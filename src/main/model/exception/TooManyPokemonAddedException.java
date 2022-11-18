package model.exception;

public class TooManyPokemonAddedException extends Exception {
    public TooManyPokemonAddedException() {
    }

    public TooManyPokemonAddedException(String msg) {
        super(msg);
    }


}
