package clases;

import javax.swing.JOptionPane;

public class Utiles {
	static public String leer(String txt) {
		return JOptionPane.showInputDialog(txt);
	}
	
	static public boolean sino(String txt) {
		return (JOptionPane.showConfirmDialog(null,txt,null,JOptionPane.YES_NO_OPTION)==0?true:false);
	}
	
	static public Object seleccion(String txt,Object arr[]) {
		return JOptionPane.showInputDialog(null, txt,null, JOptionPane.QUESTION_MESSAGE,null,arr,null);
	}
	
}
