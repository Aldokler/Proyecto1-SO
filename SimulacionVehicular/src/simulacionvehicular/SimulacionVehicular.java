/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simulacionvehicular;
import java.util.ArrayList;
import Model.*;
import java.util.Random; 

/**
 *
 * @author aldokler
 */
public class SimulacionVehicular {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args){
    ArrayList<Nodo> nodosList = new ArrayList();
    for(int i =0;i<9;i++){
        Nodo n = new Nodo(i);
        nodosList.add(n);
    }
    Arista a12 = new Arista(nodosList.get(0),nodosList.get(1), 2);
    Arista a23 = new Arista(nodosList.get(1),nodosList.get(2), 10);
    Arista a25 = new Arista(nodosList.get(1),nodosList.get(4), 15);
    Arista a34 = new Arista(nodosList.get(2),nodosList.get(3), 11);
    Arista a56 = new Arista(nodosList.get(4),nodosList.get(5), 12);
    Arista a67 = new Arista(nodosList.get(5),nodosList.get(6), 5);
    Arista a68 = new Arista(nodosList.get(5),nodosList.get(7), 15);
    Arista a42 = new Arista(nodosList.get(4),nodosList.get(2), 8);
    Arista a78 = new Arista(nodosList.get(7),nodosList.get(8), 20);
    
    nodosList.get(0).addArista(a12);
    nodosList.get(1).addArista(a12);
    
    nodosList.get(1).addArista(a23);
    nodosList.get(2).addArista(a23);
    
    nodosList.get(1).addArista(a25);
    nodosList.get(4).addArista(a25);
    
    nodosList.get(2).addArista(a34);
    nodosList.get(3).addArista(a34);
    
    nodosList.get(4).addArista(a56);
    nodosList.get(5).addArista(a56);
    
    nodosList.get(5).addArista(a67);
    nodosList.get(6).addArista(a67);
    
    nodosList.get(5).addArista(a68);
    nodosList.get(7).addArista(a68);
    
    nodosList.get(4).addArista(a42);
    nodosList.get(2).addArista(a42);
    
    nodosList.get(7).addArista(a78);
    nodosList.get(8).addArista(a78);
    
    Car carrito = new Car(1, nodosList.get(8), nodosList.get(0), 12, 23);
    ArrayList<Nodo> rutaa = Grafo.Dijsktra(carrito);
    
    for(int i =0;i<rutaa.size();i++){
        System.out.println("-"+rutaa.get(i).getIdentifier()+"-");
    }
    
    /*    
    for (int i = 0; i < 8; i++){
            Nodo n = nodosList.get(i);
            System.out.println("Nodo N"+i+"\n");
            for(int j = 0; j < n.getAristas().size(); j++){
                System.out.println("    Arista N"+j+"\n");
            }
            System.out.println("\n");
        }
    */
        
        
    }
    /*
    public static void main(String[] args) {
        // TODO code application logic here
        Random rand = new Random();
        int nodos = rand.nextInt(100, 1000);
        int aristas = rand.nextInt(100, nodos);
        
        ArrayList<Nodo> nodosList = new ArrayList();
        ArrayList<Arista> aristasList = new ArrayList();
        
        for (int i = 0; i < nodos; i++){
            nodosList.add(new Nodo(String.valueOf(i)));
        }
        for (int i = 0; i < aristas; i++){
            Nodo n1 = nodosList.get(rand.nextInt(nodos));
            Nodo n2 = nodosList.get(rand.nextInt(nodos));
            while (n1 == n2){
                n2 = nodosList.get(rand.nextInt(nodos));
            }
            aristasList.add(new Arista(n1, n2, rand.nextInt(10, 100)));
            n1.addArista(aristasList.get(i));
            n2.addArista(new Arista(n1, n2, rand.nextInt(10, 100)));
        }
        
        
        
       // Descomente esto si desea quitar los nodos sin aristas
        
        for (int i = 0; i < nodos; i++){
            if (nodosList.get(i).getAristas().isEmpty()){
                nodosList.remove(i);
                i--;
                nodos--;
            }
        }
        
        /*
        for (int i = 0; i < nodos; i++){
            Nodo n = nodosList.get(i);
            System.out.println("Nodo N"+i+"\n");
            for(int j = 0; j < n.getAristas().size(); j++){
                System.out.println("    Arista N"+j+"\n");
            }
            System.out.println("\n");
        }
      
        Car carrito = new Car("tsuru-tuneado", nodosList.get(0), nodosList.get(50), 12, 23);
        ArrayList<Nodo> rutaa = grafo.Dijsktra(carrito);
    }
    
    */
}
