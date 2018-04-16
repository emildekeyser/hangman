package domain;

public class Rechthoek {
	
	private int breedte;
	private int hoogte;

	
	public Rechthoek(int breedte, int hoogte) {
		super();
		setBreedte(breedte);
		setHoogte(hoogte);
	}
	
	
	public int getBreedte() {
		return breedte;
	}
	
	public void setBreedte(int breedte) {
		if(breedte <= 0 ) {
			throw new IllegalArgumentException("de breedte mag niet minder zijn dan 0!");
		}
		this.breedte = breedte;
	}
	
	public int getHoogte() {
		return hoogte;
	}
	
	public void setHoogte(int hoogte) {
		if(hoogte <= 0 ) {
			throw new IllegalArgumentException("de hoogte mag niet minder zijn dan 0!");
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
		return true;
	}


	
	
	@Override
	public String toString() {
		return "Rechthoek : positie : (" + ", " + " )" + "- breedte : " + breedte + " - hoogte : " + hoogte;
	}
	
	
	
	
	
	
	

}
