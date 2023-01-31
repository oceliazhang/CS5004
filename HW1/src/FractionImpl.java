import java.util.HashMap;
import java.util.Objects;

public class FractionImpl implements Fraction {
    private int numerator;
    private int denominator;

    /**
     * Construct a fraction object using the given numerator and denominator
     * @param numerator the numerator of this fraction
     * @param denominator the denominator of this fraction
     */
    public FractionImpl(int numerator, int denominator) {
        if (denominator <= 0) {
            throw new IllegalArgumentException("The denominator should be a positive integer");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    /**
     * Get the numerator of the fraction
     * @return the numerator of the fraction
     */
    @Override
    public int getNumerator() {
        return this.numerator;
    }

    /**
     * Get the denominator of the fraction
     * @return the denominator of the fraction
     */
    @Override
    public int getDenominator() {
        return this.denominator;
    }

    /**
     * Set the numerator of the fraction
     * @param newNumerator set an integer as the numerator of the fraction
     */
    @Override
    public void setNumerator(int newNumerator) {
        this.numerator = newNumerator;
    }

    /**
     * Set the denominator of the fraction
     * @param newDenominator set a positive integer as the denominator of the fraction
     * @throws IllegalArgumentException if the denominator is not positive
     */
    @Override
    public void setDenominator(int newDenominator) throws IllegalArgumentException {
        if (newDenominator <= 0) {
            throw new IllegalArgumentException("The denominator should be a positive integer");
        }
        this.denominator = newDenominator;
    }

    /**
     * Returns the scientific value (decimal) of the fraction.
     * @return the scientific value
     */
    @Override
    public double toDouble() {
        double result = (double) numerator / denominator;
        return result;
    }

    /**
     * Returns the reciprocal of this fraction.
     * @return the reciprocal of the fraction
     * @throws IllegalArgumentException if the numerator is 0
     */
    @Override
    public Fraction reciprocal() throws IllegalArgumentException {
        if (this.numerator == 0) {
            throw new IllegalArgumentException("Cannot return reciprocal when numerator is 0");
        }
        else if (this.numerator > 0) {
            return new FractionImpl(this.denominator, this.numerator);
        }
        else {
            return new FractionImpl(this.denominator * (-1), this.numerator * (-1));
        }
    }

    /**
     * Adds this fraction to the one passed to it and returns the
     * result as a fraction.
     * @param other another fraction add to this fraction
     * @return the result after adding another fraction
     */
    @Override
    public Fraction add(Fraction other) {
        int sumDenominator = this.denominator * other.getDenominator();
        int sumNumerator = this.numerator * other.getDenominator()
                           + other.getNumerator() * this.denominator;
        return new FractionImpl(sumNumerator, sumDenominator);
    }

    /**
     * Compares two fractions. It returns a negative
     * integer if (this < other), a positive integer if (this > other) and 0 otherwise.
     * @param other another Fraction to compare to this fraction
     * @return the compare result of two fractions (-1 or 0 or 1)
     */
    @Override
    public int compareTo(Fraction other) {
        int compThis = this.numerator * other.getDenominator();
        int compOther = other.getNumerator() * this.denominator;
        if (compThis > compOther) {
            return 1;
        } else if (compThis < compOther) {
            return -1;
        }
        else {
            return 0;
        }

    }

    /**
     * Finds the greatest common divisor of two integers
     * @param a integer
     * @param b integer
     * @return the greatest common divisor of integer a and b
     */
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * Returns a String depicting the fraction’s value, as a fraction, but in
     * simplest form
     * @return the simplest form of the fraction
     */
    @Override
    public String toString() {
        // get the greatest common divisor of numerator and denominator
        int gcd = gcd(numerator, denominator);
        return "The fraction in simplest form is "
                + (numerator / gcd) + " / " + (denominator / gcd);
    }

    public static void main(String[] args) {
        FractionImpl myFraction = new FractionImpl(4,8);
        System.out.println(myFraction.toDouble());
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * <p>
     * The {@code equals} method implements an equivalence relation
     * on non-null object references:
     * <ul>
     * <li>It is <i>reflexive</i>: for any non-null reference value
     *     {@code x}, {@code x.equals(x)} should return
     *     {@code true}.
     * <li>It is <i>symmetric</i>: for any non-null reference values
     *     {@code x} and {@code y}, {@code x.equals(y)}
     *     should return {@code true} if and only if
     *     {@code y.equals(x)} returns {@code true}.
     * <li>It is <i>transitive</i>: for any non-null reference values
     *     {@code x}, {@code y}, and {@code z}, if
     *     {@code x.equals(y)} returns {@code true} and
     *     {@code y.equals(z)} returns {@code true}, then
     *     {@code x.equals(z)} should return {@code true}.
     * <li>It is <i>consistent</i>: for any non-null reference values
     *     {@code x} and {@code y}, multiple invocations of
     *     {@code x.equals(y)} consistently return {@code true}
     *     or consistently return {@code false}, provided no
     *     information used in {@code equals} comparisons on the
     *     objects is modified.
     * <li>For any non-null reference value {@code x},
     *     {@code x.equals(null)} should return {@code false}.
     * </ul>
     *
     * <p>
     * An equivalence relation partitions the elements it operates on
     * into <i>equivalence classes</i>; all the members of an
     * equivalence class are equal to each other. Members of an
     * equivalence class are substitutable for each other, at least
     * for some purposes.
     *
     * @param obj the reference object with which to compare.
     * @return {@code true} if this object is the same as the obj
     * argument; {@code false} otherwise.
     * @implSpec The {@code equals} method for class {@code Object} implements
     * the most discriminating possible equivalence relation on objects;
     * that is, for any non-null reference values {@code x} and
     * {@code y}, this method returns {@code true} if and only
     * if {@code x} and {@code y} refer to the same object
     * ({@code x == y} has the value {@code true}).
     * <p>
     * In other words, under the reference equality equivalence
     * relation, each equivalence class only has a single element.
     * @apiNote It is generally necessary to override the {@link #hashCode() hashCode}
     * method whenever this method is overridden, so as to maintain the
     * general contract for the {@code hashCode} method, which states
     * that equal objects must have equal hash codes.
     * @see #hashCode()
     * @see HashMap
     */
    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == this.getClass()){
            return Objects.equals(obj.toString(), this.toString());
        }
        return false;
    }
}


