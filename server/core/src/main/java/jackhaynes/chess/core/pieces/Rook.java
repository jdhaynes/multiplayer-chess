package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.*;

public class Rook extends Piece {
    public Rook(Board board, PieceColour colour, int x, int y) {
        super(board, colour, x, y);
    }

    @Override
    public PieceType getType() {
        return PieceType.ROOK;
    }

    @Override
    public boolean canMoveTo(int toX, int toY) {
        // TODO: doesn't support "castling" special move.
        if(!this.board.positionIsWithinBoard(toX, toY)) {
            return false;
        }

        Move move = new Move(this.x, toX, this.y, toY);

        return move.getType() == MoveType.STRAIGHT;
    }
}
