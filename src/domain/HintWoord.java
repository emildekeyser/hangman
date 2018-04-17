package domain;

import java.util.ArrayList;

public class HintWoord {
	private String woord;
	//private ArrayList<HintLetter> hintLetters = new ArrayList<>();
	
	public HintWoord(String woord) {
		this.woord = woord;
	}
	
	public boolean raad(char letter) {
		woord.indexOf(letter);
		String result = "";
		for(int i = 0; i < this.woord.length(); i++) {
			if(i == woord.indexOf(letter)) {
				
			}
			result += " _";
		}
		return true;
	}
	
	public boolean isGeraden() {
		return false;
	}
	
	@Override
	public String toString() {
		String result = "";
		for(int i = 0; i < this.woord.length(); i++) {
			result += " _";
		}
		return result.substring(1);
	}

	public String getWoord() {
		return this.woord;
		
	}
	
	
}
