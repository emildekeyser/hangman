package domain;

public class HintWoord {
	private String woord;
	private String hint;
	
	public HintWoord(String woord) {
		//Het te raden woord (woord) mag niet leeg zijn en wordt omgezet naar kleine letters
		if(woord == null || woord.trim().isEmpty())throw new DomainException("Woord mag niet leeg zijn.");
		this.woord = woord.toLowerCase();
		//een lege hint wordt aangemaakt. "_" wordt op de plaats van een letter gezet. bv: "test" wordt "_ _ _ _".
		String result = "";
		for(int i = 0; i < this.woord.length(); i++) {
			result += " _";
		}
		this.hint = result.substring(1);
	}
	
	public boolean raad(char letter) {
		// letter omzetten naar lowercase
		letter = Character.toLowerCase(letter);
		boolean veranderd = false;
		// check of letter al eens geraden is
		int inwoord = hint.indexOf(letter);
		if(inwoord < 0 || letter == ' ') {
			for(int i = 0; i < woord.length(); i++) {
				//substring in hint omzetten naar letter
				if(woord.charAt(i) == letter) {
					this.hint = hint.substring(0,i*2)+ letter +hint.substring(i*2+1);
					veranderd = true;
				}
			}
		}
		// return true wanneer de letter in het woord zit en veranderd is. return false als de letter niet in het woord zit.
		return veranderd;
	}
	
	// als alle letters geraden zijn geeft deze functie true terug
	public boolean isGeraden() {
		if(hint.replaceAll("\\s+","").equals(woord.replaceAll("\\s+", ""))) {
			return true;
		}
		
		else {
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