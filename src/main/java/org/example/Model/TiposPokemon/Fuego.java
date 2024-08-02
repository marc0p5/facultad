package org.example.Model.TiposPokemon;

import org.example.Model.Pokemon;
import org.example.Model.TipoPokemon;

public class Fuego extends TipoPokemon {
    public Fuego(String nombre) {
        super("Fuego");
    }

    @Override
    public void hacerDaño(double damage,Pokemon PokemonQueAtaca, Pokemon pokemonAtacado) {
        if (pokemonAtacado.getTipo().getNombre().equalsIgnoreCase("Planta")) {
            damage = damage + damage * 0.25;
            System.out.println("El daño del pokemon fue increible ya que "+ pokemonAtacado.getEspecie() + " , es de tipo Planta y le duele un 25% mas restandole "+damage +" de vida");
            pokemonAtacado.restarVida(damage);
        }else {
            System.out.println("Buen ataque de parte de "+ PokemonQueAtaca.getEspecie() + " a "+ pokemonAtacado.getEspecie() + " restandole "+ damage+" de vida");
            pokemonAtacado.restarVida(damage);
        }
    }

}
