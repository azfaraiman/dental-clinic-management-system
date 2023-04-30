/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package loginpage;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import static loginpage.RegisterAdmin.SHA1;

public class RegisterStaff extends javax.swing.JFrame {

    Connection con = null;
    PreparedStatement pst = null;
    
private void table_update(){
   int c;
    try {
        con=DriverManager.getConnection("jdbc:mysql://localhost:3307/projectcrypto","root","");
        pst = con.prepareStatement("select * from registerstaff");
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
                   for(int a= 0; a<=c; a++){
                      v2.add(rs.getString("staff_id"));      
                      v2.add(rs.getString("staff_pass"));  
                      v2.add(rs.getString("staff_name"));
                      v2.add(rs.getString("staff_phone"));
                      v2.add(rs.getString("staff_email"));
                   }
                       df.addRow(v2);
            }
            staffId.setText("");
                    staffpass.setText("");
                    staffname.setText("");
                    staffphone.setText("");
                    staffEmail.setText("");
                    staffId.requestFocus();
     
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
public RegisterStaff() {
        initComponents();
        table_update();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        staffId = new javax.swing.JTextField();
        staffpass = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        staffname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        staffphone = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        staffEmail = new javax.swing.JTextField();
        EditButton = new javax.swing.JButton();
        DeleteButton = new javax.swing.JButton();
        RegisterButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        displaytable = new javax.swing.JTable();
        DoneButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(107, 35, 107));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(167, 219, 219), 3));

        jLabel1.setFont(new java.awt.Font("Bahnschrift", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(167, 219, 219));
        jLabel1.setText("THE DENTAL HOUSE");

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton1.setForeground(new java.awt.Color(107, 35, 107));
        jButton1.setText("Log Out");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(167, 219, 219));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Admin Page | Register Staff", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Bahnschrift", 1, 12))); // NOI18N

        jLabel3.setFont(new java.awt.Font("Bahnschrift", 1, 11)); // NOI18N
        jLabel3.setText("Staff  ID");

        jLabel4.setFont(new java.awt.Font("Bahnschrift", 1, 11)); // NOI18N
        jLabel4.setText("Password");

        jLabel5.setFont(new java.awt.Font("Bahnschrift", 1, 11)); // NOI18N
        jLabel5.setText("Name");

        jLabel6.setFont(new java.awt.Font("Bahnschrift", 1, 11)); // NOI18N
        jLabel6.setText("Phone Number");

        jLabel8.setFont(new java.awt.Font("Bahnschrift", 1, 11)); // NOI18N
        jLabel8.setText("Email");

        EditButton.setText("Update");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        DeleteButton.setText("Delete");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

        RegisterButton.setText("Add");
        RegisterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RegisterButtonActionPerformed(evt);
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
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel8)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(staffEmail, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(staffphone)))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                                .addComponent(DeleteButton)
                                .addGap(67, 67, 67)
                                .addComponent(EditButton))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(staffId)
                            .addComponent(staffpass)
                            .addComponent(staffname))))
                .addGap(29, 29, 29))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(staffId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(staffpass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(staffname, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addComponent(staffphone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(staffEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 29, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DeleteButton)
                    .addComponent(RegisterButton)
                    .addComponent(EditButton)))
        );

        displaytable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        displaytable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Staff ID", "Password", "Name", "Phone Number", "Email", "Hash"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Object.class
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
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(44, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 441, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DoneButton, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jLabel1))
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(DoneButton))
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void RegisterButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RegisterButtonActionPerformed
        try{
            con=DriverManager.getConnection("jdbc:mysql://localhost:3307/projectcrypto","root","");
            String query= "INSERT INTO `registerstaff` (`staff_id`,`staff_pass`,`staff_hash`,`staff_name`,`staff_phone`,`staff_email`) VALUES (?,?,?,?,?,?)";
            pst=con.prepareStatement(query);
            pst.setString(1,staffId.getText());
            pst.setString(2,staffpass.getText());
            pst.setString(3,SHA1(staffpass.getText()));
            pst.setString(4,staffname.getText());
            pst.setString(5,staffphone.getText());
            pst.setString(6,staffEmail.getText());
            pst.executeUpdate();
           JOptionPane.showMessageDialog(null, "REGISTER SUCCESSFUL");
            table_update();
                    
            staffId.setText("");
            staffpass.setText("");
            staffname.setText("");
            staffphone.setText("");
            staffEmail.setText("");
            staffId.requestFocus();        
       
        }catch(Exception ex){
           JOptionPane.showMessageDialog(null, "REGISTER FAILED");
       }
    }//GEN-LAST:event_RegisterButtonActionPerformed

    private void displaytableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_displaytableMouseClicked
         DefaultTableModel df = (DefaultTableModel)displaytable.getModel();
        int selectedIndex = displaytable.getSelectedRow();
        
        staffId.setText(df.getValueAt(selectedIndex,0).toString());
        staffpass.setText(df.getValueAt(selectedIndex,1).toString());
        staffname.setText(df.getValueAt(selectedIndex,2).toString());
        staffphone.setText(df.getValueAt(selectedIndex,3).toString());
        staffEmail.setText(df.getValueAt(selectedIndex,4).toString());
    }//GEN-LAST:event_displaytableMouseClicked

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
       try{
          String id= staffId.getText();
          String password= staffpass.getText();
          String hash= SHA1(staffpass.getText());
          String name= staffname.getText();
          String phone = staffphone.getText();
          String email = staffEmail.getText();
        
          con=DriverManager.getConnection("jdbc:mysql://localhost:3307/projectcrypto","root","");
          String query= ("UPDATE `registerstaff` SET `staff_pass`='"+password+"',`staff_hash`='"+hash+"',`staff_name`='"+name+"',`staff_phone`='"+phone+"',`staff_email`='"+email+"' WHERE `staff_id`='"+id+"'");
          pst=con.prepareStatement(query);
          pst.executeUpdate();
          JOptionPane.showMessageDialog(null,"UPDATE SUCCESSFUL");
          table_update();
 
        }catch(Exception ex){
           JOptionPane.showMessageDialog(null, "UPDATE FAILED");
       }
    
    }//GEN-LAST:event_EditButtonActionPerformed

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
         try{
             
           String id= staffId.getText();
           con=DriverManager.getConnection("jdbc:mysql://localhost:3307/projectcrypto","root","");
           String query= ("DELETE FROM `registerstaff`  WHERE `staff_id`='"+id+"'");
           pst=con.prepareStatement(query);
           pst.executeUpdate();
           JOptionPane.showMessageDialog(null,"DELETE SUCCESSFUL");
           table_update();
                    
           staffId.setText("");
           staffpass.setText("");
           staffname.setText("");
           staffphone.setText("");
           staffEmail.setText("");
           staffId.requestFocus();        
       
        }catch(Exception ex){
           JOptionPane.showMessageDialog(null, "DELETE FAILED");
       }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private void DoneButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DoneButtonActionPerformed
       AdminHomePage ad3 = new AdminHomePage();
        ad3.show(); //to display admin home page
        dispose();
    }//GEN-LAST:event_DoneButtonActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        login ad3 = new login();
        ad3.show(); //to display login home page
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed


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
            java.util.logging.Logger.getLogger(RegisterStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RegisterStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RegisterStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RegisterStaff.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new RegisterStaff().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DeleteButton;
    private javax.swing.JButton DoneButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JButton RegisterButton;
    private javax.swing.JTable displaytable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField staffEmail;
    private javax.swing.JTextField staffId;
    private javax.swing.JTextField staffname;
    private javax.swing.JTextField staffpass;
    private javax.swing.JTextField staffphone;
    // End of variables declaration//GEN-END:variables
}
