package model;

public class TypeChart {
    //Variables
    //Type of Move       - Static        NOT DONE
    //Type of Receiver   - Static        NOT DONE
    //Damage Multiplier  - Changing      NOT DONE


    // Normal = 0
    // Electric = 1
    // Water = 2
    // Fire = 3
    // Grass = 4
    // Ground = 5
    // Rock = 6
    // Flying = 7
    // Dragon = 8
    // Fairy = 9
    // Steel = 10
    // Psychic = 11
    // Dark = 12
    // Fighting = 13
    // Ice = 14
    // Bug = 15
    // Ghost = 16
    // Poison = 17




    private static final int MAX_TYPING = 2;

    //REQUIRES: A valid move, and a list of valid move types
    public static double typeChart(String moveType, String[] pokemonType) {
        return findWeaknessFirstHalf(moveType, pokemonType);
    }

    //EFFECTS: returns a type effectiveness multiplier
    //REQUIRES: Since the constructer requires the valid moveType and pokemonType: I'm going to assume these methods
    //          dont need requirements
    private static double findWeaknessFirstHalf(String moveType, String[] pokemonType) {
        double multiplier = 1;                                             //When given a move type, this will tell us
        if (moveType.equals("Normal")) {                                   //How much we need to multiply the damage by
            multiplier = multiplier * normalMove(pokemonType);
        } else if (moveType.equals("Electric")) {
            multiplier = multiplier * electricMove(pokemonType);
        } else if (moveType.equals("Water")) {
            multiplier = multiplier * waterMove(pokemonType);
        } else if (moveType.equals("Fire")) {
            multiplier = multiplier * fireMove(pokemonType);
        } else if (moveType.equals("Grass")) {
            multiplier = multiplier * grassMove(pokemonType);
        } else if (moveType.equals("Ground")) {
            multiplier = multiplier * groundMove(pokemonType);
        } else if (moveType.equals("Rock")) {
            multiplier = multiplier * rockMove(pokemonType);
        } else if (moveType.equals("Flying")) {
            multiplier = multiplier * flyingMove(pokemonType);
        } else if (moveType.equals("Dragon")) {
            multiplier = multiplier * dragonMove(pokemonType);
        } else {
            multiplier = multiplier * findWeaknessSecondHalf(moveType, pokemonType);
        }
        return multiplier;
    }

    private static double findWeaknessSecondHalf(String moveType, String[] pokemonType) {
        double multiplier = 1;                                             //When given a move type, this will tell us
        if (moveType.equals("Fairy")) {                                   //How much we need to multiply the damage by
            multiplier = multiplier * fairyMove(pokemonType);
        } else if (moveType.equals("Steel")) {
            multiplier = multiplier * steelMove(pokemonType);
        } else if (moveType.equals("Psychic")) {
            multiplier = multiplier * psychicMove(pokemonType);
        } else if (moveType.equals("Dark")) {
            multiplier = multiplier * darkMove(pokemonType);
        } else if (moveType.equals("Fighting")) {
            multiplier = multiplier * fightingMove(pokemonType);
        } else if (moveType.equals("Ice")) {
            multiplier = multiplier * iceMove(pokemonType);
        } else if (moveType.equals("Bug")) {
            multiplier = multiplier * bugMove(pokemonType);
        } else if (moveType.equals("Ghost")) {
            multiplier = multiplier * ghostMove(pokemonType);
        } else {
            multiplier = multiplier * poisonMove(pokemonType);
        }
        return multiplier;
    }

    //EFFECTS: returns the multiplier when a normal move is dealing damage
    private static double normalMove(String[] pokemonType) {                    //Explanation in electricMove
        double multiplier = 1;
        for (int x = 0; x < MAX_TYPING; x++) {
            if (pokemonType[x].equals("Rock")
                    || pokemonType[x].equals("Steel")) {
                multiplier = multiplier * 0.5;
            } else if (pokemonType[x].equals("Ghost")) {
                multiplier = multiplier * 0;
            }
        }
        return multiplier;
    }

    //EFFECTS: same thing but electric
    private static double electricMove(String[] pokemonType) {
        double multiplier = 1;
        for (int x = 0; x < MAX_TYPING; x++) {                       //Since lots of pokemon have 2 types,
            if (pokemonType[x].equals("Water")                       // we need to make sure both are considered
                    || pokemonType[x].equals("Flying")) {            // for super effective and not very effectiveness
                multiplier = multiplier * 2;                         // *2 means the move is super effective
            } else if (pokemonType[x].equals("Electric")
                    || pokemonType[x].equals("Grass")
                    || pokemonType[x].equals("Dragon")) {
                multiplier = multiplier * 0.5;                       // *0.5 means the move is not very effective
            }  else if (pokemonType[x].equals("Ground")) {
                multiplier = multiplier * 0;                         // *0 means the move does not effect at all
            }
        }
        return multiplier;
    }

