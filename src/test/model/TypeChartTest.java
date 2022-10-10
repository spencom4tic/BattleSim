package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.SQLOutput;

import static org.junit.jupiter.api.Assertions.*;

public class TypeChartTest {
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
        assertEquals(1, TypeChart.TypeChart("Normal", Victini.getType()));
        assertEquals(1, TypeChart.TypeChart("Normal", Pangoro.getType()));
        assertEquals(1, TypeChart.TypeChart("Normal", Zapdos.getType()));
        assertEquals(1, TypeChart.TypeChart("Normal", Swampert.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Normal", Kartana.getType()));
        assertEquals(1, TypeChart.TypeChart("Normal", Blissey.getType()));
        assertEquals(0, TypeChart.TypeChart("Normal", Dragapult.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Normal", Aerodactyl.getType()));
        assertEquals(1, TypeChart.TypeChart("Normal", Primarina.getType()));
    }

    @Test
    void electricMove() {
        assertEquals(1, TypeChart.TypeChart("Electric", Victini.getType()));
        assertEquals(1, TypeChart.TypeChart("Electric", Pangoro.getType()));
        assertEquals(1, TypeChart.TypeChart("Electric", Zapdos.getType()));
        assertEquals(0, TypeChart.TypeChart("Electric", Swampert.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Electric", Kartana.getType()));
        assertEquals(1, TypeChart.TypeChart("Electric", Blissey.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Electric", Dragapult.getType()));
        assertEquals(2, TypeChart.TypeChart("Electric", Aerodactyl.getType()));
        assertEquals(2, TypeChart.TypeChart("Electric", Primarina.getType()));
    }

    @Test
    void waterMove() {
        assertEquals(2, TypeChart.TypeChart("Water", Victini.getType()));
        assertEquals(1, TypeChart.TypeChart("Water", Pangoro.getType()));
        assertEquals(1, TypeChart.TypeChart("Water", Zapdos.getType()));
        assertEquals(1, TypeChart.TypeChart("Water", Swampert.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Water", Kartana.getType()));
        assertEquals(1, TypeChart.TypeChart("Water", Blissey.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Water", Dragapult.getType()));
        assertEquals(2, TypeChart.TypeChart("Water", Aerodactyl.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Water", Primarina.getType()));
    }

    @Test
    void fireMove() {
        assertEquals(0.5, TypeChart.TypeChart("Fire", Victini.getType()));
        assertEquals(1, TypeChart.TypeChart("Fire", Pangoro.getType()));
        assertEquals(1, TypeChart.TypeChart("Fire", Zapdos.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Fire", Swampert.getType()));
        assertEquals(4, TypeChart.TypeChart("Fire", Kartana.getType()));
        assertEquals(1, TypeChart.TypeChart("Fire", Blissey.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Fire", Dragapult.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Fire", Aerodactyl.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Fire", Primarina.getType()));
    }

    @Test
    void grassMove() {
        assertEquals(0.5, TypeChart.TypeChart("Grass", Victini.getType()));
        assertEquals(1, TypeChart.TypeChart("Grass", Pangoro.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Grass", Zapdos.getType()));
        assertEquals(4, TypeChart.TypeChart("Grass", Swampert.getType()));
        assertEquals(0.25, TypeChart.TypeChart("Grass", Kartana.getType()));
        assertEquals(1, TypeChart.TypeChart("Grass", Blissey.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Grass", Dragapult.getType()));
        assertEquals(1, TypeChart.TypeChart("Grass", Aerodactyl.getType()));
        assertEquals(2, TypeChart.TypeChart("Grass", Primarina.getType()));
    }

    @Test
    void groundMove() {
        assertEquals(2, TypeChart.TypeChart("Ground", Victini.getType()));
        assertEquals(1, TypeChart.TypeChart("Ground", Pangoro.getType()));
        assertEquals(0, TypeChart.TypeChart("Ground", Zapdos.getType()));
        assertEquals(1, TypeChart.TypeChart("Ground", Swampert.getType()));
        assertEquals(1, TypeChart.TypeChart("Ground", Kartana.getType()));
        assertEquals(1, TypeChart.TypeChart("Ground", Blissey.getType()));
        assertEquals(1, TypeChart.TypeChart("Ground", Dragapult.getType()));
        assertEquals(0, TypeChart.TypeChart("Ground", Aerodactyl.getType()));
        assertEquals(1, TypeChart.TypeChart("Ground", Primarina.getType()));
    }

    @Test
    void rockMove() {
        assertEquals(2, TypeChart.TypeChart("Rock", Victini.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Rock", Pangoro.getType()));
        assertEquals(2, TypeChart.TypeChart("Rock", Zapdos.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Rock", Swampert.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Rock", Kartana.getType()));
        assertEquals(1, TypeChart.TypeChart("Rock", Blissey.getType()));
        assertEquals(1, TypeChart.TypeChart("Rock", Dragapult.getType()));
        assertEquals(2, TypeChart.TypeChart("Rock", Aerodactyl.getType()));
        assertEquals(1, TypeChart.TypeChart("Rock", Primarina.getType()));
    }

    @Test
    void flyingMove() {
        assertEquals(1, TypeChart.TypeChart("Flying", Victini.getType()));
        assertEquals(2, TypeChart.TypeChart("Flying", Pangoro.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Flying", Zapdos.getType()));
        assertEquals(1, TypeChart.TypeChart("Flying", Swampert.getType()));
        assertEquals(1, TypeChart.TypeChart("Flyinh", Kartana.getType()));
        assertEquals(1, TypeChart.TypeChart("Flying", Blissey.getType()));
        assertEquals(1, TypeChart.TypeChart("Flying", Dragapult.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Flying", Aerodactyl.getType()));
        assertEquals(1, TypeChart.TypeChart("Flying", Primarina.getType()));
    }

    @Test
    void dragonMove() {
        assertEquals(1, TypeChart.TypeChart("Dragon", Victini.getType()));
        assertEquals(1, TypeChart.TypeChart("Dragon", Pangoro.getType()));
        assertEquals(1, TypeChart.TypeChart("Dragon", Zapdos.getType()));
        assertEquals(1, TypeChart.TypeChart("Dragon", Swampert.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Dragon", Kartana.getType()));
        assertEquals(1, TypeChart.TypeChart("Dragon", Blissey.getType()));
        assertEquals(2, TypeChart.TypeChart("Dragon", Dragapult.getType()));
        assertEquals(1, TypeChart.TypeChart("Dragon", Aerodactyl.getType()));
        assertEquals(0, TypeChart.TypeChart("Dragon", Primarina.getType()));
    }

    @Test
    void fairyMove() {
        assertEquals(0.5, TypeChart.TypeChart("Fairy", Victini.getType()));
        assertEquals(4, TypeChart.TypeChart("Fairy", Pangoro.getType()));
        assertEquals(1, TypeChart.TypeChart("Fairy", Zapdos.getType()));
        assertEquals(1, TypeChart.TypeChart("Fairy", Swampert.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Fairy", Kartana.getType()));
        assertEquals(1, TypeChart.TypeChart("Fairy", Blissey.getType()));
        assertEquals(2, TypeChart.TypeChart("Fairy", Dragapult.getType()));
        assertEquals(1, TypeChart.TypeChart("Fairy", Aerodactyl.getType()));
        assertEquals(1, TypeChart.TypeChart("Fairy", Primarina.getType()));
    }

    @Test
    void steelMove() {
        assertEquals(0.5, TypeChart.TypeChart("Steel", Victini.getType()));
        assertEquals(1, TypeChart.TypeChart("Steel", Pangoro.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Steel", Zapdos.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Steel", Swampert.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Steel", Kartana.getType()));
        assertEquals(1, TypeChart.TypeChart("Steel", Blissey.getType()));
        assertEquals(1, TypeChart.TypeChart("Steel", Dragapult.getType()));
        assertEquals(2, TypeChart.TypeChart("Steel", Aerodactyl.getType()));
        assertEquals(1, TypeChart.TypeChart("Steel", Primarina.getType()));
    }

    @Test
    void psychicMove() {
        assertEquals(0.5, TypeChart.TypeChart("Psychic", Victini.getType()));
        assertEquals(0, TypeChart.TypeChart("Psychic", Pangoro.getType()));
        assertEquals(1, TypeChart.TypeChart("Psychic", Zapdos.getType()));
        assertEquals(1, TypeChart.TypeChart("Psychic", Swampert.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Psychic", Kartana.getType()));
        assertEquals(1, TypeChart.TypeChart("Psychic", Blissey.getType()));
        assertEquals(1, TypeChart.TypeChart("Psychic", Dragapult.getType()));
        assertEquals(1, TypeChart.TypeChart("Psychic", Aerodactyl.getType()));
        assertEquals(1, TypeChart.TypeChart("Psychic", Primarina.getType()));
    }

    @Test
    void darkMove() {
        assertEquals(2, TypeChart.TypeChart("Dark", Victini.getType()));
        assertEquals(0.25, TypeChart.TypeChart("Dark", Pangoro.getType()));
        assertEquals(1, TypeChart.TypeChart("Dark", Zapdos.getType()));
        assertEquals(1, TypeChart.TypeChart("Dark", Swampert.getType()));
        assertEquals(1, TypeChart.TypeChart("Dark", Kartana.getType()));
        assertEquals(1, TypeChart.TypeChart("Dark", Blissey.getType()));
        assertEquals(2, TypeChart.TypeChart("Dark", Dragapult.getType()));
        assertEquals(1, TypeChart.TypeChart("Dark", Aerodactyl.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Dark", Primarina.getType()));
    }

    @Test
    void fightingMove() {
        assertEquals(0.5, TypeChart.TypeChart("Fighting", Victini.getType()));
        assertEquals(2, TypeChart.TypeChart("Fighting", Pangoro.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Fighting", Zapdos.getType()));
        assertEquals(1, TypeChart.TypeChart("Fighting", Swampert.getType()));
        assertEquals(2, TypeChart.TypeChart("Fighting", Kartana.getType()));
        assertEquals(2, TypeChart.TypeChart("Fighting", Blissey.getType()));
        assertEquals(0, TypeChart.TypeChart("Fighting", Dragapult.getType()));
        assertEquals(1, TypeChart.TypeChart("Fighting", Aerodactyl.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Fighting", Primarina.getType()));
    }

    @Test
    void iceMove() {
        assertEquals(0.5, TypeChart.TypeChart("Ice", Victini.getType()));
        assertEquals(1, TypeChart.TypeChart("Ice", Pangoro.getType()));
        assertEquals(2, TypeChart.TypeChart("Ice", Zapdos.getType()));
        assertEquals(1, TypeChart.TypeChart("Ice", Swampert.getType()));
        assertEquals(1, TypeChart.TypeChart("Ice", Kartana.getType()));
        assertEquals(1, TypeChart.TypeChart("Ice", Blissey.getType()));
        assertEquals(2, TypeChart.TypeChart("Ice", Dragapult.getType()));
        assertEquals(2, TypeChart.TypeChart("Ice", Aerodactyl.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Ice", Primarina.getType()));
    }

    @Test
    void bugMove() {
        assertEquals(1, TypeChart.TypeChart("Bug", Victini.getType()));
        assertEquals(1, TypeChart.TypeChart("Bug", Pangoro.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Bug", Zapdos.getType()));
        assertEquals(1, TypeChart.TypeChart("Bug", Swampert.getType()));
        assertEquals(1, TypeChart.TypeChart("Bug", Kartana.getType()));
        assertEquals(1, TypeChart.TypeChart("Bug", Blissey.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Bug", Dragapult.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Bug", Aerodactyl.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Bug", Primarina.getType()));
    }

    @Test
    void ghostMove() {
        assertEquals(2, TypeChart.TypeChart("Ghost", Victini.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Ghost", Pangoro.getType()));
        assertEquals(1, TypeChart.TypeChart("Ghost", Zapdos.getType()));
        assertEquals(1, TypeChart.TypeChart("Ghost", Swampert.getType()));
        assertEquals(1, TypeChart.TypeChart("Ghost", Kartana.getType()));
        assertEquals(0, TypeChart.TypeChart("Ghost", Blissey.getType()));
        assertEquals(2, TypeChart.TypeChart("Ghost", Dragapult.getType()));
        assertEquals(1, TypeChart.TypeChart("Ghost", Aerodactyl.getType()));
        assertEquals(1, TypeChart.TypeChart("Ghost", Primarina.getType()));
    }

    @Test
    void poisonMove() {
        assertEquals(1, TypeChart.TypeChart("Poison", Victini.getType()));
        assertEquals(1, TypeChart.TypeChart("Poison", Pangoro.getType()));
        assertEquals(1, TypeChart.TypeChart("Poison", Zapdos.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Poison", Swampert.getType()));
        assertEquals(0, TypeChart.TypeChart("Poison", Kartana.getType()));
        assertEquals(1, TypeChart.TypeChart("Poison", Blissey.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Poison", Dragapult.getType()));
        assertEquals(0.5, TypeChart.TypeChart("Poison", Aerodactyl.getType()));
        assertEquals(2, TypeChart.TypeChart("Poison", Primarina.getType()));
    }
}
