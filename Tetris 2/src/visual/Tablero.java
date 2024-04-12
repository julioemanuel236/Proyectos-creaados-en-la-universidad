package visual;
import java.awt.Color;
import javax.swing.JPanel;
import piezas.Pieza;
import java.util.LinkedList;

public class Tablero extends JPanel{
    /*
        la clase tablero es la que se encarga de la mayoria de las cosas
        en esta estan tambien todos los datos de la partida y del puntaje
        obtenido en esta
    */
    
    private Segmento[][] matrix;
    private int filas;
    private int columnas;
    private int blockSize = 20;
    //esta lista se usa para tener las lineas que se deben vaciar
    //pq fueron completadas
    private final LinkedList<Integer> limpiar = new LinkedList<>();
    private int lineasCompletadas = 0;
    private int puntaje = 0;
    private int nivel = 1;
    private int tiempoEspera = 1000;
    private int lineasNivel = 0;
    private int lineasPasarNivel = 2;

    
    private void initVariables(){
        lineasCompletadas = 0;
        puntaje = 0;
        nivel = 1;
        tiempoEspera = 1000;
        lineasNivel = 0;
        lineasPasarNivel = 2;
    }
    public int getFilas() {
        return filas;
    }

    public int getColumnas() {
        return columnas;
    }
    
    public Tablero(int filas,int columnas){
        this.filas = filas;
        this.columnas = columnas;
        matrix = new Segmento[filas][columnas];
        setLayout(null);
        setBackground(Color.darkGray);
        setFocusable(false);
        resize();
    }
    
    public void resize(){        
        int width = blockSize*columnas;
        int height = blockSize*filas;        
        
        setSize(width,height);
        matrix = new Segmento[filas][columnas];
        //repaint();
    }           
           
    public void add(Pieza p){
        //p.setMatrixLocation(0,0);
        for(Segmento s: p.getSegmentos())
            add(s);
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public void setColumnas(int columnas) {
        this.columnas = columnas;
    }

    public void setBlockSize(int blockSize) {
        this.blockSize = blockSize;
    }

    public Segmento[][] getMatrix() {
        return this.matrix;
    }

    public int getBlockSize() {
        return blockSize;
    }
    
    public void clear(){
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[i].length;j++){
                
                matrix[i][j] = null;
            }
    }
    
    public boolean lineasCompletadas(){
        /*
            este proceso revisa todas las lineas
            las que que no tengan ningun null
            es porque estan completas
            esas las agrega a la lista limpiar
        */
        int cont = 0;
        
        boolean alguna = false;                  
        alguna = false;
        
        for(int i = matrix.length-1;i>=0;i--){
            boolean ok = true;
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j] == null){
                    ok = false;
                    break;
                }
            }
            if(ok)limpiar.add(i);
            if(ok)alguna = true;
        }    

        /*
            luego vacia esas filas
        */
        if(!limpiar.isEmpty())alguna = true;
        int n = limpiar.size();
        for(int i=0;i<n;i++){
            int fila = limpiar.poll();
            limpiar.add(fila);
           // System.out.println("FILA COMPLETADA "+fila);
            limpiarFila(fila);
            cont++;
        }
        
        //y una vez hecho eso actualiza los segmentos
        //que hay que bajar
        
        actualizarRemanentes();                
              
        lineasCompletadas += cont;
        lineasNivel += cont;
        puntaje += (cont*nivel);
        
        //y se pasa de nivel en caso de que ya se cumplan
        //los requisitos
        
        pasarNivel();

        return alguna;        
    }
    
    public void pasarNivel(){
        if(lineasNivel >= lineasPasarNivel){
            lineasNivel-=lineasPasarNivel;
            nivel++;
            disminuirTiempoEspera();
            siguienteNivel();
            
        }
        else return;
    }
    
    public void disminuirTiempoEspera(){
        tiempoEspera*=0.7;
    }
    
    public void siguienteNivel(){
        boolean ok = false;
        while(!ok){
            lineasPasarNivel++;
            ok = true;
            int n = (int)Math.sqrt(lineasPasarNivel);
            
            for(int i=2;i<=n;i++)
                if(lineasPasarNivel%i == 0){
                    ok = false;
                    break;
                }
        }
        
    }
    
    public void actualizarRemanentes(){
        if(limpiar.isEmpty()){
            //System.out.println("NO HAY NADA QUE ACTUALIZAR");
            return;
        }
        boolean ok;
        int fila = -1;
        int next;
        int cont = 1;
        /*
            esta funcion recorre la matrix
            desde abajo hacia arriba
            desde la ultimam linea limpiada 
            hasta la siguiente
            y en cada tramo desplaza hacia abajo esos segmentos
            la cantidad de lineas que ya haya desplazado
            anteriormente + 1
        */
        if(!limpiar.isEmpty())fila = limpiar.poll()-1;
        Segmento[] segmentosActualizar = new Segmento[filas*columnas];
        int n = 0;
        do{            
            if(!limpiar.isEmpty())
                next = limpiar.poll();
            else next = -1;
            for(;fila>next;fila--){
                for(int i=0;i<matrix[fila].length;i++){
                    if(matrix[fila][i] != null){
                        matrix[fila][i].setMatrixLocation(i, fila+cont);
                        segmentosActualizar[n++] = matrix[fila][i];
                    } 
                    matrix[fila+cont][i] = matrix[fila][i];
                    
                    matrix[fila][i] = null;                    
                }
            }
            fila = next - 1;
            cont++;
        }while(fila>=0);
 
        Segmento.actualizarUI(segmentosActualizar,n);
    }
    
    public void limpiarFila(int fila){
        
        for(int j = 0 ; j< matrix[fila].length ;j++){
            matrix[fila][j].setVisible(false);
            matrix[fila][j].repaint();
            
            matrix[fila][j] = null;
        }
        
    }
    
    public void reset(){
        clear();
        initVariables();
        removeAll();        
    }

    public int getLineasCompletadas() {
        return lineasCompletadas;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getNivel() {
        return nivel;
    }

    public int getTiempoEspera() {
        return tiempoEspera;
    }

    public int getLineasNivel() {
        return lineasNivel;
    }

    public int getLineasPasarNivel() {
        return lineasPasarNivel;
    }
    
    
    public void printMatrix(){
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                if(matrix[i][j] == null)System.out.print("-");
                else System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
    
}
