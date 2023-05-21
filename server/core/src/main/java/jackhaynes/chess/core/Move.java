package jackhaynes.chess.core;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class Move {
    private final Piece piece;
    private final int fromX;
    private final int toX;
    private final int fromY;
    private final int toY;

    private MoveType type;
    private MoveDirection direction;
    private int steps;

    private List<Piece> blockingPieces;

    public Move(Piece piece, int toX, int toY) {
        this.piece = piece;
        this.fromX = piece.getX();
        this.toX = toX;
        this.fromY = piece.getY();
        this.toY = toY;
        this.blockingPieces = new ArrayList<Piece>();

        calculateMove();
    }

    public MoveType getType() {
        return this.type;
    }

    public MoveDirection getDirection() { return this.direction; }

    public int getSteps() {
        return this.steps;
    }

    public boolean isBlockedByPiece() {
        return this.blockingPieces.size() > 0;
    }

    private List<Piece> getStraightMoveBlockingPieces(int signedDeltaX, int signedDeltaY) {
        List<Piece> blockingPieces = new ArrayList<Piece>();

        int deltaX = Math.abs(signedDeltaX);
        int deltaY = Math.abs(signedDeltaY);

        boolean isHorizontal = deltaY == 0;
        boolean isPositiveDirection = signedDeltaX > 0 || signedDeltaY > 0;

        int movementStep = isPositiveDirection ? 1 : -1;
        for(int i = 0; i < (isHorizontal ? signedDeltaX : signedDeltaY); i += movementStep) {
            int x = fromX + (isHorizontal ? i : 0);
            int y = fromY + (isHorizontal ? 0 : i);

            Piece piece = this.piece.getBoard().getPiece(x, y);

            if(piece != null && piece != this.piece) {
                blockingPieces.add(piece);
            }
        }

        return blockingPieces;
    }

    private List<Piece> getDiagonalMoveBlockingPieces(int signedDeltaX, int signedDeltaY) {
        List<Piece> blockingPieces = new ArrayList<Piece>();

        int deltaX = Math.abs(signedDeltaX);
        int deltaY = Math.abs(signedDeltaY);

        int x = this.fromX;
        int y = this.fromY;

        while(x < this.toX && y < this.toY) {
            x += signedDeltaX > 0 ? 1 : -1;
            y += signedDeltaY > 0 ? 1 : -1;

            Piece piece = this.piece.getBoard().getPiece(x, y);

            if(piece != null && piece != this.piece) {
                blockingPieces.add(piece);
            }
        }

        return blockingPieces;
    }

    private void calculateMove() {
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
            this.blockingPieces = getStraightMoveBlockingPieces(signedDeltaX, signedDeltaY);

            return;
        }

        // Has a component of vertical movement (either straight vertical, or diagonal)
        boolean isMovingForward = (this.piece.colour == Colour.BLACK && signedDeltaY > 0) ||
        (this.piece.colour == Colour.WHITE && signedDeltaY < 0);

        this.direction = isMovingForward ? MoveDirection.FORWARD : MoveDirection.BACKWARD;

        // Straight vertical movement
        if(signedDeltaX == 0) {
            this.type = MoveType.STRAIGHT;
            this.steps = Math.abs(signedDeltaY);
            this.blockingPieces = getStraightMoveBlockingPieces(signedDeltaX, signedDeltaY);

            return;
        }

        int deltaX = Math.abs(signedDeltaX);
        int deltaY = Math.abs(signedDeltaY);

        // Diagonal movement
        if(deltaX == deltaY) {
            this.type = MoveType.SYMMETRICAL_DIAGONAL;
            this.steps = deltaX; // This will be equal to deltaY for symmetrical diag - can use either.
            this.blockingPieces = getDiagonalMoveBlockingPieces(signedDeltaX, signedDeltaY);
        } else {
            this.type = MoveType.ASYMMETRICAL_DIAGONAL;
            this.steps = Math.max(deltaX, deltaY);
            this.blockingPieces = new ArrayList<Piece>();
        }
    }

    public int getToX() {
        return toX;
    }

    public int getToY() {
        return toY;
    }
}
