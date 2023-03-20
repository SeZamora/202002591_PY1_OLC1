/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package analizador;

/**
 *
 * @author SEBASTIAN ZAMORA
 */
public class Entrada {
    private String nombre;
    private String entrada;


    public Entrada(String nombre, String entrada){
        this.nombre=nombre;
        this.entrada=entrada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEntrada() {
        return entrada;
    }

    public void setEntrada(String entrada) {
        this.entrada = entrada;
    }
}

