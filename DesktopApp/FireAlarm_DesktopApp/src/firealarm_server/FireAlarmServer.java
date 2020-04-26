/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firealarm_server;

/**
 *
 * @author Pasan
 */
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
