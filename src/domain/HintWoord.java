package domain;

import java.util.ArrayList;

public class HintWoord {
	private String woord;
	//private ArrayList<HintLetter> hintLetters = new ArrayList<>();
	
	public HintWoord(String woord) {
		this.woord = woord;
	}
	
	public boolean raad(char letter) {
		return true;
	}
	
	public boolean isGeraden() {
		return true;
	}

	@Override
	public String toString() {
		return "HintWoord [woord=" + woord + "]";
	}

	public String getWoord() {
		return woord;
	}
	
	
}
