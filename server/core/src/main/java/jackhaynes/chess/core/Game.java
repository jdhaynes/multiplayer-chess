package jackhaynes.chess.core;

import jackhaynes.chess.core.exceptions.MoveNotAllowedException;

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

    public void playerMove(Colour playerColour, int fromX, int toX, int fromY, int toY)
            throws MoveNotAllowedException {
        if(this.status != GameStatus.ACTIVE) { throw new MoveNotAllowedException("The game is not active."); }
        if(playerColour != this.currentPlayer) { throw new MoveNotAllowedException("It is not your turn."); }

        Piece targetPiece = this.board.getPiece(fromX, fromY);

        if(targetPiece == null) { throw new MoveNotAllowedException("There is no piece at the specified position."); }
        if(targetPiece.getColour() != playerColour) { throw new MoveNotAllowedException("You do not own this piece."); }

        this.board.movePiece(targetPiece, toX, toY);

        this.switchPlayer();
    }

    private void switchPlayer() {
        this.currentPlayer = (this.currentPlayer == Colour.WHITE) ? Colour.BLACK : Colour.WHITE;
    }
}
