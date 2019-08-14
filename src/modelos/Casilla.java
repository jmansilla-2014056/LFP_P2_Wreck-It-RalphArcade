/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.awt.Color;

/**
 *
 * @author Mansilla
 */
public class Casilla {
    private int ejeX;
    private int ejeY;
    private int tipo;
    private Color color;

    public Casilla(int ejeX, int ejeY, int tipo) {
        this.ejeX = ejeX;
        this.ejeY = ejeY;
        switch(tipo){
             case 0:
                //Casilla normal
                this.color = Color.GRAY;
                break;
            case 1:
                //Escaleras celeste
                this.color = Color.getHSBColor((float) 0.56, (float) 0.70, (float) 0.9);
                break;
            case 2:
                //Bloque dañado azul
                this.color = Color.getHSBColor((float) 0.62, (float) 0.96, (float) 0.9);
                break;
            case 3:
                //Bloque enemigo
                this.color = Color.RED;
                break;
            case 4:
                //Bloque reparado
                this.color = Color.GRAY;
                break;
            case 5:
                //Escalera dañada Morado
                this.color = Color.getHSBColor((float) 0.70, (float) 0.85, (float) 0.9);
                break;
 
        }               
        this.tipo = tipo;                                                                                                                                                                                                                                                                   
    }

    public Casilla() {
        //To change body of generated methods, choose Tools | Templates.
    }

               
    public int getEjeX() {
        return ejeX;
    }

    public void setEjeX(int ejeX) {
        this.ejeX = ejeX;
    }

    public int getEjeY() {
        return ejeY;
    }

    public void setEjeY(int ejeY) {
        this.ejeY = ejeY;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
            switch(tipo){
                     case 0:
                //Escaleras
                this.color = Color.GRAY;
                break;
            case 1:
                //Escaleras
                this.color = Color.getHSBColor((float) 0.56, (float) 0.70, (float) 0.9);
                break;
            case 2:
                //Bloque dañado
                this.color = Color.getHSBColor((float) 0.62, (float) 0.96, (float) 0.9);
                break;
            case 3:
                //Bloque enemigo
                this.color = Color.GRAY;
                break;
                //Bloque reparado
            case 4:
                this.color = Color.GRAY;
                break;    
            case 5:
                //Escalera dañada
                this.color = Color.getHSBColor((float) 0.70, (float) 0.85, (float) 0.9);
                break;
        }          
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    } 
    
}
