/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package intranetmailsystemfinal11;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author DELL
 */
public class Registration extends javax.swing.JFrame {
    Integer val=2;
    Socket s=null;
     ObjectOutputStream os=null;
     BufferedReader br=null;
      String uid=null;
      DataOutputStream dos=null;
    
    /**
     * Creates new form Registration
     */
    public Registration() {
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

        jButton3 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jPasswordField2 = new javax.swing.JPasswordField();
        jTextField2 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jComboBox1 = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton3.setText("Next");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 260, -1, -1));

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel2.setText("UserName");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 70, -1, -1));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel3.setText("DOB");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 100, 20));

        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setPreferredSize(new java.awt.Dimension(60, 22));
        getContentPane().add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 80, 260, 30));

        jLabel9.setFont(new java.awt.Font("Tw Cen MT Condensed Extra Bold", 1, 48)); // NOI18N
        jLabel9.setText("Registration");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 10, -1, -1));

        jPasswordField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        getContentPane().add(jPasswordField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 160, 260, 30));

        jTextField2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField2.setPreferredSize(new java.awt.Dimension(60, 22));
        getContentPane().add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 260, 30));

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel5.setText("Password");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, -1, 30));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel6.setText("Gender");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 210, 110, 40));

        jRadioButton1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jRadioButton1.setText("Male");
        getContentPane().add(jRadioButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 210, -1, -1));

        jRadioButton2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jRadioButton2.setText("Female");
        getContentPane().add(jRadioButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 210, -1, -1));

        jComboBox1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "What is your nick name?", "what is your birth place?", "what is your favourate color?", "what is your pet name?", "what is your lucky number?", "what is your school name?", "what is your birth year?", "what is your best friend name?", " " }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 250, 260, 30));

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setText("SecurityQ");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 260, -1, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel8.setText("Answer");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 310, -1, 20));

        jTextField4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField4.setPreferredSize(new java.awt.Dimension(60, 22));
        getContentPane().add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 302, 260, 30));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton1.setText("Save");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 340, -1, -1));

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 340, -1, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intranetmailsystemfinal11/Laptop-notebook-grass-meadow.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, -1));

        setSize(new java.awt.Dimension(916, 539));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String uid=jTextField1.getText();
        String dob=jTextField2.getText();
        String pass=jPasswordField2.getText();
        String g="";
        String msg="";
        
        if(jRadioButton1.isSelected())
        {
            g="Male";
        }
        else
        {
            g="Female";
        }

        String sq=jComboBox1.getSelectedItem().toString();
        String ans=jTextField4.getText();
        
        Register reg=new Register(uid,dob,pass,g,sq,ans);
        System.out.println(reg.uid+""+reg.dob+""+reg.pass+""+reg.g+""+reg.sq+""+reg.ans);
        try
        {
            if(uid.equals("")|| pass.equals(""))
            {
                JOptionPane.showMessageDialog(this," Please Enter UserID or Password","Acsess Denied",JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                 s=new Socket("127.0.0.1",4444);// for socket connection

                 /*for function call in Thread */
                 dos=new DataOutputStream(s.getOutputStream());
                 dos.writeInt(val);
                 dos.flush();
                // send user id and password 
                os=new ObjectOutputStream(s.getOutputStream());
                os.writeObject(reg);
                br=new BufferedReader(new InputStreamReader(s.getInputStream()));
                msg=br.readLine();
               System.out.println(msg);
           
            if(msg.equals("Registered"))
            {
                JOptionPane.showMessageDialog(this, "User Successfully Registered", "Register",JOptionPane.INFORMATION_MESSAGE);
                s.close();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "DataBase Error", "Register",JOptionPane.ERROR_MESSAGE);
            }
            Login l1= new Login();
            l1.show();
            }
            s.close();
        }
        catch(Exception e)
                {
                e.printStackTrace();
                }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        MainForm l1 = new MainForm();
        l1.show();
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        Login l7=new Login();
                l7.show();
                this.dispose();
                
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Registration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Registration().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordField2;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField4;
    // End of variables declaration//GEN-END:variables
}