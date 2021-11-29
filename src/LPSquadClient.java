import model.LPSquad;
import model.LPSquadInterface;
import model.LPSquadListInterface;

import java.rmi.Naming;
import java.util.ArrayList;

public class LPSquadClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String url="rmi:///"; //no IP address, this is local.
		
		try {
			
			LPSquadListInterface LPSquadList = (LPSquadListInterface) Naming.lookup("listOfPlayers");
			
			ArrayList<LPSquad> actualLPSquadList = LPSquadList.getList();
			
			for(LPSquadInterface h : actualLPSquadList) {
				System.out.println(h.getPlayer());
			}

			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
