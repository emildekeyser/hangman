package domain;

public class HintWoord {
	private String woord;
	private String hint;
	//private ArrayList<HintLetter> hintLetters = new ArrayList<>();
	
	public HintWoord(String woord) {
		if(woord == null)throw new DomainException("Woord mag niet null zijn.");
		this.woord = woord;
	}
	
	public boolean raad(char letter) {
		int index = woord.indexOf(letter);
		if(index >=0) {
		String result = "";
		
		for(int i = 0; i < this.woord.length(); i++) {
			if(index == i) {
				result += " " + letter;
			}
			else {
			result += " _";
			}
		}
		this.hint = result.substring(1);
		System.out.println(hint);
		return true;
		}
		return false;
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
		this.hint = result.substring(1);
		return this.hint;
	}

	public String getWoord() {
		return this.woord;
		
	}
	
	
}