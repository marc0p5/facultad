package org.example.DAO;

import org.example.Model.Entrenador;

public interface EntrenadorDAO {
    public void registrarEntrenador(Entrenador entrenador);
    public Entrenador retornarEntrenadorPorID(int id);
    public void modificarEntrenador(Entrenador entrenador, int id);
    public void eliminarEntrenador(int id);
    public void EnfrentarseA(int id, int id2);
}
