package ui;

import javax.swing.JOptionPane;
import domain.*;

import domain.Speler;
import domain.WoordenLijst;

public class HangManUi {
	Speler speler;
	WoordenLijst woordenLijst;
	HintWoord rade = new HintWoord("Dante");

	public HangManUi(Speler speler/* , WoordenLijst woordenLijst */) {
		setSpeler(speler);
		setWoordenLijst(woordenLijst);
	}

	public void play() {
		TekeningHangMan tekening = new TekeningHangMan();
		GameHoofdScherm view = new GameHoofdScherm(tekening.getNaam(), tekening);
		view.setVisible(true);
		view.teken();
		//String randomWord = this.getWoordenLijst().getRandomWord();
		JOptionPane.showMessageDialog(null, "Rarara welk woord zoeken we? \n\n"+ rade.toString()+   );
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
