package model;

public class Moves {
    private String pokemonName;
    private String[] moveName = new String[4];
    private double[] movePower = new double[4];
    private int[] moveAccuracy = new int[4];
    private String[] moveType =  new String[4];
    private String[] moveProperties = new String[4];
    private String[] moveDamageType = new String[4];

    //Variables
    //Power    - Changing     NOT DONE
    //Accuracy - Static       NOT DONE
    //Type     - Static       NOT DONE
    //Name     - Static       NOT DONE

    public Moves(String name) {
        this.pokemonName = name;
        setupMove();
    }

    public String getMoveName(int move) {
        return this.moveName[move];
    }

    public double getMovePower(int move) {
        return this.movePower[move];
    }

    public int getMoveAccuracy(int move) {
        return this.moveAccuracy[move];
    }

    public String getMoveType(int move) {
        return this.moveType[move];
    }

    public String getMoveProperties(int move) {
        return this.moveProperties[move];
    }

    public String getDamageType(int move) {
        return this.moveDamageType[move];
    }

    public String getMove(int move) {
        String testString = this.moveName[move]
                + "  Power: " + this.movePower[move]
                + ",  Accuracy: " + this.moveAccuracy[move]
                + ",  Type: " + this.moveType[move]
                + ",  Properties: " + this.moveProperties[move]
                + ",  Damage Type: " + this.moveDamageType[move];
        return testString;
    }

    public void setupMove() {
        if (this.pokemonName == "Victini") {
            setupVictini();
        } else if (this.pokemonName == "Pangoro") {
            setupPangoro();
        } else if (this.pokemonName == "Zapdos") {
            setupZapdos();
        } else if (this.pokemonName == "Swampert") {
            setupSwampert();
        } else if (this.pokemonName == "Kartana") {
            setupKartana();
        } else if (this.pokemonName == "Blissey") {
            setupBlissey();
        } else if (this.pokemonName == "Dragapult") {
            setupDragapult();
        } else if (this.pokemonName == "Aerodactyl") {
            setupAerodactyl();
        } else if (this.pokemonName == "Primarina") {
            setupPrimarina();
        }
    }

    private void setupVictini() {
        moveName[0] = "Blue Flare";
        moveType[0] = "Fire";
        movePower[0] = 195;
        moveAccuracy[0] = 85;
        moveProperties[0] = "Attack";
        moveName[1] = "Zen Headbutt";
        moveType[1] = "Psychic";
        movePower[1] = 120;
        moveAccuracy[1] = 90;
        moveProperties[1] = "Attack";
        moveName[2] = "Bolt Strike";
        moveType[2] = "Electric";
        movePower[2] = 130;
        moveAccuracy[2] = 85;
        moveProperties[2] = "Attack";
        moveName[3] = "Energy Ball";
        moveType[3] = "Grass";
        movePower[3] = 90;
        moveAccuracy[3] = 100;
        moveProperties[3] = "Attack";
        moveDamageType[0] = moveDamageType[2] = "Physical";
        moveDamageType[1] = moveDamageType[3] = "Special";
    }

    private void setupPangoro() {
        moveName[0] = "Close Combat";
        moveType[0] = "Fighting";
        movePower[0] = 180;
        moveAccuracy[0] = 100;
        moveProperties[0] = "Attack";
        moveName[1] = "Darkest Lariat";
        moveType[1] = "Dark";
        movePower[1] = 120;
        moveAccuracy[1] = 100;
        moveProperties[1] = "Attack";
        moveName[2] = "Thunder Punch";
        moveType[2] = "Electric";
        movePower[2] = 75;
        moveAccuracy[2] = 100;
        moveProperties[2] = "Attack";
        moveName[3] = "Swords Dance";
        moveType[3] = "Normal";
        movePower[3] = 0;
        moveAccuracy[3] = 100;
        moveProperties[3] = "Swords Dance";
        moveDamageType[0] = moveDamageType[1] = moveDamageType[2] = moveDamageType[3] = "Physical";
    }

    private void setupZapdos() {
        moveName[0] = "Thunderbolt";
        moveType[0] = "Electric";
        movePower[0] = 135;
        moveAccuracy[0] = 100;
        moveProperties[0] = "Attack";
        moveName[1] = "Hurricane";
        moveType[1] = "Flying";
        movePower[1] = 165;
        moveAccuracy[1] = 70;
        moveProperties[1] = "Attack";
        moveName[2] = "Heat Wave";
        moveType[2] = "Fire";
        movePower[2] = 95;
        moveAccuracy[2] = 90;
        moveProperties[2] = "Attack";
        moveName[3] = "Roost";
        moveType[3] = "Normal";
        movePower[3] = 0;
        moveAccuracy[3] = 100;
        moveProperties[3] = "Heal";
        moveDamageType[0] = moveDamageType[1] = moveDamageType[2] = moveDamageType[3] = "Special";
    }

