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
    public static void main(String[] args) {
        // TODO code application logic here
        Random rand = new Random();
        int nodos = rand.nextInt(100, 10000);
        int aristas = rand.nextInt(100, nodos);
        
        ArrayList<Nodo> nodosList = new ArrayList();
        ArrayList<Arista> aristasList = new ArrayList();
        
        for (int i = 0; i < nodos; i++){
            nodosList.add(new Nodo());
        }
        for (int i = 0; i < aristas; i++){
            Nodo n1 = nodosList.get(rand.nextInt(nodos));
            Nodo n2 = nodosList.get(rand.nextInt(nodos));
            while (n1 == n2){
                n2 = nodosList.get(rand.nextInt(nodos));
            }
            aristasList.add(new Arista(n1, n2, rand.nextInt(10, 100)));
            n1.addArista(aristasList.get(i));
            n2.addArista(aristasList.get(i));
        }
        
        /*
        
        Descomente esto si desea quitar los nodos sin aristas
        
        for (int i = 0; i < nodos; i++){
            if (nodosList.get(i).getAristas().isEmpty()){
                nodosList.remove(i);
                i--;
                nodos--;
            }
        }
        */
        
        for (int i = 0; i < nodos; i++){
            Nodo n = nodosList.get(i);
            System.out.println("Nodo N"+i+"\n");
            for(int j = 0; j < n.getAristas().size(); j++){
                System.out.println("    Arista N"+j+"\n");
            }
            System.out.println("\n");
        }
        
    }
    
}
