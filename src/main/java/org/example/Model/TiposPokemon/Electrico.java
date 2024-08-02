package org.example.Model.TiposPokemon;

import org.example.Model.Pokemon;
import org.example.Model.TipoPokemon;

public class Electrico extends TipoPokemon {
    public Electrico(String nombre) {
        super("Electrico");
    }

    @Override
    public void hacerDaño(double damage,Pokemon PokemonQueAtaca, Pokemon pokemonAtacado) {
        if (pokemonAtacado.getTipo().getNombre().equalsIgnoreCase("Agua")) {
            double damagePropio = damage * 0.05;
            double damageTop= damage * 0.50;
            System.out.println("El daño del pokemon fue increible pero tambien le jugo en contra ya que "+ pokemonAtacado.getEspecie() + " , es de tipo Agua y al ser Electrico le saca un 5% de su ataque restandole "+damagePropio +" de daño \npero aumenta un 50% su ataque restandole "+damageTop+" de vida");
            PokemonQueAtaca.restarVida(damagePropio);
            pokemonAtacado.restarVida(damageTop);
        }else {
            System.out.println("Buen ataque de parte de "+ PokemonQueAtaca.getEspecie() + " a "+ pokemonAtacado.getEspecie() + " restandole "+ damage+" de vida");
            pokemonAtacado.restarVida(damage);
        }
    }
}
