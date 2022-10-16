package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;



class PokemonTest {
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
    void getNameTest() {
        assertEquals(Victini.getName(), "Victini");
        assertEquals(Pangoro.getName(), "Pangoro");
        assertEquals(Zapdos.getName(), "Zapdos");
        assertEquals(Swampert.getName(), "Swampert");
        assertEquals(Kartana.getName(), "Kartana");
        assertEquals(Blissey.getName(), "Blissey");
        assertEquals(Dragapult.getName(), "Dragapult");
        assertEquals(Aerodactyl.getName(), "Aerodactyl");
        assertEquals(Primarina.getName(), "Primarina");
    }

    @Test
    void getFactsVictiniTest() {
        String facts = "Name: " + "Victini" + "\n" + "HP: "  + 341   + "\n"
                + "Attack: " + 236 + "\n" + "Defense: " + 236 + "\n"
                + "Special Attack: " + 236 + "\n" + "Special Defense: " + 236 + "\n"
                + "Speed: " + 236 + "\n" + "Type: " + "Fire" + ", " + "Psychic" + "\n"
                + "Moves: " + "Blue Flare"+ ", " + "Zen Headbutt" + ", " + "Bolt Strike"+ ", " + "Energy Ball";
        assertEquals(facts, Victini.getFacts());                                      //This test method checks
        Victini.setPokemonCurrentHP(Victini.getPokemonHP());                          //Everything that the pokemon
        assertEquals(341, Victini.getPokemonHP());                            //Class has to offer, and is done
        assertEquals(341, Victini.getPokemonCurrentHP());                     //Through the getFacts() test,
        assertEquals(236, Victini.getPokemonAttack());                        //The rest of these tests are just
        assertEquals(236, Victini.getPokemonDefense());                       //For code coverage, and for the
        assertEquals(236, Victini.getPokemonSpecialAttack());                 //Purpose of time, im just using
        assertEquals(236, Victini.getPokemonSpecialDefense());                //Victini complete the coverage
        assertEquals(236, Victini.getPokemonSpeed());
        assertEquals("Blue Flare", Victini.getPokemonMoves().getMoveName(0));
        Victini.setPokemonCurrentAttack(Victini.getPokemonAttack());
        Victini.setPokemonCurrentSpecialAttack(Victini.getPokemonSpecialAttack());
        Victini.setPokemonCurrentSpecialDefense(Victini.getPokemonSpecialDefense());
        assertEquals(236, Victini.getPokemonCurrentAttack(), Victini.getPokemonCurrentSpecialAttack());
        assertEquals(236, Victini.getPokemonCurrentSpecialDefense());
    }

    @Test
    void getFactsPangoroTest() {
        String facts = "Name: " + "Pangoro" + "\n" + "HP: "  + 331   + "\n"
                + "Attack: " + 284 + "\n"  + "Defense: " + 192 + "\n"
                + "Special Attack: " + 174 + "\n" + "Special Defense: " + 178 + "\n"
                + "Speed: " + 152 + "\n" + "Type: " + "Fighting" + ", " + "Dark" + "\n"
                + "Moves: " + "Close Combat"+ ", " + "Darkest Lariat" + ", " + "Thunder Punch"+ ", " + "Swords Dance";
        assertEquals(facts, Pangoro.getFacts());
    }

    @Test
    void getFactsZapdosTest() {
        String facts = "Name: " + "Zapdos" + "\n"
                + "HP: "  + 321   + "\n"
                + "Attack: " + 216 + "\n"
                + "Defense: " + 206 + "\n"
                + "Special Attack: " + 286 + "\n"
                + "Special Defense: " + 216 + "\n"
                + "Speed: " + 236 + "\n"
                + "Type: " + "Electric" + ", " + "Flying" + "\n"
                + "Moves: " + "Thunderbolt"+ ", " + "Hurricane" + ", " + "Heat Wave"+ ", " + "Roost";
        assertEquals(facts, Zapdos.getFacts());
    }

    @Test
    void getFactsSwampertTest() {
        String facts = "Name: " + "Swampert" + "\n"
                + "HP: "  + 341   + "\n"
                + "Attack: " + 256 + "\n"
                + "Defense: " + 216 + "\n"
                + "Special Attack: " + 206 + "\n"
                + "Special Defense: " + 216 + "\n"
                + "Speed: " + 156 + "\n"
                + "Type: " + "Water" + ", " + "Ground" + "\n"
                + "Moves: " + "Liquidation"+ ", " + "Earthquake" + ", " + "Stone Edge"+ ", " + "Ice Punch";

        assertEquals(facts, Swampert.getFacts());
    }

