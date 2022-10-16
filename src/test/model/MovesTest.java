package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class MovesTest {
    Pokemon Victini;
    Pokemon Pangoro;
    Pokemon Zapdos;
    Pokemon Swampert;
    Pokemon Kartana;
    Pokemon Blissey;
    Pokemon Dragapult;
    Pokemon Aerodactyl;
    Pokemon Primarina;


    @BeforeEach
    void runBefore() {
        Victini = new Pokemon("Victini");
        Victini.setupPokemon();
        Pangoro = new Pokemon("Pangoro");
        Pangoro.setupPokemon();
        Zapdos = new Pokemon("Zapdos");
        Zapdos.setupPokemon();
        Swampert = new Pokemon("Swampert");
        Swampert.setupPokemon();
        Kartana = new Pokemon("Kartana");
        Kartana.setupPokemon();
        Blissey = new Pokemon("Blissey");
        Blissey.setupPokemon();
        Dragapult = new Pokemon("Dragapult");
        Dragapult.setupPokemon();
        Aerodactyl = new Pokemon("Aerodactyl");
        Aerodactyl.setupPokemon();
        Primarina = new Pokemon("Primarina");
        Primarina.setupPokemon();
    }

    @Test
    void test() {
        String testString = "Stone Edge"
                    + "  Power: " + 150.0
                    + ",  Accuracy: " + 80
                    + ",  Type: " + "Rock"
                    + ",  Properties: " + "Attack"
                    + ",  Damage Type: " + "Physical";
        assertEquals(Victini.getPokemonMoves().getMoveName(0),"Blue Flare");
        assertEquals(Pangoro.getPokemonMoves().getMoveAccuracy(2), 100);
        assertEquals(Zapdos.getPokemonMoves().getMoveType(1), "Flying");
        assertEquals(Kartana.getPokemonMoves().getMovePower(1), 105);
        assertEquals(Primarina.getPokemonMoves().getDamageType(2), "Special");
        assertEquals(Blissey.getPokemonMoves().getMoveProperties(1), "Heal");
        assertEquals(Aerodactyl.getPokemonMoves().getMove(0), testString);
    }
}