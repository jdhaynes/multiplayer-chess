package jackhaynes.chess.core;

public abstract class Piece {
    protected final Board board;
    protected final Colour colour;

    protected int x;
    protected int y;
    protected boolean hasMoved;

    public Piece(Board board, Colour colour, int x, int y) {
        this.board = board;
        this.colour = colour;
        this.x = x;
        this.y = y;
        this.hasMoved = false;
    }

    public abstract boolean canPerformMove(Move move);

    public void move(int toX, int toY) {
        if(this.board.positionIsWithinBoard(toX, toY)) {
            this.x = toX;
            this.y = toY;
            this.hasMoved = true;
        }
    }

    public Colour getColour() {
        return this.colour;
    }

    public Board getBoard() { return this.board; }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public boolean hasMoved() { return this.hasMoved; }
}
