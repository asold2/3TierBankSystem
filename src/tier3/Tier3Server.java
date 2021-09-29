package tier3;

import tier1.model.customer.AccountModel;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Tier3Server extends Remote
{
  void createAccount(String name, String lastname, int id, double amount) throws RemoteException;
  void withdraw(int id, double amount) throws RemoteException;
  void supply(int id, double amount) throws RemoteException;
  void start() throws RemoteException;
  AccountModel getAccount(int id) throws RemoteException;
}
