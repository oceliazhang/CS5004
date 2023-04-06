/**
 * The TicTacToeModel interface represents the model of a Tic-Tac-Toe game.
 * It provides five methods allowing two players to play the game
 * The controller team can represent the board, make moves, get game status,
 * determine next player and winner through this model.
 */
public interface TicTacToeModel {
  /**
   * Places an X or O mark in the specified cell. Whether it places an X
   * or O depends on which player's turn it is.
   *
   * @param column the column of the cell
   * @param row    the row of the cell
   * @throws IllegalStateException if the game is over, or if there is
   * already a mark in the cell.
   * @throws IndexOutOfBoundsException if the cell is out of bounds.
   */
  void move(int column, int row) throws IllegalStateException, IndexOutOfBoundsException;

  /**
   * Returns the player whose turn is next.
   *
   * @return the next player (of data type Player)
   * @throws IllegalStateException if the game is over
   */
  Player nextPlayer() throws IllegalStateException;

  /**
   * Returns the {@link Player} whose mark is in the cell at the given
   * coordinates, or {@code null} if that cell is empty.
   *
   * @param column the column of the cell
   * @param row    the row of the cell
   * @return a {@code Player} or {@code null}
   * @throws IndexOutOfBoundsException if the cell is out of bounds.
   */
  Player getMarkAt(int column, int row) throws IndexOutOfBoundsException;

  /**
   * Determines whether the game is over.
   *
   * @return boolean value indicating whether the game is over
   *         true if the game is over, false if the game is not over
   */
  boolean isGameOver();

  /**
   * Returns the winner of the game, or {@code null} if the game is a
   * tie.
   *
   * @return the winner (of data type Player) or {@code null}
   * @throws IllegalStateException if the game isn't over
   */
  Player getWinner() throws IllegalStateException;

}
