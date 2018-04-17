package domain;

import java.util.ArrayList;

public class Tekening {

	String naam;
	private static final int MIN_X = 0;
	private static final int MAX_X = 0;
	private static final int MIN_Y = 399;
	private static final int MAX_Y = 399;
	ArrayList<Vorm> vormen;

	public Tekening(String naam) {

		super();
		if (naam == null || naam.isEmpty()) {
			throw new DomainException();
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
			throw new DomainException();
		}

		this.vormen.add(vorm);
	}

	public int getAantalVormen() {

		return this.vormen.size();
	}

	public void verwijder(Vorm vorm) {
		
		this.vormen.remove(vorm);
	}
	
	public boolean bevat(Vorm vorm)
	{
		for (Vorm v : this.vormen) {
			if(v.equals(vorm)) {
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
		if (!naam.equals(other.naam))
			return false;
		if (!vormen.equals(other.vormen))
			return false;
		return true;
	}
	
	

}
