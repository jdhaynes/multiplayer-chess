package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.*;

public class Rook extends Piece {
    public Rook(Board board, Colour colour, int x, int y) {
        super(board, colour, x, y);
    }

    @Override
    public boolean canPerformMove(Move move) {
        return super.canPerformMove(move)
                && move.getType() == MoveType.STRAIGHT
                && !move.isBlockedByPiece();
    }
}
