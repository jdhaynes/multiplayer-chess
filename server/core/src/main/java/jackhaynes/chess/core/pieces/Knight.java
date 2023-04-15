package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.*;

public class Knight extends Piece {
    public Knight(Board board, PieceColour colour, int x, int y) {
        super(board, colour, x, y);
    }

    @Override
    public PieceType getType() {
         return PieceType.KNIGHT;
    }

    @Override
    public boolean canMoveTo(int toX, int toY) {
        if(!this.board.positionIsWithinBoard(toX, toY)) {
            return false;
        }

        Move move = new Move(this.x, toX, this.y, toY);
        return move.getType() == MoveType.ASYMMETRICAL_DIAGONAL && move.getSteps() == 2;
    }
}
