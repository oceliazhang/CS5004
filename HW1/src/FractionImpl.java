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
        return (double) numerator / denominator;  // cast to double
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
        // using cross-multiplication
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
        // using cross-multiplication
        int compThis = this.numerator * other.getDenominator();
        int compOther = other.getNumerator() * this.denominator;
        return Integer.compare(compThis, compOther);

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

    /**
     * Override equals
     */
    @Override
    public boolean equals(Object obj) {
        if (obj.getClass() == this.getClass()){
            return Objects.equals(obj.toString(), this.toString());
        }
        return false;
    }
}