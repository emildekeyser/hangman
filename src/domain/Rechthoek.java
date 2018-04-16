package domain;

public class Rechthoek  {
	
	private int breedte;
	private int hoogte;
	private Punt linkerBovenhoek;

	
	public Rechthoek(Punt linkerBovenhoek,int breedte, int hoogte) {
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
		if(breedte <= 0  ) {
			throw new DomainException();
		}
		this.breedte = breedte;
	}
	
	public int getHoogte() {
		return hoogte;
	}
	
	public void setHoogte(int hoogte) {
		if(hoogte <= 0 ) {
			throw new DomainException();
		}
		this.hoogte = hoogte;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Rechthoek other = (Rechthoek) obj;
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
		return "Rechthoek : positie : ("+ linkerBovenhoek.getX() + ", " +  linkerBovenhoek.getY()+ " )" + "- breedte : " + breedte + " - hoogte : " + hoogte;
	}
	
	
	
	
	
	
	

}
