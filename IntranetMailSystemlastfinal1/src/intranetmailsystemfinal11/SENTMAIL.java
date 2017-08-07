
package intranetmailsystemfinal11;

import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;


public class SENTMAIL extends javax.swing.JFrame {
    String uid=null;
    Integer val=7;
    Socket s=null;
    DataOutputStream dos=null;
    ObjectOutputStream os=null;
    String reciever="",subject="",date="",time="",msg="";
 
    /**
     * Creates new form SENTMAIL
     */
    public SENTMAIL() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    public SENTMAIL(String uid) {
        initComponents();
        this.uid=uid;
        
        try
        {
             s=new Socket("127.0.0.1",4444);// for socket connection
             System.out.println("Connected");
             DefaultTableModel model = (DefaultTableModel)jTable1.getModel();
             ArrayList<Mail> myList=new ArrayList<Mail>(); 
             /*for function call in Thread */
             dos=new DataOutputStream(s.getOutputStream());
             dos.writeInt(val);
             dos.flush();
             
             PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
             pw.println(uid+"\n");
             
             
               ObjectInputStream objectInput = new ObjectInputStream(s.getInputStream());
               
               Object ob=objectInput.readObject();
               myList=(ArrayList<Mail>)ob;
               
               for(int i=0;i<myList.size();i++)
               {
                   Mail m=myList.get(i);
                   reciever=m.sender;
                   subject=m.subject;
                   date=m.date;
                   time=m.time;
                   msg=m.message;
                  //System.out.println(m.sender+" "+m.subject+" "+m.date+" "+m.time);
                  model.addRow(new Object[]{reciever,subject,msg,date,time});
                   s.close();
               }
               
             /*  pw.close();
               objectInput.close();
               dos.close();
              
              */ 
               
               
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("SENTMAIL");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jLabel2.setText("SENTMAIL");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 22, -1, 30));

        jTable1.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "TO", "SUBJECT", "MESSAGE", "DATE", "TIME"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 870, 370));

        jButton1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jButton1.setText("BACK");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 450, 140, 40));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/intranetmailsystemfinal11/571f9db0c46188c3358b45bc.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane2.setViewportView(jList1);

        getContentPane().add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 50, -1, -1));

        setBounds(0, 0, 916, 539);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       Inbox ob77= new Inbox(uid);
       ob77.show();
       this.dispose();
            
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
    DefaultTableModel model1=(DefaultTableModel) jTable1.getModel();
      int select=jTable1.getSelectedRow();
      reciever=model1.getValueAt(select,0).toString();
      subject=model1.getValueAt(select,1).toString();
      msg=model1.getValueAt(select,2).toString();
      date=model1.getValueAt(select,3).toString();
      time=model1.getValueAt(select,4).toString();
      System.out.println(model1.getValueAt(select,1).toString()+" "+model1.getValueAt(select,3).toString());
      
      Sent1 ob=new Sent1(uid,reciever,subject,msg,date,time);
      ob.show();
      this.dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1MouseClicked

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
            java.util.logging.Logger.getLogger(SENTMAIL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SENTMAIL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SENTMAIL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SENTMAIL.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SENTMAIL().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}