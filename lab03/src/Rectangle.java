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

    @Override
    public double distanceFromOrigin() {
        double distance = pow(pow(x, 2) + pow(y, 2), 0.5);
        return distance;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return (width + height) * 2;
    }

    @Override
    public Shape resize(double factor) {
        double newWidth = width * pow(factor, 0.5);
        double newHeight = height * pow(factor, 0.5);
        return new Rectangle(x, y, newWidth, newHeight);
    }

    @Override
    public int compareTo(Shape s) {
        if (this.area() > s.area()) { return 1; }       // Repetitive
        if (this.area() == s.area()) { return 0; }      // Repetitive
        if (this.area() < s.area()) { return -1; }      // Repetitive

        return 0;
    }
}


