package model;

import java.util.ArrayList;
import java.util.List;

public class Pokemon {

    //Variables
    //HP              - Changing          DONE
    //Attack          - Changing          DONE
    //Defense         - Changing          DONE
    //Special Attack  - Changing          DONE
    //Special Defense - Changing          DONE
    //Type            - Static            DONE
    //Name            - Static            DONE
    //Sprite          - Static            NOT DONE



    private String pokemonName;
    private int pokemonHP;
    private int pokemonAttack;
    private int pokemonDefense;
    private int pokemonSpecialAttack;
    private int pokemonSpecialDefense;
    private int pokemonSpeed;
    private String move1;
    private String move2;
    private String move3;
    private String move4;
    private String[] pokemonType = new String[2];                  //Lists every possible attribute the pokemon needs

    //REQUIRES: A valid pokemon name
    public Pokemon(String name) {
        this.pokemonName = name;
    }       //Constructs the pokemon


    //EFFECTS: Redirects the code to give stats to the proper pokemon
    public void setupPokemon() {                                   //Since we have a finite amount of pokemon, we can
        if (this.pokemonName.equals("Victini")) {                  //create a method to give each of the 9 pokemon their
            giveVictiniStats();                                    //respective stats, moves, and types
        } else if (this.pokemonName.equals("Pangoro")) {           //I have tried a switch case here and it does not
            givePangoroStats();                                    //Seem to work when using it the same way as
        } else if (this.pokemonName.equals("Zapdos")) {            //the TypeChart switch method
            giveZapdosStats();
        } else if (this.pokemonName.equals("Kartana")) {
            giveKartanaStats();
        } else if (this.pokemonName.equals("Swampert")) {
            giveSwampertStats();
        } else if (this.pokemonName.equals("Dragapult")) {
            giveDragapultStats();
        } else if (this.pokemonName.equals("Blissey")) {
            giveBlisseyStats();
        } else if (this.pokemonName.equals("Aerodactyl")) {
            giveAerodactylStats();
        } else if (this.pokemonName.equals("Primarina")) {
            givePrimarinaStats();
        }

    }

    //MODIFIES: THIS
    //This applies to all 9 give_____Stats methods
    private void giveVictiniStats() {                         //The next couple of paragraphs are dedicated to attribute
        this.pokemonHP = 341;                                 //initializing
        this.pokemonAttack = 236;
        this.pokemonDefense = 236;
        this.pokemonSpecialAttack = 236;
        this.pokemonSpecialDefense = 236;
        this.pokemonSpeed = 236;
        this.pokemonType[0] = "Fire";
        this.pokemonType[1] = "Psychic";
        this.move1 = "Blue Flare";
        this.move2 = "Psychic";
        this.move3 = "Bolt Strike";
        this.move4 = "Energy Ball";
    }

    private void givePangoroStats() {
        this.pokemonHP = 331;
        this.pokemonAttack = 284;
        this.pokemonDefense = 192;
        this.pokemonSpecialAttack = 174;
        this.pokemonSpecialDefense = 178;
        this.pokemonSpeed = 152;
        this.pokemonType[0] = "Fighting";
        this.pokemonType[1] = "Dark";
        this.move1 = "Close Combat";
        this.move2 = "Darkest Lariat";
        this.move3 = "Thunder Punch";
        this.move4 = "Swords Dance";
    }

    private void giveZapdosStats() {
        this.pokemonHP = 321;
        this.pokemonAttack = 216;
        this.pokemonDefense = 206;
        this.pokemonSpecialAttack = 286;
        this.pokemonSpecialDefense = 216;
        this.pokemonSpeed = 236;
        this.pokemonType[0] = "Electric";
        this.pokemonType[1] = "Flying";
        this.move1 = "Thunderbolt";
        this.move2 = "Hurricane";
        this.move3 = "Heat Wave";
        this.move4 = "Roost";
    }

    private void giveSwampertStats() {
        this.pokemonHP = 341;
        this.pokemonAttack = 256;
        this.pokemonDefense = 216;
        this.pokemonSpecialAttack = 206;
        this.pokemonSpecialDefense = 216;
        this.pokemonSpeed = 156;
        this.pokemonType[0] = "Water";
        this.pokemonType[1] = "Ground";
        this.move1 = "Liquidation";
        this.move2 = "Earthquake";
        this.move3 = "Stone Edge";
        this.move4 = "Ice Punch";
    }

