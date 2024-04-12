/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Library;

import SupportClass.Book;
import SupportClass.Library;
import java.util.Date;

/**
 *
 * @author Julio Rafael LL
 */
public class Add_Books extends javax.swing.JFrame {

    Library library;
    GUI gui;
    /**
     * Creates new form Add_Magazine
     */
    public Add_Books() {
        initComponents();
    }
    
    public Add_Books(GUI gui,Library library) {
        this.gui = gui;
        this.library = library;
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

        jPanel1 = new javax.swing.JPanel();
        numberpages_txt_b = new javax.swing.JTextField();
        highdate_txt_b = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        lotnumber_txt_b = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        button_add_books = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        home_book = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        initialamount_txt_b = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        gender_txt_b = new javax.swing.JTextField();
        name_txt_b = new javax.swing.JTextField();
        collection_txt_b = new javax.swing.JTextField();
        price_txt_b = new javax.swing.JTextField();
        editionnumber_txt_b = new javax.swing.JTextField();
        author_txt_b = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setAutoscrolls(true);
        jPanel1.setFocusTraversalPolicyProvider(true);
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel1.add(numberpages_txt_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 168, 95, -1));
        jPanel1.add(highdate_txt_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 210, 93, -1));

        jLabel10.setText("Collection");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 95, -1, -1));
        jPanel1.add(lotnumber_txt_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 170, 93, -1));

        jLabel11.setFont(new java.awt.Font("Tempus Sans ITC", 1, 18)); // NOI18N
        jLabel11.setText("Add books to catalog");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(137, 11, -1, -1));

        jLabel6.setText("Author: ");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 136, -1, -1));

        button_add_books.setText("ADD");
        button_add_books.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button_add_booksActionPerformed(evt);
            }
        });
        jPanel1.add(button_add_books, new org.netbeans.lib.awtextra.AbsoluteConstraints(233, 265, -1, -1));

        jLabel1.setText("Name: ");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 57, -1, -1));

        jLabel7.setText("Number of pages");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 171, -1, -1));

        home_book.setText("Home");
        jPanel1.add(home_book, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 294, -1, -1));

        jLabel2.setText("Price: ");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 95, -1, -1));

        jLabel8.setText("Gender");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 57, -1, -1));

        jLabel3.setText("Lot number: ");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jLabel9.setText("Edition number");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 133, -1, -1));

        jLabel4.setText("High date: ");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));
        jPanel1.add(initialamount_txt_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 206, 95, -1));

        jLabel5.setText("Initial amount: ");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(232, 209, -1, -1));
        jPanel1.add(gender_txt_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 54, 95, -1));
        jPanel1.add(name_txt_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 50, 93, -1));
        jPanel1.add(collection_txt_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 92, 95, -1));
        jPanel1.add(price_txt_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 90, 93, -1));
        jPanel1.add(editionnumber_txt_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(343, 130, 95, -1));
        jPanel1.add(author_txt_b, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 93, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 329, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button_add_booksActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button_add_booksActionPerformed
        library.Add(new Book(author_txt_b.getText(),Integer.parseInt(numberpages_txt_b.getText()),gender_txt_b.getText(),Integer.parseInt(editionnumber_txt_b.getText()),collection_txt_b.getText(),lotnumber_txt_b.getText(),name_txt_b.getText(),Float.parseFloat(price_txt_b.getText()), new Date(System.currentTimeMillis()),Integer.parseInt(this.initialamount_txt_b.getText())));
        gui.ActualizarList();
        setVisible(false);
    }//GEN-LAST:event_button_add_booksActionPerformed

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
            java.util.logging.Logger.getLogger(Add_Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Add_Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Add_Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Add_Books.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Add_Books().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField author_txt_b;
    private javax.swing.JButton button_add_books;
    private javax.swing.JTextField collection_txt_b;
    private javax.swing.JTextField editionnumber_txt_b;
    private javax.swing.JTextField gender_txt_b;
    private javax.swing.JTextField highdate_txt_b;
    private javax.swing.JLabel home_book;
    private javax.swing.JTextField initialamount_txt_b;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField lotnumber_txt_b;
    private javax.swing.JTextField name_txt_b;
    private javax.swing.JTextField numberpages_txt_b;
    private javax.swing.JTextField price_txt_b;
    // End of variables declaration//GEN-END:variables

   
}