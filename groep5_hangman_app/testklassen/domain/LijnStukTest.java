package domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LijnStukTest {
	private Punt punt1 = new Punt(10, 20);
	private Punt zelfdeAlsPunt1 = new Punt(10, 20);
	private Punt punt2 = new Punt(190, 30);
	private Punt zelfdeAlsPunt2 = new Punt(190, 30);

	@Test
	public void LijnStuk_moet_lijnstuk_aanmaken_met_gegeven_startPunt_en_eindPunt() {
		LijnStuk lijnstuk = new LijnStuk(punt1, punt2);

		assertEquals(punt1, lijnstuk.getStartPunt());
		assertEquals(punt2, lijnstuk.getEindPunt());
	}
	
	@Test (expected = DomainException.class)
	public void LijnStuk_Moet_exception_gooien_als_startpunt_null()  {
		new LijnStuk(null, punt2);
	}
	
	@Test (expected = DomainException.class)
	public void LijnStuk_Moet_exception_gooien_als_eindpunt_null()  {
		new LijnStuk(punt1, null);
	}
	
	@Test (expected = DomainException.class)
	public void LijnStuk_Moet_exception_gooien_als_start_en_eindpunt_gelijk()  {
		new LijnStuk(punt1, punt1);
	}
	
	@Test
	public void equals_moet_true_teruggeven_als_begin_en_eindpunt_gelijk_zijn(){
		LijnStuk lijnStuk = new LijnStuk(punt1, punt2);
		LijnStuk zelfdeLijnStuk = new LijnStuk(zelfdeAlsPunt1, zelfdeAlsPunt2);
		assertTrue(lijnStuk.equals(zelfdeLijnStuk));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_parameter_null(){
		LijnStuk lijnStuk = new LijnStuk(punt1, punt2);
		assertFalse(lijnStuk.equals(null));
	}
	
	@Test
	public void Omhullende_geeft_correcte_waarde() {
		LijnStuk lijnStuk = new LijnStuk(punt1, punt2);
		
		Punt linkerBovenPunt = new Punt(punt1.getX(), punt1.getY());
		int breedte = punt2.getX() - punt1.getX();
		int hoogte = punt2.getY() - punt1.getY();
		
		assertEquals(linkerBovenPunt, lijnStuk.getOmhullende().getLinkerBovenhoek());
		assertEquals(breedte, lijnStuk.getOmhullende().getBreedte());
		assertEquals(hoogte, lijnStuk.getOmhullende().getHoogte());
		
	}
}
	
