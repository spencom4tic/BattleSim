package ui;

import model.Pokemon;
import model.TypeChart;

import java.lang.reflect.Type;
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
    boolean activePokemonStatus = false;
    boolean opponentPokemonStatus = true;
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
        fight();
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

    //MODIFIES: the pokemon to implement its stats and types and moves
    private void setUpPokemon(Pokemon choosingPokemon) {
        choosingPokemon.setupPokemon();
    }

    //MODIFIES: Makes the enemy team party
    private void makeEnemyTeam() {            //Basically the same code as addPokemon but using a random
        int enemyTeamNumber = 0;              //number generator to generate enemy pokemon
        while (enemyTeamNumber < PARTY_NUMBER) {
            int randomPokemon = rand.nextInt(8);
            Pokemon opponentPokemon = new Pokemon(acceptablePokemon[randomPokemon]);
            setUpPokemon(opponentPokemon);
            enemyPokemon[enemyTeamNumber] = opponentPokemon;
            enemyTeamNumber++;
        }
    }

    //EFFECTS:  Allows us to choose our lead pokemon
    //MODIFIES: Active pokemon
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
        this.activePokemon = listOfPokemon[userinput.nextInt() - 1];              //Sets our active pokemon
        Random rand = new Random();
        this.opponentActivePokemon = enemyPokemon[rand.nextInt(3)];        //Sets opponents pokemon
    }


    //EFFECTS: makes the fight active
    private void fight() {
        doATurn();
        //while (listOfPokemon.length != 0 && enemyPokemon.length != 0) {      //Game wil end if either team
                                                                               //Has no pokemon
        //}
    }

    //MODIFIES: active pokemon
    //EFFECTS: plays a classic turn of pokemon
    private void doATurn() {
        boolean doWeGoFirst = doWeGoFirst();
        System.out.println("\n\n\n\nOpponents pokemon: " + opponentActivePokemon.getName()
                         + "\nOpponents Type: " + opponentActivePokemon.getType()[0] + " "
                                                + opponentActivePokemon.getType()[1]);

        System.out.println("\nOur pokemon: " + activePokemon.getName()
                         + "\nOur Type: " + activePokemon.getType()[0] + " "
                                          + activePokemon.getType()[1]
                         + "\nOur Moves: " + activePokemon.getPokemonMoves().getMove(0) + "\n"
                                           + activePokemon.getPokemonMoves().getMove(1) + "\n"
                                           + activePokemon.getPokemonMoves().getMove(2) + "\n"
                                           + activePokemon.getPokemonMoves().getMove(3) + "\n");
        if (doWeGoFirst) {
            doOurTurn();
            //doOpponentTurn();
        } else {
            //doOpponentTurn();
            doOurTurn();
        }
    }

    //EFFECTS: finds out who is faster and who should go first in the turn
    private boolean doWeGoFirst() {
        if (activePokemon.getPokemonSpeed() > opponentActivePokemon.getPokemonSpeed()) {         //If we are faster
            return true;                                                                         //We go first
        } else if (activePokemon.getPokemonSpeed() < opponentActivePokemon.getPokemonSpeed()) {  //If Opponent is faster
            return false;                                                                        //They go first
        } else {
            int random = rand.nextInt(2);                                                  // Speed tie
            if (random == 1) {
                return true;
            } else {
                return false;
            }
        }
    }

    //EFFECTS: Does our turn of pokemon
    //MODIFIES: both active pokemon
    private void doOurTurn() {
        System.out.println("\nPlease enter a move by its number!!"
                       +   "\n1: " + activePokemon.getPokemonMoves().getMoveName(0)
                       +   "   2: " + activePokemon.getPokemonMoves().getMoveName(1)
                       +   "   3: " + activePokemon.getPokemonMoves().getMoveName(2)
                       +   "   4: " + activePokemon.getPokemonMoves().getMoveName(3) + "   5: Switch");
        int chosenMove = userinput.nextInt();
        int paralysis = rand.nextInt(4);
        if (activePokemonStatus == true && paralysis == 1) {
            System.out.println("Your Pokemon was paralyzed! It couldn't move!");
        } else {
            chosenMove = chosenMove - 1;                  //Everything here is pretty self explanatory
            if (chosenMove == 4) {
                switchYourPokemon();
            } else if (activePokemon.getPokemonMoves().getMoveProperties(chosenMove).equals("Attack")) {
                doDamage(activePokemon, opponentActivePokemon, chosenMove);
            } else if (activePokemon.getPokemonMoves().getMoveProperties(chosenMove).equals("Heal")) {
                heal(activePokemon);
            } else if (activePokemon.getPokemonMoves().getMoveProperties(chosenMove).equals("Swords Dance")) {
                swordsDance(activePokemon);
            } else {
                //calmMind(activePokemon);
            }
        }
    }

    //MODIFIES: Our active pokemon
    //EFFECTS: switch pokemon
    private void switchYourPokemon() {
        System.out.println("Please enter what pokemon you would like to switch to!");
        for (int x = 0; x < PARTY_NUMBER; x++) {
            if (!listOfPokemon[x].equals(activePokemon)) {               //creates list of possible pokemon to switch to
                System.out.print(x + ". " + listOfPokemon[x].getName() + "      ");
            }
        }
        activePokemon.setPokemonCurrentAttack(activePokemon.getPokemonAttack());              //Resets the stat changes
        activePokemon.setPokemonCurrentSpecialAttack(activePokemon.getPokemonSpecialAttack());
        activePokemon.setPokemonCurrentSpecialDefense(activePokemon.getPokemonSpecialDefense());
        activePokemon = listOfPokemon[userinput.nextInt()];                                   //Switches pokemon
        System.out.println(activePokemon.getName());
    }

    //MODIFIES: one of the active pokemon
    //EFFECTS: does damage to enemy pokemon
    private void doDamage(Pokemon attackingPokemon, Pokemon receivingPokemon, int move) {
        double damage = 0;
        if (attackingPokemon.getPokemonMoves().getDamageType(move).equals("Physical")) {
            damage = ((double) 2) + (((double) 42) * attackingPokemon.getPokemonMoves().getMovePower(move)
                    * (((double) attackingPokemon.getPokemonCurrentAttack())
                    / ((double) receivingPokemon.getPokemonDefense()))         //standard pokemon damage formula
                    / ((double) 50));
        } else {
            damage = ((double) 2) + (((double) 42) * attackingPokemon.getPokemonMoves().getMovePower(move)
                    * (((double) attackingPokemon.getPokemonCurrentSpecialAttack())
                    / ((double) receivingPokemon.getPokemonCurrentSpecialDefense()))
                    / ((double) 50));
        }
        double effectiveness = TypeChart.typeChart(attackingPokemon.getPokemonMoves().getMoveType(move),
                receivingPokemon.getType());
        double multiplier = rand.nextInt(15);                         //there exist "rolls" in pokemon where
        double damageRoll = ((multiplier + 85) / 100);                      //the damage done varies
        damage = damage * damageRoll * effectiveness;                       //Takes the rolls and type effectivess
        receivingPokemon.setPokemonCurrentHP(receivingPokemon.getPokemonCurrentHP() - ((int) damage));
        //recieving pokemon takes damage

        //TO DO, make pokemon faint
    }

    //MODIFIES: one of the active pokemon
    //EFFECTS: heals the mon
    private void heal(Pokemon pokemon) {
        pokemon.setPokemonCurrentHP(pokemon.getPokemonCurrentHP() + ((int) (pokemon.getPokemonHP() * 0.5)));
        if (pokemon.getPokemonCurrentHP() > pokemon.getPokemonHP()) {
            pokemon.setPokemonCurrentHP(pokemon.getPokemonHP());            //makes sure pokemon cant heal over maxhp
        }
    }

    //MODIFIES: one of the active pokemon
    //EFFECTS: double its attack
    private void swordsDance(Pokemon pokemon) {
        if (pokemon.getPokemonCurrentAttack() == 4 * pokemon.getPokemonAttack()) {      //you can only swords dance 3
            System.out.println("You have already maxed out your attack!");              //times
        } else {
            pokemon.setPokemonCurrentAttack(pokemon.getPokemonCurrentAttack() + pokemon.getPokemonAttack());
        }


    }

}
