
package rsa.quad;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test on a PointQuadtree, the facade of quad package.
 * It supports {@code insert()}, {@code find()}
 * {@code inserReplace()} and {@code delete()} methods,
 * implemented through delegation on the root trie.
 * 
 * @author Jos&eacute; Paulo Leal {@code zp@dcc.fc.up.pt}
 */
public class PointQuadtreeTest {

	
	private static final String DATA = "rsa/quad/locais.txt";
	static double RADIUS = 0.0001D; // 11.13 m
	
	private static int CAPACITY = 10;
	
	private static final int BOTTOM_RIGHT_Y = 10;
	private static final int BOTTOM_RIGHT_X = 20;
	private static final int TOP_LEFT_Y = 20;
	private static final int TOP_LEFT_X = 10;
	
	private static final int CENTER_X = (TOP_LEFT_X + BOTTOM_RIGHT_X)/2;
	private static final int CENTER_Y = (TOP_LEFT_Y + BOTTOM_RIGHT_Y)/2;
	
	private static final int TOO_LARGE_COORDINATE = 30;
	private static final int TOO_SMALL_COORDINATE =  0;
	
	private static final int SMALL_RADIUS = 1;
	
	static Map<String,Location> locations;
	
	@BeforeClass
	static public void setUp() {
		Trie.setCapacity(CAPACITY);
		locations = load();
	}

	 PointQuadtree<Location> quad;
	
	 Location porto;
	 
	@Before
	public void prepare() {
		quad = new PointQuadtree<>(TOP_LEFT_X,TOP_LEFT_Y,BOTTOM_RIGHT_X,BOTTOM_RIGHT_Y);
		
		porto = locations.get("Porto");
	}
	
	/**
	 * Points outside the boundaries should raise an exception
	 */

	/**
	 * Points on the boundaries should not raise exceptions
	 */
	@Test
	public void testBoundariesIn() {
		 quad.insert(new Location("center", CENTER_X, CENTER_Y));
		 quad.insert(new Location("top left", TOP_LEFT_X, TOP_LEFT_Y));
		 quad.insert(new Location("top right", BOTTOM_RIGHT_X, TOP_LEFT_Y));
		 quad.insert(new Location("bottom right", TOP_LEFT_X, BOTTOM_RIGHT_Y));
		 quad.insert(new Location("bottom left", BOTTOM_RIGHT_X, BOTTOM_RIGHT_Y));
	}
	


	
	
	/**
	 * Check if point is absent after deletion
	 */
	@Test
	public void testDelete() {
		quad = makeQuadTreeFor(porto);
		
		quad.insert(porto);
		
		quad.delete(porto);
		assertNull(quad.find(porto));
	}
	
	
	/**
	 * Check if a point replaces another in the  same location
	 */
	@Test
	public void testInsertReplace() {
		quad = makeQuadTreeFor(porto);
		
		quad.insert(porto);
		
		Set<Location> near =  quad.findNear(porto.getX(), porto.getY(), SMALL_RADIUS);
		assertEquals(1,near.size());
		assertEquals("Porto",near.iterator().next().name);

		String otherName = "Oporto";
		Location other = new Location(otherName, porto.latitude, porto.longitude);
				
		quad.insertReplace(other);
		
		near =  quad.findNear(porto.getX(), porto.getY(), 1);
		assertEquals(1,near.size());
		assertEquals(otherName,near.iterator().next().name);		
		
	}
	

	
}
