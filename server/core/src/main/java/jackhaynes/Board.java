package jackhaynes;

public class Board {
    private final int X_DIMENSION = 8;
    private final int Y_DIMENSION = 8;

    private Piece[][] board;

    public Board() {
        this.board = createEmptyBoard();
    }

    public Piece pieceAt(int x, int y) {
        if(coordinateIsWithinBoard(x, y)) {
            return this.board[y][x];
        } else {
            return null;
        }
    }

    public void placePiece(Piece piece, int x, int y) {
        if(coordinateIsWithinBoard(x, y)) {
            this.board[y][x] = piece;
        }
    }

    private boolean coordinateIsWithinBoard(int x, int y) {
        return (x >= 0 && x < X_DIMENSION) && (y >= 0 && y < Y_DIMENSION);
    }

    private Piece[][] createEmptyBoard() {
        Piece[][] emptyBoard = new Piece[Y_DIMENSION][X_DIMENSION];

        for(int row = 0; row < Y_DIMENSION; row++) {
            for(int col = 0; col < X_DIMENSION; col++) {
                emptyBoard[col][row] = null;
            }
        }

        return emptyBoard;
    }
}
