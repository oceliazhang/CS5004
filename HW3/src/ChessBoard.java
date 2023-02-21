public interface ChessBoard {

  /**
   * return the piece at a given position, or "EMPTY" if there is no piece at that position.
   *
   * @param row the row of the position
   * @param col the column of the position
   * @return the piece at the position or "EMPTY" if no piece at the position
   */
  ChessPiece getPiece(int row, int col);
}
