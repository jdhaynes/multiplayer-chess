package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.Board;
import jackhaynes.chess.core.Piece;
import jackhaynes.chess.core.Colour;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QueenTest {
    @Test
    public void Given_SingleQueen_When_MoveStraightOneStep_Should_BeValid() {
        Piece piece = new Queen(new Board(), Colour.BLACK, 3, 3);

        // Test all directions (up, down, left, right)
        assertAll(
                () -> assertTrue(piece.canMoveTo(2, 3)),
                () -> assertTrue(piece.canMoveTo(4, 3)),
                () -> assertTrue(piece.canMoveTo(3, 2)),
                () -> assertTrue(piece.canMoveTo(3, 4))
        );
    }

    @Test
    public void Given_SingleQueen_When_MoveDiagonalOneStep_Should_BeValid() {
        Piece piece = new Queen(new Board(), Colour.BLACK, 3, 3);

        // Test all directions (northeast, southeast, southwest, northwest)
        assertAll(
                () -> assertTrue(piece.canMoveTo(4, 2)),
                () -> assertTrue(piece.canMoveTo(4, 4)),
                () -> assertTrue(piece.canMoveTo(2, 4)),
                () -> assertTrue(piece.canMoveTo(2, 2))
        );
    }

    @Test
    public void Given_SingleQueen_When_MoveMoreThanOneStep_Should_BeValid() {
        Piece piece = new Queen(new Board(), Colour.BLACK, 3, 3);

        // Test both straight and diagonal steps
        assertAll(
                () -> assertTrue(piece.canMoveTo(1, 3)),
                () -> assertTrue(piece.canMoveTo(6, 3)),
                () -> assertTrue(piece.canMoveTo(3, 5)),
                () -> assertTrue(piece.canMoveTo(1, 3))
        );
    }

    @Test
    public void Given_SingleQueen_When_MoveToOffBoard_Should_NotBeValid() {
        Board board = new Board();
        Piece piece = new Queen(new Board(), Colour.BLACK, 3, 3);

        // Test each side of board at first position out of bounds
        assertAll(
                () -> assertFalse(piece.canMoveTo(-1, 3)),
                () -> assertFalse(piece.canMoveTo(board.getXDimension(), 3)),
                () -> assertFalse(piece.canMoveTo(3, -1)),
                () -> assertFalse(piece.canMoveTo(3, board.getYDimension()))
        );
    }
}
