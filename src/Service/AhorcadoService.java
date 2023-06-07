/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Service;

import Entidad.Ahorcado;
import java.util.Scanner;

/**
 *
 * @author Carolina
 */
public class AhorcadoService {
    Scanner leer = new Scanner(System.in).useDelimiter("\n");
    
    public Ahorcado crearJuego(){
        Ahorcado juego = new Ahorcado(); //instanciamos objeto
        
        System.out.println("Por favor ingrese la palabra para el juego: ");
        juego.setPalabra(leer.next());
        
        System.out.println("Por favor ingrese la cantidad de jugadas máximas "
                + "que va a permitir al jugador: ");
        juego.setCantJugadasMax(leer.nextInt());
        
        
        
              
        return juego;
    }
    public void longitudPalabra(Ahorcado juego){
        System.out.println("Longitud de la palabra a encontrar: " + juego.getPalabra().length());
        
    }
    public int buscarLetra(Ahorcado juego, String letra,String vectorAux2[]){
        
        
        int buscar = 0;
        String let;
        
        int longitud = juego.getPalabra().length();//hallamos longitud de la palabra ingresada

        String vectorAux[] = new String[longitud];//creamos vector auxiliar
        
        
        for (int i = 0; i < vectorAux.length; i++) {
            vectorAux[i] = juego.getPalabra().substring(i, i+1);
            let = vectorAux[i];
            if(letra.equals(let)){
                buscar += 1;
                vectorAux2[i] = letra;
                
            }

        }
        if(buscar > 0){
            System.out.println("La letra pertenece a la palabra");
            juego.setCantLetrasEncontradas(buscar+juego.getCantLetrasEncontradas());
            for (int i = 0; i < vectorAux2.length; i++) {
                System.out.print(" " + vectorAux2[i] + "/ ");
            }
        }else{
            System.out.println("La letra no pertenece a la palabra");
            
        }
        
        return buscar;
       
    }
    
    public boolean encontrar(Ahorcado juego, int buscar, int ingresar){
        int encontradas;
        int faltantes;
        boolean encon = false;
        
        if(ingresar == 1 && buscar > 0){
            encontradas = buscar;
            faltantes = juego.getPalabra().length() - buscar;
            encon = true;
            
        }else{
            if(ingresar == 1 && buscar == 0){
                encontradas = buscar;
                faltantes = juego.getPalabra().length() - buscar;
                encon = false;
            }else{
                if(ingresar != 1 && buscar > 0){
                    encontradas = juego.getCantLetrasEncontradas();
                    faltantes = juego.getPalabra().length() - juego.getCantLetrasEncontradas();
                    encon = true;
                }else{
                    encontradas = juego.getCantLetrasEncontradas() + buscar;
                    faltantes = juego.getPalabra().length() - juego.getCantLetrasEncontradas();
                    encon = false;
                }
               
            }
        }
        
        System.out.println("Número de letras (encontradas,faltantes)= ( " + encontradas +" , " + faltantes +" )");
        
        return encon;
    }
    public void intentos(Ahorcado juego){
        int oportunidades = juego.getCantJugadasMax();
        
        oportunidades -= 1;
        juego.setCantJugadasMax(oportunidades);
        System.out.println("Número de oportunidades restantes: " + oportunidades);
        
    }
    public void juegoArrancar(Ahorcado juego){
        AhorcadoService as = new AhorcadoService();//instancio objeto tipo servicio
        String let;
        boolean letrayaingresada = false;
        int buscar; int ingresar = 0;
        boolean encon;
        boolean ganaste = false;
        int contintentos = juego.getCantJugadasMax();
        String vectorAux2[] = new String[juego.getPalabra().length()];//creamos otro vector auxiliar para mostrar las letras que se van adivinando
        for (int i = 0; i < vectorAux2.length; i++) {  //inicializamos vector auxiliar2
            vectorAux2[i] = " ";
        }
        
        
        do{
            letrayaingresada = false;
            System.out.println("Por favor ingrese una letra: ");
            String letra = leer.next();
            ingresar += 1;
            //revisamos primero si la letra ingresada ya había sido ingresada antes
            for (int i = 0; i < juego.getPalabra().length(); i++) {
                if(vectorAux2[i].equalsIgnoreCase(letra)){
                    System.out.println("Letra ya ingresada!!!!!");
                    letrayaingresada = true;
                    break;
                }
            }
            if(letrayaingresada){
                
            }else{
                buscar = as.buscarLetra(juego,letra,vectorAux2);
                encon = as.encontrar(juego, buscar, ingresar);
            
                if(encon){
                    
                }else{
                    as.intentos(juego);
                
                }
                if(juego.getCantLetrasEncontradas() == juego.getPalabra().length()){
                System.out.println("!!!! GANASTE --ENCONTRASTE LA PALABRA !!!!!!");
                System.out.println(" " + juego.getPalabra());
                ganaste = true;
                break;
            
                }
            }
            contintentos = juego.getCantJugadasMax();
            
        }while(contintentos > 0);
        if(ganaste){
            
        }else{
            System.out.println("Estás AHORCADOOOOOOO!!!!!!");
            System.out.println("Lo sentimos no hay más oportunidades");
        }
        
    }
    
}
