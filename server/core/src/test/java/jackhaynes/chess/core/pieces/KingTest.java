package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.Board;
import jackhaynes.chess.core.Piece;
import jackhaynes.chess.core.PieceColour;
import jackhaynes.chess.core.PieceType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KingTest {
    @Test
    public void Given_NewPiece_When_GetType_Should_BeKing() {
        Piece piece = new King(new Board(), PieceColour.BLACK, 2, 2);
        assertEquals(PieceType.KING, piece.getType());
    }

    @Test
    public void Given_SingleKing_When_MoveStraightOneStep_Should_BeValid() {
        Piece piece = new King(new Board(), PieceColour.BLACK, 3, 3);

        // Test all directions (up, down, left, right)
        assertAll(
                () -> assertTrue(piece.canMoveTo(2, 3)),
                () -> assertTrue(piece.canMoveTo(4, 3)),
                () -> assertTrue(piece.canMoveTo(3, 2)),
                () -> assertTrue(piece.canMoveTo(3, 4))
        );
    }

    @Test
    public void Given_SingleKing_When_MoveDiagonalOneStep_Should_BeValid() {
        Piece piece = new King(new Board(), PieceColour.BLACK, 3, 3);

        // Test all directions (northeast, southeast, southwest, northwest)
        assertAll(
                () -> assertTrue(piece.canMoveTo(4, 2)),
                () -> assertTrue(piece.canMoveTo(4, 4)),
                () -> assertTrue(piece.canMoveTo(2, 4)),
                () -> assertTrue(piece.canMoveTo(2, 2))
        );
    }

    @Test
    public void Given_SingleKing_When_MoveMoreThanOneStep_Should_NotBeValid() {
        Piece piece = new King(new Board(), PieceColour.BLACK, 3, 3);

        // Test both straight and diagonal steps
        assertAll(
                () -> assertFalse(piece.canMoveTo(1, 3)),
                () -> assertFalse(piece.canMoveTo(6, 3)),
                () -> assertFalse(piece.canMoveTo(3, 5)),
                () -> assertFalse(piece.canMoveTo(1, 3))
        );
    }

    @Test
    public void Given_SingleKing_When_MoveToOffBoard_Should_NotBeValid() {
        Board board = new Board();
        Piece piece = new King(new Board(), PieceColour.BLACK, 3, 3);

        // Test each side of board at first position out of bounds
        assertAll(
                () -> assertFalse(piece.canMoveTo(-1, 3)),
                () -> assertFalse(piece.canMoveTo(board.getXDimension(), 3)),
                () -> assertFalse(piece.canMoveTo(3, -1)),
                () -> assertFalse(piece.canMoveTo(3, board.getYDimension()))
        );
    }
}