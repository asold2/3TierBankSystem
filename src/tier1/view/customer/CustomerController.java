package tier1.view.customer;

import javafx.fxml.FXML;

import javafx.scene.control.*;
import tier1.view.ViewHandler;
import tier1.viewmodel.ViewModelFactory;
import tier1.viewmodel.customer.CustomerViewModel;



public class CustomerController
{
  private ViewHandler vh;
  private ViewModelFactory vmf;
  private CustomerViewModel customerViewModel;
  @FXML private TextField id;
  @FXML private TextField amount;
  @FXML private Button withdraw;
  @FXML private Label error;
  @FXML private Label myMoney;


  public void init(ViewHandler vh, ViewModelFactory vmf){
    this.vh = vh;
    this.vmf = vmf;
    amount.setEditable(false);
    withdraw.setVisible(false);
    customerViewModel = vmf.getCustomerViewModel();
    error.setVisible(false);
  }

  @FXML public void onButtonLogin(){
    if(customerViewModel.login(Integer.parseInt(id.getText()))){
      amount.setEditable(true);
      withdraw.setVisible(true);
      error.setVisible(false);
      myMoney.setVisible(true);
      myMoney.setText(String.valueOf(customerViewModel.getAccountById(Integer.parseInt(id.getText())).getAmount()));
    }
    else{
      error.setVisible(true);
    }
  }
  @FXML public void onWithdraw(){
    customerViewModel.withdraw(Integer.parseInt(id.getText()), Double.parseDouble(amount.getText()));
    System.out.println("Money withdrown by client");

  }

}
