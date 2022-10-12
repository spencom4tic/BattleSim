package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;

public class TypeChartTest {
    TypeChart tc;
    String[] dummyMoves = {"Normal", "null"};
    double multiplier;
    Pokemon Victini;
    Pokemon Pangoro;
    Pokemon Zapdos;
    Pokemon Swampert;
    Pokemon Kartana;
    Pokemon Blissey;
    Pokemon Dragapult;
    Pokemon Aerodactyl;
    Pokemon Primarina;
    String[] coverageType1 = {"Poison", "Bug"};
    String[] coverageType2 = {"Ice", "null"};


    @BeforeEach
    void runBefore() {
        tc = new TypeChart();
        multiplier = tc.typeChart("Normal", dummyMoves);
        Victini = new Pokemon("Victini"); Victini.setupPokemon();
        Pangoro = new Pokemon("Pangoro"); Pangoro.setupPokemon();
        Zapdos = new Pokemon("Zapdos"); Zapdos.setupPokemon();
        Swampert = new Pokemon("Swampert"); Swampert.setupPokemon();
        Kartana = new Pokemon("Kartana"); Kartana.setupPokemon();
        Blissey = new Pokemon("Blissey"); Blissey.setupPokemon();
        Dragapult = new Pokemon("Dragapult"); Dragapult.setupPokemon();
        Aerodactyl = new Pokemon("Aerodactyl"); Aerodactyl.setupPokemon();
        Primarina = new Pokemon("Primarina"); Primarina.setupPokemon();
    }


    @Test
    void normalMove() {
        assertEquals(1, TypeChart.typeChart("Normal", Victini.getType()));
        assertEquals(1, TypeChart.typeChart("Normal", Pangoro.getType()));
        assertEquals(1, TypeChart.typeChart("Normal", Zapdos.getType()));
        assertEquals(1, TypeChart.typeChart("Normal", Swampert.getType()));
        assertEquals(0.5, TypeChart.typeChart("Normal", Kartana.getType()));
        assertEquals(1, TypeChart.typeChart("Normal", Blissey.getType()));
        assertEquals(0, TypeChart.typeChart("Normal", Dragapult.getType()));
        assertEquals(0.5, TypeChart.typeChart("Normal", Aerodactyl.getType()));
        assertEquals(1, TypeChart.typeChart("Normal", Primarina.getType()));
        assertEquals(1, TypeChart.typeChart("Normal", coverageType1));
        assertEquals(1, TypeChart.typeChart("Normal", coverageType2));
    }

    @Test
    void electricMove() {
        assertEquals(1, TypeChart.typeChart("Electric", Victini.getType()));
        assertEquals(1, TypeChart.typeChart("Electric", Pangoro.getType()));
        assertEquals(1, TypeChart.typeChart("Electric", Zapdos.getType()));
        assertEquals(0, TypeChart.typeChart("Electric", Swampert.getType()));
        assertEquals(0.5, TypeChart.typeChart("Electric", Kartana.getType()));
        assertEquals(1, TypeChart.typeChart("Electric", Blissey.getType()));
        assertEquals(0.5, TypeChart.typeChart("Electric", Dragapult.getType()));
        assertEquals(2, TypeChart.typeChart("Electric", Aerodactyl.getType()));
        assertEquals(2, TypeChart.typeChart("Electric", Primarina.getType()));
        assertEquals(1, TypeChart.typeChart("Electric", coverageType1));
        assertEquals(1, TypeChart.typeChart("Electric", coverageType2));
    }

