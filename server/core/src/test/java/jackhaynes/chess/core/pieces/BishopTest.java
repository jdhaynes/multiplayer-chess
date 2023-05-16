package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.Board;
import jackhaynes.chess.core.Move;
import jackhaynes.chess.core.Piece;
import jackhaynes.chess.core.Colour;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BishopTest {
    @Test
    public void Given_SingleBishop_When_MoveDiagonal_Should_BeValid() {
        Piece piece = new Bishop(new Board(), Colour.BLACK, 3, 3);

        // Test all directions (northeast, southeast, southwest, northwest)
        assertAll(
                () -> assertTrue(piece.canPerformMove(new Move(piece, 4, 2))),
                () -> assertTrue(piece.canPerformMove(new Move(piece, 4, 4))),
                () -> assertTrue(piece.canPerformMove(new Move(piece, 2, 4))),
                () -> assertTrue(piece.canPerformMove(new Move(piece, 2, 2)))
        );
    }

    @Test
    public void Given_SingleBishop_When_MoveStraight_Should_NotBeValid() {
        Piece piece = new Bishop(new Board(), Colour.BLACK, 3, 3);

        // Test all directions (up, down, left, right)
        assertAll(
                () -> assertFalse(piece.canPerformMove(new Move(piece, 2, 3))),
                () -> assertFalse(piece.canPerformMove(new Move(piece, 4, 3))),
                () -> assertFalse(piece.canPerformMove(new Move(piece, 3, 2))),
                () -> assertFalse(piece.canPerformMove(new Move(piece, 3, 4)))
        );
    }

    @Test
    public void Given_SingleBishop_When_MoveMoreThanOneStep_Should_BeValid() {
        Piece piece = new Bishop(new Board(), Colour.BLACK, 3, 3);

        assertAll(
                () -> assertTrue(piece.canPerformMove(new Move(piece, 6, 0))),
                () -> assertTrue(piece.canPerformMove(new Move(piece, 6, 6))),
                () -> assertTrue(piece.canPerformMove(new Move(piece, 0, 6))),
                () -> assertTrue(piece.canPerformMove(new Move(piece, 0, 0)))
        );
    }

    @Test
    public void Given_SingleBishop_When_MoveToOffBoardDiagonal_Should_NotBeValid() {
        Board board = new Board();
        Piece piece = new Bishop(new Board(), Colour.BLACK, 3, 3);

        // Test each side of board at first position out of bounds
        assertAll(
                () -> assertFalse(piece.canPerformMove(new Move(piece, 7, -1))),
                () -> assertFalse(piece.canPerformMove(new Move(piece, 8, 8))),
                () -> assertFalse(piece.canPerformMove(new Move(piece, -1, 7))),
                () -> assertFalse(piece.canPerformMove(new Move(piece, -1, -1)))
        );
    }
}
