package tier1.model;

import tier1.model.admin.Admin;
import tier1.model.admin.IAdmin;
import tier1.model.clerk.Clerk;
import tier1.model.clerk.IClerk;
import tier1.model.customer.AccountModel;
import tier1.model.customer.IAccount;
import tier1.networking.ClientFactory;

public class ModelFactory
{
  private IAdmin admin;
  private IClerk clerk;
  private IAccount customer;


  ClientFactory cf;
  public ModelFactory(ClientFactory cf){
    this.cf = cf;
  }
  public IAdmin getAdminModel(){
    if(admin==null){
      admin = new Admin(cf.getAdminClient());
    }
    return admin;
  }

  public IClerk getClerk()
  {
    if(clerk==null){
      clerk=new Clerk(cf.getClerkClient());
    }
    return clerk;
  }

  public IAccount getCustomer(){
    if(customer==null){
      customer = new AccountModel(cf.getCustomer());
    }
    return customer;
  }
}
