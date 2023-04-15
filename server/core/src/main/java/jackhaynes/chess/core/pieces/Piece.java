package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.Board;

public abstract class Piece {
    protected final Board board;
    protected final PieceColour colour;

    protected int x;
    protected int y;

    public Piece(Board board, PieceColour colour, int x, int y) {
        this.board = board;
        this.colour = colour;
        this.x = x;
        this.y = y;
    }

    public abstract PieceType getType();
    public abstract boolean canMoveTo(int x, int y);

    public PieceColour getColour() {
        return this.colour;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
