package domain;

public class Speler {
	String naam;
	int score;
	public Speler(String naam) {
		setNaam(naam);
	}
	public String getNaam() {
		return naam;
	}
	public void setNaam(String naam) {
		
		if (naam == null || naam.trim().equals("")) {
			throw new DomainException();
		}
		this.naam = naam;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	public void addToScore(int score) {
		if ((this.getScore()+score)<0) {
			throw new DomainException();
		}
		setScore(this.getScore()+score);
	}
	@Override
	public boolean equals(Object object) {
		if (object instanceof Speler) {
			if (((Speler)object).getScore() == this.getScore() && ((Speler) object).getNaam().equals(this.getNaam())) {
				return true;
			}
			return false;
		}
		return false;
	}

}
