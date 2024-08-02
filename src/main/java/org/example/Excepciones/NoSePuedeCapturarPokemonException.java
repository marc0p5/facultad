package org.example.Excepciones;

import org.example.Model.Entrenador;
import org.example.Model.Pokemon;

public class NoSePuedeCapturarPokemonException extends RuntimeException {
    public NoSePuedeCapturarPokemonException(Entrenador entrenador, Pokemon pokemon) {
        super ("Mala suerte! alcanzaste el limite de pokemones... no puedes capturar a: " + pokemon.getEspecie() + " ");
    }
}
