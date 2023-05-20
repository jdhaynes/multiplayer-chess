package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.*;

import java.util.List;

public class King extends Piece {
    public King(Board board, Colour colour, int x, int y) {
        super(board, colour, x, y);
    }

    @Override
    public boolean canPerformMove(Move move) {
        if(!board.positionIsWithinBoard(move.getToX(), move.getToY())) {
            return false;
        }

        boolean moveStepsValid = (move.getSteps() <= 1);
        boolean moveTypeValid = (move.getType() == MoveType.STRAIGHT ||
                move.getType() == MoveType.SYMMETRICAL_DIAGONAL);
        boolean isNotBlockedByPiece = !move.isBlockedByPiece();

        return  moveStepsValid && moveTypeValid && isNotBlockedByPiece;
    }

    public boolean isInCheck() {
        List<Piece> opponentPieces = (this.getColour() == Colour.WHITE) ?
                this.board.getBlackPieces() :
                this.board.getWhitePieces();

        for(int i = 0; i < opponentPieces.size(); i++) {
            Piece piece = opponentPieces.get(i);
            Move move = new Move(piece, this.getX(), this.getY());
            if(piece.canPerformMove(move)) {
                return true;
            }
        }

        return false;
    }
}
