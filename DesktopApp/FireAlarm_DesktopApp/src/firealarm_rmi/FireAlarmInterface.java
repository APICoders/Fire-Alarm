
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
