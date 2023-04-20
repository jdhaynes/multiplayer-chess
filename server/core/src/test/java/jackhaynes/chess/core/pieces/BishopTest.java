package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.Board;
import jackhaynes.chess.core.Piece;
import jackhaynes.chess.core.Colour;
import jackhaynes.chess.core.PieceType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class BishopTest {
    @Test
    public void Given_NewPiece_When_GetType_Should_BeRook() {
        Piece piece = new Bishop(new Board(), Colour.BLACK, 2, 2);
        assertEquals(PieceType.BISHOP, piece.getType());
    }

    @Test
    public void Given_SingleBishop_When_MoveDiagonal_Should_BeValid() {
        Piece piece = new Bishop(new Board(), Colour.BLACK, 3, 3);

        // Test all directions (northeast, southeast, southwest, northwest)
        assertAll(
                () -> assertTrue(piece.canMoveTo(4, 2)),
                () -> assertTrue(piece.canMoveTo(4, 4)),
                () -> assertTrue(piece.canMoveTo(2, 4)),
                () -> assertTrue(piece.canMoveTo(2, 2))
        );
    }

    @Test
    public void Given_SingleBishop_When_MoveStraight_Should_NotBeValid() {
        Piece piece = new Bishop(new Board(), Colour.BLACK, 3, 3);

        // Test all directions (up, down, left, right)
        assertAll(
                () -> assertFalse(piece.canMoveTo(2, 3)),
                () -> assertFalse(piece.canMoveTo(4, 3)),
                () -> assertFalse(piece.canMoveTo(3, 2)),
                () -> assertFalse(piece.canMoveTo(3, 4))
        );
    }

    @Test
    public void Given_SingleBishop_When_MoveMoreThanOneStep_Should_BeValid() {
        Piece piece = new Bishop(new Board(), Colour.BLACK, 3, 3);

        assertAll(
                () -> assertTrue(piece.canMoveTo(6, 0)),
                () -> assertTrue(piece.canMoveTo(6, 6)),
                () -> assertTrue(piece.canMoveTo(0, 6)),
                () -> assertTrue(piece.canMoveTo(0, 0))
        );
    }

    @Test
    public void Given_SingleBishop_When_MoveToOffBoardDiagonal_Should_NotBeValid() {
        Board board = new Board();
        Piece piece = new Bishop(new Board(), Colour.BLACK, 3, 3);

        // Test each side of board at first position out of bounds
        assertAll(
                () -> assertFalse(piece.canMoveTo(7, -1)),
                () -> assertFalse(piece.canMoveTo(8, 8)),
                () -> assertFalse(piece.canMoveTo(-1, 7)),
                () -> assertFalse(piece.canMoveTo(-1, -1))
        );
    }
}
