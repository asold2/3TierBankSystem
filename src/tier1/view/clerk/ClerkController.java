package tier1.view.clerk;

import javafx.fxml.FXML;
import tier1.view.ViewHandler;
import tier1.viewmodel.ViewModelFactory;
import tier1.viewmodel.clerk.ClerkViewModel;
import javafx.scene.control.TextField;


public class ClerkController
{
  private ViewHandler vh;
  private ViewModelFactory vmf;
  @FXML private TextField id;
  @FXML private TextField amount;
  private ClerkViewModel clerkViewModel;

  public void init(ViewHandler vh, ViewModelFactory vmf){
    this.vh = vh;
    this.vmf = vmf;
    clerkViewModel = vmf.getClerkViewModel();
  }
  @FXML public void onButtonWithdraw(){
    clerkViewModel.withdraw(Integer.parseInt(id.getText()), Double.parseDouble(amount.getText()));
  }
  @FXML public void onButtonSupply(){
    clerkViewModel.supply(Integer.parseInt(id.getText()), Double.parseDouble(amount.getText()));
  }
}
