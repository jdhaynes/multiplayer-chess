package jackhaynes.chess.core;

public class Game {
    private Board board;
    private GameStatus status;
    private Colour currentPlayer;

    public Game() {
        this.board = new Board();
    }

    protected Game(Board board) {
        this.board = board;
    }

    public void initialise() {
        this.board.initialise();
        this.status = GameStatus.ACTIVE;
        this.currentPlayer = Colour.WHITE;
    }

    public boolean playerMove(Colour playerColour, int fromX, int toX, int fromY, int toY) {
        if(playerColour != this.currentPlayer || this.status != GameStatus.ACTIVE) {
            return false;
        }

        Piece targetPiece = this.board.getPiece(fromX, fromY);
        if(targetPiece == null || targetPiece.getColour() == playerColour) {
            return false;
        }

        return true;
    }
}
