import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DVDTest {
	private DVD d1,d2,d3,d4;
	
	@Before
	public void setUp() {
		d1=new DVD("Auntie Mame","NR",123);
		d2=new DVD("The Gentlemen","R",97);
		d3=new DVD("Fantastic Beasts","PG-13",89);
		d4=new DVD("American Underdog","PG",103);
	}
	
	
	@Test
	// Testing SetRating
	public void testSetRating() {
		d2.setRating("NR");
		assertEquals("NR",d2.getRating());
		d1.setRating("R");
		assertEquals("R",d1.getRating());
	}
	@Test
	// Testing RunningTime 
	public void testSetRunningTime() {
		d3.setRunningTime(1234);
		assertEquals(1234,d3.getRunningTime());
		d3.setRunningTime(89);
		assertEquals(89,d3.getRunningTime());
	}
	@Test
	// Testing ToString
	public void testToString() {
		assertEquals("AUNTIE MAME/NR/123min",d1.toString());
		assertEquals("THE GENTLEMEN/R/97min",d2.toString());
		assertEquals("FANTASTIC BEASTS/PG-13/89min",d3.toString());
		assertEquals("AMERICAN UNDERDOG/PG/103min",d4.toString());
	}
}