package persistence;

import model.Pokemon;
import org.json.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class JsonReader {
    private String source;

    public JsonReader(String source) {
        this.source = source;
    }

    public Pokemon[] readOurPokemon() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseOurPokemon(jsonObject);
    }

    public Pokemon[] readEnemyPokemon() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseEnemyPokemon(jsonObject);
    }

    public Pokemon readActivePokemon(Pokemon[] ourPokemon) throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseActivePokemon(jsonObject, ourPokemon);
    }

    public Pokemon readOpponentActivePokemon(Pokemon[] opponentPokemon) throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseOpponentActivePokemon(jsonObject, opponentPokemon);
    }

    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    private Pokemon[] parseOurPokemon(JSONObject jsonObject) {
        JSONObject json = jsonObject.getJSONObject("List of Pokemon");
        JSONArray jsonArray = json.getJSONArray("Our Pokemon");
        Pokemon[] list = new Pokemon[jsonArray.length()];
        int count = 0;
        for (Object jsonMon : jsonArray) {
            list[count] = parseIndividualPokemon(jsonMon);
            count++;
        }
        return list;
    }

    private Pokemon[] parseEnemyPokemon(JSONObject jsonObject) {
        JSONObject json = jsonObject.getJSONObject("List of Pokemon");
        JSONArray jsonArray = json.getJSONArray("Opponent Pokemon");
        Pokemon[] list = new Pokemon[jsonArray.length()];
        int count = 0;
        for (Object jsonMon : jsonArray) {
            list[count] = parseIndividualPokemon(jsonMon);
            count++;
        }
        return list;
    }

    private Pokemon parseIndividualPokemon(Object monObject) {
        JSONObject pokemonJson = (JSONObject) monObject;
        Pokemon pokemon = new Pokemon(pokemonJson.getString("Name"));
        pokemon.setupPokemon();
        pokemon.setPokemonCurrentHP(pokemonJson.getInt("Current HP"));
        pokemon.setPokemonCurrentAttack(pokemonJson.getInt("Current Attack"));
        pokemon.setPokemonCurrentSpecialAttack(pokemonJson.getInt("Current Special Attack"));
        pokemon.setPokemonCurrentSpecialDefense(pokemonJson.getInt("Current Special Defense"));
        return pokemon;
    }

    private Pokemon parseActivePokemon(JSONObject jsonObject, Pokemon[] ourPokemon) {
        JSONObject json = jsonObject.getJSONObject("Active Pokemon");
        JSONObject jsonActivePokemon = json.getJSONObject("Our active pokemon");
        Pokemon pokemon = new Pokemon(jsonActivePokemon.getString("Name"));
        pokemon.setPokemonCurrentHP(jsonActivePokemon.getInt("Current HP"));
        pokemon.setPokemonCurrentAttack(jsonActivePokemon.getInt("Current Attack"));
        pokemon.setPokemonCurrentSpecialAttack(jsonActivePokemon.getInt("Current Special Attack"));
        pokemon.setPokemonCurrentSpecialDefense(jsonActivePokemon.getInt("Current Special Defense"));
        pokemon = comparePokemon(ourPokemon, pokemon);
        return pokemon;
    }

    private Pokemon parseOpponentActivePokemon(JSONObject jsonObject, Pokemon[] opponentPokemon) {
        JSONObject json = jsonObject.getJSONObject("Active Pokemon");
        JSONObject jsonActivePokemon = json.getJSONObject("Opponent active pokemon");
        Pokemon pokemon = new Pokemon(jsonActivePokemon.getString("Name"));
        pokemon.setPokemonCurrentHP(jsonActivePokemon.getInt("Current HP"));
        pokemon.setPokemonCurrentAttack(jsonActivePokemon.getInt("Current Attack"));
        pokemon.setPokemonCurrentSpecialAttack(jsonActivePokemon.getInt("Current Special Attack"));
        pokemon.setPokemonCurrentSpecialDefense(jsonActivePokemon.getInt("Current Special Defense"));
        pokemon = comparePokemon(opponentPokemon, pokemon);
        return pokemon;
    }

    private Pokemon comparePokemon(Pokemon[] list, Pokemon pokemon) {
        for (Pokemon x : list) {
            if (x.getName().equals(pokemon.getName())
                    && x.getPokemonCurrentHP() == pokemon.getPokemonCurrentHP()
                    && x.getPokemonCurrentAttack() == pokemon.getPokemonCurrentAttack()
                    && x.getPokemonCurrentSpecialAttack() == pokemon.getPokemonCurrentSpecialAttack()
                    && x.getPokemonCurrentSpecialDefense() == pokemon.getPokemonCurrentSpecialDefense()) {
                return x;
            }
        }
        return null;
    }
}
