package mainwindow;

import java.awt.Color;
import java.awt.Container;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import data.ControlGasto;
import data.Usuario;
import ventana.configs;
import visor_gastos.PanelVisorGastos;

public class MainWindow extends JFrame{
	
	Usuario user;
	
	private Image barImg;
	private Image closeButtonImg;
	private Image configButtonImg;
	private Image findButtonImg;
	
	private Image findFieldImg;
	private Image grayBaseImg;
	private Image deleteButtonImg;
	private Image editButtonImg;
	private Image calendarButtonImg;
	private Image newButtonImg;
	private Image wasteAreaImg;
	private Image panelVisorGastosImg;
			
	private int skin = 0;
		
	private Bar bar;
	private CloseButton closeButton;
	private GrayBase grayBase;
	private NewButton newButton;
	private WasteArea wasteArea;
	private FechaLabel fechaLabel;
	private CalendarButton calendar;
	private FindButton findButton;
	private FindField findField;
	private PanelVisorGastos panelVisorGastos;
	private UserNameDisplayer usernameDisplayer;
	private boolean ready = false;
	
	private ControlGasto gastos ;
	
	public MainWindow(Usuario user)throws Exception{
		setUndecorated(true);
		//setSize(500,300);
		//comentar el setVisible para producto final
		setOpacity(0);
		setVisible(true);
		
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		this.user = user;		
		initComponents();		
		
		gastos = new ControlGasto(user);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		eventos.MouseTrackingThread.run();
		gastos.waitUntilReady();
		
		
		//JOptionPane.showMessageDialog(null, "READY");
		this.ready = true;
		
		
	}
	
