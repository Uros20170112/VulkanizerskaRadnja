package auto_radnja;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import auto_radnja.gume.AutoGuma;

public abstract class RadnjaTest {

	protected Radnja r;
	List<AutoGuma> g;
	AutoGuma a;
	AutoGuma b;

	@BeforeEach
	void setUp() throws Exception {
		
	}

	@AfterEach
	void tearDown() throws Exception {
		a = null;
		b = null;
		g = null;
	}

	@Test
	void testDodajGumuNull() {
		assertThrows(java.lang.NullPointerException.class, () -> r.dodajGumu(null) );
	}
	
	@Test
	void testDodajGumuPostoji() {
		a = new AutoGuma("Michelin1", 20, 200, 40);
		b = new AutoGuma("Michelin1", 20, 200, 40);
		r.dodajGumu(a);
		assertThrows(java.lang.RuntimeException.class, () -> r.dodajGumu(b));
	}
	
	@Test
	void testDodajGumuDozvoljeno() {
		a = new AutoGuma("Michelin1", 20, 200, 40);
		r.dodajGumu(a);
		assertEquals(a, r.vratiSveGume().get(0));
		assertEquals(1, r.vratiSveGume().size());
		
	}

	@Test
	void testPronadjiGumuNull() {
		a = new AutoGuma();
		r.dodajGumu(a);
		assertEquals(null, r.pronadjiGumu(null));
	}
	
	@Test
	void testPronadjiGumuNema() {
		a = new AutoGuma();
		b = new AutoGuma();
		a.setMarkaModel("Michelin1");
		b.setMarkaModel("Tigar1");
		
		r.dodajGumu(a);
		assertEquals(0, r.pronadjiGumu(b.getMarkaModel()).size());
	}
	
	@Test
	void testPronadjiGumuVise() {
		a = new AutoGuma("Michelin1", 20, 200, 40);
		b = new AutoGuma("Michelin1", 19, 190, 30);
		
		r.dodajGumu(a);
		r.dodajGumu(b);
		
		List<AutoGuma> pom = r.pronadjiGumu("Michelin1");
		assertEquals(2, pom.size());
		assertTrue(pom.contains(a));
		assertTrue(pom.contains(b));
	}

	@Test
	void testVratiSveGume() {
		a = new AutoGuma("Michelin1", 20, 200, 40);
		b = new AutoGuma("Michelin1", 19, 190, 30);
		AutoGuma a1 = new AutoGuma("Michelin2", 20, 200, 40);
		AutoGuma b1 = new AutoGuma("Michelin2", 19, 190, 30);
		
		r.dodajGumu(a);
		r.dodajGumu(b);
		r.dodajGumu(a1);
		r.dodajGumu(b1);
		
		assertEquals(4, r.vratiSveGume().size());
	}

}
