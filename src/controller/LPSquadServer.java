package controller;

import model.LPSquad;
import model.LPSquadList;
import model.LPSquadListInterface;

import java.io.*;
import java.rmi.Naming;

public class LPSquadServer {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		LPSquad salah = new LPSquad("Salah", "Egyptian", 11, 108);
		LPSquad mane = new LPSquad("Mane", "Senegalese",10,102);
		LPSquad firmino = new LPSquad("Firmino", "Brazillian",13,102);
		System.out.println("Server has started.....");
		LPSquadList hl = new LPSquadList();
		hl.addToList(salah);
		hl.addToList(mane);
		hl.addToList(firmino);

		try {

			Naming.rebind("listOfPlayers",hl);
			FileInputStream fileIn = new FileInputStream("Players.ser");
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			LPSquadListInterface newPlayer = (LPSquadListInterface) objectIn.readObject();
			objectIn.close();

			Naming.rebind("listOfPlayers", newPlayer);


		}
		catch(Exception e)
		{
			e.printStackTrace();



			//Serializing
			FileOutputStream fileOut = new FileOutputStream("Players.ser");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(hl);

			objectOut.close();
			Naming.rebind("listOfPlayers", hl);



			e.printStackTrace();
		}
	}

}








