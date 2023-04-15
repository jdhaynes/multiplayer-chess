package jackhaynes.chess.core;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MoveTest {
    @Test
    public void Given_MoveSamePosition_When_GetType_Should_BeStatic() {
        Move move = new Move(4, 4, 2, 2);
        assertEquals(MoveType.STATIC, move.getType());
    }

    @Test
    public void Given_MoveHorizontally_When_GetType_Should_BeStraight() {
        Move leftMove = new Move(4, 2, 5, 5);
        Move rightMove = new Move(4, 5, 5, 5);

        assertAll(
                () -> assertEquals(MoveType.STRAIGHT, leftMove.getType()),
                () -> assertEquals(MoveType.STRAIGHT, rightMove.getType())
        );
    }

    @Test
    public void Given_MoveVertically_When_GetType_Should_BeStraight() {
        Move upMove = new Move(4, 4, 6, 4);
        Move downMove = new Move(2, 2, 3, 4);

        assertAll(
                () -> assertEquals(MoveType.STRAIGHT, upMove.getType()),
                () -> assertEquals(MoveType.STRAIGHT, downMove.getType())
        );
    }

    @Test
    public void Given_Move45Degrees_When_GetType_Should_BeValidDiagonal() {
        Move northEast = new Move(3, 5, 4, 2);
        Move southEast = new Move(3, 5, 4, 6);
        Move southWest = new Move(3, 1, 4, 6);
        Move northWest = new Move(3, 1, 4, 2);

        assertAll(
                () -> assertEquals(MoveType.VALID_DIAGONAL, northEast.getType()),
                () -> assertEquals(MoveType.VALID_DIAGONAL, southEast.getType()),
                () -> assertEquals(MoveType.VALID_DIAGONAL, southWest.getType()),
                () -> assertEquals(MoveType.VALID_DIAGONAL, northWest.getType())
        );
    }

    @Test
    public void Given_MoveNon45Degrees_When_GetType_Should_BeInvalidDiagonal() {
        Move longerHorizontal = new Move(1, 6, 2, 3);
        Move longerVertical = new Move(2, 3, 1, 6);

        assertAll(
                () -> assertEquals(MoveType.INVALID_DIAGONAL, longerHorizontal.getType()),
                () -> assertEquals(MoveType.INVALID_DIAGONAL, longerVertical.getType())
        );
    }

    @Test
    public void Given_HorizontalMove_When_GetSteps_Should_ReturnCorrectNumber() {
        Move leftOneMove = new Move(4, 3, 2, 2);
        Move rightTwoMoves = new Move(4, 6, 2, 2);

        assertAll(
                () -> assertEquals(1, leftOneMove.getSteps()),
                () -> assertEquals(2, rightTwoMoves.getSteps())
        );
    }

    @Test
    public void Given_VerticalMove_When_GetSteps_Should_ReturnCorrectNumber() {
        Move upOneMove = new Move(2, 2, 5, 4);
        Move downTwoMoves = new Move(2, 2, 5, 7);

        assertAll(
                () -> assertEquals(1, upOneMove.getSteps()),
                () -> assertEquals(2, downTwoMoves.getSteps())
        );
    }

    @Test
    public void Given_ValidDigagonalMove_When_GetSteps_Should_ReturnCorrectNumber() {
        Move northEast = new Move(3, 5, 4, 2);
        Move southEast = new Move(3, 4, 4, 5);
        Move southWest = new Move(3, 0, 4, 7);
        Move northWest = new Move(3, 1, 4, 2);

        assertAll(
                () -> assertEquals(2, northEast.getSteps()),
                () -> assertEquals(1, southEast.getSteps()),
                () -> assertEquals(3, southWest.getSteps()),
                () -> assertEquals(2, northWest.getSteps())
        );
    }
}
