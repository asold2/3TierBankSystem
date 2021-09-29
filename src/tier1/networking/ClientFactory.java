package tier1.networking;

import tier1.networking.adminclient.AdminClient;
import tier1.networking.adminclient.IAdminClient;
import tier1.networking.clerkclient.ClerkClient;
import tier1.networking.clerkclient.IClerkClient;
import tier1.networking.customerclient.CustomerClient;
import tier1.networking.customerclient.ICustomerClient;

import java.rmi.RemoteException;

public class ClientFactory
{
  private IAdminClient adminClient;
  private IClerkClient clerkClient;
  private ICustomerClient customer;
  public IAdminClient getAdminClient(){
    if(adminClient==null){
      try
      {
        adminClient = new AdminClient();
      }
      catch (RemoteException e)
      {
        e.printStackTrace();
      }
    }
    return adminClient;
  }
  public ICustomerClient getCustomer(){
    if(customer==null){
      try
      {
        customer = new CustomerClient();
      }
      catch (RemoteException e)
      {
        e.printStackTrace();
      }
    }
    return customer;
  }

  public IClerkClient getClerkClient()
  {
    if(clerkClient==null){
      try
      {
        clerkClient = new ClerkClient();
      }
      catch (RemoteException e)
      {
        e.printStackTrace();
      }
    }
    return clerkClient;
  }
}
