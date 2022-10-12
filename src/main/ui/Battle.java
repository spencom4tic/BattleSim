package ui;

import model.Pokemon;

import java.util.Scanner;
import java.util.Random;

//Battle Application
public class Battle {

    //Variables
    //Active Pokemon          - Changing
    //Party                   - Static once set            DONE
    //Opponent Active Pokemon - Changing
    //Opponent Party          - Static once set

    Random rand = new Random();
    Scanner userinput = new Scanner(System.in);
    private Pokemon activePokemon;                                    //Creates the pokemon that will be actice
    private Pokemon opponentActivePokemon;                            //Creates opponents active pokemon
    public static final int PARTY_NUMBER = 3;                         //We want 3 Pokemon Max
    private Pokemon[] listOfPokemon = new Pokemon[PARTY_NUMBER];      //Creates the party
    private Pokemon[] enemyPokemon = new Pokemon[PARTY_NUMBER];       //Creates enemy team party
    private final String[] acceptablePokemon = new String[]{          //Creates list of 9 acceptable pokemon we want
            "Victini",
            "Pangoro",
            "Zapdos",
            "Swampert",
            "Kartana",
            "Dragapult",
            "Blissey",
            "Aerodactyl",
            "Primarina" };


    // EFFECTS: Welcomes player
    // EFFECTS: runs the addPokemon application
    // EFFECTS: Starts the Battle
    public Battle() {
        System.out.println("");
        System.out.println("Welcome to the Pokemon Battle! Please choose 3 of the 9 listed pokemon! "
                + "Repeats are allowed.");
        for (int x = 0; x < acceptablePokemon.length; x++) {
            System.out.print(acceptablePokemon[x] + ", ");
        }
        System.out.println("");
        addPokemon();
        makeEnemyTeam();
        System.out.println("Press any key and return when you are ready to start!");
        String dummy = userinput.next();                                        //Forces user to enter input to continue
        startBattle();                                                          //Starts the battle
    }

    //MODIFIES: This
    //EFFECTS: Adds Pokemon to party
    private void addPokemon() {
        int numberOfChosenPokemon = 0;                                //Counter to give us exactly 3 pokemon
        while (numberOfChosenPokemon < PARTY_NUMBER) {                //Making sure we have 3 pokemon
            System.out.println("Please add a pokemon to your party!");
            String pokemon = verifyPokemon();                         //Makes sure the pokemon is one of the 9 given
            Pokemon choosingPokemon = new Pokemon(pokemon);           //Creates the pokemon
            setUpPokemon(choosingPokemon);                            //Calls to a method to give pokemon stats and type
            listOfPokemon[numberOfChosenPokemon] = choosingPokemon;   //Adds pokemon to list
            System.out.println(choosingPokemon.getName() + " has been added!");
            numberOfChosenPokemon++;                                  //Adds to the counter for max pokemon
        }

        System.out.println("\nYour party is ");
        for (int x = 0; x < PARTY_NUMBER; x++) {
            System.out.println(listOfPokemon[x].getFacts());       //Makes sure the party, names, and stats are correct

        }
    }

    //MODIFIES: THIS
    //EFFECTS: Returns a String of an acceptable pokemon name
    private String verifyPokemon() {
        boolean check = true;
        String pokemonName = "";
        while (check) {                             //Creates a loop that will only end when an acceptable name is given
            pokemonName = userinput.next();         //Input the pokemons name
            for (int x = 0; x < acceptablePokemon.length; x++) {  //Checks every acceptable pokemon name
                if (acceptablePokemon[x].equals(pokemonName)) {   //Checks to see if given name is correct
                    check = false;
                }
            }
            if (check) {
                System.out.println("You have entered the wrong name! Please look at the 9 options and"
                        + "choose one from there.");
            }
        }
        return pokemonName;
    }

    private void setUpPokemon(Pokemon choosingPokemon) {
        choosingPokemon.setupPokemon();
    }

    private void makeEnemyTeam() {            //Basically the same code as addPokemon but using a random
        int enemyTeamNumber = 0;              //number generator to generate enemy pokemon
        while (enemyTeamNumber < PARTY_NUMBER) {
            int randomPokemon = rand.nextInt(8);
            Pokemon opponentPokemon = new Pokemon(acceptablePokemon[randomPokemon]);
            setUpPokemon(opponentPokemon);
            enemyPokemon[enemyTeamNumber] = opponentPokemon;
            enemyTeamNumber++;
        }
        System.out.println("\nYour opponent's party is ");
        for (int x = 0; x < PARTY_NUMBER; x++) {
            System.out.println(enemyPokemon[x].getFacts());       //Makes sure the party, names, and stats are correct

        }
    }

    private void startBattle() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Your pokemon ");
        for (int x = 0; x < PARTY_NUMBER; x++) {
            System.out.print(x + 1 + ". " + listOfPokemon[x].getName() + ", ");

        }
        System.out.println("\n");
        System.out.println("Opponent's pokemon ");
        for (int x = 0; x < PARTY_NUMBER; x++) {
            System.out.print(x + 1 + ". " + enemyPokemon[x].getName() + ", ");
        }
        System.out.println("\n");
        System.out.println("Please choose your starting pokemon by their corresponding number.");
                                             //Everything up to here is just console printing to make the UI look pretty


    }


}
