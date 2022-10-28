package persistence;
//most of this code is credited to UBC's CPSC 210 class example code

import model.Pokemon;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.*;


public class JsonWriter {
    private static final int TAB = 4;
    private PrintWriter writer;
    private String destination;


    public JsonWriter(String destination) {
        this.destination = destination;
    }

    public void open() throws FileNotFoundException {
        writer = new PrintWriter(new File(destination));
    }

    public JSONObject writePokemon(Pokemon[] ourList, Pokemon[] enemyList) {
        JSONObject json = new JSONObject();
        json.put("Our Pokemon", writeOurPokemon(ourList));
        json.put("Opponent Pokemon", writeEnemyPokemon(enemyList));
        return json;
    }


    public JSONArray writeOurPokemon(Pokemon[] list) {
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (Pokemon x : list) {
            jsonArray.put(writeIndividualPokemon(x));
        }

        return jsonArray;
    }

    public JSONArray writeEnemyPokemon(Pokemon[] list) {
        JSONObject json = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for (Pokemon x : list) {
            jsonArray.put(writeIndividualPokemon(x));
        }
        return jsonArray;
    }

    public JSONObject writeIndividualPokemon(Pokemon pokemon) {
        JSONObject json = new JSONObject();
        json.put("Name", pokemon.getName());
        json.put("Current HP", pokemon.getPokemonCurrentHP());
        json.put("Current Attack", pokemon.getPokemonCurrentAttack());
        json.put("Current Special Attack", pokemon.getPokemonCurrentSpecialAttack());
        json.put("Current Special Defense", pokemon.getPokemonCurrentSpecialDefense());

        return json;

    }

    public JSONObject writeActivePokemon(Pokemon activePokemon, Pokemon opponentActivePokemon) {
        JSONObject json = new JSONObject();
        json.put("Our active pokemon", writeIndividualPokemon(activePokemon));
        json.put("Opponent active pokemon", writeIndividualPokemon(opponentActivePokemon));
        return json;
    }

    public void write(Pokemon[] ourList, Pokemon[] enemyList, Pokemon activePokemon, Pokemon opponentActivePokemon) {
        JSONObject json = new JSONObject();
        json.put("List of Pokemon", writePokemon(ourList, enemyList));
        json.put("Active Pokemon", writeActivePokemon(activePokemon, opponentActivePokemon));
        saveToFile(json.toString(TAB));
    }

    public void close() {
        writer.close();
    }

    public void saveToFile(String json) {
        writer.print(json);
    }
}
