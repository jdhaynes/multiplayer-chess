package jackhaynes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {
    @Test
    public void Given_NewBoard_When_Instantiate_Should_HaveNoPieces() {
        Board board = new Board();

        for(int i = 0; i < Board.Y_DIMENSION; i++) {
            for(int j = 0; j < Board.X_DIMENSION; j++) {
                assertNull(board.pieceAt(j, i));
            }
        }
    }
}