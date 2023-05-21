package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.*;

public class Knight extends Piece {
    public Knight(Board board, Colour colour, int x, int y) {
        super(board, colour, x, y);
    }

    @Override
    public boolean canPerformMove(Move move) {
        boolean isAsymmetricalDiagonal = move.getType() == MoveType.ASYMMETRICAL_DIAGONAL;
        boolean isTwoSteps = move.getSteps() == 2;

        return super.canPerformMove(move)
                && isAsymmetricalDiagonal
                && isTwoSteps;
    }
}
