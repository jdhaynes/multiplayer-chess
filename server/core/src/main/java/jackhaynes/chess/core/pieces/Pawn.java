package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.*;

public class Pawn extends Piece {
    public Pawn(Board board, Colour colour, int x, int y) {
        super(board, colour, x, y);
    }

    @Override
    public boolean canMoveTo(int toX, int toY) {
        if(!this.board.positionIsWithinBoard(toX, toY)) {
            return false;
        }

        // TODO: doesn't capture more complex behaviour
        Move move = new Move(this, toX, toY);

        return (
                move.getSteps() <= 2 &&
                move.getType() == MoveType.STRAIGHT &&
                move.getDirection() == MoveDirection.FORWARD
        );
    }
}
