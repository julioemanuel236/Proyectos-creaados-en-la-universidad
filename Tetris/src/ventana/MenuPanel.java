package ventana;

import control.ControlVentana;
import control.VARIABLESGLOBALES;
import entidad.Puntaje;
import java.applet.AudioClip;
import java.awt.Container;

public class MenuPanel extends javax.swing.JPanel {

    /**
     * Creates new form MenuPanel
     */    
    ControlVentana controlVentana;
    
    public MenuPanel(ControlVentana controlVentana) {      
        this.controlVentana = controlVentana;
        VARIABLESGLOBALES.BACK_TO_MENU = false;
        initComponents();
        setSize(VARIABLESGLOBALES.WINDOWS_WIDTH,VARIABLESGLOBALES.WINDOWS_HEIGHT);        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        nombre1 = new javax.swing.JLabel();
        nombre2 = new javax.swing.JLabel();
        nombre3 = new javax.swing.JLabel();
        nombre4 = new javax.swing.JLabel();
        nombre5 = new javax.swing.JLabel();
        nombre6 = new javax.swing.JLabel();
        nombre7 = new javax.swing.JLabel();
        nombre8 = new javax.swing.JLabel();
        nombre9 = new javax.swing.JLabel();
        nombre10 = new javax.swing.JLabel();
        puntaje1 = new javax.swing.JLabel();
        puntaje2 = new javax.swing.JLabel();
        puntaje3 = new javax.swing.JLabel();
        puntaje4 = new javax.swing.JLabel();
        puntaje5 = new javax.swing.JLabel();
        puntaje6 = new javax.swing.JLabel();
        puntaje7 = new javax.swing.JLabel();
        puntaje8 = new javax.swing.JLabel();
        puntaje9 = new javax.swing.JLabel();
        puntaje10 = new javax.swing.JLabel();
        posicion1 = new javax.swing.JLabel();
        posicion2 = new javax.swing.JLabel();
        posicion3 = new javax.swing.JLabel();
        posicion4 = new javax.swing.JLabel();
        posicion5 = new javax.swing.JLabel();
        posicion6 = new javax.swing.JLabel();
        posicion7 = new javax.swing.JLabel();
        posicion8 = new javax.swing.JLabel();
        posicion9 = new javax.swing.JLabel();
        posicion10 = new javax.swing.JLabel();
        fondoLabel = new javax.swing.JLabel();

        setPreferredSize(new java.awt.Dimension(420, 600));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton2.setBackground(new java.awt.Color(78, 80, 81));
        jButton2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("SALIR");
        jButton2.setFocusable(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 490, 190, 90));

