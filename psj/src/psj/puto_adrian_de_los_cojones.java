package psj;
import javax.swing.*;
public class puto_adrian_de_los_cojones extends JFrame{

		class algo extends Object{
			String s1="Prueba";
			String s2="item";
			String s3="KK";
			@Override
			public String toString() {
				return s1+s2+s3;
			}
			
		}
	
		public puto_adrian_de_los_cojones () {
		this.setUndecorated(true);
		this.setSize(500,500);
		this.setVisible(true);
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		JComboBox cb = new JComboBox();
		cb.addItem(new algo());
		cb.setSize(250,20);
		cb.setLocation(0,0);
		this.add(cb);
		}
	
		public static void main(String[] args) {
		puto_adrian_de_los_cojones p = new puto_adrian_de_los_cojones ();
		p.adrianPuto();
		p.setLocation(0,0);
	}
		
		public void adrianPuto() {
			(new Thread() {
				public void run() {
					boolean se=false;
					JLabel txt = new JLabel("ADRIAN PUTO ALV");
					txt.setSize(400,400);
					txt.setFont(new java.awt.Font("Roboto",java.awt.Font.BOLD,30));
					txt.setLocation((puto_adrian_de_los_cojones.this.getWidth()/2)-(txt.getWidth()/2),
							(puto_adrian_de_los_cojones.this.getHeight()/2)-(txt.getHeight()/2 ));
					puto_adrian_de_los_cojones .this.add(txt);
					txt.setHorizontalAlignment(txt.CENTER);
					while(true) {
						
						txt.setVisible(se);
						txt.repaint();
						try {
							sleep(200);
							se=!se;
						}
						catch(Exception e) {
							
						}
					}
				}
			}).start();
		}
		

}
