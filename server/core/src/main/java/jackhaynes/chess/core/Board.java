package jackhaynes.chess.core;

import jackhaynes.chess.core.pieces.Piece;

public class Board {
    private final int X_DIMENSION = 8;
    private final int Y_DIMENSION = 8;

    private final Piece[][] board;

    public Board() {
        this.board = this.createEmptyBoard();
    }

    public boolean positionIsWithinBoard(int x, int y) {
        return (x >= 0 && x < this.getXDimension()) && (y >= 0 && y < this.getYDimension());
    }

    public Piece getPiece(int x, int y) {
        if(this.positionIsWithinBoard(x, y)) {
            return this.board[y][x];
        } else {
            return null;
        }
    }

    public void placePiece(Piece piece, int x, int y) {
        if(this.positionIsWithinBoard(x, y)) {
            this.board[y][x] = piece;
        }
    }

    public void removePiece(int x, int y) {
        if(this.positionIsWithinBoard(x, y)) {
            this.board[y][x] = null;
        }
    }

    public int getYDimension() {
        return this.board.length;
    }

    public int getXDimension() {
        return this.board[0].length;
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
