package ui;

import domain.*;

public class TekeningHangMan extends Tekening {

	public TekeningHangMan() {
		
		super("Hangman");
		
		Vorm galgBodem = new Rechthoek(new Punt(10, 350), 300, 40);
		Vorm galgStaaf = new LijnStuk(new Punt(160, 350), new Punt(160, 50)); // altijd zichtbaar
		Vorm hangbar = new LijnStuk(new Punt(160, 50), new Punt(280, 50)); // altijd zichtbaar
		Vorm koord = new LijnStuk(new Punt(280, 50), new Punt(280, 100)); // altijd zichtbaar
		Vorm hoofd = new Cirkel(new Punt(280, 125), 25); // zichtbaar na 1 fout
		Vorm oogLinks = new Cirkel(new Punt(270, 118), 2); // zichtbaar na 2 fouten
		
		Vorm oogRechts = new Cirkel(new Punt(290, 118), 2);
		Vorm neus = new Cirkel(new Punt(280, 128), 2);
		Vorm mond = new LijnStuk(new Punt(270, 138), new Punt(290, 138));
		Vorm lijf = new LijnStuk(new Punt(280,150), new Punt(280, 250));
		Vorm beenLinks = new LijnStuk(new Punt(280, 250), new Punt(240, 310));
		Vorm beenRechts = new LijnStuk(new Punt(280, 250), new Punt(320, 310));
		Vorm voetLinks = new Cirkel(new Punt(240, 310), 5);
		Vorm voetRechts = new Cirkel(new Punt(320, 310), 5);
		Vorm armLinks = new LijnStuk(new Punt(280, 200), new Punt(230, 170));
		Vorm armRechts = new LijnStuk(new Punt(280, 200), new Punt(330, 170));
		Vorm handLinks = new Cirkel(new Punt(230, 170), 5);
		Vorm handRechts = new Cirkel(new Punt(330, 170), 5);
		
		this.voegToe(galgBodem);
		this.voegToe(galgStaaf);
		this.voegToe(hangbar);
		this.voegToe(koord);
		this.voegToe(hoofd);
		this.voegToe(oogLinks);
		this.voegToe(oogRechts);
		this.voegToe(neus);
		this.voegToe(mond);
		this.voegToe(lijf);
		this.voegToe(beenLinks);
		this.voegToe(beenRechts);
		this.voegToe(voetLinks);
		this.voegToe(voetRechts);
		this.voegToe(armLinks);
		this.voegToe(armRechts);
		this.voegToe(handLinks);
		this.voegToe(handRechts);
		
		
	}

}
