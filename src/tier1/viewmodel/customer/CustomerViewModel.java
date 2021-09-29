package tier1.viewmodel.customer;

import tier1.model.customer.IAccount;

import java.rmi.RemoteException;

public class CustomerViewModel
{
  private IAccount customer;

  public CustomerViewModel(IAccount customer){
    this.customer = customer;
  }

  public boolean login(int id)
  {
    return customer.login(id);
  }
}