        jButton1.setBackground(new java.awt.Color(78, 80, 81));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("JUEGO NUEVO");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 490, 190, 90));

        nombre1.setBackground(new java.awt.Color(60, 63, 64));
        nombre1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nombre1.setForeground(new java.awt.Color(255, 255, 255));
        nombre1.setText("nombre 1");
        nombre1.setFocusable(false);
        nombre1.setOpaque(true);
        add(nombre1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 160, 160, 25));

        nombre2.setBackground(new java.awt.Color(60, 63, 64));
        nombre2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nombre2.setForeground(new java.awt.Color(255, 255, 255));
        nombre2.setText("nombre 2");
        nombre2.setFocusable(false);
        nombre2.setOpaque(true);
        add(nombre2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 190, 160, 25));

        nombre3.setBackground(new java.awt.Color(60, 63, 64));
        nombre3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nombre3.setForeground(new java.awt.Color(255, 255, 255));
        nombre3.setText("nombre 3");
        nombre3.setFocusable(false);
        nombre3.setOpaque(true);
        add(nombre3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 220, 160, 25));

        nombre4.setBackground(new java.awt.Color(60, 63, 64));
        nombre4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nombre4.setForeground(new java.awt.Color(255, 255, 255));
        nombre4.setText("nombre 4");
        nombre4.setFocusable(false);
        nombre4.setOpaque(true);
        add(nombre4, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 160, 25));

        nombre5.setBackground(new java.awt.Color(60, 63, 64));
        nombre5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nombre5.setForeground(new java.awt.Color(255, 255, 255));
        nombre5.setText("nombre 5");
        nombre5.setFocusable(false);
        nombre5.setOpaque(true);
        add(nombre5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 280, 160, 25));

        nombre6.setBackground(new java.awt.Color(60, 63, 64));
        nombre6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nombre6.setForeground(new java.awt.Color(255, 255, 255));
        nombre6.setText("nombre 6");
        nombre6.setFocusable(false);
        nombre6.setOpaque(true);
        add(nombre6, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 310, 160, 25));

        nombre7.setBackground(new java.awt.Color(60, 63, 64));
        nombre7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nombre7.setForeground(new java.awt.Color(255, 255, 255));
        nombre7.setText("nombre 7");
        nombre7.setFocusable(false);
        nombre7.setOpaque(true);
        add(nombre7, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 160, 25));

        nombre8.setBackground(new java.awt.Color(60, 63, 64));
        nombre8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nombre8.setForeground(new java.awt.Color(255, 255, 255));
        nombre8.setText("nombre 8");
        nombre8.setFocusable(false);
        nombre8.setOpaque(true);
        add(nombre8, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 370, 160, 25));

        nombre9.setBackground(new java.awt.Color(60, 63, 64));
        nombre9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nombre9.setForeground(new java.awt.Color(255, 255, 255));
        nombre9.setText("nombre 9");
        nombre9.setFocusable(false);
        nombre9.setOpaque(true);
        add(nombre9, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 160, 25));

        nombre10.setBackground(new java.awt.Color(60, 63, 64));
        nombre10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        nombre10.setForeground(new java.awt.Color(255, 255, 255));
        nombre10.setText("nombre 10");
        nombre10.setFocusable(false);
        nombre10.setOpaque(true);
        add(nombre10, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 430, 160, 25));

        puntaje1.setBackground(new java.awt.Color(60, 63, 64));
        puntaje1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        puntaje1.setForeground(new java.awt.Color(255, 255, 255));
        puntaje1.setText("puntos 1");
        puntaje1.setFocusable(false);
        puntaje1.setOpaque(true);
        add(puntaje1, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 160, 80, 25));

        puntaje2.setBackground(new java.awt.Color(60, 63, 64));
        puntaje2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        puntaje2.setForeground(new java.awt.Color(255, 255, 255));
        puntaje2.setText("puntos 2");
        puntaje2.setFocusable(false);
        puntaje2.setOpaque(true);
        add(puntaje2, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 190, 80, 25));

        puntaje3.setBackground(new java.awt.Color(60, 63, 64));
        puntaje3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        puntaje3.setForeground(new java.awt.Color(255, 255, 255));
        puntaje3.setText("puntos 3");
        puntaje3.setFocusable(false);
        puntaje3.setOpaque(true);
        add(puntaje3, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 220, 80, 25));

        puntaje4.setBackground(new java.awt.Color(60, 63, 64));
        puntaje4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        puntaje4.setForeground(new java.awt.Color(255, 255, 255));
        puntaje4.setText("puntos 4");
        puntaje4.setFocusable(false);
        puntaje4.setOpaque(true);
        add(puntaje4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 250, 80, 25));

        puntaje5.setBackground(new java.awt.Color(60, 63, 64));
        puntaje5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        puntaje5.setForeground(new java.awt.Color(255, 255, 255));
        puntaje5.setText("puntos 5");
        puntaje5.setFocusable(false);
        puntaje5.setOpaque(true);
        add(puntaje5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, 80, 25));

        puntaje6.setBackground(new java.awt.Color(60, 63, 64));
        puntaje6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        puntaje6.setForeground(new java.awt.Color(255, 255, 255));
        puntaje6.setText("puntos 6");
        puntaje6.setFocusable(false);
        puntaje6.setOpaque(true);
        add(puntaje6, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 310, 80, 25));

        puntaje7.setBackground(new java.awt.Color(60, 63, 64));
        puntaje7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        puntaje7.setForeground(new java.awt.Color(255, 255, 255));
        puntaje7.setText("puntos 7");
        puntaje7.setFocusable(false);
        puntaje7.setOpaque(true);
        add(puntaje7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 340, 80, 25));

        puntaje8.setBackground(new java.awt.Color(60, 63, 64));
        puntaje8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        puntaje8.setForeground(new java.awt.Color(255, 255, 255));
        puntaje8.setText("puntos 8");
        puntaje8.setFocusable(false);
        puntaje8.setOpaque(true);
        add(puntaje8, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 370, 80, 25));

        puntaje9.setBackground(new java.awt.Color(60, 63, 64));
        puntaje9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        puntaje9.setForeground(new java.awt.Color(255, 255, 255));
        puntaje9.setText("puntos 9");
        puntaje9.setFocusable(false);
        puntaje9.setOpaque(true);
        add(puntaje9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 400, 80, 25));

        puntaje10.setBackground(new java.awt.Color(60, 63, 64));
        puntaje10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        puntaje10.setForeground(new java.awt.Color(255, 255, 255));
        puntaje10.setText("puntos 10");
        puntaje10.setFocusable(false);
        puntaje10.setOpaque(true);
        add(puntaje10, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 430, 80, 25));

        posicion1.setBackground(new java.awt.Color(60, 63, 64));
        posicion1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        posicion1.setForeground(new java.awt.Color(255, 255, 255));
        posicion1.setText("1");
        posicion1.setFocusable(false);
        posicion1.setOpaque(true);
        add(posicion1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 160, 30, 25));

        posicion2.setBackground(new java.awt.Color(60, 63, 64));
        posicion2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        posicion2.setForeground(new java.awt.Color(255, 255, 255));
        posicion2.setText("2");
        posicion2.setFocusable(false);
        posicion2.setOpaque(true);
        add(posicion2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 190, 30, 25));

        posicion3.setBackground(new java.awt.Color(60, 63, 64));
        posicion3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        posicion3.setForeground(new java.awt.Color(255, 255, 255));
        posicion3.setText("3");
        posicion3.setFocusable(false);
        posicion3.setOpaque(true);
        add(posicion3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 220, 30, 25));

        posicion4.setBackground(new java.awt.Color(60, 63, 64));
        posicion4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        posicion4.setForeground(new java.awt.Color(255, 255, 255));
        posicion4.setText("4");
        posicion4.setFocusable(false);
        posicion4.setOpaque(true);
        add(posicion4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, 30, 25));

        posicion5.setBackground(new java.awt.Color(60, 63, 64));
        posicion5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        posicion5.setForeground(new java.awt.Color(255, 255, 255));
        posicion5.setText("5");
        posicion5.setFocusable(false);
        posicion5.setOpaque(true);
        add(posicion5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 30, 25));

        posicion6.setBackground(new java.awt.Color(60, 63, 64));
        posicion6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        posicion6.setForeground(new java.awt.Color(255, 255, 255));
        posicion6.setText("6");
        posicion6.setFocusable(false);
        posicion6.setOpaque(true);
        add(posicion6, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 310, 30, 25));

        posicion7.setBackground(new java.awt.Color(60, 63, 64));
        posicion7.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        posicion7.setForeground(new java.awt.Color(255, 255, 255));
        posicion7.setText("7");
        posicion7.setFocusable(false);
        posicion7.setOpaque(true);
        add(posicion7, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 340, 30, 25));

        posicion8.setBackground(new java.awt.Color(60, 63, 64));
        posicion8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        posicion8.setForeground(new java.awt.Color(255, 255, 255));
        posicion8.setText("8");
        posicion8.setFocusable(false);
        posicion8.setOpaque(true);
        add(posicion8, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 370, 30, 25));

        posicion9.setBackground(new java.awt.Color(60, 63, 64));
        posicion9.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        posicion9.setForeground(new java.awt.Color(255, 255, 255));
        posicion9.setText("9");
        posicion9.setFocusable(false);
        posicion9.setOpaque(true);
        add(posicion9, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 400, 30, 25));

        posicion10.setBackground(new java.awt.Color(60, 63, 64));
        posicion10.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        posicion10.setForeground(new java.awt.Color(255, 255, 255));
        posicion10.setText("10");
        posicion10.setFocusable(false);
        posicion10.setOpaque(true);
        add(posicion10, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 430, 30, 25));

        fondoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/fondoTetris.png"))); // NOI18N
        fondoLabel.setToolTipText("");
        add(fondoLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 460, -1));
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                controlVentana.mostrarPartida();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    
    public void actualizarTablaPuntajes(Puntaje[] puntajes){
        int pos = 0;
        if(puntajes[pos] != null){
            nombre1.setText(puntajes[pos].getNombre());
            puntaje1.setText(String.valueOf(puntajes[pos].getPuntaje()));
            pos++;
        }
        if(puntajes[pos] != null){
            nombre2.setText(puntajes[pos].getNombre());
            puntaje2.setText(String.valueOf(puntajes[pos].getPuntaje()));
            pos++;
        }
        if(puntajes[pos] != null){
            nombre3.setText(puntajes[pos].getNombre());
            puntaje3.setText(String.valueOf(puntajes[pos].getPuntaje()));
            pos++;
        }
        if(puntajes[pos] != null){
            nombre4.setText(puntajes[pos].getNombre());
            puntaje4.setText(String.valueOf(puntajes[pos].getPuntaje()));
            pos++;
        }
        if(puntajes[pos] != null){
            nombre5.setText(puntajes[pos].getNombre());
            puntaje5.setText(String.valueOf(puntajes[pos].getPuntaje()));
            pos++;
        }
        if(puntajes[pos] != null){
            nombre6.setText(puntajes[pos].getNombre());
            puntaje6.setText(String.valueOf(puntajes[pos].getPuntaje()));
            pos++;
        }
        if(puntajes[pos] != null){
            nombre7.setText(puntajes[pos].getNombre());
            puntaje7.setText(String.valueOf(puntajes[pos].getPuntaje()));
            pos++;
        }
        if(puntajes[pos] != null){
            nombre8.setText(puntajes[pos].getNombre());
            puntaje8.setText(String.valueOf(puntajes[pos].getPuntaje()));
            pos++;
        }
        if(puntajes[pos] != null){
            nombre9.setText(puntajes[pos].getNombre());
            puntaje9.setText(String.valueOf(puntajes[pos].getPuntaje()));
            pos++;
        }
        if(puntajes[pos] != null){
            nombre10.setText(puntajes[pos].getNombre());
            puntaje10.setText(String.valueOf(puntajes[pos].getPuntaje()));
            pos++;
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel fondoLabel;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel nombre1;
    private javax.swing.JLabel nombre10;
    private javax.swing.JLabel nombre2;
    private javax.swing.JLabel nombre3;
    private javax.swing.JLabel nombre4;
    private javax.swing.JLabel nombre5;
    private javax.swing.JLabel nombre6;
    private javax.swing.JLabel nombre7;
    private javax.swing.JLabel nombre8;
    private javax.swing.JLabel nombre9;
    private javax.swing.JLabel posicion1;
    private javax.swing.JLabel posicion10;
    private javax.swing.JLabel posicion2;
    private javax.swing.JLabel posicion3;
    private javax.swing.JLabel posicion4;
    private javax.swing.JLabel posicion5;
    private javax.swing.JLabel posicion6;
    private javax.swing.JLabel posicion7;
    private javax.swing.JLabel posicion8;
    private javax.swing.JLabel posicion9;
    private javax.swing.JLabel puntaje1;
    private javax.swing.JLabel puntaje10;
    private javax.swing.JLabel puntaje2;
    private javax.swing.JLabel puntaje3;
    private javax.swing.JLabel puntaje4;
    private javax.swing.JLabel puntaje5;
    private javax.swing.JLabel puntaje6;
    private javax.swing.JLabel puntaje7;
    private javax.swing.JLabel puntaje8;
    private javax.swing.JLabel puntaje9;
    // End of variables declaration//GEN-END:variables
}
