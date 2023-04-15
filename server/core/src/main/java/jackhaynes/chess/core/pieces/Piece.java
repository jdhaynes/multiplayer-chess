package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.Board;

public abstract class Piece {
    protected final Board board;
    protected final PieceColour colour;

    protected int x;
    protected int y;

    public Piece(Board board, PieceColour colour) {
        this.board = board;
        this.colour = colour;
    }

    public abstract PieceType getType();
    public abstract boolean canMoveTo(int x, int y);

    public PieceColour getColour() {
        return this.colour;
    }
}
