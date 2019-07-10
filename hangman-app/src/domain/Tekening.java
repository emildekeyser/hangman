package domain;

import java.util.ArrayList;

public class Tekening {

	String naam;
	private static final int MIN_X = 0;
	private static final int MAX_X = 399;
	private static final int MIN_Y = 0;
	private static final int MAX_Y = 399;
	ArrayList<Vorm> vormen;

	public Tekening(String naam) {

		super();
		if (naam == null || naam.isEmpty()) {
			throw new IllegalArgumentException();
		}
		this.naam = naam;
		this.vormen = new ArrayList<Vorm>();
	}

	public String getNaam() {
		return this.naam;
	}

	public Vorm getVorm(int index) {
		return this.vormen.get(index);
	}

	public void voegToe(Vorm vorm) {

		if (vorm == null) {
			throw new DomainException("Vorm mag niet null zijn.");
		}
		
		Omhullende omhullendeVanVorm = vorm.getOmhullende();
		if(omhullendeVanVorm.getLinkerBovenhoek().getX() < MIN_X || omhullendeVanVorm.getLinkerBovenhoek().getX() + omhullendeVanVorm.getBreedte() > MAX_X
		   || omhullendeVanVorm.getLinkerBovenhoek().getY() < MIN_Y || omhullendeVanVorm.getLinkerBovenhoek().getY() + omhullendeVanVorm.getHoogte() > MAX_Y) {
			
			throw new DomainException("Vorm mag niet buiten het beeld komen");
			
		} else {
			
			
			this.vormen.add(vorm);
			
		}
	}

	public int getAantalVormen() {

		return this.vormen.size();
	}

	public void verwijder(Vorm vorm) {

		this.vormen.remove(vorm);
	}

	public boolean bevat(Vorm vorm) {
		for (Vorm v : this.vormen) {
			if (v.equals(vorm)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		String ret = "Tekening met naam " + naam + " bevat " + this.getAantalVormen() + " vormen:";
		for (Vorm vorm : this.vormen) {
			ret += "\n" + vorm;
		}
		return ret;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tekening other = (Tekening) obj;
		if (this.getAantalVormen() != other.getAantalVormen())
			return false;
		for (Vorm vorm : this.vormen) {
			if (!other.bevat(vorm)) {
				return false;
			}
		}
		return true;
	}
	
	

}
