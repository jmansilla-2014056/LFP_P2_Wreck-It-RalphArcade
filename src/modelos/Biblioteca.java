/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.awt.Color;

/**
 *
 * @author User
 */
public class Biblioteca {
    private int id;
    private String palabra;
    private Color color;

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public int getId() {
        return id;
    }

    public Biblioteca(int id, String palabra, Color color) {
        this.id = id;
        this.palabra = palabra;
        this.color = color;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }
  
}