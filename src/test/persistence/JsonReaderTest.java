package persistence;

import model.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;


class JsonReaderTest {

    private Pokemon[] list1 = new Pokemon[2];
    private Pokemon[] list2;
    private Pokemon[] list3;
    private Pokemon pokemon1;

    @BeforeEach
    void runBefore() {
        Pokemon test1 = new Pokemon("Blissey");
        test1.setupPokemon();
        Pokemon test2 = new Pokemon("Zapdos");
        test2.setupPokemon();
        list1[0] = test1;
        list1[1] = test2;
        Pokemon test3 = new Pokemon("Dragapult");
        Pokemon test4 = new Pokemon("Pangoro");
        Pokemon test5 = new Pokemon("Aerodactyl");
        test3.setupPokemon();
        test4.setupPokemon();
        test5.setupPokemon();
        list2 = new Pokemon[]{test4, test2, test1};
        list3 = new Pokemon[]{test3, test5, test3};
    }

    @Test
    void testReaderNonExistentFile() {
        JsonReader reader = new JsonReader("./data/aegagaegweh.json");
        try {
            Pokemon[] list = reader.readOurPokemon();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
        try {
            Pokemon[] list = reader.readEnemyPokemon();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
        try {
            Pokemon pokemon = reader.readActivePokemon(list1);
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
        try {
            Pokemon pokemon = reader.readOpponentActivePokemon(list1);
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmpty() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyPokemon.json");
        try {
            list1 = reader.readOurPokemon();
            assertEquals(0, list1.length);
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
        try {
            list1 = reader.readEnemyPokemon();
            assertEquals(0, list1.length);
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testNullActivePokemon() {
        JsonReader reader = new JsonReader("./data/testReaderEmptyPokemon.json");
        try {
            pokemon1 = new Pokemon("Victini");
            pokemon1 = reader.readActivePokemon(list1);
            assertEquals(null, pokemon1);
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
        try {
            pokemon1 = new Pokemon("Victini");
            pokemon1 = reader.readOpponentActivePokemon(list1);
            assertEquals(null, pokemon1);
        } catch (IOException e) {
            fail("Could't read from file");
        }
    }

    @Test
    void testReaderGeneralActivePokemon() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralPokemon.json");
        try {
            pokemon1 = reader.readActivePokemon(list2);
            assertEquals(list2[0], pokemon1);
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
        try {
            pokemon1 = new Pokemon("Dragapult");
            pokemon1.setupPokemon();
            pokemon1 = reader.readOpponentActivePokemon(list3);
            assertEquals(list3[0], pokemon1);
        } catch (IOException e) {
            fail("Could't read from file");
        }
    }

    @Test
    void testReaderGeneralPokemon() {
        JsonReader reader = new JsonReader("./data/testReaderGeneralPokemon.json");
        try {
            Pokemon[] testList2 = reader.readOurPokemon();
            assertEquals(list2[0].getSaveFacts(), testList2[0].getSaveFacts());
            assertEquals(list2[1].getSaveFacts(), testList2[1].getSaveFacts());
            assertEquals(list2[2].getSaveFacts(), testList2[2].getSaveFacts());


        } catch (IOException e) {
            fail("Couldn't read from file");
        }
        try {
            Pokemon[] testList3 = reader.readEnemyPokemon();
            assertEquals(list3[0].getSaveFacts(), testList3[0].getSaveFacts());
            assertEquals(list3[1].getSaveFacts(), testList3[1].getSaveFacts());
            assertEquals(list3[2].getSaveFacts(), testList3[2].getSaveFacts());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}