    private static double waterMove(String[] pokemonType) {
        double multiplier = 1;
        for (int x = 0; x < MAX_TYPING; x++) {
            if (pokemonType[x].equals("Fire")
                    || pokemonType[x].equals("Ground")
                    || pokemonType[x].equals("Rock")) {
                multiplier = multiplier * 2;
            } else if (pokemonType[x].equals("Water")
                    || pokemonType[x].equals("Grass")
                    || pokemonType[x].equals("Dragon")) {
                multiplier = multiplier * 0.5;
            }
        }
        return multiplier;
    }

    private static double fireMove(String[] pokemonType) {
        double multiplier = 1;
        for (int x = 0; x < MAX_TYPING; x++) {
            if (pokemonType[x].equals("Grass")
                    || pokemonType[x].equals("Steel")
                    || pokemonType[x].equals("Bug")
                    || pokemonType[x].equals("Ice")) {
                multiplier = multiplier * 2;
            } else if (pokemonType[x].equals("Water")
                    || pokemonType[x].equals("Rock")
                    || pokemonType[x].equals("Fire")
                    || pokemonType[x].equals("Dragon")) {
                multiplier = multiplier * 0.5;
            }
        }
        return multiplier;
    }

    private static double grassMove(String[] pokemonType) {
        double multiplier = 1;
        for (int x = 0; x < MAX_TYPING; x++) {
            if (pokemonType[x].equals("Water")
                    || pokemonType[x].equals("Ground")
                    || pokemonType[x].equals("Rock")) {
                multiplier = multiplier * 2;
            } else if (pokemonType[x].equals("Fire")
                    || pokemonType[x].equals("Bug")
                    || pokemonType[x].equals("Poison")
                    || pokemonType[x].equals("Steel")
                    || pokemonType[x].equals("Grass")
                    || pokemonType[x].equals("Flying")
                    || pokemonType[x].equals("Dragon")) {
                multiplier = multiplier * 0.5;
            }
        }
        return multiplier;
    }

    private static double groundMove(String[] pokemonType) {
        double multiplier = 1;
        for (int x = 0; x < MAX_TYPING; x++) {
            if (pokemonType[x].equals("Electric")
                    || pokemonType[x].equals("Steel")
                    || pokemonType[x].equals("Poison")
                    || pokemonType[x].equals("Rock")
                    || pokemonType[x].equals("Fire")) {
                multiplier = multiplier * 2;
            } else if (pokemonType[x].equals("Grass")
                    || pokemonType[x].equals("Bug")) {
                multiplier = multiplier * 0.5;
            } else if (pokemonType[x].equals("Flying")) {
                multiplier = multiplier * 0;
            }
        }
        return multiplier;
    }

    private static double rockMove(String[] pokemonType) {
        double multiplier = 1;
        for (int x = 0; x < MAX_TYPING; x++) {
            if (pokemonType[x].equals("Fire")
                    || pokemonType[x].equals("Flying")
                    || pokemonType[x].equals("Ice")
                    || pokemonType[x].equals("Bug")) {
                multiplier = multiplier * 2;
            } else if (pokemonType[x].equals("Ground")
                    || pokemonType[x].equals("Steel")
                    || pokemonType[x].equals("Fighting")) {
                multiplier = multiplier * 0.5;
            }
        }
        return multiplier;
    }

    private static double flyingMove(String[] pokemonType) {
        double multiplier = 1;
        for (int x = 0; x < MAX_TYPING; x++) {
            if (pokemonType[x].equals("Grass")
                    || pokemonType[x].equals("Bug")
                    || pokemonType[x].equals("Fighting")) {
                multiplier = multiplier * 2;
            } else if (pokemonType[x].equals("Steel")
                    || pokemonType[x].equals("Electric")
                    || pokemonType[x].equals("Rock")) {
                multiplier = multiplier * 0.5;
            }
        }
        return multiplier;
    }

    private static double dragonMove(String[] pokemonType) {
        double multiplier = 1;
        for (int x = 0; x < MAX_TYPING; x++) {
            if (pokemonType[x].equals("Dragon")) {
                multiplier = multiplier * 2;
            } else if (pokemonType[x].equals("Steel")) {
                multiplier = multiplier * 0.5;
            } else if (pokemonType[x].equals("Fairy")) {
                multiplier = multiplier * 0;
            }
        }
        return multiplier;
    }

    private static double fairyMove(String[] pokemonType) {
        double multiplier = 1;
        for (int x = 0; x < MAX_TYPING; x++) {
            if (pokemonType[x].equals("Dark")
                    || pokemonType[x].equals("Fighting")
                    || pokemonType[x].equals("Dragon")) {
                multiplier = multiplier * 2;
            } else if (pokemonType[x].equals("Steel")
                    || pokemonType[x].equals("Poison")
                    || pokemonType[x].equals("Fire")) {
                multiplier = multiplier * 0.5;
            }
        }
        return multiplier;
    }

