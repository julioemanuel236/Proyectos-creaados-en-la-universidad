package app;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Random;

public class Muestra extends JFrame{
	
	private int di[] = {-1,0,1,0};
	private int dj[] = {0,1,0,-1};
	
	int size = 511;
	private int color=0;
	int x = 0, y = 0;
	boolean BFS = true;
	int pos = 0;
	LinkedList<Point> q = new LinkedList<>();
	
	public Muestra() throws Exception{
		
		setSize(size,size);
		
		setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
			iniciarAnimacion();
		
		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseMoved(MouseEvent e) {
				x = e.getX();
				y = e.getY();
				
			}	
		});
	
		addMouseListener((MouseListener) new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getButton() == e.BUTTON1)
					BFS = !BFS;
				if(e.getButton() == e.BUTTON3)
					pos = (pos+1)%3;
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
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
	
	
	public void iniciarAnimacion() throws Exception{
		
		(new Thread() {
			
			public void run() {
				int cont = 0;
				long last = 0;
				while(true) {
					
					repaint();
					//System.out.println(q.size());
					color%=0xFFFFFF;			
					if(System.currentTimeMillis()-last >= 1000) {
						//System.out.println(last);
						//System.out.println(cont);
						cont = 0;
						last = System.currentTimeMillis();
					}
					try {
						Thread.sleep(1000/144);
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					cont++;
				}
			}
			
		}).start();
		
		
	}
	
	
	@Override
	public void paint(Graphics g) {
		try {
			if(BFS)mostrarExpansionBFS(g);
			else mostrarExpansionDFS(g);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void mostrarExpansionBFS(Graphics gr) throws Exception{
		//System.out.println("COMENZANDO EXPANSION");
		
		Random rand = new Random();		
		//System.out.println("EN ESPERA: "+q.size());
		q.push(new Point(this.x,this.y));
		int[][] matrix = new int[size][size];
		matrix[this.y][this.x] = 1;
		
		//System.out.println(x + " " + y);
		
		int last =  1;
		int edge = 1;
		int mascaras[] = {0xFF,0xFF00,0xFF0000};
		int desplazamiento[] = {0,8,16};
		
		
		while(!q.isEmpty()) {
			//Thread.sleep(1);
			Point p = q.poll();
			
			
			int r = (color&mascaras[pos])>>desplazamiento[pos];
			int g = (color&mascaras[(pos+1)%3])>>desplazamiento[(pos+1)%3];
			int b = (color&mascaras[(pos+2)%3])>>desplazamiento[(pos+2)%3];
			
			//System.out.println(r + " " + g + " " + b);
			gr.setColor(new Color(r,g,b));
			gr.fillRect(p.x, p.y, 1, 1);
			color++;
			for(int k = 0; k < di.length ; k++) {
				int newI = p.y+di[k];
				int newJ = p.x+dj[k];
				
				if(newI < 0 || newI == matrix.length|| newJ < 0 || newJ == matrix[newI].length || matrix[newI][newJ] !=0 )continue;
				
				
				q.add(new Point(newJ,newI));
				
				matrix[newI][newJ] = matrix[p.y][p.x]+1;
															
			}			
			/*if(matrix[p.y][p.x]-last >= edge) {
				
				color++;
				
				last = matrix[p.y][p.x];
				try {
					Thread.sleep(1);
				}
				catch(Exception e) {
					
				}
			}*/
			
		}
		//System.out.println("EXPANSION TERMINADA");		
		
	}
	
	public void mostrarExpansionDFS(Graphics gr) throws Exception{
		
		int i = getWidth()/2;
		int j = getHeight()/2;
		
		q = new LinkedList<>();
		
		q.push(new Point(x,y));
		int[][] matrix = new int[getWidth()][getHeight()];
		matrix[y][x] = 1;
		
		int last =  1;
		int edge = 1;
		
		int mascaras[] = {0xFF,0xFF00,0xFF0000};
		int desplazamiento[] = {0,8,16};
		
		
		
		while(!q.isEmpty()) {
			Point p = q.poll();
			//Thread.sleep(10);
						
			int r = (color&mascaras[pos])>>desplazamiento[pos];
			int g = (color&mascaras[(pos+1)%3])>>desplazamiento[(pos+1)%3];
			int b = (color&mascaras[(pos+2)%3])>>desplazamiento[(pos+2)%3];
			
			//System.out.println(r + " " + g + " " + b);
			gr.setColor(new Color(r,g,b));
			gr.fillRect(p.x, p.y, 1, 1);
			
			color++;
			for(int k = 0; k < di.length ; k++) {
				int newI = p.y+di[k];
				int newJ = p.x+dj[k];
				
				if(newI < 0 || newI == getHeight() || newJ < 0 || newJ == getWidth() || matrix[newI][newJ] !=0 )continue;
				
				
				q.addFirst(new Point(newJ,newI));
				
				matrix[newI][newJ] = matrix[p.y][p.x]+1;
															
			}			
			
			/*if(matrix[p.y][p.x]-last >= edge) {
										
				last = matrix[p.y][p.x];
				try {
					Thread.sleep(1);
				}
				catch(Exception e) {
					
				}
			}*/
			
		}
		
	}
	
	
	public static void main(String[] args)throws Exception{
		new Muestra();		
	}

}
