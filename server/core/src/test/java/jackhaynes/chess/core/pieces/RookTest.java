package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.Board;
import jackhaynes.chess.core.Move;
import jackhaynes.chess.core.Piece;
import jackhaynes.chess.core.Colour;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RookTest {
    @Test
    public void Given_SingleRook_When_MoveStraightMultipleStepsToEdge_Should_BeValidMove() {
        Board board = new Board();
        Piece piece = new Rook(board, Colour.BLACK, 3, 3);

        assertAll(
                () -> assertTrue(piece.canPerformMove(new Move(piece, 0, 3))),
                () -> assertTrue(piece.canPerformMove(new Move(piece, board.getXDimension() - 1, 3))),
                () -> assertTrue(piece.canPerformMove(new Move(piece, 3, 0))),
                () -> assertTrue(piece.canPerformMove(new Move(piece, 3, board.getYDimension() - 1)))
        );
    }

    @Test
    public void Given_SingleRook_When_MoveStraightOffBoard_Should_NotBeValidMove() {
        Board board = new Board();
        Piece piece = new Rook(board, Colour.BLACK, 3, 3);

        assertAll(
                () -> assertFalse(piece.canPerformMove(new Move(piece, -1, 3))),
                () -> assertFalse(piece.canPerformMove(new Move(piece, board.getXDimension(), 3))),
                () -> assertFalse(piece.canPerformMove(new Move(piece, 3, -1))),
                () -> assertFalse(piece.canPerformMove(new Move(piece, 3, board.getYDimension())))
        );
    }

    @Test
    public void Given_SingleRook_When_MoveDiagonal_Should_NotBeValidMove() {
        Board board = new Board();
        Piece piece = new Rook(board, Colour.BLACK, 3, 3);

        assertAll(
                () -> assertFalse(piece.canPerformMove(new Move(piece, 4, 2))),
                () -> assertFalse(piece.canPerformMove(new Move(piece, 4, 4))),
                () -> assertFalse(piece.canPerformMove(new Move(piece, 2, 4))),
                () -> assertFalse(piece.canPerformMove(new Move(piece, 2, 2)))

        );
    }
}
