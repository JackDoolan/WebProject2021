import java.rmi.Naming;
import java.rmi.*;
public class LPSquadServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Server has started.....");
		
		try {
			LPSquad salah = new LPSquad("Salah", "Egyptian", 11, 108);
			System.out.println("Salah created");
			LPSquad mane = new LPSquad("Mane", "Senegalese",10,102);
			System.out.println("Mane created");
	
			LPSquadList hl = new LPSquadList();
			hl.addToList(salah);
			hl.addToList(mane);
			
			
			Naming.rebind("listOfHouses", hl);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
