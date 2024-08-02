package org.example.Model;

public class Poder {
    private String nombre;
    private double costoPoder;
    private double damage;

    public Poder(String nombre, double costoPoder, double damage) {
        this.nombre = nombre;
        this.costoPoder = costoPoder;
        this.damage = damage;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCostoPoder() {
        return costoPoder;
    }

    public void setCostoPoder(double costoPoder) {
        this.costoPoder = costoPoder;
    }

    public double getDaño() {
        return damage;
    }

    public void setDaño(double daño) {
        this.damage = damage;
    }

}
