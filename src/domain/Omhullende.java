package domain;

public class Omhullende {
	
	private Punt linkerBovenhoek;
	private int breedte, hoogte;
	
	
	
	public Omhullende(Punt linkerBovenhoek, int breedte, int hoogte) {
		super();
			setBreedte(breedte);
			setHoogte(hoogte);
			setLinkerBovenhoek(linkerBovenhoek);
	}



	public Punt getLinkerBovenhoek() {
		return linkerBovenhoek;
	}



	public void setLinkerBovenhoek(Punt linkerBovenhoek) {
		if(linkerBovenhoek == null) {
			throw new DomainException();
		}
		this.linkerBovenhoek = linkerBovenhoek;
	}



	public int getBreedte() {
		return breedte;
	}



	public void setBreedte(int breedte) {
		if(breedte < 0  ) {
			throw new DomainException();
		}
		this.breedte = breedte;
	}



	public int getHoogte() {
		return hoogte;
	}



	public void setHoogte(int hoogte) {
		if(hoogte < 0 ) {
			throw new DomainException();
		}
		this.hoogte = hoogte;
	}
	
	
	
	public int minimaleX() {
		return getLinkerBovenhoek().getX();
	}
	
	
	public int maximaleX() {
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