    @Test
    void waterMove() {
        assertEquals(2, TypeChart.typeChart("Water", Victini.getType()));
        assertEquals(1, TypeChart.typeChart("Water", Pangoro.getType()));
        assertEquals(1, TypeChart.typeChart("Water", Zapdos.getType()));
        assertEquals(1, TypeChart.typeChart("Water", Swampert.getType()));
        assertEquals(0.5, TypeChart.typeChart("Water", Kartana.getType()));
        assertEquals(1, TypeChart.typeChart("Water", Blissey.getType()));
        assertEquals(0.5, TypeChart.typeChart("Water", Dragapult.getType()));
        assertEquals(2, TypeChart.typeChart("Water", Aerodactyl.getType()));
        assertEquals(0.5, TypeChart.typeChart("Water", Primarina.getType()));
        assertEquals(1, TypeChart.typeChart("Water", coverageType1));
        assertEquals(1, TypeChart.typeChart("Water", coverageType2));
    }

    @Test
    void fireMove() {
        assertEquals(0.5, TypeChart.typeChart("Fire", Victini.getType()));
        assertEquals(1, TypeChart.typeChart("Fire", Pangoro.getType()));
        assertEquals(1, TypeChart.typeChart("Fire", Zapdos.getType()));
        assertEquals(0.5, TypeChart.typeChart("Fire", Swampert.getType()));
        assertEquals(4, TypeChart.typeChart("Fire", Kartana.getType()));
        assertEquals(1, TypeChart.typeChart("Fire", Blissey.getType()));
        assertEquals(0.5, TypeChart.typeChart("Fire", Dragapult.getType()));
        assertEquals(0.5, TypeChart.typeChart("Fire", Aerodactyl.getType()));
        assertEquals(0.5, TypeChart.typeChart("Fire", Primarina.getType()));
        assertEquals(2, TypeChart.typeChart("Fire", coverageType1));
        assertEquals(2, TypeChart.typeChart("Fire", coverageType2));
    }

    @Test
    void grassMove() {
        assertEquals(0.5, TypeChart.typeChart("Grass", Victini.getType()));
        assertEquals(1, TypeChart.typeChart("Grass", Pangoro.getType()));
        assertEquals(0.5, TypeChart.typeChart("Grass", Zapdos.getType()));
        assertEquals(4, TypeChart.typeChart("Grass", Swampert.getType()));
        assertEquals(0.25, TypeChart.typeChart("Grass", Kartana.getType()));
        assertEquals(1, TypeChart.typeChart("Grass", Blissey.getType()));
        assertEquals(0.5, TypeChart.typeChart("Grass", Dragapult.getType()));
        assertEquals(1, TypeChart.typeChart("Grass", Aerodactyl.getType()));
        assertEquals(2, TypeChart.typeChart("Grass", Primarina.getType()));
        assertEquals(0.25, TypeChart.typeChart("Grass", coverageType1));
        assertEquals(1, TypeChart.typeChart("Grass", coverageType2));
    }

    @Test
    void groundMove() {
        assertEquals(2, TypeChart.typeChart("Ground", Victini.getType()));
        assertEquals(1, TypeChart.typeChart("Ground", Pangoro.getType()));
        assertEquals(0, TypeChart.typeChart("Ground", Zapdos.getType()));
        assertEquals(1, TypeChart.typeChart("Ground", Swampert.getType()));
        assertEquals(1, TypeChart.typeChart("Ground", Kartana.getType()));
        assertEquals(1, TypeChart.typeChart("Ground", Blissey.getType()));
        assertEquals(1, TypeChart.typeChart("Ground", Dragapult.getType()));
        assertEquals(0, TypeChart.typeChart("Ground", Aerodactyl.getType()));
        assertEquals(1, TypeChart.typeChart("Ground", Primarina.getType()));
        assertEquals(1, TypeChart.typeChart("Ground", coverageType1));
        assertEquals(1, TypeChart.typeChart("Ground", coverageType2));
    }

