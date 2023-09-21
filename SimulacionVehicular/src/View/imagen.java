/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.util.ArrayList;
import processing.core.PImage;

/**
 *
 * @author Aldokler
 */
public class imagen {
    
    private static imagen esta;
    private ArrayList<PImage> img;

    private imagen(ArrayList<PImage> img) {
        this.img = img;
    }

    public ArrayList<PImage> getImg() {
        return img;
    }
    
    public static imagen getInstance(ArrayList<PImage> img) {
        // Si la instancia aún no se ha creado, la crea
        if (esta == null) {
            esta = new imagen(img);
        }
        return esta;
    }
}
