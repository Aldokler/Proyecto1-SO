/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.util.ArrayList;

/**
 *
 * @author jeffr
 */
public class grafo {
    public static ArrayList<Nodo> Dijsktra(Car carro){
    ArrayList rutaDisjktra = new ArrayList<Nodo>();
    ArrayList arcosRecorridos = new ArrayList<Arista>();
    int lugar = -1;
    Nodo actual = carro.getInicio();
    
    rutaDisjktra.add(actual);
    while(carro.getDestino()!= actual){
       if(isDestinationNext(actual, carro.getDestino())){
           Arista ab = getAristaPorNodos(actual, carro.getDestino());
           rutaDisjktra.add(actual);
           arcosRecorridos.add(ab);
           if(ab.getFin()==actual){
               actual = ab.getInicio();
           }
           else{
           actual = ab.getFin();
           }
           
           rutaDisjktra.add(actual);
       }
       else{
       Arista ar = actual.getShortest(arcosRecorridos);
       if(ar == null){
           ar = (Arista) arcosRecorridos.get(lugar);
           rutaDisjktra.remove(lugar);
           lugar--;
           actual = ar.getInicio();
       }
       else{
           rutaDisjktra.add(actual);
           arcosRecorridos.add(ar);
           if(ar.getFin()==actual){
               actual = ar.getInicio();
           }
           else{
           actual = ar.getFin();
           }
           lugar++;
            }
       }
    }
    return rutaDisjktra;
    }
    public static boolean isDestinationNext(Nodo actual, Nodo destino){
        ArrayList aristasNodoActual = actual.getAristas();
        for(int i =0;i<aristasNodoActual.size();i++){
            Arista a = (Arista) aristasNodoActual.get(i);
            if(a.getFin() == destino || a.getInicio() == destino){
                return true;
            }
        }
        return false;
    }
    
    public static Arista getAristaPorNodos(Nodo n1, Nodo n2){
        Arista a = null;
        for(int i =0;i<n1.getAristas().size();i++){
            Arista ev = (Arista) n1.getAristas().get(i);
            Nodo n = ev.getFin();
            Nodo nn = ev.getInicio();
            if(n == n2 || nn==n2){ 
                a = ev;
            }
        }
        return a;
    }
    
    
}
