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
     * Return if it can move to a given cell, "in between" squares are considered
     * @param row the row of the target location
     * @param col the column of the target location
     * @param board the current chess board
     * @return True if it can move to the target location,
     *         False if it can't move to the target location
     */
    Boolean canMoveV2(int row, int col, ChessBoard board);

    /**
     * Return if it can kill the piece
     * @param piece a chess piece
     * @return True if it can kill the piece, False if it can't kill the piece
     */
    Boolean canKill(ChessPiece piece);

    /**
     * Create EMPTY constant
     */
    ChessPiece EMPTY = new ChessPiece() {
        /**
         * the row of the EMPTY constant is -1
         * @return -1
         */
        @Override
        public int getRow() {
            return -1;
        }

        /**
         * the column of the EMPTY constant is -1
         * @return -1
         */
        @Override
        public int getColumn() {
            return -1;
        }

        /**
         * the color of the EMPTY constant is null
         * @return null
         */
        @Override
        public Color getColor() {
            return null;
        }

        /**
         * the EMPTY constant can't move
         * @param row the row of the target location
         * @param col the column of the target location
         * @return false
         */
        @Override
        public Boolean canMove(int row, int col) {
            return false;
        }

        /**
         * the EMPTY constant can't move
         * @param row the row of the target location
         * @param col the column of the target location
         * @param board the current chess board
         * @return false
         */
        @Override
        public Boolean canMoveV2(int row, int col, ChessBoard board) {
            return false;
        }

        /**
         * the EMPTY constant can't kill
         * @param piece a chess piece
         * @return false
         */
        @Override
        public Boolean canKill(ChessPiece piece) {
            return false;
        }
    };
}

