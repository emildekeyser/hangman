package ui;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import db.WoordenLezer;
import domain.HangMan;
import domain.WoordenLijst;

public class HangmanPaneel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JTextField letter;
	private JLabel woord;

	private TekenVenster tekenVenster;
	private HangMan spel;

	public HangmanPaneel(HangMan spel) {
		super();
		setSpel(spel);
		init();
	}

	private void init() {
		letter = new JTextField("", 5);
		woord = new JLabel("");

		this.setLayout(new BorderLayout());
		this.add(letter, BorderLayout.EAST);
		this.add(woord, BorderLayout.CENTER);

		letter.addKeyListener(new RaadLuisteraar());
	}

	private void reset() {
		woord.setText(getSpel().getHint());
		getTekenVenster().teken();
	}

	// String randomWord = this.getWoordenLijst().getRandomWord();
	// rade = new HintWoord(randomWord);
	// while(!rade.isGeraden()) {
	// String s = JOptionPane.showInputDialog(null, "Rarara welk woord zoeken we?
	// \n\n"+ rade.toString()+ "\n Geef een letter.");
	// char c = s.charAt(0);
	// if(!rade.raad(c)) {
	// tekening.zetVolgendeZichtbaar();

	public class RaadLuisteraar implements KeyListener {

		@Override
		public void keyPressed(KeyEvent arg0) {
			if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
				String input = letter.getText();
				char guess = '\u0000';
				if (input.length() > 0) {
					guess = input.charAt(0);
				}

				getSpel().raad(guess);

				woord.setText(getSpel().getHint());
				letter.setText("");
				getTekenVenster().teken();

				String gewonnenOfVerloren = "";
				if (getSpel().isGewonnen()) {
					gewonnenOfVerloren = "Gewonnen!";
				} else if (getSpel().isGameOver()) {
					gewonnenOfVerloren = "Verloren!";
				}

				if (!gewonnenOfVerloren.isEmpty()) {
					int option = JOptionPane.showConfirmDialog(null, gewonnenOfVerloren + "\nVerder spelen ?", gewonnenOfVerloren,
							JOptionPane.YES_NO_OPTION, JOptionPane.ERROR_MESSAGE);
					if (option == JOptionPane.YES_OPTION) {
						WoordenLijst nieuweWoordenlijst = new WoordenLezer("hangman.txt").lees();
						HangMan nieuwSpel = new HangMan(getSpel().getSpeler(), nieuweWoordenlijst);
						setSpel(nieuwSpel);
						getTekenVenster().setTekening(nieuwSpel.getTekening());
						reset();
					}else {
						System.exit(0);
					}
					
				}
			}
		}

		@Override
		public void keyReleased(KeyEvent arg0) {
			/* Niet nodig */}

		@Override
		public void keyTyped(KeyEvent arg0) {
			/* Niet nodig */}
	}

	private void setSpel(HangMan spel) {
		this.spel = spel;
	}

	private HangMan getSpel() {
		return spel;
	}

	private TekenVenster getTekenVenster() {
		return tekenVenster;
	}

	public void setTekenVenster(TekenVenster tekenVenster) {
		this.tekenVenster = tekenVenster;

		reset();
	}
}