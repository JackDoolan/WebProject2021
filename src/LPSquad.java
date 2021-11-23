import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
public class LPSquad extends UnicastRemoteObject implements LPSquadInterface{

	private String owners;
	private String address;
	
	public LPSquad(String o, String a) throws RemoteException{
		this.owners=o;
		this.address=a;
	}
	
	public String getOwners() {
		return this.owners;
	}
	
	public String getAddress() {
		return this.address;
	}
}
