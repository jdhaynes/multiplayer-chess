package jackhaynes.pieces;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KingTest {

    @Test
    void Given_NewPiece_When_GetType_Should_BeKing() {
        Piece piece = new King(null);
        assertEquals(PieceType.KING, piece.getType());
    }

    @Test
    void Given_HasBoardSpace_When_MoveOneHorizontally_Should_BeValid() {
        Piece piece = new King(null);

    }
}