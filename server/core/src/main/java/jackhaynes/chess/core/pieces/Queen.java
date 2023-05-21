package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.*;

public class Queen extends Piece {
    public Queen(Board board, Colour colour, int x, int y) {
        super(board, colour, x, y);
    }

    @Override
    public boolean canPerformMove(Move move) {boolean isStraightMove = move.getType() == MoveType.STRAIGHT;
       boolean isSymmetricalDiagonalMove = move.getType() == MoveType.SYMMETRICAL_DIAGONAL;
       boolean isNotBlockedByPiece = !move.isBlockedByPiece();

       return super.canPerformMove(move)
        && (isStraightMove || isSymmetricalDiagonalMove)
        && isNotBlockedByPiece;
    }
}
