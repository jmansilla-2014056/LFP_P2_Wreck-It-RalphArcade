/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author Mansilla
 */
public class Reglas {

    public Reglas(int nivel, String nombre, int tamanioB, int tamanioA, String rutaPersonaje, String rutaEnemigo, Collection<Casilla> casillas) {
        this.nivel = nivel;
        this.nombre = nombre;
        this.tamanioB = tamanioB;
        this.tamanioA = tamanioA;
        this.rutaPersonaje = rutaPersonaje;
        this.rutaEnemigo = rutaEnemigo;
        this.casillas = casillas;
        this.superado=false;
                }
        
    private int nivel;
    private String nombre;
    private int tamanioB;
    private int tamanioA;    
    private String rutaPersonaje;
    private String rutaEnemigo;
    private Collection<Casilla> casillas;
    private boolean superado;

    public boolean isSuperado() {
        return superado;
    }

    public void setSuperado(boolean superado) {
        this.superado = superado;
    }

    public Reglas() {
       casillas = new ArrayList<>();
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getTamanioB() {
        return tamanioB;
    }

    public void setTamanioB(int tamanioB) {
        this.tamanioB = tamanioB;
    }

    public int getTamanioA() {
        return tamanioA;
    }

    public void setTamanioA(int tamanioA) {
        this.tamanioA = tamanioA;
    }

    public String getRutaPersonaje() {
        return rutaPersonaje;
    }

    public void setRutaPersonaje(String rutaPersonaje) {
        this.rutaPersonaje = rutaPersonaje;
    }

    public String getRutaEnemigo() {
        return rutaEnemigo;
    }

    public void setRutaEnemigo(String rutaEnemigo) {
        this.rutaEnemigo = rutaEnemigo;
    }

    public Collection<Casilla> getCasillas() {
        return casillas;
    }

    public void setCasillas(Collection<Casilla> casillas) {
        this.casillas = casillas;
    }
    
    
    
}
