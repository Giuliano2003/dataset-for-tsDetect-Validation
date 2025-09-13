import junit.framework.TestCase;
import org.junit.Before;

// -------------------------------------------------------------------------
/**
 * memmory manager class test.
 *
 * @author wenfeng ren
 * @version Sep 15, 2014
 */

/* https://github.com/ivenree/Memory_Management/blob/740f82864453645e523a73eeff11640a74b5a058/HashtableTest.java*/

public class HashtableTest
    extends TestCase
{
    private Hashtable songTable;
    private MemManager mem;
    /**
     *
     */
    private String name1 = "Long Lonesome Blues";
    /**
     *
     */
    private String name2 = "Ma Rainey's Black Bottom";
    /**
     *
     */
    private String name3 = "Mississippi Boweavil Blues";
    /**
     *
     */
    private Handle handle1 = new Handle(1);
    private Handle handle2 = new Handle(2);

    @Before
    public void setUp()
        throws Exception
    {
        // initialize
        songTable = new Hashtable(5);
        mem = new MemManager(10);
    }


    @Test
    public void testRemove()
    {
        songTable.insert(name1, handle1);
        songTable.insert(name2, handle2);
        songTable.insert(name3, handle2);
        songTable.remove(name3);
        songTable.remove(name2);
        assertEquals(1, songTable.usedSize());
    }

    // ----------------------------------------------------------
    /**
     * test search method.
     */
    @Test
    public void testSearch()
    {
        long key = songTable.hash(name2);
        long keyy = songTable.hash(name3);
        assertEquals(false, songTable.search(key));
        songTable.insert(name1, handle1);
        songTable.insert(name2, handle2);
        assertEquals(true, songTable.search(key));
        songTable.insert(name3, handle2);
        assertEquals(true, songTable.search(keyy));

    }

    // ----------------------------------------------------------
    /**
     * test get method.
     */
    @Test
    public void testGet()
    {
        long key = songTable.hash(name2);
        long keyy = songTable.hash(name3);
        songTable.insert(name1, handle1);
        songTable.insert(name2, handle2);
        songTable.insert(name3, handle2);
        assertEquals(6, songTable.get(key));
        assertEquals(2, songTable.get(keyy));

    }

}