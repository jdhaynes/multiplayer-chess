package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.Board;
import jackhaynes.chess.core.Move;
import jackhaynes.chess.core.Piece;
import jackhaynes.chess.core.Colour;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {
    @Test
    public void Given_SinglePawn_When_MoveForwardOneOrTwoSteps_Should_BeValidMove() {
        Piece piece = new Pawn(new Board(), Colour.BLACK, 2, 2);
        assertAll(
                () -> assertTrue(piece.canPerformMove(new Move(piece, 2, 3))),
                () -> assertTrue(piece.canPerformMove(new Move(piece, 2, 4)))
        );
    }

    @Test
    public void Given_SinglePawn_When_MoveForwardThreeSteps_Should_NotBeValidMove() {
        Piece piece = new Pawn(new Board(), Colour.BLACK, 2, 2);
        assertFalse(piece.canPerformMove(new Move(piece, 2, 5)));
    }

    @Test
    public void Given_SinglePawn_When_MoveSideways_Should_NotBeValidMove() {
        Piece piece = new Pawn(new Board(), Colour.BLACK, 2, 2);
        assertAll(
                () -> assertFalse(piece.canPerformMove(new Move(piece, 1, 2))),
                () -> assertFalse(piece.canPerformMove(new Move(piece, 3, 2)))
        );
    }

    @Test
    public void Given_SinglePawn_When_MoveDiagonal_Should_NotBeValidMove() {
        Piece piece = new Pawn(new Board(), Colour.BLACK, 3, 3);

        // Test all directions (northeast, southeast, southwest, northwest)
        assertAll(
                () -> assertFalse(piece.canPerformMove(new Move(piece, 4, 2))),
                () -> assertFalse(piece.canPerformMove(new Move(piece, 4, 4))),
                () -> assertFalse(piece.canPerformMove(new Move(piece, 2, 4))),
                () -> assertFalse(piece.canPerformMove(new Move(piece, 2, 2)))
        );
    }

    @Test
    public void Given_SinglePawn_When_MoveToOffBoard_Should_NotBeValid() {
        Board board = new Board();
        Piece piece = new Pawn(new Board(), Colour.BLACK, 3, 3);

        // Test each side of board at first position out of bounds
        assertAll(
                () -> assertFalse(piece.canPerformMove(new Move(piece, -1, 3))),
                () -> assertFalse(piece.canPerformMove(new Move(piece, board.getXDimension(), 3))),
                () -> assertFalse(piece.canPerformMove(new Move(piece, 3, -1))),
                () -> assertFalse(piece.canPerformMove(new Move(piece, 3, board.getYDimension())))
        );
    }
}
