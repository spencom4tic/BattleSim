package ui;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import model.Pokemon;
import model.TypeChart;
import model.exception.CantSaveException;
import model.exception.TooManyPokemonAddedException;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;

//Battle Application
class Battle extends JFrame {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final String FILE_DESCRIPTOR = "...file";
    private static final String SCREEN_DESCRIPTOR = "...screen";
    private JComboBox<String> printCombo;
    private JDesktopPane desktop;
    private JInternalFrame controlPanel;


    //Variables
    //Active Pokemon          - Changing
    //Party                   - Static once set            DONE
    //Opponent Active Pokemon - Changing
    //Opponent Party          - Static once set

    JsonWriter jsonWriter = new JsonWriter(JSON_STORE);
    JsonReader jsonReader = new JsonReader(JSON_STORE);
    private static final String JSON_STORE = "./data/pokemon.json";
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

    private boolean canSave = false;
    private boolean canSwitch = false;

    Icon iconPrimarina = new ImageIcon("C:\\Users\\spenc\\IdeaProjects\\"
            + "project_z7w5c\\data\\pokemon sprites\\Primarina.png");
    Icon iconVictini = new ImageIcon("C:\\Users\\spenc\\IdeaProjects\\"
            + "project_z7w5c\\data\\pokemon sprites\\Victini.png");
    Icon iconBlissey = new ImageIcon("C:\\Users\\spenc\\IdeaProjects\\"
            + "project_z7w5c\\data\\pokemon sprites\\Blissey.png");
    Icon iconPangoro = new ImageIcon("C:\\Users\\spenc\\IdeaProjects\\"
            + "project_z7w5c\\data\\pokemon sprites\\Pangoro.png");
    Icon iconDragapult = new ImageIcon("C:\\Users\\spenc\\IdeaProjects\\"
            + "project_z7w5c\\data\\pokemon sprites\\Dragapult.png");
    Icon iconKartana = new ImageIcon("C:\\Users\\spenc\\IdeaProjects\\"
            + "project_z7w5c\\data\\pokemon sprites\\Kartana.png");
    Icon iconZapdos = new ImageIcon("C:\\Users\\spenc\\IdeaProjects\\"
            + "project_z7w5c\\data\\pokemon sprites\\Zapdos.png");
    Icon iconAerodactyl = new ImageIcon("C:\\Users\\spenc\\IdeaProjects\\"
            + "project_z7w5c\\data\\pokemon sprites\\Aerodactyl.png");
    Icon iconSwampert = new ImageIcon("C:\\Users\\spenc\\IdeaProjects\\"
            + "project_z7w5c\\data\\pokemon sprites\\Swampert.png");

    JPanel addPokemonButtonPanel = new JPanel();
    JPanel ourPokemon = new JPanel();
    int addedPokemon = 0;
    String dummy;

    // EFFECTS: Welcomes player
    // EFFECTS: runs the addPokemon application
    // EFFECTS: Starts the Battle
    public Battle() {
        boolean check = checkLoad();
        if (!check) {
            setupUI();
            System.out.println("Press any key when you are have made your team!");
            /*System.out.println("\nWelcome to the Pokemon Battle!
             Please choose 3 of the 9 listed pokemon! Repeats are allowed.");
            for (int x = 0; x < acceptablePokemon.length; x++) {
                System.out.print(acceptablePokemon[x] + ", ");
            }
            addPokemon();*/
        }
        while (listOfPokemon[2] == null) {

            dummy = userinput.next();
        }

        for (Pokemon x : listOfPokemon) {
            setUpPokemon(x);
        }
        controlPanel.remove(addPokemonButtonPanel);
        makeEnemyTeam();
        startBattle();
        fight();
        endGame();

    }

    private void setupUI() {
        desktop = new JDesktopPane();
        desktop.addMouseListener(new DesktopFocusAction());
        controlPanel = new JInternalFrame("Control Panel",
                false, false, false, false);
        controlPanel.setLayout(new BorderLayout());
        setContentPane(desktop);
        setTitle("Spencer's Pokemon Battle Simulator");
        setSize(WIDTH, HEIGHT);
        addOurPokemon();
        //addSaveLoad();
        controlPanel.pack();
        controlPanel.setVisible(true);
        desktop.add(controlPanel);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        centreOnScreen();
        setVisible(true);

    }


