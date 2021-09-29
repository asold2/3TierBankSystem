package tier3;

import tier1.model.customer.AccountModel;

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

  @Override public AccountModel getAccount(int id) throws RemoteException
  {
    ResultSet rs = null;
    rs = databaseConnection.getAccountById(id);
    AccountModel account = new AccountModel();
    while(true){
      try
      {
        if (!rs.next())
          break;
      }
      catch (SQLException throwables)
      {
        throwables.printStackTrace();
      }
      String name = null;
      try
      {
        name = rs.getString("name");
      }
      catch (SQLException throwables)
      {
        throwables.printStackTrace();
      }
      String lastName = null;
      try
      {
        lastName = rs.getString("lastname");
      }
      catch (SQLException throwables)
      {
        throwables.printStackTrace();
      }
      double amount = 0;
      try
      {
        amount = rs.getDouble("amount");
      }
      catch (SQLException throwables)
      {
        throwables.printStackTrace();
      }
      account.set(name, lastName, id, amount);
    }

    return account;
  }
}
