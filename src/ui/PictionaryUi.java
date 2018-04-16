package ui;
import java.util.*;

import javax.swing.JOptionPane;
import javax.swing.JOptionPane.*;

import domain.Punt;

public class PictionaryUi {

	
	
	
	public void showMenu() {
		int xCoordinaat = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het punt:"));
		int yCoordinaat = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het punt:"));
		Punt gebruikerPunt = new Punt(xCoordinaat,yCoordinaat);
		JOptionPane.showMessageDialog(null,"U heeft een correct punt aangemaakt: " + gebruikerPunt.toString());

}
}

