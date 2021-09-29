package tier1.model.admin;

import tier1.networking.adminclient.IAdminClient;

import java.rmi.RemoteException;

public class Admin implements IAdmin
{
  private IAdminClient client;

  public Admin(IAdminClient client){
    this.client = client;
  }
  @Override public void createAccount(String name, String lastname, int id, double amount)
  {
    try
    {
      client.createAccount(name, lastname, id, amount);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }


}
