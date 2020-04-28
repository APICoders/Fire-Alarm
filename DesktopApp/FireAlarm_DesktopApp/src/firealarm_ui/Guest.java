package firealarm_ui;


import firealarm_rmi.FireAlarmInterface;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import org.json.JSONArray;
import org.json.JSONObject;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pasan
 */
public class Guest extends javax.swing.JFrame {

    //Define the table and timer
    DefaultTableModel table;
    Timer refreshTimer;
    /**
     * Creates new form Guest
     */
    public Guest() {
        //Form Load Event
        initComponents();
        centerPanel();
        createCloums();
        autoRefresh();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblGuest = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnAdminRegister = new javax.swing.JButton();
        btnAdminLogin = new javax.swing.JButton();
        btnClose = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setUndecorated(true);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        tblGuest.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tblGuest.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {}
            },
            new String [] {

            }
        ));
        tblGuest.setRowHeight(40);
        tblGuest.setRowMargin(5);
        jScrollPane1.setViewportView(tblGuest);

        jPanel2.setBackground(new java.awt.Color(102, 204, 255));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 36)); // NOI18N
        jLabel3.setText("FIRE ALARM SYSTEM");

        btnAdminRegister.setText("Register");
        btnAdminRegister.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminRegisterActionPerformed(evt);
            }
        });

        btnAdminLogin.setText("Login");
        btnAdminLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAdminLoginActionPerformed(evt);
            }
        });

        btnClose.setText("Close");
        btnClose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCloseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnClose)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(148, 148, 148)
                .addComponent(btnAdminRegister, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnAdminLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addComponent(jLabel3))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdminRegister)
                            .addComponent(btnAdminLogin)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnClose)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(88, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1078, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(68, 68, 68)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 451, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void createCloums(){
        
        //In form load that columns are create
        table = (DefaultTableModel) tblGuest.getModel();
        table.addColumn("ID");
        table.addColumn("Floor No");
        table.addColumn("Room No");
        table.addColumn("CO2");
        table.addColumn("Smoke");
        table.addColumn("Status");
        
        
        
    }
    
    private void centerPanel() {

            //JFrom Center the compter screen
            Dimension windowSize = getSize();//Get the form size
            GraphicsEnvironment graphicsEnvironment = GraphicsEnvironment.getLocalGraphicsEnvironment();
            Point centerPoint = graphicsEnvironment.getCenterPoint();

            int x = centerPoint.x - windowSize.width / 2;//From Horisontal center
            int y = centerPoint.y - windowSize.height / 2;//From vertical center    
            setLocation(x, y);//Set the From center in the computer screen
    }
        
    private void autoRefresh(){
        //Timer Auto refresh the 15 secounds
          refreshTimer =new Timer(15000, new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  //What event run given time
                  Refresh();
              }
          });
          refreshTimer.start();//Start timer
          
      }
     
    private void Refresh(){
        
          table =(DefaultTableModel) tblGuest.getModel();
            int rowCount = table.getRowCount();//Get row count
            //Remove rows one by one from table
            for (int i = rowCount - 1; i >= 0; i--) {
                table.removeRow(i);
        }

        JSONArray firealarm = new JSONArray();
        StringBuffer response = new StringBuffer();
        try 
        {
            //Rgister the RMI 
            Registry reg=LocateRegistry.getRegistry("127.0.0.1",1098);
            FireAlarmInterface fireAlarm=(FireAlarmInterface)reg.lookup("firealarm");
            //Get responce of the server
            response =  fireAlarm.showfirealarm();
            
            //Responce add to JSON array
             firealarm = new JSONArray(response.toString());
                        
                    //Devide the JSON object to json array
                     for (int i = 0; i < firealarm.length(); ++i) {
                            JSONObject fireobj = firealarm.getJSONObject(i);
                            int id = fireobj.getInt("id");
                            String floor = fireobj.getString("floorNo");
                            String room = fireobj.getString("roomNo");
                            int co2 = fireobj.getInt("co2Level");
                            int smoke = fireobj.getInt("smokeLevel");
                            int status = fireobj.getInt("status");
                            
                            //Adding to Table that values
                            InsertRow(id,floor,room,Integer.toString(co2),Integer.toString(smoke), status);
                            
                            //If co2 or smoke level increse the 5 Display the alert
                           if(co2 > 5 || smoke > 5){
                               //Start the alert
                               Alert frmAlert = new Alert(floor,room);
                               frmAlert.show();
                           }
                        

                
            }
            
            
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
        
    }
        
    private void InsertRow(int id,String floor,String room,String co2,String smoke,int status){
        
        //Responce data add to table
        table =(DefaultTableModel) tblGuest.getModel();
        String sid = String.valueOf(id);
        
        String[] rowData ={ sid,room,floor,co2,smoke,String.valueOf(status)};
        
        //Adding
        table.addRow(rowData);
    }
    
    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        //Form open method calling
       Refresh();
    }//GEN-LAST:event_formWindowOpened

    private void btnAdminRegisterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminRegisterActionPerformed
        // TODO add your handling code here:
        //If register button click open the register form
        AdminRegister frmreg = new AdminRegister();
        frmreg.show();
        this.hide();
    }//GEN-LAST:event_btnAdminRegisterActionPerformed

    private void btnAdminLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAdminLoginActionPerformed
        // TODO add your handling code here:
        //If the login button click open the login form
        AdminLogin frmLogin = new AdminLogin();
        frmLogin.show();
        this.hide();
    }//GEN-LAST:event_btnAdminLoginActionPerformed

    private void btnCloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCloseActionPerformed
        // TODO add your handling code here:
        //Close
        dispose();
    }//GEN-LAST:event_btnCloseActionPerformed

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
            java.util.logging.Logger.getLogger(Guest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Guest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Guest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Guest.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Guest().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdminLogin;
    private javax.swing.JButton btnAdminRegister;
    private javax.swing.JButton btnClose;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblGuest;
    // End of variables declaration//GEN-END:variables
}
