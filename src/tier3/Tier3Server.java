package tier3;

import tier1.model.customer.AccountModel;
import tier1.model.customer.IAccount;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface Tier3Server extends Remote
{
  void createAccount(String name, String lastname, int id, double amount) throws RemoteException;
  void withdraw(int id, double amount) throws RemoteException;
  void supply(int id, double amount) throws RemoteException;
  void start() throws RemoteException;
  IAccount getAccount(int id) throws RemoteException, SQLException;
}
