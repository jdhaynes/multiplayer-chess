package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.*;

public class Queen extends Piece {
    public Queen(Board board, Colour colour, int x, int y) {
        super(board, colour, x, y);
    }

    @Override
    public boolean canMoveTo(int toX, int toY) {
       if(!this.board.positionIsWithinBoard(toX, toY)) {
           return false;
       }

       Move move = new Move(this, toX, toY);
       return move.getType() == MoveType.STRAIGHT || move.getType() == MoveType.SYMMETRICAL_DIAGONAL;
    }
}
