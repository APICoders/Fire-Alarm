/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firealarm_rmi;



import java.rmi.*;
import org.json.JSONArray;
public interface FireAlarmInterface extends Remote{
    
    
    public boolean AdminLogin(String email,String password) throws RemoteException;
    
    public boolean AdminRegister(String name,String email,String password) throws RemoteException;
    
    public boolean RegisterAlarm(String floorNo,String roomNo) throws RemoteException;
    
    public boolean UpdateFireAlarm(String floorNo,String roomNo,int id) throws RemoteException;
    
    public boolean DeleteFireAlarm(int id) throws RemoteException;
    
    public StringBuffer showfirealarm() throws RemoteException;  
    
    
}
