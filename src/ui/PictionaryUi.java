package ui;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.JOptionPane.*;

import domain.*;


public class PictionaryUi {
	Speler speler;
	public PictionaryUi(Speler speler) {
		
	this.speler = speler;
}

	/*
	public void showKeuze() {
	Object[] shapes = {"Cirkel", "Rechthoek"};
			Object keuze = JOptionPane.showInputDialog(null, "Wat wilt u tekenen",
			"input", JOptionPane.INFORMATION_MESSAGE, null, shapes, null);
			JOptionPane.showMessageDialog(null,keuze);
	}
	
	*/
	
	
	public void showMenu() {
		int xCoordinaat = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het punt:"));
		int yCoordinaat = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het punt:"));
		Punt gebruikerPunt = new Punt(xCoordinaat,yCoordinaat);
		JOptionPane.showMessageDialog(null,"U heeft een correct punt aangemaakt: " + gebruikerPunt.toString());

}
	
		
}

