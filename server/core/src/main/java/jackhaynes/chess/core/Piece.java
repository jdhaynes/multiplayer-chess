package jackhaynes.chess.core;

public abstract class Piece {
    protected final Board board;
    protected final PieceColour colour;

    protected int x;
    protected int y;
    protected boolean hasMoved;

    public Piece(Board board, PieceColour colour, int x, int y) {
        this.board = board;
        this.colour = colour;
        this.x = x;
        this.y = y;
        this.hasMoved = false;
    }

    public abstract PieceType getType();
    public abstract boolean canMoveTo(int toX, int toY);

    public void move(int toX, int toY) {
        if(!this.board.positionIsWithinBoard(toX, toY)) {
            this.x = toX;
            this.y = toY;
            this.hasMoved = true;
        }
    }

    public PieceColour getColour() {
        return this.colour;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
