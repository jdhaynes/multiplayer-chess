package jackhaynes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    private final int EXPECTED_X_DIM = 8;
    private final int EXPECTED_Y_DIM = 8;

    private class PieceStub extends Piece {
        @Override
        public PieceType getType() {
            return null;
        }
    }

    @Test
    public void Given_NewBoard_When_Instantiate_Should_HaveNoPieces() {
        Board board = new Board();

        for(int i = 0; i < EXPECTED_X_DIM; i++) {
            for(int j = 0; j < EXPECTED_X_DIM; j++) {
                assertNull(board.getPiece(j, i));
            }
        }
    }

    @Test
    public void Given_PlacedPiece_When_GetPieceAtPos_Should_ReturnCorrectPiece() {
        Board board = new Board();

        Piece piece = new PieceStub();
        board.placePiece(piece, 4, 5);

        assertEquals(piece, board.getPiece(4,5));
    }

    @Test
    public void Given_PiecesPlacedOutsideBoard_When_GetPieces_Should_ReturnNulls() {
        Board board = new Board();

        // Test covers pieces placed left, right, above and below board.
        Piece leftPiece = new PieceStub();
        Piece rightPiece = new PieceStub();
        Piece topPiece = new PieceStub();
        Piece bottomPiece = new PieceStub();

        board.placePiece(leftPiece, -1, EXPECTED_Y_DIM / 2);
        board.placePiece(rightPiece, EXPECTED_X_DIM, EXPECTED_Y_DIM / 2);
        board.placePiece(topPiece, EXPECTED_X_DIM / 2, -1);
        board.placePiece(bottomPiece, EXPECTED_X_DIM / 2, EXPECTED_Y_DIM);

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

        board.placePiece(new PieceStub(), 3, 4);
        board.removePiece(3, 4);

        assertNull(board.getPiece(3, 4));
    }
}