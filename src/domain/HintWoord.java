package domain;

public class HintWoord {
	private String woord;
	private String hint;
	//private ArrayList<HintLetter> hintLetters = new ArrayList<>();
	
	public HintWoord(String woord) {
		if(woord == null || woord.trim().isEmpty())throw new DomainException("Woord mag niet leeg zijn.");
		this.woord = woord.toLowerCase();
		String result = "";
		for(int i = 0; i < this.woord.length(); i++) {
			result += " _";
		}
		this.hint = result.substring(1);
	}
	
	public boolean raad2(char letter) {
		int index = woord.indexOf(letter);
		if(index >=0) {
			
			return true;
		}
		return false;
	}
	
	public boolean raad(char letter) {
		letter = Character.toLowerCase(letter);
		boolean veranderd = false;
		int inwoord = hint.indexOf(letter);
		if(inwoord < 0) {
			for(int i = 0; i < woord.length(); i++) {
				if(woord.charAt(i) == letter) {
					this.hint = hint.substring(0,i*2)+ letter +hint.substring(i*2+1);
					veranderd = true;
				}
			}
		}
		return veranderd;
	}
	
	public boolean isGeraden() {
		if(hint.replaceAll("\\s+","").equals(woord)) {
			System.out.println(hint.trim());
			return true;
		}
		
		else {
			System.out.println(hint.trim());
			return false;
		}
	}
	
	@Override
	public String toString() {
		return this.hint;
	}

	public String getWoord() {
		return this.woord;
		
	}
	
	
}