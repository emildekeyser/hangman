package ui;

import javax.swing.JOptionPane;
import domain.*;

public class PictionaryUi {
	
	Speler speler;
	Tekening tekening;

	public PictionaryUi(Speler speler) {

		this.speler = speler;
		this.tekening = new Tekening("Tekening van " + speler.getNaam());
	}
	
	public void hoofdMenu() {
		boolean stop = false;
		while(!stop) {
			String[] keuzes = { "Vorm maken", "Tekening tonen", "Stoppen" };
			Object keuze = JOptionPane.showInputDialog(null, "Wat wilt u doen", "input", JOptionPane.INFORMATION_MESSAGE,
					null, keuzes, null);
			if (keuze.equals(keuzes[0])) { //Vorm maken
				vormMaken();
			}else if (keuze.equals(keuzes[1])) { // Tekening tonen
				tekeningTonen();
				stop = true;
			}else {
				stop = true;
			}
		}
	}
	
	private void tekeningTonen() {
		
		GameHoofdScherm view = new GameHoofdScherm(this.tekening.getNaam(), this.tekening);
		view.setVisible(true);
		view.teken();
		
	}

	public void vormMaken() {

		Object[] shapes = { "Cirkel", "Rechthoek", "Lijnstuk", "Driehoek" };
		Object keuze = JOptionPane.showInputDialog(null, "Wat wilt u tekenen", "input", JOptionPane.INFORMATION_MESSAGE,
				null, shapes, null);
		JOptionPane.showMessageDialog(null, keuze);

		if (keuze.equals("Cirkel")) {
			try {
				int xCoordinaat = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het punt:"));
				int yCoordinaat = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het punt:"));
				Punt gebruikerPunt = new Punt(xCoordinaat, yCoordinaat);
				JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + gebruikerPunt.toString());
				int radius = Integer.parseInt(JOptionPane.showInputDialog("wat is de radius van de cirkel"));
				Cirkel c = new Cirkel(gebruikerPunt, radius);
				
				this.tekening.voegToe(c);
				

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "geen negatieve waarden");

			}

		} else if (keuze.equals("Rechthoek")) {

			try {
				int xCoordinaat = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het punt:"));
				int yCoordinaat = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het punt:"));
				Punt gebruikerPunt = new Punt(xCoordinaat, yCoordinaat);
				JOptionPane.showMessageDialog(null, "U heeft een correct punt aangemaakt: " + gebruikerPunt.toString());
				int breedte = Integer.parseInt(JOptionPane.showInputDialog("wat is de breedte van de rechthoek"));
				int hoogte = Integer.parseInt(JOptionPane.showInputDialog("wat is de hoogte van de rechthoek"));
				Rechthoek r = new Rechthoek(gebruikerPunt, breedte, hoogte);
				
				this.tekening.voegToe(r);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "geen negatieve waarden");

			}

		}
		else if (keuze.equals("Lijnstuk")) {
			
			try {
				int x = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het punt:"));
				int y = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het punt:"));
				Punt startPunt = new Punt(x, y);
				x = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het punt:"));
				y = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het punt:"));
				Punt eindPunt = new Punt(x, y);
				LijnStuk lijn = new LijnStuk(startPunt, eindPunt);
				
				this.tekening.voegToe(lijn);
 
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Fout begin en/of eindpunt");
			}
		}
		else if (keuze.equals("Driehoek")) {
			
			try {
				
				int x1 = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het eerste punt van de driehoek:"));
				int y1 = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het eerste punt van de driehoek:"));
				Punt punt1 = new Punt(x1, y1);
				int x2 = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het tweede punt van de driehoek:"));
				int y2 = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het tweede punt van de driehoek:"));
				Punt punt2 = new Punt(x2, y2);
				int x3 = Integer.parseInt(JOptionPane.showInputDialog("x coordinaat van het derde punt van de driehoek:"));
				int y3 = Integer.parseInt(JOptionPane.showInputDialog("y coordinaat van het derde punt van de driehoek:"));
				Punt punt3 = new Punt(x3, y3);
				Driehoek driehoek = new Driehoek(punt1, punt2, punt3);
				
				this.tekening.voegToe(driehoek);
 
			} catch (Exception e) {
				
				JOptionPane.showMessageDialog(null, "Fout punt in de driehoek");
				
			}
		}
		
		JOptionPane.showMessageDialog(null, this.tekening);
	}

}
