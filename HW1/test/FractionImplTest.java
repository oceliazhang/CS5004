import org.junit.Test;

import static org.junit.Assert.*;

public class FractionImplTest {
    // create myFraction object for future use of all tests
    private FractionImpl myFraction =  new FractionImpl(4,8);

    /**
     * Test for constructor
     * when we initialize the fraction with the denominator as a negative number,
     * throw an IllegalArgumentException
     */
    @Test (expected = IllegalArgumentException.class)
    public void testConstructor() {
        FractionImpl wrongFraction = new FractionImpl(2, -3);
    }

    /**
     * Test getNumerator() method
     */
    @Test
    public void testGetNumerator() {
        assertEquals(4, myFraction.getNumerator());
    }

    /**
     * Test getDenominator() method
     */
    @Test
    public void testGetDenominator() {
        assertEquals(8, myFraction.getDenominator());
    }

    /**
     * Test setNumerator() method
     */
    @Test
    public void testSetNumerator() {
        myFraction.setNumerator(-2);
        assertEquals(-2, myFraction.getNumerator());
    }

    /**
     * Test setDenominator() method
     * when we set the denominator as a negative number,
     * it throws an IllegalArgumentException
     */
    @Test (expected = IllegalArgumentException.class)
    public void testSetDenominatorNegative() {
        myFraction.setDenominator(-1);
    }

    /**
     * Test setDenominator() method
     */
    @Test
    public void testSetDenominator() {
        myFraction.setDenominator(2);
        assertEquals(2, myFraction.getDenominator());
    }

    /**
     * Test toDouble() method
     */
    @Test
    public void testToDouble() {
        assertEquals(0.5, myFraction.toDouble(), 0.0001);
    }

    /**
     * Test reciprocal() method
     * when we try to get reciprocal from a fraction whose numerator is 0,
     * it throws an IllegalArgumentException
     */
    @Test (expected = IllegalArgumentException.class)
    public void testReciprocalException() {
        FractionImpl newFractionE = new FractionImpl(0,2);
        newFractionE.reciprocal();
    }

    /**
     * Test reciprocal() method with a negative fraction
     */
    @Test
    public void testReciprocalNegative() {
        FractionImpl fractionNegative = new FractionImpl(-1,2);
        FractionImpl expectFraction =  new FractionImpl(-2,1);
        assertEquals(expectFraction, fractionNegative.reciprocal());
    }

    /**
     * Test reciprocal() method with a positive fraction
     */
    @Test
    public void testReciprocalPositive() {
        FractionImpl expectFractionPositive =  new FractionImpl(8,4);
        assertEquals(expectFractionPositive, myFraction.reciprocal());
    }

    /**
     * Test add() method with a negative fraction
     */
    @Test
    public void testAddNegative() {
        Fraction other = new FractionImpl(-1, 4);
        FractionImpl addResult =  new FractionImpl(2,8);
        assertEquals(addResult, myFraction.add(other));
    }

    /**
     * Test add() method with a positive fraction
     */
    @Test
    public void testAddPositive() {
        Fraction other = new FractionImpl(1, 4);
        FractionImpl addResult =  new FractionImpl(24,32);
        assertEquals(addResult, myFraction.add(other));
    }

    /**
     * Test add() method with two negative fractions
     */
    @Test
    public void testAddTwoNegative() {
        FractionImpl oneNegative = new FractionImpl(-1, 4);
        FractionImpl twoNegative =  new FractionImpl(-2,8);
        FractionImpl addResult = new FractionImpl(-16,32);
        assertEquals(addResult, oneNegative.add(twoNegative));
    }

    /**
     * Test compareTo() method with a smaller fraction
     */
    @Test
    public void testCompareToSmall() {
        Fraction another = new FractionImpl(1,4);
        assertEquals(1, myFraction.compareTo(another));
    }

    /**
     * Test compareTo() method with an equal fraction
     */
    @Test
    public void testCompareToSame() {
        Fraction another = new FractionImpl(1,2);
        assertEquals(0, myFraction.compareTo(another));
    }

    /**
     * Test compareTo() method with a larger fraction
     */
    @Test
    public void testCompareToBig() {
        Fraction another = new FractionImpl(1,1);
        assertEquals(-1, myFraction.compareTo(another));
    }

    /**
     * Test the gcd() function to see if it gets the greatest common divisor correctly
     */
    @Test
    public void testGcd() {
        assertEquals(8, FractionImpl.gcd(24, 32));
    }

    /**
     * Test toString()
     */
    @Test
    public void testToString() {
        String msg = "The fraction in simplest form is 1 / 2";
        assertEquals(msg, myFraction.toString());
    }
}
