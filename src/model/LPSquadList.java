package model;

import model.LPSquad;
import view.LPSquadGUI;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Iterator;

public class LPSquadList extends UnicastRemoteObject implements LPSquadListInterface, Serializable {

	private ArrayList<LPSquadInterface> players;



	public LPSquadList() throws RemoteException {

		players = new ArrayList();

	}

	public void addToList(LPSquad h) throws RemoteException {
		players.add(h);
		
	}
	@Override
	public void addToList(LPSquadInterface h) throws RemoteException {
		this.players.add(h);
	}

	@Override
	public ArrayList<LPSquadInterface> getList() throws RemoteException {
		// TODO Auto-generated method stub
		return players;
	}
	public void addPlayer(String name, String nationality, int kitNumber, int goalsScored) throws RemoteException {
		LPSquadInterface lp = new LPSquad(name, nationality, kitNumber, goalsScored);
		players.add(lp);
	}
	public void editPlayer(String name, String nationality, int kitNumber, int goalsScored) throws RemoteException {
				Iterator lps = this.players.iterator();
				while(lps.hasNext()){
					LPSquadInterface lpsquad = (LPSquadInterface) lps.next();
					if(name.equals(lpsquad.getPlayer())){
						lpsquad.setNationality(nationality);
						lpsquad.setKitNumber(kitNumber);
						lpsquad.setGoalsScored(goalsScored);
					}}}

	@Override
	public void deletePlayer(String name) throws RemoteException {

		for (int i=0; i<players.size(); i++)
		{
			if(name.equals(players.get(i).getPlayer())){
				players.remove(i);
			}
		}
	}

}
