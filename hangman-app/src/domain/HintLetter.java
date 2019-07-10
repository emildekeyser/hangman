package domain;

public class HintLetter {
	
	private char letter;
	private boolean geraden;

	public HintLetter(char letter) {
		this.letter = letter;
	}

	public char getLetter() {
			return letter;
	
	}

	public boolean raad(char letter) {
		if(geraden == true) {
			return false;
		}
		char lg = Character.toUpperCase(letter);
		char ll = Character.toLowerCase(letter);
		if(lg == this.letter || ll == this.letter) {
			geraden = true;
			return true;
		}
		return false;
	}
	
	public boolean isGeraden() {
		if(geraden == true) {
			return true;
		}
		
		return false;
	}


	public char toChar() {
		if(isGeraden() == true) {
			return letter;
		}
		return '_';
		
	}
	
	
	
	
	
	
	

}
