/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidad;

/**
 *
 * @author Carolina
 */
public class Ahorcado {
    //atributos
    
    private String palabra;
    private int cantLetrasEncontradas;
    private int cantJugadasMax;
    
    //crear constructores

    public Ahorcado() {
    }

    public Ahorcado(String palabra, int cantLetrasEncontradas, int cantJugadasMax) {
        this.palabra = palabra;
        this.cantLetrasEncontradas = cantLetrasEncontradas;
        this.cantJugadasMax = cantJugadasMax;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    public int getCantLetrasEncontradas() {
        return cantLetrasEncontradas;
    }

    public void setCantLetrasEncontradas(int cantLetrasEncontradas) {
        this.cantLetrasEncontradas = cantLetrasEncontradas;
    }

    public int getCantJugadasMax() {
        return cantJugadasMax;
    }

    //crear get y set
    public void setCantJugadasMax(int cantJugadasMax) {
        this.cantJugadasMax = cantJugadasMax;
    }

    //crear toString

    @Override
    public String toString() {
        return "Ahorcado{" + "palabra=" + palabra + ", cantLetrasEncontradas=" + cantLetrasEncontradas + ", cantJugadasMax=" + cantJugadasMax + '}';
    }
    
    

   
    
}
