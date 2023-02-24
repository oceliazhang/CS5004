import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * This class contains all the unit tests for various kinds of shapes
 */
public class ShapeTest {

  Shape circle1,circle2,circle3,rect1,rect2,tri1,tri2;

  @Before
  public void setup() {
    circle1 = new Circle(3,4,5);
    circle2 = new Circle(10.32,10.43,10);
    circle3 = new Circle(20);

    rect1 = new Rectangle(5,6,2.5,2);
    rect2 = new Rectangle(2,3,10,10);

    tri1 = new Triangle(new Point2D(1,1), new Point2D(2,2), new Point2D(1,3));
    tri2 = new Triangle(new Point2D(2.5,2.5), new Point2D(0,5), new Point2D(4,9));
  }

  /**
   * Tests whether objects have been created with the correct numbers or not.
   * It does this by using their toString methods
   */
  @Test
  public void testObjectData() {
    assertEquals("Circle: center (3.000,4.000) radius 5.000",circle1.toString
            ());
    assertEquals("Circle: center (10.320,10.430) radius 10.000",circle2.toString
            ());
    assertEquals("Circle: center (0.000,0.000) radius 20.000",circle3
            .toString
            ());
    assertEquals("Rectangle: LL corner (5.000,6.000) width 2.500 height 2.000",
            rect1.toString());
    assertEquals("Rectangle: LL corner (2.000,3.000) width 10.000 height 10" +
            ".000",rect2
            .toString());
    assertEquals("Triangle: reference (1.000,1.000) point2 (2.000,2.000) "
        + "point3 (1.000,3.000)",tri1.toString());
    assertEquals("Triangle: reference (2.500,2.500) point2 (0.000,5.000) "
        + "point3 (4.000,9.000)",tri2.toString());
  }

  /**
   * Tests whether the area methods work correctly for all shapes
   */
  @Test
  public void testArea() {
    assertEquals(Math.PI*25,circle1.area(),0.001);
    assertEquals(Math.PI*100,circle2.area(),0.001);
    assertEquals(Math.PI*400,circle3.area(),0.001);
    assertEquals(5,rect1.area(),0.001);
    assertEquals(100,rect2.area(),0.001);
    assertEquals(1,tri1.area(),0.001);
    assertEquals(10,tri2.area(),0.001);
  }

  /**
   * Tests whether the perimeter methods work correctly for all shapes
   */
  @Test
  public void testPerimeter() {
    assertEquals(2*Math.PI*5,circle1.perimeter(),0.001);
    assertEquals(2*Math.PI*10,circle2.perimeter(),0.001);
    assertEquals(2*Math.PI*20,circle3.perimeter(),0.001);
    assertEquals(9,rect1.perimeter(),0.001);
    assertEquals(40,rect2.perimeter(),0.001);
    assertEquals(4.828,tri1.perimeter(),0.001);
    assertEquals(15.8631,tri2.perimeter(),0.001);
  }

  /**
   * Tests whether the resize methods work correctly for all shapes
   */
  @Test
  public void testResizes() {
    Shape resizedCircle1,resizedCircle2,resizedCircle3,resizedRect1,
            resizedRect2,resizedTri1,resizedTri2;

    resizedCircle1 = circle1.resize(2.5);
    resizedCircle2 = circle2.resize(0);
    resizedCircle3 = circle3.resize(10);
    resizedRect1 = rect1.resize(12.5);
    resizedRect2 = rect2.resize(0.001);
    resizedTri1 = tri1.resize(4);
    resizedTri2 = tri2.resize(121);

    assertEquals(2.5*circle1.area(),resizedCircle1.area(),0.001);
    assertEquals(0*circle2.area(),resizedCircle2.area(),0.001);
    assertEquals(10*circle3.area(),resizedCircle3.area(),0.001);
    assertEquals(12.5*rect1.area(),resizedRect1.area(),0.001);
    assertEquals(0.001*rect2.area(),resizedRect2.area(),0.001);
    assertEquals(4*tri1.area(),resizedTri1.area(),0.001);
    assertEquals(121*tri2.area(),resizedTri2.area(),0.001);
  }

  /**
   * test triangle's resize method
   * when factor == 0, throw IllegalArgumentException
   */
  @Test (expected = IllegalArgumentException.class)
  public void testTriResizeZero() {
    tri1.resize(0);
  }

  /**
   * test triangle's resize method
   * when factor is negative, throw IllegalArgumentException
   */
  @Test (expected = IllegalArgumentException.class)
  public void testTriResizeNegative() {
    tri1.resize(-1);
  }

  /**
   * test Point2D distToOrigin method
   */
  @Test
  public void testPoint2DDistToOrigin() {
    assertEquals(7.8102, rect1.distanceFromOrigin(), 0.001);
    assertEquals(5, circle1.distanceFromOrigin(), 0.001);
    assertEquals(1.4142, tri1.distanceFromOrigin(), 0.001);
  }