    @Test
    void rockMove() {
        assertEquals(2, TypeChart.typeChart("Rock", Victini.getType()));
        assertEquals(0.5, TypeChart.typeChart("Rock", Pangoro.getType()));
        assertEquals(2, TypeChart.typeChart("Rock", Zapdos.getType()));
        assertEquals(0.5, TypeChart.typeChart("Rock", Swampert.getType()));
        assertEquals(0.5, TypeChart.typeChart("Rock", Kartana.getType()));
        assertEquals(1, TypeChart.typeChart("Rock", Blissey.getType()));
        assertEquals(1, TypeChart.typeChart("Rock", Dragapult.getType()));
        assertEquals(2, TypeChart.typeChart("Rock", Aerodactyl.getType()));
        assertEquals(1, TypeChart.typeChart("Rock", Primarina.getType()));
        assertEquals(2, TypeChart.typeChart("Rock", coverageType1));
        assertEquals(2, TypeChart.typeChart("Rock", coverageType2));
    }

    @Test
    void flyingMove() {
        assertEquals(1, TypeChart.typeChart("Flying", Victini.getType()));
        assertEquals(2, TypeChart.typeChart("Flying", Pangoro.getType()));
        assertEquals(0.5, TypeChart.typeChart("Flying", Zapdos.getType()));
        assertEquals(1, TypeChart.typeChart("Flying", Swampert.getType()));
        assertEquals(1, TypeChart.typeChart("Flying", Kartana.getType()));
        assertEquals(1, TypeChart.typeChart("Flying", Blissey.getType()));
        assertEquals(1, TypeChart.typeChart("Flying", Dragapult.getType()));
        assertEquals(0.5, TypeChart.typeChart("Flying", Aerodactyl.getType()));
        assertEquals(1, TypeChart.typeChart("Flying", Primarina.getType()));
        assertEquals(2, TypeChart.typeChart("Flying", coverageType1));
        assertEquals(1, TypeChart.typeChart("Flying", coverageType2));
    }

    @Test
    void dragonMove() {
        assertEquals(1, TypeChart.typeChart("Dragon", Victini.getType()));
        assertEquals(1, TypeChart.typeChart("Dragon", Pangoro.getType()));
        assertEquals(1, TypeChart.typeChart("Dragon", Zapdos.getType()));
        assertEquals(1, TypeChart.typeChart("Dragon", Swampert.getType()));
        assertEquals(0.5, TypeChart.typeChart("Dragon", Kartana.getType()));
        assertEquals(1, TypeChart.typeChart("Dragon", Blissey.getType()));
        assertEquals(2, TypeChart.typeChart("Dragon", Dragapult.getType()));
        assertEquals(1, TypeChart.typeChart("Dragon", Aerodactyl.getType()));
        assertEquals(0, TypeChart.typeChart("Dragon", Primarina.getType()));
        assertEquals(1, TypeChart.typeChart("Dragon", coverageType1));
        assertEquals(1, TypeChart.typeChart("Dragon", coverageType2));
    }

    @Test
    void fairyMove() {
        assertEquals(0.5, TypeChart.typeChart("Fairy", Victini.getType()));
        assertEquals(4, TypeChart.typeChart("Fairy", Pangoro.getType()));
        assertEquals(1, TypeChart.typeChart("Fairy", Zapdos.getType()));
        assertEquals(1, TypeChart.typeChart("Fairy", Swampert.getType()));
        assertEquals(0.5, TypeChart.typeChart("Fairy", Kartana.getType()));
        assertEquals(1, TypeChart.typeChart("Fairy", Blissey.getType()));
        assertEquals(2, TypeChart.typeChart("Fairy", Dragapult.getType()));
        assertEquals(1, TypeChart.typeChart("Fairy", Aerodactyl.getType()));
        assertEquals(1, TypeChart.typeChart("Fairy", Primarina.getType()));
        assertEquals(0.5, TypeChart.typeChart("Fairy", coverageType1));
        assertEquals(1, TypeChart.typeChart("Fairy", coverageType2));
    }

