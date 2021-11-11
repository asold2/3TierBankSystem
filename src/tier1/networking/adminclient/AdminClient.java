package tier1.networking.adminclient;

import tier2.Tier2Server;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import static tier2.Tier2Server.T2_SERVICE_NAME;

public class AdminClient extends UnicastRemoteObject implements IAdminClient
{
  private Tier2Server server;

  public AdminClient() throws RemoteException
  {
    try
    {
      Naming.rebind(ADMIN_SERVICE_NAME, this);
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
    catch (NotBoundException | MalformedURLException | RemoteException e)
    {
      e.printStackTrace();
    }
    server.getPoolOfClients().addAdmin(this);

  }

  @Override public void createAccount(String name, String lastname, int id,
      double amount) throws RemoteException
  {
    server.createAccount(id, name, lastname, amount);
  }

}
