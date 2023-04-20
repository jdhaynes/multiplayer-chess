package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.*;

public class Rook extends Piece {
    public Rook(Board board, Colour colour, int x, int y) {
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

        Move move = new Move(this, toX, toY);

        return move.getType() == MoveType.STRAIGHT;
    }
}
