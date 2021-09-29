package tier1.viewmodel.customer;

import tier1.model.customer.AccountModel;
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

  public AccountModel getAccountById(int id){
    return customer.getAccountById(id);
  }

  public void withdraw(int parseInt, double parseDouble)
  {
    try
    {
      customer.withdraw(parseInt, parseDouble);
      System.out.println("Here1");
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }
}
