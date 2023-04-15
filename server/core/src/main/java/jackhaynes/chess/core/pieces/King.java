package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.Board;

public class King extends Piece {
    public King(Board board, PieceColour colour) {
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
