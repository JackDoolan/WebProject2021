import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LPSquadInterface extends Remote{
	public String getPlayer() throws RemoteException;
	public String getNationality() throws RemoteException;
	public int getKitNumber() throws RemoteException;
	public int getGoalsScored() throws RemoteException;
}
