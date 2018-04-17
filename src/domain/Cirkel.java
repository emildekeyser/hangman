package domain;

import java.awt.Graphics;

public class Cirkel extends Vorm implements Tekenbaar{
	private int radius;
	private Punt punt;

	public Cirkel(Punt punt, int radius) {

		super();
		setRadius(radius);
		setMiddelpunt(punt);
	}

	public void setMiddelpunt(Punt punt) {
		if (punt == null)
			throw new DomainException();
		this.punt = punt;
	}

	private void setRadius(int radius) {
		if (radius <= 0)
			throw new DomainException();
		this.radius = radius;
	}

	public int getRadius() {
		return radius;
	}

	public Punt getMiddelPunt() {
		return punt;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cirkel other = (Cirkel) obj;
		if (radius != other.radius)
			return false;
		if (!this.punt.equals(((Cirkel) obj).getMiddelPunt())) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "Cirkel: middelPunt: " + this.punt.toString() + " - straal: " + this.radius;
	}

	@Override
	public Omhullende getOmhullende() {
		int x = this.punt.getX() - this.radius;
		int y = this.punt.getY() - this.radius;
		Punt linkerBoven = new Punt(x,y);
		int zijde = this.radius * 2;
		Omhullende o = new Omhullende(linkerBoven, zijde, zijde);
		return o;
	}

	@Override
	public void teken(Graphics graphics) {
		 
		graphics.drawOval(this.getMiddelPunt().getX(), this.getMiddelPunt().getY(), this.getRadius() * 2, this.getRadius() * 2);
	}

}
