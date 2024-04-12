package paquete1.proyectguitars;

import javax.swing.ImageIcon;
import javax.swing.event.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import java.awt.event.ActionListener;

public class ProyectGuitars extends JFrame implements ActionListener, ChangeListener, ItemListener {

    //Desde el JLabe3 hasta el JLabe6 estan estan las imagenes o calcomanias de la hoja de las canciones 
    public JLabel label1, label2;
    public JTextField textField1, textField2, textField3, textField4, textField5, textField6, textField7, textField8, textField9;
    public JButton boton1, boton2, boton3, boton4, boton5;
    public String cancionBuscada, mostrarCancion;
    public String matrisTCan[][] = new String[50][50];//primero filas luego las columnas
    public ButtonGroup grupoBt;
    public JRadioButton radio1, radio2, radio3, radio4, radio5, radio6, radio7;
    public int y = 0;

    public ProyectGuitars() {

        setLayout(null);
        setTitle("Guitars Flash");

        //setIconImage(new ImageIcon(getClass().getResource("/icono-guitarra.png")).getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //----------------------------------------------------------------------
        //Espacios donde aparecen los nombres de las canciones 
        textField2 = new JTextField();
        textField2.setEditable(false);
        textField2.setBounds(45, 162, 230, 22);
        textField2.setFont(new Font("Segoe UI", 1, 12));
        textField2.setForeground(new Color(255, 51, 51));
        textField2.setBackground(new Color(255, 255, 255));
        textField2.setBackground(new java.awt.Color(0,0,0,1));
        textField2.setBorder(null);
        textField2.setOpaque(false);
        add(textField2);
        textField3 = new JTextField();
        textField3.setBounds(45, 186, 230, 22);
        textField3.setFont(new Font("Segoe UI", 1, 12));
        textField3.setForeground(new Color(255, 51, 51));
        textField3.setBackground(new Color(246, 206, 154));
        //textField3.setEditable(false);
        textField3.setBorder(null);
        add(textField3);
        textField4 = new JTextField();
        textField4.setBounds(45, 210, 230, 22);
        textField4.setFont(new Font("Segoe UI", 1, 12));
        textField4.setForeground(new Color(255, 51, 51));
        textField4.setBackground(new Color(246, 206, 154));
        //textField4.setEditable(false);
        textField4.setBorder(null);
        add(textField4);
        textField5 = new JTextField();
        textField5.setBounds(45, 234, 230, 22);
        textField5.setFont(new Font("Segoe UI", 1, 12));
        textField5.setForeground(new Color(255, 51, 51));
        textField5.setBackground(new Color(246, 206, 154));
        // textField5.setEditable(false);
        textField5.setBorder(null);
        add(textField5);
        textField6 = new JTextField();
        textField6.setBounds(45, 262, 230, 22);
        textField6.setFont(new Font("Segoe UI", 1, 12));
        textField6.setForeground(new Color(255, 51, 51));
        textField6.setBackground(new Color(246, 206, 154));
        //textField6.setEditable(false);
        textField6.setBorder(null);
        add(textField6);
        textField7 = new JTextField();
        textField7.setBounds(45, 286, 230, 22);
        textField7.setFont(new Font("Segoe UI", 1, 12));
        textField7.setForeground(new Color(255, 51, 51));
        textField7.setBackground(new Color(246, 206, 154));
        //textField7.setEditable(false);
        textField7.setBorder(null);
        add(textField7);
        textField8 = new JTextField();
        textField8.setBounds(45, 310, 230, 22);
        textField8.setFont(new Font("Segoe UI", 1, 12));
        textField8.setForeground(new Color(255, 51, 51));
        textField8.setBackground(new Color(246, 206, 154));
        //textField8.setEditable(false);
        textField8.setBorder(null);
        add(textField8);
        textField9 = new JTextField();
        textField9.setBounds(45, 338, 230, 22);
        textField9.setFont(new Font("Segoe UI", 1, 12));
        textField9.setForeground(new Color(255, 51, 51));
        textField9.setBackground(new Color(246, 206, 154));
        //textField9.setEditable(false);
        textField9.setBorder(null);
        add(textField9);
        //----------------------------------------------------------------------
        // Barra de busqueda
        textField1 = new JTextField();
        textField1.setBounds(85, 130, 140, 25);
        textField1.setFont(new Font("Segoe UI", 1, 14));
        textField1.setForeground(new Color(255, 51, 51));
        textField1.setBackground(new Color(255, 255, 255));
        textField1.setBackground(new java.awt.Color(0,0,0,1));
        textField1.setOpaque(false);
        textField1.setBorder(null);
        add(textField1);
        //Boton de buscar
        ImageIcon lupaBuscar = new ImageIcon("images/lupa.png");
        boton1 = new JButton(lupaBuscar);
        boton1.setBounds(225, 130, 30, 30);
        boton1.setBackground(new Color(246, 206, 154));
        boton1.setBorder(null);
        boton1.addActionListener(this);
        add(boton1);
        //Boton de Siguiente a la derecha
        ImageIcon lupaSigDere = new ImageIcon("images/Siguiente_derecha.png");
        boton2 = new JButton(lupaSigDere);
        boton2.setBounds(235, 380, 30, 30);
        boton2.setBackground(new Color(246, 206, 154));
        boton2.setBorder(null);
        boton2.addActionListener(this);
        //boton atras izquierda
        add(boton2);
        ImageIcon lupaSigIzqui = new ImageIcon("images/Siguiente_izquierda.png");
        boton3 = new JButton(lupaSigIzqui);
        boton3.setBounds(205, 380, 30, 30);
        boton3.setBackground(new Color(246, 206, 154));
        boton3.setBorder(null);
        boton3.addActionListener(this);
        add(boton3);
        //-----------------------------------------------------------------------------------
        grupoBt = new ButtonGroup();
        radio1 = new JRadioButton("Nivel 1");
        radio1.setBounds(45, 370, 65, 10);
        radio1.setFont(new Font("Segoe UI", 1, 11));
        radio1.setForeground(new Color(255, 51, 51));
        radio1.setBackground(new Color(246, 206, 154));
        radio1.setBorder(null);
        radio1.addChangeListener(this);
        add(radio1);
        grupoBt.add(radio1);

        radio2 = new JRadioButton("Nivel 2");
        radio2.setBounds(50, 384, 65, 10);
        radio2.setFont(new Font("Segoe UI", 1, 11));
        radio2.setForeground(new Color(255, 51, 51));
        radio2.setBackground(new Color(246, 206, 154));
        radio2.setBorder(null);
        radio2.addChangeListener(this);
        add(radio2);
        grupoBt.add(radio2);

        radio3 = new JRadioButton("Nivel 3");
        radio3.setBounds(55, 398, 65, 10);
        radio3.setFont(new Font("Segoe UI", 1, 11));
        radio3.setForeground(new Color(255, 51, 51));
        radio3.setBackground(new Color(246, 206, 154));
        radio3.setBorder(null);
        radio3.addChangeListener(this);
        add(radio3);
        grupoBt.add(radio3);

        radio4 = new JRadioButton("Nivel 4");
        radio4.setBounds(60, 412, 65, 10);
        radio4.setFont(new Font("Segoe UI", 1, 11));
        radio4.setForeground(new Color(255, 51, 51));
        radio4.setBackground(new Color(246, 206, 154));
        radio4.setBorder(null);
        radio4.addChangeListener(this);
        add(radio4);
        grupoBt.add(radio4);

        radio5 = new JRadioButton("Nivel 5");
        radio5.setBounds(65, 426, 65, 10);
        radio5.setFont(new Font("Segoe UI", 1, 11));
        radio5.setForeground(new Color(255, 51, 51));
        radio5.setBackground(new Color(246, 206, 154));
        radio5.setBorder(null);
        radio5.addChangeListener(this);
        add(radio5);
        grupoBt.add(radio5);

        radio6 = new JRadioButton("Nivel 6");
        radio6.setBounds(70, 440, 65, 10);
        radio6.setFont(new Font("Segoe UI", 1, 11));
        radio6.setForeground(new Color(255, 51, 51));
        radio6.setBackground(new Color(246, 206, 154));
        radio6.setBorder(null);
        radio6.addChangeListener(this);
        add(radio6);
        grupoBt.add(radio6);
        radio7 = new JRadioButton("Nivel 6");
        radio7.setBounds(75, 454, 65, 10);
        radio7.setFont(new Font("Segoe UI", 1, 11));
        radio7.setForeground(new Color(255, 51, 51));
        radio7.setBackground(new Color(246, 206, 154));
        radio7.setBorder(null);
        radio7.addChangeListener(this);
        add(radio7);
        grupoBt.add(radio7);
        //-----------------------------------------------------------------------------------
        //--------------------------------------------------------------------------------------
        // Aqui estan Todas las canciones ya ordenadas dentro de la matris
        //Primera fila
        /*Matris posicion 1*/
        matrisTCan[0][0] = "  Lonely Day - System Of A Down           [2]";// 11 ESPACIOS
        /*Matris posicion 2*/
        matrisTCan[0][1] = "  Son Of The King - Hellish War               [5]";//15 ESPACIOS
        /*Matris posicion 3*/
        matrisTCan[0][2] = "  Toxicity - System Of A Down                [3]";//16 ESPACIOS
        /*Matris posicion 4*/
        matrisTCan[0][3] = "  Figure It Out - Royal Blood                    [2]";// 20 ESPACIOS
        /*Matris posicion 5*/
        matrisTCan[0][4] = "  Famous Last Words - My C Romance   [3]";// 3 ESPACIOS
        /*Matris posicion 6*/
        matrisTCan[0][5] = "  Pet Sematary - Ramones     [2]";
        /*Matris posicion 7*/
        matrisTCan[0][6] = "  They Say - Scars On Broadway              [2]";// 14 ESPACIOS
        /*Matris posicion 8*/
        matrisTCan[0][7] = "  Kickstart My Heart - Motley Crue        [3]";// 8 ESPACIOS
        /*Matris posicion 9*/
        matrisTCan[0][8] = "  Wings Of Justice - Galneryus                 [5]";// 17 ESPACIOS
        /*Matris posicion 10*/
        matrisTCan[0][9] = "  Livin On The Edge - Aerosmith             [3]";// 13 ESPACIOS
        /*Matris posicion 11*/
        matrisTCan[0][10] = "  Mistakes Like Fractures - Knocked L   [3]";// 3 ESPACIOS
        /*Matris posicion 12*/
        matrisTCan[0][11] = "  Slither - Velvet Revolvet                       [3]";// 23 ESPACIOS
        /*Matris posicion 13*/
        matrisTCan[0][12] = "  Rime Of The Ancient Mariner - I M      [3]";// 6 ESPACIOS
        /*Matris posicion 14*/
        matrisTCan[0][13] = "  Destroyer - Hellish War                          [5]";// 26 ESPACIOS
        /*Matris posicion 15*/
        matrisTCan[0][14] = "  All Nightmare Long - Metallica     [5]";
        /*Matris posicion 16*/
        matrisTCan[0][15] = "  Reset The Game - Noturnall                 [6]";//17 ESPACIOS
        /*Matris posicion 17*/
        matrisTCan[0][16] = "  Metal Forever - Hellish War                  [3]";// 18 ESPACION
        /*Matris posicion 18*/
        matrisTCan[0][17] = "  Soldiers Of The Wasteland - DragonF [6]";//1 ESPACIOS
        /*Matris posicion 19*/
        matrisTCan[0][18] = "  Lux Eterna - Metallica                             [4]";// 29 ESPACIOS
        /*Matris posicion 20*/
        matrisTCan[0][19] = "  Sleepwaking - Bring Me The Horizon [3]";// 1 ESPACIOS
        /*Matris posicion 21*/
        matrisTCan[0][20] = "  Zombified - Falling In Reverse              [3]";// 14 ESPACIOS
        /*Matris posicion 22*/
        matrisTCan[0][21] = "  No Sleep Till Brooklyn - Beastie Boys  [3]";// 2 ESPACIOS
        /*Matris posicion 23*/
        matrisTCan[0][22] = "  Akatsuki - BabyMetal                              [4]";// 30 ESPACIOS
        /*Matris posicion 24*/
        matrisTCan[0][23] = "  Die For Glory - Hellish War                   [5]";//20 espacios
        /*Matris posicion 25*/
        matrisTCan[0][24] = "  one - Metallica                                          [5]";// 42 ESPACIOS
        /*Matris posicion 26*/
        matrisTCan[0][25] = "  The Arms Of Sorrow - Killswitch E       [3]";// 7 ESPACIOS
        /*Matris posicion 27*/
        matrisTCan[0][26] = "  Playing God - Polyphia                             [4]";// 29 ESPACIOS
        /*Matris posicion 28*/
        matrisTCan[0][27] = "  Highway To Oblivion - DragonForce   [6]";// 3 ESPACIOS
        /*Matris posicion 29*/
        matrisTCan[0][28] = "  Dr. Feelgood - Motley Crue                   [3]";// 19 ESPACIOS
        /*Matris posicion 30*/
        matrisTCan[0][29] = "  God Damn - Avenged Sevenfold         [3]";// 9 ESPACIOS
        /*Matris posicion 31*/
        matrisTCan[0][30] = "  Falling To Pieces - Faith No More         [3]";// 9 ESPACIOS
        /*Matris posicion 32*/
        //matrisTCan[0][31] = "  Lonely Day - System Of A Down          [2]";// 10 ESPACIOS
        /*Matris posicion 33*/
        matrisTCan[0][32] = "  Hollywood Whore - Papa Roach     [3]";
        /*Matris posicion 34*/
        matrisTCan[0][33] = "  Keep It Hellish - Hellish War                  [3]";//18 espacios
        /*Matris posicion 35*/
        matrisTCan[0][34] = "  Hypa Hypa - Electric Callboy                  [3]";//18 ESPACIOS
        /*Matris posicion 36*/
        matrisTCan[0][35] = "  Into The Mouth Of H - Trivium             [4]";// 13 ESPACIOS
        /*Matris posicion 37*/
        matrisTCan[0][36] = "  My Will Be Done - Powerwolf               [3]";//15 ESPACIOS
        /*Matris posicion 38*/
        matrisTCan[0][37] = "  B.Y.O.B - System Of A Down                 [5]";//17 espacios
        /*Matris posicion 39*/
        matrisTCan[0][38] = "  Fly By Night - Rush                                   [2]";//35 ESPACIOS
        /*Matris posicion 40*/
        matrisTCan[0][39] = "  The Game - DragonForce                       [5]";//22 espacios
        /*Matris posicion 41*/
        matrisTCan[0][40] = "  The Dark Ride - Helloween                   [4]";//19 ESPACIOS
        /*Matris posicion 42*/
        matrisTCan[0][41] = "  Wish I Had An Angel - Nightwish     [3]";
        /*Matris posicion 43*/
        matrisTCan[0][42] = "  Inside The Winter Storm - DragonF    [6]";//4 ESPACIOS
        /*Matris posicion 44*/
        matrisTCan[0][43] = "  Message In A Bottle - The Police          [2]";//10 ESPACIOS
        /*Matris posicion 45*/
        matrisTCan[0][44] = "  Chop Suey - System Of A Down           [5]";//10 ESPACIOS
        /*Matris posicion 46*/
        matrisTCan[0][45] = "  You Can't Handle Me - Thunder           [1]";//11 ESPACIOS
        /*Matris posicion 47*/
        matrisTCan[0][46] = "  Do Your Worst - Rival Sons                   [3]";//19 ESPACIOS
        /*Matris posicion 48*/
        matrisTCan[0][47] = "  Freak On A Leash - Korn                        [2]";//24 ESPACIOS
        /*Matris posicion 49*/
        matrisTCan[0][48] = "  Heaven Nor Hell - Volbeat                    [2]";//20 ESPACIOS
        /*Matris posicion 50*/
        matrisTCan[0][49] = "  Question - System Of A Down             [3]";//12 espacios
        //----------------------------------- hasta aqui termina la primera fila
        //Segunda fila
        /*Matris posicion 1*/
        matrisTCan[1][0] = "  Technical Difficilties - Racer X     [4]";
        /*Matris posicion 2*/
        matrisTCan[1][1] = "  Take On Me - A-ha                                  [2]";//34 ESPACIOS
        /*Matris posicion 3*/
        matrisTCan[1][2] = "  Monsoon - Tokio Hotel                          [1]";//26 ESPACIOS
        /*Matris posicion 4*/
        matrisTCan[1][3] = "  The Lead Sprinkler - John 5                   [5]";//19 ESPACIOS
        /*Matris posicion 5*/
        matrisTCan[1][4] = "  Aerials - System Of A Down                  [2]";//18 espacios
        /*Matris posicion 6*/
        matrisTCan[1][5] = "  Alive - P.O.D.                                             [3]";
        /*Matirs posicion 7*/
        matrisTCan[1][6] = "  Crawling In The Dark - Hoobastank     [3]";
        /*Matris posicion 8*/
        matrisTCan[1][7] = "  Reptiles - Command6                              [3]";
        /*Matris posicion 9*/
        matrisTCan[1][8] = "  Hypnotize - System Of A Down           [2]";//11 espacios
        /*Matris posicion 10*/
        matrisTCan[1][9] = "  The Day That Never Comes - Metallica     [3]";
        /*Matris posicion 11*/
        matrisTCan[1][10] = "  San Quentin - Nickelback                      [3]";
        /*Matris posicion 12*/
        matrisTCan[1][11] = "  Acid Rain - Liquid Tension E                   [4]";
        /*Matris posicion 13*/
        matrisTCan[1][12] = "  Get Free - The Vines                               [1]";
        /*Matris posicion 14*/
        matrisTCan[1][13] = "  The Damn Colony - Vávera                    [3]";
        /*Matris posicion 15*/
        matrisTCan[1][14] = "  Fuck Authority - Pennysise                    [3]";//20 ESPACIOS
        /*Matris posicion 16*/
        matrisTCan[1][15] = "  Valley Of The Damned - DragonF        [5]";//8 ESPACIOS
        /*Matris posicion 17*/
        matrisTCan[1][16] = "  Protect The Land - System Of A D      [3]";// 6 ESPACIOS
        /*Matris posicion 18*/
        matrisTCan[1][17] = "  Figure It Out - Royal Blood                    [2]";//20 ESPACIOS
        /*Matris posicion 19*/
        matrisTCan[1][18] = "  Enter Sandman - Metallica     [3]";
        /*Matris posicion 20*/
        matrisTCan[1][19] = "  I Want To Break Free - Queen             [2]";//13 ESPACIOS
        /*Matris posicion 21*/
        matrisTCan[1][20] = "  In My Dreams - Dokken                        [3]";//24 ESPACIOS
        /*Matris posicion 22*/
        matrisTCan[1][21] = "  Decadence - Disturbed                          [3]";//26 ESPACIOS
        /*Matris posicion 23*/
        matrisTCan[1][22] = "  Cry Thunder - DragonForce                   [4]";//19 espacios
        /*Matris posicion 24*/
        matrisTCan[1][23] = "  Spiders - System Of A Down                 [3]";//17 espacios
        /*Matris posicion 25*/
        matrisTCan[1][24] = "  Addicted To Pain - Alter Bridge            [3]";//12 espacios
        /*Matris posicion 26*/
        matrisTCan[1][25] = "  Heroes Of Our Time - DragonF             [5]";//13 espacios
        /*Matris posicion 27*/
        matrisTCan[1][26] = "  Sugar - System Of A Down                    [3]";//20 espacios 
        /*Matris posicion 28*/
        matrisTCan[1][27] = "  Christmas Truce - Sabaton     [3]";
        /*Matris posicion 29*/
        matrisTCan[1][28] = "  Tempesta Di Fuoco - R Of Fire             [4]";//13 espacios
        /*Matris posicion 30*/
        matrisTCan[1][29] = "  The Dying Song - Slipknot                    [3]";//20 espacios
        /*Matris posicion 31*/
        matrisTCan[1][30] = "  Throgh The Fire And Flames - DF         [6]";//9 espacios
        /*Matris posicion 32*/
        matrisTCan[1][31] = "  Flying Ehales - Gojira                               [4]";//31 espacios
        /*Matris posicion 33*/
        matrisTCan[1][32] = "  Self Esteem - The Offspring                 [3]";//17 espacios
        /*Matris posicion 34*/
        matrisTCan[1][33] = "  The Last In Line - Dio                              [3]";// 30 espacios
        /*Matris posicion 35*/
        matrisTCan[1][34] = "  Three Hammers - DragonForce           [4]";//11 espacios
        /*Matris posicion 36*/
        matrisTCan[1][35] = "  Parasite - Bullet For My Valentine       [4]";// 7 espacios
        /*Matris posicion 37*/
        matrisTCan[1][36] = "  You Only Live Once - The Strokes     [3]";
        /*Matris posicion 38*/
        matrisTCan[1][37] = "  Fury Of The Storm - DragonForce       [6]";//7 espacios
        /*Matris posicion 39*/
        matrisTCan[1][38] = "  Monsters - Motchbook Romance        [3]";// 8 espacios
        /*Matris posicion 40*/
        matrisTCan[1][39] = "  La Grange - ZZ Top                                  [3]";//34 espacios
        /*Matris posicion 41*/
        matrisTCan[1][40] = "  Operation Ground And Pound - DF     [6]";//5 espacios
        /*Matris posicion 42*/
        matrisTCan[1][41] = "  Hector's Hymn - Hammerfall               [4]";// 15 espacios
        /*Matris posicion 43*/
        matrisTCan[1][42] = "  Genocidal Humanoidz - SDown            [3]";//12 espacios
        /*Matris posicion 44*/
        matrisTCan[1][43] = "  Cry For Eternity - DragonForce             [6]";//13 espacios
        /*Matris posicion 45*/
        matrisTCan[1][44] = "  Extreme Power Metal - DragonF         [6]";// 9 espacios
        /*Matris posicion 46*/
        matrisTCan[1][45] = "  I-E-A-I-A-I-O - SDown                           [3]";//27 espacios
        /*Matris posicion 47*/
        matrisTCan[1][46] = "  Revolution Deathsquad - DragonF      [6]";// 6 espacios
        /*Matris posicion 48*/
        matrisTCan[1][47] = "  Not Gonna Die - Skillet                          [3]";// 26 espacios
        /*Matris posicion 49*/
        matrisTCan[1][48] = "  Deuce - Kiss                                              [3]";//46 espacios
        /*Matris posicion 50*/
        matrisTCan[1][49] = "  Polaris - Blue Encount     [3]";
        //Hasta aqui termina la segunda fila----------------------
        //Tercera fila
        /*Matris posicion 1*/
        matrisTCan[2][0] = "  Scars Of Yesterday - DragonForce     [6]";
        /*Matris posicion 2*/
        matrisTCan[2][1] = "  Empyreal - Sylosis     [5]";
        //**---------------------------------------------------------------------------------
        textField2.setText(matrisTCan[0][0]);
        textField3.setText(matrisTCan[0][1]);
        textField4.setText(matrisTCan[0][2]);
        textField5.setText(matrisTCan[0][3]);
        textField6.setText(matrisTCan[0][4]);
        textField7.setText(matrisTCan[0][5]);
        textField8.setText(matrisTCan[0][6]);
        textField9.setText(matrisTCan[0][7]);
        textField7.setText(matrisTCan[0][8]);
        //-----------------------------------------------------------------------------------
        /*//Hoja de la lista de canciones
        ImageIcon imagen2 = new ImageIcon("images/hojaDeCancionesLista.png");
        label2 = new JLabel(imagen2);
        label2.setBounds(5, 40, 332, 450);
        add(label2);*/
        //Fonde de la interfaz
        ImageIcon imagen = new ImageIcon("images/Fonde3.jpg");
        label1 = new JLabel(imagen);
        label1.setBounds(0, 0, 560, 520);
        add(label1);

    }

