package tier1.viewmodel.clerk;

import tier1.model.clerk.IClerk;

public class ClerkViewModel
{
  private IClerk clerk;

  public ClerkViewModel(IClerk clerk){
    this.clerk = clerk;
  }

  public void withdraw(int id, double amount){
    clerk.withdraw(id, amount);
  }
  public void supply(int id, double amount){
    clerk.supply(id, amount);
  }
}
