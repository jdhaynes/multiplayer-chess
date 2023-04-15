package jackhaynes.chess.core;

import jackhaynes.chess.core.pieces.Piece;

public class Move {
    private Piece piece;

    private int fromX;
    private int fromY;
    private int toX;
    private int toY;

    public Move(Piece piece, int fromX, int fromY, int toX, int toY) {
        this.piece = piece;
        this.fromX = fromX;
        this.fromY = fromY;
        this.toX = toX;
        this.toY = toY;
    }

    public MoveDirection getDirection() {
        throw new UnsupportedOperationException();
    }

    public int getSteps() {
        throw new UnsupportedOperationException();
    }
 }