    @Test
    void getFactsKartanaTest() {
        String facts = "Name: " + "Kartana" + "\n"
                + "HP: "  + 256   + "\n"
                + "Attack: " + 398 + "\n"
                + "Defense: " + 298 + "\n"
                + "Special Attack: " + 154 + "\n"
                + "Special Defense: " + 99 + "\n"
                + "Speed: " + 254 + "\n"
                + "Type: " + "Grass" + ", " + "Steel" + "\n"
                + "Moves: " + "Leaf Blade"+ ", " + "Smart Strike" + ", " + "Sacred Sword"+ ", " + "Swords Dance";

        assertEquals(facts, Kartana.getFacts());
    }

    @Test
    void getFactDragapultTest() {
        String facts = "Name: " + "Dragapult" + "\n"
                + "HP: "  + 317   + "\n"
                + "Attack: " + 276 + "\n"
                + "Defense: " + 186 + "\n"
                + "Special Attack: " + 236 + "\n"
                + "Special Defense: " + 186 + "\n"
                + "Speed: " + 320 + "\n"
                + "Type: " + "Ghost" + ", " + "Dragon" + "\n"
                + "Moves: " + "Shadow Ball"+ ", " + "Dragon Pulse" + ", " + "Flamethrower"+ ", " + "Hydro Pump";

        assertEquals(facts, Dragapult.getFacts());
    }

    @Test
    void getFactBlisseyTest() {
        String facts = "Name: " + "Blissey" + "\n"
                + "HP: "  + 651   + "\n"
                + "Attack: " + 56 + "\n"
                + "Defense: " + 56 + "\n"
                + "Special Attack: " + 186 + "\n"
                + "Special Defense: " + 306 + "\n"
                + "Speed: " + 146 + "\n"
                + "Type: " + "Normal" + ", " + "null" + "\n"
                + "Moves: " + "Seismic Toss"+ ", " + "Soft Boiled" + ", " + "Thunderbolt"+ ", " + "Thunder Wave";

        assertEquals(facts, Blissey.getFacts());
    }

    @Test
    void getFactAerodactylTest() {
        String facts = "Name: " + "Aerodactyl" + "\n"
                + "HP: "  + 301   + "\n"
                + "Attack: " + 246 + "\n"
                + "Defense: " + 166 + "\n"
                + "Special Attack: " + 156 + "\n"
                + "Special Defense: " + 186 + "\n"
                + "Speed: " + 296 + "\n"
                + "Type: " + "Rock" + ", " + "Flying" + "\n"
                + "Moves: " + "Stone Edge"+ ", " + "Wing Attack" + ", " + "Earthquake"+ ", " + "Roost";

        assertEquals(facts, Aerodactyl.getFacts());
    }

    @Test
    void getFactPrimarinaTest() {
        String facts = "Name: " + "Primarina" + "\n"
                + "HP: "  + 301   + "\n"
                + "Attack: " + 184 + "\n"
                + "Defense: " + 184 + "\n"
                + "Special Attack: " + 288 + "\n"
                + "Special Defense: " + 268 + "\n"
                + "Speed: " + 156 + "\n"
                + "Type: " + "Water" + ", " + "Fairy" + "\n"
                + "Moves: " + "Moonblast"+ ", " + "Hydro Pump" + ", " + "Energy Ball"+ ", " + "Calm Mind";

        assertEquals(facts, Primarina.getFacts());
    }


    @Test
    void getTypeTest() {
        String[] victiniType = {"Fire", "Psychic"};
        assertArrayEquals(Victini.getType(), victiniType);
        String[] pangoroType = {"Fighting", "Dark"};
        assertArrayEquals(Pangoro.getType(), pangoroType);
        String[] zapdosType = {"Electric", "Flying"};
        assertArrayEquals(Zapdos.getType(), zapdosType);
        String[] swampertType = {"Water", "Ground"};
        assertArrayEquals(Swampert.getType(), swampertType);
        String[] kartanaType = {"Grass", "Steel"};
        assertArrayEquals(Kartana.getType(), kartanaType);
        String[] blisseyType = {"Normal", "null"};
        assertArrayEquals(Blissey.getType(), blisseyType);
        String[] dragapultType = {"Ghost", "Dragon"};
        assertArrayEquals(Dragapult.getType(), dragapultType);
        String[] aerodactylType = {"Rock", "Flying"};
        assertArrayEquals(Aerodactyl.getType(), aerodactylType);
        String[] primarinaType = {"Water", "Fairy"};
        assertArrayEquals(Primarina.getType(), primarinaType);

    }
}