package org.example.Model;
import org.example.Excepciones.EmpatePorPeleaException;
import org.example.Excepciones.NoSePuedeCapturarPokemonException;

import java.util.Date;
import java.util.LinkedList;

public class Entrenador {
    private String nombre, direccion, nacionalidad;
    private Date fechaNacimiento;
    private int edad;
    private Genero genero;
    private LinkedList<Pokemon> pokemones;
    private int id;

    public Entrenador(String nombre, Genero genero, int edad, Date fechaNacimiento, String nacionalidad ,String direccion) {
        this.nombre = nombre;
        this.genero = genero;
        this.edad = edad;
        this.fechaNacimiento = fechaNacimiento;
        this.nacionalidad = nacionalidad;
        this.direccion = direccion;
        this.pokemones = new LinkedList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public LinkedList<Pokemon> getPokemones() {
        return pokemones;
    }

    public void setPokemones(LinkedList<Pokemon> pokemones) {
        this.pokemones = pokemones;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public double poderTotal(){
        double poderTotal=0;
        for(Pokemon pokemon : this.pokemones){
            double poder =pokemon.getPoder();
            poderTotal += poder;
        }
        return poderTotal;
    }
    public void enfrentarseA(Entrenador otroEntrenador){
        double poderEntrenador1 =  this.poderTotal();
        double poderEntrenador2 = otroEntrenador.poderTotal();


        if(poderEntrenador1 > poderEntrenador2){
            System.out.println("El entrenador "+ this.getNombre() + " gano ya que tiene pokemones con mas poder: " + poderEntrenador1 + " y el otro entrenador "+poderEntrenador2+ " de poder");
        }else if(poderEntrenador1 < poderEntrenador2){
            System.out.println("El entrenador "+ otroEntrenador.getNombre() + " gano ya que tiene pokemones con mas poder: " + poderEntrenador2 + " y el otro entrenador "+poderEntrenador1+ " de poder");
        }else{
            throw new EmpatePorPeleaException(this, otroEntrenador);
        }
    }

    public void capturarPokemon(Pokemon pokemon){
        if (this.pokemones.size()>=5){
            throw new NoSePuedeCapturarPokemonException(this, pokemon);
        }else{
            pokemones.add(pokemon);
            System.out.println("Ha capturado exitosamente a " + pokemon.getEspecie() +" que tiene " + pokemon.getEnergia() + " de vida y " + pokemon.getPoder() + " de poder");
        }
    }


}
