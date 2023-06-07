/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejer6extraguiapooahorcado;

import Entidad.Ahorcado;
import Service.AhorcadoService;

/**
 *
 * @author Carolina
 */
public class Ejer6ExtraGuiaPooAhorcado {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // instanciamos objetos tipo servicio y tipo Ahorcado
        AhorcadoService as = new AhorcadoService();
        
        
        System.out.println("-------- JUEGO DEL AHORCADO ---------");
        System.out.println("Inicialicemos el juego: ");
        
        Ahorcado a1 = as.crearJuego();
        
        System.out.println("Ahora si....");
        System.out.println("Empecemos a JUGAR !!!!!!!!");
        as.juegoArrancar(a1);
        
        
    }
    
}