    @Test
    void steelMove() {
        assertEquals(0.5, TypeChart.typeChart("Steel", Victini.getType()));
        assertEquals(1, TypeChart.typeChart("Steel", Pangoro.getType()));
        assertEquals(0.5, TypeChart.typeChart("Steel", Zapdos.getType()));
        assertEquals(0.5, TypeChart.typeChart("Steel", Swampert.getType()));
        assertEquals(0.5, TypeChart.typeChart("Steel", Kartana.getType()));
        assertEquals(1, TypeChart.typeChart("Steel", Blissey.getType()));
        assertEquals(1, TypeChart.typeChart("Steel", Dragapult.getType()));
        assertEquals(2, TypeChart.typeChart("Steel", Aerodactyl.getType()));
        assertEquals(1, TypeChart.typeChart("Steel", Primarina.getType()));
        assertEquals(1, TypeChart.typeChart("Steel", coverageType1));
        assertEquals(2, TypeChart.typeChart("Steel", coverageType2));
    }

    @Test
    void psychicMove() {
        assertEquals(0.5, TypeChart.typeChart("Psychic", Victini.getType()));
        assertEquals(0, TypeChart.typeChart("Psychic", Pangoro.getType()));
        assertEquals(1, TypeChart.typeChart("Psychic", Zapdos.getType()));
        assertEquals(1, TypeChart.typeChart("Psychic", Swampert.getType()));
        assertEquals(0.5, TypeChart.typeChart("Psychic", Kartana.getType()));
        assertEquals(1, TypeChart.typeChart("Psychic", Blissey.getType()));
        assertEquals(1, TypeChart.typeChart("Psychic", Dragapult.getType()));
        assertEquals(1, TypeChart.typeChart("Psychic", Aerodactyl.getType()));
        assertEquals(1, TypeChart.typeChart("Psychic", Primarina.getType()));
        assertEquals(2, TypeChart.typeChart("Psychic", coverageType1));
        assertEquals(1, TypeChart.typeChart("Psychic", coverageType2));
    }

    @Test
    void darkMove() {
        assertEquals(2, TypeChart.typeChart("Dark", Victini.getType()));
        assertEquals(0.25, TypeChart.typeChart("Dark", Pangoro.getType()));
        assertEquals(1, TypeChart.typeChart("Dark", Zapdos.getType()));
        assertEquals(1, TypeChart.typeChart("Dark", Swampert.getType()));
        assertEquals(1, TypeChart.typeChart("Dark", Kartana.getType()));
        assertEquals(1, TypeChart.typeChart("Dark", Blissey.getType()));
        assertEquals(2, TypeChart.typeChart("Dark", Dragapult.getType()));
        assertEquals(1, TypeChart.typeChart("Dark", Aerodactyl.getType()));
        assertEquals(0.5, TypeChart.typeChart("Dark", Primarina.getType()));
        assertEquals(1, TypeChart.typeChart("Dark", coverageType1));
        assertEquals(1, TypeChart.typeChart("Dark", coverageType2));
    }

    @Test
    void fightingMove() {
        assertEquals(0.5, TypeChart.typeChart("Fighting", Victini.getType()));
        assertEquals(2, TypeChart.typeChart("Fighting", Pangoro.getType()));
        assertEquals(0.5, TypeChart.typeChart("Fighting", Zapdos.getType()));
        assertEquals(1, TypeChart.typeChart("Fighting", Swampert.getType()));
        assertEquals(2, TypeChart.typeChart("Fighting", Kartana.getType()));
        assertEquals(2, TypeChart.typeChart("Fighting", Blissey.getType()));
        assertEquals(0, TypeChart.typeChart("Fighting", Dragapult.getType()));
        assertEquals(1, TypeChart.typeChart("Fighting", Aerodactyl.getType()));
        assertEquals(0.5, TypeChart.typeChart("Fighting", Primarina.getType()));
        assertEquals(0.25, TypeChart.typeChart("Fighting", coverageType1));
        assertEquals(2, TypeChart.typeChart("Fighting", coverageType2));
    }

