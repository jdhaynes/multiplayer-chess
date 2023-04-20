package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.Board;
import jackhaynes.chess.core.Piece;
import jackhaynes.chess.core.Colour;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KnightTest {
    @Test
    public void Given_SingleKnight_When_MoveOneByTwo_Should_BeValidMove() {
        Piece piece = new Knight(new Board(), Colour.BLACK, 3, 3);

        // 8 valid moves (assuming none go off bounds of board).
        assertAll(
                () -> assertTrue(piece.canMoveTo(4, 1)),
                () -> assertTrue(piece.canMoveTo(5, 2)),
                () -> assertTrue(piece.canMoveTo(5, 4)),
                () -> assertTrue(piece.canMoveTo(4, 5)),
                () -> assertTrue(piece.canMoveTo(2, 5)),
                () -> assertTrue(piece.canMoveTo(1, 4)),
                () -> assertTrue(piece.canMoveTo(1, 2)),
                () -> assertTrue(piece.canMoveTo(2, 1))
        );
    }

    @Test
    public void Given_SingleKnight_When_MoveStraightOneStep_Should_NotBeValid() {
        Piece piece = new Knight(new Board(), Colour.BLACK, 3, 3);

        // Test all directions (up, down, left, right)
        assertAll(
                () -> assertFalse(piece.canMoveTo(2, 3)),
                () -> assertFalse(piece.canMoveTo(4, 3)),
                () -> assertFalse(piece.canMoveTo(3, 2)),
                () -> assertFalse(piece.canMoveTo(3, 4))
        );
    }

    @Test
    public void Given_SingleKnight_When_MoveDiagonalOneStep_Should_NotBeValid() {
        Piece piece = new Knight(new Board(), Colour.BLACK, 3, 3);

        // Test all directions (northeast, southeast, southwest, northwest)
        assertAll(
                () -> assertFalse(piece.canMoveTo(4, 2)),
                () -> assertFalse(piece.canMoveTo(4, 4)),
                () -> assertFalse(piece.canMoveTo(2, 4)),
                () -> assertFalse(piece.canMoveTo(2, 2))
        );
    }

    @Test
    public void Given_SingleKnight_When_MoveToOffBoard_Should_NotBeValid() {
        Board board = new Board();
        Piece piece = new Knight(new Board(), Colour.BLACK, 3, 3);

        // Test each side of board at first position out of bounds
        assertAll(
                () -> assertFalse(piece.canMoveTo(-1, 3)),
                () -> assertFalse(piece.canMoveTo(board.getXDimension(), 3)),
                () -> assertFalse(piece.canMoveTo(3, -1)),
                () -> assertFalse(piece.canMoveTo(3, board.getYDimension()))
        );
    }
}
