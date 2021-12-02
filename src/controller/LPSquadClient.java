package controller;

import model.LPSquad;
import model.LPSquadInterface;
import model.LPSquadListInterface;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class LPSquadClient {

	public ArrayList<LPSquadInterface> getArrayList() throws MalformedURLException, NotBoundException, RemoteException {
		// TODO Auto-generated method stub

		String url="rmi:///"; //no IP address, this is local.
		LPSquadListInterface LPSquadList = (LPSquadListInterface) Naming.lookup("listOfPlayers");
		ArrayList<LPSquadInterface> actualLPSquadList = LPSquadList.getList();

		try {



			System.out.println("LIST " +LPSquadList.getList());


			for(LPSquadInterface h: actualLPSquadList){
				System.out.println(h.getPlayer());

			}

			return actualLPSquadList;

		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
