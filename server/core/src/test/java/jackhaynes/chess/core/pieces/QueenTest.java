package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.Board;
import jackhaynes.chess.core.Move;
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
                () -> assertTrue(piece.canPerformMove(new Move(piece, 2, 3))),
                () -> assertTrue(piece.canPerformMove(new Move(piece, 4, 3))),
                () -> assertTrue(piece.canPerformMove(new Move(piece, 3, 2))),
                () -> assertTrue(piece.canPerformMove(new Move(piece, 3, 4)))
        );
    }

    @Test
    public void Given_SingleQueen_When_MoveDiagonalOneStep_Should_BeValid() {
        Piece piece = new Queen(new Board(), Colour.BLACK, 3, 3);

        // Test all directions (northeast, southeast, southwest, northwest)
        assertAll(
                () -> assertTrue(piece.canPerformMove(new Move(piece, 4, 2))),
                () -> assertTrue(piece.canPerformMove(new Move(piece, 4, 4))),
                () -> assertTrue(piece.canPerformMove(new Move(piece, 2, 4))),
                () -> assertTrue(piece.canPerformMove(new Move(piece, 2, 2)))
        );
    }

    @Test
    public void Given_SingleQueen_When_MoveMoreThanOneStep_Should_BeValid() {
        Piece piece = new Queen(new Board(), Colour.BLACK, 3, 3);

        // Test both straight and diagonal steps
        assertAll(
                () -> assertTrue(piece.canPerformMove(new Move(piece, 1, 3))),
                () -> assertTrue(piece.canPerformMove(new Move(piece, 6, 3))),
                () -> assertTrue(piece.canPerformMove(new Move(piece, 3, 5))),
                () -> assertTrue(piece.canPerformMove(new Move(piece, 1, 3)))
        );
    }

    @Test
    public void Given_SingleQueen_When_MoveToOffBoard_Should_NotBeValid() {
        Board board = new Board();
        Piece piece = new Queen(new Board(), Colour.BLACK, 3, 3);

        // Test each side of board at first position out of bounds
        assertAll(
                () -> assertFalse(piece.canPerformMove(new Move(piece, -1, 3))),
                () -> assertFalse(piece.canPerformMove(new Move(piece, board.getXDimension(), 3))),
                () -> assertFalse(piece.canPerformMove(new Move(piece, 3, -1))),
                () -> assertFalse(piece.canPerformMove(new Move(piece, 3, board.getYDimension())))
        );
    }
}
