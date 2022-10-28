package persistence;
//most of this code is credited to UBC's CPSC 210 class example code

import model.Pokemon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;


class JsonWriterTest {

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
    void testWriterInvalidFile() {
        try {
            Pokemon[] list = new Pokemon[3];
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            //pass
        }
    }

    @Test
    void testWriterList() {
        try {
            JsonWriter writer = new JsonWriter("./data/testWritingThings.json");
            writer.open();
            writer.write(list2, list3, list2[1], list3[0]);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWritingThings.json");
            Pokemon[] testList2 = reader.readOurPokemon();
            assertEquals(list2[0].getSaveFacts(), testList2[0].getSaveFacts());
            assertEquals(list2[1].getSaveFacts(), testList2[1].getSaveFacts());
            assertEquals(list2[2].getSaveFacts(), testList2[2].getSaveFacts());
        } catch (IOException e) {
            fail("Expectation should not have been thrown");
        }
    }
}