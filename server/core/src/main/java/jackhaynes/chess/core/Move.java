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

        calculateVector();
    }

    public MoveType getType() {
        return this.type;
    }

    public int getSteps() {
        return this.steps;
    }

    private void calculateVector() {
        int deltaX = Math.abs(fromX - toX);
        int deltaY = Math.abs(fromY - toY);

        if(deltaX == 0 && deltaY == 0) {
            this.type = MoveType.STATIC;
            this.steps = 0;
            return;
        }

        if(deltaX == 0 || deltaY == 0) {
            this.type = MoveType.STRAIGHT;
            this.steps = Math.max(deltaX, deltaY);
        } else {
            if(deltaX == deltaY) {
                this.type = MoveType.VALID_DIAGONAL;
                this.steps = deltaX; // This will be equal to deltaY for valid diag - can use either.
            } else {
                this.type = MoveType.INVALID_DIAGONAL;
                this.steps = 0;
            }
        }
    }
 }
