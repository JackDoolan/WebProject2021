package model;

import model.LPSquad;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface LPSquadListInterface extends Remote{

	public void addToList(LPSquadInterface h) throws RemoteException;
	public ArrayList<LPSquadInterface> getList() throws RemoteException;
	public void addPlayer(String name, String nationality, int kitNumber, int goalsScored) throws RemoteException;
	public void editPlayer(String name, String nationality, int kitNumber, int goalsScored) throws RemoteException;
	public void deletePlayer(String name) throws RemoteException;
}
