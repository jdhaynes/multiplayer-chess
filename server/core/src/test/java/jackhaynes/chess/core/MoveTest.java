package jackhaynes.chess.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveTest {
    private class PieceStub extends Piece {
        public PieceStub(Colour colour, int x, int y) {
            super(new Board(), colour, x, y);
        }

        @Override
        public boolean canMoveTo(int toX, int toY) {
            return false;
        }
    }

    @Test
    public void Given_MoveSamePosition_When_GetType_Should_BeStatic() {
        Move move = new Move(new PieceStub(Colour.BLACK, 4, 2), 4, 2);
        assertEquals(MoveType.STATIC, move.getType());
    }

    @Test
    public void Given_MoveHorizontally_When_GetType_Should_BeStraight() {
        Move leftMove = new Move(new PieceStub(Colour.BLACK, 4, 5),2, 5);
        Move rightMove = new Move(new PieceStub(Colour.BLACK, 4, 5), 5, 5);

        assertAll(
                () -> assertEquals(MoveType.STRAIGHT, leftMove.getType()),
                () -> assertEquals(MoveType.STRAIGHT, rightMove.getType())
        );
    }

    @Test
    public void Given_MoveVertically_When_GetType_Should_BeStraight() {
        Move upMove = new Move(new PieceStub(Colour.BLACK, 4, 6), 4, 4);
        Move downMove = new Move(new PieceStub(Colour.BLACK, 2, 3), 2, 4);

        assertAll(
                () -> assertEquals(MoveType.STRAIGHT, upMove.getType()),
                () -> assertEquals(MoveType.STRAIGHT, downMove.getType())
        );
    }

    @Test
    public void Given_Move45Degrees_When_GetType_Should_BeValidDiagonal() {

        // new PieceStub(3, 4)
        Move northEast = new Move(new PieceStub(Colour.BLACK, 3, 4), 5, 2);
        Move southEast = new Move(new PieceStub(Colour.BLACK, 3, 4), 5, 6);
        Move southWest = new Move(new PieceStub(Colour.BLACK, 3, 4), 1, 6);
        Move northWest = new Move(new PieceStub(Colour.BLACK, 3, 4), 1, 2);

        assertAll(
                () -> assertEquals(MoveType.SYMMETRICAL_DIAGONAL, northEast.getType()),
                () -> assertEquals(MoveType.SYMMETRICAL_DIAGONAL, southEast.getType()),
                () -> assertEquals(MoveType.SYMMETRICAL_DIAGONAL, southWest.getType()),
                () -> assertEquals(MoveType.SYMMETRICAL_DIAGONAL, northWest.getType())
        );
    }

    @Test
    public void Given_MoveNon45Degrees_When_GetType_Should_BeInvalidDiagonal() {
        Move longerHorizontal = new Move(new PieceStub(Colour.BLACK, 1, 2), 6, 3);
        Move longerVertical = new Move(new PieceStub(Colour.BLACK, 2, 1), 3, 6);

        assertAll(
                () -> assertEquals(MoveType.ASYMMETRICAL_DIAGONAL, longerHorizontal.getType()),
                () -> assertEquals(MoveType.ASYMMETRICAL_DIAGONAL, longerVertical.getType())
        );
    }

    @Test
    public void Given_HorizontalMove_When_GetSteps_Should_ReturnCorrectNumber() {
        Move leftOneMove = new Move(new PieceStub(Colour.BLACK, 4, 2), 3, 2);
        Move rightTwoMoves = new Move(new PieceStub(Colour.BLACK, 4, 2), 6, 2);

        assertAll(
                () -> assertEquals(1, leftOneMove.getSteps()),
                () -> assertEquals(2, rightTwoMoves.getSteps())
        );
    }

    @Test
    public void Given_VerticalMove_When_GetSteps_Should_ReturnCorrectNumber() {
        Move upOneMove = new Move(new PieceStub(Colour.BLACK, 2, 5), 2, 4);
        Move downTwoMoves = new Move(new PieceStub(Colour.BLACK, 2, 5), 2, 7);

        assertAll(
                () -> assertEquals(1, upOneMove.getSteps()),
                () -> assertEquals(2, downTwoMoves.getSteps())
        );
    }

    @Test
    public void Given_ValidDiagonalMove_When_GetSteps_Should_ReturnCorrectNumber() {
        Move northEast = new Move(new PieceStub(Colour.BLACK, 3, 4), 5, 2);
        Move southEast = new Move(new PieceStub(Colour.BLACK, 3, 4), 4, 5);
        Move southWest = new Move(new PieceStub(Colour.BLACK, 3, 4), 0, 7);
        Move northWest = new Move(new PieceStub(Colour.BLACK, 3, 4), 1, 2);

        assertAll(
                () -> assertEquals(2, northEast.getSteps()),
                () -> assertEquals(1, southEast.getSteps()),
                () -> assertEquals(3, southWest.getSteps()),
                () -> assertEquals(2, northWest.getSteps())
        );
    }

    @Test
    public void Given_Non45DegreeMove_When_GetSteps_Should_ReturnLargestSideSize() {
        Move longerHorizontal = new Move(new PieceStub(Colour.BLACK, 1, 2), 6, 3);
        Move longerVertical = new Move(new PieceStub(Colour.BLACK, 2, 1), 3, 6);

        assertAll(
                () -> assertEquals(5, longerHorizontal.getSteps()),
                () -> assertEquals(5, longerVertical.getSteps())
        );
    }

    @Test
    public void Given_BlackPiece_When_MoveVerticallyDown_Should_BeMovingForward() {
        Move move = new Move(new PieceStub(Colour.BLACK, 2, 2), 2, 3);
        assertEquals(MoveDirection.FORWARD, move.getDirection());
    }

    @Test
    public void Given_BlackPiece_When_MoveVerticallyUp_Should_BeMovingBackwards() {
        Move move = new Move(new PieceStub(Colour.BLACK, 2, 2), 2, 1);
        assertEquals(MoveDirection.BACKWARD, move.getDirection());
    }

    @Test
    public void Given_WhitePiece_When_MoveVerticallyUp_Should_BeMovingForward() {
        Move move = new Move(new PieceStub(Colour.WHITE, 2, 2), 2, 1);
        assertEquals(MoveDirection.FORWARD, move.getDirection());
    }

    @Test
    public void Given_WhitePiece_When_MoveVerticallyDown_Should_BeMovingBackwards() {
        Move move = new Move(new PieceStub(Colour.WHITE, 2, 2), 2, 3);
        assertEquals(MoveDirection.BACKWARD, move.getDirection());
    }
}
