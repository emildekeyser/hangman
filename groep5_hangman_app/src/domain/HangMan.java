package domain;

import ui.TekeningHangMan;

public class HangMan {
	private Speler speler;
	private WoordenLijst woordenLijst;
	private HintWoord hintWoord;
	private TekeningHangMan tekening;
	
	
	public HangMan(Speler speler, WoordenLijst woordenLijst) {
		setSpeler(speler);
		setWoordenLijst(woordenLijst);
		this.hintWoord = new HintWoord(this.woordenLijst.getRandomWord());
		this.tekening = new TekeningHangMan();
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
		return this.hintWoord.toString();
	}
	
	public Speler getSpeler() {
		return this.speler;
	}
	
	public TekeningHangMan getTekening() {
		return this.tekening;
	}
	
	public void raad(char letter) {
		if (!this.hintWoord.raad(letter)) {
			this.getTekening().zetVolgendeZichtbaar();
		}
		
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
