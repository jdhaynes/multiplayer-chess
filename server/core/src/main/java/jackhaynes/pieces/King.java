package jackhaynes.pieces;

import jackhaynes.Board;
import jackhaynes.Colour;

public class King extends Piece {
    public King(Board board, Colour colour) {
        super(board, colour);
    }

    @Override
    public PieceType getType() {
        return PieceType.KING;
    }

    @Override
    public boolean canMoveTo(int x, int y) {
        return false;
    }

}
