package ui;

import domain.*;

public class TekeningHangMan extends Tekening {
	
	public TekeningHangMan() {
		
		super("Hangman");
		
		Vorm galgBodem = new Rechthoek(new Punt(10, 350), 300, 40);// altijd zichtbaar
		Vorm galgStaaf = new LijnStuk(new Punt(160, 50), new Punt(160, 350));// altijd zichtbaar
		Vorm hangbar = new LijnStuk(new Punt(160, 50), new Punt(280, 50));// altijd zichtbaar
		Vorm koord = new LijnStuk(new Punt(280, 50), new Punt(280, 100));// altijd zichtbaar
		Vorm hoofd = new Cirkel(new Punt(280, 125), 25);// zichtbaar na 1 fout
		hoofd.setZichtbaar(false);
		Vorm oogLinks = new Cirkel(new Punt(270, 118), 2);// zichtbaar na 2 fouten
		oogLinks.setZichtbaar(false);
		Vorm oogRechts = new Cirkel(new Punt(290, 118), 2);
		oogRechts.setZichtbaar(false);
		Vorm neus = new Cirkel(new Punt(280, 128), 2);
		neus.setZichtbaar(false);
		Vorm mond = new LijnStuk(new Punt(270, 138), new Punt(290, 138));
		mond.setZichtbaar(false);
		Vorm lijf = new LijnStuk(new Punt(280, 150), new Punt(280, 250));
		lijf.setZichtbaar(false);
		Vorm beenLinks = new LijnStuk(new Punt(280, 250), new Punt(240, 310));
		beenLinks.setZichtbaar(false);
		Vorm beenRechts = new LijnStuk(new Punt(280, 250), new Punt(320, 310));
		beenRechts.setZichtbaar(false);
		Vorm voetLinks = new Cirkel(new Punt(240, 310), 5);
		voetLinks.setZichtbaar(false);
		Vorm voetRechts = new Cirkel(new Punt(320, 310), 5);
		voetRechts.setZichtbaar(false);
		Vorm armLinks = new LijnStuk(new Punt(280, 200), new Punt(230, 170));
		armLinks.setZichtbaar(false);
		Vorm armRechts = new LijnStuk(new Punt(280, 200), new Punt(330, 170));
		armRechts.setZichtbaar(false);
		Vorm handLinks = new Cirkel(new Punt(230, 170), 5);
		handLinks.setZichtbaar(false);
		Vorm handRechts = new Cirkel(new Punt(330, 170), 5);
		handRechts.setZichtbaar(false);
		
		super.voegToe(galgBodem);
		super.voegToe(galgStaaf);
		super.voegToe(hangbar);
		super.voegToe(koord);
		super.voegToe(hoofd);
		super.voegToe(oogLinks);
		super.voegToe(oogRechts);
		super.voegToe(neus);
		super.voegToe(mond);
		super.voegToe(lijf);
		super.voegToe(beenLinks);
		super.voegToe(beenRechts);
		super.voegToe(voetLinks);
		super.voegToe(voetRechts);
		super.voegToe(armLinks);
		super.voegToe(armRechts);
		super.voegToe(handLinks);
		super.voegToe(handRechts);
	
		
		
	}
	
	
	public int getAantalOnzichtbaar() {
		int aantal = 0;
		for (int i = 0; i < this.getAantalVormen(); i++) {
			if(!this.getVorm(i).isZichtbaar()) {
				aantal++;
			}
			
		}
		return aantal;
	}
	
	public void zetVolgendeZichtbaar() {
		
		if (this.getAantalOnzichtbaar() == 0) {
			throw new UiException("alles getoond");
		}
		
		int index = 0;
		while(this.getVorm(index).isZichtbaar()) {
			index++;
		}
		if(this.getAantalVormen() > index) {
			this.getVorm(index).setZichtbaar(true);
		}
		
	}
	
	
	public void reset() {
		for (int i = 4; i < this.getAantalVormen(); i++) {
			this.getVorm(i).setZichtbaar(false);
			
		}
	}

	@Override
	public void voegToe(Vorm vorm) {
		throw new UiException("kan niet toevoegen");
	}
	
	@Override
	public void verwijder(Vorm vorm) {
		throw new UiException("kan niet verwijderen");
	}
	
/*
	public void teken(Graphics graphic) {
		for (int i = 0; i < this.getAantalVormen(); i++) {
			if (this.getVorm(i).isZichtbaar()) {
				try {
					Tekenbaar tek = (Tekenbaar) this.getVorm(i);
					tek.teken(graphic);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, e.getMessage());
				}
			}
		}
	}
	
	*/
	
}
