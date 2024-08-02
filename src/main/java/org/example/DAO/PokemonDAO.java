package org.example.DAO;

import org.example.Model.Pokemon;

public interface PokemonDAO {
    public void registrarPokemon(Pokemon pokemon);
    public Pokemon retornarPokemonPorID(int id);
    public void modificarPokemon(Pokemon pokemon, int id);
    public void eliminarPokemon(int id);
    public void capturarPokemon(int id, int idEntrenador);
}
