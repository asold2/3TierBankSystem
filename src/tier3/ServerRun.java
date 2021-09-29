package tier3;

import java.rmi.RemoteException;

public class ServerRun
{
  public static void main(String args[]){
    Tier3Server server = new Tier3ServerImpl("postgres");
    try
    {
      server.start();
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

}
