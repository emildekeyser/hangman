package ui;

import javax.swing.JOptionPane;

import db.WoordenLezer;
import domain.*;

public class Launcher {
	public static void main(String[] args) {
		
		String inputValue = JOptionPane.showInputDialog("Welkom!\n Hoe heet je?");
		Speler speler = new Speler(inputValue);
		WoordenLezer woordenLezer = new WoordenLezer("hangman.txt");
		WoordenLijst woordenLijst = woordenLezer.lees(); 
		
		String[] keuzes = { "Hangman", "Pictonary" };
		Object keuze = JOptionPane.showInputDialog(null, "Dag"+ speler.getNaam() +" welk spel wil je spelen?", "input", JOptionPane.INFORMATION_MESSAGE,
				null, keuzes, null);
		if (keuze.equals(keuzes[0])) { //Hangman
			HangManUi hmui= new HangManUi(speler);
			hmui.play();
			
	
		}
		else if (keuze.equals(keuzes[1])) { // Pictonary
			PictionaryUi pictionaryUi = new PictionaryUi(speler);
			pictionaryUi.hoofdMenu();

		
	}
}

}
