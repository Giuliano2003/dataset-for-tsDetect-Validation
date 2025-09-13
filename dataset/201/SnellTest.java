import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BSTTest {
    private BST<String, String> bst;

    @Before
    public void setUp() {
        bst = new BST<>();
    }

    @Test
    public void testIsEmptyAfterAddRemove() {
        bst.put("key1", "value1");
        assertFalse(bst.isEmpty());
        bst.remove("key1");
        assertTrue(bst.isEmpty());
    }
}