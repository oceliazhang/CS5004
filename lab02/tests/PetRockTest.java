import org.junit.Test;

import static org.junit.Assert.*;

public class PetRockTest {
    // create rocky object for future test
    private PetRock rocky = new PetRock("Rocky");

    /**
     * Test getName() method
     */
    @Test
    public void testGetName() {
        assertEquals("Rocky", rocky.getName());
    }

    /**
     * Test rock is not happy when it's initialized
     */
    @Test
    public void testUnhappyToStart() {
        assertFalse(rocky.isHappy());
    }

    /**
     * Test playWithRock() method
     */
    @Test
    public void testPlayWithRock() {
        rocky.playWithRock();
        assertTrue(rocky.isHappy());
    }

    /**
     * Test getHappyMessage() to get exception
     */
    @Test (expected = IllegalStateException.class)
    public void testGetHappyMessageFalse() {
        rocky.getHappyMessage();
    }

    /**
     * Test getHappyMessage()
     */
    @Test
    public void testGetHappyMessage() {
        rocky.playWithRock();
        String msg = rocky.getHappyMessage();
        assertEquals("I'm happy!", msg);
    }

    /**
     * Test constructor when passing an empty string
     */
    @Test (expected = IllegalArgumentException.class)
    public void testConstructor() {
        new PetRock("");
    }

    /**
     * Test getWeight() method using assertEquals
     */
    @Test
    public void testGetWeightEquals() {
        // assertEquals asserts that two objects are equal.
        // this test will pass.
        assertEquals(50.8, rocky.getWeight(), 1e-15);
    }

//    /**
//     * Test getWeight() method using assertSame
//     */
//    @Test
//    public void testGetWeightSame() {
//        // assertSame asserts that two objects refer to the same object.
//        // this test will fail.
//        assertSame(50.8, rocky.getWeight());
//    }

    /**
     * Test toString() method
     */
    @Test
    public void testToString() {
        assertEquals("Hi, the pet rock Rocky weighs 50.8 grams",
                rocky.toString());
    }
}
