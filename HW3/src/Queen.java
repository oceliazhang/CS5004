public class Queen extends AbstractChessPiece {

    /**
     * Construct a Queen object using the given row, column, color
     * @param row the row where locate the Queen
     * @param column the column where locate the Queen
     * @param color the color of the Queen
     * @throws IllegalArgumentException if row and column out of range
     */
    public Queen(int row, int column, Color color) {
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
        if (this.getRow() == row) {
            return true;
        } else if (this.getColumn() == col) {
            return true;
        } else return (Math.abs(this.getRow() - row) == Math.abs(this.getColumn() - col));
    }

    /**
     * Return if it can move to a given cell, "in between" squares are considered
     *
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
        if (board.getPiece(row, col) != ChessPiece.EMPTY
            && board.getPiece(row, col).getColor() == this.getColor()) {
            return false;
        }

        // check if all the way to the destination is empty
        int rowDiff = row > this.getRow() ? 1 : -1;
        int colDiff = col > this.getColumn() ? 1 : -1;
        int currRow = this.getRow() + rowDiff;
        int currCol = this.getColumn() + colDiff;

        if (row == this.getRow()) {
            while (currCol != col) {
                if (board.getPiece(row, currCol) != ChessPiece.EMPTY) {
                    return false;
                }
                currCol += colDiff;
            }
        } else if (col == this.getColumn()) {
            while (currRow != row) {
                if (board.getPiece(currRow, col) != ChessPiece.EMPTY) {
                    return false;
                }
                currRow += rowDiff;
            }
        } else {
            while (currRow != row && currCol != col) {
                if (board.getPiece(currRow, currCol) != ChessPiece.EMPTY) {
                    return false;
                }
                currRow += rowDiff;
                currCol += colDiff;
            }
        }

        return true;
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
        return "Queen{" +
            "row=" + getRow() +
            ", column=" + getColumn() +
            ", color=" + getColor() +
            '}';
    }
}
