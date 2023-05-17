package jackhaynes.chess.core.exceptions;

public class MoveNotAllowedException extends Exception {
    public MoveNotAllowedException(String errorMessage) {
        super(errorMessage);
    }
}
