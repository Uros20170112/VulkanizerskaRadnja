package auto_radnja.gume;

import static org.junit.jupiter.api.Assertions.*;

import java.util.LinkedList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AutoGumaTest {
	
	AutoGuma a;
	AutoGuma b;

	@BeforeEach
	void setUp() throws Exception {
		a = new AutoGuma();
		b = new AutoGuma("Michelin1", 20, 200, 50);
	}

	@AfterEach
	void tearDown() throws Exception {
		a = null;
		b = null;
	}

	@Test
	void testAutoGuma() {
		assertEquals(a.getMarkaModel(), null);
		assertEquals(a.getPrecnik(), -1);
		assertEquals(a.getSirina(), -1);
		assertEquals(a.getVisina(), -1);
	}

	@Test
	void testAutoGumaStringIntIntInt() {
		assertEquals(b.getMarkaModel(), "Michelin1");
		assertEquals(b.getPrecnik(), 20);
		assertEquals(b.getSirina(), 200);
		assertEquals(b.getVisina(), 50);
	}
	
	@Test
	void testSetMarkaModel() {
		a.setMarkaModel("Michelin1");
		assertTrue(a.getMarkaModel().equals("Michelin1"));
	}

	@Test
	void testSetMarkaModelNull() {
		assertThrows(java.lang.NullPointerException.class, () -> a.setMarkaModel(null));
	}

	@Test
	void testSetMarkaModelManjeOd3() {
		assertThrows(java.lang.IllegalArgumentException.class, () -> a.setMarkaModel("M1"));
	}
	
	@ParameterizedTest
	@CsvSource({
		"20", "21", "15"
	})
	void testSetPrecnikDozvoljen(int precnik) {
		a.setPrecnik(precnik);
		assertEquals(precnik, a.getPrecnik());
	}
	
	@ParameterizedTest
	@CsvSource({
		"2", "201", "12"
	})
	void testSetPrecnikNedozvoljen(int precnik) {
		assertThrows(java.lang.IllegalArgumentException.class, () -> a.setPrecnik(precnik));	
	}

	@ParameterizedTest
	@CsvSource({
		"136", "200", "350"
	})
	void testSetSirinaDozvoljen(int sirina) {
		a.setSirina(sirina);
		assertEquals(sirina, a.getSirina());
	}
	
	@ParameterizedTest
	@CsvSource({
		"134", "20", "359"
	})
	void testSetSirinaNedozvoljen(int sirina) {
		assertThrows(java.lang.IllegalArgumentException.class, () -> a.setSirina(sirina));
	}

	@ParameterizedTest
	@CsvSource({
		"25", "50", "75"
	})
	void testSetVisinaDozvoljen(int visina) {
		a.setVisina(visina);
		assertEquals(visina, a.getVisina());
	}
	
	@ParameterizedTest
	@CsvSource({
		"2", "500", "750"
	})
	void testSetVisinaNedozvoljen(int visina) {
		assertThrows(java.lang.IllegalArgumentException.class, () -> a.setVisina(visina));
	}

	@Test
	void testToString() {
		a.setMarkaModel("Michelin1");
		a.setPrecnik(20);
		a.setSirina(190);
		a.setVisina(40);
		
		String s = a.toString();
		assertTrue(s.contains("Michelin1"));
		assertTrue(s.contains("20"));
		assertTrue(s.contains("190"));
		assertTrue(s.contains("40"));
		
	}

	@ParameterizedTest
	@CsvSource({
		"Tigar1, 21, 190, 25, Tigar2, 18, 200, 40, false",
		"Tigar1, 21, 190, 25, Tigar1, 21, 190, 25, true"
	})
	void testEqualsObject(String marka1, int precnik1, int sirina1, int visina1,
			String marka2, int precnik2, int sirina2, int visina2, boolean jednako) {
		a.setMarkaModel(marka1);
		a.setPrecnik(precnik1);
		a.setSirina(sirina1);
		a.setVisina(visina1);
		
		AutoGuma a2 = new AutoGuma(marka2, precnik2, sirina2, visina2);
		assertEquals(jednako, a.equals(a2));
	}

}
