package domain;

import static org.junit.Assert.*;

import org.junit.Test;

public class DriehoekTest {
	private Punt punt1 = new Punt(10, 20);
	private Punt zelfdeAlsPunt1 = new Punt(10, 20);
	private Punt verschillendVanPunt1 = new Punt(15, 20);
	private Punt punt2 = new Punt(20, 40);
	private Punt zelfdeAlsPunt2 = new Punt(20, 40);
	private Punt verschillendVanPunt2 = new Punt(40, 20);
	private Punt punt3 = new Punt(190, 30);
	private Punt zelfdeAlsPunt3 = new Punt(190, 30);
	private Punt verschillendVanPunt3 = new Punt(120, 100);
	
	private Punt puntOpLijn1 = new Punt(10, 30);
	private Punt puntOpLijn2 = new Punt(10, 40);
	private Punt puntOpLijn3 = new Punt(10, 50);
	

	@Test
	public void Driehoek_moet_DrieHoek_aanmaken_met_gegeven_hoekpunten() {
		Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);

		assertEquals(punt1, drieHoek.getHoekPunt1());
		assertEquals(punt2, drieHoek.getHoekPunt2());
		assertEquals(punt3, drieHoek.getHoekPunt3());
	}
	//zelf verzonnen test
	@Test (expected = DomainException.class)
	public void Driehoek_Moet_exception_gooien_als_hoekpunten_op_zelfde_lijn() {
		
		new Driehoek(puntOpLijn1, puntOpLijn2, puntOpLijn3);
		
	}
	//zelf verzonnen test
	@Test (expected = DomainException.class)
	public void Driehoek_Moet_exception_gooien_als_hoekpunten_overlappen() {
			
		new Driehoek(punt1, punt1, punt2);
			
	}
	@Test (expected = DomainException.class)
	public void Driehoek_Moet_exception_gooien_als_hoekpunt1_null()  {
		new Driehoek(null, punt2, punt3);
	}
	
	@Test (expected = DomainException.class)
	public void Driehoek_Moet_exception_gooien_als_hoekpunt2_null()  {
		new Driehoek(punt1, null, punt3);
	}
	
	@Test (expected = DomainException.class)
	public void DrieHoek_Moet_exception_gooien_als_hoekpunt3_null()  {
		new Driehoek(punt1, punt2, null);
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_hoekPunt1_verschillend(){
		Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
		Driehoek andereDriehoek = new Driehoek(verschillendVanPunt1, zelfdeAlsPunt2, zelfdeAlsPunt3);
		assertFalse(drieHoek.equals(andereDriehoek));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_hoekPunt2_verschillend(){
		Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
		Driehoek andereDriehoek = new Driehoek(zelfdeAlsPunt1, verschillendVanPunt2, zelfdeAlsPunt3);
		assertFalse(drieHoek.equals(andereDriehoek));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_hoekPunt3_verschillend(){
		Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
		Driehoek andereDriehoek = new Driehoek(zelfdeAlsPunt1, zelfdeAlsPunt2, verschillendVanPunt3);
		assertFalse(drieHoek.equals(andereDriehoek));
	}
	
	@Test
	public void equals_moet_false_teruggeven_als_parameter_null(){
		Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
		assertFalse(drieHoek.equals(null));
	}
	
	@Test
	public void Omhullende_geeft_correcte_waarde() {
		Driehoek drieHoek = new Driehoek(punt1, punt2, punt3);
		
		int x = punt1.getX();
		int y = Math.min(Math.min(punt1.getY(), punt2.getY()), punt3.getY());
		int hoogte = Math.max(Math.max(punt1.getY(), punt2.getY()), punt3.getY()) - y ;
		int breedte = Math.max(Math.max(punt1.getX(), punt2.getX()), punt3.getX()) - x ;
		Punt linkerBovenHoek = new Punt(x, y);
		
		assertEquals(linkerBovenHoek, drieHoek.getOmhullende().getLinkerBovenhoek());
		assertEquals(breedte, drieHoek.getOmhullende().getBreedte());
		assertEquals(hoogte, drieHoek.getOmhullende().getHoogte());
		
	}

}