    @Test
    void iceMove() {
        assertEquals(0.5, TypeChart.typeChart("Ice", Victini.getType()));
        assertEquals(1, TypeChart.typeChart("Ice", Pangoro.getType()));
        assertEquals(2, TypeChart.typeChart("Ice", Zapdos.getType()));
        assertEquals(1, TypeChart.typeChart("Ice", Swampert.getType()));
        assertEquals(1, TypeChart.typeChart("Ice", Kartana.getType()));
        assertEquals(1, TypeChart.typeChart("Ice", Blissey.getType()));
        assertEquals(2, TypeChart.typeChart("Ice", Dragapult.getType()));
        assertEquals(2, TypeChart.typeChart("Ice", Aerodactyl.getType()));
        assertEquals(0.5, TypeChart.typeChart("Ice", Primarina.getType()));
        assertEquals(1, TypeChart.typeChart("Ice", coverageType1));
        assertEquals(0.5, TypeChart.typeChart("Ice", coverageType2));
    }

    @Test
    void bugMove() {
        assertEquals(1, TypeChart.typeChart("Bug", Victini.getType()));
        assertEquals(1, TypeChart.typeChart("Bug", Pangoro.getType()));
        assertEquals(0.5, TypeChart.typeChart("Bug", Zapdos.getType()));
        assertEquals(1, TypeChart.typeChart("Bug", Swampert.getType()));
        assertEquals(1, TypeChart.typeChart("Bug", Kartana.getType()));
        assertEquals(1, TypeChart.typeChart("Bug", Blissey.getType()));
        assertEquals(0.5, TypeChart.typeChart("Bug", Dragapult.getType()));
        assertEquals(0.5, TypeChart.typeChart("Bug", Aerodactyl.getType()));
        assertEquals(0.5, TypeChart.typeChart("Bug", Primarina.getType()));
        assertEquals(0.5, TypeChart.typeChart("Bug", coverageType1));
        assertEquals(1, TypeChart.typeChart("Bug", coverageType2));
    }

    @Test
    void ghostMove() {
        assertEquals(2, TypeChart.typeChart("Ghost", Victini.getType()));
        assertEquals(0.5, TypeChart.typeChart("Ghost", Pangoro.getType()));
        assertEquals(1, TypeChart.typeChart("Ghost", Zapdos.getType()));
        assertEquals(1, TypeChart.typeChart("Ghost", Swampert.getType()));
        assertEquals(1, TypeChart.typeChart("Ghost", Kartana.getType()));
        assertEquals(0, TypeChart.typeChart("Ghost", Blissey.getType()));
        assertEquals(2, TypeChart.typeChart("Ghost", Dragapult.getType()));
        assertEquals(1, TypeChart.typeChart("Ghost", Aerodactyl.getType()));
        assertEquals(1, TypeChart.typeChart("Ghost", Primarina.getType()));
        assertEquals(1, TypeChart.typeChart("Ghost", coverageType1));
        assertEquals(1, TypeChart.typeChart("Ghost", coverageType2));
    }

    @Test
    void poisonMove() {
        assertEquals(1, TypeChart.typeChart("Poison", Victini.getType()));
        assertEquals(1, TypeChart.typeChart("Poison", Pangoro.getType()));
        assertEquals(1, TypeChart.typeChart("Poison", Zapdos.getType()));
        assertEquals(0.5, TypeChart.typeChart("Poison", Swampert.getType()));
        assertEquals(0, TypeChart.typeChart("Poison", Kartana.getType()));
        assertEquals(1, TypeChart.typeChart("Poison", Blissey.getType()));
        assertEquals(0.5, TypeChart.typeChart("Poison", Dragapult.getType()));
        assertEquals(0.5, TypeChart.typeChart("Poison", Aerodactyl.getType()));
        assertEquals(2, TypeChart.typeChart("Poison", Primarina.getType()));
        assertEquals(0.5, TypeChart.typeChart("Poison", coverageType1));
        assertEquals(1, TypeChart.typeChart("Poison", coverageType2));
    }
}
