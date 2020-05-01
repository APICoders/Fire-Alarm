/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firealarm_rmi;

/**
 *
 * @author Pasan
 */
import firealarm_ui.Alert;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FireAlarmImplement extends UnicastRemoteObject implements FireAlarmInterface{
    
        //Intialize Variable
        StringBuffer response;
        Timer refreshTimer;
        
    public FireAlarmImplement() throws RemoteException{
        
        getStatus();
        //Set Refresh
         refreshTimer =new Timer(15000, new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  getStatus();
              }
          });
          refreshTimer.start();
    }
     
    


    @Override
    public boolean AdminLogin(String email, String password) throws RemoteException {
        
        boolean found= false;
                 
        try {
            //Call api url
            String url = "http://localhost:8081/FireAlarmMonitor/rest/fireAlarms/getUser/"+email+"/"+password+"/";
            URL obj;
            
            obj = new URL(url);
            
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            //Method GET
            con.setRequestMethod("GET");
            //add request header
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            BufferedReader bufferedReader = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            
        
            String value;
            StringBuffer response = new StringBuffer();
            while ((value = bufferedReader.readLine()) != null) {

               response.append(value);

            }
              JSONObject jobj = new JSONObject(response.toString());

               
               int uvalid = jobj.getInt("valid");
               
               if(uvalid == 1){
                   //Found User
                   return found = true;
               }
               else
                   //Cant find
                   return found = false;
   
     
        } catch (MalformedURLException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
       
   }    catch (JSONException ex) {    
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        }    
     
      
        return found;//Return the result
     
    }

    @Override
    public boolean AdminRegister(String name, String email, String password) throws RemoteException {
          boolean reg_user = false;
        try {
            //URL call in the API
            String url = "http://localhost:8081/FireAlarmMonitor/rest/fireAlarms/addUser/";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection)obj.openConnection();
            
            //Creating the POST request
            con.setRequestMethod("POST");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setRequestProperty("Content-Type","application/json");
            
            //creating a JSON object using json-simple library
            JSONObject jObject = new JSONObject();
            jObject.put("name",name);
            jObject.put("email",email);
            jObject.put("password",password);
            
            //converting the JSON object
            String data = jObject.toString();
            
            System.out.println(data);
            
            //Insert data to output stream
            con.setDoOutput(true);
            DataOutputStream stream = new DataOutputStream(con.getOutputStream());
            stream.writeBytes(data);
            System.out.println("Added successfully");
            stream.flush();
            stream.close();
            
            int responseCode = con.getResponseCode();
            System.out.println("Sending 'POST' request to URL : " + url);
            System.out.println("Data sending : " + data);
            System.out.println("Response Code : " + responseCode);
            
            reg_user = true;//Return the result

            
         
        } catch (MalformedURLException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
         return reg_user;
    }

    @Override
    public boolean RegisterAlarm(String floorNo, String roomNo) throws RemoteException {
         
        boolean reg_alarm = false;
        try {
            //URL call in the API
            String url = "http://localhost:8081/FireAlarmMonitor/rest/fireAlarms/addAlarm/";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection)obj.openConnection();
            
            //Creating the POST request
            con.setRequestMethod("POST");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setRequestProperty("Content-Type","application/json");
            
            //creating a JSON object using json-simple library
            JSONObject jObject = new JSONObject();
            jObject.put("roomNo",roomNo);
            jObject.put("floorNo",floorNo);
            
            //converting the JSON object
            String data = jObject.toString();
            
            System.out.println(data);
            
            //Insert data to output stream
            con.setDoOutput(true);
            DataOutputStream stream = new DataOutputStream(con.getOutputStream());
            stream.writeBytes(data);
            System.out.println("Added successfully");
            stream.flush();
            stream.close();
            
            int responseCode = con.getResponseCode();
            System.out.println("Sending 'POST' request to URL : " + url);
            System.out.println("Data sending : " + data);
            System.out.println("Response Code : " + responseCode);
            
            reg_alarm = true;//Return the result

            
         
        } catch (MalformedURLException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
         return reg_alarm;
    }

    @Override
    public boolean UpdateFireAlarm(String floorNo, String roomNo, int id) throws RemoteException {
        boolean update_alarm = false;
        try {
            //URL  call in the API
            String url = "http://localhost:8081/FireAlarmMonitor/rest/fireAlarms/updateFireAlarm/"+id;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection)obj.openConnection();
            
            //Creating the put request
            con.setRequestMethod("PUT");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setRequestProperty("Content-Type","application/json");
            
            //creating a JSON object using json-simple library
            JSONObject jObject = new JSONObject();
            jObject.put("roomNo",roomNo);
            jObject.put("floorNo",floorNo);
            
            //converting the JSON object
            String data = jObject.toString();
            
            System.out.println(data);
            
            //Insert data to output stream
            con.setDoOutput(true);
            DataOutputStream stream = new DataOutputStream(con.getOutputStream());
            stream.writeBytes(data);
            System.out.println("Update successfully");
            stream.flush();
            stream.close();
            
            int responseCode = con.getResponseCode();
            System.out.println("Sending 'PUT' request to URL : " + url);
            System.out.println("Data sending : " + data);
            System.out.println("Response Code : " + responseCode);
            
            update_alarm = true;//Return the result

            
         
        } catch (MalformedURLException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
         return update_alarm;
    }

    @Override
    public boolean DeleteFireAlarm(int id) throws RemoteException {
          boolean delete_alarm = false;
      try {
            //URL for the Delete function call in the API
            String url = "http://localhost:8081/FireAlarmMonitor/rest/fireAlarms/deleteFireAlarm/"+id;
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection)obj.openConnection();
            
            //Creating the DELETE request
            con.setRequestMethod("DELETE");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setRequestProperty("Content-Type","application/json");
            
            //creating a JSON object using json-simple library
            JSONObject jObject = new JSONObject();
        
            
            //converting the JSON object
            String data = jObject.toString();
    
            //Insert data to output stream
            con.setDoOutput(true);
            DataOutputStream stream = new DataOutputStream(con.getOutputStream());
            stream.writeBytes(data);
            System.out.println("Delete successfully");
            stream.flush();
            stream.close();
            
            int responseCode = con.getResponseCode();
            System.out.println("Sending 'DELETE' request to URL : " + url);
            System.out.println("Data sending : " + data);
            System.out.println("Response Code : " + responseCode);
            
            delete_alarm = true;

            
         
        } catch (MalformedURLException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (IOException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
         return delete_alarm;
    }
   
     
    @Override
    public StringBuffer showfirealarm() throws RemoteException {
        
 
      return response;//Retrn the result
        
    }

   
    public void getStatus() {
        
        response = new StringBuffer();
         try {
            //URL for the function call in the API
            String url = "http://localhost:8081/FireAlarmMonitor/rest/fireAlarms/";
            URL urlobj;
             System.out.println("\n request to URL [GET] for REFRESH : " + url);
            
            urlobj = new URL(url);
            
            HttpURLConnection connection = (HttpURLConnection) urlobj.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = connection.getResponseCode();
           
          
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));
            
        
            String inputLine;
            
            while ((inputLine = in.readLine()) != null) {

               response.append(inputLine);

            }
            in.close();
             System.out.println(response.toString());
         
            //Responce add to JSON array
                    JSONArray firealarm = new JSONArray(response.toString());
                        
                    //Devide the JSON object to json array
                     for (int i = 0; i < firealarm.length(); ++i) {
                            JSONObject fireobj = firealarm.getJSONObject(i);
                            int id = fireobj.getInt("id");
                            String floor = fireobj.getString("floorNo");
                            String room = fireobj.getString("roomNo");
                            int co2 = fireobj.getInt("co2Level");
                            int smoke = fireobj.getInt("smokeLevel");
                            int status = fireobj.getInt("status");
                         
                            //If co2 or smoke level increse the 5 Display the alert
                           if(co2 > 5 || smoke > 5){
                               //Send sms and mail
                              sendMail(id,floor,room,co2,smoke);
                              sendSms(id, floor, room, co2, smoke);
                           }
                        

                
            }
   
     
        } catch (MalformedURLException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
       
        }   catch (JSONException ex) {
                Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
            }
     
    }
    
    private void sendMail(int id,String floor,String room,int co2,int smoke){
        
         try {
            //URL call in the API to send mail
            String url = "http://localhost:8081/FireAlarmMonitor/rest/fireAlarms/sendMail/";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection)obj.openConnection();
            
            //Creating the POST request
            con.setRequestMethod("POST");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setRequestProperty("Content-Type","application/json");
            
            //creating a JSON object using json-simple library
            JSONObject jObject = new JSONObject();
            jObject.put("id",id);
            jObject.put("floorNo",floor);
            jObject.put("roomNo",room);
            jObject.put("co2Level",co2);
             jObject.put("smokeLevel",smoke);
            
            //converting the JSON object
            String data = jObject.toString();
            
            System.out.println(data);
            
            //Insert data to output stream
            con.setDoOutput(true);
            DataOutputStream stream = new DataOutputStream(con.getOutputStream());
            stream.writeBytes(data);
            stream.flush();
            stream.close();
            
            int responseCode = con.getResponseCode();
            System.out.println("Sending 'POST' request to email : " + url);
            System.out.println("Data sending : " + data);
            System.out.println("Response Code : " + responseCode);
            
            

            
         
        } catch (MalformedURLException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    private void sendSms(int id,String floor,String room,int co2,int smoke){
        
         try {
            //URL call in the API to send mail
            String url = "http://localhost:8081/FireAlarmMonitor/rest/fireAlarms/sendSMS/";
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection)obj.openConnection();
            
            //Creating the POST request
            con.setRequestMethod("POST");
            con.setRequestProperty("Accept-Language", "en-US,en;q=0.5");
            con.setRequestProperty("Content-Type","application/json");
            
            //creating a JSON object using json-simple library
            JSONObject jObject = new JSONObject();
            jObject.put("id",id);
            jObject.put("floorNo",floor);
            jObject.put("roomNo",room);
            jObject.put("co2Level",co2);
             jObject.put("smokeLevel",smoke);
            
            //converting the JSON object
            String data = jObject.toString();
            
            System.out.println(data);
            
            //Insert data to output stream
            con.setDoOutput(true);
            DataOutputStream stream = new DataOutputStream(con.getOutputStream());
            stream.writeBytes(data);
            stream.flush();
            stream.close();
            
            int responseCode = con.getResponseCode();
            System.out.println("Sending 'POST' request to sms : " + url);
            System.out.println("Data sending : " + data);
            System.out.println("Response Code : " + responseCode);
            
            

            
         
        } catch (MalformedURLException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JSONException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
