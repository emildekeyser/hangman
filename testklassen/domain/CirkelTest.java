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
			new Cirkel(geldigMiddelPunt, geldigeRadius);
		} catch (Exception e) {
			fail();
		}

	}
	
	
	@Test (expected = DomainException.class)
	public void CirkelMetMiddelPuntNullGooitException() {
		new Cirkel(null, geldigeRadius);
	}
	
	@Test (expected = DomainException.class)
	public void CirkelMetStraalZeroGooitException() {
		new Cirkel(geldigMiddelPunt, 0);
	}
	
	@Test (expected = DomainException.class)
	public void CirkelMetStraalNegatiefGooitException() {
		new Cirkel(geldigMiddelPunt, -123652);
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
	
	@Test
	public void Omhullende_geeft_correcte_waarde() {
		Cirkel geldig1 = new Cirkel(geldigMiddelPunt, geldigeRadius);
		
		int x = this.geldigMiddelPunt.getX() - this.geldigeRadius;
		int y = this.geldigMiddelPunt.getY() - this.geldigeRadius;
		Punt linkerBoven = new Punt(x,y);
		int zijde = this.geldigeRadius * 2;
		
	
		assertEquals(linkerBoven, geldig1.getOmhullende().getLinkerBovenhoek());
		assertEquals(zijde,geldig1.getRadius()*2);

	}
}
