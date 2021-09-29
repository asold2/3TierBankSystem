package tier1.model.customer;

import tier1.networking.customerclient.ICustomerClient;

import java.io.Serializable;
import java.rmi.RemoteException;

public class AccountModel implements IAccount, Serializable
{
  private String name;
  private String lastName;
  private int id;
  private double amount;
  private ICustomerClient client;

  public AccountModel(){

  }
  public AccountModel(ICustomerClient client){
    this.client = client;
  }

  @Override public boolean login(int Id)
  {
    try
    {
      return client.login(Id);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return false;
  }

  @Override public void withdraw(int id, double amount) throws RemoteException
  {
    client.withdraw(this.id, amount);
  }

  public String getName()
  {
    return name;
  }



  public String getLastName()
  {
    return lastName;
  }



  public int getId()
  {
    return id;
  }



  public double getAmount()
  {
    return amount;
  }

  public void set(String name, String lastname, int id, double amount){
    this.name = name;
    this.lastName = lastname;
    this.id = id;
    this.amount = amount;
  }

}
