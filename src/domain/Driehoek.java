package domain;

import java.awt.Graphics;

public class Driehoek extends Vorm implements Tekenbaar {
	
	private Punt hoekPunt1;
	private Punt hoekPunt2;
	private Punt hoekPunt3;
	
	public Driehoek(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3) {
		
		setHoekPunten(hoekPunt1, hoekPunt2, hoekPunt3);
		
	}
	public void setHoekPunten(Punt hoekPunt1, Punt hoekPunt2, Punt hoekPunt3) {

		if(hoekPunt1 == null || hoekPunt2 == null || hoekPunt3 == null) {
			
			throw new DomainException();
			
		}
		
		if(hoekPunt1.equals(hoekPunt2) || hoekPunt1.equals(hoekPunt3) || hoekPunt2.equals(hoekPunt3)) {
			
			throw new DomainException();
			
		}
		
		if((hoekPunt2.getX() - hoekPunt1.getX()) * (hoekPunt3.getY() - hoekPunt1.getY()) == (hoekPunt3.getX() - hoekPunt1.getX()) * (hoekPunt2.getY() - hoekPunt1.getY())) {
			
			throw new DomainException();
			
		} else {
			
			this.hoekPunt1 = hoekPunt1;
			this.hoekPunt2 = hoekPunt2;
			this.hoekPunt3 = hoekPunt3;
			
		}
	}
	public Punt getHoekPunt1() {
		
		return hoekPunt1;
		
	}
	public Punt getHoekPunt2() {
		
		return hoekPunt2;
		
	}
	public Punt getHoekPunt3() {
		
		return hoekPunt3;
		
	}
	@Override
	public boolean equals(Object object) {
		
		if (object == null || !(object instanceof Driehoek)) {
			
			return false;
			
		} else {
			
			Driehoek teVergelijken = (Driehoek)object;
			Punt[] drieHoek1 = new Punt[] {this.getHoekPunt1(), this.getHoekPunt2(), this.getHoekPunt3()};
			Punt[] drieHoek2 = new Punt[] {teVergelijken.getHoekPunt1(), teVergelijken.getHoekPunt2(), teVergelijken.getHoekPunt3()};
			int teller = 0;
			
			for (Punt punt: drieHoek1) {
				
				for (int i = 0; i < drieHoek2.length; i++) {
					
					if(punt.equals(drieHoek2[i])) {
						
						teller++;
						
					}
				}
			}
			
			if (teller == 3) {
				
				return true;
				
			} else {
				
				return false;

			}
		}
	}
	@Override
	public String toString() {
		
		return "Driehoek: hoekpunt1: " + hoekPunt1.toString() + " - hoekpunt2: " + hoekPunt2.toString() + " - hoekpunt3: " + hoekPunt3.toString();
		
	}
	@Override
	public Omhullende getOmhullende() {
		int x = hoekPunt1.getX();
		int y = Math.min(Math.min(hoekPunt1.getY(), hoekPunt2.getY()), hoekPunt3.getY());
		int hoogte = y - Math.max(Math.max(hoekPunt1.getY(), hoekPunt2.getY()), hoekPunt3.getY());
		int breedte = x - Math.max(Math.max(hoekPunt1.getX(), hoekPunt2.getX()), hoekPunt3.getX());
		Punt linkerBovenHoek = new Punt(x, y);
		Omhullende o = new Omhullende(linkerBovenHoek, breedte, hoogte);
		return o;
	}
	@Override
	public void teken(Graphics graphics) {
		 
		LijnStuk A = new LijnStuk(this.getHoekPunt1(), this.getHoekPunt2());
		LijnStuk B = new LijnStuk(this.getHoekPunt2(), this.getHoekPunt3());
		LijnStuk C = new LijnStuk(this.getHoekPunt3(), this.getHoekPunt1());
		A.teken(graphics);
		B.teken(graphics);
		C.teken(graphics);
	}
}
