package tier1.view.customer;

import javafx.fxml.FXML;
import tier1.view.ViewHandler;
import tier1.viewmodel.ViewModelFactory;
import tier1.viewmodel.customer.CustomerViewModel;

import java.awt.*;

public class CustomerController
{
  private ViewHandler vh;
  private ViewModelFactory vmf;
  private CustomerViewModel customerViewModel;
  @FXML private TextField id;
  @FXML private TextField amount;
  @FXML private Button withdraw;


  public void init(ViewHandler vh, ViewModelFactory vmf){
    this.vh = vh;
    this.vmf = vmf;
    amount.setEditable(false);
    withdraw.setVisible(false);
    customerViewModel = vmf.getCustomerViewModel();
  }

  @FXML public void onButtonLogin(){
    if(customerViewModel.login(Integer.parseInt(id.getText()))){
      amount.setEditable(true);
      withdraw.setVisible(true);
    };
  }

}
