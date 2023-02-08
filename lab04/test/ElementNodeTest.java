import org.junit.Test;

import static org.junit.Assert.*;

public class ElementNodeTest {
    private ElementNode myList = new ElementNode(0,
            new ElementNode(1, new ElementNode(2, new EmptyNode())));

    @Test
    public void addAtIndex() {
        assertEquals("0 1 2 3 ", myList.addAtIndex(3,3).toString());
    }

    @Test (expected = IllegalArgumentException.class)
    public void addAtIndexOutOfRange() {
        myList.addAtIndex(3, 4);
    }

    @Test
    public void addFront() {
        assertEquals("3 0 1 2 ", myList.addFront(3).toString());
    }

    @Test
    public void addBack() {
        assertEquals("0 1 2 3 ", myList.addBack(3).toString());
    }

    @Test
    public void getDataAtIndex() {
        assertEquals(1, myList.getDataAtIndex(1));
    }

    @Test (expected = IllegalArgumentException.class)
    public  void getDataAtIndexOutOfRange() {
        myList.getDataAtIndex(3);
    }

    @Test
    public void count() {
        assertEquals(3, myList.count());
    }

    @Test
    public void sum() {
        assertEquals(3, myList.sum());
    }

    @Test
    public void testToString() {
        assertEquals("0 1 2 ", myList.toString());
    }
}