/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *  Clase de nodo, 
 * guarda aristas, 
 * un identificador, 
 * la tasa de creacion de carros
 * y un estado de ocupado o no para cuando pasen los carros
 * 
 * @author jeffr
 */
public class Nodo {
    
    String identifier;
    float tasaCreacion;
    ArrayList aristas;
    boolean ocupado;

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public float getTasaCreacion() {
        return tasaCreacion;
    }

    public void setTasaCreacion(float tasaCreacion) {
        this.tasaCreacion = tasaCreacion;
    }

    public boolean isOcupado() {
        return ocupado;
    }

    public void setOcupado(boolean ocupado) {
        this.ocupado = ocupado;
    }

    public Nodo() {
    }

    public Nodo(float tasaCreacion, boolean ocupado) {
        this.tasaCreacion = tasaCreacion;
        this.ocupado = ocupado;
    }

    @Override
    public String toString() {
        return "Nodo{" + "identifier=" + identifier + ", tasaCreacion=" + tasaCreacion + ", aristas=" + aristas + ", ocupado=" + ocupado + '}';
    }
    
}
