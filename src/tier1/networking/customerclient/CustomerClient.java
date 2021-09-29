package tier1.networking.customerclient;

import tier1.model.customer.AccountModel;
import tier2.Tier2Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import static tier2.Tier2Server.T2_SERVICE_NAME;

public class CustomerClient extends UnicastRemoteObject implements ICustomerClient
{
  private Tier2Server server;

  public CustomerClient() throws RemoteException
  {
    try
    {
      Naming.rebind(CLIENT_SERVICE_NAME, this);
      System.out.println("Client started");
    }
    catch (MalformedURLException | RemoteException e)
    {
      e.printStackTrace();
    }
    try
    {
      server = (Tier2Server) Naming.lookup(T2_SERVICE_NAME);
    }
    catch (NotBoundException | RemoteException | MalformedURLException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void withdraw(int id, double amount) throws RemoteException
  {
    server.withdraw(id, amount);
    System.out.println("Here3");
    System.out.println(getAccountById(id).getAmount());

  }

  @Override public boolean login(int id)
  {
    try
    {
      return server.login(id);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return false;
  }

  @Override public AccountModel getAccountById(int id)
  {
    try
    {
      return server.getAccountById(id);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return null;
  }
}
