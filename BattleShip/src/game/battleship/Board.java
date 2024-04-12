package game.battleship;
import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Board extends JPanel{
    Entity board[][];
    int lenX;
    int lenY;
    String id;
    boolean correct=true;
    int sizeX=0,sizeY=5;    
    int toDestroy=0;
    
    public Board(String id,String dimen,String s,int width,int height){
    	super();    	
    	//App.board=this;
        setLayout(null);
        setBackground(Color.cyan);
        int p = dimen.indexOf('X');
        lenX=Integer.parseInt(dimen.substring(0,p));
        lenY=Integer.parseInt(dimen.substring(p+1));
        sizeX=width/lenX;
    	sizeY=height/lenY;
    	setSize(lenX*sizeX,lenY*sizeY);
        makeBoard(s);    
        this.id=id;
    }          
    
    public void oneLess() {
    	toDestroy--;
    	if(toDestroy==0) {
    		JOptionPane.showMessageDialog(null, "FELICIDADES GANASTE");
    		App.app.switchPanel(App.menu);
    		App.savePTS();
    	}
    }
  
    public void lose() {
    	JOptionPane.showMessageDialog(null, "HAS PERDIDO, MEJOR SURETE LA PROXIMA");
    	App.app.switchPanel(App.menu);
    	App.savePTS();
    }
    
    private boolean makeBoard(String s){
        App.board = this;
        board= new Entity[lenY][lenX];
        int y=0,x=0;
        for(int i=0;i<s.length();i++){
            Entity e = null;
            char c = s.charAt(i);                      
            if(c=='B'){
                i++;
                c = s.charAt(i);
                switch(c){
                    case '1':e = new Part(x,y,100,sizeX,sizeY); break;
                    case '2':e = new Part(x,y,40,sizeX,sizeY); break;
                    case '3':e = new Part(x,y,75,sizeX,sizeY); break;
                    default: return correct=false;
                }
                toDestroy++;
                add(e);
                e.setLocation(x*sizeX,y*sizeY);
                board[y][x]=e;
                x++;
                if(x==lenX){
                    x=0;
                    y++;
                }
            }
            else{
                switch(c){
                    case 'T':e = new Torpedo(x,y,sizeX,sizeY); break;
                    case 'I':e = new Misil(x,y,sizeX,sizeY); break;
                    case 'O':e = new Hecaton(x,y,sizeX,sizeY); break;
                    case '~':e = new Sea(x,y,sizeX,sizeY);break;
                    case ',':continue;
                    default: return correct=false;
                }
                add(e);
                e.setLocation(x*sizeX,y*sizeY);
                board[y][x]=e;
                x++;
                if(x==lenX){
                    x=0;
                    y++;
                }
            }
            
        }    
        
        return true;
    }
    
    int getSizeX(){
        return sizeX;
    }      
    
    int getSizeY(){
        return sizeY;
    }
    
    public int getDifficulty() {
    	if(lenX*lenY<=36)return 0;
    	else if(lenX*lenY<=64)return 1;
    	else return 2;
    }
        
}
