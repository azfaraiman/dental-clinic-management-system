/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package loginpage;
import java.nio.charset.StandardCharsets;
import java.security.spec.KeySpec;
import javax.crypto.Cipher;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Base64;
import java.util.Vector;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;


public class patientRegister extends javax.swing.JFrame {

     Connection con = null;
    PreparedStatement pst = null;
    

  private static final String SECRET_KEY = "my_super_secret_key";
  private static final String SALT = "ssshhhhhhhhhhh!!!!";
 
    private void table_update(){
   int c;
    try {
        con=DriverManager.getConnection("jdbc:mysql://localhost:3307/projectcrypto","root","");
        pst = con.prepareStatement("SELECT * FROM registerpatient");
        ResultSet rs = pst.executeQuery();
        ResultSetMetaData Rss = rs.getMetaData();
        c= Rss.getColumnCount();
        DefaultTableModel df = (DefaultTableModel)displayTable.getModel();
        TableColumnModel tableColumnModel=displayTable.getColumnModel();
        tableColumnModel.removeColumn(tableColumnModel.getColumn(6));
        
         displayTable.setModel(df);
       
        df.setRowCount(0);
        while(rs.next()){
         Vector v2= new Vector();
             for(int a= 1; a<=c; a++){
                 v2.add(rs.getString("patient_id"));
                 v2.add(rs.getString("patient_name"));
                 v2.add(rs.getString("patient_ic"));
                 v2.add(rs.getString("patient_phone"));
                 v2.add(rs.getString("patient_treatment"));
                 v2.add(rs.getString("patient_app"));
               
             }
                df.addRow(v2);
            }
        patientId.setText("");
               patientName.setText("");
               patientIC.setText("");
              patientPhone.setText("");
              patientTreatment.setText("");
              patientApp.setText("");
              patientId.requestFocus();
                    
                
   } catch (Exception ex) {
             JOptionPane.showMessageDialog(null, "THE TABLE WILL BE UPDATE ONCE YOU RE-ENTERED THE PAGE");
        }     
    }
    public static String encrypt(String strToEncrypt) {
    try {
      byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
      IvParameterSpec ivspec = new IvParameterSpec(iv);
 
      SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
      KeySpec spec = new PBEKeySpec(SECRET_KEY.toCharArray(), SALT.getBytes(), 65536, 256);
      SecretKey tmp = factory.generateSecret(spec);
      SecretKeySpec secretKey = new SecretKeySpec(tmp.getEncoded(), "AES");
 
      Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
      cipher.init(Cipher.ENCRYPT_MODE, secretKey, ivspec);
      return Base64.getEncoder()
          .encodeToString(cipher.doFinal(strToEncrypt.getBytes(StandardCharsets.UTF_8)));
    } catch (Exception e) {
      System.out.println("Error while encrypting: " + e.toString());
    }
    return null;
  }
    public patientRegister() {
        initComponents();
        table_update();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        RegisterButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        patientId = new javax.swing.JTextField();
        patientName = new javax.swing.JTextField();
        patientIC = new javax.swing.JTextField();
        patientPhone = new javax.swing.JTextField();
        patientTreatment = new javax.swing.JTextField();
        patientApp = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        displayTable = new javax.swing.JTable();
        DoneButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(107, 35, 107));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(167, 219, 219), 3));

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(167, 219, 219));
        jLabel1.setText("THE DENTAL HOUSE");

        jPanel2.setBackground(new java.awt.Color(167, 219, 219));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Staff Page | Register Patient", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bahnschrift", 1, 12))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 11)); // NOI18N
        jLabel3.setText("Patient ID");

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 11)); // NOI18N
        jLabel4.setText("Name");

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 1, 11)); // NOI18N
        jLabel5.setText("IC No");

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 1, 11)); // NOI18N
        jLabel6.setText("Phone Number");

        jLabel7.setFont(new java.awt.Font("Bahnschrift", 1, 11)); // NOI18N
        jLabel7.setText("Treatment");

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 1, 11)); // NOI18N
        jLabel8.setText("Appoinment");

        RegisterButton.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        RegisterButton.setText("Add");
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
            }
        });

        DeleteButton.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        EditButton.setFont(new java.awt.Font("Bahnschrift", 1, 12)); // NOI18N
        EditButton.setText("Update");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(RegisterButton)
                            .addComponent(jLabel8))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(patientApp))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(83, 83, 83)
                                .addComponent(DeleteButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                                .addComponent(EditButton)
                                .addGap(17, 17, 17))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7))
                        .addGap(29, 29, 29)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(patientTreatment)
                            .addComponent(patientPhone)
                            .addComponent(patientIC)
                            .addComponent(patientId)
                            .addComponent(patientName))))
                .addGap(40, 40, 40))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(patientId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(patientName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(patientIC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(patientPhone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(patientTreatment, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(patientApp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RegisterButton)
                    .addComponent(DeleteButton)
                    .addComponent(EditButton))
                .addContainerGap())
        );

        displayTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                " ID", "Name", "IC No", "Phone Number", "Treatment", "Appoinment", "Encrypt"
            }
        ));
        displayTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                displayTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(displayTable);

        DoneButton.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        DoneButton.setForeground(new java.awt.Color(107, 35, 107));
        DoneButton.setText("Done");
        DoneButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DoneButtonActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(107, 35, 107));
        jButton1.setText("Log Out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DoneButton)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jButton1))
                        .addGap(18, 18, 18)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(66, 66, 66)
                        .addComponent(DoneButton)
                        .addGap(47, 47, 47))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
    try {
       con=DriverManager.getConnection("jdbc:mysql://localhost:3307/projectcrypto","root","");
       String query = "INSERT INTO `registerpatient`(`patient_id`, `patient_name`,`patient_ic`,`encrypt_patient`, `patient_phone`,`patient_treatment`, `patient_app`) VALUES (?,?,?,?,?,?,?) ";
       pst = con.prepareStatement(query);
       pst.setString(1,patientId.getText());
       pst.setString(2,patientName.getText());
       pst.setString(3,patientIC.getText());
       pst. setString(4,encrypt(patientIC.getText()));
       pst.setString(5,patientPhone.getText());
       pst.setString(6,patientTreatment.getText());
       pst.setString(7,patientApp.getText());
       pst.executeUpdate();
       JOptionPane.showMessageDialog(null, "REGISTER PATIENT SUCCESSFUL");
       table_update();
           
        patientId.setText("");
        patientName.setText("");
        patientIC.setText("");
        patientPhone.setText("");
        patientTreatment.setText("");
        patientApp.setText("");
        patientId.requestFocus();

    } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "REGISTER FAILED");
        }
               
    }//GEN-LAST:event_RegisterButtonActionPerformed

    private void DoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoneButtonActionPerformed
        StaffPage ad3 = new StaffPage();
        ad3.show(); //to display staff home page
        dispose();
   
    }//GEN-LAST:event_DoneButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        login ad3 = new login();
        ad3.show(); //to display login home page
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void displayTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displayTableMouseClicked
        DefaultTableModel df = (DefaultTableModel)displayTable.getModel();
        int selectedIndex = displayTable.getSelectedRow();
        
        patientId.setText(df.getValueAt(selectedIndex,0).toString());
        patientName.setText(df.getValueAt(selectedIndex,1).toString());
        patientIC.setText(df.getValueAt(selectedIndex,2).toString());
        patientPhone.setText(df.getValueAt(selectedIndex,3).toString());
       patientTreatment.setText(df.getValueAt(selectedIndex,4).toString());
       patientApp.setText(df.getValueAt(selectedIndex,5).toString());
    }//GEN-LAST:event_displayTableMouseClicked

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        try {
            String id= patientId.getText();
          String name= patientName.getText();
          String ic= patientIC.getText();
          String encryption=encrypt(patientIC.getText());
          String phone = patientPhone.getText();
          String treatment = patientTreatment.getText();
          String app = patientApp.getText();
                    con=DriverManager.getConnection("jdbc:mysql://localhost:3307/projectcrypto","root","");
                    String query = ("UPDATE `registerpatient` SET `patient_name`='"+name+"',`patient_ic`='"+ic+"',`encrypt_patient`='"+encryption+"',`patient_phone`='"+phone+"',`patient_treatment`='"+treatment+"',`patient_app`='"+app+"' WHERE `patient_id`='"+id+"'");
                    pst = con.prepareStatement(query);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(null, "RECORD UPDATED");
                    table_update();
 
      } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "UPDATE FAILED");
        }
    }//GEN-LAST:event_EditButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        try {
            String id= patientId.getText();
       con=DriverManager.getConnection("jdbc:mysql://localhost:3307/projectcrypto","root","");
       String query = ("DELETE FROM `registerpatient`  WHERE `patient_id`='"+id+"'");
       pst = con.prepareStatement(query);
       pst.executeUpdate();
       JOptionPane.showMessageDialog(null, "DELETE SUCCESSFUL");
        table_update();
        patientId.setText("");
        patientName.setText("");
        patientIC.setText("");
        patientPhone.setText("");
        patientTreatment.setText("");
        patientApp.setText("");
        patientId.requestFocus();
  } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "DELETE FAILED");
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

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
            java.util.logging.Logger.getLogger(patientRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(patientRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(patientRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(patientRegister.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new patientRegister().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton DoneButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JTable displayTable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField patientApp;
    private javax.swing.JTextField patientIC;
    private javax.swing.JTextField patientId;
    private javax.swing.JTextField patientName;
    private javax.swing.JTextField patientPhone;
    private javax.swing.JTextField patientTreatment;
    // End of variables declaration//GEN-END:variables
}
