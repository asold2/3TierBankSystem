package tier1.networking.clerkclient;

import tier2.Tier2Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import static tier2.Tier2Server.T2_SERVICE_NAME;

public class ClerkClient extends UnicastRemoteObject implements IClerkClient
{
  private  Tier2Server server;
  public ClerkClient() throws RemoteException
  {
    try
    {
      Naming.rebind(CLERK_SERVICE_NAME, this);
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
    server.getPoolOfClients().addClerk(this);
  }

  @Override public void withdraw(int id, double amount)
  {
    try
    {
      server.withdraw(id, amount);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void supply(int id, double amount)
  {
    try
    {
      server.supply(id, amount);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }
}
