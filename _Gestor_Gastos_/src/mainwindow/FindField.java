package mainwindow;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;

import ventana.TextField;
import ventana.configs;

public class FindField extends Component{

	private TextField texto;
	
	public FindField(Image img) {
		super(img);
		texto = new TextField(getWidth(),getHeight(),"Buscar..");
		texto.underline.setVisible(false);
		Font fuente = new Font(configs.FONTNAME,14,Font.PLAIN);
		fuente = ajustarFuente(fuente,getHeight());		
		texto.setFont(fuente);		
		add(texto);
		activeMouseListener();
	}
	
	@Override
	public void setForeground(Color f) {
		super.setForeground(f);
		texto.setForeground(f);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		texto.text.grabFocus();
	}
	
}
