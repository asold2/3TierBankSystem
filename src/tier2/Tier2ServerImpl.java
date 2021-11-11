package tier2;

import tier1.model.customer.AccountModel;
import tier1.model.customer.IAccount;
import tier3.Tier3Server;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class Tier2ServerImpl extends UnicastRemoteObject implements Tier2Server
{
  private Tier3Server tier3;
  private PoolOfClients poolOfClients;
  private PropertyChangeSupport support;
  public Tier2ServerImpl() throws RemoteException
  {
    try
    {
      Naming.rebind(T2_SERVICE_NAME, this);

    }
    catch (MalformedURLException e)
    {
      e.printStackTrace();
    }
    try
    {
      tier3 = (Tier3Server) Naming.lookup("DatabaseServer");
    }
    catch (NotBoundException | MalformedURLException e)
    {
      e.printStackTrace();
    }
    poolOfClients = new PoolOfClients();

  }

  @Override public boolean login(int id)
  {
    try
    {
      IAccount temp = (AccountModel) tier3.getAccount(id);
      return temp!=null;
    }
    catch (RemoteException | SQLException e)
    {
      e.printStackTrace();
    }
    return false;
  }

  @Override public AccountModel getAccountById(int id)
  {
    try
    {
      return (AccountModel) tier3.getAccount(id);
    }
    catch (RemoteException | SQLException e)
    {
      e.printStackTrace();
    }
    return null;
  }

  @Override public PoolOfClients getPoolOfClients()
  {
    return poolOfClients;
  }

  @Override public void createAccount(int id, String name, String lastname,
      double amount)
  {
    AccountModel account = new AccountModel();
    account.set(name, lastname, id, amount);
    try
    {
      tier3.createAccount(account.getName(), account.getLastName(), account.getId(), account.getAmount());
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void withdraw(int accountId, double amount)
  {
    try
    {
      tier3.withdraw(accountId, - amount);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void supply(int accountId, double amount)
  {
    try
    {
      tier3.supply(accountId, amount);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }

  }

}
