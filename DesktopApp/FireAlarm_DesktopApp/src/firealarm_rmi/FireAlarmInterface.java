/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firealarm_rmi;



import java.rmi.*;
public interface FireAlarmInterface extends Remote{
    
    
    public boolean AdminLogin(String email,String password) throws RemoteException;
    
    public boolean AdminRegister(String name,String email,String password) throws RemoteException;
    
    public boolean RegisterSensor(String roomNo,String flooNo) throws RemoteException;
    
    public boolean UpdateFireAlarm(int roomNo,int floorNo,int id) throws RemoteException;
    
    public boolean DeleteFireAlarm(int id) throws RemoteException;
    
    public void showAll() throws RemoteException;
       
    public boolean getLogin(String user, String pass ) throws RemoteException;
}
