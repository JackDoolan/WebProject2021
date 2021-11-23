import java.rmi.Naming;
import java.rmi.*;
public class LPSquadServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Server has started.....");
		
		try {
			LPSquad bungalow = new LPSquad("Smiths", "Dublin");
			System.out.println("bungalow created....");
			LPSquad dormer = new LPSquad("Burkes", "Kerry");
			System.out.println("dormer created...");
	
			LPSquadList hl = new LPSquadList();
			hl.addToList(bungalow);
			hl.addToList(dormer);
			
			
			Naming.rebind("listOfHouses", hl);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
