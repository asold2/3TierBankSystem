package tier2;

import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.rmi.RemoteException;

public interface PropertyChangeSubject extends Serializable
{
  void addListener(String propertyName, PropertyChangeListener listener) throws
      RemoteException;
  void addListener(PropertyChangeListener listener) throws
      RemoteException;
  void removeListener(PropertyChangeListener listener) throws
      RemoteException;
  void removeListener(String propertyName, PropertyChangeListener listener) throws
      RemoteException;
}
