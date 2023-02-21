public abstract class AbstractChessPiece implements ChessPiece{
  private int row;
  private int column;
  private Color color;

  /**
   * Construct a new Chess piece
   * @param row the row of the piece
   * @param column the column of the piece
   * @param color the color of the piece
   * @throws IllegalArgumentException if row and column out of range
   */
  public AbstractChessPiece(int row, int column, Color color) {
    if (row < 0 || row > 7 || column < 0 || column > 7) {
      throw new IllegalArgumentException
          ("row and column should be within the range of [0,7]");
    }
    this.row = row;
    this.column = column;
    this.color = color;
  }

  /**
   * Get the row where locate the chess piece
   * @return the row of the current chess piece
   */
  @Override
  public int getRow() {
    return this.row;
  }

  /**
   * Get the column where locate the chess piece
   * @return the column of the current chess piece
   */
  @Override
  public int getColumn() {
    return this.column;
  }

  /**
   * Get the color of the chess piece
   * @return the color of the chess piece
   */
  @Override
  public Color getColor() {
    return this.color;
  }

  /**
   * Return if it can move to a given cell
   * @param row the row of the target location
   * @param col the column of the target location
   * @return True if it can move to the target location, False if it can't move to the target
   * location
   */
  @Override
  public abstract Boolean canMove(int row, int col);

  /**
   * Return if it can move to a given cell, "in between" squares are considered
   * @param row   the row of the target location
   * @param col   the column of the target location
   * @param board the current chess board
   * @return True if it can move to the target location, False if it can't move to the target
   * location
   */
  @Override
  public abstract Boolean canMoveV2(int row, int col, ChessBoard board);

  /**
   * Return if it can kill the piece
   * @param piece a chess piece
   * @return True if it can kill the piece, False if it can't kill the piece
   */
  @Override
  public abstract Boolean canKill(ChessPiece piece);

  @Override
  public String toString() {
    return "AbstractChessPiece{" +
        "row=" + row +
        ", column=" + column +
        ", color=" + color +
        '}';
  }
}
