package tier1.view.admin;


import javafx.fxml.FXML;

import javafx.scene.control.TextField;
import tier1.model.admin.IAdmin;
import tier1.view.ViewHandler;
import tier1.viewmodel.ViewModelFactory;
import tier1.viewmodel.admin.AdminViewModel;

public class AdminController
{
  private @FXML TextField name;
  private @FXML TextField lastname;
  private @FXML TextField id;
  private @FXML TextField amount;

  private ViewModelFactory vmf;
  private ViewHandler vh;
  private AdminViewModel adminViewModel;




  public void init(ViewHandler vh, ViewModelFactory vmf){
    this.vmf = vmf;
    this.vh = vh;
    adminViewModel = vmf.getAdminViewModel();
  }




 @FXML
  public void onButtonAdd(){
   System.out.println("Hello from Admin");
   adminViewModel.createAccount(name.getText(), lastname.getText(), Integer.parseInt(id.getText()), Double.parseDouble(amount.getText()));
  }
}
