package model.exception;

public class WrongPokemonException extends Exception {
    public WrongPokemonException() {
    }

    public WrongPokemonException(String msg) {
        super(msg);
    }


}
