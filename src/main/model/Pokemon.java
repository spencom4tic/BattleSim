package model;

import java.awt.image.AreaAveragingScaleFilter;
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
    private int pokemonCurrentHP;
    private int pokemonAttack;
    private int pokemonCurrentAttack;
    private int pokemonDefense;
    private int pokemonSpecialAttack;
    private int pokemonCurrentSpecialAttack;
    private int pokemonSpecialDefense;
    private int pokemonCurrentSpecialDefense;
    private int pokemonSpeed;
    private Moves pokemonMoves;
    private String[] pokemonType = new String[2];                  //Lists every possible attribute the pokemon needs

    //REQUIRES: A valid pokemon name
    public Pokemon(String name) {
        this.pokemonName = name;
    }       //Constructs the pokemon


    //EFFECTS: Redirects the code to give stats to the proper pokemon
    public void setupPokemon() {                                   //Since we have a finite amount of pokemon, we can
        if (this.pokemonName.equals("Victini")) {                  //create a method to give each of the 9 pokemon their
            giveVictiniStats();                                    //respective stats, moves, and types
        } else if (this.pokemonName.equals("Pangoro")) {
            givePangoroStats();
        } else if (this.pokemonName.equals("Zapdos")) {
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
        } else {                                                   //Primarina is the only option here as we have
            givePrimarinaStats();                                  //REQUIRED only valid pokemon in an above method
        }                                                          //Also git code coverage wants this to be else
                                                                   //Instead of else if
    }

    //MODIFIES: THIS
    //This applies to all 9 give_____Stats methods
    private void giveVictiniStats() {                         //The next couple of paragraphs are dedicated to attribute
        this.pokemonHP = this.pokemonCurrentHP = 341;         //initializing
        this.pokemonAttack = this.pokemonCurrentAttack = 236;
        this.pokemonDefense = 236;
        this.pokemonSpecialAttack = this.pokemonCurrentSpecialAttack = 236;
        this.pokemonSpecialDefense = this.pokemonCurrentSpecialDefense = 236;
        this.pokemonSpeed = 236;
        this.pokemonType[0] = "Fire";
        this.pokemonType[1] = "Psychic";
        this.pokemonMoves = new Moves("Victini");


    }

    private void givePangoroStats() {
        this.pokemonHP = this.pokemonCurrentHP = 331;
        this.pokemonAttack = this.pokemonCurrentAttack = 284;
        this.pokemonDefense = 192;
        this.pokemonSpecialAttack = this.pokemonCurrentSpecialAttack =  174;
        this.pokemonSpecialDefense = this.pokemonCurrentSpecialDefense = 178;
        this.pokemonSpeed = 152;
        this.pokemonType[0] = "Fighting";
        this.pokemonType[1] = "Dark";
        this.pokemonMoves = new Moves("Pangoro");
    }

    private void giveZapdosStats() {
        this.pokemonHP = this.pokemonCurrentHP = 321;
        this.pokemonAttack = this.pokemonCurrentAttack = 216;
        this.pokemonDefense = 206;
        this.pokemonSpecialAttack = this.pokemonCurrentSpecialAttack = 286;
        this.pokemonSpecialDefense = this.pokemonCurrentSpecialDefense = 216;
        this.pokemonSpeed = 236;
        this.pokemonType[0] = "Electric";
        this.pokemonType[1] = "Flying";
        this.pokemonMoves = new Moves("Zapdos");
    }

    private void giveSwampertStats() {
        this.pokemonHP = this.pokemonCurrentHP = 341;
        this.pokemonAttack = this.pokemonCurrentAttack = 256;
        this.pokemonDefense = 216;
        this.pokemonSpecialAttack = this.pokemonCurrentSpecialAttack = 206;
        this.pokemonSpecialDefense = this.pokemonCurrentSpecialDefense = 216;
        this.pokemonSpeed = 156;
        this.pokemonType[0] = "Water";
        this.pokemonType[1] = "Ground";
        this.pokemonMoves = new Moves("Swampert");
    }

    private void giveKartanaStats() {
        this.pokemonHP = this.pokemonCurrentHP = 256;
        this.pokemonAttack = this.pokemonCurrentAttack = 398;
        this.pokemonDefense = 298;
        this.pokemonSpecialAttack = this.pokemonCurrentSpecialAttack = 154;
        this.pokemonSpecialDefense = this.pokemonCurrentSpecialDefense = 99;
        this.pokemonSpeed = 254;
        this.pokemonType[0] = "Grass";
        this.pokemonType[1] = "Steel";
        this.pokemonMoves = new Moves("Kartana");
    }

    private void giveDragapultStats() {
        this.pokemonHP = this.pokemonCurrentHP = 317;
        this.pokemonAttack = this.pokemonCurrentAttack = 276;
        this.pokemonDefense = 186;
        this.pokemonSpecialAttack = this.pokemonCurrentSpecialAttack = 236;
        this.pokemonSpecialDefense = this.pokemonCurrentSpecialDefense = 186;
        this.pokemonSpeed = 320;
        this.pokemonType[0] = "Ghost";
        this.pokemonType[1] = "Dragon";
        this.pokemonMoves = new Moves("Dragapult");
    }

    private void giveBlisseyStats() {
        this.pokemonHP = this.pokemonCurrentHP = 651;
        this.pokemonAttack = this.pokemonCurrentAttack = 56;
        this.pokemonDefense = 56;
        this.pokemonSpecialAttack = this.pokemonCurrentSpecialAttack = 186;
        this.pokemonSpecialDefense = this.pokemonCurrentSpecialDefense = 306;
        this.pokemonSpeed = 146;
        this.pokemonType[0] = "Normal";
        this.pokemonType[1] = "null";
        this.pokemonMoves = new Moves("Blissey");
    }

    private void giveAerodactylStats() {
        this.pokemonHP = this.pokemonCurrentHP = 301;
        this.pokemonAttack = this.pokemonCurrentAttack = 246;
        this.pokemonDefense = 166;
        this.pokemonSpecialAttack = this.pokemonCurrentSpecialAttack = 156;
        this.pokemonSpecialDefense = this.pokemonCurrentSpecialDefense = 186;
        this.pokemonSpeed = 296;
        this.pokemonType[0] = "Rock";
        this.pokemonType[1] = "Flying";
        this.pokemonMoves = new Moves("Aerodactyl");
    }

    private void givePrimarinaStats() {
        this.pokemonHP = this.pokemonCurrentHP = 301;
        this.pokemonAttack = 184;
        this.pokemonDefense = 184;
        this.pokemonSpecialAttack = this.pokemonCurrentSpecialAttack = 288;
        this.pokemonSpecialDefense = this.pokemonCurrentSpecialDefense = 268;
        this.pokemonSpeed = 156;
        this.pokemonType[0] = "Water";
        this.pokemonType[1] = "Fairy";
        this.pokemonMoves = new Moves("Primarina");
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
                     + "Moves: " + this.pokemonMoves.getMoveName(0)
                     + ", " + this.pokemonMoves.getMoveName(1)
                     + ", " + this.pokemonMoves.getMoveName(2)
                     + ", " + this.pokemonMoves.getMoveName(3);
        return facts;
    }

    public String getSaveFacts() {
        String saveFacts = "Name: " + this.pokemonName + "\n"
                         + "Current HP: " + this.pokemonCurrentHP + "\n"
                         + "Current Attack: " + this.getPokemonCurrentAttack() + "\n"
                         + "Current Special Attack: " + this.getPokemonCurrentSpecialAttack() + "\n"
                         + "Current Special Defense: " + this.getPokemonCurrentSpecialDefense();
        return saveFacts;
    }
    public int getPokemonHP() {
        return this.pokemonHP;
    }

    public int getPokemonCurrentHP() {
        return this.pokemonCurrentHP;
    }

    public void setPokemonCurrentHP(int hp) {
        this.pokemonCurrentHP = hp;
    }

    public void setPokemonCurrentAttack(int atk) {
        this.pokemonCurrentAttack = atk;
    }

    public void setPokemonCurrentSpecialAttack(int spatk) {
        this.pokemonCurrentSpecialAttack = spatk;
    }

    public void setPokemonCurrentSpecialDefense(int spdef) {
        this.pokemonCurrentSpecialDefense = spdef;
    }

    public int getPokemonAttack() {
        return this.pokemonAttack;
    }

    public int getPokemonDefense() {
        return this.pokemonDefense;
    }

    public int getPokemonSpecialAttack() {
        return this.pokemonSpecialAttack;
    }

    public int getPokemonSpecialDefense() {
        return this.pokemonSpecialDefense;
    }

    public int getPokemonSpeed() {
        return this.pokemonSpeed;
    }

    public int getPokemonCurrentAttack() {
        return this.pokemonCurrentAttack;
    }

    public int getPokemonCurrentSpecialAttack() {
        return this.pokemonCurrentSpecialAttack;
    }

    public int getPokemonCurrentSpecialDefense() {
        return this.pokemonCurrentSpecialDefense;
    }

    //EFFECTS: gives the pokemons type
    public String[] getType() {                                 //While name is used to print name, and facts are used
        return this.pokemonType;                                //To verify the stats are correct, this is used to
    }                                                           //Figure out the type effectiveness, as well as STAB
                                                                //Which will be explained in the Moves class

    public Moves getPokemonMoves() {
        return this.pokemonMoves;
    }
}
