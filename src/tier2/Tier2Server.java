package tier2;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public interface Tier2Server extends Remote
{
  void createAccount(int id, String name, String lastname, double amount) throws RemoteException;
  void withdraw(int accountId, double amount) throws RemoteException;
  void supply(int accountId, double amount) throws RemoteException;
  void start() throws RemoteException;
  public static final String T2_SERVICE_NAME = "rmi://localhost/T2";
  boolean login(int id) throws RemoteException;
}
