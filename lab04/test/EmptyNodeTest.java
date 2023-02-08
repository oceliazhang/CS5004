import org.junit.Test;

import static org.junit.Assert.*;

public class EmptyNodeTest {
    private EmptyNode myList = new EmptyNode();

    @Test (expected = IllegalArgumentException.class)
    public void addAtIndexFault() {
        myList.addAtIndex(2, 2);
    }

    @Test
    public void addAtIndex() {
        assertEquals("0 ", myList.addAtIndex(0, 0).toString());
    }

    @Test
    public void addFront() {
        assertEquals("1 ", myList.addFront(1).toString());
    }

    @Test
    public void addBack() {
        assertEquals("2 ", myList.addBack(2).toString());
    }

    @Test (expected = IllegalArgumentException.class)
    public void getDataAtIndex() {
        myList.getDataAtIndex(0);
    }

    @Test
    public void count() {
        assertEquals(0, myList.count());
    }

    @Test
    public void sum() {
        assertEquals(0, myList.sum());
    }

    @Test
    public void testToString() {
        assertEquals("", myList.toString());
    }
}