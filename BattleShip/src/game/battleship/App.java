package game.battleship;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class App extends JFrame{
    static Board board;
    static Player player;
    static HashMap<String,String[]> boards = new HashMap<>();
    static MainPanel menu;
    static LevelPanel level;
    static MapPanel mapaPanel;
    static PuntajePanel puntajePanel;
    static CollectionPanel collectionPanel;
    static JPanel visible;
    static App app;
    static int seleccion;
    static FileWriter registro; 
   
    public App(){
    	try {
    		registro = new FileWriter("acciones.avn",true);
    	}
    	catch(Exception e) {
    		
    	}
    	app=this;
    	Utiles.addWindowsMove(this);
	    setUndecorated(true);
	    setSize(500,500);
	    menu = new MainPanel(getWidth(),getHeight(),this);
	    visible = menu;
	    level = new LevelPanel(getWidth(),getHeight(),this);
	    mapaPanel = new MapPanel(getWidth(),getHeight(),this);
	    puntajePanel = new PuntajePanel(getWidth(),getHeight(),this);
	    collectionPanel = new CollectionPanel(getWidth(),getHeight(),this);
	    level.setVisible(false);
	    mapaPanel.setVisible(false);
	    switchPanel(menu);
	    setLocationRelativeTo(null);
	    setVisible(true);
	    setDefaultCloseOperation(EXIT_ON_CLOSE);
	    
    }
    
    public void iniciarPartida() {
    	if(boards.isEmpty())
    		nuevaPartida();   
    	seleccionarDificultad();
    }
    
    public void seleccionarDificultad() {
    	switchPanel(level);
    }
    
    public void nuevaPartida() {
    	if(boards.isEmpty()) {
    		if(!cargarMapas())return;
    		if(!boards.isEmpty())menu.enableIni();
    	}
    	
    	iniciarPartida();
    	
    }
    
    public boolean cargarMapas() {
    	JFileChooser fc = new JFileChooser();
		FileNameExtensionFilter filtrer = new FileNameExtensionFilter("Archivos de mapas","th");
		fc.addChoosableFileFilter(filtrer);
		fc.addActionListener((ActionEvent)->{
		System.out.println(fc.getSelectedFile().getName());
		});
		int respuesta = fc.showOpenDialog(null);
		
		if (respuesta == JFileChooser.APPROVE_OPTION) {
			
		    File archivoElegido = fc.getSelectedFile();
		    int c=0;
		    try {
		    	Scanner entry = new Scanner(archivoElegido);
		    	
		    	while(entry.hasNext()) {    		    		
		    		String id = entry.next();
		    		id = entry.next();
		    		int pi=id.lastIndexOf('<');
		    		int pf=id.indexOf('>');
		    		if(pi==-1||pf==-1)continue;
		    		
		    		id = id.substring(pi+1,pf);
		    		if(boards.keySet().contains(id)) {
		    			JOptionPane.showMessageDialog(fc, "El mapa con id "+id+" ya fue cargado");
		    			continue;
		    		}
		    		String dimension = entry.next();
		    		dimension = entry.next();
		    		System.out.println(id+"\n"+dimension);
		    		int lines = Integer.parseInt(dimension.substring(dimension.indexOf('X')+1));
		    		String map="";
		    		for(int i=0;i<lines;i++) {
		    			String s=entry.next();
		    			System.out.println(s);
		    			map+=s;        		   			
		    		}
		    		System.out.println(map);
		    		boards.put(id, new String[]{id,dimension,map});
		    		Board b = new Board(id,dimension,map,getWidth(),getHeight());
		    		for(int i=0;i<b.board.length;i++) 
		    			for(int j=0;j<b.board[0].length;j++)
		    					if(b.board[i][j]!=null)b.board[i][j].show();
		    		collectionPanel.addBoard(b);
		    		c++;
		    	}
		    	if(!boards.isEmpty())menu.enableIni();
		    	JOptionPane.showMessageDialog(fc, "Mapas cargados con exito: "+c);
		    }
		    catch(Exception e) {    		    	
		    	e.printStackTrace();
		    	JOptionPane.showMessageDialog(fc, "Error al cargar los mapas");
		    	JOptionPane.showMessageDialog(fc, "Mapas cargados con exito: "+c);
		    	if(!boards.isEmpty())menu.enableIni();
		    	if(c==0)return false;
		    }
		}
		
		else return false;
		return true;
    }
    
    public  void puntajes() {
    	if(puntajePanel.reload())
    		switchPanel(puntajePanel);
    }
    
    public  void seleccionTableros() {
    	switchPanel(collectionPanel);
    }
    
    void switchPanel(JPanel panel) {
    	if(visible==null) {
    		visible=panel;    	
    	}
    	visible.setVisible(false);
    	visible=panel;
    	visible.setVisible(true);
    	add(visible);
    }
    
    public static void savePTS(){
    	
    	try{
    		FileWriter fw = new FileWriter(new File("punteos.war"),true);    	    	
    		fw.append(player.name+" "+player.pts+"\n");
    		fw.close();
    	}
    	catch(Exception e) {
    		JOptionPane.showMessageDialog(null, "OCURRIO UN ERROR AL ACTUALIZAR EL PUNTAJE");
    	}
    }
    
    public static void main(String[] args) {
        new App();
    }
    
}
/*


*/