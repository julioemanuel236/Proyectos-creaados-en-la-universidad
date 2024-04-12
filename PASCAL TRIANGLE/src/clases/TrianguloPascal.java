
package clases;
import java.util.ArrayList;

public class TrianguloPascal {
    private ArrayList<Linea> lineas;    
    private boolean visible=false;
    
    public TrianguloPascal(){
        lineas = new ArrayList<>();       
    }
    
    public TrianguloPascal(int filas){        
        lineas = new ArrayList<>();
        for(int i=0;i<filas;i++)
            this.addFila(i);
        filas = lineas.size();
        this.ver();
    }

    
    public void addFila(int fila){
        switch (fila) {
            case 0:
                lineas.add(new Linea(0));
                break;
            case 1:
                lineas.add(new Linea(1));
                break;
            default:
                lineas.add(new Linea(lineas.get(lineas.size()-1)));
                break;
        }
    }        
    
    public void addFila(){
        this.addFila(lineas.size());
    }
    
    public void mostrar() {
    	for(Linea linea:lineas){
            for(Segmento segmento:linea.getSegmentos()){
                System.out.print(segmento.getValor()+" ");
            }
            System.out.println();
        }
    }
    
    public void ver(){
        for(Linea linea:lineas){
            for(Segmento segmento:linea.getSegmentos()){
                System.out.println(segmento.getFila()+" "+segmento.getIndex());
            }
            System.out.println();
        }
    }
    
    public Linea getLinea(int index){
          return lineas.get(index);
      }
    
    public int getAncho(){
        return lineas.get(lineas.size()-1).getSegmentos().size();
    }
    
    public int getAlto(){
        return lineas.size();
    }
  
    public void setVisible(boolean visible){
        this.visible=visible;
    }   
    
    public boolean isVisible(){
        return this.visible;
    }
        
    public int getFilas(){
        return  lineas.size();
    }
    
    public ArrayList<Linea> getLineas(){
        return lineas;
    }
}
