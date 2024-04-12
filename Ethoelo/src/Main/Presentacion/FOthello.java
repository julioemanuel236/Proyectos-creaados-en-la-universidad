package Main.Presentacion;

import javax.swing.JFrame;

import Main.Logica.BotonPersonalizado;
import Main.Logica.Turno;
import Main.Logica.Othello;
import java.awt.GridLayout;

public class FOthello extends JFrame {
    private BotonPersonalizado[][] botones;
    private final int filas = 8;
    private final int columnas = 8;
    
    private Turno turno;

    public FOthello() {
        this.setTitle("Othello");
        this.setSize(600, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(filas, columnas));
        
        turno = new Turno();
    
        botones = new BotonPersonalizado[filas][columnas];
        
      
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                botones[i][j] = new BotonPersonalizado("Default", turno);
                this.add(botones[i][j]); // Asegúrate de agregar los botones al diseño
            }
        }
        
        inicializarMapa();
    }

    private void inicializarMapa() {

    	((BotonPersonalizado) botones[3][4]).cambiarTipo("Negro");
    	((BotonPersonalizado) botones[4][3]).cambiarTipo("Negro");

    	((BotonPersonalizado) botones[3][3]).cambiarTipo("Blanco");
    	((BotonPersonalizado) botones[4][4]).cambiarTipo("Blanco");

    	((BotonPersonalizado) botones[2][3]).cambiarTipo("Ayuda");
    	((BotonPersonalizado) botones[3][2]).cambiarTipo("Ayuda");
    	((BotonPersonalizado) botones[5][4]).cambiarTipo("Ayuda");
    	((BotonPersonalizado) botones[4][5]).cambiarTipo("Ayuda");
    }

    public static void main(String[] args) {
        FOthello fOthello = new FOthello();
        fOthello.setVisible(true);
    }
}
