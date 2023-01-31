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

    @Override
    public double distanceFromOrigin() {
        double distance = pow(pow(centerx, 2) + pow(centery, 2), 0.5);  // repetitive
                               // (only the parameters are different, the formula is exactly same)
        return distance;  // repetitive
    }

    @Override
    public double area() {
        return Math.PI * pow(radius, 2);
    }

    @Override
    public double perimeter() {
        return 2 * PI * radius;
    }

    @Override
    public Shape resize(double factor) {
        double newRadius = radius * pow(factor, 0.5);
        return new Circle(centerx, centery, newRadius);
    }

    @Override
    public int compareTo(Shape s) {
        return Double.compare(this.area(), s.area());  // repetitive
    }

}
