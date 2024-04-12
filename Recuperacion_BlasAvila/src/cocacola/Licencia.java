package cocacola;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;

public class Licencia extends JFrame implements ActionListener, ChangeListener{
    
    private JLabel titulo, logo2;
    private JCheckBox aceptar;
    private JButton continuar, noacepto;
    private JTextArea informacion;
    private JScrollPane movilidad;
    public static String nombre = "";

    public Licencia(){

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        setTitle("Licencia de Uso");
        setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage());
        nombre = Bienvenida.texto;

        titulo = new JLabel("TERMINOS Y CONDICIONES");
        titulo.setBounds(215,5,200,30);
        titulo.setFont(new Font("Andale Mono", 1, 14));
        titulo.setForeground(new Color(0,0,0));
        add(titulo);

        informacion = new JTextArea();
        informacion.setEditable(false);
        informacion.setFont(new Font("Andale mono", 0, 9));
        informacion.setText("\n\n           TERMINOS Y CONDICIONES" + 
                            "\n\n          A. PROHIBIDA SU VENTA O DISTRIBUCION SIN AUTORIZACION DE ALAN LÓPEZ." + 
                            "\n          B. PROHIBIDA LA ALTERACION DEL CODIGO FUENTE O DISEÑO DE LAS INTERFACES GRAFICAS" + 
                            "\n          C. ALAN LÓPEZ NO SE HACE RESPONSABLE DEL MAL USO DE ESTE SOFTWARE" + 
                            "\n\n          LOS ACUERDOS LEGALES EXPUESTOS A CONTINUACION RIGEN EL USO QUE USTED HAGA DE ESTE SOFTWARE" + 
                            "\n          (ALAN LÓPEZ), NO SE RESPONSABILIZA DEL USO QUE USTED HAGA CON ESTE SOFWARE Y SUS SERVICIOS" +
                            "\n          PARA ACEPTAR LOS TERMINOS Y CONDICIONES HAGA CLIC EN 'ACEPTAR' " +
                            "\n          SI USTED NO ACEPTA ESTOS TERMINOS HAGA CLIC EN 'NO ACEPTO' Y NO UTILICE ESTE SOFTWARE" + 
                            "\n\n          PARA MAYOR INFORMACION SOGRE NUESTROS PRODUCTOS O SERVICIOS POR FAVOR VISITE:" +
                            "\n          https://www.facebook.com/profile.php?id=100042433620829");
        movilidad = new JScrollPane(informacion);
        movilidad.setBounds(10,40,575,200);
        add(movilidad);

        aceptar = new JCheckBox("Yo " + nombre + " Acepto");
        aceptar.setBounds(10,250,300,30);
        aceptar.addChangeListener(this);
        add(aceptar);

        continuar = new JButton("Continuar");
        continuar.setBounds(10,290,100,30);
        continuar.addActionListener(this); 
        continuar.setEnabled(false); 
        add(continuar);

        noacepto = new JButton("No acepto");
        noacepto.setBounds(120,290,100,30);
        noacepto.addActionListener(this); 
        noacepto.setEnabled(true); 
        add(noacepto);

        ImageIcon imagen = new ImageIcon(getClass().getResource("/images/coca-cola.png"));
        logo2 = new JLabel(imagen);
        logo2.setBounds(315,135,300,300);
        add(logo2);

    }

    public void stateChanged(ChangeEvent a){

        if(aceptar.isSelected() == true){

            continuar.setEnabled(true);
            noacepto.setEnabled(false);
        } else{
            continuar.setEnabled(false);
            noacepto.setEnabled(true);
        }

    }

    public void actionPerformed(ActionEvent a){


        if(a.getSource() == continuar){

        Principal pantalla3 = new Principal();
        pantalla3.setBounds(0,0,750,575);
        pantalla3.setVisible(true);
        pantalla3.setResizable(false);
        pantalla3.setLocationRelativeTo(null);
        this.setVisible(false);

        }else if(a.getSource() == noacepto) {

        Bienvenida interfaz1 = new Bienvenida();
        interfaz1.setBounds(0,0,350,450);
        interfaz1.setVisible(true);
        interfaz1.setResizable(false);
        interfaz1.setLocationRelativeTo(null);
        this.setVisible(false);

        }
    }

    public static void main(String[] args) {
        
        Licencia interfaz2 = new Licencia();
        interfaz2.setBounds(0,0,600,360);
        interfaz2.setVisible(true);
        interfaz2.setResizable(false);
        interfaz2.setLocationRelativeTo(null);

    }
}