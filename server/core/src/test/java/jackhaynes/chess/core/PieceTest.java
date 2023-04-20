package jackhaynes.chess.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PieceTest {
    private class GenericPiece extends Piece {
        public GenericPiece(Board board, Colour colour, int x, int y)
        {
            super(board, colour, x, y);
        }

        @Override
        public boolean canMoveTo(int x, int y) {
            return false;
        }
    }

    @Test
    public void Given_WhitePiece_When_GetColour_Should_BeWhite() {
        Piece piece = new GenericPiece(new Board(), Colour.WHITE, 2, 2);
        assertEquals(Colour.WHITE, piece.getColour());
    }

    @Test
    public void Given_NewPiece_When_GetHasMoved_Should_HaveNotMoved() {
        Piece piece = new GenericPiece(new Board(), Colour.WHITE, 2, 2);
        assertFalse(piece.hasMoved);
    }

    @Test
    public void Given_MovedPiece_When_GetHasMoved_Should_HaveMoved() {
        Piece piece = new GenericPiece(new Board(), Colour.WHITE, 2, 2);
        piece.move(3, 3);
        assertTrue(piece.hasMoved());
    }

    @Test
    public void Given_Piece_When_Move_Should_UpdatePosition() {
        Piece piece = new GenericPiece(new Board(), Colour.WHITE, 2, 2);
        piece.move(5, 1);

        assertAll(
                () -> assertEquals(5, piece.getX()),
                () -> assertEquals(1, piece.getY())
        );
    }
}
