import org.junit.Test;

import static org.junit.Assert.*;

public class ElementNodeTest {
    // create a new list "0 1 2 " for future tests
    private ElementNode myList = new ElementNode(0,
            new ElementNode(1, new ElementNode(2, new EmptyNode())));

    /**
     * Test addAtIndex() method
     */
    @Test
    public void testAddAtIndex() {
        assertEquals("0 1 2 3 ", myList.addAtIndex(3,3).toString());
    }

    /**
     * Test addAtIndex() method, when index out of range, throws exception
     */
    @Test (expected = IllegalArgumentException.class)
    public void testAddAtIndexOutOfRange() {
        myList.addAtIndex(3, 4);
    }

    /**
     * Test addFront() method
     */
    @Test
    public void testAddFront() {
        assertEquals("3 0 1 2 ", myList.addFront(3).toString());
    }

    /**
     * Test addBack() method
     */
    @Test
    public void testAddBack() {
        assertEquals("0 1 2 3 ", myList.addBack(3).toString());
    }

    /**
     * Test getDataAtIndex() method
     */
    @Test
    public void testGetDataAtIndex() {
        assertEquals(1, myList.getDataAtIndex(1));
    }

    /**
     * Test getDataAtIndex() method, when index out of range, throws exception
     */
    @Test (expected = IllegalArgumentException.class)
    public  void testGetDataAtIndexOutOfRange() {
        myList.getDataAtIndex(3);
    }

    /**
     * Test count() method
     */
    @Test
    public void testCount() {
        assertEquals(3, myList.count());
    }

    /**
     * Test sum() method
     */
    @Test
    public void testSum() {
        assertEquals(3, myList.sum());
    }

    /**
     * Test toString() method
     */
    @Test
    public void testToString() {
        assertEquals("0 1 2 ", myList.toString());
    }
}