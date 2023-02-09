public class Pawn implements ChessPiece{
    private int row;
    private int column;
    private Color color;

    /**
     * Construct a Pawn object using the given row, column, color
     * @param row the row where locate the Pawn
     * @param column the column where locate the Pawn
     * @param color the color of the Pawn
     * @throws IllegalArgumentException if row and column out of range
     */
    public Pawn(int row, int column, Color color) {
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
        if (this.color == Color.WHITE) {
            if ((this.column == col) && (row - this.row == 1)) {
                return true;
            } else return (row - this.row == 1) && Math.abs(this.column - col) == 1;
        }
        else {
            if ((this.column == col) && (this.row - row == 1)) {
                return true;
            } else return (this.row - row == 1) && Math.abs(this.column - col) == 1;
        }
    }

    /**
     * Return if it can kill the piece
     * @param piece a chess piece
     * @return True if it can kill the piece, False if it can't kill the piece
     */
    @Override
    public Boolean canKill(ChessPiece piece) {
        int rowDiff = piece.getRow() - this.row;
        int colDiff = piece.getColumn() - this.column;
        if (this.color != piece.getColor()) {
            if (rowDiff == 1 && colDiff == 1) {
                return true;
            }
            else return rowDiff == 1 && colDiff == -1;
        } else return false;
    }
}
