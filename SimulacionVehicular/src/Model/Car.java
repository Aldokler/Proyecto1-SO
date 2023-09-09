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
    Nodo destino;
    boolean estado;
    int x, y;
    Object imagen;
    ArrayList ruta;

    public Car(String Identifier, Nodo destino, int x, int y) {
        this.Identifier = Identifier;
        this.destino = destino;
        this.x = x;
        this.y = y;
        this.Velocidad = 10;
        this.estado = true;
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
