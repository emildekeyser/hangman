package db;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import domain.WoordenLijst;

public class WoordenLezer {
	
	File bestandsNaam;
	Scanner scanner;
	
	
	public WoordenLezer(String bestandsNaam){
			setBestandsNaam(bestandsNaam);
		
		
			   File file = new File(bestandsNaam);
			   try {
				   scanner = new Scanner(file);
			} catch (FileNotFoundException e) {
				throw new DbException("File not found");
			}
			   
		
	}

	private void setBestandsNaam(String bestandsNaam) {

		if (bestandsNaam == null || bestandsNaam.trim().isEmpty()) {
			
			throw new DbException("Filename invalid");
			
		} else {
			
			this.bestandsNaam = new File(bestandsNaam);

		}
	}
	
	public WoordenLijst lees() {
		WoordenLijst woordenLijst = new WoordenLijst();
		while (scanner.hasNext()) {
		    woordenLijst.voegToe((scanner.nextLine()));
		}
		scanner.close();
		return woordenLijst;
		
		
		
	}
}
