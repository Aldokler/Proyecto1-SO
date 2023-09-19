/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import processing.core.PApplet;
import processing.core.PVector;
import processing.core.PImage;
/**
 *
 * @author Aldokler
 */
public class Car extends PApplet {

    int Identifier;
    int Velocidad;
    Nodo inicio;
    Nodo actual;
    Nodo destino;
    boolean estado;
    float x, y;
    PImage img;

    ArrayList<Nodo> rutas;
    int rutaActual;
    PVector posicion;
    float speed;
    boolean done;

    public Car(int dentifier, Nodo inicio, Nodo destino, float x, float y) {
        this.Identifier = Identifier;
        this.inicio = inicio;
        this.actual = inicio;
        this.destino = destino;
        this.x = x;
        this.y = y;
        this.Velocidad = 10;
        this.estado = true;

        rutaActual = 0;
        speed = (float) 2.0;
        done = false;
    }

    public Car(int dentifier, float x, float y) {
        this.Identifier = Identifier;

        this.x = x;
        this.y = y;
        this.Velocidad = 10;
        this.estado = true;

        rutaActual = 0;
        speed = (float) 2.0;
        done = false;
        
    }
    
    @Override
    public void setup() {
        this.img = loadImage("C:/Users/Aldokler/Documents/git/Proyecto1-SO/SimulacionVehicular/src/imagenes/car_0.png");
    }

    public void update(PApplet p) {
        if (rutaActual >= rutas.size()) {
            done = true;
        } else {
            if (posicion.dist(rutas.get(rutaActual).getNodo()) >= 1) {
                move();
            } else {
               if(isNodoFree(rutas.get(rutaActual).getIdentifier())){
                   /*
                   try {
                       wait(2000);
                   } catch (InterruptedException ex) {
                       Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
                   }*/
                   rutaActual++;
               }
               else{
                   System.out.println("ocupado  " + rutas.get(rutaActual).getIdentifier());
               }
            }

        }

    }

    public void display(PApplet p) {
        p.fill(150);
        p.ellipse(x, y, 10, 10);
        System.out.println(this.img);
        if (this.img != null){
            image(this.img, 0, 0);
        }
    }

    public void move() {
        PVector direccion = PVector.sub(rutas.get(rutaActual).getNodo(), posicion);
        direccion.normalize().mult(speed);
        posicion.add(direccion);
        x = posicion.x;
        y = posicion.y;

    }

    public boolean isNodoFree(int ID) {
        for (Nodo n : Grafo.nodos) {
            if (n.getIdentifier() == ID) {
                if (n.isOcupado()) {
                    return false;
                }
                return true;
            }
        }
        return true;
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

    public int getIdentifier() {
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

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public Object getImagen() {
        return img;
    }

    public void setVelocidad(int Velocidad) {
        this.Velocidad = Velocidad;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public ArrayList getRutas() {
        return rutas;
    }

    public void setRutas(ArrayList<Nodo> rutas) {
        this.rutas = rutas;
        posicion = rutas.get(0).getNodo();
    }

}
