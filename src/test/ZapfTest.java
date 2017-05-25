package test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import automat.AutomatenSteuerung;
import automat.Bezeichnung;
import automat.Protokoll;

public class ZapfTest {
	AutomatenSteuerung testAutomat = AutomatenSteuerung.getInstance();
	Protokoll testProtokoll = Protokoll.getInstance();
	private float delta = 0.001f;

	@Test
	public void testGetInstance() {
		AutomatenSteuerung testAutomat = AutomatenSteuerung.getInstance();
		assertEquals(testAutomat,AutomatenSteuerung.getInstance());

		Protokoll testProtokoll = Protokoll.getInstance();
		assertEquals(testProtokoll,Protokoll.getInstance());
	}

	@Test
	public void testBezahleBetrag() {
		testAutomat.testKonfiguration();
		testAutomat.waehleProdukt(Bezeichnung.KAKAO);
		testAutomat.bezahleBetrag(Bezeichnung.KAKAO.getPreis());
		testAutomat.zapfeProdukt();
		assertEquals(Bezeichnung.KAKAO.getPreis(), testProtokoll.getUmsatz(), delta );
		assertEquals("Kakao (1.0EURO)", cutDate(testAutomat.listeVerkäufe()[0]));
		testAutomat.waehleProdukt(Bezeichnung.KAFFEE);
		testAutomat.bezahleBetrag(0.1f);
		testAutomat.bezahleBetrag(0.2f);
		testAutomat.bezahleBetrag(0.1f);
		testAutomat.bezahleBetrag(0.2f);
		testAutomat.bezahleBetrag(0.4f);
		testAutomat.bezahleBetrag(0.2f);
		testAutomat.zapfeProdukt();
		System.out.println(testAutomat.listeVerkäufe()[1]);
		float erwartet = Bezeichnung.KAFFEE.getPreis() + Bezeichnung.KAKAO.getPreis();
		assertEquals(erwartet, testProtokoll.getUmsatz(), delta);
		assertEquals("Kaffe (1.2EURO)", cutDate(testAutomat.listeVerkäufe()[1]));
	}

	private String cutDate(String date){
		return date.substring(0, date.indexOf(':') - 3);
	}

	@Test
	public void testWaehleProdukt() {
		fail("Not yet implemented");
	}

	@Test
	public void testWaehleOption() {
		fail("Not yet implemented");
	}

	@Test
	public void testFordereWechselgeld() {
		fail("Not yet implemented");
	}

	@Test
	public void testZapfeProdukt() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetUmsatz() {
		fail("Not yet implemented");
	}

	@Test
	public void testListeVerkäufe() {
		fail("Not yet implemented");
	}

	@Test
	public void testAbbruch() {
		fail("Not yet implemented");
	}

}
