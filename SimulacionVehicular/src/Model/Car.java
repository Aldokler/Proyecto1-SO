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
public class Car extends PApplet implements Runnable{

    private int Identifier;
    private int Velocidad;
    private Nodo inicio;
    private Nodo actual;
    private Nodo destino;
    private boolean estado;
    private float x, y;
    private Object imagen;

    private ArrayList<Nodo> rutas;
    private int rutaActual;
    private PVector posicion;
    private float speed;
    private boolean done;
    private PImage img;

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

    public Car(int dentifier) {
        this.Identifier = Identifier;

        this.Velocidad = 10;
        this.estado = true;

        rutaActual = 0;
        speed = (float) 1.0;
        done = false;
        
    }
    
    @Override
    public void setup() {
        this.img = loadImage("C:/Users/Aldokler/Documents/git/Proyecto1-SO/SimulacionVehicular/src/imagenes/car_0.png");
    }
    
    @Override
    public synchronized void run(){
        while(true){
            if (rutaActual >= rutas.size()) {
                done = true;
            } else {
                PVector destino = rutas.get(rutaActual).getNodo().copy();
                if (posicion.dist(destino) > 1) {
                    move();
                } else {
                   if(isNodoFree(rutas.get(rutaActual).getIdentifier())){
                       rutas.get(rutaActual).setOcupado(true);
                       
                       try {
                           wait(2000);
                       } catch (InterruptedException ex) {
                           Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
                       }
                       rutas.get(rutaActual).setOcupado(false);
                       rutaActual++;
                       notifyAll();
                   }
                   else{
                       try {
                           wait();
                       } catch (InterruptedException ex) {
                           Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
                       }
                       System.out.println("ocupado  " + rutas.get(rutaActual).getIdentifier());
                   }
                }

            }
            try {
                wait(15);
            } catch (InterruptedException ex) {
                Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }


    public void display(PApplet p) {
        p.fill(150);
        p.circle(posicion.x, posicion.y, 10);
    }
    public void move() {
        PVector destino = rutas.get(rutaActual).getNodo().copy();
        PVector direccion = PVector.sub(destino, posicion);
        direccion.normalize().mult(speed);
        posicion.add(direccion);
        //x = posicion.x;
       // y = posicion.y;

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
        return imagen;
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
        posicion = rutas.get(0).getNodo().copy();
        x = posicion.x;
        y = posicion.y;
    }

}
