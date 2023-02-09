public class Knight implements ChessPiece{
    private int row;
    private int column;
    private Color color;

    /**
     * Construct a Knight object using the given row, column, color
     * @param row the row where locate the Knight
     * @param column the column where locate the Knight
     * @param color the color of the Knight
     * @throws IllegalArgumentException if row and column out of range
     */
    public Knight(int row, int column, Color color) {
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
        int rowDiff = Math.abs(this.row - row);
        int colDiff = Math.abs(this.column - col);
        if ((rowDiff == 2) && (colDiff == 1)) {
            return true;
        } else return (rowDiff == 1) && (colDiff == 2);
    }

    /**
     * Return if it can kill the piece
     * @param piece a chess piece
     * @return True if it can kill the piece, False if it can't kill the piece
     */
    @Override
    public Boolean canKill(ChessPiece piece) {
        return (this.color != piece.getColor()) &&
                canMove(piece.getRow(), piece.getColumn());
    }
}
