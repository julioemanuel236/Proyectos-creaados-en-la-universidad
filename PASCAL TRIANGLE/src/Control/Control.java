package Control;
import gui.*;
import java.util.ArrayList;
import clases.*;
import java.awt.Color;
import java.awt.Dimension;
import java.math.BigDecimal;
import java.util.Random;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.util.LinkedList;
import javax.swing.JLayeredPane;

public class Control {
    
    private VistaPrincipal frame;
    private TrianguloPascal triangulo;
    private String[] textos={"Podemos apreciar al construir el triangulo de pascal\ncomo cada segmento tiene un valor igual\n a la suma de los de elementos de arriba",
                             "Al pintar los valores pares de un color y los impares\nde otro podemos ver un particular diseño",
                             "Aqui podemos apreciar como el triangulo de pascal es\nsimetrico, ya que si pintamos los valores iguales de una misma fila de un mismo color\n notaremos un diseño simetrico",
                             "A continuacion cada color representa una fila, todas las filas contienen una potencia de 2 como suma de sus elementos",
                             "Si tomamos los elementos con la siguiente distrubucion la suma de cada color \ncorresponde a un numero de fibonacci en sucecion",
                             "Las diagonales resaltadas presentan solo 1,\nnumeros naturales consecutivos,\nnumeros triangulares \ny numeros tetraedircos"};
    private boolean simulando=false;
    private LinkedList<Bolita> bolitas = new LinkedList<>();
    private SegmentoSimulacion resultados[];
    private int bolitasPermitidasALaVez = 100;
    private int bolitasTotales=0;
    
    public Control(gui.VistaPrincipal frame){
        this.frame=frame;        
    }
    
    public void generarTriangulo(int filas,JTextArea txt){
        triangulo = new TrianguloPascal(filas);
        simulando=false;
        generarVisual(txt);
    }
    
    private void generarVisual(JTextArea txt){           
        JLayeredPane panel = frame.getVisualPanel();                               
        panel.removeAll();
        panel.repaint();
        Dimension panelD = new Dimension(panel.getWidth(),panel.getHeight());
        Dimension size = new Dimension((panel.getWidth())/triangulo.getAncho(),panel.getHeight()/triangulo.getAlto());        
        //int x = (int)panelD.getWidth()-((int)size.getWidth()*triangulo.getAncho());
        //int y =(int)panelD.getHeight()-((int)size.getHeight()*triangulo.getAlto());
        (new Thread(){
            public void run(){
            	int n =triangulo.getLineas().size();
                for(int i=0;i<n;i++){         
                	Linea linea = triangulo.getLineas().get(i);
                	int m = linea.getSegmentos().size();
                    for(int j = 0; j < m;j++){
                    	Segmento segmento = linea.getSegmentos().get(j);
                        //System.out.println(segmento.getFila()+" "+segmento.getIndex()+" "+segmento.getValor());
                        SegmentoVisual visual = new SegmentoVisual(segmento);
                        segmento.setVisual(visual);            
                        int y = (int)(size.getHeight()*i);
                        int desplazamiento = ((panel.getWidth()/2)-(int)((size.getWidth()*m)/2));
                        int x = desplazamiento + (int)(size.getWidth()*j);
                        segmento.pintar(size,x,y);
                        //segmento.pintar(size,panelD,x/2,y/2);                                                
                        panel.setLayer(visual,1);
                        panel.add(visual);
                    }
                }
                 panel.repaint();
            }
        }).start();
        txt.setText(textos[0]);
    }
    
    public void paridad(JTextArea txt){
        (new Thread(){
            public void run(){ 
                
                Random rand = new Random();
                Color c1 = new Color(Math.max(100,rand.nextInt(255)),Math.max(rand.nextInt(255),100),Math.max(rand.nextInt(255),100));
                Color c2 =new Color(Math.max(100,rand.nextInt(255)),Math.max(rand.nextInt(255),100),Math.max(rand.nextInt(255),100));
                Color colores[] = {c1,c2};
                for(Linea linea:triangulo.getLineas()){                        
                    for(Segmento segmento:linea.getSegmentos()){                                        
                        segmento.paridad(colores);                                
                    }
                }
            }
        }).start();
        txt.setText(textos[1]);
    }
    
    public void simetria(JTextArea txt){
        (new Thread(){
            public void run(){
                for(Linea linea:triangulo.getLineas()){                        
                    for(Segmento segmento:linea.getSegmentos()){
                        int v = segmento.getValor();
                        if(v<0)v=-v;
                        Color color = new Color(v%255,v%255,v%255);
                        segmento.simetria(color);                                
                    }
                }
            }
        }).start();
        txt.setText(textos[2]);
    }

