public class Triangle extends AbstractShape{
  private Point2D point2, point3;

  /**
   * Constructs a triangle with three points
   * @param reference the reference point
   * @param point2 a point
   * @param point3 a point
   * @throws IllegalArgumentException when points are the same
   */
  public Triangle(Point2D reference, Point2D point2, Point2D point3) {
    super(reference);
    this.point2 = point2;
    this.point3 = point3;
    if (reference.equals(point2) || reference.equals(point3) ||
        point2.equals(point3)) {
      throw new IllegalArgumentException("Points should be unique");
    }
  }

  /**
   * Check if three points are collinear
   * @return true if collinear, false if not
   */
  public boolean isCollinear() {
    return (this.reference.getX() == point2.getX() && point2.getX() == point3.getX())
        || (this.reference.getY() == point2.getY() && point2.getY() == point3.getY());
  }

  /**
   * Computes and returns the area of this shape.
   *
   * @return the area of the shape
   */
  @Override
  public double area() {
    if (this.isCollinear()) {
      return 0;
    }

    // compute the area of a triangle based on the x and y of its three points
    return 0.5 * Math.abs(reference.getX() * (point2.getY() - point3.getY())
    + point2.getX() * (point3.getY() - reference.getY())
        + point3.getX() * (reference.getY() - point2.getY()));
  }

  /**
   * Computes and returns the perimeter of this shape.
   *
   * @return the perimeter of the shape
   */
  @Override
  public double perimeter() {
    double sideA = Math.sqrt(Math.pow((reference.getX() - point2.getX()), 2)
        + Math.pow((reference.getY() - point2.getY()), 2));
    double sideB = Math.sqrt(Math.pow((point3.getX() - point2.getX()), 2)
        + Math.pow((point3.getY() - point2.getY()), 2));
    double sideC = Math.sqrt(Math.pow((reference.getX() - point3.getX()), 2)
        + Math.pow((reference.getY() - point3.getY()), 2));

    return sideA + sideB + sideC;
  }

  /**
   * Create and return a shape of the same kind as this one, resized in area by the provided factor
   *
   * @param factor factor of resizing
   * @return the resized Shape
   */
  @Override
  public Shape resize(double factor) {
    double sqrtFactor = Math.sqrt(factor);
    double newX2 = reference.getX() + sqrtFactor * (reference.getX() - point2.getX());
    double newY2 = reference.getY() + sqrtFactor * (reference.getY() - point2.getY());
    double newX3 = reference.getX() + sqrtFactor * (reference.getX() - point3.getX());
    double newY3 = reference.getY() + sqrtFactor * (reference.getY() - point3.getY());
    Point2D newPoint2 = new Point2D(newX2, newY2);
    Point2D newPoint3 = new Point2D(newX3, newY3);
    return new Triangle(this.reference, newPoint2, newPoint3);
  }

  /**
   * toString() method of the triangle
   * @return the position of the three points of the triangle
   */
  @Override
  public String toString() {
    return String.format("Triangle: reference (%.3f,%.3f) point2 (%.3f,%.3f) point3 (%.3f,%.3f)",
        this.reference.getX(),this.reference.getY(),
        this.point2.getX(),this.point2.getY(),
        this.point3.getX(),this.point3.getY());
  }
}