    private void giveKartanaStats() {
        this.pokemonHP = 256;
        this.pokemonAttack = 398;
        this.pokemonDefense = 298;
        this.pokemonSpecialAttack = 154;
        this.pokemonSpecialDefense = 99;
        this.pokemonSpeed = 254;
        this.pokemonType[0] = "Grass";
        this.pokemonType[1] = "Steel";
        this.move1 = "Leaf Blade";
        this.move2 = "Smart Strike";
        this.move3 = "Sacred Sword";
        this.move4 = "Swords Dance";
    }

    private void giveDragapultStats() {
        this.pokemonHP = 317;
        this.pokemonAttack = 276;
        this.pokemonDefense = 186;
        this.pokemonSpecialAttack = 236;
        this.pokemonSpecialDefense = 186;
        this.pokemonSpeed = 320;
        this.pokemonType[0] = "Ghost";
        this.pokemonType[1] = "Dragon";
        this.move1 = "Shadow Ball";
        this.move2 = "Dragon Pulse";
        this.move3 = "Flamethrower";
        this.move4 = "Hydro Pump";
    }

    private void giveBlisseyStats() {
        this.pokemonHP = 651;
        this.pokemonAttack = 56;
        this.pokemonDefense = 56;
        this.pokemonSpecialAttack = 186;
        this.pokemonSpecialDefense = 306;
        this.pokemonSpeed = 146;
        this.pokemonType[0] = "Normal";
        this.pokemonType[1] = "null";
        this.move1 = "Seismic Toss";
        this.move2 = "Soft Boiled";
        this.move3 = "Thunderbolt";
        this.move4 = "Thunder Wave";
    }

    private void giveAerodactylStats() {
        this.pokemonHP = 301;
        this.pokemonAttack = 246;
        this.pokemonDefense = 166;
        this.pokemonSpecialAttack = 156;
        this.pokemonSpecialDefense = 186;
        this.pokemonSpeed = 296;
        this.pokemonType[0] = "Rock";
        this.pokemonType[1] = "Flying";
        this.move1 = "Stone Edge";
        this.move2 = "Wing Attack";
        this.move3 = "Earthquake";
        this.move4 = "Roost";
    }

    private void givePrimarinaStats() {
        this.pokemonHP = 301;
        this.pokemonAttack = 184;
        this.pokemonDefense = 184;
        this.pokemonSpecialAttack = 288;
        this.pokemonSpecialDefense = 268;
        this.pokemonSpeed = 156;
        this.pokemonType[0] = "Water";
        this.pokemonType[1] = "Fairy";
        this.move1 = "Moonblast";
        this.move2 = "Hydro Pump";
        this.move3 = "Energy Ball";
        this.move4 = "Calm Mind";
    }


    //EFFECTS: gives the pokemons name
    public String getName() {
        return pokemonName;
    }

    //EFFECTS: gives the pokemons attributes
    public String getFacts() {
        String facts = "Name: " + this.pokemonName + "\n"
                     + "HP: "  + this.pokemonHP   + "\n"
                     + "Attack: " + this.pokemonAttack + "\n"
                     + "Defense: " + this.pokemonDefense + "\n"
                     + "Special Attack: " + this.pokemonSpecialAttack + "\n"
                     + "Special Defense: " + this.pokemonSpecialDefense + "\n"
                     + "Speed: " + this.pokemonSpeed + "\n"
                     + "Type: " + this.pokemonType[0] + ", " + this.pokemonType[1] + "\n"
                     + "Moves: " + this.move1 + ", " + this.move2 + ", " + this.move3 + ", " + this.move4;
        return facts;
    }

    //EFFECTS: gives the pokemons type
    public String[] getType() {                                 //While name is used to print name, and facts are used
        return this.pokemonType;                                //To verify the stats are correct, this is used to
    }                                                           //Figure out the type effectiveness, as well as STAB
                                                                //Which will be explained in the Moves class
}
