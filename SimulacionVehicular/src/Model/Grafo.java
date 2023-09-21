/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import View.Main;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import processing.core.PApplet;
import static processing.core.PApplet.dist;

/**
 *
 * @author jeffr
 */
public class Grafo {

    static ArrayList<Nodo> nodos;
    static ArrayList<Thread> generadores;
    static ArrayList<Car> carros;
    static ArrayList<Arista> aristas;
    static int contGrafos = 0;
    static int contCarros = 0;
    private long tiempoInicio;
    private int nodo1 = -1;
    private int nodo2 = -1;

    public Grafo() {
        nodos = new ArrayList<Nodo>();
        aristas = new ArrayList<Arista>();
        carros = new ArrayList<Car>();
        generadores = new ArrayList();

    }

    public void clean() {
        carros.clear();
        tiempoInicio = 0;

    }

    public void addCarro() {
        //if (!nodos.get(0).isOcupado()){
        Car car = new Car(contCarros);
        car.setRutas(nodos);
        carros.add(car);
        contCarros++;
        Thread carHilo = new Thread(car);
        carHilo.start();
        //}
    }

    public synchronized void carGenerator(Nodo nodo) {
        while (true) {
            try {
                wait((long) (1000 / nodo.getTasaCreacion()));
                addCarro();
            } catch (InterruptedException ex) {
                Logger.getLogger(Nodo.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void addNodo(float tasaCreacion, float x, float y) {
        Nodo nodo = new Nodo(contGrafos, tasaCreacion, x, y);
        nodos.add(nodo);
        contGrafos++;
        generadores.add(new Thread(() -> {
            carGenerator(nodo);
        }));

        System.out.println(" t " + nodos.size());
        for (Nodo nod : nodos) {
            System.out.println(nod.getX() + "  " + nod.getY() + "\n");
        }

    }

    public int NodoSelected(float x, float y) {
        System.out.println("xy");
        for (Nodo nodo : nodos) {
            float distancia = dist(x, y, nodo.getX(), nodo.getY());
            if (distancia < 10) {
                return nodo.getIdentifier();
            }
        }
        return -5;
    }

    public void crearUnion(float x, float y) {
        System.out.println("crear");
        int id = NodoSelected(x, y);
        if (id >= 0) {
            if (Main.checkInput()) {
                unir(id, Main.numeroInput);
            } else {
                unir(id, 5);
            }
            
        }

    }

    public boolean checkArista(int id1, int id2) {
        for (Arista a : aristas) {
            if ((a.getInicio().getIdentifier() == id1 && a.getFin().getIdentifier() == id2) || (a.getInicio().getIdentifier() == id2 && a.getFin().getIdentifier() == id1)) {
                return false;
            }
        }
        return true;
    }

    public void unir(int ID, float distancia) {
        System.out.println("nodos1-2");
        if (nodo1 == -1) {
            nodo1 = ID;
        } else {
            nodo2 = ID;
            if (nodo1 != nodo2 && checkArista(nodo1, nodo2)) {
                addArista(nodo1, nodo2, distancia);
            }
            nodo1 = -1;
            nodo2 = -2;
        }
    }

    public void addArista(int id1, int id2, float distancia) {
        Nodo nodo1 = getNodo(id1);
        Nodo nodo2 = getNodo(id2);

        Arista arista = new Arista(nodo1, nodo2, distancia);
        nodo1.addArista(arista);
        nodo2.addArista(arista);
        aristas.add(arista);
        System.out.println("aris" + aristas.size());
    }

    public void setTasa(float x, float y) {
        int id = NodoSelected(x, y);
        if (id >= 0) {
            if (Main.checkInput()) {
                nodos.get(id).setTasaCreacion(Main.numeroInput);
                System.out.println("tasa input");
            } else {
                nodos.get(id).setTasaCreacion(15);
            }

        }
    }

    public Nodo getNodo(int id) {
        for (Nodo nodo : nodos) {
            if (nodo.getIdentifier() == id) {
                return nodo;
            }
        }
        return null;
    }

    public void display(PApplet p) {
        for (Nodo n : nodos) {
            n.display(p);
            System.out.println("tasa nodo  " + n.getIdentifier() + "   " + n.getTasaCreacion());

        }

        for (Arista a : aristas) {
            a.display(p);
            System.out.println("arista " + a.getDistancia());
        }

        for (Car car : carros) {
            car.display(p);
        }

        if (tiempoInicio > 0) {
            tiempoSimulacion();
        }
        cantidad();
        velocidad();

    }

    public static String convertir(long milisegundos) {
        long segundos = milisegundos / 1000;
        long minutos = segundos / 60;
        long horas = minutos / 60;

        segundos = segundos % 60;
        minutos = minutos % 60;

        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }

    public void tiempoSimulacion() {
        long t = System.currentTimeMillis() - tiempoInicio;
        Main.tiempoS.setText("Tiempo simulacion: " + convertir(t));
    }

    public void Iniciar() {
        tiempoInicio = System.currentTimeMillis();
        tiempoSimulacion();
    }

    public void cantidad() {
        Main.cantidadC.setText("Cantidad vehiculos: " + carros.size());
    }

    public void velocidad() {
        Main.velocidadP.setText("Velocidad promedio: " + velocidadPromedio());
    }

    public float velocidadPromedio() {
        if (carros.size() > 0) {
            float v = 0;

            for (Car c : carros) {
                v = v + c.getVelocidad();
            }
            return (v / carros.size());
        }
        return 0;
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
