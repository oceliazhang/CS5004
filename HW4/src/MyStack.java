import java.util.ArrayList;
import java.util.EmptyStackException;

/**
 * A generic implementation of a stack using an ArrayList as s the concrete representation
 * of the stack's data
 * @param <T> the type of elements stored in the stack
 */
public class MyStack<T> {
  private ArrayList<T> stack;

  /**
   * creates an initially empty MyStack
   */
  public MyStack() {
    stack = new ArrayList<T>();
  }

  /**
   * push() method adds element x to the stack
   * @param x T data type element to add to the stack
   */
  public void push(T x) {
    stack.add(x);
  }

  /**
   * pop() method removes the last element of the stack
   * @return the last element of the stack
   * @throws EmptyStackException if the stack is empty
   */
  public T pop() {
    if (stack.isEmpty()) throw new EmptyStackException();
    return stack.remove(stack.size() - 1);
  }

  /**
   * top() method returns the last element of the stack, without removing it
   * @return the last element of the stack
   * @throws EmptyStackException if the stack is empty
   */
  public T top() {
    if (stack.isEmpty()) throw new EmptyStackException();
    return stack.get(stack.size() - 1);
  }

  /**
   * empty() method returns boolean, indicating whether the stack is empty or not
   * @return true if the stack is empty, false if the stack is not empty
   */
  public boolean empty() {
    return stack.isEmpty();
  }

  /**
   * toString() method returns a string representation of the stack,
   * with each element separated by a single space.
   * @return a string representation of the stack
   */
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("Stack: ");
    for (T x : stack) {
      sb.append(x).append(" ");
    }
    return sb.toString().trim();
  }
}
