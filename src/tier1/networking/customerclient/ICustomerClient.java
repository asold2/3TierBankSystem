package tier1.networking.customerclient;

import tier1.model.customer.AccountModel;

import java.io.Serializable;
import java.rmi.RemoteException;

public interface ICustomerClient extends Serializable
{

  public static final String CLIENT_SERVICE_NAME = "rmi://localhost/CLIENT";
  void withdraw(int id, double amount) throws RemoteException;
  boolean login(int id) throws RemoteException;
  AccountModel getAccountById(int id) throws RemoteException;
}
