public interface Shape {

    /**
     * Returns the distance of this shape from the origin. The distance is
     * measured from whatever reference position a shape is (e.g. a center for
     * a circle)
     * @return the distance from the origin
     */
    double distanceFromOrigin();

    /**
     * Computes and returns the area of this shape.
     * @return the area of the shape
     */
    double area();

    /**
     * Computes and returns the perimeter of this shape.
     * @return the perimeter of the shape
     */
    double perimeter();

    /**
     * Create and return a shape of the same kind as this one, resized
     * in area by the provided factor
     * @param factor factor of resizing
     * @return the resized Shape
     */
    Shape resize(double factor);

    /**
     * Compares this shape with the one passed to it based on their areas.
     * if (this<s) return a negative number
     * if (this==s) return 0
     * if (this>s) return a positive number
     * @param s the other shape to be compared to
     * @return the result of the comparison
     */
    int compareTo(Shape s);
}