 package domain;
import java.util.ArrayList;
import java.util.Random;

public class WoordenLijst {
	
	ArrayList<String> woordenLijst;
	
	public WoordenLijst() {
		
		this.woordenLijst = new ArrayList<String>();
		
	}
	
	public int getAantalWoorden() {
		
		return woordenLijst.size();
		
	}
	
	public void voegToe(String woord) {
		
		if (woord == null || woord.trim().isEmpty()) {
			
			throw new DomainException("Er mag geen leeg woord toegevoegd worden.");
			
		} 
		else if (woordenLijst.contains(woord)) {
				
			throw new DomainException("Er mogen geen woorden dubbel voorkomen.");
				
		} else {
				
			woordenLijst.add(woord);
				
		}	
	}
	
	public String getRandomWord() {
		
		if (woordenLijst.isEmpty()) {
			
			return null;
			
		} else {
			
			Random rand = new Random();
			int randomint = rand.nextInt(woordenLijst.size());
			return woordenLijst.get(randomint);

		}	
	}
}
