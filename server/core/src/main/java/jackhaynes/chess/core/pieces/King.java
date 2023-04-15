package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.*;

public class King extends Piece {
    public King(Board board, PieceColour colour, int x, int y) {
        super(board, colour, x, y);
    }

    @Override
    public PieceType getType() {
        return PieceType.KING;
    }

    @Override
    public boolean canMoveTo(int toX, int toY) {
        // TODO: doesn't support "castling" special move.
        if(!board.positionIsWithinBoard(x, y)) {
            return false;
        }

        Move move = new Move(this, toX, toY);

        boolean moveStepsValid = (move.getSteps() <= 1);
        boolean moveTypeValid = (move.getType() == MoveType.STRAIGHT ||
                move.getType() == MoveType.SYMMETRICAL_DIAGONAL);

        return  moveStepsValid && moveTypeValid;
    }
}
