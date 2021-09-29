package tier1.networking.customerclient;

import java.rmi.RemoteException;

public interface ICustomerClient
{

  public static final String CLIENT_SERVICE_NAME = "rmi://localhost/CLIENT";
  void withdraw(int id, double amount) throws RemoteException;
  boolean login(int id) throws RemoteException;
}
