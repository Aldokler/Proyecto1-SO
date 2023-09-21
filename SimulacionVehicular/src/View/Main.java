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
    static float tiempo = (float) 2.0;
    public static Textlabel tiempoS;
    public static Textlabel cantidadC;
    public static Textlabel velocidadP;
    public static float numeroInput;

    private int opc = 0;

    public static boolean checkInput() {
        String numero = (cp5.get(Textfield.class, "input").getText());
        float n;
        try {
            n = Float.parseFloat(numero);
        } catch (Exception e) {
            return false;
        }
        if (n > 0) {
            numeroInput = n;
            return true;
        }
        return false;
    }

    public void buttons() {
        cp5 = new ControlP5(this);

        cp5.addButton("Stop")
                .setPosition(0, 0)
                .setSize(100, 40);

        cp5.addButton("Start")
                .setPosition(110, 0)
                .setSize(100, 40);

        tiempoS = cp5.addTextlabel("tiempoS")
                .setText("Tiempo simulacion: ")
                .setPosition(0, 50)
                .setColorValue(0xffffff00)
                .setFont(createFont("C059-BdIta", 20));
        cantidadC = cp5.addTextlabel("cantidad")
                .setText("Cantidad vehiculos: ")
                .setPosition(0, 80)
                .setColorValue(0xffffff00)
                .setFont(createFont("C059-BdIta", 20));
        velocidadP = cp5.addTextlabel("velocidad")
                .setText("velocidad promedio: ")
                .setPosition(0, 110)
                .setColorValue(0xffffff00)
                .setFont(createFont("C059-BdIta", 20));
        
        cp5.addTextfield("input")
                .setPosition(220, 10)
                .setSize(50, 40)
                .setFont(createFont("C059-BdIta", 20))
                .setFocus(true)
                .setAutoClear(false)
                .setColor(color(255, 0, 0));
    }

    public void setup() {
        background(0);
        stroke(255);
        noFill();
        buttons();
        String[] fontList = PFont.list();
        printArray(fontList);
        
        ArrayList<PImage> carritos = new ArrayList();
        for(int i = 0; i < 6; i++){
            PImage ferrari = loadImage("../imagenes/car_"+i+".png");
            carritos.add(ferrari);
        }
        imagen.getInstance(carritos);

    }

    public void Stop() {
        grafo.clean();
    }

    public void Start() {
        grafo.Iniciar();
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
            grafo.addNodo((float) 1/5, mouseX, mouseY);
        }
        if (key == 't') {
            opc = 1;
        }
        /*
        if (key == 'c') {
            grafo.addCarro();
        }
*/

    }

    public void mousePressed() {
        switch (opc) {
            case 1:
                grafo.setTasa(mouseX, mouseY);
                opc = 0;
                break;
            default:
                grafo.crearUnion(mouseX, mouseY);
        }

    }

    public void draw() {
        background(0);
        grafo.display(this);

    }

    public void settings() {
        size(1200, 800);
        //fullScreen();

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
