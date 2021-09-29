package tier1.model.clerk;

import tier1.networking.clerkclient.IClerkClient;

import java.rmi.RemoteException;

public class Clerk implements IClerk
{
  private IClerkClient client;

  public Clerk(IClerkClient client){
    this.client = client;
  }

  @Override public void withdraw(int id, double amount)
  {
    try
    {
      client.withdraw(id, amount);
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
      client.supply(id, amount);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }
}
