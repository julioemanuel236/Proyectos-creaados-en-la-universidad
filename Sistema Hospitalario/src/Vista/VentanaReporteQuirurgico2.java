/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Vista;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JOptionPane;
import Modelo.ClaseReporteQuirurjico;
import Modelo.ClaseHora;
import Modelo.ClaseFecha;
import Modelo.ClaseRecetas;
import java.util.ArrayList;

/**
 *
 * @author sinai
 */
public class VentanaReporteQuirurgico2 extends javax.swing.JFrame {
    static ClaseReporteQuirurjico reporteQuirurjico;
    static int complejidad;
    static int avanceEnfermedad;
    static String observacion;
    static String operacion;
    static String proceso;
 

    
    
    /**
     * Creates new form VentanaReporteQuirurgico2
     */
    FondoPanel fondo = new FondoPanel();//Visualizar fondo de panel
    
    public VentanaReporteQuirurgico2() {
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

        PanelQururgico3 = new FondoPanel();
        lbTituloVReporteQ2 = new javax.swing.JLabel();
        lbCirugiaQ2 = new javax.swing.JLabel();
        lbProcesoReporteQ2 = new javax.swing.JLabel();
        lbInicioReporteQ2 = new javax.swing.JLabel();
        lbFechaReporteQ1 = new javax.swing.JLabel();
        lbHoraInicioQ2 = new javax.swing.JLabel();
        lbHoraFinalQ2 = new javax.swing.JLabel();
        lbMinutosFinalQ2 = new javax.swing.JLabel();
        lbMinutosInicioQ2 = new javax.swing.JLabel();
        lbComplejidadQ2 = new javax.swing.JLabel();
        btnSeguir3Q = new javax.swing.JButton();
        btnRegresar = new javax.swing.JButton();
        lbRecuperacion = new javax.swing.JLabel();
        lbObservacion = new javax.swing.JLabel();
        txtCirugia = new javax.swing.JTextField();
        txtComplejidad = new javax.swing.JTextField();
        txtProceso = new javax.swing.JTextField();
        txtHoraInicio = new javax.swing.JTextField();
        txtMinutosInicio = new javax.swing.JTextField();
        txtHoraSalida = new javax.swing.JTextField();
        txtMinutosSalida = new javax.swing.JTextField();
        txtAvanceEnfermedad = new javax.swing.JTextField();
        txtObservacion = new javax.swing.JTextField();
        lbHoraFinalQ3 = new javax.swing.JLabel();
        lbInicioReporteQ3 = new javax.swing.JLabel();
        lbDia = new javax.swing.JLabel();
        lbMes = new javax.swing.JLabel();
        lbAnio = new javax.swing.JLabel();
        txtDia = new javax.swing.JTextField();
        txtMes = new javax.swing.JTextField();
        txtAnio = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lbTituloVReporteQ2.setFont(new java.awt.Font("Arial Narrow", 1, 34)); // NOI18N
        lbTituloVReporteQ2.setText("Reporte Quirúrgico:");

        lbCirugiaQ2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbCirugiaQ2.setText("Cirugía:");

        lbProcesoReporteQ2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbProcesoReporteQ2.setText("Proceso:");

        lbInicioReporteQ2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbInicioReporteQ2.setText("Fecha:");

        lbFechaReporteQ1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbFechaReporteQ1.setText("Final:");

        lbHoraInicioQ2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbHoraInicioQ2.setText("Hora:");

        lbHoraFinalQ2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbHoraFinalQ2.setText("Hora:");

        lbMinutosFinalQ2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbMinutosFinalQ2.setText("Minuto:");

        lbMinutosInicioQ2.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbMinutosInicioQ2.setText("Minuto:");

        lbComplejidadQ2.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbComplejidadQ2.setText("Complejidad:");

        btnSeguir3Q.setBackground(new java.awt.Color(0, 153, 153));
        btnSeguir3Q.setFont(new java.awt.Font("Maiandra GD", 1, 18)); // NOI18N
        btnSeguir3Q.setText("Siguiente");
        btnSeguir3Q.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        btnSeguir3Q.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSeguir3QActionPerformed(evt);
            }
        });

        btnRegresar.setBackground(new java.awt.Color(255, 0, 0));
        btnRegresar.setFont(new java.awt.Font("Malayalam MN", 1, 20)); // NOI18N
        btnRegresar.setText("Regresar");
        btnRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRegresarActionPerformed(evt);
            }
        });

        lbRecuperacion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbRecuperacion.setText("Avance Enfermedad");

        lbObservacion.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbObservacion.setText("Obervación: ");

        txtCirugia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCirugiaActionPerformed(evt);
            }
        });

        txtProceso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtProcesoActionPerformed(evt);
            }
        });

        lbHoraFinalQ3.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        lbHoraFinalQ3.setText("Hora:");

        lbInicioReporteQ3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        lbInicioReporteQ3.setText("Inicio:");

        lbDia.setText("Dia:");

        lbMes.setText("Mes:");

        lbAnio.setText("Año:");

        javax.swing.GroupLayout PanelQururgico3Layout = new javax.swing.GroupLayout(PanelQururgico3);
        PanelQururgico3.setLayout(PanelQururgico3Layout);
        PanelQururgico3Layout.setHorizontalGroup(
            PanelQururgico3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelQururgico3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelQururgico3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PanelQururgico3Layout.createSequentialGroup()
                        .addComponent(lbCirugiaQ2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbComplejidadQ2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtComplejidad))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelQururgico3Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(PanelQururgico3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelQururgico3Layout.createSequentialGroup()
                                .addComponent(btnRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(417, 417, 417))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelQururgico3Layout.createSequentialGroup()
                                .addComponent(lbProcesoReporteQ2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(PanelQururgico3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelQururgico3Layout.createSequentialGroup()
                                        .addComponent(lbDia)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbMes)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(lbAnio)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14))))
                    .addGroup(PanelQururgico3Layout.createSequentialGroup()
                        .addGroup(PanelQururgico3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PanelQururgico3Layout.createSequentialGroup()
                                .addGap(73, 73, 73)
                                .addComponent(lbHoraInicioQ2)
                                .addGap(134, 134, 134)
                                .addGroup(PanelQururgico3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelQururgico3Layout.createSequentialGroup()
                                        .addGap(70, 70, 70)
                                        .addComponent(btnSeguir3Q, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(PanelQururgico3Layout.createSequentialGroup()
                                        .addGroup(PanelQururgico3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(lbMinutosInicioQ2)
                                            .addComponent(lbMinutosFinalQ2))
                                        .addGap(18, 18, 18)
                                        .addGroup(PanelQururgico3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtMinutosSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtMinutosInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(PanelQururgico3Layout.createSequentialGroup()
                                .addComponent(lbObservacion)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 405, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbTituloVReporteQ2)
                            .addGroup(PanelQururgico3Layout.createSequentialGroup()
                                .addGroup(PanelQururgico3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(PanelQururgico3Layout.createSequentialGroup()
                                        .addGroup(PanelQururgico3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbInicioReporteQ3)
                                            .addComponent(lbFechaReporteQ1))
                                        .addGap(12, 12, 12)
                                        .addGroup(PanelQururgico3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbHoraFinalQ2)
                                            .addComponent(lbHoraFinalQ3))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(PanelQururgico3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(txtHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(lbRecuperacion))
                                .addGap(18, 18, 18)
                                .addComponent(txtAvanceEnfermedad, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(lbInicioReporteQ2))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        PanelQururgico3Layout.setVerticalGroup(
            PanelQururgico3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelQururgico3Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(lbTituloVReporteQ2, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PanelQururgico3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCirugiaQ2)
                    .addComponent(lbComplejidadQ2)
                    .addComponent(txtCirugia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtComplejidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(PanelQururgico3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbProcesoReporteQ2)
                    .addGroup(PanelQururgico3Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(txtProceso, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(PanelQururgico3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbInicioReporteQ2)
                    .addComponent(lbDia)
                    .addComponent(lbMes)
                    .addComponent(lbAnio)
                    .addComponent(txtDia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAnio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(PanelQururgico3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMinutosInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMinutosInicioQ2)
                    .addComponent(txtHoraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbHoraFinalQ3)
                    .addComponent(lbInicioReporteQ3))
                .addGap(18, 18, 18)
                .addGroup(PanelQururgico3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbFechaReporteQ1)
                    .addComponent(txtHoraSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbHoraFinalQ2)
                    .addComponent(txtMinutosSalida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbMinutosFinalQ2, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelQururgico3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbRecuperacion)
                    .addComponent(txtAvanceEnfermedad, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(PanelQururgico3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelQururgico3Layout.createSequentialGroup()
                        .addGroup(PanelQururgico3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbObservacion)
                            .addComponent(txtObservacion, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PanelQururgico3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRegresar)
                            .addComponent(btnSeguir3Q, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelQururgico3Layout.createSequentialGroup()
                        .addComponent(lbHoraInicioQ2)
                        .addGap(18, 18, 18))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelQururgico3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelQururgico3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 70, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRegresarActionPerformed
        // TODO add your handling code here:
        
        try{
            //Atributos del reporte quirurgico:
            this.operacion = this.txtCirugia.getText();
            this.proceso = this.txtProceso.getText();
            this.observacion = this.txtObservacion.getText();
            this.complejidad = Integer.parseInt(this.txtComplejidad.getText());
            this.avanceEnfermedad = Integer.parseInt(this.txtAvanceEnfermedad.getText());
            
            //Establecer fecha de la operación:
            
            ClaseFecha fecha1 = new ClaseFecha(Integer.parseInt(this.txtDia.getText()), Integer.parseInt(this.txtMes.getText()), Integer.parseInt(this.txtAnio.getText()));
            
            //Establecer hora de entrada y salida del quirófano:
            
            ClaseHora hora1 = new ClaseHora(Integer.parseInt(this.txtHoraInicio.getText()), Integer.parseInt(this.txtMinutosInicio.getText()));
            
            ClaseHora hora2 = new ClaseHora(Integer.parseInt(this.txtHoraSalida.getText()), Integer.parseInt(this.txtMinutosSalida.getText()));
            
            if (fecha1.getDia() == 0 || fecha1.getAnio() == 0 || fecha1.getMes() == 0 || hora1.getHora() == 0 || hora1.getMinutos() == 0 || hora2.getHora() == 0 || hora1.getHora() == 0){
                JOptionPane.showMessageDialog(rootPane, "Registo no válido en la fecha u horario");
            }
            else{
                //Crear lista de recetas para el reporte:
                ArrayList<ClaseRecetas> listaRecetas = new ArrayList();

                //Crear objeto de reporte quirurjico:
                this.reporteQuirurjico = new ClaseReporteQuirurjico(this.operacion, this.proceso, this.complejidad, hora2, this.avanceEnfermedad, listaRecetas,fecha1, hora1, this.observacion);

                //Agregar reporte a la lista de reportes del paciente hospitalizado:
                VentanaRegistroInterno.pacienteHospitalizado.getListaReportes().add(reporteQuirurjico);

                this.dispose();
                new VentanaReporteInterno().setVisible(true);
            }
        }
        catch(ClassCastException e1){
            JOptionPane.showMessageDialog(rootPane, "Tipo de dato incorrecto");
        }
        catch(NumberFormatException e2){
            JOptionPane.showMessageDialog(rootPane, "Tipo de dato incorrecto");
        }
    }//GEN-LAST:event_btnRegresarActionPerformed

    private void btnSeguir3QActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSeguir3QActionPerformed
        // TODO add your handling code here:
        this.dispose();
        new Receta().setVisible(true);
    }//GEN-LAST:event_btnSeguir3QActionPerformed

    private void txtCirugiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCirugiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCirugiaActionPerformed

    private void txtProcesoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtProcesoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtProcesoActionPerformed

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
            java.util.logging.Logger.getLogger(VentanaReporteQuirurgico2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VentanaReporteQuirurgico2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VentanaReporteQuirurgico2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VentanaReporteQuirurgico2.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaReporteQuirurgico2().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel PanelQururgico3;
    private javax.swing.JButton btnRegresar;
    private javax.swing.JButton btnSeguir3Q;
    private javax.swing.JLabel lbAnio;
    private javax.swing.JLabel lbCirugiaQ2;
    private javax.swing.JLabel lbComplejidadQ2;
    private javax.swing.JLabel lbDia;
    private javax.swing.JLabel lbFechaReporteQ1;
    private javax.swing.JLabel lbHoraFinalQ2;
    private javax.swing.JLabel lbHoraFinalQ3;
    private javax.swing.JLabel lbHoraInicioQ2;
    private javax.swing.JLabel lbInicioReporteQ2;
    private javax.swing.JLabel lbInicioReporteQ3;
    private javax.swing.JLabel lbMes;
    private javax.swing.JLabel lbMinutosFinalQ2;
    private javax.swing.JLabel lbMinutosInicioQ2;
    private javax.swing.JLabel lbObservacion;
    private javax.swing.JLabel lbProcesoReporteQ2;
    private javax.swing.JLabel lbRecuperacion;
    private javax.swing.JLabel lbTituloVReporteQ2;
    private javax.swing.JTextField txtAnio;
    private javax.swing.JTextField txtAvanceEnfermedad;
    private javax.swing.JTextField txtCirugia;
    private javax.swing.JTextField txtComplejidad;
    private javax.swing.JTextField txtDia;
    private javax.swing.JTextField txtHoraInicio;
    private javax.swing.JTextField txtHoraSalida;
    private javax.swing.JTextField txtMes;
    private javax.swing.JTextField txtMinutosInicio;
    private javax.swing.JTextField txtMinutosSalida;
    private javax.swing.JTextField txtObservacion;
    private javax.swing.JTextField txtProceso;
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