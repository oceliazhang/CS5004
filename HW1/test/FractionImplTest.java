import org.junit.Test;

import static org.junit.Assert.*;

public class FractionImplTest {
    private FractionImpl myFraction =  new FractionImpl(4,8);

    @Test (expected = IllegalArgumentException.class)
    public void testConstructor() {
        FractionImpl wrongFraction = new FractionImpl(2, -3);
    }

    @Test
    public void getNumerator() {
        assertEquals(4, myFraction.getNumerator());
    }

    @Test
    public void getDenominator() {
        assertEquals(8, myFraction.getDenominator());
    }

    @Test
    public void setNumerator() {
        myFraction.setNumerator(-2);
        assertEquals(-2, myFraction.getNumerator());
    }

    @Test (expected = IllegalArgumentException.class)
    public void setDenominatorNegative() {
        myFraction.setDenominator(-1);
    }

    @Test
    public void setDenominator() {
        myFraction.setDenominator(2);
        assertEquals(2, myFraction.getDenominator());
    }

    @Test
    public void toDouble() {
        assertEquals(0.5, myFraction.toDouble(), 0.0001);
    }

    @Test (expected = IllegalArgumentException.class)
    public void reciprocalException() {
        FractionImpl newFractionE = new FractionImpl(0,2);
        newFractionE.reciprocal();
    }

    @Test
    public void reciprocalNegative() {
        FractionImpl fractionNegative = new FractionImpl(-1,2);
        FractionImpl expectFraction =  new FractionImpl(-2,1);
        assertEquals(expectFraction, fractionNegative.reciprocal());
    }

    @Test
    public void reciprocalPositive() {
        FractionImpl expectFractionPositive =  new FractionImpl(8,4);
        assertEquals(expectFractionPositive, myFraction.reciprocal());
    }

    @Test
    public void addNegative() {
        Fraction other = new FractionImpl(-1, 4);
        FractionImpl addResult =  new FractionImpl(2,8);
        assertEquals(addResult, myFraction.add(other));
    }

    @Test
    public void addPositive() {
        Fraction other = new FractionImpl(1, 4);
        FractionImpl addResult =  new FractionImpl(24,32);
        assertEquals(addResult, myFraction.add(other));
    }

    @Test
    public void addTwoNegative() {
        FractionImpl oneNegative = new FractionImpl(-1, 4);
        FractionImpl twoNegative =  new FractionImpl(-2,8);
        FractionImpl addResult = new FractionImpl(-16,32);
        assertEquals(addResult, oneNegative.add(twoNegative));
    }

    @Test
    public void compareToSmall() {
        Fraction another = new FractionImpl(1,4);
        assertEquals(1, myFraction.compareTo(another));
    }

    @Test
    public void compareToSame() {
        Fraction another = new FractionImpl(1,2);
        assertEquals(0, myFraction.compareTo(another));
    }

    @Test
    public void compareToBig() {
        Fraction another = new FractionImpl(1,1);
        assertEquals(-1, myFraction.compareTo(another));
    }

    @Test
    public void gcd() {
        assertEquals(8, FractionImpl.gcd(24, 32));
    }

    @Test
    public void testToString() {
        String msg = "The fraction in simplest form is 1 / 2";
        assertEquals(msg, myFraction.toString());
    }
}
