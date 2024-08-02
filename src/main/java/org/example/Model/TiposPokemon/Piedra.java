package org.example.Model.TiposPokemon;

import org.example.Model.Pokemon;
import org.example.Model.TipoPokemon;

public class Piedra extends TipoPokemon {
    public Piedra(String nombre) {
        super("Piedra");
    }

    @Override
    public void hacerDaño(double damage,Pokemon PokemonQueAtaca, Pokemon pokemonAtacado) {
            System.out.println("Buen ataque de parte de "+ PokemonQueAtaca.getEspecie() + " a "+ pokemonAtacado.getEspecie() + " restandole "+ damage+" de vida");
            pokemonAtacado.restarVida(damage);
    }
}
