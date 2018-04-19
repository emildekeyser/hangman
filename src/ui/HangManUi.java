package ui;

import domain.*;
import domain.Speler;
import domain.WoordenLijst;

public class HangManUi {
	Speler speler;
	WoordenLijst woordenLijst;
	HintWoord rade;// = new HintWoord("Dante");
	TekeningHangMan tekening = new TekeningHangMan();

	public HangManUi(Speler speler, WoordenLijst woordenLijst) {
		setSpeler(speler);
		setWoordenLijst(woordenLijst);
	}

	// public void play() {
	//
	// GameHoofdScherm view = new GameHoofdScherm(tekening.getNaam(), tekening);
	// view.setVisible(true);
	// String randomWord = this.getWoordenLijst().getRandomWord();
	// rade = new HintWoord(randomWord);
	// while(!rade.isGeraden()) {
	// String s = JOptionPane.showInputDialog(null, "Rarara welk woord zoeken we?
	// \n\n"+ rade.toString()+ "\n Geef een letter.");
	// char c = s.charAt(0);
	// if(!rade.raad(c)) {
	// tekening.zetVolgendeZichtbaar();
	// view.teken();
	// }
	// }
	// }

	public void play() {
		
		HangMan hangman = new HangMan(speler, woordenLijst);
		HangmanPaneel paneel = new HangmanPaneel(hangman);
		HangManHoofdScherm hoofdscherm = new HangManHoofdScherm(hangman, paneel);
		hoofdscherm.start();
	}

	public Speler getSpeler() {
		return speler;
	}

	public void setSpeler(Speler speler) {
		this.speler = speler;
	}

	public WoordenLijst getWoordenLijst() {
		return woordenLijst;
	}

	public void setWoordenLijst(WoordenLijst woordenLijst) {
		this.woordenLijst = woordenLijst;
	}

}
