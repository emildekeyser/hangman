package ui;

public class HangManUI {
	
	
	public void play() {
		TekeningHangMan tekening = new TekeningHangMan();
		GameHoofdScherm view = new GameHoofdScherm(tekening.getNaam(), tekening);
		view.setVisible(true);
		view.teken();
	}

}
