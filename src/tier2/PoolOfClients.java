package tier2;

import tier1.model.clerk.IClerk;
import tier1.model.customer.IAccount;
import tier1.networking.adminclient.IAdminClient;
import tier1.networking.clerkclient.IClerkClient;
import tier1.networking.customerclient.ICustomerClient;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PoolOfClients implements Serializable
{
  private List<ICustomerClient> customers;
  private List<IAdminClient> admins;
  private List<IClerkClient> clerks;
  public PoolOfClients(){
    customers = new ArrayList<ICustomerClient>();
    admins = new ArrayList<IAdminClient>();
    clerks = new ArrayList<IClerkClient>();
  }

  public void addCustomer(ICustomerClient client){
    customers.add(client);
  }
  public void addAdmin(IAdminClient client){
    admins.add(client);
  }
  public void addClerk(IClerkClient client){
    clerks.add(client);
  }
}