	private void cargar_imagenes() {
		String skinRute = configs.getImgRute(skin);
		System.out.println(skinRute);
		try {
			barImg = ImageIO.read(getClass().getResource(skinRute+"bar.png"));			
		}			
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			closeButtonImg = ImageIO.read(getClass().getResource(skinRute+"close_button.png"));
		}			
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			configButtonImg = ImageIO.read(getClass().getResource(skinRute+"config_button.png"));
		}			
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			findButtonImg = ImageIO.read(getClass().getResource(skinRute+"find_button.png"));
		}			
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			calendarButtonImg = ImageIO.read(getClass().getResource(skinRute+"calendar_button.png"));
		}			
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			editButtonImg = ImageIO.read(getClass().getResource(skinRute+"edit_button.png"));
		}			
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			deleteButtonImg = ImageIO.read(getClass().getResource(skinRute+"delete_button.png"));
		}			
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			newButtonImg = ImageIO.read(getClass().getResource(skinRute+"new_button.png"));
		}			
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			findFieldImg = ImageIO.read(getClass().getResource(skinRute+"find_field.png"));
		}			
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			wasteAreaImg = ImageIO.read(getClass().getResource(skinRute+"waste_area.png"));
		}			
		catch(Exception e) {
			e.printStackTrace();
		}
		try {
			grayBaseImg = ImageIO.read(getClass().getResource(skinRute+"gray_base.png"));
		}			
		catch(Exception e) {
			e.printStackTrace();
		}		
		try {
			panelVisorGastosImg = ImageIO.read(getClass().getResource(skinRute+"panel_visor_gastos.png"));
		}			
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}
			
	private void crear_componentes() {
		JPanel glassPanel = new JPanel();
		
		bar = new Bar(barImg);
		add(bar);
		//repaint();
		grayBase = new GrayBase(grayBaseImg);
		System.out.println(System.currentTimeMillis());
		add(grayBase,0);
		//repaint();
		System.out.println(System.currentTimeMillis());				
		newButton = new NewButton(newButtonImg);
		System.out.println(System.currentTimeMillis());
		add(newButton,0);
		//repaint();
		wasteArea = new WasteArea(wasteAreaImg);
		System.out.println(System.currentTimeMillis());
		grayBase.add(wasteArea,0);
		//repaint();
		fechaLabel = new FechaLabel();
		System.out.println(System.currentTimeMillis());
		add(fechaLabel,0);
		//repaint();
		closeButton = new CloseButton(closeButtonImg);
		System.out.println(System.currentTimeMillis());
		add(closeButton,0);
		//repaint();		
		calendar = new CalendarButton(calendarButtonImg);
		System.out.println(System.currentTimeMillis());
		grayBase.add(calendar);	
		//repaint();
		findButton = new FindButton(findButtonImg);
		System.out.println(System.currentTimeMillis());
		add(findButton,0);
		//repaint();
		findField = new FindField(findFieldImg);
		System.out.println(System.currentTimeMillis());
		add(findField,1);
		//repaint();
		panelVisorGastos = new PanelVisorGastos(panelVisorGastosImg);
		System.out.println(System.currentTimeMillis());
		add(panelVisorGastos);
		//repaint();
		usernameDisplayer = new UserNameDisplayer(user);
		System.out.println(System.currentTimeMillis());
		add(usernameDisplayer,0);
		//repaint();
		fechaLabel.setForeground(configs.FOREGROUND);
		findField.setForeground(configs.FOREGROUND);
		wasteArea.setForeground(configs.FOREGROUND);
		usernameDisplayer.setForeground(configs.FOREGROUND);
		glassPanel.setOpaque(false);
		glassPanel.setSize(getSize());		
		setGlassPane(glassPanel);
		glassPanel.setVisible(true);
		

		System.out.println(System.currentTimeMillis());
		
		
		
		
		
		
			
		
		
		
		
		
		bar.setVentana(this);
		closeButton.setVentana(this);

		System.out.println(System.currentTimeMillis());
		
		//rescalar(2,(Container)this);
		
		closeButton.setLocation(getWidth()-closeButton.getWidth(),0);
		grayBase.setLocation(0,bar.getHeight());
		newButton.setLocation(grayBase.getWidth()+(getWidth()-grayBase.getWidth())/10,bar.getHeight()*2/5);
		wasteArea.setLocation(grayBase.getWidth()-wasteArea.getWidth(),0);
		fechaLabel.setSize(bar.getWidth()/3,bar.getHeight()/2);		
		fechaLabel.setLocation((bar.getWidth()/3)-(fechaLabel.getWidth()/2),(bar.getHeight()/2)-(fechaLabel.getHeight()/2));
		calendar.setLocation(grayBase.getWidth()-calendar.getWidth()-(calendar.getWidth()/3),
				grayBase.getHeight()-calendar.getHeight()-(calendar.getHeight()/3));		
		findButton.setLocation(wasteArea.getX()+(wasteArea.getWidth()/2)-findButton.getWidth(),
				                wasteArea.getHeight()+(1*findButton.getHeight())+bar.getHeight());		
		findField.setLocation(findButton.getX()+findButton.getWidth()*5/8,findButton.getY());						
		panelVisorGastos.setLocation(getWidth()-panelVisorGastos.getWidth(),getHeight()-panelVisorGastos.getHeight());
		usernameDisplayer.setLocation(bar.getWidth()*58/100,0);
		usernameDisplayer.setSize(fechaLabel.getWidth(),bar.getHeight()*2/5);
		
		
		
		
	}
	
	public void rescalar(int k,Container p) {
		for(java.awt.Component c:p.getComponents()) {
			rescalar(k, (Container)c);
		}
		p.setSize(p.getWidth()*k,p.getHeight()*k);
	}
	
	private void initComponents() {
		cargar_imagenes();
		
		setSize(barImg.getWidth(null),barImg.getHeight(null)+grayBaseImg.getHeight(null));

		crear_componentes();
		
		//System.out.println(getGlassPane());
		
		getGlassPane().addMouseListener((MouseListener) new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {				
				eventos.MouseTrackingThread.MOUSEEVENTS.add(e);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				//System.out.println("PRESIONADO");
				eventos.MouseTrackingThread.MOUSEEVENTS.add(e);
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				//System.out.println("SOLTADO");
				eventos.MouseTrackingThread.MOUSEEVENTS.add(e);
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
	
		
	}
	
	public void mostrar() {
		
		long tInicio = System.currentTimeMillis();
		long tActual = 0;
		long tFinal = 500;
		setOpacity(0);
		setVisible(true);
	
		while(tActual<=tFinal){
			
			
			try {
				float opacity = ((float)tActual/(float)tFinal);				
				setOpacity(opacity);
				System.out.println(opacity);
				repaint();
				Thread.sleep(1000/144);
				
			}
			catch(Exception ee) {
				ee.printStackTrace();
			}
			tActual = System.currentTimeMillis() - tInicio;			
						
		}
		
		setOpacity(1);
		wasteArea.setPrecio("1000000.74");
	}
	
	public void waitUntilReady() {
		
		while(!ready) {
			try {
				Thread.sleep(1000/144);
			}
			catch(Exception e) {
				
			}
		}
		
	}
	/*
	public static void main(String[] args) {
		try {
			new MainWindow(new Usuario("PRUEBA"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	*/
	
}
