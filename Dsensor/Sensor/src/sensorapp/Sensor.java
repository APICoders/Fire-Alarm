/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sensorapp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.Timer;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author Pasan
 */
public class Sensor extends javax.swing.JFrame {

    /**
     * Creates new form Sensor
     */
    
    int smokeLevel = 0;
    int co2Level = 0;
    int command = 0;
     Timer refreshTimer;
                
    public Sensor() {
        initComponents();
    }

    private void stopSensor(int id) {
		
        try {
            //URL for the updateFireAlarmRecords function call in the API
            String RequestUrl = "http://localhost:8081/FireAlarmMonitor/rest/fireAlarms/updateRecords/"+id;
            URL obj = new URL(RequestUrl);
            HttpURLConnection httpCon = (HttpURLConnection)obj.openConnection();
            
            //Creating the put request
            httpCon.setRequestMethod("PUT");
            httpCon.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            httpCon.setRequestProperty("Content-Type","application/json");
            
            //creating a JSON object using json-simple library
            JSONObject jObject = new JSONObject();
            jObject.put("id",id);
            jObject.put("status",0);
            jObject.put("smokeLevel",0);
            jObject.put("co2Level",0);
            
            //converting the JSON object
            String data = jObject.toString();
            
            System.out.println(data);
            
            //Insert data to output stream
            httpCon.setDoOutput(true);
            DataOutputStream stream = new DataOutputStream(httpCon.getOutputStream());
            stream.writeBytes(data);
            System.out.println("update successfully");
            stream.flush();
            stream.close();
            
            int responseCode = httpCon.getResponseCode();
            System.out.println("'PUT' request to URL : " + RequestUrl);
      
            
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(httpCon.getInputStream()));
            String output;
            StringBuffer response = new StringBuffer();
            
            while ((output = reader.readLine()) != null) {
                response.append(output);
            }
            
            
            reader.close();
            
            //printing result from response
            System.out.println(response.toString());
        } catch (MalformedURLException ex) {
            Logger.getLogger(Sensor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Sensor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(Sensor.class.getName()).log(Level.SEVERE, null, ex);
        }
		
	}
    
    private void sendSensorData(int id,int smokeLevel, int co2Level) throws Exception{
		//URL for the updateFireAlarmRecords function call in the API
		String RequestUrl = "http://localhost:8081/FireAlarmMonitor/rest/fireAlarms/updateRecords/"+id;
		URL obj = new URL(RequestUrl);
		HttpURLConnection httpCon = (HttpURLConnection)obj.openConnection();
		
		//Creating the put request
		httpCon.setRequestMethod("PUT");
		httpCon.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
		httpCon.setRequestProperty("Content-Type","application/json");
		
		//creating a JSON object using json-simple library
		JSONObject jObject = new JSONObject();
		jObject.put("id",id);
		jObject.put("status",1);
		jObject.put("smokeLevel",smokeLevel);
		jObject.put("co2Level",co2Level);
		
		//converting the JSON object 
		String data = jObject.toString();
		
		System.out.println(data);
		
		 //Insert data to output stream
		httpCon.setDoOutput(true);
		DataOutputStream stream = new DataOutputStream(httpCon.getOutputStream());
		stream.writeBytes(data);
		System.out.println("update successfully");
		stream.flush();
		stream.close();
		
		int responseCode = httpCon.getResponseCode();
		  System.out.println("'PUT' request to URL : " + RequestUrl);
	
		 
		  BufferedReader reader = new BufferedReader(
		          new InputStreamReader(httpCon.getInputStream()));
		  String output;
		  StringBuffer response = new StringBuffer();
		 
		  while ((output = reader.readLine()) != null) {
		   response.append(output);
		  }
		  
		  
		  reader.close();
		  
		  //printing result from response
		  System.out.println(response.toString());
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
        btnStart = new javax.swing.JButton();
        btnStop = new javax.swing.JButton();
        txtID = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(new javax.swing.border.MatteBorder(null));

        btnStart.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        btnStop.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        btnStop.setText("Stop");
        btnStop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStopActionPerformed(evt);
            }
        });

        txtID.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Sensor");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(195, 195, 195)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("ID");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(btnStop, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(118, 118, 118)
                        .addComponent(jLabel2)
                        .addGap(28, 28, 28)
                        .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(129, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnStart)
                    .addComponent(btnStop))
                .addGap(79, 79, 79))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        // TODO add your handling code here:
         //Timer Auto refresh the 10 secounds
          refreshTimer =new Timer(10000, new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  //What event run given time
                  sensorRefresh();
              }
          });
          refreshTimer.start();//Start timer
       
                
    }//GEN-LAST:event_btnStartActionPerformed

    private void btnStopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStopActionPerformed
        // TODO add your handling code here:
        refreshTimer.stop();
        stopSensor(Integer.parseInt(txtID.getText()));
    }//GEN-LAST:event_btnStopActionPerformed

    
    private void sensorRefresh(){
         //Assign random values for smoke level and carbondioxide level readings
         
		Random randomGenerator=new Random();
		
		smokeLevel = randomGenerator.nextInt(10) + 1;
		co2Level = randomGenerator.nextInt(10) + 1;
		
		System.out.println("Co2 val:"+co2Level);
		System.out.println("smoke lavel:"+smokeLevel);
		try {
			
			sendSensorData(Integer.parseInt(txtID.getText()),smokeLevel,co2Level);
			Thread.sleep(5000);
		} catch (Exception e) {
			
			e.printStackTrace();
		}
    }
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
            java.util.logging.Logger.getLogger(Sensor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sensor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sensor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sensor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sensor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnStop;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JTextField txtID;
    // End of variables declaration//GEN-END:variables
}
