package domain;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class CirkelTest {

	private Punt geldigMiddelPunt;
	private Punt anderMiddelPunt;
	private int geldigeRadius;
	private int andereRadius;

	@Before
	public void setUp() throws Exception {
		 geldigMiddelPunt = new Punt(200, 200);
		 anderMiddelPunt = new Punt(100,100);
		 geldigeRadius = 50;
		 andereRadius = 25;
	}

	@Test
	public void Maak_geldige_cirkel() {
		
		try {
			Cirkel geldig = new Cirkel(geldigMiddelPunt, geldigeRadius);
		} catch (Exception e) {
			fail();
		}

	}
	
	
	@Test (expected = DomainException.class)
	public void CirkelMetMiddelPuntNullGooitException() {
		Cirkel ci = new Cirkel(null, geldigeRadius);
	}
	
	@Test (expected = DomainException.class)
	public void CirkelMetStraalZeroGooitException() {
		Cirkel ci = new Cirkel(geldigMiddelPunt, 0);
	}
	
	@Test (expected = DomainException.class)
	public void CirkelMetStraalNegatiefGooitException() {
		Cirkel ci = new Cirkel(geldigMiddelPunt, -123652);
	}
	
	@Test
	public void CirkelsZijnGelijkWanneerMiddelpuntEnRadiusZijnGelijk(){
		Cirkel geldig1 = new Cirkel(geldigMiddelPunt, geldigeRadius);
		Cirkel geldig2 = new Cirkel(geldigMiddelPunt, geldigeRadius);
		assertEquals(geldig1, geldig2);
	}
	
	@Test
	public void CirkelsZijnVerschillendWanneerMiddelpuntEnRadiusZijnGelijk(){
		Cirkel geldig1 = new Cirkel(geldigMiddelPunt, geldigeRadius);
		Cirkel geldig2 = null;
		assertNotEquals(geldig1, geldig2);
	}
	
	@Test
	public void CirkelsZijnVerschillendWanneerMiddelpuntIsVerschillend(){
		Cirkel geldig1 = new Cirkel(geldigMiddelPunt, geldigeRadius);
		Cirkel geldig2 = new Cirkel(anderMiddelPunt, geldigeRadius);
		assertNotEquals(geldig1, geldig2);
	}
	
	@Test
	public void CirkelsZijnVerschillendWanneerRadiusIsVerschillend(){
		Cirkel geldig1 = new Cirkel(geldigMiddelPunt, geldigeRadius);
		Cirkel geldig2 = new Cirkel(geldigMiddelPunt, andereRadius);
		assertNotEquals(geldig1, geldig2);
	}
	
	/*
	@Test (expected = DomainException.class)
	public void Speler_moet_exception_gooien_als_naam_lege_string() {
		speler = new Speler("");
	}
	
	@Test
	public void equals_moet_true_teruggeven_als_naam_en_score_gelijk_zijn(){
		speler.addToScore(positiveScore);
		Speler andereSpeler = new Speler(naam);
		andereSpeler.addToScore(positiveScore);
		
		assertTrue(speler.equals(andereSpeler));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_parameter_null(){
		assertFalse(speler.equals(null));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_speler_een_andere_naam_heeft(){
		Speler andereSpeler = new Speler(anderenaam);
		assertFalse(speler.equals(andereSpeler));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_speler_aan_andere_score_heeft(){
		Speler andereSpeler = new Speler(naam);
		andereSpeler.addToScore(positiveScore);
		assertFalse(speler.equals(andereSpeler));
	}
	
	@Test
	public void addToScore_moet_gegeven_score_toevoegen_aan_bestaande_score(){
		speler.addToScore(positiveScore);
		assertEquals(positiveScore, speler.getScore());
	}
	
	@Test
	public void addtoScore_mag_negatieve_score_toevoegen_als_de_resulterende_score_niet_negatief_wordt(){
		speler.addToScore(positiveScore);
		speler.addToScore(positiveScore);
		speler.addToScore(negativeScore);
		assertEquals(positiveScore, speler.getScore());
	}
	
	@Test (expected = DomainException.class)
	public void addToScore_moet_exception_gooien_als_resulterende_score_negatief_wordt(){
		speler.addToScore(negativeScore);
	}*/
}