    @Override
    public void actionPerformed(ActionEvent evet) {

        //if que controla en movimiento a la derecha 
        if (evet.getSource() == boton2) {
            y = y + 1;
            metodoRellenoCanciones();
        }
        //if que controla el movimiento a la izquierda
        if (evet.getSource() == boton3) {
            y = y - 1;
            metodoRellenoCanciones();

        }
        //----------------------------------------------------------------------
        //canciones
        if (evet.getSource() == boton1) {
            if (evet.getSource() == boton1) {
                cancionBuscada = textField1.getText();
                metodoBuscarCancionSolicitada();

            } else {

                textField2.setText("La cancion solicitada no fue encontrada :(");
            }
        }

    }

    @Override
    public void stateChanged(ChangeEvent eve) {
        if (radio1.isSelected()) {

        }

        //---------------------
        if (radio2.isSelected()) {

            //metodos.metodoDificultad2();
        }

        //---------------------
        if (radio3.isSelected()) {

        }
        //----------------------
        if (radio4.isSelected()) {

        }
        //-----------------------
        if (radio5.isSelected()) {

        }
        if (radio6.isSelected()) {

        }
    }

    public void metodoBuscarCancionSolicitada() {
        //Lista de canciones donde se busca la cancion solicitada

        if (textField1.getText().isEmpty()) {
            //Hellish War
            if (cancionBuscada.equalsIgnoreCase("Son Of The King")) {
                textField2.setText(matrisTCan[0][1]);
                textField3.setText("");
                textField4.setText("");
                textField5.setText("");
                textField6.setText("");
                textField7.setText("");
                textField8.setText("");
                textField9.setText("");
            }
            if (cancionBuscada.equalsIgnoreCase("Destroyer")) {
                textField2.setText(matrisTCan[0][13]);

            }
            if (cancionBuscada.equalsIgnoreCase("Metal Forever")) {
                textField2.setText(matrisTCan[0][16]);
            }
            if (cancionBuscada.equalsIgnoreCase("Die For Glory")) {
                textField2.setText(matrisTCan[0][23]);
            }
            if (cancionBuscada.equalsIgnoreCase("Keep It Hellish")) {
                textField2.setText(matrisTCan[0][33]);
            }
            //System Of A Down
            if (cancionBuscada.equalsIgnoreCase("Lonely Day")) {
                textField2.setText(matrisTCan[0][0]);
            }
            if (cancionBuscada.equalsIgnoreCase("Toxicity")) {
                textField2.setText(matrisTCan[0][2]);
            }
            if (cancionBuscada.equalsIgnoreCase("B.Y.O.B")) {
                textField2.setText(matrisTCan[0][37]);
            }
            if (cancionBuscada.equalsIgnoreCase("Chop Suey")) {
                textField2.setText(matrisTCan[0][44]);
            }
            if (cancionBuscada.equalsIgnoreCase("Question")) {
                textField2.setText(matrisTCan[0][49]);
            }
            if (cancionBuscada.equalsIgnoreCase("Aerials")) {
                textField2.setText(matrisTCan[1][4]);
            }
            if (cancionBuscada.equalsIgnoreCase("Hypnotize")) {
                textField2.setText(matrisTCan[1][8]);
            }
            if (cancionBuscada.equalsIgnoreCase("Spiders")) {
                textField2.setText(matrisTCan[1][23]);
            }
            if (cancionBuscada.equalsIgnoreCase("Sugar")) {
                textField2.setText(matrisTCan[1][26]);
            }
            if (cancionBuscada.equalsIgnoreCase("Genocidal Humanoidz")) {
                textField2.setText(matrisTCan[1][42]);
            }
            if (cancionBuscada.equalsIgnoreCase("I-E-A-I-A-I-O")) {
                textField2.setText(matrisTCan[1][45]);
            }
            //Royal Blood
            if (cancionBuscada.equalsIgnoreCase("Figure It Out")) {
                textField2.setText(matrisTCan[0][3]);
            }
            //My C Romance
            if (cancionBuscada.equalsIgnoreCase("Famous Last Words")) {
                textField2.setText(matrisTCan[0][4]);
            }
            //Ramones
            if (cancionBuscada.equalsIgnoreCase("Pet Sematary")) {
                textField2.setText(matrisTCan[0][5]);
            }
            //Scars On Broadway
            if (cancionBuscada.equalsIgnoreCase("They Say")) {
                textField2.setText(matrisTCan[0][6]);
            }
            if (cancionBuscada.equalsIgnoreCase("Dr. Feelgood")) {
                textField2.setText(matrisTCan[0][28]);
            }
            //Galneryus
            if (cancionBuscada.equalsIgnoreCase("Wings Of Justice")) {
                textField2.setText(matrisTCan[0][8]);
            }
            //Aerosmith
            if (cancionBuscada.equalsIgnoreCase("Livin On The Edge")) {
                textField2.setText(matrisTCan[0][9]);
            }
            //Motley Crue
            if (cancionBuscada.equalsIgnoreCase("Kickstart My Heart")) {
                textField2.setText(matrisTCan[0][7]);
            }
            if (cancionBuscada.equalsIgnoreCase("Dr. Feelgood ")) {
                textField2.setText(matrisTCan[0][28]);
            }
            // Knocked L
            if (cancionBuscada.equalsIgnoreCase("Mistakes Like Fractures")) {
                textField2.setText(matrisTCan[0][10]);
            }
            //Velvet Revolvet
            if (cancionBuscada.equalsIgnoreCase("Slither")) {
                textField2.setText(matrisTCan[0][11]);
            }
            //I M
            if (cancionBuscada.equalsIgnoreCase("Rime Of The Ancient Mariner")) {
                textField2.setText(matrisTCan[0][12]);
            }
            //Dragon Force
            if (cancionBuscada.equalsIgnoreCase("Soldiers Of The Wasteland")) {
                textField2.setText(matrisTCan[0][17]);
            }
            if (cancionBuscada.equalsIgnoreCase("Highway To Oblivion")) {
                textField2.setText(matrisTCan[0][27]);
            }
            //Noturnall 
            if (cancionBuscada.equalsIgnoreCase("Reset The Game")) {
                textField2.setText(matrisTCan[0][15]);
            }
            //Metallica
            if (cancionBuscada.equalsIgnoreCase("Lux Eterna")) {
                textField2.setText(matrisTCan[0][18]);
            }
            if (cancionBuscada.equalsIgnoreCase("One")) {
                textField2.setText(matrisTCan[0][24]);
            }
            if (cancionBuscada.equalsIgnoreCase("All Nightmare Long")) {
                textField2.setText(matrisTCan[0][14]);
            }
            //Bring Me The Horizon
            if (cancionBuscada.equalsIgnoreCase("Sleepwaking")) {
                textField2.setText(matrisTCan[0][19]);
            }
            //Falling In Reverse
            if (cancionBuscada.equalsIgnoreCase("Zombified")) {
                textField2.setText(matrisTCan[0][20]);
            }
            //Beastie Boys
            if (cancionBuscada.equalsIgnoreCase("No Sleep Till Brooklyn")) {
                textField2.setText(matrisTCan[0][21]);
            }
            //BabyMetal
            if (cancionBuscada.equalsIgnoreCase("Akatsuki")) {
                textField2.setText(matrisTCan[0][22]);
            }
            //Polyphia 
            if (cancionBuscada.equalsIgnoreCase("Playing God")) {
                textField2.setText(matrisTCan[0][26]);
            }
            //Killswitch E
            if (cancionBuscada.equalsIgnoreCase("The Arms Of Sorrow")) {
                textField2.setText(matrisTCan[0][25]);
            }
            //Avenged Sevenfold
            if (cancionBuscada.equalsIgnoreCase("God Damn")) {
                textField2.setText(matrisTCan[0][29]);
            }
            //Faith No More 
            if (cancionBuscada.equalsIgnoreCase("Falling To Pieces")) {
                textField2.setText(matrisTCan[0][30]);
            }
            //Trivium
            if (cancionBuscada.equalsIgnoreCase("Into The Mouth Of H")) {
                textField2.setText(matrisTCan[0][35]);
            }
            //Electric Callboy
            if (cancionBuscada.equalsIgnoreCase("Hypa Hypa")) {
                textField2.setText(matrisTCan[0][34]);
            }
            //
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[0][41])) {
                textField2.setText(matrisTCan[0][41]);
            }
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[0][42])) {
                textField2.setText(matrisTCan[0][42]);
            }
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[0][43])) {
                textField2.setText(matrisTCan[0][43]);
            }
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[0][44])) {
                textField2.setText(matrisTCan[0][44]);
            }
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[0][45])) {
                textField2.setText(matrisTCan[0][45]);
            }
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[0][46])) {
                textField2.setText(matrisTCan[0][46]);
            }
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[0][47])) {
                textField2.setText(matrisTCan[0][47]);
            }
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[0][48])) {
                textField2.setText(matrisTCan[0][48]);
            }
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[0][49])) {
                textField2.setText(matrisTCan[0][49]);
            }
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[1][0])) {
                textField2.setText(matrisTCan[1][0]);
            }
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[1][1])) {
                textField2.setText(matrisTCan[1][1]);
            }
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[1][2])) {
                textField2.setText(matrisTCan[1][2]);
            }
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[1][3])) {
                textField2.setText(matrisTCan[1][3]);
            }
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[1][4])) {
                textField2.setText(matrisTCan[1][4]);
            }
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[1][5])) {
                textField2.setText(matrisTCan[1][5]);
            }
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[1][6])) {
                textField2.setText(matrisTCan[1][6]);
            }
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[1][7])) {
                textField2.setText(matrisTCan[1][7]);
            }
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[1][8])) {
                textField2.setText(matrisTCan[1][8]);
            }
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[1][9])) {
                textField2.setText(matrisTCan[1][9]);
            }
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[1][10])) {
                textField2.setText(matrisTCan[1][10]);
            }
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[1][11])) {
                textField2.setText(matrisTCan[1][11]);
            }
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[1][12])) {
                textField2.setText(matrisTCan[1][12]);
            }
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[1][13])) {
                textField2.setText(matrisTCan[1][13]);
            }
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[1][14])) {
                textField2.setText(matrisTCan[1][14]);
            }
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[1][15])) {
                textField2.setText(matrisTCan[1][15]);
            }
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[1][16])) {
                textField2.setText(matrisTCan[1][16]);
            }
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[1][17])) {
                textField2.setText(matrisTCan[1][17]);
            }
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[1][18])) {
                textField2.setText(matrisTCan[1][18]);
            }
            if (cancionBuscada.equalsIgnoreCase(matrisTCan[1][19])) {
                textField2.setText(matrisTCan[1][19]);
            }
        } else {
            textField2.setText("La cancion solicitada no fue encontrada :(");
        }
    }

    public void metodoRellenoCanciones() {
        //if q controla el movimiento de las canciones
        if (y == 0) {
            textField2.setText(matrisTCan[0][0]);
            textField3.setText(matrisTCan[0][1]);
            textField4.setText(matrisTCan[0][2]);
            textField5.setText(matrisTCan[0][3]);
            textField6.setText(matrisTCan[0][4]);
            textField7.setText(matrisTCan[0][5]);
            textField8.setText(matrisTCan[0][6]);
            textField9.setText(matrisTCan[0][7]);
            textField7.setText(matrisTCan[0][8]);

        }
        if (y == 1) {
            textField2.setText(matrisTCan[0][9]);
            textField3.setText(matrisTCan[0][10]);
            textField4.setText(matrisTCan[0][11]);
            textField5.setText(matrisTCan[0][12]);
            textField6.setText(matrisTCan[0][13]);
            textField7.setText(matrisTCan[0][14]);
            textField8.setText(matrisTCan[0][15]);
            textField9.setText(matrisTCan[0][16]);
            textField7.setText(matrisTCan[0][17]);

        }
        if (y == 2) {
            textField2.setText(matrisTCan[0][18]);
            textField3.setText(matrisTCan[0][19]);
            textField4.setText(matrisTCan[0][20]);
            textField5.setText(matrisTCan[0][21]);
            textField6.setText(matrisTCan[0][22]);
            textField7.setText(matrisTCan[0][23]);
            textField8.setText(matrisTCan[0][24]);
            textField9.setText(matrisTCan[0][25]);
            textField7.setText(matrisTCan[0][26]);

        }
        if (y == 3) {
            textField2.setText(matrisTCan[0][27]);
            textField3.setText(matrisTCan[0][28]);
            textField4.setText(matrisTCan[0][29]);
            textField5.setText(matrisTCan[0][30]);
            textField6.setText(matrisTCan[0][31]);
            textField7.setText(matrisTCan[0][32]);
            textField8.setText(matrisTCan[0][33]);
            textField9.setText(matrisTCan[0][34]);
            textField7.setText(matrisTCan[0][35]);

        }
        if (y == 4) {
            textField2.setText(matrisTCan[0][36]);
            textField3.setText(matrisTCan[0][37]);
            textField4.setText(matrisTCan[0][38]);
            textField5.setText(matrisTCan[0][39]);
            textField6.setText(matrisTCan[0][40]);
            textField7.setText(matrisTCan[0][41]);
            textField8.setText(matrisTCan[0][42]);
            textField9.setText(matrisTCan[0][43]);
            textField7.setText(matrisTCan[0][44]);

        }
        if (y == 5) {
            textField2.setText(matrisTCan[0][45]);
            textField3.setText(matrisTCan[0][46]);
            textField4.setText(matrisTCan[0][47]);
            textField5.setText(matrisTCan[0][48]);
            textField6.setText(matrisTCan[0][49]);
            textField7.setText(matrisTCan[1][0]);
            textField8.setText(matrisTCan[1][1]);
            textField9.setText(matrisTCan[1][2]);
            textField7.setText(matrisTCan[1][3]);

        }
        if (y == 6) {
            textField2.setText(matrisTCan[1][4]);
            textField3.setText(matrisTCan[1][5]);
            textField4.setText(matrisTCan[1][6]);
            textField5.setText(matrisTCan[1][7]);
            textField6.setText(matrisTCan[1][8]);
            textField7.setText(matrisTCan[1][9]);
            textField8.setText(matrisTCan[1][10]);
            textField9.setText(matrisTCan[1][11]);
            textField7.setText(matrisTCan[1][12]);

        }
        if (y == 7) {
            textField2.setText(matrisTCan[1][13]);
            textField3.setText(matrisTCan[1][14]);
            textField4.setText(matrisTCan[1][15]);
            textField5.setText(matrisTCan[1][16]);
            textField6.setText(matrisTCan[1][17]);
            textField7.setText(matrisTCan[1][18]);
            textField8.setText(matrisTCan[1][19]);
            textField9.setText(matrisTCan[1][20]);
            textField7.setText(matrisTCan[1][21]);

        }
        if (y == 8) {
            textField2.setText(matrisTCan[1][22]);
            textField3.setText(matrisTCan[1][23]);
            textField4.setText(matrisTCan[1][24]);
            textField5.setText(matrisTCan[1][25]);
            textField6.setText(matrisTCan[1][26]);
            textField7.setText(matrisTCan[1][27]);
            textField8.setText(matrisTCan[1][28]);
            textField9.setText(matrisTCan[1][29]);
            textField7.setText(matrisTCan[1][30]);

        }
        if (y == 9) {
            textField2.setText(matrisTCan[1][31]);
            textField3.setText(matrisTCan[1][32]);
            textField4.setText(matrisTCan[1][33]);
            textField5.setText(matrisTCan[1][34]);
            textField6.setText(matrisTCan[1][35]);
            textField7.setText(matrisTCan[1][36]);
            textField8.setText(matrisTCan[1][37]);
            textField9.setText(matrisTCan[1][38]);
            textField7.setText(matrisTCan[1][39]);

        }
        if (y == 10) {
            textField2.setText(matrisTCan[1][40]);
            textField3.setText(matrisTCan[1][41]);
            textField4.setText(matrisTCan[1][42]);
            textField5.setText(matrisTCan[1][43]);
            textField6.setText(matrisTCan[1][44]);
            textField7.setText(matrisTCan[1][45]);
            textField8.setText(matrisTCan[1][46]);
            textField9.setText(matrisTCan[1][47]);
            textField7.setText(matrisTCan[1][48]);

        }

    }

    public static void main(String[] args) {
        ProyectGuitars class1 = new ProyectGuitars();
        class1.setBounds(0, 0, 560, 545);
        class1.setResizable(false);
        class1.setVisible(true);
        class1.setLocationRelativeTo(null);

    }

    @Override
    public void itemStateChanged(ItemEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
