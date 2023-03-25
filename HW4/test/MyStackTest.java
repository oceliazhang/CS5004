import static org.junit.Assert.*;

import java.util.EmptyStackException;
import org.junit.Before;
import org.junit.Test;

/**
 * This class contains all the tests of all the methods in MyStack<T> class
 * with different data types(integer, double, string)
 */
public class MyStackTest {
  // initialize three data types stack
  MyStack<Integer> integerMyStack;
  MyStack<Double> doubleMyStack;
  MyStack<String> stringMyStack;

  /**
   * set up integer/double/string data types stack, all are initialized empty ArrayList
   */
  @Before
  public void setUp() {
    integerMyStack = new MyStack<>();
    doubleMyStack = new MyStack<>();
    stringMyStack = new MyStack<>();
  }

  @Test
  public void testConstructor() {
    assertEquals("Stack:", integerMyStack.toString());
    assertEquals("Stack:", doubleMyStack.toString());
    assertEquals("Stack:", stringMyStack.toString());
  }

  /**
   * test push() method with integer/double/string data types stack
   */
  @Test
  public void testPush() {
    integerMyStack.push(1);
    doubleMyStack.push(0.5);
    stringMyStack.push("a");
    assertEquals("Stack: 1", integerMyStack.toString());
    assertEquals("Stack: 0.5", doubleMyStack.toString());
    assertEquals("Stack: a", stringMyStack.toString());
  }

  /**
   * test pop() method with integer stack
   * throws EmptyStackException when stack is empty
   */
  @Test (expected = EmptyStackException.class)
  public void testPopExceptionInteger() {
    integerMyStack.pop();
  }

  /**
   * test pop() method with double stack
   * throws EmptyStackException when stack is empty
   */
  @Test (expected = EmptyStackException.class)
  public void testPopExceptionDouble() {
    doubleMyStack.pop();
  }

  /**
   * test pop() method with string stack
   * throws EmptyStackException when stack is empty
   */
  @Test (expected = EmptyStackException.class)
  public void testPopExceptionString() {
    stringMyStack.pop();
  }

  /**
   * test pop() method with integer/double/string data types stack
   */
  @Test
  public void testPop() {
    // set up the integer/double/string data types stack
    integerMyStack.push(1);
    doubleMyStack.push(0.5);
    stringMyStack.push("a");

    // test if the popped element is correct
    assertEquals(1, integerMyStack.pop(), 0.01);
    assertEquals(0.5, doubleMyStack.pop(), 0.01);
    assertEquals("a", stringMyStack.pop());

    // test if pop() method removes the element from the arraylist
    assertEquals("Stack:", integerMyStack.toString());
    assertEquals("Stack:", doubleMyStack.toString());
    assertEquals("Stack:", stringMyStack.toString());
  }

  /**
   * test top() method with integer stack
   * throws EmptyStackException when stack is empty
   */
  @Test (expected = EmptyStackException.class)
  public void testTopExceptionInteger() {
    integerMyStack.top();
  }

  /**
   * test top() method with double stack
   * throws EmptyStackException when stack is empty
   */
  @Test (expected = EmptyStackException.class)
  public void testTopExceptionDouble() {
    doubleMyStack.top();
  }

  /**
   * test top() method with string stack
   * throws EmptyStackException when stack is empty
   */
  @Test (expected = EmptyStackException.class)
  public void testTopExceptionString() {
    stringMyStack.top();
  }

  /**
   * test top() method with integer/double/string data types stack
   */
  @Test
  public void testTop() {
    // set up the integer/double/string data types stack
    integerMyStack.push(1);
    doubleMyStack.push(0.5);
    stringMyStack.push("a");

    // test if the topped element is correct
    assertEquals(1, integerMyStack.top(), 0.01);
    assertEquals(0.5, doubleMyStack.top(), 0.01);
    assertEquals("a", stringMyStack.top());

    // test if pop() method doesn't remove the element from the arraylist
    assertEquals("Stack: 1", integerMyStack.toString());
    assertEquals("Stack: 0.5", doubleMyStack.toString());
    assertEquals("Stack: a", stringMyStack.toString());
  }

  /**
   * test empty() method with integer/double/string data types stack
   */
  @Test
  public void testEmpty() {
    // test empty stack returns true
    assertTrue(integerMyStack.empty());
    assertTrue(doubleMyStack.empty());
    assertTrue(stringMyStack.empty());

    // test non-empty stack returns false
    integerMyStack.push(1);
    doubleMyStack.push(0.5);
    stringMyStack.push("a");
    assertFalse(integerMyStack.empty());
    assertFalse(doubleMyStack.empty());
    assertFalse(stringMyStack.empty());
  }

  /**
   * test toString() method with integer/double/string data types stack
   */
  @Test
  public void testToString() {
    // set up the integer/double/string data types stack
    integerMyStack.push(1);
    integerMyStack.push(2);
    integerMyStack.push(3);
    doubleMyStack.push(0.5);
    doubleMyStack.push(1.5);
    doubleMyStack.push(2.5);
    stringMyStack.push("a");
    stringMyStack.push("b");
    stringMyStack.push("c");

    // test if the string representation is correct
    assertEquals("Stack: 1 2 3", integerMyStack.toString());
    assertEquals("Stack: 0.5 1.5 2.5", doubleMyStack.toString());
    assertEquals("Stack: a b c", stringMyStack.toString());
  }
}