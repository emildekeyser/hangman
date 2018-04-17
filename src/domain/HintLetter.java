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
		if(letter == this.letter) {
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
		if(raad(letter) == true) {
			return letter;
		}
		return '_';
		
	}
	
	
	
	
	
	
	

}
