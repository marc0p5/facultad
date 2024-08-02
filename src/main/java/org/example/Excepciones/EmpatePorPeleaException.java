package org.example.Excepciones;


import org.example.Model.Entrenador;

public class EmpatePorPeleaException extends RuntimeException {
    public EmpatePorPeleaException(Entrenador Entrenador, Entrenador otroEntrenador) {
       super("Menuda pelea! El entrenador " + Entrenador.getNombre() +" y " + otroEntrenador.getNombre() +" Tienen el mismo poder en sus pokemones! por lo tanto....hay un empate!");
    }
}
