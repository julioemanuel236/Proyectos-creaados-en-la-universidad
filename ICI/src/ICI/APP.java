package ICI;

import javax.swing.*;

class APP extends JFrame{


	APP(){
		setLayout(null);
		setResizable(false);
		setSize(1024,720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}


	static void main(String args[]){
		new APP();
	}
}

