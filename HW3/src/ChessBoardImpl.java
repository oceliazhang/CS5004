import java.util.ArrayList;
import java.util.List;

public class ChessBoardImpl implements ChessBoard {

  private ArrayList<ArrayList<ChessPiece>> board;

  /**
   * Constructs an empty board
   */
  public ChessBoardImpl() {
    board = new ArrayList<>();
    for (int i = 0; i < 8; i++) {
      ArrayList<ChessPiece> row = new ArrayList<>(8);
      for (int j = 0; j < 8; j++) {
        row.add(ChessPiece.EMPTY);
      }
      board.add(row);
    }
  }

  /**
   * create a Board with an initial position containing some pieces
   * @param startingPieces some initial pieces
   */
  public ChessBoardImpl(ChessPiece[] startingPieces) {
    this();  // call the default constructor to create an empty board
    for (ChessPiece piece : startingPieces) {
      board.get(piece.getRow()).set(piece.getColumn(), piece);
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
    return board.get(row).get(col) == null ?
        ChessPiece.EMPTY : board.get(row).get(col);
  }

  /**
   * toString() method of the chess board
   * @return string indicating all the pieces on the board
   */
  @Override
  public String toString() {
    StringBuilder pieces = new StringBuilder();
    for (int row = 0; row < 8; row++) {
      for (int col = 0; col < 8; col++) {
        if (getPiece(row, col) != ChessPiece.EMPTY) {
          pieces.append(getPiece(row, col).toString()).append("\n");
        }
      }
    }
    return pieces.toString();
  }
}
