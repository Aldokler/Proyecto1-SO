/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Aldokler
 */
public class Arista {
    
    Nodo inicio, fin;
    int distancia;

    public Arista(Nodo inicio, Nodo fin, int distancia) {
        this.inicio = inicio;
        this.fin = fin;
        this.distancia = distancia;
    }

    public Nodo getInicio() {
        return inicio;
    }

    public Nodo getFin() {
        return fin;
    }

    public int getDistancia() {
        return distancia;
    }

    public void setInicio(Nodo inicio) {
        this.inicio = inicio;
    }

    public void setFin(Nodo fin) {
        this.fin = fin;
    }

    public void setDistancia(int distancia) {
        this.distancia = distancia;
    }

    @Override
    public String toString() {
        return "Arista{" + "inicio=" + inicio.getIdentifier() + ", fin=" + fin.getIdentifier() + ", distancia=" + distancia + '}';
    }
    
    
}
