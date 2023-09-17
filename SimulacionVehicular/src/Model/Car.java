/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author Aldokler
 */
public class Car {
    
    String Identifier;
    int Velocidad;
    Nodo inicio;
    Nodo actual;
    Nodo destino;
    boolean estado;
    int x, y;
    Object imagen;
    ArrayList ruta;

    public Car(String Identifier, Nodo inicio, Nodo destino, int x, int y) {
        this.Identifier = Identifier;
        this.inicio = inicio;
        this.actual = inicio;
        this.destino = destino;
        this.x = x;
        this.y = y;
        this.Velocidad = 10;
        this.estado = true;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public Nodo getActual() {
        return actual;
    }

    public void setActual(Nodo actual) {
        this.actual = actual;
    }
    
    public String getIdentifier() {
        return Identifier;
    }

    public int getVelocidad() {
        return Velocidad;
    }

    public Nodo getDestino() {
        return destino;
    }

    public boolean isEstado() {
        return estado;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Object getImagen() {
        return imagen;
    }

    public void setVelocidad(int Velocidad) {
        this.Velocidad = Velocidad;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public ArrayList getRuta() {
        return ruta;
    }

    public void setRuta(ArrayList ruta) {
        this.ruta = ruta;
    }
    
    
}
