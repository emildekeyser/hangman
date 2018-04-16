package ui;
import javax.swing.JOptionPane;
import ui.*;

import domain.*;

public class Launcher {
	public static void main(String[] args) {
		
		String inputValue = JOptionPane.showInputDialog("Welkom!\n Hoe heet je?");
		Speler speler = new Speler(inputValue);
		PictionaryUi pictionaryUi = new PictionaryUi(speler);
		
	}

}