    private class DesktopFocusAction extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            Battle.this.requestFocusInWindow();
        }
    }

    private void centreOnScreen() {
        int width = Toolkit.getDefaultToolkit().getScreenSize().width;
        int height = Toolkit.getDefaultToolkit().getScreenSize().height;
        setLocation((width - getWidth()) / 2, (height - getHeight()) / 2);

    }

    private void addSaveLoad() {
        JPanel saveButtonPanel = new JPanel();
        saveButtonPanel.setLayout(new GridLayout(1, 3));
        saveButtonPanel.add(new JButton(new SaveAction()));
        saveButtonPanel.add(new JButton(new LoadAction()));
        saveButtonPanel.add(createPrintCombo());

        controlPanel.add(saveButtonPanel, BorderLayout.CENTER);
    }

    private class SaveAction extends AbstractAction {

        SaveAction() {
            super("Save the Game");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                save();
            } catch (CantSaveException c) {
                JOptionPane.showMessageDialog(null, c.getMessage(),
                        "System Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private class LoadAction extends AbstractAction {

        LoadAction() {
            super("Load a previously stored game");
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                load();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private JComboBox<String> createPrintCombo() {
        printCombo = new JComboBox<String>();
        printCombo.addItem(FILE_DESCRIPTOR);
        printCombo.addItem(SCREEN_DESCRIPTOR);
        return printCombo;
    }

    private void addOurPokemon() {
        JButton primarina = new JButton(iconPrimarina);
        JButton pangoro = new JButton(iconPangoro);
        JButton swampert = new JButton(iconSwampert);
        JButton zapdos = new JButton(iconZapdos);
        JButton kartana = new JButton(iconKartana);
        JButton aerodactyl = new JButton(iconAerodactyl);
        JButton blissey = new JButton(iconBlissey);
        JButton dragapult = new JButton(iconDragapult);
        JButton victini = new JButton(iconVictini);
        primarina.addActionListener(new PrimarinaActionListener());
        pangoro.addActionListener(new PangoroActionListener());
        swampert.addActionListener(new SwampertActionListener());
        zapdos.addActionListener(new ZapdosActionListener());
        kartana.addActionListener(new KartanaActionListener());
        aerodactyl.addActionListener(new AerodactylActionListener());
        blissey.addActionListener(new BlisseyActionListener());
        dragapult.addActionListener(new DragapultActionListener());
        victini.addActionListener(new VictiniActionListener());
        addOurPokemonPart2(primarina, pangoro, victini,
                swampert, zapdos, kartana, aerodactyl, blissey, dragapult);
    }

    private void addOurPokemonPart2(JButton primarina, JButton pangoro, JButton victini, JButton swampert,
                                    JButton zapdos, JButton kartana, JButton aerodactyl, JButton blissey,
                                    JButton dragapult) {
        JOptionPane.showMessageDialog(null, "Please choose 3 pokemon from the list");
        JOptionPane.showMessageDialog(null, "Once you choose 3, please look at the console "
                + "for the next steps");
        JOptionPane.showMessageDialog(null, "You have to move the panel in order to see "
                + "what pokemon you have chosen");
        addPokemonButtonPanel.setLayout(new GridLayout(5, 3));
        ourPokemon.setLayout(new GridLayout(3, 1));
        addPokemonButtonPanel.add(primarina);
        addPokemonButtonPanel.add(pangoro);
        addPokemonButtonPanel.add(swampert);
        addPokemonButtonPanel.add(kartana);
        addPokemonButtonPanel.add(zapdos);
        addPokemonButtonPanel.add(blissey);
        addPokemonButtonPanel.add(dragapult);
        addPokemonButtonPanel.add(aerodactyl);
        addPokemonButtonPanel.add(victini);
        addPokemonButtonPanel.add(new JButton("Your"));
        addPokemonButtonPanel.add(new JButton("Team"));
        addPokemonButtonPanel.add(new JButton("Below"));
        controlPanel.add(addPokemonButtonPanel, BorderLayout.WEST);
        controlPanel.add(ourPokemon, BorderLayout.SOUTH);

    }

    private class PrimarinaActionListener extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (addedPokemon < PARTY_NUMBER) {
                listOfPokemon[addedPokemon] = new Pokemon("Primarina");
                JButton primarinaActivePokemon = new JButton(iconPrimarina);
                primarinaActivePokemon.addActionListener(new PrimarinaActionListener());
                addPokemonButtonPanel.add(primarinaActivePokemon);
                addedPokemon++;
            } else if (activePokemon == null) {
                for (Pokemon p : listOfPokemon) {
                    if (p.getName().equals("Primarina")) {
                        activePokemon = p;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "You can only add 3 pokemon to the team"
                        + "and one active pokemon!");
            }
        }
    }

    private class PangoroActionListener extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (addedPokemon < PARTY_NUMBER) {
                listOfPokemon[addedPokemon] = new Pokemon("Pangoro");
                JButton pangoroActivePokemon = new JButton(iconPangoro);
                pangoroActivePokemon.addActionListener(new PangoroActionListener());
                addPokemonButtonPanel.add(pangoroActivePokemon);
                addedPokemon++;
            } else if (activePokemon == null) {
                for (Pokemon p : listOfPokemon) {
                    if (p.getName().equals("Pangoro")) {
                        activePokemon = p;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "You can only add 3 pokemon to the team"
                        + "and one active pokemon!");
            }
        }
    }

    private class SwampertActionListener extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (addedPokemon < PARTY_NUMBER) {
                listOfPokemon[addedPokemon] = new Pokemon("Swampert");
                JButton swampertActivePokemon = new JButton(iconSwampert);
                swampertActivePokemon.addActionListener(new SwampertActionListener());
                addPokemonButtonPanel.add(swampertActivePokemon);
                addedPokemon++;
            } else if (activePokemon == null) {
                for (Pokemon p : listOfPokemon) {
                    if (p.getName().equals("Swampert")) {
                        activePokemon = p;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "You can only add 3 pokemon to the team"
                        + "and one active pokemon!");
            }
        }
    }

    private class ZapdosActionListener extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (addedPokemon < PARTY_NUMBER) {
                listOfPokemon[addedPokemon] = new Pokemon("Zapdos");
                JButton zapdosActivePokemon = new JButton(iconZapdos);
                zapdosActivePokemon.addActionListener(new ZapdosActionListener());
                addPokemonButtonPanel.add(zapdosActivePokemon);
                addedPokemon++;
            } else if (activePokemon == null) {
                for (Pokemon p : listOfPokemon) {
                    if (p.getName().equals("Zapdos")) {
                        activePokemon = p;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "You can only add 3 pokemon to the team"
                        + "and one active pokemon!");
            }
        }
    }

    private class KartanaActionListener extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (addedPokemon < PARTY_NUMBER) {
                listOfPokemon[addedPokemon] = new Pokemon("Kartana");
                JButton kartanaActivePokemon = new JButton(iconKartana);
                kartanaActivePokemon.addActionListener(new KartanaActionListener());
                addPokemonButtonPanel.add(kartanaActivePokemon);
                addedPokemon++;
            } else if (activePokemon == null) {
                for (Pokemon p : listOfPokemon) {
                    if (p.getName().equals("Kartana")) {
                        activePokemon = p;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "You can only add 3 pokemon to the team"
                        + "and one active pokemon!");
            }
        }
    }

    private class AerodactylActionListener extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (addedPokemon < PARTY_NUMBER) {
                listOfPokemon[addedPokemon] = new Pokemon("Aerodactyl");
                JButton aerodactylActivePokemon = new JButton(iconAerodactyl);
                aerodactylActivePokemon.addActionListener(new AerodactylActionListener());
                addPokemonButtonPanel.add(aerodactylActivePokemon);
                addedPokemon++;
            } else if (activePokemon == null) {
                for (Pokemon p : listOfPokemon) {
                    if (p.getName().equals("Aerodactyl")) {
                        activePokemon = p;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "You can only add 3 pokemon to the team"
                        + "and one active pokemon!");
            }
        }
    }

    private class BlisseyActionListener extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (addedPokemon < PARTY_NUMBER) {
                listOfPokemon[addedPokemon] = new Pokemon("Blissey");
                JButton blisseyActivePokemon = new JButton(iconBlissey);
                blisseyActivePokemon.addActionListener(new BlisseyActionListener());
                addPokemonButtonPanel.add(blisseyActivePokemon);
                addedPokemon++;
            } else if (activePokemon == null) {
                for (Pokemon p : listOfPokemon) {
                    if (p.getName().equals("Blissey")) {
                        activePokemon = p;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "You can only add 3 pokemon to the team"
                        + "and one active pokemon!");
            }
        }
    }

    private class DragapultActionListener extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (addedPokemon < PARTY_NUMBER) {
                if (addedPokemon < PARTY_NUMBER) {
                    listOfPokemon[addedPokemon] = new Pokemon("Dragapult");
                    JButton dragapultActivePokemon = new JButton(iconDragapult);
                    dragapultActivePokemon.addActionListener(new DragapultActionListener());
                    addPokemonButtonPanel.add(dragapultActivePokemon);
                    addedPokemon++;
                } else if (activePokemon == null) {
                    for (Pokemon p : listOfPokemon) {
                        if (p.getName().equals("Dragapult")) {
                            activePokemon = p;
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "You can only add 3 pokemon to the team"
                            + "and one active pokemon!");
                }
            }
        }
    }

    private class VictiniActionListener extends AbstractAction {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (addedPokemon < PARTY_NUMBER) {
                listOfPokemon[addedPokemon] = new Pokemon("Victini");
                JButton victiniActivePokemon = new JButton(iconVictini);
                victiniActivePokemon.addActionListener(new VictiniActionListener());
                addPokemonButtonPanel.add(victiniActivePokemon);
                addedPokemon++;
            } else if (activePokemon == null) {
                for (Pokemon p : listOfPokemon) {
                    if (p.getName().equals("Victini")) {
                        activePokemon = p;
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "You can only add 3 pokemon to the team"
                        + "and one active pokemon!");
            }
        }
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
            int randomPokemon = rand.nextInt(9);
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
        setupStartBattleUI();
        //System.out.println("Please choose your starting pokemon by their corresponding number.");
                                             //Everything up to here is just console printing to make the UI look pretty
        //this.activePokemon = listOfPokemon[userinput.nextInt() - 1];              //Sets our active pokemon
        Random rand = new Random();
        this.opponentActivePokemon = enemyPokemon[rand.nextInt(3)];        //Sets opponents pokemon
    }


    public void setupStartBattleUI() {

        while (activePokemon == null) {

        }
    }

    //EFFECTS: makes the fight active
    private void fight() {
        while (listOfPokemon.length > 0 && enemyPokemon.length > 0) {      //Game wil end if either team
            doATurn();                                                                //Has no pokemon
        }
    }

    //MODIFIES: active pokemon
    //EFFECTS: plays a classic turn of pokemon
    private void doATurn() {
        canSave = true;
        boolean doWeGoFirst = doWeGoFirst();
        System.out.println("\n\n\nStart of turn!");
        System.out.println("Opponents pokemon: " + opponentActivePokemon.getName()
                + "\nOpponents Type: " + opponentActivePokemon.getType()[0] + " "
                + opponentActivePokemon.getType()[1]
                + "\nHP:  " + opponentActivePokemon.getPokemonCurrentHP() + "/" + opponentActivePokemon.getPokemonHP());

        System.out.println("\nOur pokemon: " + activePokemon.getName()
                + "\nOur Type: " + activePokemon.getType()[0] + " "
                + activePokemon.getType()[1]
                + "\nHP:  " + activePokemon.getPokemonCurrentHP() + "/" + activePokemon.getPokemonHP()
                + ", Attack: " + activePokemon.getPokemonCurrentAttack() + ", Defense: "
                + activePokemon.getPokemonDefense() + ", Special Attack: "
                + activePokemon.getPokemonCurrentSpecialAttack() + ", Special Defense: "
                + activePokemon.getPokemonCurrentSpecialDefense() + ", Speed: " + activePokemon.getPokemonSpeed());
        askIfWeWantToSave();
        boolean switching = askIfWeWantToSwitch();
        if (doWeGoFirst && !switching) {
            turnWhereWeGoFirst();
        } else {
            turnWhereOpponentGoesFirst(switching);
        }
    }

    public void askIfWeWantToSave() {
        System.out.println("Would you like to to save? 1 = Yes, and 2 = No!");
        int answer = userinput.nextInt();
        if (answer == 1) {
            try {
                save();
            } catch (CantSaveException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void save() throws CantSaveException {
        if (canSave) {
            try {
                jsonWriter.open();
                jsonWriter.write(listOfPokemon, enemyPokemon, activePokemon, opponentActivePokemon);
                jsonWriter.close();
                System.out.println("Saved");
            } catch (FileNotFoundException e) {
                System.out.println("Unable to write to file");
            }
        } else {
            throw new CantSaveException("Cannot save at this moment!");
        }

    }

    public boolean checkLoad() {
        System.out.println("Would you like to to load your previous file? 1 = Yes, and 2 = No!");
        int answer = userinput.nextInt();
        if (answer == 1) {
            try {
                load();
                System.out.println("Loaded from " + JSON_STORE);
                return true;
            } catch (IOException e) {
                System.out.println("Unable to load game");
                return false;
            }
        } else {
            return false;
        }
    }

    public void load() throws IOException {
        listOfPokemon = jsonReader.readOurPokemon();
        enemyPokemon = jsonReader.readEnemyPokemon();
        activePokemon = jsonReader.readActivePokemon(listOfPokemon);
        opponentActivePokemon = jsonReader.readOpponentActivePokemon(enemyPokemon);
    }

    public boolean askIfWeWantToSwitch() {
        System.out.println("Would you like to to switch? 1 = Yes, and 2 = No!");
        int answer = userinput.nextInt();
        if (answer == 1) {
            return true;
        } else {
            return false;
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

    //TODO
    private void turnWhereWeGoFirst() {
        doOurTurn();
        if (checkFainted(opponentActivePokemon, enemyPokemon) && enemyPokemon.length > 0) {
            switchOpponentPokemon();
        } else if (enemyPokemon.length > 0) {
            doOpponentTurn();
            if (checkFainted(activePokemon, listOfPokemon) && listOfPokemon.length > 0) {
                canSwitch = true;
                switchYourPokemon();
            }
        }
        canSave = true;
    }

    //TODO
    private void turnWhereOpponentGoesFirst(boolean switching) {
        if (switching) {
            canSwitch = true;
            switchYourPokemon();
        }
        doOpponentTurn();
        if (checkFainted(activePokemon, listOfPokemon) && listOfPokemon.length > 0) {
            canSwitch = true;
            switchYourPokemon();
        } else if (listOfPokemon.length > 0) {
            if (!switching) {
                doOurTurn();
            }
            if (checkFainted(opponentActivePokemon, enemyPokemon) && enemyPokemon.length > 0) {
                switchOpponentPokemon();
            }
        }
        canSave = true;
    }

    //EFFECTS: Does our turn of pokemon
    //MODIFIES: both active pokemon
    private void doOurTurn() {
        System.out.println("\nPlease enter a move by its number!!" + "\n1: "
                       + activePokemon.getPokemonMoves().getMoveName(0) + "   2: "
                       + activePokemon.getPokemonMoves().getMoveName(1)
                       +   "   3: " + activePokemon.getPokemonMoves().getMoveName(2)
                       +   "   4: " + activePokemon.getPokemonMoves().getMoveName(3));
        int chosenMove = userinput.nextInt() - 1;
        if (activePokemon.getPokemonMoves().getMoveProperties(chosenMove).equals("Attack")) {
            doDamage(activePokemon, opponentActivePokemon, chosenMove);
        } else if (activePokemon.getPokemonMoves().getMoveProperties(chosenMove).equals("Heal")) {
            heal(activePokemon);
        } else if (activePokemon.getPokemonMoves().getMoveProperties(chosenMove).equals("Swords Dance")) {
            swordsDance(activePokemon);
        } else if (activePokemon.getPokemonMoves().getMoveProperties(chosenMove).equals("Seismic Toss")) {
            seismicToss(opponentActivePokemon);
        } else {
            calmMind(activePokemon);
        }
    }

    //MODIFIES: Our active pokemon
    //EFFECTS: switch pokemon
    private void switchYourPokemon() {
        canSave = false;
        System.out.println("Please enter what pokemon you would like to switch to!");
        for (int x = 0; x < listOfPokemon.length; x++) {
            if (!listOfPokemon[x].equals(activePokemon)) {               //creates list of possible pokemon to switch to
                System.out.print(x + 1 + ". " + listOfPokemon[x].getName() + "      ");
            }
        }
        activePokemon.setPokemonCurrentAttack(activePokemon.getPokemonAttack());              //Resets the stat changes
        activePokemon.setPokemonCurrentSpecialAttack(activePokemon.getPokemonSpecialAttack());
        activePokemon.setPokemonCurrentSpecialDefense(activePokemon.getPokemonSpecialDefense());
        activePokemon = listOfPokemon[userinput.nextInt() - 1];   //TODOOOOOOOO               //Switches pokemon
        System.out.println(activePokemon.getName());
        canSwitch = false;
    }

    //MODIFIES: one of the active pokemon
    //EFFECTS: does damage to enemy pokemon
    private void doDamage(Pokemon attackingPokemon, Pokemon receivingPokemon, int move) {
        double damage = 0;
        if (attackingPokemon.getPokemonMoves().getDamageType(move).equals("Physical")
                && accuracyCheck(attackingPokemon, move)) {
            damage = ((double) 2) + (((double) 42) * attackingPokemon.getPokemonMoves().getMovePower(move)
                    * (((double) attackingPokemon.getPokemonCurrentAttack())
                    / ((double) receivingPokemon.getPokemonDefense())) / ((double) 50));
        } else if (accuracyCheck(attackingPokemon, move)) {              //classic pokemon damage formula
            damage = ((double) 2) + (((double) 42) * attackingPokemon.getPokemonMoves().getMovePower(move)
                    * (((double) attackingPokemon.getPokemonCurrentSpecialAttack())
                    / ((double) receivingPokemon.getPokemonCurrentSpecialDefense())) / ((double) 50));
        }
        double effectiveness = TypeChart.typeChart(attackingPokemon.getPokemonMoves().getMoveType(move),
                receivingPokemon.getType());                   //there exist "rolls" in pokemon where the damage varies
        double multiplier = (rand.nextInt(15) + 85) / 100.0;
        damage = damage * multiplier * effectiveness;
        if (damage > receivingPokemon.getPokemonCurrentHP()) {       //^^   Takes the rolls and type effectivess
            damage = receivingPokemon.getPokemonCurrentHP();
        }
        receivingPokemon.setPokemonCurrentHP(receivingPokemon.getPokemonCurrentHP() - ((int) damage));
        if (receivingPokemon.getPokemonCurrentHP() < 0) {
            receivingPokemon.setPokemonCurrentHP(0);
        }
        damagePrinting(attackingPokemon, receivingPokemon, effectiveness, damage, move);
    }

    private boolean accuracyCheck(Pokemon pokemon, int move) {
        boolean check = true;
        int accuracy = rand.nextInt(99);
        if (accuracy > pokemon.getPokemonMoves().getMoveAccuracy(move)) {
            check = false;
        }
        return check;
    }

    //TODO
    private void damagePrinting(Pokemon attacker, Pokemon pokemon, double effectiveness, double damage, int move) {
        System.out.println(attacker.getName() + " uses " + attacker.getPokemonMoves().getMoveName(move));
        if (damage == 0 && effectiveness != 0) {
            System.out.println("The move misses!");
        } else if (effectiveness > 1) {
            System.out.println("It's super effective!");
        } else if (effectiveness == 0) {
            System.out.println("It doesn't effect the opposing " + pokemon.getName() + "...");
        } else if (effectiveness < 1) {
            System.out.println("It's not very effective...");
        }
        double percent = damage / ((double) pokemon.getPokemonHP());
        percent = ((double) 100) * percent;
        int intPercent = (int) percent;
        System.out.println("The attack did " + intPercent + "% of " + pokemon.getName() + "'s health!");
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

    //MODIFIES: one of the active pokemon
    //EFFECTS: multiplies active pokemons special attack and special def by 1
    private void calmMind(Pokemon pokemon) {
        if (pokemon.getPokemonCurrentSpecialAttack() == 4 * pokemon.getPokemonSpecialAttack()) {
            System.out.println("You have already maxed out your special attack!");
        } else {
            pokemon.setPokemonCurrentSpecialAttack((int) (pokemon.getPokemonCurrentSpecialAttack()
                    + pokemon.getPokemonSpecialAttack() * 0.5));
            pokemon.setPokemonCurrentSpecialDefense((int) (pokemon.getPokemonCurrentSpecialDefense()
                    + pokemon.getPokemonSpecialDefense() * 0.5));
        }
    }

    //Does damage equal to the users level (in this case, 100)
    private void seismicToss(Pokemon defendingPokemon) {
        if (TypeChart.typeChart("Fighting", defendingPokemon.getType()) == 0) {
            System.out.println("It doesnt effect the opposing " + defendingPokemon.getName() + "...");
        } else {
            defendingPokemon.setPokemonCurrentHP(defendingPokemon.getPokemonCurrentHP() - 100);
        }
    }

    //TODO
    private boolean checkFainted(Pokemon pokemon, Pokemon[] list) {
        int count = 0;
        if (Arrays.equals(list, listOfPokemon) && pokemon.getPokemonCurrentHP() <= 0) {
            System.out.println("Your pokemon, " + pokemon.getName() + " has fainted!");
            Pokemon[] newList = new Pokemon[listOfPokemon.length - 1];
            for (int x = 0; x < listOfPokemon.length; x++) {
                if (listOfPokemon[x].getPokemonCurrentHP() > 0) {
                    newList[count] = listOfPokemon[x];
                    count++;
                }
            }
            listOfPokemon = newList;
            return true;
        } else if (Arrays.equals(list, enemyPokemon) && pokemon.getPokemonCurrentHP() <= 0) {
            return opponentFaint(pokemon);
        }
        return false;
    }

    private boolean opponentFaint(Pokemon pokemon) {
        int count = 0;
        System.out.println("\nThe enemy pokemon " + pokemon.getName() + " has fainted!");
        Pokemon[] newList = new Pokemon[enemyPokemon.length - 1];
        for (int x = 0; x < enemyPokemon.length; x++) {
            if (enemyPokemon[x].getPokemonCurrentHP() > 0) {
                newList[count] = enemyPokemon[x];
                count++;
            }
        }
        enemyPokemon = newList;
        return true;
    }

    //TODO
    private void switchOpponentPokemon() {
        boolean check = false;
        for (int x = 0; x < enemyPokemon.length; x++) {
            for (int y = 0; y < 4; y++) {
                double multiplier = TypeChart.typeChart(enemyPokemon[x].getPokemonMoves().getMoveType(y),
                                                        activePokemon.getType());
                if (multiplier > 1) {
                    opponentActivePokemon = enemyPokemon[x];
                    check = true;
                }
            }
        }
        if (check == false) {
            opponentActivePokemon = enemyPokemon[rand.nextInt(enemyPokemon.length)];
        }
        System.out.println("The opponent has switched their pokemo to " + opponentActivePokemon.getName() + "!");
    }

    private void doOpponentTurn() {
        double percent = opponentActivePokemon.getPokemonCurrentHP() / ((double) opponentActivePokemon.getPokemonHP());
        percent = ((double) 100) * percent;
        int intPercent = (int) percent;
        boolean healCheck = checkHeal(opponentActivePokemon);
        boolean setupCheck = checkSetup(opponentActivePokemon)
                          && (opponentActivePokemon.getPokemonCurrentAttack()
                             > 1.5 * opponentActivePokemon.getPokemonAttack()
                             || opponentActivePokemon.getPokemonCurrentSpecialAttack()
                             > 1.3 * opponentActivePokemon.getPokemonSpecialAttack());
        if (intPercent < 33 && healCheck == true) {
            healOpponent(opponentActivePokemon);
        } else if (intPercent > 75 && setupCheck == true) {
            setupOpponent(opponentActivePokemon);
        } else if (opponentActivePokemon.getName().equals("Blissey")) {
            blisseyUsesSeismicToss(opponentActivePokemon, activePokemon);
        } else {
            opponentAttack(opponentActivePokemon, activePokemon);
        }
    }

    private boolean checkHeal(Pokemon pokemon) {
        for (int x = 0; x < 4; x++) {
            if (pokemon.getPokemonMoves().getMoveName(x) == "Roost"
                    || pokemon.getPokemonMoves().getMoveName(x) == "Soft Boiled") {
                return true;
            }
        }
        return false;
    }

    private boolean checkSetup(Pokemon pokemon) {
        for (int x = 0; x < 4; x++) {
            if (pokemon.getPokemonMoves().getMoveName(x) == "Swords Dance"
                    || pokemon.getPokemonMoves().getMoveName(x) == "Calm Mind") {
                return true;
            }
        }
        return false;
    }


    private void healOpponent(Pokemon pokemon) {
        if (pokemon.getName().equals("Blissey")) {
            System.out.println("The enemy " + pokemon.getName() + " used soft-boiled!");
        } else {
            System.out.println("The enemy " + pokemon.getName() + " used Roost!");
        }
        System.out.println("It healed half its health!");
        heal(pokemon);
    }

    private void setupOpponent(Pokemon pokemon) {
        if (pokemon.getName().equals("Primarina")) {
            System.out.println("The enemy " + pokemon.getName() + " used Calm Mind!");
            System.out.println("It raised its special attack and special defense by one stage!");
            calmMind(pokemon);
        } else {
            System.out.println("The enemy " + pokemon.getName() + " used Swords Dance");
            System.out.println("It raised its attack by two stages!");
            swordsDance(pokemon);
        }
    }

    private void blisseyUsesSeismicToss(Pokemon blissey, Pokemon defendingPokemon) {
        boolean doesSeismicTossDoMoreDamage = true;
        for (int x = 2; x < 4; x++) {
            if (((double) 2) + (((double) 42) * blissey.getPokemonMoves().getMovePower(x)
                    * (((double) blissey.getPokemonCurrentSpecialAttack())
                    / ((double) defendingPokemon.getPokemonCurrentSpecialDefense()))
                    / ((double) 50)) > 100) {
                doDamage(blissey, defendingPokemon, x);
                doesSeismicTossDoMoreDamage = false;
            }
        }
        if (doesSeismicTossDoMoreDamage) {
            System.out.println("The opponent Blissey used Seismic Toss!");
            seismicToss(defendingPokemon);
        }

    }

    private void opponentAttack(Pokemon attacker, Pokemon reciever) {
        double maxdamage = 0;
        int saveX = 0;                     //Saves which move does the max damage
        for (int x = 0; x < 4; x++) {
            if (attacker.getPokemonMoves().getMoveProperties(x).equals("Attack")) {
                double damage;
                if (attacker.getPokemonMoves().getDamageType(x).equals("Physical")) {
                    damage = ((double) 2) + (((double) 42) * attacker.getPokemonMoves().getMovePower(x)
                            * (((double) attacker.getPokemonCurrentAttack())
                            / ((double) reciever.getPokemonDefense())) / ((double) 50));
                } else {              //classic pokemon damage formula
                    damage = ((double) 2) + (((double) 42) * attacker.getPokemonMoves().getMovePower(x)
                            * (((double) attacker.getPokemonCurrentSpecialAttack())
                            / ((double) reciever.getPokemonCurrentSpecialDefense()))
                            / ((double) 50));
                }
                if (damage > maxdamage) {
                    maxdamage = damage;
                    saveX = x;
                }
            }
        }
        doDamage(attacker, reciever, saveX);
    }

    private void endGame() {
        if (listOfPokemon.length > enemyPokemon.length) {
            System.out.println("You have won! Thanks for playing!");
        } else {
            System.out.println("You have lost! Thanks for playing!");
        }
    }
}
