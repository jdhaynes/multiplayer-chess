package jackhaynes.chess.core;

public class Move {
    private final int fromX;
    private final int toX;
    private final int fromY;
    private final int toY;

    private MoveType type;
    private int steps;

    public Move(int fromX, int toX, int fromY, int toY) {
        this.fromX = fromX;
        this.toX = toX;
        this.fromY = fromY;
        this.toY = toY;
    }

    public MoveType getType() {
        if(type != null) {
            return this.type;
        }

        if(fromX == toX && fromY == toY) {
            return MoveType.STATIC;
        }

        if(this.fromX == toX || fromY == toY) {
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
        if(getType() == MoveType.STRAIGHT) {
            int deltaX = Math.abs(this.fromX - this.toX);
            int deltaY = Math.abs(this.fromY - this.toY);

            return(Math.max(deltaX, deltaY));
        }

        return 0;
    }
 }
