package domain;
import java.util.ArrayList;
import java.util.Random;

import db.DbException;

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
			
			throw new DomainException();
			
		} 
		else if (woordenLijst.contains(woord)) {
				
			throw new DomainException();
				
		} else {
				
			woordenLijst.add(woord);
				
		}	
	}
	
	public String getRandomWord() {
		
		Random rand = new Random();
		int randomint = rand.nextInt(woordenLijst.size() - 1);
		
		if (woordenLijst == null) {
			
			return null;
			
		} else {
			
			return woordenLijst.get(randomint);

		}	
	}
}
