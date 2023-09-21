/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PVector;
import processing.core.PImage;

/**
 *
 * @author Aldokler
 */
public class Car extends PApplet implements Runnable {

    private int Identifier;
    private int Velocidad;
    private Nodo inicio;
    private Nodo actual;
    private Nodo destino;
    private boolean estado;
    private float x, y;
    private Object imagen;
    private Lock lock;
    
    private int r, g, b;

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
        this.lock = new ReentrantLock();

        rutaActual = 0;
        speed = (float) 2.0;
        done = false;
        
        Random rand = new Random();
        r = rand.nextInt(256);
        g = rand.nextInt(256);
        b = rand.nextInt(256);
    }

    public Car(int dentifier) {
        this.Identifier = dentifier;

        this.Velocidad = 10;
        this.estado = true;

        rutaActual = 0;
        speed = (float) 1.0;
        done = false;
        this.lock = new ReentrantLock();
        
        Random rand = new Random();
        r = rand.nextInt(256);
        g = rand.nextInt(256);
        b = rand.nextInt(256);

    }

    @Override
    public void setup() {
        this.img = loadImage("C:/Users/Aldokler/Documents/git/Proyecto1-SO/SimulacionVehicular/src/imagenes/car_0.png");
    }

    @Override
    public synchronized void run() {
        while (true) {
            if (rutaActual >= rutas.size()) {
                done = true;
            } else {
                PVector destino = rutas.get(rutaActual).getNodo().copy();
                if (posicion.dist(destino) > 1) {
                    move();
                } else {
                    if (isNodoFree(rutas.get(rutaActual).getIdentifier()) && !rutas.get(rutaActual).getCola().contains(this.Identifier)) {
                        lock.lock();
                        try {
                            rutas.get(rutaActual).setOcupado(true);
                        } finally {
                            lock.unlock();
                        }
                        try {
                            wait(2000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        lock.lock();
                        try {
                            rutas.get(rutaActual).setOcupado(false);
                            if (!rutas.get(rutaActual).getCola().isEmpty()) {
                                rutas.get(rutaActual).getCola().remove(0);
                            }
                            rutaActual++;
                        } finally {
                            lock.unlock();
                        }

                        notifyAll();
                    } else {

                        lock.lock();
                        try {
                            if (!rutas.get(rutaActual).getCola().contains(this.Identifier)){
                                rutas.get(rutaActual).getCola().add(this.Identifier);
                            }
                        } finally {
                            lock.unlock();
                        }

                        try {
                            wait(15);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Car.class.getName()).log(Level.SEVERE, null, ex);
                        }
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
        p.fill(this.r, this.g, this.b);
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
    public void setDestino(Nodo destino) {
        this.destino = destino;
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
        rutaActual++;
        PVector destino = rutas.get(rutaActual).getNodo().copy();
        x = posicion.x;
        y = posicion.y;
        for (int i = 0; i < 10; i++){
            move();
        }
    }

}
