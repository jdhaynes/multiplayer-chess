package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.*;

public class King extends Piece {
    public King(Board board, Colour colour, int x, int y) {
        super(board, colour, x, y);
    }

    @Override
    public boolean canPerformMove(Move move) {
        if(!board.positionIsWithinBoard(move.getToX(), move.getToY())) {
            return false;
        }

        boolean moveStepsValid = (move.getSteps() <= 1);
        boolean moveTypeValid = (move.getType() == MoveType.STRAIGHT ||
                move.getType() == MoveType.SYMMETRICAL_DIAGONAL);
        boolean isNotBlockedByPiece = !move.isBlockedByPiece();

        return  moveStepsValid && moveTypeValid && isNotBlockedByPiece;
    }
}
