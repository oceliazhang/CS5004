public class Knight extends AbstractChessPiece {

    /**
     * Construct a Knight object using the given row, column, color
     * @param row the row where locate the Knight
     * @param column the column where locate the Knight
     * @param color the color of the Knight
     * @throws IllegalArgumentException if row and column out of range
     */
    public Knight(int row, int column, Color color) {
        super(row, column, color);
    }

    /**
     * Return if it can move to a given cell
     * @param row the row of the target location
     * @param col the column of the target location
     * @return True if it can move to the target location,
     * False if it can't move to the target location
     * @throws IllegalArgumentException if row and col out of range
     */
    @Override
    public Boolean canMove(int row, int col) {
        if (row < 0 || row > 7 || col < 0 || col > 7) {
            throw new IllegalArgumentException
                    ("row and column should be within the range of [0,7]");
        }
        int rowDiff = Math.abs(this.getRow() - row);
        int colDiff = Math.abs(this.getColumn() - col);
        if ((rowDiff == 2) && (colDiff == 1)) {
            return true;
        } else return (rowDiff == 1) && (colDiff == 2);
    }

    /**
     * Return if it can move to a given cell, "in between" squares are considered
     * @param row   the row of the target location
     * @param col   the column of the target location
     * @param board the current chess board
     * @return True if it can move to the target location, False if it can't move to the target
     * @throws IllegalArgumentException if row or column out of range
     */
    @Override
    public Boolean canMoveV2(int row, int col, ChessBoard board) {
        // check if the moving pattern is correct
        if (!this.canMove(row, col)) {
            return false;
        }

        // check if the destination is a same-color piece
        return board.getPiece(row, col) == ChessPiece.EMPTY
            || board.getPiece(row, col).getColor() != this.getColor();
    }

    /**
     * Return if it can kill the piece
     * @param piece a chess piece
     * @return True if it can kill the piece, False if it can't kill the piece
     */
    @Override
    public Boolean canKill(ChessPiece piece) {
        return (this.getColor() != piece.getColor()) &&
                canMove(piece.getRow(), piece.getColumn());
    }

    /**
     * toString() method
     * @return its row, column, and color
     */
    @Override
    public String toString() {
        return "Knight{" +
            "row=" + getRow() +
            ", column=" + getColumn() +
            ", color=" + getColor() +
            '}';
    }
}
