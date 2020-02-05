/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresenraya;

import java.util.Scanner;

/**
 *
 * @author jesushera
 */
public class TresEnRaya {
    Character [][] carton;
    
    
    public TresEnRaya(){
        carton=new Character[3][3];
        for(int f=0;f<carton.length;f++){
            for(int c=0;c<carton[f].length;c++){
                carton[f][c]='-';
            }
        }
    }
    
    public void marcarCasilla(int fila, int columna, char jugador){
        Scanner sc=new Scanner(System.in);
        while(carton[fila][columna]=='O' || carton[fila][columna]=='X' ){
            System.out.println("Posición ya ocupada: ");
            mostrarTablero();
            System.out.println("Introduce una posición de fila:");
            fila=sc.nextInt();
            System.out.println("Introduce una posición de columna:");
            columna=sc.nextInt();
        }   
        while(carton[fila][columna]=='-'){
            if(jugador=='O' || jugador=='X'){
                carton[fila][columna]=jugador;
            }
        }
    }
    
    /*public char queJugadorToca(){
        int contadorJ1=0; // Jugador con X
        int contadorJ2=0; // Jugador con O
        for(int f=0;f<carton.length;f++){
            for(int c=0;c<carton[f].length;c++){
                if(carton[f][c]=='O'){
                    contadorJ2++;
                }else if(carton[f][c]=='X'){
                    contadorJ1++;
                }
            }
        }
        if(){
            
        }
    }*/
    
    
    
    public void mostrarTablero(){
        for(int f=0;f<carton.length;f++){
            for(int c=0;c<carton[f].length;c++){
                System.out.print("["+carton[f][c] + "] ");
            }
            System.out.println("");
        }
    }
    
    public int comprobarFila(){
        
        for(int f=0;f<carton.length;f++){
            int gana1=0;
            int gana2=0;
            boolean fin=false;
            for(int c=0;!fin && c<carton[f].length;c++){
                if(carton[f][c]=='O'){
                    gana2++;
                }else if(carton[f][c]=='X'){
                    gana1++;
                }
            }
            if(gana1==3){
                //System.out.println("Gana el jugador 1, con las X");
                return 1;
                
            }
            else if(gana1==3){
                //System.out.println("Gana el jugador 2, con las O");
                return 2;
                
            }
        }
        return -1;
    }
    
    public int comprobarColumnas(){
        for(int c=0;c<carton[0].length;c++){
            int gana1=0;
            int gana2=0;
            boolean fin=false;
            for(int f=0;!fin && f<carton.length;f++){
                if(carton[f][c]=='O'){
                    gana2++;
                }else if(carton[f][c]=='X'){
                    gana1++;
                }
            }
            if(gana1==3){
                //System.out.println("Gana el jugador 1, con las X");
                return 1;
                
            }
            else if(gana1==3){
                //System.out.println("Gana el jugador 2, con las O");
                return 2;
                
            }
        }
        return -1;
    }
    
    public int comprobarDiagonales(){
        //PRIMERA DIAGONAL
        int gana1D1=0;
        int gana2D1=0;
        for(int i=0;i<carton.length;i++){

            if(carton[i][i]=='X'){
                gana1D1++;
            }else if(carton[i][i]=='O'){
                gana2D1++;
            }
        }
        
        if(gana1D1==3){
            //System.out.println("Gana el jugador 1, DIAGONAL 1, con las X");
            return 1;
        }else if(gana2D1==3){
            //System.out.println("Gana el jugador 2 DIAGONAL 1, con las O");
            return 2;
        }
        
    
        //SEGUNDA DIAGONAL
        int gana1D2=0;
        int gana2D2=0;
        for(int f=0;f<carton.length;f++){
            
            if(carton[f][carton[f].length-f-1]=='X'){
                gana1D2++;
            }else if(carton[f][carton[f].length-f-1]=='O'){
                gana2D2++;
            }
            
        }
        
        if(gana1D2==3){
            //System.out.println("Gana el jugador 1, DIAGONAL 2, con las X");
            return 1;
        }else if(gana2D2==3){
            //System.out.println("Gana el jugador 2, DIAGONAL 2, con las O");
            return 2;
        }
        return -1;
    }
    
    
    
    public int comprobarGanador(){
        if(this.comprobarFila()>0){
            return this.comprobarFila();
        }
        
        if(this.comprobarColumnas()>0){
            return this.comprobarColumnas();
        }
        if(this.comprobarDiagonales()>0){
            return this.comprobarDiagonales();
        }
        return -1;
    }
    
    
    
    public static void main (String [] args){
        Scanner sc=new Scanner(System.in);
        TresEnRaya partida1=new TresEnRaya();
        /*
        partida1.marcarCasilla(0, 0, 'X');
        partida1.marcarCasilla(0, 0, 'X');
        partida1.marcarCasilla(0, 0, 'X');
        partida1.marcarCasilla(0, 0, 'X');
        
        partida1.mostrarTablero();
        
        partida1.comprobarGanador();
        */
        //jugador 1 X y 2 O
        
        
        //MODIFICAR PARA EMPATE, HACER OTRO METODO Y QUE HAGA UN RETURN DE 0 POR EJEMPLO
        while(partida1.comprobarGanador()<0){
            partida1.mostrarTablero();
            
            System.out.println("Le toca a JUGADOR 1 (X)");
            System.out.println("Introduce la fila: ");
            int filaJ1=sc.nextInt();
            System.out.println("Introduce la columna: ");
            int filaJ2=sc.nextInt();
            if(partida1.comprobarGanador()>0){
                
                break;
            }
        
        
        }
        
    }
    
    
}
