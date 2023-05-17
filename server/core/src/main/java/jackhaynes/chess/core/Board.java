package jackhaynes.chess.core;

import jackhaynes.chess.core.exceptions.MoveNotAllowedException;
import jackhaynes.chess.core.pieces.*;

public class Board {
    private final int X_DIMENSION = 8;
    private final int Y_DIMENSION = 8;

    private final Piece[][] board;

    public Board() {
        this.board = createEmptyBoard();
    }

    public void initialise() {
        placePiece(new Rook(this, Colour.BLACK, 0, 0));
        placePiece(new Knight(this, Colour.BLACK, 1, 0));
        placePiece(new Bishop(this, Colour.BLACK, 2, 0));
        placePiece(new Queen(this, Colour.BLACK, 3, 0));
        placePiece(new King(this, Colour.BLACK, 4, 0));
        placePiece(new Bishop(this, Colour.BLACK, 5, 0));
        placePiece(new Knight(this, Colour.BLACK, 6, 0));
        placePiece(new Rook(this, Colour.BLACK, 7, 0));

        for(int i = 0; i < getXDimension(); i++) {
            placePiece(new Rook(this, Colour.BLACK, i, 1));
        }

        placePiece(new Rook(this, Colour.WHITE, 0, 7));
        placePiece(new Knight(this, Colour.WHITE, 1, 7));
        placePiece(new Bishop(this, Colour.WHITE, 2, 7));
        placePiece(new Queen(this, Colour.WHITE, 3, 7));
        placePiece(new King(this, Colour.WHITE, 4, 7));
        placePiece(new Bishop(this, Colour.WHITE, 5, 7));
        placePiece(new Knight(this, Colour.WHITE, 6, 7));
        placePiece(new Rook(this, Colour.WHITE, 7, 7));

        for(int i = 0; i < getXDimension(); i++) {
            placePiece(new Rook(this, Colour.WHITE, i, 7));
        }
    }

    public boolean positionIsWithinBoard(int x, int y) {
        return (x >= 0 && x < this.getXDimension()) && (y >= 0 && y < this.getYDimension());
    }

    public Piece getPiece(int x, int y) {
        if (this.positionIsWithinBoard(x, y)) {
            return this.board[y][x];
        } else {
            return null;
        }
    }

    public void placePiece(Piece piece) {
        if (this.positionIsWithinBoard(piece.getX(), piece.getY())) {
            this.board[piece.getY()][piece.getX()] = piece;
        }
    }

    public void movePiece(Piece piece, int toX, int toY) throws MoveNotAllowedException {
        Move move = new Move(piece, toX, toY);
        if (piece.canPerformMove(move)) {
            this.removePiece(piece.getX(), piece.getY());
            this.placePiece(piece);
        } else {
            throw new MoveNotAllowedException("The piece cannot perform this move.");
        }
    }

    public void removePiece(int x, int y) {
        if (this.positionIsWithinBoard(x, y)) {
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
