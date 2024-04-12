package game.battleship;
import java.awt.Image;
import java.net.URL;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;

public abstract class Entity extends JLayeredPane{
    public int x;
    public int y;
    boolean discovered=false;
    JLabel hide,Sea,icon;
    JButton hider;
    URL sea = getClass().getResource("/images/Sea.png");
    int w,h;
   public Entity(int x,int y,String image,int w,int h){
	   this.w=w;
	   this.h=h;
    	setSize(w,h);
    	System.err.println(getSize());
        setPos(x,y);
        setIcon(getClass().getResource(image));
        hide();      
        
    }
    
    @Override
    public void hide(){
        hider = new JButton();
        hider.setSize(this.getSize());
        hider.addActionListener((ActionEvent)->{
        	if(App.player.bombs[App.seleccion]==0)return;        	
    		Bomb b=null;
    		switch(App.app.seleccion) {
    			case 0:b = new Bomb(x,y,w,h); break;
    			case 1:b = new Torpedo(x,y,w,h); break;
    			case 2:b = new Misil(x,y,w,h); break;
    			case 3:b = new Hecaton(x,y,w,h); break;                			
    		}
    		if(this instanceof Torpedo) {
    	        Date date = new Date();
    	        try {
    	        	App.registro.write(App.player.name+","+"Activasion de Torpedo  en la casilla "+x+"-"+y+","+date.getHours()+":"+date.getMinutes()+"\n");
    	        }
    	        catch(Exception e) {
    	        	
    	        }
    		}
    		if(this instanceof Misil) {
    	        Date date = new Date();
    	        try {
    	        	App.registro.write(App.player.name+","+"Activasion de Misil  en la casilla "+x+"-"+y+","+date.getHours()+":"+date.getMinutes()+"\n");
    	        }
    	        catch(Exception e) {
    	        	
    	        }
    		}
    		if(this instanceof Sea) {
    	        Date date = new Date();
    	        try {
    	        	App.registro.write(App.player.name+","+"Colocacion de "+b.getClass().getSimpleName()+" en la casilla "+x+"-"+y+","+date.getHours()+":"+date.getMinutes()+"\n");
    	        }
    	        catch(Exception e) {
    	        	
    	        }
    		}
    		if(this instanceof Hecaton) {
    	        Date date = new Date();
    	        try {
    	        	App.registro.write(App.player.name+","+"Activasion de Hecaton  en la casilla "+x+"-"+y+","+date.getHours()+":"+date.getMinutes()+"\n");
    	        }
    	        catch(Exception e) {
    	        	
    	        }
    		}
    		App.board.board[y][x].discover();
    		if(App.board.board[y][x] instanceof Bomb) {
    			JOptionPane.showMessageDialog(null, "Suerte has explotado una mina");
    		}
    		else if(App.board.board[y][x] instanceof Sea) {
    			JOptionPane.showMessageDialog(null, "Ups fallaste");
    		}
    		if(App.board.board[y][x] instanceof Sea||b instanceof Hecaton) {
    			b.discover();    			    			
    		}
    		remove(hider);
    		repaint();    		
    		
    		
    		App.player.bombs[App.seleccion]--;
    		if(App.visible instanceof GamePanel)
    		((GamePanel)App.visible).actualizarTextos();
    	
        	
        	
        });
        hider.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/hidden.png")).getImage().
                getScaledInstance(App.board.getSizeX(), App.board.getSizeY(), Image.SCALE_SMOOTH)));
        setLayer(hider,2);
        add(hider);
    }
    
    @Override
    public void show(){
        for(int i=0;i<getComponentCount();i++)
        	if(getComponents()[i] instanceof JButton)remove(i);
        repaint();
        hide = new JLabel();
        hide.setSize(this.getSize());
        hide.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/Explosion.png")).getImage().
                getScaledInstance(App.board.getSizeX(), App.board.getSizeY(), Image.SCALE_SMOOTH)));
        setLayer(hide,2);
        add(hide);
        (new Thread(){
          @Override
          public void run(){
              long time = System.currentTimeMillis();
              long finish = 1000+time;
              while(time<finish){
                  time = System.currentTimeMillis();
                  try{
                      sleep(10);
                      if(hide.getWidth()>0||hide.getWidth()>0) {
                    	  hide.setSize(hide.getWidth()-((int)(getWidth()*0.1)),hide.getHeight()-((int)(getHeight()*0.1)));
                    	  hide.setIcon(new ImageIcon(new ImageIcon(getClass().getResource("/images/explosion.png")).getImage().
                                  getScaledInstance(hide.getWidth(), hide.getHeight(), Image.SCALE_SMOOTH)));
                    	  hide.setLocation((getWidth()/2)-(hide.getWidth()/2),(getHeight()/2)-(hide.getHeight()/2));
                      }
                  }
                  catch(Exception e){
                      
                  }
              }
              remove(hide);
              repaint();
          }  
        }).start();
    }
    
    private void setIcon(URL image){
       JLabel icon = new JLabel();
       icon.setSize(getSize());
       icon.setIcon(new ImageIcon(new ImageIcon(image).getImage().
               getScaledInstance(App.board.getSizeX(), App.board.getSizeY(), Image.SCALE_SMOOTH)));
       setLayer(icon,1);
       add(icon);
       JLabel Sea = new JLabel();
       Sea.setSize(getSize());
       Sea.setIcon(new ImageIcon(new ImageIcon(sea).getImage().
                getScaledInstance(App.board.getSizeX(), App.board.getSizeY(), Image.SCALE_SMOOTH)));
       setLayer(Sea,0);
       add(Sea);
    }
    

    private void setPos(int x,int y){
        this.x=x;
        this.y=y;
        this.setLocation(x*App.board.getSizeX(), y*App.board.getSizeX());
    }
    
  
    public boolean discover(){
        if(discovered)return true;
        discovered=true;     
        show();
        if(this instanceof Part)
        	App.board.oneLess();
        return action();
    }    
    
    public boolean isValid(int x,int y) {
    	if(App.board==null)return false;
    	if(x<0||y<0)return false;
    	else if(x>=App.board.board[0].length||y>=App.board.board.length)return false;
    	else return true;
    }
    
    public abstract boolean action();
    
}
