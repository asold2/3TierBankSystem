package tier1.viewmodel;

import tier1.model.ModelFactory;
import tier1.viewmodel.admin.AdminViewModel;
import tier1.viewmodel.clerk.ClerkViewModel;
import tier1.viewmodel.customer.CustomerViewModel;

public class ViewModelFactory
{
  private AdminViewModel adminViewModel;
  private ClerkViewModel clerkViewModel;
  private CustomerViewModel customerViewModel;

  public ViewModelFactory(ModelFactory mf){
    this.adminViewModel = new AdminViewModel(mf.getAdminModel());
    this.clerkViewModel = new ClerkViewModel(mf.getClerk());
    this.customerViewModel = new CustomerViewModel(mf.getCustomer());
  }

  public AdminViewModel getAdminViewModel()
  {
    return adminViewModel;
  }
  public ClerkViewModel getClerkViewModel(){
    return clerkViewModel;
  }

  public CustomerViewModel getCustomerViewModel()
  {
    return customerViewModel;
  }
}
