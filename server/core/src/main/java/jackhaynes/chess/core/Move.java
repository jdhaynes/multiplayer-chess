package jackhaynes.chess.core;

public class Move {
    private int fromX;
    private int toX;
    private int fromY;
    private int toY;

    public Move(int fromX, int toX, int fromY, int toY) {
        this.fromX = fromX;
        this.toX = toX;
        this.fromY = fromY;
        this.toY = toY;
    }

    public MoveType getType() {
        if(fromX == toX && fromY == toY) {
            return MoveType.STATIC;
        }

        if(fromX == toX || fromY == toY) {
            return MoveType.STRAIGHT;
        } else {
            int deltaX = Math.abs(fromX - toX);
            int deltaY = Math.abs(fromY - toY);

            if(deltaX == deltaY) {
                return MoveType.VALID_DIAGONAL;
            } else {
                return MoveType.INVALID_DIAGONAL;
            }
        }
    }

    public int getSteps() {
        throw new UnsupportedOperationException();
    }
 }
