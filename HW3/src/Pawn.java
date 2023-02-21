public class Pawn extends AbstractChessPiece {

    /**
     * Construct a Pawn object using the given row, column, color
     * @param row the row where locate the Pawn
     * @param column the column where locate the Pawn
     * @param color the color of the Pawn
     * @throws IllegalArgumentException if row and column out of range
     */
    public Pawn(int row, int column, Color color) {
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

        // white pawn should go upwards and black pawn should go downwards
        if (this.getColor() == Color.WHITE) {
            if ((this.getColumn() == col) && (row - this.getRow() == 1)) {
                return true;
            } else return (row - this.getRow() == 1) && Math.abs(this.getColumn() - col) == 1;
        }
        else {
            if ((this.getColumn() == col) && (this.getRow() - row == 1)) {
                return true;
            } else return (this.getRow() - row == 1) && Math.abs(this.getColumn() - col) == 1;
        }
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
        if (row < 0 || row > 7 || col < 0 || col > 7) {
            throw new IllegalArgumentException
                ("row and column should be within the range of [0,7]");
        }

        // white pawn should go upwards and black pawn should go downwards
        if (this.getColor() == Color.WHITE) {
            if ((this.getColumn() == col) && (row - this.getRow() == 1)) {
                return board.getPiece(row, col) == ChessPiece.EMPTY;
            } else if (row - this.getRow() == 1 && Math.abs(this.getColumn() - col) == 1) {
                return board.getPiece(row, col) != ChessPiece.EMPTY
                    && board.getPiece(row, col).getColor() == Color.BLACK;
            } else return false;
        }
        else {
            if ((this.getColumn() == col) && (this.getRow() - row == 1)) {
                return board.getPiece(row, col) == ChessPiece.EMPTY;
            } else if (this.getRow() - row == 1 && Math.abs(this.getColumn() - col) == 1) {
                return board.getPiece(row, col) != ChessPiece.EMPTY
                    && board.getPiece(row, col).getColor() == Color.WHITE;
            } else return false;
        }
    }

    /**
     * Return if it can kill the piece
     * @param piece a chess piece
     * @return True if it can kill the piece, False if it can't kill the piece
     */
    @Override
    public Boolean canKill(ChessPiece piece) {
        int rowDiff = piece.getRow() - this.getRow();
        int colDiff = piece.getColumn() - this.getColumn();
        if (this.getColor() != piece.getColor()) {
            if (rowDiff == 1 && colDiff == 1) {
                return true;
            }
            else return rowDiff == 1 && colDiff == -1;
        } else return false;
    }

    /**
     * toString() method
     * @return its row, column, and color
     */
    @Override
    public String toString() {
        return "Pawn{" +
            "row=" + getRow() +
            ", column=" + getColumn() +
            ", color=" + getColor() +
            '}';
    }
}
