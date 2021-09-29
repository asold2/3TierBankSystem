package tier1.view;

import javafx.fxml.FXML;
import tier1.viewmodel.ViewModelFactory;

import java.io.IOException;

public class FirstWindowController
{
    private ViewHandler vh;
    private ViewModelFactory vmf;


    @FXML public void onButtonAdmin() throws IOException
    {
      vh.openAdminView();
    }
    @FXML public void onButtonClerk() throws IOException
    {
    vh.openClerkView();
  }
    @FXML public void onButtonCustomer() throws IOException
    {
    vh.openCustomerView();
}

  public void init(ViewHandler viewHandler, ViewModelFactory vmf)
  {
    this.vh = viewHandler;
    this.vmf = vmf;
  }
}
