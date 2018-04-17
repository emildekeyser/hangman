package domain;

import java.awt.Graphics;

public class Rechthoek extends Vorm implements Tekenbaar{
	
	private int breedte;
	private int hoogte;
	private Punt linkerBovenhoek;
	private Omhullende o;

	
	public Rechthoek(Punt linkerBovenhoek,int breedte, int hoogte) {
		
		super();
		setBreedte(breedte);
		setHoogte(hoogte);
		setLinkerBovenhoek(linkerBovenhoek);
		this.o = new Omhullende(linkerBovenhoek, breedte, hoogte);
	}


	public Punt getLinkerBovenhoek() {
		return linkerBovenhoek;
	}

	public Omhullende getOmhullende() {
		//return "Rechthoek : positie : ("+ linkerBovenhoek.getX() + ", " +  linkerBovenhoek.getY()+ " )" + " - " + breedte + " - " + hoogte;
		return o;
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


	@Override
	public void teken(Graphics graphics) {
		
		graphics.drawRect(this.getLinkerBovenhoek().getX(), this.getLinkerBovenhoek().getY(), this.getBreedte(),
				this.getHoogte());
	}
	
}
