package visual;

import piezas.*;
import java.awt.Color;
import javax.swing.JPanel;

public class Generador extends JPanel{
    
    /*
        el generador contiene un tablero 
        en el que se generar una pieza aleatoria
        y se dejara ahí hasta que se genere otra
    */
    
    private Pieza piezaMostando;
    private Tablero tablero;
    
    public Generador() {
        tablero = new Tablero(6,6);
        setLayout(null);
        add(tablero);
        setOpaque(true);
        setSize(100,100);
        setFocusable(false);
        
        setBackground(Color.black);
    }
        
    public void nextPieza(){
        generate();
        tablero.removeAll();                
        piezaMostando.setMatrixLocation(1, 1);        
        piezaMostando.updateState();                
        tablero.add(piezaMostando);
        repaint();        
    }
    
    public Pieza generate(){
        /*
            el proceso de generar es generar un numero
            y cada numero corresponde con un tipo de pieza
            de ahi se le da el tamanno adecuado para mostrarlo
            en el tablero del generador
        */
        int tipo = Pieza.RAND.nextInt(Pieza.TIPOS);
        Pieza p = null;
        
        int size = 0;
        int filas = 0, columnas = 0;
        switch(tipo){
            case 0: 
                filas = columnas = 6;
                tablero.setFilas(filas);
                tablero.setColumnas(columnas);                
                tablero.setBlockSize(getWidth()/filas);
                tablero.resize();
                size = tablero.getBlockSize();
                p = new PiezaI(tablero.getMatrix(), size);
            break;
            case 1:
                filas = columnas = 5;
                tablero.setFilas(filas);
                tablero.setColumnas(columnas);
                tablero.setBlockSize(getWidth()/filas);
                tablero.resize();
                size = tablero.getBlockSize();
                p = new PiezaL(tablero.getMatrix(), size);
            break;
            case 2: 
                filas = columnas = 4;
                tablero.setFilas(filas);
                tablero.setColumnas(columnas);
                tablero.setBlockSize(getWidth()/filas);
                tablero.resize();
                size = tablero.getBlockSize();
                p = new PiezaO(tablero.getMatrix(), size);
            break;
            case 3: 
                filas = columnas = 5;
                tablero.setFilas(filas);
                tablero.setBlockSize(getWidth()/filas);
                tablero.setColumnas(columnas);
                tablero.resize();
                size = tablero.getBlockSize();
                p = new PiezaRL(tablero.getMatrix(), size);
            break;
            case 4: 
                filas = columnas = 5;
                tablero.setFilas(filas);
                tablero.setColumnas(columnas);
                tablero.setBlockSize(getWidth()/filas);
                tablero.resize();
                
                size = tablero.getBlockSize();
                p = new PiezaRZ(tablero.getMatrix(), size);
            break;
            case 5: 
                filas = columnas = 5;
                tablero.setFilas(filas);
                tablero.setColumnas(columnas);
                tablero.setBlockSize(getWidth()/filas);
                tablero.resize();
                size = tablero.getBlockSize();
                p = new PiezaT(tablero.getMatrix(), size);
            break;
            case 6: 
                filas = columnas = 5;
                tablero.setFilas(filas);
                tablero.setColumnas(columnas);
                tablero.setBlockSize(getWidth()/filas);
                tablero.resize();
                size = tablero.getBlockSize();
                p = new PiezaZ(tablero.getMatrix(), size);
            break;                           
        }
        
        //System.out.println(size);
        tablero.setSize(getSize());
        //dar tamanno al tablero y posicionarlo en el medio
        tablero.setLocation((getWidth()/2)-(tablero.getWidth()/2),(getHeight()/2)-(tablero.getHeight()/2));
        
        this.piezaMostando = p; 
        return p;
    }

    public Pieza getPiezaMostando() {
        return piezaMostando;
    }

    public Tablero getTablero() {
        return tablero;
    }
    
    
}
