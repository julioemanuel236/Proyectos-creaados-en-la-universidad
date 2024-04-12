package cocacola;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class Bienvenida extends JFrame implements ActionListener{

    private JLabel logo, sistema, Inombre, piedepagina;
    private JTextField nombre;
    private JButton ingresar;
    public static String texto = "";

    public Bienvenida(){

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        setTitle("Bienvenido/a");
        getContentPane().setBackground(new Color(255,0,0));
        setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage());

        ImageIcon imagen = new ImageIcon(getClass().getResource("/images/logo-coca.png"));
        logo = new JLabel(imagen);
        logo.setBounds(25,15,300,150);
        add(logo);

        sistema = new JLabel("Sistema de Control Vacacional");
        sistema.setBounds(35,135,300,30);
        sistema.setFont(new Font("Andale Mono", 3, 18));
        sistema.setForeground(new Color(255,255,255));
        add(sistema);

        Inombre = new JLabel("Ingrese su Nombre");
        Inombre.setBounds(45,212,200,30);
        Inombre.setFont(new Font("Andale Mono", 1, 13));
        Inombre.setForeground(new Color(255,255,255));
        add(Inombre); 

        piedepagina = new JLabel("© 2023 The Coca-Cola Company");
        piedepagina.setBounds(85,375,300,30);
        piedepagina.setFont(new Font("Andale Mono", 1, 12));
        piedepagina.setForeground(new Color(255,255,255));
        add(piedepagina);

        nombre = new JTextField();
        nombre.setBounds(45,240,255,25);
        nombre.setBackground(new Color(224,224,224));
        nombre.setFont(new Font("Arial", 1, 14));
        nombre.setForeground(new Color(0,0,0));
        add(nombre);

        ingresar = new JButton("Ingresar");
        ingresar.setBounds(125,280,100,30);
        ingresar.setBackground(new Color(224,224,224));
        ingresar.setFont(new Font("Andale Mono", 1,14));
        ingresar.setForeground(new Color(255,0,0));
        ingresar.addActionListener(this);
        add(ingresar);

    }

    public void actionPerformed(ActionEvent a){
        
        if(a.getSource() == ingresar){

            texto = nombre.getText().trim();

            if(texto.equals("")){
                JOptionPane.showMessageDialog(null, "Debes Ingresar tu Nombre.");
            } else{
                
            Licencia interfaz2 = new Licencia();
            interfaz2.setBounds(0,0,600,360);
            interfaz2.setVisible(true);
            interfaz2.setResizable(false);
            interfaz2.setLocationRelativeTo(null);
            this.setVisible(false);

            }
        }

    }

    public static void main(String[] args) {
        
        Bienvenida interfaz1 = new Bienvenida();
        interfaz1.setBounds(0,0,350,450);
        interfaz1.setVisible(true);
        interfaz1.setResizable(false);
        interfaz1.setLocationRelativeTo(null);

    }
}