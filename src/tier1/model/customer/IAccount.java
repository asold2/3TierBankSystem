package tier1.model.customer;

import java.rmi.RemoteException;

public interface IAccount
{
  boolean login(int Id);
  void withdraw(int id, double amount) throws RemoteException;
  String getName();
  String getLastName();
  int getId();
  double getAmount();
  void set(String name, String lastname, int id, double amount);


}
