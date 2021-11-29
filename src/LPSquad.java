import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
public class LPSquad extends UnicastRemoteObject implements LPSquadInterface {

	private String player;
	private String nationality;
	private int kitNumber;
	private int goalsScored;

	public LPSquad(String player, String nationality, int kitNumber, int goalsScored) throws RemoteException{
		this.player = player;
		this.nationality=nationality;
		this.kitNumber=kitNumber;
		this.goalsScored=goalsScored;
	}
	public String getPlayer() {
		return player;
	}

	public void setPlayer(String player) {
		this.player = player;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public int getKitNumber() {
		return kitNumber;
	}

	public void setKitNumber(int kitNumber) {
		this.kitNumber = kitNumber;
	}

	public int getGoalsScored() {
		return goalsScored;
	}

	public void setGoalsScored(int goalsScored) {
		this.goalsScored = goalsScored;
	}













}
