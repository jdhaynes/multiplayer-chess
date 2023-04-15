package jackhaynes;

public class Board {
    public static final int X_DIMENSION = 8;
    public static final int Y_DIMENSION = 8;

    private Piece[][] board;

    public Board() {
        this.board = createEmptyBoard();
    }

    public Piece pieceAt(int x, int y) {
        return this.board[y][x];
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
