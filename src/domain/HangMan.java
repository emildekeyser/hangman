package domain;

import ui.TekeningHangMan;

public class HangMan {
	Speler speler;
	WoordenLijst woordenLijst;
	HintWoord hintWoord;
	
	
	public HangMan(Speler speler,WoordenLijst woordenLijst) {
		setSpeler(speler);
		setWoordenLijst(woordenLijst);
	}
	public void setSpeler(Speler speler) {
		if (speler == null) {
			throw new DomainException("Speler mag niet null zijn");
		}
		this.speler = speler;
	}
	public void setWoordenLijst(WoordenLijst woordenLijst) {
		if (woordenLijst == null) {
			throw new DomainException("woordenLijst is null");
		}
		if (woordenLijst.getAantalWoorden() == 0) {
			throw new DomainException("woordenLijst mag niet leeg zijn");
		}
		this.woordenLijst = woordenLijst;
	}
	
	public String getHint(){
		return new HintWoord(woordenLijst.getRandomWord()).toString();
	}
	
	public Speler getSpeler() {
		return this.speler;
	}
	
	public TekeningHangMan getTekening() {
		return new TekeningHangMan();
	}
	
	public void raad(char letter) {
		this.hintWoord.raad(letter);
		
	}
	
	public boolean isGameOver() {
		if (getTekening().getAantalOnzichtbaar()==0) {
			return true;
		}
		return false;
	}
	
	public boolean isGewonnen() {
		if (this.hintWoord.isGeraden() == true) {
			return true;
		}	
		return false;
	}

}
