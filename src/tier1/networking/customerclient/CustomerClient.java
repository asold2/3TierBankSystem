package tier1.networking.customerclient;

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
    catch (NotBoundException e)
    {
      e.printStackTrace();
    }
    catch (MalformedURLException e)
    {
      e.printStackTrace();
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void withdraw(int id, double amount) throws RemoteException
  {
    server.withdraw(id, amount);

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
}
