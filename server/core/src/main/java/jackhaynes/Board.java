package jackhaynes;

public class Board {
    private final int X_DIMENSION = 8;
    private final int Y_DIMENSION = 8;

    private final Piece[][] board;

    public Board() {
        this.board = this.createEmptyBoard();
    }

    public int getYDimension() {
        return this.board.length;
    }

    public int getXDimension() {
        return this.board[0].length;
    }

    public Piece getPiece(int x, int y) {
        if(this.coordinateIsWithinBoard(x, y)) {
            return this.board[y][x];
        } else {
            return null;
        }
    }

    public void placePiece(Piece piece, int x, int y) {
        if(this.coordinateIsWithinBoard(x, y)) {
            this.board[y][x] = piece;
        }
    }

    public void removePiece(int x, int y) {
        if(this.coordinateIsWithinBoard(x, y)) {
            this.board[y][x] = null;
        }
    }

    private boolean coordinateIsWithinBoard(int x, int y) {
        return (x >= 0 && x < this.getXDimension()) && (y >= 0 && y < this.getYDimension());
    }

    private Piece[][] createEmptyBoard() {
        Piece[][] emptyBoard = new Piece[this.Y_DIMENSION][this.X_DIMENSION];

        for(int row = 0; row < this.Y_DIMENSION; row++) {
            for(int col = 0; col < this.X_DIMENSION; col++) {
                emptyBoard[col][row] = null;
            }
        }

        return emptyBoard;
    }
}
