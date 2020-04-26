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
import java.io.BufferedReader;
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
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FireAlarmImplement extends UnicastRemoteObject implements FireAlarmInterface{

    public FireAlarmImplement() throws RemoteException{
        
    }
    
    
    public boolean getLogin(String user, String pass) throws RemoteException 
    {
         
        boolean found=false;
        try 
        {
            if(user.equals("admin") && pass.equals("123")||user.equals("admin1") && pass.equals("1234")||user.equals("admin2") && pass.equals("12345") )
            {
          // Carteira cart1 = new Carteira();
            //    System.out.println("Seu saldo é de:"+cart1.getCarteira());
   // MenuCantina menucan = new MenuCantina();
         //   menucan.menu();
             
                
                
                
                  JOptionPane.showMessageDialog(null, "Login com sucesso");
         
                
                
           // menucan.menu();
            
          
            
               return found=true;
                
            }
            else
            {
                return found=false;
            }
        } 
        
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
       
        return found;
        
        
    }


    public void showAll() throws RemoteException {
        
        
      
            
        try {
            String url = "http://localhost:8080/FireAlarmMonitor/rest/fireAlarms/";
            URL obj;
            
            obj = new URL(url);
            
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // optional default is GET
            con.setRequestMethod("GET");
            //add request header
            con.setRequestProperty("User-Agent", "Mozilla/5.0");
            int responseCode = con.getResponseCode();
            System.out.println("\nSending 'GET' request to URL : " + url);
            System.out.println("Response Code : " + responseCode);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            
        
            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {

               response.append(inputLine);

            }
            in.close();
 
            System.out.println(response.toString());
       
            JSONArray my = new JSONArray(response.toString());
            
            for (int i = 0; i < my.length(); ++i) {
    JSONObject rec = my.getJSONObject(i);
    int id = rec.getInt("co2Level");
  //  String loc = rec.getString("loc");
    // ...
    
                System.out.println(id);
}
            
   
     
        } catch (MalformedURLException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ProtocolException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
       
   }    catch (JSONException ex) {    
            Logger.getLogger(FireAlarmImplement.class.getName()).log(Level.SEVERE, null, ex);
        }    
     
      
        
    
    }

    @Override
    public boolean AdminLogin(String email, String password) throws RemoteException {
        
        boolean found= false;
                 
        try {
            String url = "http://localhost:8080/FireAlarmMonitor/rest/fireAlarms/getUser/"+email+"/"+password+"/";
            URL obj;
            
            obj = new URL(url);
            
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            // optional default is GET
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
     
             
              
               String uemail = jobj.getString("email");
               String upass = jobj.getString("password");
               int uvalid = jobj.getInt("valid");
               
               if(uvalid == 1){
                   return found = true;
               }
               else
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
     
      
        return found;
     
    }

    @Override
    public boolean AdminRegister(String name, String email, String password) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean RegisterSensor(String roomNo, String flooNo) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean UpdateFireAlarm(int roomNo, int floorNo, int id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean DeleteFireAlarm(int id) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
