package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.Board;
import jackhaynes.chess.core.Move;
import jackhaynes.chess.core.MoveType;

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
        // TODO: doesn't support "casting" special move.
        if(!board.positionIsWithinBoard(x, y)) {
            return false;
        }

        Move move = new Move(this.x, toX, this.y, toY);
        return (move.getSteps() <= 1) &&
                (move.getType() == MoveType.STRAIGHT || move.getType() == MoveType.VALID_DIAGONAL);
    }
}