    public void sumaFilas(JTextArea txt){
        int suma[] = new int[triangulo.getAncho()];
        for(Linea lineas:triangulo.getLineas()){
            Random rand = new Random();
            Color color = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
            for(Segmento segmento:lineas.getSegmentos()){
                suma[segmento.getFila()]+=segmento.getValor();
                segmento.color(color);
            }
        }
        txt.setText(textos[3]);
        for(int i=0;i<suma.length;i++)
            txt.setText(txt.getText()+"\nFila "+i+": "+suma[i]);
    }
    
    public void fibbonaci(JTextArea txt){
        
        ArrayList<Linea> lineas = triangulo.getLineas();
        Random rand = new Random();
        Color color; 
        int n = (int)lineas.size()/2;
        int fibo[] = new int[triangulo.getAncho()];
        boolean colorear=true;
        int c=0;
        for(int i=0;i<lineas.size();i++){
            color = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));                                             
            if(c-1==lineas.size())colorear=false;
            for(int j=i-1,i2=i;j>=0&&i2<lineas.size();j--,i2++){
                Segmento segmento = lineas.get(i2).getSegmentos().get(j);
                if(colorear)fibo[j+i2]+=segmento.getValor();
                if(colorear)segmento.color(color);
                else segmento.color(null);
            }c++;
            if(c-1==lineas.size())colorear=false;
            color = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
            for(int j=i,i2=i;j>=0&&i2<lineas.size();j--,i2++){
                Segmento segmento = lineas.get(i2).getSegmentos().get(j);
                if(colorear)fibo[j+i2]+=segmento.getValor();
                if(colorear)segmento.color(color);
                else segmento.color(null);
            }c++;                                               
        }
        /*for(int i=0;i<fibo.length;i++){
            if(fibo[i]>0)System.out.println(fibo[i]+" ");
        }*/
        txt.setText(textos[4]);
        for(int i=0;i<fibo.length;i++)
            txt.setText(txt.getText()+"\nFila "+i+": "+fibo[i]);
    }
                 
    public void diagonales(JTextArea txt){
        int n = Math.min(triangulo.getAlto(),4);
        
        Random rand = new Random();
        Color color;
        boolean colorear=true;
        for(int i=0;i<triangulo.getAlto();i++){
            if(i==n)colorear=false;
            color = new Color(rand.nextInt(255),rand.nextInt(255),rand.nextInt(255));
            for(int j=i;j<triangulo.getAlto();j++){
                Segmento segmento = triangulo.getLineas().get(j).getSegmentos().get(i);
                if(colorear)segmento.color(color);
                else segmento.color(null);
            }
        }
        txt.setText(textos[5]);
    }
    
    public void mover(final int x,final int y,int tiempo,Bolita component){        
         //System.out.println("X: "+x+" "+"Y: "+y);
        (new Thread(){
            public void run(){
                if(component.isMoviendo())return;
                long inicio = System.currentTimeMillis();            
                long actual = 0;

                int xi = component.getX();
                int yi = component.getY();
                int xr=x-xi;
                int yr=y-yi;
                component.setMoviendo(true);
                while(actual<=tiempo) {
                    float avance = (float)actual/(float)tiempo;
                    component.setLocation(xi+((int)(xr*avance)),yi+((int)(yr*avance)));
                    component.repaint();

                    try{
                        sleep(10);                    
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                    actual = System.currentTimeMillis()-inicio;                            
                }                 
                component.setLocation(x,y);
                component.aumentarProfindidad();
                if(component.getProfundidad()==triangulo.getAlto()){
                    component.desaparecer();
                    //System.out.println("INDEX: "+component.getIndex());
                    if(component.getIndex()<resultados.length){
                        resultados[component.getIndex()].incrementar();
                        bolitasTotales++;                    
                        for(int i=0;i<resultados.length;i++){
                            resultados[i].paint(Math.max(bolitasTotales,1));                            
                        }
                        frame.getSimluacionVisualPanel().repaint();
                    }                    
                }
                component.repaint();
                component.setMoviendo(false);
            }
        }).start();
    }
 
     public void simular(JTextArea txt,int tiempoAparicion,int recorrido){
         txt.setText("Simulacion de Quincunce");
         JPanel panel = frame.getSimluacionVisualPanel();
        if(!simulando){
           panel.removeAll();           
            int n = triangulo.getAncho();
            System.out.println(n + "SEGMENTOS");
            int ancho = panel.getWidth()/n;
            int alto = panel.getHeight();
            resultados = new SegmentoSimulacion[n];
            for(int i=0;i<n;i++){
                SegmentoSimulacion  ss = new SegmentoSimulacion(alto);
                ss.setSize(ancho,alto);
                ss.setLocation((ancho*i)-i,0);
                resultados[i] = ss;                
                panel.add(ss);
                bolitasTotales=0;
            }
            panel.repaint();
        }
        
        (new Thread(){
            public void run(){
            	
                long next = System.currentTimeMillis()+tiempoAparicion;
                Random rand = new Random();
                if(simulando){
                    simulando=false;
                    while(!bolitas.isEmpty()){
                        bolitas.poll().desaparecer();
                    }
                    return;
                }                
                simulando=true;
                
                while(simulando){
                    if(System.currentTimeMillis()>next){
                    	if(bolitas.size()<bolitasPermitidasALaVez) {                    		
	                        SegmentoVisual sv = triangulo.getLineas().get(0).getSegmentos().get(0).getVisual();
	                        int diametro = Math.min(sv.getWidth(),sv.getHeight())*3/4;
	                        Bolita b = new Bolita(diametro);                            
	                        b.setLocation(sv.getX()+(sv.getWidth()/2)-b.getRadio(),sv.getY()+(sv.getHeight()/2)-b.getRadio());
	                        //System.out.println(b.getLocation());
	                        frame.getVisualPanel().setLayer(b,2);
	                        frame.getVisualPanel().add(b);
	                        
	                    	bolitas.add(b);
	                        next = System.currentTimeMillis()+tiempoAparicion;
                    	}
                    }
                    int n = bolitas.size();
                    for(int k=0;k<n;k++) {
                    	                    
	                    Bolita b = bolitas.poll();
	                    //System.out.println("MIRANDO "+b);
	                    if(b==null)continue;                    
	                    boolean continuar = true;
	                    
	                    if(!b.isMoviendo()) {                    
	                    	//System.out.println("VOY A MOVER LA BOLITA");                    	
	                    	
	                        if(b.getProfundidad()==triangulo.getAlto()-1){
	                        	//System.out.println("LLEGUE AL FINAL");
	                        	continuar = false;
	                            b.desaparecer();
	                            //System.out.println("INDEX: "+component.getIndex());
	                            if(b.getIndex()<resultados.length){
	                                resultados[b.getIndex()].incrementar();
	                                bolitasTotales++;                    
	                                int mayor = 0;
	                                for(int i=0;i<resultados.length;i++){
	                                    //resultados[i].paint(Math.max(bolitasTotales,1));
	                                    mayor = (mayor<resultados[i].getMio()? resultados[i].getMio(): mayor);
	                                }
	                                for(int i=0;i<resultados.length;i++){
	                                    resultados[i].paint(Math.max(bolitasTotales,1));
	                                    
	                                }
	                                frame.getSimluacionVisualPanel().repaint();
	                            }                           
	                            
	                        }
	                        else {
	                        	//System.out.println("CALCUANDO SIGUIENTE POSICION");
	                        	boolean dir = rand.nextBoolean();
	                            
	                        	b.setIndex(b.getIndex()+(dir?1:0));
	                        	b.aumentarProfindidad();
	                        	
	                            SegmentoVisual sv = triangulo.getLineas().get(b.getProfundidad()).getSegmentos().get(b.getIndex()).getVisual();
	                            //System.out.println("VOY A : "+b.getProfundidad()+"/"+b.getIndex());
	                            
	                            int x = (sv.getX()+(sv.getWidth()/2)-(b.getWidth()/2));
	                            int y = (sv.getY()+(sv.getHeight()/2)-(b.getHeight()/2));
	                            
	                            b.setMoviendo(true);
	                            double velocidad = 0.5d + Math.random();
	                            
	                            GestorMovimiento.agregarMovimiento(b, x, y, (int)((recorrido/triangulo.getAlto())*velocidad));
	                            
	                        }
	                                                
	                        //mover(x, y, recorrido/(triangulo.getAlto()+1), b);
	                        
	                        //b.repaint();
	                        //b.setMoviendo(false);                        
	                    }
	                    if(continuar) 
	                    	bolitas.add(b);
	                    else b.desaparecer();
	                    	
	                    
                    }
                     
                    
                    GestorMovimiento.run();
                    try{                        
                        frame.getVisualPanel().repaint();
                        sleep(1000/60);
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
     }
             
     
     
}
