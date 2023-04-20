package jackhaynes.chess.core;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private final int EXPECTED_X_DIM = 8;
    private final int EXPECTED_Y_DIM = 8;

    private class PieceStub extends Piece {
        public PieceStub(Board board, Colour colour, int x, int y) {
            super(board, colour, x, y);
        }

        @Override
        public boolean canMoveTo(int x, int y) {
            return false;
        }
    }

    @Test
    public void Given_NewBoard_When_Instantiate_Should_HaveNoPieces() {
        Board board = new Board();

        for (int i = 0; i < EXPECTED_X_DIM; i++) {
            for (int j = 0; j < EXPECTED_X_DIM; j++) {
                assertNull(board.getPiece(j, i));
            }
        }
    }

    @Test
    public void Given_PlacedPiece_When_GetPieceAtPos_Should_ReturnCorrectPiece() {
        Board board = new Board();

        Piece piece = new PieceStub(board, Colour.BLACK, 4, 5);
        board.placePiece(piece);

        Assertions.assertEquals(piece, board.getPiece(4, 5));
    }

    @Test
    public void Given_PiecesPlacedOutsideBoard_When_GetPieces_Should_ReturnNulls() {
        Board board = new Board();

        // Test covers pieces placed left, right, above and below board.
        Piece leftPiece = new PieceStub(board, Colour.BLACK, -1, EXPECTED_Y_DIM / 2);
        Piece rightPiece = new PieceStub(board, Colour.BLACK, EXPECTED_X_DIM, EXPECTED_Y_DIM / 2);
        Piece topPiece = new PieceStub(board, Colour.BLACK, EXPECTED_X_DIM / 2, -1);
        Piece bottomPiece = new PieceStub(board, Colour.BLACK, EXPECTED_X_DIM / 2, EXPECTED_Y_DIM);

        board.placePiece(leftPiece);
        board.placePiece(rightPiece);
        board.placePiece(topPiece);
        board.placePiece(bottomPiece);

        assertAll(
                () -> assertNull(board.getPiece(-1, EXPECTED_Y_DIM / 2)),
                () -> assertNull(board.getPiece(EXPECTED_X_DIM, EXPECTED_Y_DIM / 2)),
                () -> assertNull(board.getPiece(EXPECTED_X_DIM / 2, -1)),
                () -> assertNull(board.getPiece(EXPECTED_X_DIM / 2, EXPECTED_Y_DIM))
        );
    }

    @Test
    public void Given_EmptyBoard_When_GetDimensions_Should_BeCorrectSize() {
        Board board = new Board();

        assertAll(
                () -> assertEquals(EXPECTED_X_DIM, board.getXDimension()),
                () -> assertEquals(EXPECTED_Y_DIM, board.getYDimension())
        );
    }

    @Test
    public void Given_PlacedPiece_When_RemovePiece_Should_RemoveFromBoard() {
        Board board = new Board();

        board.placePiece(new PieceStub(board, Colour.BLACK, 3, 4));
        board.removePiece(3, 4);

        assertNull(board.getPiece(3, 4));
    }
}