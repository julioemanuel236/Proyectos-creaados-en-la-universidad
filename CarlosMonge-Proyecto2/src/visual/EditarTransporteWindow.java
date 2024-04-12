package visual;
import control.Datos;
import entidades.*;
import javax.swing.JOptionPane;

public class EditarTransporteWindow extends javax.swing.JFrame {

    /**
     * Creates new form EditarTransporteWindow
     */
    
    String codigo,tipo,color;
    String clase;
    int cantidad;
    Datos datos;
    Transporte transporte;
    MainWindow mainWindow;
    
    public EditarTransporteWindow(Datos datos,Transporte t,MainWindow mainWindow) {
        /*
            pasamos por parametro los datos, el transporte a editar y la ventana principal
        */
        
        initComponents();
        this.datos = datos;
        this.mainWindow = mainWindow;
        this.transporte = t;
        this.clase = t.getClass().getSimpleName();
        this.codigo = t.getCodigo();
        this.tipo = t.getTipo();
        
        /*
            decidimos que se debe mostrar segun
            el tipo de transporte que estamos editando
        */
        
        if(clase.equals(Bicicleta.class.getSimpleName())){
            this.cantidad = (((Bicicleta)t).getCantidadCambios());
            biciPanel.setSize(optionPanel.getSize());            
            optionPanel.add(biciPanel);
            jComboBox3.setSelectedIndex(((Bicicleta)t).getCantidadCambios()-1);
        }
        else if(clase.equals(Scooter.class.getSimpleName())){
            this.color = (((Scooter)t).getColor());;
            scooterPanel.setSize(optionPanel.getSize());            
            jTextField2.setText(((Scooter)t).getColor());
            optionPanel.add(scooterPanel);
        }
        else if(clase.equals(Patinete.class.getSimpleName())){
            this.cantidad = (((Patinete)t).getCantidadRuedas());
            patinetePanel.setSize(optionPanel.getSize());            
            optionPanel.add(patinetePanel);
            jComboBox2.setSelectedIndex(((Patinete)t).getCantidadRuedas()-1);
        }
        
        categoria.setText(clase);
        codigoText.setText(this.codigo);
        TipoCombo.setSelectedItem(this.tipo);
        setLocationRelativeTo(null);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        biciPanel = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        scooterPanel = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        patinetePanel = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox<>();
        jPanel1 = new javax.swing.JPanel();
        codigoText = new javax.swing.JTextField();
        categoria = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        TipoCombo = new javax.swing.JComboBox<>();
        optionPanel = new javax.swing.JPanel();
        aceptarButton = new javax.swing.JButton();

        biciPanel.setBackground(new java.awt.Color(60, 64, 65));
        biciPanel.setPreferredSize(new java.awt.Dimension(285, 40));

        jLabel3.setBackground(new java.awt.Color(60, 64, 65));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("CANTIDAD CAMBIOS");

        jComboBox3.setBackground(new java.awt.Color(70, 74, 75));
        jComboBox3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox3.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2" }));

        javax.swing.GroupLayout biciPanelLayout = new javax.swing.GroupLayout(biciPanel);
        biciPanel.setLayout(biciPanelLayout);
        biciPanelLayout.setHorizontalGroup(
            biciPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(biciPanelLayout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65)
                .addComponent(jComboBox3, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(67, Short.MAX_VALUE))
        );
        biciPanelLayout.setVerticalGroup(
            biciPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, biciPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(biciPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                .addContainerGap())
        );

        scooterPanel.setBackground(new java.awt.Color(60, 64, 65));
        scooterPanel.setPreferredSize(new java.awt.Dimension(285, 40));

        jLabel4.setBackground(new java.awt.Color(60, 64, 65));
        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("COLOR");

        jTextField2.setBackground(new java.awt.Color(70, 74, 75));
        jTextField2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jTextField2.setForeground(new java.awt.Color(255, 255, 255));
        jTextField2.setCaretColor(new java.awt.Color(255, 255, 255));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout scooterPanelLayout = new javax.swing.GroupLayout(scooterPanel);
        scooterPanel.setLayout(scooterPanelLayout);
        scooterPanelLayout.setHorizontalGroup(
            scooterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scooterPanelLayout.createSequentialGroup()
                .addContainerGap(82, Short.MAX_VALUE)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
        );
        scooterPanelLayout.setVerticalGroup(
            scooterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(scooterPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(scooterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 7, Short.MAX_VALUE))
        );

        patinetePanel.setBackground(new java.awt.Color(60, 64, 65));
        patinetePanel.setPreferredSize(new java.awt.Dimension(406, 40));

        jLabel5.setBackground(new java.awt.Color(60, 64, 65));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("CANTIDAD RUEDAS");

        jComboBox2.setBackground(new java.awt.Color(70, 74, 75));
        jComboBox2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jComboBox2.setForeground(new java.awt.Color(255, 255, 255));
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        javax.swing.GroupLayout patinetePanelLayout = new javax.swing.GroupLayout(patinetePanel);
        patinetePanel.setLayout(patinetePanelLayout);
        patinetePanelLayout.setHorizontalGroup(
            patinetePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patinetePanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        patinetePanelLayout.setVerticalGroup(
            patinetePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(patinetePanelLayout.createSequentialGroup()
                .addContainerGap(7, Short.MAX_VALUE)
                .addGroup(patinetePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(60, 64, 65));
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);

        jPanel1.setBackground(new java.awt.Color(60, 64, 65));

        codigoText.setBackground(new java.awt.Color(70, 74, 75));
        codigoText.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        codigoText.setForeground(new java.awt.Color(255, 255, 255));
        codigoText.setText("CODIGO");

        categoria.setBackground(new java.awt.Color(60, 64, 65));
        categoria.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        categoria.setForeground(new java.awt.Color(255, 255, 255));
        categoria.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        categoria.setText("CATEGORIA");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CODIGO");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("TIPO");

        TipoCombo.setBackground(new java.awt.Color(70, 74, 75));
        TipoCombo.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        TipoCombo.setForeground(new java.awt.Color(255, 255, 255));
        TipoCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "NORMAL", "ELECTRICO" }));
        TipoCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TipoComboActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout optionPanelLayout = new javax.swing.GroupLayout(optionPanel);
        optionPanel.setLayout(optionPanelLayout);
        optionPanelLayout.setHorizontalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        optionPanelLayout.setVerticalGroup(
            optionPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 41, Short.MAX_VALUE)
        );

        aceptarButton.setBackground(new java.awt.Color(78, 81, 82));
        aceptarButton.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        aceptarButton.setForeground(new java.awt.Color(255, 255, 255));
        aceptarButton.setText("ACEPTAR");
        aceptarButton.setFocusable(false);
        aceptarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aceptarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoText, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(TipoCombo, 0, 145, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(31, 31, 31))
            .addComponent(optionPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addComponent(aceptarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 269, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(68, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(categoria, javax.swing.GroupLayout.DEFAULT_SIZE, 394, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(TipoCombo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codigoText, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(24, 24, 24)
                .addComponent(optionPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(aceptarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(categoria, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(202, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aceptarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aceptarButtonActionPerformed
        Object[] data = {codigoText.getText(),(String)TipoCombo.getSelectedItem(),null};
        
        //coger los datos nuevos
        //segun lo que estamos editando
        //y llamar a la funcion editar
        if(clase.equals(Bicicleta.class.getSimpleName())){
            data[2] = jComboBox3.getSelectedIndex()+1;
        }
        else if(clase.equals(Scooter.class.getSimpleName())){
            data[2] = jTextField2.getText();
        }
        else if(clase.equals(Patinete.class.getSimpleName())){
            data[2] = jComboBox2.getSelectedIndex()+1;
        }
        
        if(datos.editarTransporte(this.transporte,data)){
            //si fue posible editar
            //actualizar las tablas
            this.mainWindow.updateTransporteTable();
            this.mainWindow.updateAlquilerTable();
            //cerrar ventana
            dispose();            
        }
        //mostrar error en caso de no ser valida la informacion
        else JOptionPane.showMessageDialog(null, "Imposible poner esta nueva información");
        
  
    }//GEN-LAST:event_aceptarButtonActionPerformed

    private void TipoComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TipoComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TipoComboActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> TipoCombo;
    private javax.swing.JButton aceptarButton;
    private javax.swing.JPanel biciPanel;
    private javax.swing.JLabel categoria;
    private javax.swing.JTextField codigoText;
    private javax.swing.JComboBox<String> jComboBox2;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel optionPanel;
    private javax.swing.JPanel patinetePanel;
    private javax.swing.JPanel scooterPanel;
    // End of variables declaration//GEN-END:variables
}
