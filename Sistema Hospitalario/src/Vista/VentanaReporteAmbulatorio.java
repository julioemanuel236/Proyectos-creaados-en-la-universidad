/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;
import Modelo.ClaseFecha;
import Modelo.ClaseHora;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.util.ArrayList;
import Modelo.ClaseRecetas;
import Modelo.ClaseReporteConsulta;
/**
 *
 * @author sinai
 */
public class VentanaReporteAmbulatorio extends javax.swing.JFrame {
    
    /**
     * Creates new form VentanaReporteAmbulatorio
     */
    
    static ClaseReporteConsulta reporteConsulta;
    static int hora;
    static int minutos;
    static int dia;
    static int mes;
    static int anio;
    static String motivo;
    static String observacion;
    
    FondoPanel fondo = new FondoPanel();//Visualizar fondo de panel
    
    public VentanaReporteAmbulatorio() {
        this.setContentPane(fondo);//Visualizar fondo de panel
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        PanelAmbulatorio2 = new FondoPanel();
        lbTituloVRegistro = new javax.swing.JLabel();
        lbFechaReporteAmbulatorio = new javax.swing.JLabel();
        lbObservaciónReporteAmbulatorio = new javax.swing.JLabel();
        lbMotivReporteAmbulatorio = new javax.swing.JLabel();
        lbDiaAmbulatorio = new javax.swing.JLabel();
        lbMesAmbulatorio = new javax.swing.JLabel();
        lbAnioAmbulatorio = new javax.swing.JLabel();
        lbHoraAmbulatorio = new javax.swing.JLabel();
        lbMinutoAmbulatorio = new javax.swing.JLabel();
        btnSeguir2 = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        txtDia = new javax.swing.JTextField();
        txtMes = new javax.swing.JTextField();
        txtAnio = new javax.swing.JTextField();
        txtHora = new javax.swing.JTextField();
        txtMinutos = new javax.swing.JTextField();
        txtMotivo = new javax.swing.JTextField();
        txtObservacion = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbTituloVRegistro.setFont(new java.awt.Font("Arial Narrow", 1, 34)); // NOI18N
        lbTituloVRegistro.setText("Reporte Ambulatorio:");

        lbFechaReporteAmbulatorio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbFechaReporteAmbulatorio.setText("Fecha:");

        lbObservaciónReporteAmbulatorio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbObservaciónReporteAmbulatorio.setText("Observación: ");

        lbMotivReporteAmbulatorio.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbMotivReporteAmbulatorio.setText("Motivo de cosulta: ");

        lbDiaAmbulatorio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbDiaAmbulatorio.setText("Día:");

        lbMesAmbulatorio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbMesAmbulatorio.setText("Mes:");

        lbAnioAmbulatorio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbAnioAmbulatorio.setText("Año:");

        lbHoraAmbulatorio.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbHoraAmbulatorio.setText("Hora:");

        lbMinutoAmbulatorio.setText("Minuto:");

        btnSeguir2.setBackground(new java.awt.Color(0, 153, 153));
        btnSeguir2.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        btnSeguir2.setText("Siguiente");
        btnSeguir2.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btnSeguir2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeguir2ActionPerformed(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(255, 0, 51));
        btnRegresar.setFont(new java.awt.Font("Helvetica Neue", 1, 20)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        txtHora.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoraActionPerformed(evt);
            }
        });

        txtMotivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMotivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelAmbulatorio2Layout = new javax.swing.GroupLayout(PanelAmbulatorio2);
        PanelAmbulatorio2.setLayout(PanelAmbulatorio2Layout);
        PanelAmbulatorio2Layout.setHorizontalGroup(
            PanelAmbulatorio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAmbulatorio2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelAmbulatorio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAmbulatorio2Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(btnRegresar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 225, Short.MAX_VALUE)
                        .addComponent(btnSeguir2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(PanelAmbulatorio2Layout.createSequentialGroup()
                        .addGroup(PanelAmbulatorio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbTituloVRegistro)
                            .addGroup(PanelAmbulatorio2Layout.createSequentialGroup()
                                .addGroup(PanelAmbulatorio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelAmbulatorio2Layout.createSequentialGroup()
                                        .addGap(6, 6, 6)
                                        .addComponent(lbFechaReporteAmbulatorio)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(lbDiaAmbulatorio))
                                    .addComponent(lbHoraAmbulatorio, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(PanelAmbulatorio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtHora, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE)
                                    .addComponent(txtDia))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelAmbulatorio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbMesAmbulatorio)
                                    .addComponent(lbMinutoAmbulatorio))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelAmbulatorio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMes, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                    .addComponent(txtMinutos))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbAnioAmbulatorio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(PanelAmbulatorio2Layout.createSequentialGroup()
                .addGroup(PanelAmbulatorio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbMotivReporteAmbulatorio)
                    .addGroup(PanelAmbulatorio2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbObservaciónReporteAmbulatorio)))
                .addGap(18, 18, 18)
                .addGroup(PanelAmbulatorio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 283, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 255, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        PanelAmbulatorio2Layout.setVerticalGroup(
            PanelAmbulatorio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelAmbulatorio2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbTituloVRegistro, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(PanelAmbulatorio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAmbulatorio2Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addGroup(PanelAmbulatorio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbMesAmbulatorio)
                            .addGroup(PanelAmbulatorio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(lbAnioAmbulatorio)
                                .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(PanelAmbulatorio2Layout.createSequentialGroup()
                        .addGroup(PanelAmbulatorio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbFechaReporteAmbulatorio)
                            .addComponent(lbDiaAmbulatorio)
                            .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24)
                        .addGroup(PanelAmbulatorio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbHoraAmbulatorio)
                            .addComponent(txtHora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbMinutoAmbulatorio)
                            .addComponent(txtMinutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(PanelAmbulatorio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbMotivReporteAmbulatorio)
                    .addComponent(txtMotivo, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(PanelAmbulatorio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelAmbulatorio2Layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addComponent(btnSeguir2, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelAmbulatorio2Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(PanelAmbulatorio2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbObservaciónReporteAmbulatorio)
                            .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(25, 25, 25)
                        .addComponent(btnRegresar)
                        .addGap(18, 18, 18))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelAmbulatorio2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelAmbulatorio2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new VentanaRegistroAmbulatorio().setVisible(true);
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnSeguir2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeguir2ActionPerformed
        // TODO add your handling code here:
        
        try{ 
            this.hora = Integer.parseInt(this.txtHora.getText());
            this.minutos = Integer.parseInt(this.txtMinutos.getText());
            
            ClaseHora hora1 = new ClaseHora(this.hora, minutos);
            
            this.dia = Integer.parseInt(this.txtDia.getText());
            this.anio = Integer.parseInt(this.txtDia.getText());
            this.mes = Integer.parseInt(this.txtMes.getText());
            
            ClaseFecha fecha1 = new ClaseFecha(this.dia, this.mes, this.anio);
            
            this.motivo = this.txtMotivo.getText();
            this.observacion = this.txtObservacion.getText();
            
            if (fecha1.getDia() == 0 || fecha1.getAnio() == 0 || fecha1.getMes() == 0 || hora1.getHora() == 0 || hora1.getMinutos() == 0){
                JOptionPane.showMessageDialog(rootPane, "Registo no válido en la fecha u horario");
            }
            else{
            
                //Crear lista de recetas propia del objeto Paciente consulta
                ArrayList<ClaseRecetas> listaRecetas  = new ArrayList();

                //Instancia para el reporte de tipo consulta
                this.reporteConsulta = new ClaseReporteConsulta(this.motivo, listaRecetas, fecha1, hora1, this.observacion);

                //Agregar reporte a la lista de reportes del paciente de tipo consulta
                VentanaRegistroAmbulatorio.pacienteConsulta.getListaReportes().add(reporteConsulta);

                this.dispose();
                new Receta().setVisible(true);
            }
       }
       catch(ClassCastException e1){
            JOptionPane.showMessageDialog(rootPane, "Tipo de dato incorrecto");
        }
        catch(NumberFormatException e2){
            JOptionPane.showMessageDialog(rootPane, "Tipo de dato incorrecto");
        }
    }//GEN-LAST:event_btnSeguir2ActionPerformed

    private void txtMotivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMotivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMotivoActionPerformed

    private void txtHoraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoraActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtHoraActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(VentanaReporteAmbulatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaReporteAmbulatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaReporteAmbulatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaReporteAmbulatorio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaReporteAmbulatorio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelAmbulatorio2;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSeguir2;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JLabel lbAnioAmbulatorio;
    private javax.swing.JLabel lbDiaAmbulatorio;
    private javax.swing.JLabel lbFechaReporteAmbulatorio;
    private javax.swing.JLabel lbHoraAmbulatorio;
    private javax.swing.JLabel lbMesAmbulatorio;
    private javax.swing.JLabel lbMinutoAmbulatorio;
    private javax.swing.JLabel lbMotivReporteAmbulatorio;
    private javax.swing.JLabel lbObservaciónReporteAmbulatorio;
    private javax.swing.JLabel lbTituloVRegistro;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtHora;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextField txtMinutos;
    private javax.swing.JTextField txtMotivo;
    private javax.swing.JTextField txtObservacion;
    // End of variables declaration//GEN-END:variables

    //Visualizar el fondo
    class FondoPanel extends JPanel { //Visualizar fondo en la ventana
        private Image imagen;
        
        @Override
        public void paint(Graphics g){
            imagen = new ImageIcon(getClass().getResource("/Imagenes/3.png")).getImage();
            g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);
            super.paint(g);
        }
    }
}
