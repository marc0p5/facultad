package org.example.DAO;

import org.example.Model.Entrenador;
import org.example.Model.Genero;
import java.util.Date;
import java.sql.*;


public class EntrenadorDAOImpl implements EntrenadorDAO{
    private static final String URL = "jdbc:h2:./data/test";
    private static final String USER = "sa";
    private static final String PASSWORD = "";
    private static final String TABLE_NAME = "entrenador";

    public EntrenadorDAOImpl() {
        try {
            Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
            Statement statement = connection.createStatement();
            String createTableQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME +
                    "(id INT AUTO_INCREMENT PRIMARY KEY, nombre VARCHAR(255), direccion VARCHAR(255), edad INT, fechaNacimiento DATE, genero VARCHAR(255), nacionalidad VARCHAR(255))";
            statement.executeUpdate(createTableQuery);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void registrarEntrenador(Entrenador entrenador) {
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);){
            String insertQuery = "INSERT INTO " + TABLE_NAME + " (nombre, direccion, edad, fechaNacimiento, genero, nacionalidad) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement pst = connection.prepareStatement(insertQuery, Statement.RETURN_GENERATED_KEYS);
            pst.setString(1, entrenador.getNombre());
            pst.setString(2, entrenador.getDireccion());
            pst.setInt(3, entrenador.getEdad());

            pst.setDate(4, new java.sql.Date(entrenador.getFechaNacimiento().getTime()));
            pst.setString(5, entrenador.getGenero().name());
            pst.setString(6, entrenador.getNacionalidad());
            pst.executeUpdate();

            ResultSet generateKeys = pst.getGeneratedKeys();
            if (generateKeys.next()) {
                int id = generateKeys.getInt(1);
                entrenador.setId(id);
            }

            System.out.println("El entrenador " + entrenador.getNombre() + " con la nacionalidad " + entrenador.getNacionalidad() + " de " + entrenador.getEdad() + " años, con la fecha de nacimiento " + entrenador.getFechaNacimiento() +" ,con la direccion " + entrenador.getDireccion() +
                    " y el genero " + entrenador.getGenero() + " se ha añadido");
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public Entrenador retornarEntrenadorPorID(int id) {
        Entrenador entrenador= null;
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);){
            String insertQuery = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
            PreparedStatement pst = connection.prepareStatement(insertQuery);
            pst.setInt(1, id);
            try(ResultSet rs = pst.executeQuery()){
                if (rs.next()){
                    String nombre = rs.getString("nombre");
                    String direccion = rs.getString("direccion");
                    int edad = rs.getInt("edad");
                    Date fechaNacimiento = rs.getDate("fechaNacimiento");
                    String generoString = rs.getString("genero");
                    Genero genero = Genero.valueOf(generoString.toUpperCase());
                    String nacionalidad = rs.getString("nacionalidad");

                    entrenador = new Entrenador (nombre, genero, edad, fechaNacimiento, nacionalidad, direccion);
                }
            }
            System.out.println("El entrenador buscado es: " + entrenador.getNombre() + " con la nacionalidad " + entrenador.getNacionalidad() + " de " + entrenador.getEdad() + " años, con la fecha de nacimiento " + entrenador.getFechaNacimiento() +" ,con la direccion " + entrenador.getDireccion() +
                    " y el genero " + entrenador.getGenero());
        }catch(SQLException e){
            e.printStackTrace();
        }
        return entrenador;
    }

    @Override
    public void modificarEntrenador(Entrenador entrenador, int id) {
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);){
            String insertQuery = "UPDATE " + TABLE_NAME + " SET nombre = ? , direccion = ?, edad = ?, fechaNacimiento = ?, genero = ?, nacionalidad = ? WHERE id = ?";
            PreparedStatement pst = connection.prepareStatement(insertQuery);
            pst.setString(1, entrenador.getNombre());
            pst.setString(2, entrenador.getDireccion());
            pst.setInt(3, entrenador.getEdad());
            pst.setDate(4, new java.sql.Date(entrenador.getFechaNacimiento().getTime()));
            pst.setString(5, String.valueOf(entrenador.getGenero()));
            pst.setString(6, entrenador.getNacionalidad());
            pst.setInt(7, id);
            pst.executeUpdate();
            pst.close();
            System.out.println("El entrenador " + entrenador.getNombre() + " con la nacionalidad " + entrenador.getNacionalidad() + " de" + entrenador.getEdad() + " años, con la fecha de nacimiento " + entrenador.getFechaNacimiento() +" ,con la direccion " + entrenador.getDireccion() +
                    " y el genero " + entrenador.getGenero() + " Ha sido modificado con exito!");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    @Override
    public void eliminarEntrenador(int id) {
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);){
            String insertQuery = "DELETE FROM " + TABLE_NAME + " WHERE id = ?";
            PreparedStatement pst = connection.prepareStatement(insertQuery);
            pst.setInt(1, id);
            pst.executeUpdate();
            pst.close();
            System.out.println("El entrenador con el id: " + id +"ha sido eliminado con exito!");
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    public void EnfrentarseA(int id, int id2){
        Entrenador entrenador1 = null;
        Entrenador entrenador2 = null;
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);){
            String insertQuery = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
            PreparedStatement pst = connection.prepareStatement(insertQuery);
            pst.setInt(1, id);
            try(ResultSet rs = pst.executeQuery()){
                if (rs.next()){
                    String nombre = rs.getString("nombre");
                    String direccion = rs.getString("direccion");
                    int edad = rs.getInt("edad");
                    Date fechaNacimiento = rs.getDate("fechaNacimiento");
                    String generoString = rs.getString("genero");
                    Genero genero = Genero.valueOf(generoString.toUpperCase());
                    String nacionalidad = rs.getString("nacionalidad");

                    entrenador1 = new Entrenador (nombre, genero, edad, fechaNacimiento, nacionalidad, direccion);
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);){
            String insertQuery = "SELECT * FROM " + TABLE_NAME + " WHERE id = ?";
            PreparedStatement pst = connection.prepareStatement(insertQuery);
            pst.setInt(1, id2);
            try(ResultSet rs = pst.executeQuery()){
                if (rs.next()){
                    String nombre = rs.getString("nombre");
                    String direccion = rs.getString("direccion");
                    int edad = rs.getInt("edad");
                    Date fechaNacimiento = rs.getDate("fechaNacimiento");
                    String generoString = rs.getString("genero");
                    Genero genero = Genero.valueOf(generoString.toUpperCase());
                    String nacionalidad = rs.getString("nacionalidad");

                    entrenador2 = new Entrenador (nombre, genero, edad, fechaNacimiento, nacionalidad, direccion);
                }
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        int ganador=(int) (Math.random() * (2+1));
        if (ganador == 1){
            System.out.println("El ganador de la pelea ha sido " +  entrenador1.getNombre() + " ,derrotando a "+ entrenador2.getNombre());
        }else {
            System.out.println("El de la pelea ha sido " +  entrenador2.getNombre()+ " ,derrotando a "+ entrenador1.getNombre());
        }
    }
}
