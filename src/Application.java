import javafx.stage.Stage;
import tier1.model.ModelFactory;
import tier1.model.admin.Admin;
import tier1.model.admin.IAdmin;
import tier1.model.clerk.Clerk;
import tier1.model.clerk.IClerk;
import tier1.networking.ClientFactory;
import tier1.view.ViewHandler;
import tier1.viewmodel.ViewModelFactory;

public class Application extends javafx.application.Application
{
  @Override public void start(Stage stage) throws Exception
  {
    ClientFactory cf = new ClientFactory();
    ModelFactory mf = new ModelFactory(cf);
    ViewModelFactory vmf = new ViewModelFactory(mf);
    ViewHandler vh = new ViewHandler(stage, vmf);
    vh.start();
  }
}
