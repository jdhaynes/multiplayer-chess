package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.*;

public class Bishop extends Piece {
    public Bishop(Board board, Colour colour, int x, int y) {
        super(board, colour, x, y);
    }

    @Override
    public boolean canPerformMove(Move move) {
        if(!this.board.positionIsWithinBoard(move.getToX(), move.getToY())) {
            return false;
        }

        return move.getType() == MoveType.SYMMETRICAL_DIAGONAL && !move.isBlockedByPiece();
    }
}
