package ventana;

import control.ControlVentana;
import java.awt.Component;

public class RegistroNombrePanel extends javax.swing.JPanel {

    /**
     * Creates new form RegistroNombrePanel
     */
    ControlVentana controlVentana;
    public RegistroNombrePanel(ControlVentana controlVentana) {
        this.controlVentana = controlVentana;
        initComponents();
        setSize(400,300);        
    }

    
    public void reset(){
        jTextField1.setText("TU NOMBRE");
    }

    public String getRegistro(){
        return jTextField1.getText();
    }
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();

        setBackground(new java.awt.Color(60, 63, 64));
        setLayout(null);

        jButton1.setBackground(new java.awt.Color(78, 80, 81));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("ACEPTAR");
        jButton1.setFocusable(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        add(jButton1);
        jButton1.setBounds(69, 179, 250, 89);

        jTextField1.setBackground(new java.awt.Color(70, 73, 74));
        jTextField1.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        jTextField1.setForeground(new java.awt.Color(255, 255, 255));
        jTextField1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField1.setText("TU NOMBRE");
        add(jTextField1);
        jTextField1.setBounds(27, 44, 344, 87);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        controlVentana.registrarPuntaje(getRegistro());        
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}