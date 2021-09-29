package tier1.networking.clerkclient;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IClerkClient extends Remote
{
  public static final String CLERK_SERVICE_NAME = "rmi://localhost/CLERK";
  void withdraw(int id, double amount) throws RemoteException;
  void supply(int id, double amount)  throws RemoteException;

}
