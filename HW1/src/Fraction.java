public interface Fraction {

    /**
     * Get the numerator of the fraction
     * @return the numerator of the fraction
     */
    int getNumerator();

    /**
     * Get the denominator of the fraction
     * @return the denominator of the fraction
     */
    int getDenominator();

    /**
     * Set the numerator of the fraction
     * @param newNumerator set an integer as the numerator of the fraction
     */
    void setNumerator(int newNumerator);

    /**
     * Set the denominator of the fraction
     * @param newDenominator set a positive integer as the denominator of the fraction
     * @throws IllegalArgumentException if the denominator is not positive
     */
    void setDenominator(int newDenominator) throws IllegalArgumentException;

    /**
     * Returns the scientific value (decimal) of the fraction.
     * @return the scientific value
     */
    double toDouble();

    /**
     * Returns a String depicting the fraction’s value, as a fraction, but in
     * the simplest form. For example, “4 / 2” should be simplified to “2 / 1” etc.
     * @return the simplest form of the fraction
     */
    String toString();

    /**
     * Returns the reciprocal of this fraction.
     * @return the reciprocal of the fraction
     * @throws IllegalArgumentException if the numerator is 0
     */
    Fraction reciprocal() throws IllegalArgumentException;

    /**
     * Adds this fraction to the one passed to it and returns the
     * result as a fraction.
     * @param other another fraction add to this fraction
     * @return the result after adding another fraction
     */
    Fraction add(Fraction other);

    /**
     * Compares two fractions. It returns a negative
     * integer if (this < other), a positive integer if (this > other) and 0 otherwise.
     * @param other another Fraction to compare to this fraction
     * @return the compare result of two fractions (-1 or 0 or 1)
     */
    int compareTo(Fraction other);
}