    private void setupSwampert() {
        moveName[0] = "Liquidation";
        moveType[0] = "Water";
        movePower[0] = 127.5;
        moveAccuracy[0] = 100;
        moveProperties[0] = "Attack";
        moveName[1] = "Earthquake";
        moveType[1] = "Ground";
        movePower[1] = 150;
        moveAccuracy[1] = 100;
        moveProperties[1] = "Attack";
        moveName[2] = "Stone Edge";
        moveType[2] = "Rock";
        movePower[2] = 100;
        moveAccuracy[2] = 80;
        moveProperties[2] = "Attack";
        moveName[3] = "Ice Punch";
        moveType[3] = "Ice";
        movePower[3] = 75;
        moveAccuracy[3] = 100;
        moveProperties[3] = "Attack";
        moveDamageType[0] = moveDamageType[1] = moveDamageType[2] = moveDamageType[3] = "Physical";
    }

    private void setupKartana() {
        moveName[0] = "Leaf Blade";
        moveType[0] = "Grass";
        movePower[0] = 135;
        moveAccuracy[0] = 100;
        moveProperties[0] = "Attack";
        moveName[1] = "Smart Strike";
        moveType[1] = "Steel";
        movePower[1] = 105;
        moveAccuracy[1] = 100;
        moveProperties[1] = "Attack";
        moveName[2] = "Sacred Sword";
        moveType[2] = "Fighting";
        movePower[2] = 90;
        moveAccuracy[2] = 100;
        moveProperties[2] = "Attack";
        moveName[3] = "Swords Dance";
        moveType[3] = "Normal";
        movePower[3] = 0;
        moveAccuracy[3] = 100;
        moveProperties[3] = "Swords Dance";
        moveDamageType[0] = moveDamageType[1] = moveDamageType[2] = moveDamageType[3] = "Physical";
    }

    private void setupBlissey() {
        moveName[0] = "Seismic Toss";
        moveType[0] = "Fighting";
        movePower[0] = 0;
        moveAccuracy[0] = 100;
        moveProperties[0] = "Seismic Toss";
        moveName[1] = "Soft Boiled";
        moveType[1] = "Normal";
        movePower[1] = 0;
        moveAccuracy[1] = 100;
        moveProperties[1] = "Heal";
        moveName[2] = "Thunderbolt";
        moveType[2] = "Electric";
        movePower[2] = 90;
        moveAccuracy[2] = 100;
        moveProperties[2] = "Attack";
        moveName[3] = "Thunder Wave";
        moveType[3] = "Electric";
        movePower[3] = 0;
        moveAccuracy[3] = 100;
        moveProperties[3] = "Status";
        moveDamageType[0] = moveDamageType[1] = moveDamageType[2] = moveDamageType[3] = "Special";
    }

    private void setupDragapult() {
        moveName[0] = "Shadow Ball";
        moveType[0] = "Ghost";
        movePower[0] = 120;
        moveAccuracy[0] = 100;
        moveProperties[0] = "Attack";
        moveName[1] = "Dragon Pulse";
        moveType[1] = "Dragon";
        movePower[1] = 127.5;
        moveAccuracy[1] = 100;
        moveProperties[1] = "Attack";
        moveName[2] = "Flamethrower";
        moveType[2] = "Fire";
        movePower[2] = 90;
        moveAccuracy[2] = 100;
        moveProperties[2] = "Attack";
        moveName[3] = "Hydro Pump";
        moveType[3] = "Water";
        movePower[3] = 110;
        moveAccuracy[3] = 80;
        moveProperties[3] = "Attack";
        moveDamageType[0] = moveDamageType[1] = moveDamageType[2] = moveDamageType[3] = "Special";
    }

    private void setupAerodactyl() {
        moveName[0] = "Stone Edge";
        moveType[0] = "Rock";
        movePower[0] = 150;
        moveAccuracy[0] = 80;
        moveProperties[0] = "Attack";
        moveName[1] = "Wing Attack";
        moveType[1] = "Flying";
        movePower[1] = 90;
        moveAccuracy[1] = 100;
        moveProperties[1] = "Attack";
        moveName[2] = "Earthquake";
        moveType[2] = "Ground";
        movePower[2] = 100;
        moveAccuracy[2] = 100;
        moveProperties[2] = "Attack";
        moveName[3] = "Roost";
        moveType[3] = "Normal";
        movePower[3] = 0;
        moveAccuracy[3] = 100;
        moveProperties[3] = "Heal";
        moveDamageType[0] = moveDamageType[1] = moveDamageType[2] = moveDamageType[3] = "Physical";
    }

    private void setupPrimarina() {
        moveName[0] = "Moonblast";
        moveType[0] = "Fairy";
        movePower[0] = 142.5;
        moveAccuracy[0] = 100;
        moveProperties[0] = "Attack";
        moveName[1] = "Hydro Pump";
        moveType[1] = "Water";
        movePower[1] = 165;
        moveAccuracy[1] = 80;
        moveProperties[1] = "Attack";
        moveName[2] = "Energy Ball";
        moveType[2] = "Grass";
        movePower[2] = 90;
        moveAccuracy[2] = 100;
        moveProperties[2] = "Attack";
        moveName[3] = "Calm Mind";
        moveType[3] = "Psychic";
        movePower[3] = 0;
        moveAccuracy[3] = 100;
        moveProperties[3] = "Calm Mind";
        moveDamageType[0] = moveDamageType[1] = moveDamageType[2] = moveDamageType[3] = "Special";
    }
}
