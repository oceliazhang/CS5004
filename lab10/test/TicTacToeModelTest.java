import static org.junit.Assert.*;

import org.junit.Test;

/**
 * This test contains all the tests to test method. Since we are testing the interface,
 * Model does not yet exist as concrete classes, the test will not pass.
 * the tests define what behaviors are expected on concrete examples.
 */
public class TicTacToeModelTest {
  // We'll use the unimplemented "model" throughout the test.
  private TicTacToeModel model;

  /**
   * test move() method
   */
  @Test
  public void testMove() {
    model.move(2,2);
    assertEquals(Player.X, model.getMarkAt(2,2));
    model.move(1,2);
    assertEquals(Player.O, model.getMarkAt(1,2));
    model.move(0,2);
    assertEquals(Player.X, model.getMarkAt(0,2));
  }

  /**
   * test move() method with IndexOutOfBoundsException
   * when row or column is out of bound
   */
  @Test (expected = IndexOutOfBoundsException.class)
  public void testMoveOutOfBound() {
    // the range of column and row should be within [0,2]
    model.move(3,3);
  }

  /**
   * test move() method with IllegalStateException
   * when the game is over
   */
  @Test (expected = IllegalStateException.class)
  public void testMoveGameOver() {
    if (model.isGameOver()) {
      model.move(0,0);
    }
  }

  /**
   * test move() method with IllegalStateException
   * when we try to move to an already occupied mark
   */
  @Test (expected = IllegalStateException.class)
  public void testMoveAlreadyOccupied() {
    model.move(1,1);
    model.move(1,1);
  }

  /**
   * test nextPlayer() method with the starting status and afterwards status
   */
  @Test
  public void testNextPlayer() {
    // Test starting player
    assertEquals(Player.X, model.nextPlayer());

    // Test alternating players
    model.move(0, 0);
    assertEquals(Player.O, model.nextPlayer());
    model.move(1, 0);
    assertEquals(Player.X, model.nextPlayer());
  }

  /**
   * test nextPlayer() method with IllegalStateException
   * when the game is over
   */
  @Test (expected = IllegalStateException.class)
  public void testNextPlayerGameOver() {
    if (model.isGameOver()) {
      model.nextPlayer();
    }
  }

  /**
   * test the getMarkAt() method
   */
  @Test
  public void testGetMarkAt() {
    // test when there is a mark
    model.move(0, 0);
    assertEquals(Player.X, model.getMarkAt(0, 0));
    model.move(1, 1);
    assertEquals(Player.O, model.getMarkAt(1, 1));
    model.move(0, 1);
    assertEquals(Player.X, model.getMarkAt(0, 1));
    model.move(0, 2);
    assertEquals(Player.O, model.getMarkAt(0, 2));

    // test when there isn't a mark
    assertNull(model.getMarkAt(1, 2));
    assertNull(model.getMarkAt(2, 2));
    assertNull(model.getMarkAt(1, 0));
  }

  /**
   * test the getMarkAt() method with IndexOutOfBoundsException
   * when the input column or row is out of bound
   */
  @Test (expected = IndexOutOfBoundsException.class)
  public void testGetMarkAtOutOfBound() {
    model.getMarkAt(-1, 3);
  }

  /**
   * test the isGameOver() method with starting status, middle status, and final status
   */
  @Test
  public void testIsGameOver() {
    // at the beginning, the game is not over
    assertFalse(model.isGameOver());

    // in the process of the game, the game is not over
    model.move(0,0);
    model.move(1,0);
    assertFalse(model.isGameOver());

    // at the end of the game, the game is over
    model.move(0,1);
    model.move(2,0);
    model.move(0,2);
    model.move(1,0);
    model.move(0,0);
    assertTrue(model.isGameOver());
  }

  /**
   * test the getWinner() method with IllegalStateException
   * when the game is not over
   */
  @Test (expected = IllegalStateException.class)
  public void testGetWinnerGameNotOver() {
    // raise IllegalStateException when the game is not over yet
    if (!model.isGameOver()) {
      model.getWinner();
    }
  }

  @Test
  public void testGetWinner() {
    // Player X wins the game
    model.move(0,1);
    model.move(2,0);
    model.move(0,2);
    model.move(1,0);
    model.move(0,0);
    assertEquals(Player.X, model.getWinner());

    // Player O wins the game
    model.move(2,1);
    model.move(2,0);
    model.move(0,2);
    model.move(1,0);
    model.move(1,1);
    model.move(0,0);
    assertEquals(Player.O, model.getWinner());

    // No one wins, the game is a tie
    model.move(2,1);
    model.move(2,0);
    model.move(0,2);
    model.move(1,0);
    model.move(1,1);
    model.move(0,1);
    model.move(0,0);
    model.move(2,2);
    model.move(1,2);
    assertNull(model.getWinner());
  }
}