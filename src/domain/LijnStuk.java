package domain;

import java.awt.Graphics;

public class LijnStuk extends Vorm  implements Tekenbaar{

	private Punt startPunt;
	private Punt eindPunt;

	public LijnStuk(Punt startPunt, Punt eindPunt) {
		
		super();
		this.setPunten(startPunt, eindPunt);
	}

	public void setPunten(Punt startPunt, Punt eindPunt) {

		if (startPunt == null || eindPunt == null) {
			throw new DomainException("Punten mogen niet null zijn.");
		}
		
		if (startPunt.equals(eindPunt)) {
			throw new DomainException("Punten mogen niet gelijk zijn.");
		}
		
		this.startPunt = startPunt;
		this.eindPunt = eindPunt;
	}

	public Punt getStartPunt() {
		return startPunt;
	}

	public Punt getEindPunt() {

		return eindPunt;
	}

	@Override
	public String toString() {
		return "Lijn: startpunt: " + startPunt + " - eindPunt: " + eindPunt;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LijnStuk other = (LijnStuk) obj;
		if (startPunt == null) {
			if (other.startPunt != null)
				return false;
		} else if (!startPunt.equals(other.startPunt))
			return false;
		if (eindPunt == null) {
			if (other.eindPunt != null)
				return false;
		} else if (!eindPunt.equals(other.eindPunt))
			return false;
		return true;
	}

	@Override
	public Omhullende getOmhullende() {
		Punt linkerBovenPunt = new Punt(this.startPunt.getX(), this.startPunt.getY());
		int breedte = this.eindPunt.getX() - this.startPunt.getX();
		int hoogte = Math.abs(this.eindPunt.getY() - this.startPunt.getY());
		Omhullende o = new Omhullende(linkerBovenPunt, breedte, hoogte);
		return o;
	}
	
	@Override
	public void teken(Graphics graphics) {
		
		graphics.drawLine(this.getStartPunt().getX(), this.getStartPunt().getY(), this.getEindPunt().getX(),
				this.getEindPunt().getY());
	}


}
