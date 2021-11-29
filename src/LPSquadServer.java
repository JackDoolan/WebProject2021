import model.LPSquad;
import model.LPSquadList;
import model.LPSquadListInterface;

import java.io.*;
import java.rmi.Naming;

public class LPSquadServer {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub


		System.out.println("Server has started.....");
		LPSquadList hl = new LPSquadList();
		try {

			FileInputStream fileIn = new FileInputStream("Players.ser");
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);
			LPSquadListInterface newPlayer = (LPSquadListInterface) objectIn.readObject();
			objectIn.close();

			Naming.rebind("listOfPlayers", newPlayer);

		}
		catch(Exception e)
		{
			e.printStackTrace();

			System.out.println("Creating new Player List");
			LPSquad salah = new LPSquad("Salah", "Egyptian", 11, 108);
			System.out.println("Salah Created");
			LPSquad mane = new LPSquad("Mane", "Senegalese",10,102);
			System.out.println("Mane Created");

			//Serializing
			hl.addToList(salah);
			hl.addToList(mane);
			FileOutputStream fileOut = new FileOutputStream("Players.ser");
			ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
			objectOut.writeObject(hl);

			objectOut.close();
			Naming.rebind("listOfPlayers", hl);



			//e.printStackTrace();
		}
	}

}









