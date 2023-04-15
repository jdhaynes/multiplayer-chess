package jackhaynes.chess.core;

public class Move {
    private final Piece piece;
    private final int fromX;
    private final int toX;
    private final int fromY;
    private final int toY;

    private MoveType type;
    private MoveDirection direction;
    private int steps;

    public Move(Piece piece, int toX, int toY) {
        this.piece = piece;
        this.fromX = piece.getX();
        this.toX = toX;
        this.fromY = piece.getY();
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
        int signedDeltaX = toX - fromX;
        int signedDeltaY = toY - fromY;

        // No movement
        if(signedDeltaX == 0 && signedDeltaY == 0) {
            this.type = MoveType.STATIC;
            this.direction = MoveDirection.STATIC;
            this.steps = 0;

            return;
        }

        // Horizontal straight movement
        if(signedDeltaY == 0) {
            this.type = MoveType.STRAIGHT;
            this.direction = MoveDirection.SIDE;
            this.steps = Math.abs(signedDeltaX);

            return;
        }

        // Has a component of vertical movement (either straight vertical, or diagonal)
        boolean isMovingForward = (this.piece.colour == PieceColour.BLACK && signedDeltaY > 0) ||
                (this.piece.colour == PieceColour.WHITE && signedDeltaY < 0);

        this.direction = isMovingForward ? MoveDirection.FORWARD : MoveDirection.BACKWARD;

        // Straight vertical movement
        if(signedDeltaX == 0) {
            this.type = MoveType.STRAIGHT;
            this.steps = Math.abs(signedDeltaY);

            return;
        }

        int deltaX = Math.abs(signedDeltaX);
        int deltaY = Math.abs(signedDeltaY);

        // Diagonal movement
        if(deltaX == deltaY) {
            this.type = MoveType.SYMMETRICAL_DIAGONAL;
            this.steps = deltaX; // This will be equal to deltaY for symmetrical diag - can use either.
        } else {
            this.type = MoveType.ASYMMETRICAL_DIAGONAL;
            this.steps = Math.max(deltaX, deltaY);
        }
    }
 }
