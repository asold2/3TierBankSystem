package tier1.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import tier1.view.admin.AdminController;
import tier1.view.clerk.ClerkController;
import tier1.view.customer.CustomerController;
import tier1.viewmodel.ViewModelFactory;

import java.io.IOException;

public class ViewHandler
{
  private Stage stage;
  private ViewModelFactory vmf;

  public ViewHandler(Stage stage, ViewModelFactory vmf){
    this.stage = stage;
    this.vmf = vmf;
  }
  public void start() throws IOException
  {
    this.openView();
  }

  private void openView() throws IOException
  {
    Scene scene = null;
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;
    loader.setLocation(this.getClass().getResource("../view/firstWindow.fxml"));
    root = loader.load();

    FirstWindowController controller = loader.getController();
    controller.init(this, vmf);
    stage.setTitle("Choose role");
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void openAdminView() throws IOException
  {
    Scene scene = null;
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;
    loader.setLocation(this.getClass().getResource("../view/admin/adminPage.fxml"));
    root = loader.load();

    AdminController controller = loader.getController();
    controller.init(this, vmf);
    stage.setTitle("Choose role");
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();

  }

  public void openClerkView() throws IOException
  {
    Scene scene = null;
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;
    loader.setLocation(this.getClass().getResource("../view/clerk/clerkPage.fxml"));
    root = loader.load();

    ClerkController controller = loader.getController();
    controller.init(this, vmf);
    stage.setTitle("Choose role");
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }

  public void openCustomerView() throws IOException
  {
    Scene scene = null;
    FXMLLoader loader = new FXMLLoader();
    Parent root = null;
    loader.setLocation(this.getClass().getResource("../view/customer/customerPage.fxml"));
    root = loader.load();

    CustomerController controller = loader.getController();
    controller.init(this, vmf);
    stage.setTitle("Choose role");
    scene = new Scene(root);
    stage.setScene(scene);
    stage.show();
  }
}
