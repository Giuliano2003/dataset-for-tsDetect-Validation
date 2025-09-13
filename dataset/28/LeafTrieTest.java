package rsa.quad;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Test on a LeafTrie, the leaves of a quadtree
 * Test the implemented methods from the abstract
 * type {@code Trie} 
 * 
 * @author Jos&eacute; paulo Leal {@code zp@dcc.fc.up.pt}
 */
public class LeafTrieTest {
	
	private static int CAPACITY = 10;
	
	private static final int BOTTOM_RIGHT_Y = 10;
	private static final int BOTTOM_RIGHT_X = 20;
	private static final int TOP_LEFT_Y = 20;
	private static final int TOP_LEFT_X = 10;
	
	private static final int CENTER_X = (TOP_LEFT_X + BOTTOM_RIGHT_X)/2;
	private static final int CENTER_Y = (TOP_LEFT_Y + BOTTOM_RIGHT_Y)/2;
	
	private static final int LARGE_RADIUS = 100;
	private static final int SMALL_RADIUS = 1;
	
	private static final Location CENTER = new Location("", CENTER_X, CENTER_Y);
		
	LeafTrie<Location> leaf;
	Set<Location> points;
	
	@BeforeClass
	public static void init() {
		Trie.setCapacity(CAPACITY);
	}
	
	/**
	 * Create a leaf and a set for collecting points
	 */
	@Before
	public void setUp() {
		leaf = new LeafTrie<Location>(TOP_LEFT_X,TOP_LEFT_Y,BOTTOM_RIGHT_X,BOTTOM_RIGHT_Y);
		points = new HashSet<>();
	}
	
	/**
	 * No points before insertion, either with collect or find
	 */
	@Test
	public void testEmptyOnCreation() {
		leaf.collectNear(TOP_LEFT_X, TOP_LEFT_Y, LARGE_RADIUS, points);
		assertEquals(0,points.size());
		
		assertNull(leaf.find(CENTER));
	}
	
	/**
	 * Test a single location using insertion and find
	 */
	@Test  
	public void testInsertAndFind() {
		leaf.insert(CENTER);
		
		assertEquals(CENTER,leaf.find(CENTER));
	}
	
	
	
	/**
	 * Check that locations aren't there after delete
	 */
	@Test
	public void testDelete() {
		leaf.insert(CENTER);
		assertEquals(CENTER,leaf.find(CENTER));
		
		leaf.delete(CENTER);
		assertNull(leaf.find(CENTER));
	}
	
	/**
	 * Check delete of non existing point
	 */
	@Test
	public void testDeleteMissingPoint() {
		
		leaf.delete(CENTER);
		assertNull(leaf.find(CENTER));
	}
	

}