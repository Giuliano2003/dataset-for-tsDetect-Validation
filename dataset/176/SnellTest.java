import junit.framework.TestCase;
import org.junit.Before;

// -------------------------------------------------------------------------
/**
 * memmory manager class test.
 *
 * @author wenfeng ren
 * @version Sep 15, 2014
 */
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
    public void testFindIndex()
    {
        //
        long key = songTable.hash(name1);
        long keyy = songTable.hash(name2);
        assertEquals(0, songTable.findIndex(key));
        songTable.insert(name1, handle1);
        assertEquals(1, songTable.findIndex(key));
        songTable.insert(name2, handle2);
        songTable.remove(name1);
        assertEquals(2, songTable.findIndex(keyy));


    }

    // ----------------------------------------------------------
    /**
     * test insert method.
     */
    @Test
    public void testInsert()
    {
        assertEquals(true, songTable.insert(name1, handle1));
        assertFalse(songTable.rehashNeed(name1));
        assertEquals(true, songTable.insert(name2, handle2));
        assertTrue(songTable.rehashNeed(name3));
        assertEquals(true, songTable.insert(name3, handle2));
        songTable.remove(name3);
        songTable.insert(name3, handle2);
        assertFalse(songTable.rehashNeed(name1));
        assertEquals(false, songTable.insert(name2, handle2));
        assertEquals(3, songTable.usedSize());
    }

}