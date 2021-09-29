package tier1.viewmodel.admin;

import tier1.model.admin.IAdmin;

public class AdminViewModel
{
  private IAdmin admin;
  public AdminViewModel(IAdmin admin){
    this.admin = admin;
  }
  public void createAccount(String name, String lastname, int id, double amount){
    admin.createAccount(name, lastname, id, amount);
  }
}