  /**
   * test Point2D getX method
   */
  @Test
  public void testPoint2DGetX() {
    Point2D newPoint1 = new Point2D(2,3);
    Point2D newPoint2 = new Point2D(0,-1.5);
    assertEquals(2, newPoint1.getX(), 0.001);
    assertEquals(0, newPoint2.getX(), 0.001);
  }

  /**
   * test Point2D getY method
   */
  @Test
  public void testPoint2DGetY() {
    Point2D newPoint1 = new Point2D(2,3);
    Point2D newPoint2 = new Point2D(0,-1.5);
    assertEquals(3, newPoint1.getY(), 0.001);
    assertEquals(-1.5, newPoint2.getY(), 0.001);
  }

  /**
   * test Point2D equals method
   */
  @Test
  public void testPoint2DEquals() {
    Point2D newPoint1 = new Point2D(2,3);
    Point2D newPoint2 = new Point2D(2,3);
    Point2D newPoint3 = new Point2D(2,3);
    Point2D newPoint4 = new Point2D(1,3);
    assertTrue(newPoint1.equals(newPoint2));
    assertTrue(newPoint2.equals(newPoint3));
    assertFalse(newPoint4.equals(newPoint2));

  }

  /**
   * test the constructor of the triangle,
   * it throws an IllegalArgumentException when points are not unique
   */
  @Test (expected = IllegalArgumentException.class)
  public void testTriangleConstructor() {
    Triangle triSamePoint = new Triangle(new Point2D(0,0),
        new Point2D(0,0), new Point2D(1,1));
  }

  /**
   * test isCollinear method
   */
  @Test
  public void testIsCollinear() {
    Triangle triCollinear1 = new Triangle(new Point2D(0,0),
        new Point2D(0,1), new Point2D(0,4));
    Triangle triCollinear2 = new Triangle(new Point2D(1,0),
        new Point2D(1,1), new Point2D(1,-5));
    Triangle triCollinear3 = new Triangle(new Point2D(0,0),
        new Point2D(1,1), new Point2D(2,2));

    assertTrue(triCollinear1.isCollinear());
    assertTrue(triCollinear2.isCollinear());
    assertTrue(triCollinear3.isCollinear());

  }

  /**
   * test Triangle area method when it's collinear
   */
  @Test
  public void testTriangleCollinear() {
    Triangle triCollinear1 = new Triangle(new Point2D(0,0),
        new Point2D(0,1), new Point2D(0,4));
    Triangle triCollinear2 = new Triangle(new Point2D(1,0),
        new Point2D(1,1), new Point2D(1,-5));
    Triangle triCollinear3 = new Triangle(new Point2D(0,0),
        new Point2D(1,1), new Point2D(2,2));

    assertEquals(0, triCollinear1.area(), 0.001);
    assertEquals(0, triCollinear2.area(), 0.001);
    assertEquals(0, triCollinear3.area(), 0.001);
  }

  /**
   * test Triangle compareTo method (smaller, greater, equal cases)
   */
  @Test
  public void testTriangleCompareTo() {
    Triangle tri3 = new Triangle(new Point2D(2,0),new Point2D(2,2),new Point2D(1,3));
    Triangle tri4 = new Triangle(new Point2D(0,0),new Point2D(1,0),new Point2D(1,1));

    assertEquals(-1, tri1.compareTo(tri2));
    assertEquals(0, tri1.compareTo(tri3));
    assertEquals(1, tri1.compareTo(tri4));
  }

  /**
   * test PerimComparator and its difference with compareTo method
   */
  @Test
  public void testPerimComparator() {
    PerimComparator perimComparator = new PerimComparator();

    Triangle tri3 = new Triangle(new Point2D(2,0),new Point2D(2,2),new Point2D(1,3));
    Triangle tri4 = new Triangle(new Point2D(2,0),new Point2D(1,1),new Point2D(2,2));
    Rectangle rect3 = new Rectangle(0,0,4,1);
    Rectangle rect4 = new Rectangle(0,0,1,4);
    Circle circle3 = new Circle(0,0,5);

    // compare the perimeter of rectangles
    assertEquals(-1, perimComparator.compare(tri1,tri3));
    assertEquals(0,perimComparator.compare(tri1,tri4));
    assertEquals(1,perimComparator.compare(tri2,tri1));

    // compare the perimeter of rectangles
    assertEquals(-1, perimComparator.compare(rect1,rect3));
    assertEquals(0, perimComparator.compare(rect4,rect3));
    assertEquals(1, perimComparator.compare(rect2,rect3));

    // compare the perimeter of circles
    assertEquals(-1, perimComparator.compare(circle1,circle2));
    assertEquals(0, perimComparator.compare(circle1,circle3));
    assertEquals(1, perimComparator.compare(circle2,circle3));

  }

}