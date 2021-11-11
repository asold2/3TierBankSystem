package tier1.viewmodel.customer;

import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import tier1.model.customer.AccountModel;
import tier1.model.customer.IAccount;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;

public class CustomerViewModel
{
  private final IAccount customer;
  private StringProperty notification;

  public CustomerViewModel(IAccount customer){
    this.customer = customer;
    notification = new SimpleStringProperty();
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
  public StringProperty getNotification(){
    return notification;
  }
}
