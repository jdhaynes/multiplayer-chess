package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.Board;
import jackhaynes.chess.core.Colour;
import jackhaynes.chess.core.Move;

public abstract class Piece {
    protected final Board board;
    protected final Colour colour;

    protected int x;
    protected int y;

    public Piece(Board board, Colour colour) {
        this.board = board;
        this.colour = colour;
    }

    public abstract PieceType getType();
    public abstract boolean canMoveTo(int x, int y);

    public Colour getColour() {
        return this.colour;
    }
}
