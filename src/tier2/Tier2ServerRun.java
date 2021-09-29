package tier2;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class Tier2ServerRun
{
  public static void main(String args[]){
    try
    {
      Tier2Server tier2Server = new Tier2ServerImpl();
      Naming.rebind("Tier2Server", (Remote) tier2Server);
      System.out.println("Tier 2 server started!");
    }
    catch (RemoteException | MalformedURLException e)
    {
      e.printStackTrace();
    }
  }
}
