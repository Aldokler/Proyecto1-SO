/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;
import processing.core.PApplet;

/**
 *
 * @author jeffr
 */
public class Grafo {

    static ArrayList<Nodo> nodos;
    static ArrayList<Car> carros;
    static ArrayList<Arista> aristas;
    static int contGrafos = 0;
    static int contCarros = 0;

    public Grafo() {
        nodos = new ArrayList<Nodo>();
        aristas = new ArrayList<Arista>();
        carros = new ArrayList<Car>();

    }

    public void addCarro(float x, float y, ArrayList<Nodo> rutas) {
        Car car = new Car(contCarros, x, y);
        car.setRutas(nodos);
        carros.add(car);
        contCarros++;

    }

    public void addNodo(float tasaCreacion, float x, float y) {
        Nodo nodo = new Nodo(contGrafos, tasaCreacion, x, y);
        nodos.add(nodo);
        contGrafos++;

        System.out.println(" t " + nodos.size());
        for (Nodo nod : nodos) {
            System.out.println(nod.getX() + "  " + nod.getY() + "\n");
        }

    }

    public void addArista(int id1, int id2, float distancia) {
        Nodo nodo1 = getNodo(id1);
        Nodo nodo2 = getNodo(id2);

        Arista arista = new Arista(nodo1, nodo2, distancia);
        aristas.add(arista);
    }

    public Nodo getNodo(int id) {
        for (Nodo nodo : nodos) {
            if (nodo.getIdentifier() == id) {
                return nodo;
            }
        }
        return null;
    }

    public static void display(PApplet p) {
        for (Nodo n : nodos) {
            n.display(p);
            
        }

        for (Arista a : aristas) {
            a.display(p);
        }

        for (Car car : carros) {
            car.update(p);
            car.display(p);
        }
    }

    public static ArrayList<Nodo> Dijsktra(Car carro) {
        ArrayList rutaDisjktra = new ArrayList<Nodo>();
        ArrayList arcosRecorridos = new ArrayList<Arista>();
        int lugar = -1;
        Nodo actual = carro.getInicio();

        rutaDisjktra.add(actual);
        while (carro.getDestino() != actual) {
            if (isDestinationNext(actual, carro.getDestino())) {
                Arista ab = getAristaPorNodos(actual, carro.getDestino());
                rutaDisjktra.add(actual);
                arcosRecorridos.add(ab);
                if (ab.getFin() == actual) {
                    actual = ab.getInicio();
                } else {
                    actual = ab.getFin();
                }
                if (!rutaDisjktra.contains(actual)) {
                    rutaDisjktra.add(actual);
                }
            } else {
                Arista ar = actual.getShortest(arcosRecorridos);
                if (ar == null) {
                    ar = (Arista) arcosRecorridos.get(lugar);
                    rutaDisjktra.remove(lugar);
                    lugar--;
                    actual = ar.getInicio();
                } else {
                    if (!rutaDisjktra.contains(actual)) {
                        rutaDisjktra.add(actual);
                    }
                    arcosRecorridos.add(ar);
                    if (ar.getFin() == actual) {
                        actual = ar.getInicio();
                    } else {
                        actual = ar.getFin();
                    }
                    lugar++;
                }
            }
        }
        return rutaDisjktra;
    }

    public static boolean isDestinationNext(Nodo actual, Nodo destino) {
        ArrayList aristasNodoActual = actual.getAristas();
        for (int i = 0; i < aristasNodoActual.size(); i++) {
            Arista a = (Arista) aristasNodoActual.get(i);
            if (a.getFin() == destino || a.getInicio() == destino) {
                return true;
            }
        }
        return false;
    }

    public static Arista getAristaPorNodos(Nodo n1, Nodo n2) {
        Arista a = null;
        for (int i = 0; i < n1.getAristas().size(); i++) {
            Arista ev = (Arista) n1.getAristas().get(i);
            Nodo n = ev.getFin();
            Nodo nn = ev.getInicio();
            if (n == n2 || nn == n2) {
                a = ev;
            }
        }
        return a;
    }

}
