package piezas;
import control.VARIABLESGLOBALES;
import visual.Segmento;
import java.awt.Color;
import java.util.Random;
import java.awt.Point;
import java.util.LinkedList;
import visual.Tablero;

public abstract class Pieza {
    
    /*
        La clase pieza, de donde heredaran todas las demas piezas
        presenta un color, la cantidad de tipos de piezas que hay
        un arreglo con los segmentos que la forma
        un arreglo estados que se debe asignar en las clases que heredan
        una localizacion en la matrix y la matrix del tablero
        en la cual está posicionado
        presenta metodos para moverse y girar en el trablero
    */
    
    public static final Random RAND = new Random();
    public static final int TIPOS = 7;
    private final Segmento[] segmentos;
    private final Color color;
    private boolean[][][] estados = null;
    private int estado = 0;
    private final Point MatrixLocation = new Point(0,0);
    private final LinkedList<Point> porLimpiar = new LinkedList<>();    
    private Segmento matrix[][];
    private boolean cambioTablero = false;
    
    public Pieza(Segmento[][] matrix,boolean[][][] estados,int size){
        this.matrix = matrix;
        this.estados = estados;
        segmentos = new Segmento[4];
        //de esta manera seleccionamos un color 
        //aleatorio y lo aplicamos a los segmentos
        int r = RAND.nextInt(255);
        int g = RAND.nextInt(255);
        int b = RAND.nextInt(255);
        color = new Color(r,g,b);
        
        for(int i = 0; i < 4; i++){
            segmentos[i] = new Segmento(color,this,size);
        }
        
    }          
    int updates = 0;
    public boolean updateState(){        
        updates++;
        /*
            esto actualiza el estado de la ficha
            el estado es basicamente la posicion 
            de giro en la que se encuentro
        
        */
        
        //recorremos la matrix estados en el estado actual        
        for(int i = 0 ; i < estados[estado].length ;i++)  {
            //luego vamos por las columas
            for(int j = 0 ; j < estados[estado][i].length; j++){
                //usando la i y j calculamos donde es en la matrix
                //usando tambien las coordenadas actuales de la ficha
                int newX = j+(int)MatrixLocation.getX();
                int newY = i+(int)MatrixLocation.getY();      
                
                if(!valid(newX,newY)){
                    porLimpiar.clear();
                     //System.out.println("FUERA DE RANGO");
                    return false;                    
                }
                                
                //si esta activado significa que en ese estado ahi va un segmento
                if(estados[estado][i][j] == true){
                    //si es invalido no lo puedo poner en ese estado
                    //o si hay un segmento que no es parte de mi pieza
                    if(matrix[newY][newX] != null && !isMe(matrix[newY][newX])){
                        porLimpiar.clear();
                        //System.out.println("OBJETO EN MEDIO");
                        return false;                    
                    }
                    porLimpiar.add(new Point(newX,newY));
                }
                
            }
       
        
        }
       
        
        //limpiar
        if(!cambioTablero)        
        for (Segmento segmento : segmentos) {
            Point p = segmento.getMatrixLocation();            
            int x = p.x;
            int y = p.y;
            if(!valid(x,y))continue;
            
            matrix[y][x] = null;            
        }
        cambioTablero = false;
        //actualizar
        int k = 0;
        while(!porLimpiar.isEmpty()){
            Point p = porLimpiar.poll();            
            Segmento s = segmentos[k++];
            int x = p.x;
            int y = p.y;
            matrix[y][x] = s;            
            s.setMatrixLocation(x, y); 
        }
                        
        repaint();        
        
        return true;
    }
    
    
    public void rotateRight(){
        //amentar el estado
        VARIABLESGLOBALES.GIRANDO = true;
        estado = (estados.length + (estado + 1) )%estados.length;
        if(!updateState())estado = (estados.length + (estado - 1) )%estados.length;               
        VARIABLESGLOBALES.GIRANDO = false;
    }        
    
    public void rotateLeft(){
        //disminuir el estado
        VARIABLESGLOBALES.GIRANDO = true;
        estado = (estados.length + (estado - 1) )%estados.length;
        if(!updateState())estado = (estados.length + (estado + 1) )%estados.length;
        VARIABLESGLOBALES.GIRANDO = false;
    }
    
    public Segmento[] getSegmentos(){
        return segmentos;
    }
    
    public boolean[][][] getEstados(){
        return estados;
    }
    
    public boolean[][] getEstado(int estado){
        if(estados == null)return null;
        if(estado < 0 || estado > estados.length)
            return null;
        
        return estados[estado];
    }
    
    public int getEstadoIndex(){
        return estado;
    }
    
    //los metodo move mueven una de las coordenadas
    //verifican que se pueda, y si no se mueve hacia atras
    public boolean moveDown(){
        MatrixLocation.y++;
        if(!updateState()){            
            MatrixLocation.y--;
            return false;
        }        
        repaint();
        return true;
    }
    
    public void moveRight(){
        MatrixLocation.x++;
        if(!updateState())MatrixLocation.x--;
        else repaint();
    }
    
    public void moveLeft(){
        MatrixLocation.x--;
        if(!updateState())MatrixLocation.x++;                
        else repaint();
    }
        
    public Point getMatrixLocation() {
        return MatrixLocation;
    }
 
    public void setMatrixLocation(int x,int y){
        MatrixLocation.x = x;
        MatrixLocation.y = y;        
    }
    
    public boolean valid(int x,int y){
        return !(x<0 || y<0 || y>=matrix.length || x>=matrix[y].length);
    }

    public void setMatrix(Segmento[][] matrix) {
        this.matrix = matrix;        
    }
        
    public void setBlockSize(int size){
        //System.out.println("PONIENDO :" + size);
        for(Segmento s:segmentos){
            s.setSize(size,size);
        }
    }

    public void moverAlTablero(Tablero tablero){
        //actualizar el tamanno de los segmentos
        //por el tamanno del tablero
        setBlockSize(tablero.getBlockSize());
        setMatrix(tablero.getMatrix());
        
        this.cambioTablero = true;
        
    }
    
    public boolean isMe(Segmento s){
        return s.getPieza() == this;
    }
    
    public void repaint(){
        //repintar todos los segmentos
        Segmento.actualizarUI(segmentos);
        
    }
        
}
