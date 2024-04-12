package mainwindow;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import data.Usuario;
import ventana.configs;

public class UserNameDisplayer extends Component{

	private Usuario user;
	private Font font= new Font(configs.FONTNAME,Font.PLAIN,12);
	
	public UserNameDisplayer(Usuario user) {
		super();
		this.user = user;
	}

	@Override
	public void paint(Graphics g) {
		pintarTexto(g, user.getNombre().toUpperCase(), 0, 0, getWidth(), getHeight(), font);		
	}
	
}
