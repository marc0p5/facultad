package org.example.Model.TiposPokemon;

import org.example.Model.Pokemon;
import org.example.Model.TipoPokemon;

public class Agua extends TipoPokemon {
    public Agua(String nombre) {
        super("Agua");
    }

    @Override
    public void hacerDaño(double damage,Pokemon PokemonQueAtaca, Pokemon pokemonAtacado) {
        if (pokemonAtacado.getTipo().getNombre().equalsIgnoreCase("Fuego")) {
            damage = damage * 0.25;
            System.out.println("El daño del pokemon le jugo en contra ya que "+ pokemonAtacado.getEspecie() + " , es de tipo Fuego y al ser de Agua le saca un 25% de su ataque restandole "+damage +" de vida");
            PokemonQueAtaca.restarVida(damage);
        }else {
            System.out.println("Buen ataque de parte de "+ PokemonQueAtaca.getEspecie() + " a "+ pokemonAtacado.getEspecie() + " restandole "+ damage+" de daño");
            pokemonAtacado.restarVida(damage);
        }
    }
}
