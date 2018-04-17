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
	
	
	
	public void showMenu() {
		int xCoordinaat = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het punt:"));
		int yCoordinaat = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het punt:"));
		Punt gebruikerPunt = new Punt(xCoordinaat,yCoordinaat);
		JOptionPane.showMessageDialog(null,"U heeft een correct punt aangemaakt: " + gebruikerPunt.toString());

		Object[] shapes = {"Cirkel", "Rechthoek"};
			Object keuze = JOptionPane.showInputDialog(null, "Wat wilt u tekenen",
			"input", JOptionPane.INFORMATION_MESSAGE, null, shapes, null);
			JOptionPane.showMessageDialog(null,keuze);
			
			if( keuze.equals("Cirkel")) {
				try {
					
					int radius = Integer.parseInt(JOptionPane.showInputDialog("wat is de radius van de cirkel"));
					Cirkel c = new Cirkel(gebruikerPunt, radius);
					 JOptionPane.showMessageDialog(null,c.toString());	
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "geen negatieve waarden");
					
					
				}
				
					
				
			}
			else if(keuze.equals("Rechthoek")) {
				
			try {
				int breedte = Integer.parseInt(JOptionPane.showInputDialog("wat is de breedte van de rechthoek"));
				int hoogte = Integer.parseInt(JOptionPane.showInputDialog("wat is de hoogte van de rechthoek"));
				 Rechthoek r = new Rechthoek(gebruikerPunt,breedte,hoogte);
				 JOptionPane.showMessageDialog(null,r.toString());
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "geen negatieve waarden");
					
					
				}
				
			}
	}
	
		
}

