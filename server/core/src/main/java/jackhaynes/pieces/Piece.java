package jackhaynes.pieces;

import jackhaynes.Board;
import jackhaynes.Colour;

public abstract class Piece {
    protected Board board;
    protected Colour colour;

    protected int x;
    protected int y;

    public Piece(Board board, Colour colour) {
        this.board = board;
        this.colour = colour;
    }

    public abstract PieceType getType();
    public abstract boolean canMoveTo(int x, int y);
}
