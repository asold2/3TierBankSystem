package tier1.networking.adminclient;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface IAdminClient extends Remote
{
  void createAccount(String name, String lastname, int id, double amount) throws
      RemoteException;
  public static final String ADMIN_SERVICE_NAME = "rmi://localhost/ADMIN";

}
