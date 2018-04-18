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
		PictionaryUi pictionaryUi = new PictionaryUi(speler);
		pictionaryUi.hoofdMenu();
		HangManUi hangManUi = new HangManUi(speler,woordenLijst);
		
	}

}
