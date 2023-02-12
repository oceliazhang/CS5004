import static java.lang.Math.pow;

public class Rectangle implements Shape {
    private double width, height;
    private double x, y;

    /**
     * Constructs a rectangle object with the given location of its lower-left
     * corner and dimensions
     * @param x x coordinate of the lower-left corner of this rectangle
     * @param y y coordinate of the lower-left corner of this rectangle
     * @param width width of this rectangle
     * @param height height of this rectangle
     */
    public Rectangle(double x, double y, double width, double height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    /**
     * Returns the distance of this shape from the origin.
     * @return the distance from the origin
     */
    @Override
    public double distanceFromOrigin() {
        double distance = pow(pow(x, 2) + pow(y, 2), 0.5);  // repetitive
                               // (only the parameters are different, the formula is exactly same)
        return distance;  // repetitive
    }

    /**
     * Computes and returns the area of this shape.
     * @return the area of the shape
     */
    @Override
    public double area() {
        return width * height;
    }

    /**
     * Computes and returns the perimeter of this shape.
     * @return the perimeter of the shape
     */
    @Override
    public double perimeter() {
        return (width + height) * 2;
    }

    /**
     * Create and return a shape of the same kind as this one, resized
     * in area by the provided factor
     * @param factor factor of resizing
     * @return the resized Shape
     */
    @Override
    public Shape resize(double factor) {
        double newWidth = width * pow(factor, 0.5);
        double newHeight = height * pow(factor, 0.5);
        return new Rectangle(x, y, newWidth, newHeight);
    }

    /**
     * Compares this shape with the one passed to it based on their areas.
     * if (this<s) return a negative number
     * if (this==s) return 0
     * if (this>s) return a positive number
     * @param s the other shape to be compared to
     * @return the result of the comparison
     */
    @Override
    public int compareTo(Shape s) {
        return Double.compare(this.area(), s.area());  // repetitive
    }

}


