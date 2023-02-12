import org.junit.Test;

import static org.junit.Assert.*;

public class EmptyNodeTest {
    // create an empty list for future tests
    private EmptyNode myList = new EmptyNode();

    /**
     * Test addAtIndex() method, when index out of range, throws exception
     */
    @Test (expected = IllegalArgumentException.class)
    public void testAddAtIndexFault() {
        myList.addAtIndex(2, 2);
    }

    /**
     * Test addAtIndex() method
     */
    @Test
    public void testAddAtIndex() {
        assertEquals("0 ", myList.addAtIndex(0, 0).toString());
    }

    /**
     * Test addFront() method
     */
    @Test
    public void testAddFront() {
        assertEquals("1 ", myList.addFront(1).toString());
    }

    /**
     * Test addBack() method
     */
    @Test
    public void testAddBack() {
        assertEquals("2 ", myList.addBack(2).toString());
    }

    /**
     * Test getDataAtIndex() method, when index out of range, throws exception
     */
    @Test (expected = IllegalArgumentException.class)
    public void testGetDataAtIndex() {
        myList.getDataAtIndex(0);
    }

    /**
     * Test count() method
     */
    @Test
    public void testCount() {
        assertEquals(0, myList.count());
    }

    /**
     * Test sum() method
     */
    @Test
    public void testSum() {
        assertEquals(0, myList.sum());
    }

    /**
     * Test toString() method
     */
    @Test
    public void testToString() {
        assertEquals("", myList.toString());
    }
}