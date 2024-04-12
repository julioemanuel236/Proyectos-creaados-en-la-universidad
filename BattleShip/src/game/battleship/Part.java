package game.battleship;
import java.util.Date;
import javax.swing.JOptionPane;
public class Part extends Entity{
 
    private int value;
    int tipo;
    public Part(int x,int y,int value,int w,int h){
        super(x,y,"/images/Part.png",w,h);
        this.value=value;
        switch(value) {
        	case 100:tipo=1;break;
        	case 40:tipo=2;break;
        	case 25:tipo=3;break;
        }
    }

    @Override
    public boolean action() {
        if( App.player!=null)App.player.pts+=this.value;
        else return false;
        JOptionPane.showMessageDialog(null, "Excelente has golpeado un barco, sigue asi");
        Date date = new Date();
        try {
        	App.registro.write(App.player.name+","+"Derribo de barco #"+tipo+" en la casilla "+x+"-"+y+","+date.getHours()+":"+date.getMinutes()+"\n");
        }
        catch(Exception e) {
        	
        }
        return true;
    }
    
}
