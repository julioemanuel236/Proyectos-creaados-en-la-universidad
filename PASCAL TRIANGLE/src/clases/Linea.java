package clases;
import java.util.ArrayList;

public class Linea {
    
    private ArrayList<Segmento> segmentos;
    private int suma;
    private int fila;
    
    public Linea(){
        segmentos = new ArrayList<>();
        suma=0;
    }
    
    public Linea(int index){
        this.fila=index;
        segmentos = new ArrayList<>();
        suma=0;
        if(index==0)segmentos.add(new Segmento(index,0,1));
        if(index==1){
            segmentos.add(new Segmento(index,0,1));
            segmentos.add(new Segmento(index,1,1));
        }
    }
    
    public Linea(Linea anterior){
        this.fila=anterior.getFila()+1;
        segmentos = new ArrayList<>();
        suma=0;
        segmentos.add(new Segmento(fila,0,1));
        int cantidad=1;
        for(;cantidad<anterior.getSize();cantidad++)
            try{
                segmentos.add(anterior.nuevo(cantidad));
            }
            catch(Exception e){
                e.printStackTrace();
            }
        segmentos.add(new Segmento(fila,cantidad,1));
    }
    
    public void add(Segmento seg){
        this.segmentos.add(seg);
        this.suma+=seg.getValor();
        
    }
    
    public void add(int index,int valor){
        this.segmentos.add(new Segmento(fila,index,valor));
        this.suma+=valor;
    }
    
    public int getSize(){
        return segmentos.size();
    }
    
    public int getFila(){
        return this.fila;
    }
    
    public Segmento nuevo(int index)throws Exception{
        if(index<0||index>getSize())throw new Exception();
        return new Segmento(fila+1,index,segmentos.get(index-1).getValor()+segmentos.get(index).getValor());
    }
    
    public ArrayList<Segmento> getSegmentos(){
        return segmentos;        
    }

}
