package cocacola;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Principal extends JFrame implements ActionListener{

    private JMenuBar barra;
    private JMenu opciones, colordefondo, calcular, acercade;
    private JMenuItem red, black, purple, nuevo, salir, vacaciones, elcreador;
    private JLabel logo3, bienvenido, titulo, nombrecompleto, apellidopaterno, apellidomaterno,
                    departamento, antiguedad, resultadocalculo, registrado;
    private JTextField name, ap, am;
    private JComboBox<String> depa, tiempo;
    private JTextArea respuesta;
    private JScrollPane movilidad2;
    String nombreadministrador = "";
    
    public Principal(){

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);


        setTitle("Pantalla Principal");
        getContentPane().setBackground(new Color(255,0,0));
        setIconImage(new ImageIcon(getClass().getResource("/images/icon.png")).getImage());
        nombreadministrador = Bienvenida.texto;

        barra = new JMenuBar();
        barra.setBackground(new Color(255,0,0));
        setJMenuBar(barra);

        opciones = new JMenu("Opciones");
        opciones.setBackground(new Color(255,0,0));
        opciones.setFont(new Font("Andale mono", 3,14));
        opciones.setForeground(new Color(255,255,255));
        barra.add(opciones);

        calcular = new JMenu("Calcular");
        calcular.setBackground(new Color(255,0,0));
        calcular.setFont(new Font("Andale mono", 3, 14));
        calcular.setForeground(new Color(255,255,255));
        barra.add(calcular);

        acercade = new JMenu("Acerca de");
        acercade.setBackground(new Color(255,0,0));
        acercade.setFont(new Font("Andale mono", 3, 14));
        acercade.setForeground(new Color(255,255,255));
        barra.add(acercade);

        colordefondo = new JMenu("Color de Fondo");
        colordefondo.setBackground(new Color(255,255,255));
        colordefondo.setFont(new Font("Andale mono", 3, 14));
        colordefondo.setForeground(new Color(0,0,0));
        opciones.add(colordefondo);

        red = new JMenuItem("Rojo");
        red.setBackground(new Color(255,255,255));
        red.setFont(new Font("Andale mono", 3, 14));
        red.setForeground(new Color(0,0,0));
        colordefondo.add(red);
        red.addActionListener(this);

        black = new JMenuItem("Negro");
        black.setBackground(new Color(255,255,255));
        black.setFont(new Font("Andale mono", 3, 14));
        black.setForeground(new Color(0,0,0));
        colordefondo.add(black);
        black.addActionListener(this);

        purple = new JMenuItem("Morado");
        purple.setBackground(new Color(255,255,255));
        purple.setFont(new Font("Andale mono", 3, 14));
        purple.setForeground(new Color(0,0,0));
        colordefondo.add(purple);
        purple.addActionListener(this);

        nuevo = new JMenuItem("Nuevo");
        nuevo.setBackground(new Color(255,255,255));
        nuevo.setFont(new Font("Andale mono", 3, 14));
        nuevo.setForeground(new Color(0,0,0));
        opciones.add(nuevo);
        nuevo.addActionListener(this);

        salir = new JMenuItem("Salir");
        salir.setBackground(new Color(255,255,255));
        salir.setFont(new Font("Andale mono", 3, 14));
        salir.setForeground(new Color(0,0,0));
        opciones.add(salir);
        salir.addActionListener(this);

        vacaciones = new JMenuItem("Vacaciones");
        vacaciones.setBackground(new Color(255,255,255));
        vacaciones.setFont(new Font("Andale mono", 3, 14));
        vacaciones.setForeground(new Color(0,0,0));
        calcular.add(vacaciones);
        vacaciones.addActionListener(this);

        elcreador = new JMenuItem("El creador");
        elcreador.setBackground(new Color(255,255,255));
        elcreador.setFont(new Font("Andale mono", 3, 14));
        elcreador.setForeground(new Color(0,0,0));
        acercade.add(elcreador);
        elcreador.addActionListener(this);

        ImageIcon logo = new ImageIcon(getClass().getResource("images/logo-coca.png"));
        logo3 = new JLabel(logo);
        logo3.setBounds(5,5,250,100);
        add(logo3);

        bienvenido = new JLabel("Bienvenido/a " + nombreadministrador);
        bienvenido.setBounds(280,30,300,50);
        bienvenido.setFont(new Font("Andale mono", 3, 32));
        bienvenido.setForeground(new Color(255,255,255));
        add(bienvenido);

        titulo = new JLabel("Datos del Trabajador Para el Cálulo de Vacaciones");
        titulo.setBounds(45,140,900,25);
        titulo.setFont(new Font("Andale mono", 3, 24));
        titulo.setForeground(new Color(255,255,255));
        add(titulo);

        nombrecompleto = new JLabel("Nombre Completo");
        nombrecompleto.setBounds(25,188,180,25);
        nombrecompleto.setFont(new Font("Andale mono", 1,14));
        nombrecompleto.setForeground(new Color(255,255,255));
        add(nombrecompleto);

        name = new JTextField();
        name.setBounds(25,213,150,25);
        name.setBackground(new java.awt.Color(224,224,244));
        name.setFont(new java.awt.Font("Arial", 3, 14));
        name.setForeground(new Color(0,0,0));
        add(name);

        apellidopaterno = new JLabel("Apellido Paterno");
        apellidopaterno.setBounds(25,248,180,25);
        apellidopaterno.setFont(new Font("Andale mono", 3,14));
        apellidopaterno.setForeground(new Color(255,255,255));
        add(apellidopaterno);

        ap = new JTextField();
        ap.setBounds(25,273,150,25);
        ap.setBackground(new java.awt.Color(224,224,224));
        ap.setFont(new java.awt.Font("Arial", 3, 14));
        ap.setForeground(new Color(0,0,0));
        add(ap);

        apellidomaterno = new JLabel("Apellido Materno");
        apellidomaterno.setBounds(25,308,180,25);
        apellidomaterno.setFont(new Font("Andale mono", 3,14));
        apellidomaterno.setForeground(new Color(255,225,255));
        add(apellidomaterno);

        am = new JTextField();
        am.setBounds(25,334,150,25);
        am.setBackground(new java.awt.Color(224,224,224));
        am.setFont(new java.awt.Font("Arial",3,14));
        am.setForeground(new Color(0,0,0));
        add(am);

        departamento = new JLabel("Seleccione su Departamento");
        departamento.setBounds(220,188,220,25);
        departamento.setFont(new Font("Andale Mono", 3,14));
        departamento.setForeground(new Color(255,255,255));
        add(departamento);

        depa = new JComboBox<>();
        depa.setBounds(220,213,220,25);
        depa.setBackground(new java.awt.Color(224,224,224));
        depa.setFont(new java.awt.Font("Arial",3,14));
        depa.setForeground(new Color(0,0,0));
        add(depa);
        depa.addItem("");
        depa.addItem("Atencion al Cliente");
        depa.addItem("Departamento de Logistica");
        depa.addItem("Departamento de Gerencia");

        antiguedad =  new JLabel("Seleccione su Antiguedad");
        antiguedad.setBounds(220,248,180,25);
        antiguedad.setFont(new Font("Andale Mono", 3,14));
        antiguedad.setForeground(new Color(255,255,255));
        add(antiguedad);

        tiempo = new JComboBox<>();
        tiempo.setBounds(220,273,220,25);
        tiempo.setBackground(new Color(224,224,224));
        tiempo.setFont(new java.awt.Font("Arial",3,14));
        tiempo.setForeground(new java.awt.Color(0,0,0));
        add(tiempo);
        tiempo.addItem("");
        tiempo.addItem("1 Año de Servicio");
        tiempo.addItem("2 a 6 Años de Servicio");
        tiempo.addItem("7 Años o más de Servicio");

        resultadocalculo = new JLabel("Resultado del Calculo");
        resultadocalculo.setBounds(220,307,180,25);
        resultadocalculo.setFont(new Font("Andale Mono",3,14));
        resultadocalculo.setForeground(new Color(255,255,255));
        add(resultadocalculo);

        respuesta = new JTextArea();
        respuesta.setEditable(false);
        respuesta.setBackground(new Color(224,224,224));
        respuesta.setFont(new Font("Arial",3,13));
        respuesta.setForeground(new Color(0,0,0));
        respuesta.setText("\n     Resultado del Calculo de Vacaciones...");
        movilidad2 = new JScrollPane(respuesta);
        movilidad2.setBounds(220,333,490,130);
        add(movilidad2);

        registrado = new JLabel("©2023 The Coca-Cola Company | Todos los Derechos Reservados");
        registrado.setBounds(135,470,500,30);
        registrado.setFont(new Font("Andale mono",3,12));
        registrado.setForeground(new Color(255,255,255));
        add(registrado);

    }

    public void actionPerformed(ActionEvent a){

        if(a.getSource() == vacaciones){

            String nametrabajador = name.getText();
            String apellidopat = ap.getText();
            String apellidomate = am.getText();
            String dep = depa.getSelectedItem().toString();
            String time = tiempo.getSelectedItem().toString();

            if(nametrabajador.equals("") || apellidopat.equals("") || apellidomate.equals("") ||
            dep.equals("") || time.equals("")){

                JOptionPane.showMessageDialog(null, " Desbes llenar todos los campos.");

            }else {

                if(dep.equals("Atencion al Cliente")){

                    if(time.equals("1 Año de Servicio")){
                        respuesta.setText("\n     El/La Trabajador/a " + nametrabajador + " " + apellidopat + " " + apellidomate + " " +
                        "\n     quien trabaja en " + dep + " con " + time + 
                        "\n     recibe 6 dias de vacaciones.");
                    }
                    if(time.equals("2 a 6 Años de Servicio")){
                        respuesta.setText("\n     El/La Trabajador/a " + nametrabajador + " " + apellidopat + " " + apellidomate + " " +
                        "\n     quien trabaja en " + dep + " con " + time + 
                        "\n     recibe 14 dias de vacaciones.");
                    }
                    if(time.equals("7 Años o más de Servicio")){
                        respuesta.setText("\n     El/La Trabajador/a " + nametrabajador + " " + apellidopat + " " + apellidomate + " " +
                        "\n     quien trabaja en " + dep + " con " + time + 
                        "\n     recibe 20 dias de vacaciones.");
                    }                   
                }

                if(dep.equals("Departamento de Logistica")){

                    if(time.equals("1 Año de Servicio")){
                        respuesta.setText("\n     El/La Trabajador/a " + nametrabajador + " " + apellidopat + " " + apellidomate + " " +
                        "\n     quien trabaja en " + dep + " con " + time + 
                        "\n     recibe 7 dias de vacaciones.");
                    }
                    if(time.equals("2 a 6 Años de Servicio")){
                        respuesta.setText("\n     El/La Trabajador/a " + nametrabajador + " " + apellidopat + " " + apellidomate + " " +
                        "\n     quien trabaja en " + dep + " con " + time + 
                        "\n     recibe 15 dias de vacaciones.");
                    }
                    if(time.equals("7 Años o más de Servicio")){
                        respuesta.setText("\n     El/La Trabajador/a " + nametrabajador + " " + apellidopat + " " + apellidomate + " " +
                        "\n     quien trabaja en " + dep + " con " + time + 
                        "\n     recibe 22 dias de vacaciones.");
                    }                   
                }

                if(dep.equals("Departamento de Gerencia")){

                    if(time.equals("1 Año de Servicio")){
                        respuesta.setText("\n     El/La Trabajador/a " + nametrabajador + " " + apellidopat + " " + apellidomate + " " +
                        "\n     quien trabaja en " + dep + " con " + time + 
                        "\n     recibe 10 dias de vacaciones.");
                    }
                    if(time.equals("2 a 6 Años de Servicio")){
                        respuesta.setText("\n     El/La Trabajador/a " + nametrabajador + " " + apellidopat + " " + apellidomate + " " +
                        "\n     quien trabaja en " + dep + " con " + time + 
                        "\n     recibe 20 dias de vacaciones.");
                    }
                    if(time.equals("7 Años o más de Servicio")){
                        respuesta.setText("\n     El/La Trabajador/a " + nametrabajador + " " + apellidopat + " " + apellidomate + " " +
                        "\n     quien trabaja en " + dep + " con " + time + 
                        "\n     recibe 30 dias de vacaciones.");
                    }                   
                }

            }
        }
        if(a.getSource() == red){

            getContentPane().setBackground(new Color(255,0,0));
            barra.setBackground(new Color(255,0,0));
        }
        if(a.getSource() == black){

            getContentPane().setBackground(new Color(0,0,0));
            barra.setBackground(new Color(0,0,0));
        }
        if(a.getSource() == purple){

            getContentPane().setBackground(new Color(51,0,51));
            barra.setBackground(new Color(51,0,51));
        }
        if(a.getSource() == nuevo){

            name.setText("");
            ap.setText("");
            am.setText("");
            depa.setSelectedIndex(0);
            tiempo.setSelectedIndex(0);
            respuesta.setText("\n     Resultado del Calculo de Vacaciones...");
        }
        if(a.getSource() == salir){

            Bienvenida interfaz1 = new Bienvenida();
            interfaz1.setBounds(0,0,350,450);
            interfaz1.setVisible(true);
            interfaz1.setResizable(false);
            interfaz1.setLocationRelativeTo(null);
            this.setVisible(false);
        }
        if(a.getSource() == elcreador){
            JOptionPane.showMessageDialog(null, "                  Desarrollado por Alan José López Quiñonez" +
            "\n https://www.facebook.com/profile.php?id=100042433620829");
        }

    }

    public static void main(String[] args) {
        
        Principal pantalla3 = new Principal();
        pantalla3.setBounds(0,0,750,575);
        pantalla3.setVisible(true);
        pantalla3.setResizable(false);
        pantalla3.setLocationRelativeTo(null);
    } 
}