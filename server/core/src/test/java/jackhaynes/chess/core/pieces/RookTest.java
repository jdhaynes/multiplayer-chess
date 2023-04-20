package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.Board;
import jackhaynes.chess.core.Piece;
import jackhaynes.chess.core.Colour;
import jackhaynes.chess.core.PieceType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RookTest {
    @Test
    public void Given_NewPiece_When_GetType_Should_BeRook() {
        Piece piece = new Rook(new Board(), Colour.BLACK, 2, 2);
        assertEquals(PieceType.ROOK, piece.getType());
    }

    @Test
    public void Given_SingleRook_When_MoveStraightMultipleStepsToEdge_Should_BeValidMove() {
        Board board = new Board();
        Piece piece = new Rook(board, Colour.BLACK, 3, 3);

        assertAll(
                () -> assertTrue(piece.canMoveTo(0, 3)),
                () -> assertTrue(piece.canMoveTo(board.getXDimension() - 1, 3)),
                () -> assertTrue(piece.canMoveTo(3, 0)),
                () -> assertTrue(piece.canMoveTo(3, board.getYDimension() - 1))
        );
    }

    @Test
    public void Given_SingleRook_When_MoveStraightOffBoard_Should_NotBeValidMove() {
        Board board = new Board();
        Piece piece = new Rook(board, Colour.BLACK, 3, 3);

        assertAll(
                () -> assertFalse(piece.canMoveTo(-1, 3)),
                () -> assertFalse(piece.canMoveTo(board.getXDimension(), 3)),
                () -> assertFalse(piece.canMoveTo(3, -1)),
                () -> assertFalse(piece.canMoveTo(3, board.getYDimension()))
        );
    }

    @Test
    public void Given_SingleRook_When_MoveDiagonal_Should_NotBeValidMove() {
        Board board = new Board();
        Piece piece = new Rook(board, Colour.BLACK, 3, 3);

        assertAll(
                () -> assertFalse(piece.canMoveTo(4, 2)),
                () -> assertFalse(piece.canMoveTo(4, 4)),
                () -> assertFalse(piece.canMoveTo(2, 4)),
                () -> assertFalse(piece.canMoveTo(2, 2))

        );
    }
}
