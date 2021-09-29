package tier3;

import tier1.model.customer.AccountModel;
import tier1.model.customer.IAccount;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Tier3ServerImpl implements Tier3Server, Remote
{
  private DatabaseConnection databaseConnection;
  public Tier3ServerImpl(String dataBasePassword){
    try
    {
      UnicastRemoteObject.exportObject(this, 0);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    databaseConnection = new DatabaseConnection(dataBasePassword);
  }





  @Override public void createAccount(String name, String lastname, int id, double amount)
  {
    databaseConnection.createAccount(id, name, lastname, amount);

  }

  @Override public void withdraw(int id, double amount)
  {
    databaseConnection.updateAmount(id, amount);
  }

  @Override public void supply(int id, double amount)
  {
    databaseConnection.updateAmount(id, amount);
  }

  @Override public void start()
  {
    try
    {
      Registry registry = LocateRegistry.createRegistry(1099);
      registry.bind("DatabaseServer", this);
      System.out.println("Database server started");
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    catch (AlreadyBoundException e)
    {
      e.printStackTrace();
    }

  }

  @Override public IAccount getAccount(int id)
      throws RemoteException, SQLException
  {
    ResultSet rs = null;
    rs = databaseConnection.getAccountById(id);
    IAccount account = new AccountModel();
    while(rs.next()){
      String name = rs.getString("name");
      String lastname = rs.getString("lastname");
      int id2 = rs.getInt("id");
      double amount = rs.getDouble("amount");
      account.set(name, lastname, id2, amount);
    }

    return account;
  }
}
