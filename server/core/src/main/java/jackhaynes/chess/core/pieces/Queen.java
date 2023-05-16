package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.*;

public class Queen extends Piece {
    public Queen(Board board, Colour colour, int x, int y) {
        super(board, colour, x, y);
    }

    @Override
    public boolean canPerformMove(Move move) {
       if(!this.board.positionIsWithinBoard(move.getToX(), move.getToY())) {
           return false;
       }

       boolean isStraightMove = move.getType() == MoveType.STRAIGHT;
       boolean isSymmetricalDiagonalMove = move.getType() == MoveType.SYMMETRICAL_DIAGONAL;
       boolean isNotBlockedByPiece = !move.isBlockedByPiece();

       return (isStraightMove || isSymmetricalDiagonalMove) && isNotBlockedByPiece;
    }
}