    private static double steelMove(String[] pokemonType) {
        double multiplier = 1;
        for (int x = 0; x < MAX_TYPING; x++) {
            if (pokemonType[x].equals("Rock")
                    || pokemonType[x].equals("Fairy")
                    || pokemonType[x].equals("Ice")) {
                multiplier = multiplier * 2;
            } else if (pokemonType[x].equals("Steel")
                    || pokemonType[x].equals("Water")
                    || pokemonType[x].equals("Electric")
                    || pokemonType[x].equals("Fire")) {
                multiplier = multiplier * 0.5;
            }
        }
        return multiplier;
    }

    private static double psychicMove(String[] pokemonType) {
        double multiplier = 1;
        for (int x = 0; x < MAX_TYPING; x++) {
            if (pokemonType[x].equals("Fighting")
                    || pokemonType[x].equals("Poison")) {
                multiplier = multiplier * 2;
            } else if (pokemonType[x].equals("Psychic")
                    || pokemonType[x].equals("Steel")) {
                multiplier = multiplier * 0.5;
            } else if (pokemonType[x].equals("Dark")) {
                multiplier = multiplier * 0;
            }
        }
        return multiplier;
    }

    private static double darkMove(String[] pokemonType) {
        double multiplier = 1;
        for (int x = 0; x < MAX_TYPING; x++) {
            if (pokemonType[x].equals("Ghost")
                    || pokemonType[x].equals("Psychic")) {
                multiplier = multiplier * 2;
            } else if (pokemonType[x].equals("Dark")
                    || pokemonType[x].equals("Fighting")
                    || pokemonType[x].equals("Fairy")) {
                multiplier = multiplier * 0.5;
            }
        }
        return multiplier;
    }

    private static double fightingMove(String[] pokemonType) {
        double multiplier = 1;
        for (int x = 0; x < MAX_TYPING; x++) {
            if (pokemonType[x].equals("Normal")
                    || pokemonType[x].equals("Rock")
                    || pokemonType[x].equals("Dark")
                    || pokemonType[x].equals("Steel")
                    || pokemonType[x].equals("Ice")) {
                multiplier = multiplier * 2;
            } else if (pokemonType[x].equals("Psychic")
                    || pokemonType[x].equals("Poison")
                    || pokemonType[x].equals("Flying")
                    || pokemonType[x].equals("Fairy")
                    || pokemonType[x].equals("Bug")) {
                multiplier = multiplier * 0.5;
            } else if (pokemonType[x].equals("Ghost")) {
                multiplier = multiplier * 0;
            }
        }
        return multiplier;
    }

    private static double iceMove(String[] pokemonType) {
        double multiplier = 1;
        for (int x = 0; x < MAX_TYPING; x++) {
            if (pokemonType[x].equals("Grass")
                    || pokemonType[x].equals("Ground")
                    || pokemonType[x].equals("Dragon")
                    || pokemonType[x].equals("Flying")) {
                multiplier = multiplier * 2;
            } else if (pokemonType[x].equals("Steel")
                    || pokemonType[x].equals("Water")
                    || pokemonType[x].equals("Ice")
                    || pokemonType[x].equals("Fire")) {
                multiplier = multiplier * 0.5;
            }
        }
        return multiplier;
    }

    private static double bugMove(String[] pokemonType) {
        double multiplier = 1;
        for (int x = 0; x < MAX_TYPING; x++) {
            if (pokemonType[x].equals("Grass")
                    || pokemonType[x].equals("Psychic")
                    || pokemonType[x].equals("Dark")) {
                multiplier = multiplier * 2;
            } else if (pokemonType[x].equals("Fire")
                    || pokemonType[x].equals("Fighting")
                    || pokemonType[x].equals("Poison")
                    || pokemonType[x].equals("Ghost")
                    || pokemonType[x].equals("Steel")
                    || pokemonType[x].equals("Fairy")
                    || pokemonType[x].equals("Flying")) {
                multiplier = multiplier * 0.5;
            }
        }
        return multiplier;
    }

    private static double ghostMove(String[] pokemonType) {
        double multiplier = 1;
        for (int x = 0; x < MAX_TYPING; x++) {
            if (pokemonType[x].equals("Ghost")
                    || pokemonType[x].equals("Psychic")) {
                multiplier = multiplier * 2;
            } else if (pokemonType[x].equals("Dark")) {
                multiplier = multiplier * 0.5;
            } else if (pokemonType[x].equals("Normal")) {
                multiplier = multiplier * 0;
            }
        }
        return multiplier;
    }

    private static double poisonMove(String[] pokemonType) {
        double multiplier = 1;
        for (int x = 0; x < MAX_TYPING; x++) {
            if (pokemonType[x].equals("Grass")
                    || pokemonType[x].equals("Fairy")) {
                multiplier = multiplier * 2;
            } else if (pokemonType[x].equals("Poison")
                    || pokemonType[x].equals("Rock")
                    || pokemonType[x].equals("Ghost")
                    || pokemonType[x].equals("Ground")) {
                multiplier = multiplier * 0.5;
            } else if (pokemonType[x].equals("Steel")) {
                multiplier = multiplier * 0;
            }
        }
        return multiplier;
    }
}
