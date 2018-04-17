package domain;

public class LijnStuk extends Vorm {

	private Punt startPunt;
	private Punt eindPunt;

	public LijnStuk(Punt startPunt, Punt eindPunt) {
		
		super();
		this.setPunten(startPunt, eindPunt);
	}

	public void setPunten(Punt startPunt, Punt eindPunt) {

		if (startPunt == null || eindPunt == null || startPunt.equals(eindPunt)) {
			throw new DomainException();
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
		int breedte = this.startPunt.getX() - this.eindPunt.getX();
		int hoogte = this.startPunt.getY() - this.eindPunt.getY();
		Omhullende o = new Omhullende(linkerBovenPunt, breedte, hoogte);
		return o;
	}

}
