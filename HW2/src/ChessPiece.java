public interface ChessPiece {

    /**
     * Get the row where locate the chess piece
     * @return the row of the current chess piece
     */
    int getRow();

    /**
     * Get the column where locate the chess piece
     * @return the column of the current chess piece
     */
    int getColumn();

    /**
     * Get the color of the chess piece
     * @return the color of the chess piece
     */
    Color getColor();

    /**
     * Return if it can move to a given cell
     * @param row the row of the target location
     * @param col the column of the target location
     * @return True if it can move to the target location,
     *         False if it can't move to the target location
     */
    Boolean canMove(int row, int col);

    /**
     * Return if it can kill the piece
     * @param piece a chess piece
     * @return True if it can kill the piece, False if it can't kill the piece
     */
    Boolean canKill(ChessPiece piece);
}

