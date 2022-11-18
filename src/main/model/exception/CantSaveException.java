package model.exception;

public class CantSaveException extends Exception {
    public CantSaveException() {
    }

    public CantSaveException(String msg) {
        super(msg);
    }


}
