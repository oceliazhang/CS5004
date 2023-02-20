public class Triangle extends AbstractShape{

  public Triangle(Point2D reference, Point2D point2, Point2D point3) {
    super(reference);
    if (reference.equals(point2) || reference.equals(point3) ||
        point2.equals(point3)) {
      throw new IllegalArgumentException("Points should be unique");
    }
  }

  /**
   * Computes and returns the area of this shape.
   *
   * @return the area of the shape
   */
  @Override
  public double area() {
    return 0;
  }

  /**
   * Computes and returns the perimeter of this shape.
   *
   * @return the perimeter of the shape
   */
  @Override
  public double perimeter() {
    return 0;
  }

  /**
   * Create and return a shape of the same kind as this one, resized in area by the provided factor
   *
   * @param factor factor of resizing
   * @return the resized Shape
   */
  @Override
  public Shape resize(double factor) {
    return null;
  }
}
