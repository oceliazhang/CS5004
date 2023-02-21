public class ChessBoardImpl implements ChessBoard {

  private ChessPiece[][] board;

  /**
   * Constructs an empty board
   */
  public ChessBoardImpl() {
    this.board = new ChessPiece[8][8];
  }

  /**
   * create a Board with an initial position containing some pieces
   * @param startingPieces some initial pieces
   */
  public ChessBoardImpl(ChessPiece[] startingPieces) {
    this();  // call the default constructor to create an empty board
    for (ChessPiece piece : startingPieces) {
      board[piece.getRow()][piece.getColumn()] = piece;
    }
  }

  /**
   * return the piece at a given position, or "EMPTY" if there is no piece at that position.
   * @param row the row of the position
   * @param col the column of the position
   * @return the piece at the position or "EMPTY" if no piece at the position
   * @throws IllegalArgumentException if row or column out of range
   */
  @Override
  public ChessPiece getPiece(int row, int col) {
    if (row < 0 || row > 7 || col < 0 || col > 7) {
      throw new IllegalArgumentException
          ("row and column should be within the range of [0,7]");
    }
    if (board[row][col] == null) {
      return ChessPiece.EMPTY;
    } else
      return board[row][col];
  }

  /**
   * toString() method of the chess board
   * @return string indicating all the pieces on the board
   */
  @Override
  public String toString() {
    String pieces = "";
    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        if (this.getPiece(row, col) != ChessPiece.EMPTY) {
          pieces += this.getPiece(row, col).toString() + "\n";
        }
      }
    }
    return pieces;
  }
}
