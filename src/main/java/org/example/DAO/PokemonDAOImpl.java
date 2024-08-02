package org.example.DAO;

import org.example.Model.*;
import org.example.Model.TiposPokemon.*;

import java.sql.*;


public class PokemonDAOImpl implements PokemonDAO {
    private static final String URL = "jdbc:h2:./data/test";
    private static final String USER = "sa";
    private static final String PASSWORD = "";
    private static final String TABLE_NAME = "pokemon";

    public PokemonDAOImpl() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            String createTableQuery = " DROP TABLE " + TABLE_NAME + ";" + "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                    "(id INT AUTO_INCREMENT PRIMARY KEY, especie VARCHAR(255), tipo VARCHAR(255), energia DOUBLE, poder DOUBLE, id_entrenador INT)";
            statement.executeUpdate(createTableQuery);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void registrarPokemon(Pokemon pokemon) {
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);){
            String insertQuery = "INSERT INTO " + TABLE_NAME + " (especie, tipo, energia, poder, id_entrenador) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, pokemon.getEspecie());
            pst.setString(2, pokemon.getTipo().getNombre());
            pst.setDouble(3, pokemon.getEnergia());
            pst.setDouble(4, pokemon.getPoder() );
            pst.setInt(5, pokemon.getIdEntrenador() );
            pst.executeUpdate();

            ResultSet generateKeys = pst.getGeneratedKeys();
            if (generateKeys.next()) {
                int id = generateKeys.getInt(1);
                pokemon.setId(id);
            }

            System.out.println("El pokemon " + pokemon.getEspecie() + " del tipo " + pokemon.getTipo() + " con " + pokemon.getEnergia() + " de energia y " + pokemon.getPoder() +" de poder se ha añadido");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Pokemon retornarPokemonPorID(int id) {
        Pokemon pokemon= null;
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);){
            String insertQuery = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
            PreparedStatement pst = connection.prepareStatement(insertQuery);
            pst.setInt(1, id);
            try(ResultSet rs = pst.executeQuery()){
                if (rs.next()){
                    String especie = rs.getString("especie");
                    String tipoString = rs.getString("tipo");
                    TipoPokemon tipo = null;
                    switch (tipoString) {
                        case "Electrico":
                            tipo = new Electrico("Electrico");
                            break;
                        case "Agua":
                            tipo = new Agua("Agua");
                            break;
                        case "fuego":
                            tipo = new Fuego("Fuego");
                            break;
                        case "planta":
                            tipo = new Planta("Plata");
                            break;
                        case "piedra":
                            tipo = new Piedra("Piedra");
                            break;
                            }
                    double energia = rs.getFloat("energia");
                    double poder = rs.getFloat("poder");
                    int idEntrenador  = rs.getInt("id_entrenador");
                    
                    pokemon = new Pokemon (especie, tipo, energia, poder, idEntrenador);
                }
            }
            System.out.println("El pokemon buscado es: " + pokemon.getEspecie() + " del tipo " + pokemon.getTipo() + " con " + pokemon.getEnergia() + " de energia y " + pokemon.getPoder() +" de poder");
        }catch(SQLException e){
            e.printStackTrace();
        }
        return pokemon;
    }

    @Override
    public void modificarPokemon(Pokemon pokemon, int id) {
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);){
            String insertQuery = "UPDATE " + TABLE_NAME + " SET especie = ? , tipo = ?, energia = ?, poder = ?, id_entrenador = ? WHERE id = ?";
            PreparedStatement pst = connection.prepareStatement(insertQuery);
            pst.setString(1, pokemon.getEspecie());
            pst.setString(2, pokemon.getTipo().getNombre());
            pst.setDouble(3, pokemon.getEnergia());
            pst.setDouble(4, pokemon.getPoder() );
            pst.setInt(5, pokemon.getIdEntrenador());
            pst.setInt(6, id);
            pst.executeUpdate();
            pst.close();
            System.out.println("El pokemon " + pokemon.getEspecie() + " del tipo " + pokemon.getTipo() + " con " + pokemon.getEnergia() + " de energia y " + pokemon.getPoder() +" ha sido modifiado con exito!");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarPokemon(int id) {
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);){
            String insertQuery = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";
            PreparedStatement pst = connection.prepareStatement(insertQuery);
            pst.setInt(1, id);
            pst.executeUpdate();
            pst.close();
            System.out.println("El pokemon con el id: " + id+ "ha sido eliminado con exito! ");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void capturarPokemon(int id, int idEntrenador) {
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);){
            String updateQuery = "UPDATE " + TABLE_NAME + " SET id_entrenador = ? WHERE id = ? AND energia = 0";
            PreparedStatement pst = connection.prepareStatement(updateQuery);
            pst.setInt(1, idEntrenador);
            pst.setInt(2, id);
            int filasAfectadas = pst.executeUpdate();
            if (filasAfectadas > 0) {
                System.out.println("El pokemon con id " + id + " ha sido capturado con exito por: " + idEntrenador);
            } else {
                System.out.println("El pokemon no puede ser capturado!Hidropulso");
            }
            pst.close();
        } catch(SQLException e) {
            e.printStackTrace();
        }
    }
}
