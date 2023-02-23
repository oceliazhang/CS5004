/**
 * Created by ashesh on 1/26/2017.
 */
public abstract class AbstractShape implements Shape {
  protected Point2D reference;

  /**
   * Constructs an abstract shape with a point as reference
   * @param reference a point
   */
  public AbstractShape(Point2D reference) {
    this.reference = reference;
  }

  /**
   * Calculate its distance from the origin
   * @return the distance from the origin
   */
  @Override
  public double distanceFromOrigin() {
    return reference.distToOrigin();
  }

  /**
   * Compare with another shape based on the area
   * @param s the object to be compared.
   * @return 1 if this is bigger, 0 if they are the same, -1 if this is smaller
   */
  @Override
  public int compareTo(Shape s) {
    double areaThis = this.area();
    double areaOther = s.area();

    if (areaThis < areaOther) {
      return -1;
    } else if (areaOther < areaThis) {
      return 1;
    } else {
      return 0;
    }
  }

  /*
  Question 3:
  We should modify the compareTo(Shape) method in AbstractShape file as follows:

  @Override
  public int compareTo(Shape s) {
    double perimeterThis = this.perimeter();
    double perimeterOther = s.perimeter();

    if (perimeterThis < perimeterOther) {
      return -1;
    } else if (perimeterOther < perimeterThis) {
      return 1;
    } else {
      return 0;
    }
  }

  If it were not for sharing code via AbstractShape.java, we will have to modify the method in all
  the three files having concrete shapes (Circle.java, Rectangle.java, Triangle.java)
   */
}