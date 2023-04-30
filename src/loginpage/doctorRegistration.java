/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package loginpage;

import java.security.MessageDigest;
import java.sql.ResultSetMetaData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import static loginpage.RegisterStaff.SHA1;

public class doctorRegistration extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    
private void table_update(){
    int c;
    try {
        con=DriverManager.getConnection("jdbc:mysql://localhost:3307/projectcrypto","root","");
        pst = con.prepareStatement("select * from registerdoctor");
        ResultSet rs = pst.executeQuery();
        ResultSetMetaData Rss = rs.getMetaData();
        c= Rss.getColumnCount();
        DefaultTableModel df = (DefaultTableModel)displaytable.getModel();
        displaytable.setModel(df);
        TableColumnModel tableColumnModel=displaytable.getColumnModel();
       
        tableColumnModel.removeColumn(tableColumnModel.getColumn(5));
        df.setRowCount(0);
            while(rs.next()){
                Vector v2= new Vector();
                   for(int a= 0; a<=c ;a++){
                      v2.add(rs.getString("doc_id"));
                      v2.add(rs.getString("doc_pass"));
                      v2.add(rs.getString("doc_name"));
                      v2.add(rs.getString("doc_phone"));
                      v2.add(rs.getString("doc_email"));
                   }
                       df.addRow(v2);
            }
                    docId.setText("");
                    docpass.setText("");
                    docname.setText("");
                    docphone.setText("");
                    docEmail.setText("");
                    docId.requestFocus();

                    } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "THE TABLE WILL BE UPDATE ONCE YOU RE-ENTERED THE PAGE");
        }        
    }
    public static String SHA1(String input){
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-1");
            byte[] result = md.digest(input.getBytes());
            StringBuilder sb=new StringBuilder();
            for (int i=1;i< result.length;i++){
               sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
               
            }
            return sb.toString();
        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }
    public doctorRegistration() {
        initComponents();
        table_update();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        displaytable = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        docId = new javax.swing.JTextField();
        docpass = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        docname = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        docphone = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        docEmail = new javax.swing.JTextField();
        RegisterButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        DoneButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(107, 35, 107));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(167, 219, 219), 3));

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(167, 219, 219));
        jLabel1.setText("THE DENTAL HOUSE");

        displaytable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Doctor ID", "Password", "Name", "Phone Number", "Email", "Hash"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Long.class, java.lang.String.class, java.lang.Integer.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        displaytable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displaytableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(displaytable);

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(107, 35, 107));
        jButton1.setText("Log Out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(167, 219, 219));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Admin Page | Register Doctor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bahnschrift", 1, 12))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 11)); // NOI18N
        jLabel4.setText("Doctor ID");

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 1, 11)); // NOI18N
        jLabel5.setText("Password");

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 1, 11)); // NOI18N
        jLabel6.setText("Name");

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 1, 11)); // NOI18N
        jLabel7.setText("Phone Number");

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 1, 11)); // NOI18N
        jLabel8.setText("Email");

        RegisterButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        RegisterButton.setForeground(new java.awt.Color(107, 35, 107));
        RegisterButton.setText("Add");
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });

        EditButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        EditButton.setForeground(new java.awt.Color(107, 35, 107));
        EditButton.setText("Update");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        DeleteButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DeleteButton.setForeground(new java.awt.Color(107, 35, 107));
        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(docEmail, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(docpass, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(docname, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(docId, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(docphone, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 223, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(RegisterButton)
                        .addGap(81, 81, 81)
                        .addComponent(DeleteButton)
                        .addGap(93, 93, 93)
                        .addComponent(EditButton)))
                .addGap(46, 46, 46))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(docId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(docpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(docname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(docphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(docEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(RegisterButton)
                            .addComponent(EditButton)
                            .addComponent(DeleteButton)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        DoneButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DoneButton.setForeground(new java.awt.Color(107, 35, 107));
        DoneButton.setText("Done");
        DoneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoneButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(DoneButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 462, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addGap(44, 44, 44))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(63, 63, 63)
                        .addComponent(DoneButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        login ad3 = new login();
        ad3.show(); //to display login home page
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
       try {
          String id= docId.getText();
          con=DriverManager.getConnection("jdbc:mysql://localhost:3307/projectcrypto","root","");
          String query = ("DELETE FROM `registerdoctor` WHERE `doc_id`='"+id+"'");
          pst = con.prepareStatement(query);
          pst.executeUpdate();
          JOptionPane.showMessageDialog(null, "DELETE SUCCESSFUL");
          table_update();
          
            docId.setText("");
            docpass.setText("");
            docname.setText("");
            docphone.setText("");
            docEmail.setText("");
            docId.requestFocus();
            
          } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "DELETE UNSUCCESSFUL");
        }                 
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
        try {
            con=DriverManager.getConnection("jdbc:mysql://localhost:3307/projectcrypto","root","");
            String query = " INSERT INTO `registerdoctor`(`doc_id`, `doc_pass`, `doc_hash`,`doc_name`, `doc_phone`,`doc_email`) VALUES (?,?,?,?,?,?)";
            pst = con.prepareStatement(query);
            pst.setString(1,docId.getText());
            pst.setString(2,docpass.getText());
            pst.setString(3,SHA1(docpass.getText()));
            pst.setString(4,docname.getText());
            pst.setString(5,docphone.getText());
            pst.setString(6,docEmail.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "REGISTER DOCTOR SUCCESSFUL");
            table_update();
                    
            docId.setText("");
            docpass.setText("");
            docname.setText("");
            docphone.setText("");
            docEmail.setText("");
            docId.requestFocus();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "REGISTER FAILED");
        }
               
    }//GEN-LAST:event_RegisterButtonActionPerformed

    private void displaytableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displaytableMouseClicked

        DefaultTableModel df = (DefaultTableModel)displaytable.getModel();
        int selectedIndex = displaytable.getSelectedRow();
        
        docId.setText(df.getValueAt(selectedIndex,0).toString());
        docpass.setText(df.getValueAt(selectedIndex,1).toString());
        docname.setText(df.getValueAt(selectedIndex,2).toString());
        docphone.setText(df.getValueAt(selectedIndex,3).toString());
        docEmail.setText(df.getValueAt(selectedIndex,4).toString());        
                
    }//GEN-LAST:event_displaytableMouseClicked

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        try {
            String id= docId.getText();
            String password= docpass.getText();
            String hash= SHA1(docpass.getText());
            String name= docname.getText();
            String phone = docphone.getText();
            String email = docEmail.getText();
            
            con=DriverManager.getConnection("jdbc:mysql://localhost:3307/projectcrypto","root","");
            String query = ("UPDATE `registerdoctor` SET `doc_pass`='"+password+"',`doc_hash`='"+hash+"',`doc_name`='"+name+"',`doc_phone`='"+phone+"',`doc_email`='"+email+"' WHERE `doc_id`='"+id+"'");
            pst = con.prepareStatement(query);
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "RECORD UPDATED");
            table_update();
       
           } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "UPDATE UNSUCCESSFUL");
        }
    }//GEN-LAST:event_EditButtonActionPerformed

    private void DoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoneButtonActionPerformed
      AdminHomePage ad3 = new AdminHomePage();
        ad3.show(); //to display admin home page
        dispose();
    }//GEN-LAST:event_DoneButtonActionPerformed

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
            java.util.logging.Logger.getLogger(doctorRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(doctorRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(doctorRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(doctorRegistration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new doctorRegistration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton DoneButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JTable displaytable;
    private javax.swing.JTextField docEmail;
    private javax.swing.JTextField docId;
    private javax.swing.JTextField docname;
    private javax.swing.JTextField docpass;
    private javax.swing.JTextField docphone;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
