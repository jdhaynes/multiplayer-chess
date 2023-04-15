package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTest {
    private class GenericPiece extends Piece {
        public GenericPiece(Board board, PieceColour colour, int x, int y)
        {
            super(board, colour, x, y);
        }

        @Override
        public PieceType getType() {
            return null;
        }

        @Override
        public boolean canMoveTo(int x, int y) {
            return false;
        }
    }

    @Test
    public void Given_WhitePiece_When_GetColour_Should_BeWhite() {
        Piece piece = new GenericPiece(new Board(), PieceColour.WHITE, 2, 2);
        assertEquals(PieceColour.WHITE, piece.getColour());
    }

}
