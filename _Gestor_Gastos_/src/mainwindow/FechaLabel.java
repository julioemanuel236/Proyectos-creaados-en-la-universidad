package mainwindow;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.time.LocalDateTime;

import ventana.configs;




public class FechaLabel extends Component{

	private Font fontMes = new Font(configs.FONTNAME,Font.PLAIN,12);
	private Font fontAnno = new Font(configs.FONTNAME,Font.PLAIN,12);
	
	public FechaLabel() {
		
	}
	

	@Override
	public void paint(Graphics g){
		String mes = LocalDateTime.now().getMonth().toString();
		String anno = String.valueOf(LocalDateTime.now().getYear());
		pintarTexto(g,mes,0,0,getWidth()*4/5,getHeight(),fontMes);
		pintarTexto(g,anno,getWidth()*4/5,0,getWidth()-(getWidth()*4/5),getHeight()/2,fontAnno);
	}
}