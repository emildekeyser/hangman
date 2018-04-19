package ui;


import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import domain.DomainException;
import domain.Punt;
import domain.Rechthoek;

public class TekeningHangManTest {

	private TekeningHangMan tekening;
	
	@Before
	public void setUp() {
		tekening = new TekeningHangMan();		
	}
	
	
	@Test
	public void eerste_4_zichtbaar() {
		assertTrue(tekening.getVorm(0).isZichtbaar() && tekening.getVorm(1).isZichtbaar() && tekening.getVorm(2).isZichtbaar() && tekening.getVorm(3).isZichtbaar());
	}
	
	
	@Test
	public void volgende_zichtbaar() {
		tekening.zetVolgendeZichtbaar();
		assertTrue(tekening.getVorm(4).isZichtbaar());
	}
	
	@Test (expected = UiException.class)
	public void alles_zichtbaar_exception() {
		for (int i = 0; i < 100; i++) {
			tekening.zetVolgendeZichtbaar();	
		}
	}
	
	
	@Test
	public void beginstaat_naar_reset() {
		tekening.zetVolgendeZichtbaar();
		tekening.reset();
		assertTrue(tekening.getVorm(0).isZichtbaar() && tekening.getVorm(1).isZichtbaar() && tekening.getVorm(2).isZichtbaar() && tekening.getVorm(3).isZichtbaar());
	}
	
	
	@Test (expected = UiException.class)
	public void voegtoe_werkt_niet() {
		Rechthoek raam = new Rechthoek(new Punt(210, 220), 80, 60);
		tekening.voegToe(raam);
	}
	

	
	@Test (expected = UiException.class)
	public void verwijder_werkt_niet() {
		Rechthoek raam = new Rechthoek(new Punt(210, 220), 80, 60);
		tekening.verwijder(raam);
	}
}
