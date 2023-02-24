public class Rook extends AbstractChessPiece {

    /**
     * Construct a Rook object using the given row, column, color
     * @param row the row where locate the Rook
     * @param column the column where locate the Rook
     * @param color the color of the Rook
     * @throws IllegalArgumentException if row and column are not
     *                                  within the range of [0,7]
     */
    public Rook(int row, int column, Color color) {
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
        return (this.getRow() == row) || (this.getColumn() == col);
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

        // My Intellij says there are some duplicate code in here, since for several pieces,
        // we have to check if its moving pattern is correct and if its destination is a same-color
        // piece. And when I check if all the way to the destination is empty, I use same helper
        // variables for several pieces. I don't think these can be considered duplicate code since
        // the overall implementation for canMoveV2 method for each type of piece are different.

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
        } else {
            while (currRow != row) {
                if (board.getPiece(currRow, col) != ChessPiece.EMPTY) {
                    return false;
                }
                currRow += rowDiff;
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
        return "Rook{" +
            "row=" + getRow() +
            ", column=" + getColumn() +
            ", color=" + getColor() +
            '}';
    }
}
