import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class LPSquadList extends UnicastRemoteObject implements LPSquadListInterface{

	private ArrayList<LPSquad> houses;
	
	public LPSquadList() throws RemoteException {
		houses= new ArrayList();
		// TODO Auto-generated constructor stub
	}
 	@Override
	public void addToList(LPSquad h) throws RemoteException {
		houses.add(h);
		
	}

	@Override
	public ArrayList<LPSquad> getList() throws RemoteException {
		// TODO Auto-generated method stub
		return houses;
	}

}
