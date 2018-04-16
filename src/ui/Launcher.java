package ui;

public class Launcher {
	public static void main(String[] args) {
		
		String inputValue = JOptionPane.showInputDialog("Welkom!\n Hoe heet je?");
		Speler speler = new Speler(inputValue);
		
	}

}
