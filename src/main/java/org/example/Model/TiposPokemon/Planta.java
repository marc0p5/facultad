package org.example.Model.TiposPokemon;

import org.example.Model.Pokemon;
import org.example.Model.TipoPokemon;

public class Planta extends TipoPokemon {
    public Planta(String nombre) {
        super("Planta");
    }

    @Override
    public void hacerDaño(double damage,Pokemon PokemonQueAtaca, Pokemon pokemonAtacado) {
        if (pokemonAtacado.getTipo().getNombre().equalsIgnoreCase("Piedra")) {
            System.out.println("El daño del pokemon fue en vano ya que ataco a "+ pokemonAtacado.getEspecie() + " , pokemon de tipo Piedra");
        }else {
            System.out.println("Buen ataque de parte de "+ PokemonQueAtaca.getEspecie() + " a "+ pokemonAtacado.getEspecie() + " restandole "+ damage+" de vida");
            pokemonAtacado.restarVida(damage);
        }
    }
}
