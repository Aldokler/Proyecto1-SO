/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import Model.Arista;

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
    ArrayList<Arista> aristas;
    boolean ocupado;
    int x, y;
    boolean visitado;

    public boolean isVisitado() {
        return visitado;
    }
    

    public String getIdentifier() {
        return identifier;
    }
    public Arista getShortest(ArrayList<Arista> ar){
    Arista cerca = null;
    int nearest = Integer.MAX_VALUE;
    for(int i=0;i<aristas.size();i++){
        Arista a = aristas.get(i);
        if(!ar.contains(a)){
            if(a.getDistancia()<= nearest){
                nearest = a.getDistancia();
                cerca = a;
            }
        }
    }
    return cerca;
    }

    public void setVisitado(boolean visitado) {
        this.visitado = visitado;
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
        this.aristas = new ArrayList();
    }

    public Nodo(float tasaCreacion, boolean ocupado) {
        this.aristas = new ArrayList();
        this.tasaCreacion = tasaCreacion;
        this.ocupado = ocupado;
    }

    public Nodo(String identifier) {
        this.identifier = identifier;
        this.aristas = new ArrayList();
    }
    

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
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
