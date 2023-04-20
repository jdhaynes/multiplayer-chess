package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.Board;
import jackhaynes.chess.core.Piece;
import jackhaynes.chess.core.Colour;
import jackhaynes.chess.core.PieceType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PawnTest {
    @Test
    public void Given_NewPiece_When_GetType_Should_BePawn() {
        Piece piece = new Pawn(new Board(), Colour.BLACK, 2, 2);
        assertEquals(PieceType.PAWN, piece.getType());
    }

    @Test
    public void Given_SinglePawn_When_MoveForwardOneOrTwoSteps_Should_BeValidMove() {
        Piece piece = new Pawn(new Board(), Colour.BLACK, 2, 2);
        assertAll(
                () -> assertTrue(piece.canMoveTo(2, 3)),
                () -> assertTrue(piece.canMoveTo(2, 4))
        );
    }

    @Test
    public void Given_SinglePawn_When_MoveForwardThreeSteps_Should_NotBeValidMove() {
        Piece piece = new Pawn(new Board(), Colour.BLACK, 2, 2);
        assertFalse(piece.canMoveTo(2, 5));
    }

    @Test
    public void Given_SinglePawn_When_MoveSideways_Should_NotBeValidMove() {
        Piece piece = new Pawn(new Board(), Colour.BLACK, 2, 2);
        assertAll(
                () -> assertFalse(piece.canMoveTo(1, 2)),
                () -> assertFalse(piece.canMoveTo(3, 2))
        );
    }

    @Test
    public void Given_SinglePawn_When_MoveDiagonal_Should_NotBeValidMove() {
        Piece piece = new Pawn(new Board(), Colour.BLACK, 3, 3);

        // Test all directions (northeast, southeast, southwest, northwest)
        assertAll(
                () -> assertFalse(piece.canMoveTo(4, 2)),
                () -> assertFalse(piece.canMoveTo(4, 4)),
                () -> assertFalse(piece.canMoveTo(2, 4)),
                () -> assertFalse(piece.canMoveTo(2, 2))
        );
    }

    @Test
    public void Given_SinglePawn_When_MoveToOffBoard_Should_NotBeValid() {
        Board board = new Board();
        Piece piece = new Pawn(new Board(), Colour.BLACK, 3, 3);

        // Test each side of board at first position out of bounds
        assertAll(
                () -> assertFalse(piece.canMoveTo(-1, 3)),
                () -> assertFalse(piece.canMoveTo(board.getXDimension(), 3)),
                () -> assertFalse(piece.canMoveTo(3, -1)),
                () -> assertFalse(piece.canMoveTo(3, board.getYDimension()))
        );
    }
}
