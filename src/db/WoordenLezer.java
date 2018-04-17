package db;

import java.io.File;
import java.util.Scanner;
import domain.WoordenLijst;

public class WoordenLezer {
	
	File bestandsNaam;
	Scanner scanner;
	
	public WoordenLezer(String bestandsNaam){
		
		setBestandsNaam(bestandsNaam);
		scanner = new Scanner(this.bestandsNaam);
		
	}

	private void setBestandsNaam(String bestandsNaam) {

		if (bestandsNaam == null || bestandsNaam.trim().isEmpty()) {
			
			throw new DbException();
			
		} else {
			
			this.bestandsNaam = new File(bestandsNaam);

		}
	}
	
	public WoordenLijst lees() {
		
		WoordenLijst woordenLijst = new WoordenLijst();
		
		while(scanner.hasNext()) {
			
			woordenLijst.voegToe(scanner.next());
			
		}
		
		return
	}
}
