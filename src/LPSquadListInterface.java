import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface LPSquadListInterface extends Remote{

	public void addToList(LPSquad h) throws RemoteException;
	public ArrayList<LPSquad> getList() throws RemoteException;
}
