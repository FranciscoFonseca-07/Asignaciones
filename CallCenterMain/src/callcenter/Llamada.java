package callcenter;

import java.util.Random;

public class Llamada {
    public enum Tipo {normal, prioritaria}
    
    private int id;
    private String cliente;
    private Tipo tipo;
    private double duracion;

    public Llamada(int id, String cliente, Tipo tipo, double duracion) {
        this.id = id;
        this.cliente = cliente;
        this.tipo = tipo;
        this.duracion = duracion;
    }
    
    public int obtenerPuntuacion(){
        Random rand = new Random();
        return rand.nextInt(10) +1;
    }
    
    public int getId() {return id;}
    public String getCliente() {return cliente;}
    public Tipo getTipo() { return tipo;}
    public double getDuracion() { return duracion;}
}
