package org.example.Logica;

import org.example.DAO.EntrenadorDAO;
import org.example.DAO.EntrenadorDAOImpl;
import org.example.DAO.PokemonDAO;
import org.example.DAO.PokemonDAOImpl;
import org.example.Model.*;
import org.example.Model.TiposPokemon.*;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        EntrenadorDAO entrenadorDAO = new EntrenadorDAOImpl();
        PokemonDAO pokemonDAO = new PokemonDAOImpl();

        Electrico electrico = new Electrico("Electrico");
        Agua agua = new Agua("Agua");
        Planta planta = new Planta("Planta");
        Fuego fuego = new Fuego("Fuego");
        Piedra piedra = new Piedra("Piedra");


        Poder poderInfernape = new Poder("Giro Fuego", 5, 15);
        Poder poderRoserade = new Poder("Campo de Hierva", 5, 25);
        Poder poderGeodude = new Poder("Placaje", 5, 35);
        Poder poderEmpoleon = new Poder("Aqua Jet", 5, 50);
        Poder poderElectabuzz = new Poder("Impactrueno", 5, 30);
        Poder poderKyogre = new Poder("Hidropulso", 5, 45);

        Date fechaAsh = new Date(2005,2,23);
        Date fechaDawn = new Date(1994,2,23);
        Entrenador Ash= new Entrenador("Ash", Genero.MASCULINO, 19,fechaAsh, "Kanto", "Pueblo Paleta");
        Entrenador Dawn= new Entrenador("Dawn", Genero.FEMENINO, 30, fechaDawn,"Sinnoh" ,"Pueblo HojaVerde");
        entrenadorDAO.registrarEntrenador(Ash);
        entrenadorDAO.registrarEntrenador(Dawn);

        Pokemon Infernape= new Pokemon("Infernape",fuego ,90, 76,poderInfernape );
        Pokemon Roserade= new Pokemon("Roserade",planta ,76, 32,poderRoserade );
        Pokemon Geodude= new Pokemon("Geodude",piedra ,20, 57,poderGeodude );
        Pokemon Empoleon= new Pokemon("Empoleon",agua ,40, 63,poderEmpoleon );
        Pokemon Electabuzz= new Pokemon("Electabuzz",electrico ,82,94 ,poderElectabuzz );
        Pokemon Kyogre= new Pokemon("Kyogre",agua ,96, 81, poderKyogre);
        pokemonDAO.registrarPokemon(Infernape);
        pokemonDAO.registrarPokemon(Roserade);
        pokemonDAO.registrarPokemon(Geodude);
        pokemonDAO.registrarPokemon(Empoleon);
        pokemonDAO.registrarPokemon(Electabuzz);
        pokemonDAO.registrarPokemon(Kyogre);


        Dawn.capturarPokemon(Infernape);
        pokemonDAO.capturarPokemon(1,1);
        Dawn.capturarPokemon(Roserade);
        pokemonDAO.capturarPokemon(2,1);
        Dawn.capturarPokemon(Geodude);
        pokemonDAO.capturarPokemon(3,1);
        Dawn.capturarPokemon(Empoleon);
        pokemonDAO.capturarPokemon(4,2);
        Dawn.capturarPokemon(Electabuzz);
        pokemonDAO.capturarPokemon(5,2);
        Dawn.capturarPokemon(Kyogre);
        pokemonDAO.capturarPokemon(6,2);

        System.out.println("-------------------");
        System.out.println("El entrenador " + Dawn.getNombre() + " ha decidido curar a " + Roserade.getEspecie() + " y " + Geodude.getEspecie());
        Roserade.aumentarVida(10);
        Geodude.aumentarVida(10);

        System.out.println("-------------------");
        Ash.enfrentarseA(Dawn);


        System.out.println("------------------- \n Dos pokemons se pelean");
        Infernape.getTipo().hacerDaño(30, Infernape, Roserade);
        Electabuzz.getTipo().hacerDaño(15, Electabuzz, Empoleon);
        Kyogre.getTipo().hacerDaño(20, Kyogre, Infernape);


        System.out.println("-------------------");
        System.out.println("DAO");
        entrenadorDAO.retornarEntrenadorPorID(2);
        pokemonDAO.retornarPokemonPorID(2);
        entrenadorDAO.EnfrentarseA(2,3);
        Poder poderPrueba = new Poder("X", 100, 100);
        Pokemon PokemonPrueba= new Pokemon("PokemonPrueba",piedra ,100, 100, poderPrueba);
        pokemonDAO.modificarPokemon(PokemonPrueba, 6);
        pokemonDAO.retornarPokemonPorID(6);




    }
}