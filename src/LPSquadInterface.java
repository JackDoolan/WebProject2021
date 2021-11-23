import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LPSquadInterface extends Remote{
	public String getOwners() throws RemoteException;
	public String getAddress() throws RemoteException;
}
