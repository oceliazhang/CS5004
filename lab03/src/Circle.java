import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class Circle implements Shape {
    private double centerx;
    private double centery;
    private double radius;

    /**
     * Construct a circle object using the given center and radius
     * @param x x coordinate of the center of this circle
     * @param y y coordinate of the center of this circle
     * @param radius the radius of this circle
     */
    public Circle(double x, double y, double radius) {
        this.centerx = x;
        this.centery = y;
        this.radius = radius;
    }

    /**
     * Construct a circle object with the given radius. It is centered at (0,0)
     * @param radius the radius of this circle
     */
    public Circle(double radius) {
        this.centerx = 0;
        this.centery = 0;
        this.radius = radius;
    }

    /**
     * Returns the distance of this shape from the origin.
     * @return the distance from the origin
     */
    @Override
    public double distanceFromOrigin() {
        double distance = pow(pow(centerx, 2) + pow(centery, 2), 0.5);  // repetitive
                               // (only the parameters are different, the formula is exactly same)
        return distance;  // repetitive
    }

    /**
     * Computes and returns the area of this shape.
     * @return the area of the shape
     */
    @Override
    public double area() {
        return Math.PI * pow(radius, 2);
    }

    /**
     * Computes and returns the perimeter of this shape.
     * @return the perimeter of the shape
     */
    @Override
    public double perimeter() {
        return 2 * PI * radius;
    }

    /**
     * Create and return a shape of the same kind as this one, resized
     * in area by the provided factor
     * @param factor factor of resizing
     * @return the resized Shape
     */
    @Override
    public Shape resize(double factor) {
        double newRadius = radius * pow(factor, 0.5);
        return new Circle(centerx, centery, newRadius);
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
