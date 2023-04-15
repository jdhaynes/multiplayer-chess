package jackhaynes.chess.core.pieces;

import jackhaynes.chess.core.Board;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class KingTest {
    @Test
    public void Given_NewPiece_When_GetType_Should_BeKing() {
        Piece piece = new King(new Board(), PieceColour.BLACK);
        assertEquals(PieceType.KING, piece.getType());
    }

    @Test
    public void Given_HasBoardSpace_When_MoveOneHorizontally_Should_BeValid() {
        Piece piece = new King(new Board(), PieceColour.BLACK);
    }
}