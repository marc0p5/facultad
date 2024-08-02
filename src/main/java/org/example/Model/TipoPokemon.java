package org.example.Model;

public abstract class TipoPokemon {
    private String nombre;

    public TipoPokemon(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public abstract void  hacerDaño(double damage,Pokemon PokemonQueAtaca, Pokemon pokemonAtacado) ;
}
