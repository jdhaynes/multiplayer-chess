package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.*;

import java.util.List;

public class King extends Piece {
    public King(Board board, Colour colour, int x, int y) {
        super(board, colour, x, y);
    }

    @Override
    public boolean canPerformMove(Move move) {
          boolean moveStepsValid = (move.getSteps() <= 1);
        boolean moveTypeValid = (move.getType() == MoveType.STRAIGHT ||
                move.getType() == MoveType.SYMMETRICAL_DIAGONAL);
        boolean isNotBlockedByPiece = !move.isBlockedByPiece();

        return  super.canPerformMove(move)
                && moveStepsValid
                && moveTypeValid
                && isNotBlockedByPiece;
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

    public boolean isInCheckmate() {
        if(!this.isInCheck()) {
            return false;
        }

        // Get pieces in all positions that the king can move to (one step), and check if it can move there.
        for(int col = this.getX() - 1; col <= this.getX() + 1; col++) {
            for(int row = this.getY() - 1; col <= this.getY(); row++) {
                if(!board.positionIsWithinBoard(col, row)) {
                    continue;
                }

                Piece piece = board.getPiece(col, row);

                if(piece == null) {
                    return false;
                }

                if(piece.getColour() == this.getColour()) {
                    continue;
                }

                Move move = new Move(piece, col, row);
                if(this.canPerformMove(move)) {
                    return false;
                }
            }
        }

        return true;
    }
}
