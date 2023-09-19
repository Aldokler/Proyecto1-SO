/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import Model.Arista;
import Model.Car;
import Model.Nodo;
import Model.Grafo;
import java.util.ArrayList;
import processing.core.*;
import java.util.Scanner;
import controlP5.*;

/**
 *
 * @author sharon
 */
public class Main extends PApplet {

    static ControlP5 cp5;
    Grafo grafo = new Grafo();
    Scanner myObj = new Scanner(System.in);
    //Controls c;
 
    
    


    public void setup() {
        background(0);
        stroke(255);
        noFill();
        
    
        
        //c = new Controls();
        /*cp5 = new ControlP5(this);
       // c.a(this);

        cp5.addButton("miBoton")
                .setPosition(100, 100)
                .setSize(100, 40);*/
        
    }

    public void miBoton() {
        println("El botón fue presionado.");
    }

    public void unir() {

        System.out.println("Enter id");
        int id1 = myObj.nextInt();

        System.out.println("Enter id2");
        int id2 = myObj.nextInt();

        grafo.addArista(id1, id2, 50);
    }

    public void keyReleased() {
        if (key == 'n') {
            grafo.addNodo((float) 0.5, mouseX, mouseY);
        }
        if (key == 'a') {
            unir();
        }
        if (key == 'c') {
            grafo.addCarro();
        }

    }

    public void draw() {
        background(0);
        grafo.display(this);
        
    }

    public void settings() {
        size(500, 500);

    }

    static public void main(String[] passedArgs) {
        String[] appletArgs = new String[]{"View.Main"};
        if (passedArgs != null) {
            PApplet.main(concat(appletArgs, passedArgs));
        } else {
            PApplet.main(appletArgs);
        }
    }

}