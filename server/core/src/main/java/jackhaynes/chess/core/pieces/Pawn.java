package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.*;

public class Pawn extends Piece {
    public Pawn(Board board, Colour colour, int x, int y) {
        super(board, colour, x, y);
    }

    @Override
    public boolean canPerformMove(Move move) {
        return super.canPerformMove(move)
                && move.getSteps() <= 2
                && move.getType() == MoveType.STRAIGHT
                && move.getDirection() == MoveDirection.FORWARD
                && !move.isBlockedByPiece();
    }
}
