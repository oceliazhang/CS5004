import org.junit.Test;

import static org.junit.Assert.*;

public class PetRockTest {
    private PetRock rocky = new PetRock("Rocky");

    @Test
    public void getName() {
        assertEquals("Rocky", rocky.getName());
    }

    @Test
    public void testUnhappyToStart() {
        assertFalse(rocky.isHappy());
    }

    @Test
    public void testHappyAfterPlay() {
        rocky.playWithRock();
        assertTrue(rocky.isHappy());
    }

    @Test (expected = IllegalStateException.class)
     public void nameFail() {
        rocky.getHappyMessage();
    }

    @Test
    public void name() {
        rocky.playWithRock();
        String msg = rocky.getHappyMessage();
        assertEquals("I'm happy!", msg);
    }

    @Test (expected = IllegalArgumentException.class)
    public void nameEmpty() {
        new PetRock("");
    }

    @Test
    public void getWeightEquals() {
        // assertEquals asserts that two objects are equal.
        // this test will pass.
        assertEquals(50.8, rocky.getWeight(), 1e-15);
    }

    @Test
    public void getWeightSame() {
        // assertSame asserts that two objects refer to the same object.
        // this test will fail.
        assertSame(50.8, rocky.getWeight());
    }

    @Test
    public void testToString() {
        assertEquals("Hi, the pet rock Rocky weighs 50.8 grams",
                      rocky.toString());
    }
}
