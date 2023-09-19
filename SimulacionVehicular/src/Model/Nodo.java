/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import Model.Arista;
import processing.core.PApplet;
import processing.core.PVector;

/**
 *  Clase de nodo, 
 * guarda aristas, 
 * un identificador, 
 * la tasa de creacion de carros
 * y un estado de ocupado o no para cuando pasen los carros
 * 
 * @author jeffr
 */
public class Nodo extends PApplet{
    
    private int identifier;
    private float tasaCreacion;
    private ArrayList aristas;
    private boolean ocupado;
    private float x, y;
    private PVector nodo;

    public boolean isVisitado() {
        return ocupado;
    }
    

    public int getIdentifier() {
        return identifier;
    }
    public Arista getShortest(ArrayList<Arista> ar){
    Arista cerca = null;
    int nearest = Integer.MAX_VALUE;
    for(int i=0;i<aristas.size();i++){
        Arista a = (Arista) aristas.get(i);
        if(!ar.contains(a)){
            if(a.getDistancia()<= nearest){
                nearest = (int) a.getDistancia();
                cerca = a;
            }
        }
    }
    return cerca;
    }

    public void setVisitado(boolean visitado) {
        this.ocupado = visitado;
    }

    public void setIdentifier(int identifier) {
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
        this.aristas = new ArrayList();
    }

    public Nodo(float tasaCreacion, boolean ocupado) {
        this.aristas = new ArrayList();
        this.tasaCreacion = tasaCreacion;
        this.ocupado = ocupado;
    }
    
    public Nodo(int identifier, float tasaCreacion, float x, float y) {
        this.aristas = new ArrayList();
        this.tasaCreacion = tasaCreacion;
        this.ocupado = false;
        this.x = x;
        this.y = y;
        this.identifier = identifier;
        nodo = new PVector(x, y);
    }

    public PVector getNodo() {
        return nodo;
    }
    
    
    
     public void display(PApplet p) {
         if (ocupado){
             p.fill(255);
             p.circle(x, this.y, 50);
             //p.fill(0);
             //p.circle(x, this.y, 50);
         }
         else{ p.fill(0);
        p.circle(x, this.y, 50);
        }
        
    }

    public Nodo(int identifier) {
        this.identifier = identifier;
        this.aristas = new ArrayList();
    }
    

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public ArrayList getAristas() {
        return aristas;
    }

    public void setAristas(ArrayList aristas) {
        this.aristas = aristas;
    }
    public void addArista(Arista a){
        aristas.add(a);
    }
    
}
