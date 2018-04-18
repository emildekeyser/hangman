package domain;

public class Omhullende{
	
	private Punt linkerBovenhoek;
	private int breedte, hoogte;
	
	
	
	public Omhullende(Punt linkerBovenhoek, int breedte, int hoogte) {
		
			setBreedte(breedte);
			setHoogte(hoogte);
			setLinkerBovenhoek(linkerBovenhoek);
	}



	public Punt getLinkerBovenhoek() {
		return linkerBovenhoek;
	}



	public void setLinkerBovenhoek(Punt linkerBovenhoek) {
		if(linkerBovenhoek == null) {
			throw new DomainException("Liknerbovenhoek mag niet null zijn.");
		}
		this.linkerBovenhoek = linkerBovenhoek;
	}



	public int getBreedte() {
		return breedte;
	}



	public void setBreedte(int breedte) {
		if(breedte < 0  ) {
			throw new DomainException("Breedte moet 0 of meer zijn.");
		}
		this.breedte = breedte;
	}



	public int getHoogte() {
		return hoogte;
	}



	public void setHoogte(int hoogte) {
		if(hoogte < 0 ) {
			throw new DomainException("Hoogte moet 0 of meer zijn.");
		}
		this.hoogte = hoogte;
	}
	
	
	
	public int minX() {
		return getLinkerBovenhoek().getX();
	}
	
	
	public int maxX() {
		return  getLinkerBovenhoek().getX() + this.breedte;
	}
	
	public int minY() {
		return getLinkerBovenhoek().getY();
	}
	
	public int maxY() {
		return getLinkerBovenhoek().getY() + this.hoogte;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Omhullende other = (Omhullende) obj;
		if (breedte != other.breedte)
			return false;
		if (hoogte != other.hoogte)
			return false;
		if (linkerBovenhoek == null) {
			if (other.linkerBovenhoek != null)
				return false;
		} else if (!linkerBovenhoek.equals(other.linkerBovenhoek))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Omhullende : (" + this.linkerBovenhoek.toString() + ") - "+ this.breedte + " - " + this.hoogte;
	}
	
}
