/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import processing.core.PApplet;

/**
 *
 * @author Aldokler
 */
public class Arista extends PApplet{
    
    private Nodo inicio, fin;
    private float distancia;

    public Arista(Nodo inicio, Nodo fin, float distancia) {
        this.inicio = inicio;
        this.fin = fin;
        this.distancia = distancia;
    }
    
    public  void display(PApplet p){
        //p.strokeWeight(9); 
        p.line(inicio.getX(), inicio.getY(), fin.getX(), fin.getY());
    }

    public Nodo getInicio() {
        return inicio;
    }

    public Nodo getFin() {
        return fin;
    }

    public float getDistancia() {
        return distancia;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    public void setDistancia(float distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "Arista{" + "inicio=" + inicio.getIdentifier() + ", fin=" + fin.getIdentifier() + ", distancia=" + distancia + '}';
    }
    
    
}
