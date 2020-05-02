
package firealarm_server;


import firealarm_rmi.FireAlarmImplement;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
public class FireAlarmServer {
    
    public static void main(String[]args){
        
      
     try 
     {
           Registry register=LocateRegistry.createRegistry(1098);
                  
           FireAlarmImplement fireAlarmImplement=new FireAlarmImplement();
       
           register.rebind("firealarm", fireAlarmImplement);
           System.out.println("FireAlarm Server Start.");
           
           
     } 
     
     catch (Exception ex) 
     {
         ex.printStackTrace();
     }
 }   
}
