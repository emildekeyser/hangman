package domain;

public class HintLetter {
	
	private char letter;

	public HintLetter(char letter) {
		this.letter = letter;
	}

	
	
	public char getLetter() {
		return letter;
	}
	
	
	public boolean raad(char letter) {
		if(letter == getLetter()) {
			return true;
		}
		return false;
	}
	
	public boolean isGeraden() {
		if(raad(letter) == true) {
			return true;
		}
		return false;
	}


	public char toChar() {
		return letter;
	}
	
	
	
	
	
	
	

}
