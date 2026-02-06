
package LabPokemon;

import java.util.Random;
import java.util.Scanner;

public class JuegoDeMemoria_22541006 {
    static Random r = new Random();

    public static String[][] matrizCartas() {
        String[][] cartas = {
            {"A", "A", "B", "B"},
            {"C", "C", "D", "D"},
            {"E", "E", "F", "F"},
            {"G", "G", "H", "H"}
        };
        int filas = cartas.length;
        int columnas = cartas[0].length;
        String[] plano = new String[filas * columnas];
        int indice = 0;

        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                plano[indice++] = cartas[f][c];
            }
        }

        for (int i = plano.length - 1; i > 0; i--) {
            int j = r.nextInt(i + 1);
            String temp = plano[i];
            plano[i] = plano[j];
            plano[j] = temp;
        }

        indice = 0;
        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                cartas[f][c] = plano[indice++];
            }
        }

        return cartas;
    }

    public static String[][] Ocultas(String[][] cartas) {
        int filas = cartas.length;
        int columnas = cartas[0].length;
        String[][] ocultas = new String[filas][columnas];

        for (int f = 0; f < filas; f++) {
            for (int c = 0; c < columnas; c++) {
                ocultas[f][c] = "?";
            }
        }

        return ocultas;
    }

    public static void voltearCarta(String[][] tableroReal, String[][] tableroOculto, int f, int c) {
        tableroOculto[f][c] = tableroReal[f][c];
    }

    public static boolean voltearDosCartas(
        String[][] tableroReal,
        String[][] tableroOculto,
        int f1, int c1,
        int f2, int c2
    ) {
        voltearCarta(tableroReal, tableroOculto, f1, c1);
        voltearCarta(tableroReal, tableroOculto, f2, c2);

        return tableroReal[f1][c1].equals(tableroReal[f2][c2]);
    }

    public static boolean juegoTerminado(String[][] tableroOculto) {
        for (int f = 0; f < tableroOculto.length; f++) {
            for (int c = 0; c < tableroOculto[0].length; c++) {
                if (tableroOculto[f][c].equals("?")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void imprimirTablero(String[][] tablero) {
        System.out.print("    "); 
        for (int c = 0; c < tablero[0].length; c++) {
            System.out.print((c + 1) + " ");
        }
        System.out.println();

        for (int f = 0; f < tablero.length; f++) {
            System.out.print((f + 1) + " | "); 
            for (int c = 0; c < tablero[0].length; c++) {
                System.out.print(tablero[f][c] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int jugadorActual = 1;
        int puntosJ1 = 0;
        int puntosJ2 = 0;
        String[][] tablero = matrizCartas();
        String[][] tableroOculto = Ocultas(tablero);
        Scanner n = new Scanner(System.in);

        System.out.println("TABLERO INICIAL OCULTO");
        System.out.println(" ");
        imprimirTablero(tableroOculto);

        while (true) {
            System.out.println("\n Turno de jugador " + jugadorActual);

            System.out.println("Fila Carta 1: ");
            int f1 = n.nextInt() - 1;
            System.out.println("Columna Carta 1: ");
            int c1 = n.nextInt() - 1;

            System.out.println("Fila Carta 2: ");
            int f2 = n.nextInt() - 1;
            System.out.println("Columna Carta 2: ");
            int c2 = n.nextInt() - 1;
            
            while(f1<0||f1>3||c1<0||c1>3){
                System.out.println("CARTA 1 INVALIDA");
                System.out.println("Fila Carta 1: ");
                f1 = n.nextInt() - 1;
                System.out.println("Columna Carta 1: ");
                c1 = n.nextInt() - 1;
            }
            while(f2<0||f2>3||c2<0||c2>3||(f1==f2&&c1==c2)){
                System.out.println("CARTA 2 INVALIDA");
                System.out.println("Fila Carta 2: ");
                f2 = n.nextInt() - 1;
                System.out.println("Columna Carta 2: ");
                c2 = n.nextInt() - 1;
            }

            boolean acerto = voltearDosCartas(tablero, tableroOculto, f1, c1, f2, c2);

            imprimirTablero(tableroOculto);

            if (acerto) {
                System.out.println("Correcto! Sigue el jugador " + jugadorActual + " otra vez");

                if (jugadorActual == 1) puntosJ1++;
                else puntosJ2++;

                System.out.println("PUNTOS J1: " + puntosJ1 + " | PUNTOS J2: " + puntosJ2);
            } else {
                jugadorActual=(jugadorActual==1)? 2:1;
                System.out.println("FALLASTE. PRESIONA ENTER PARA CONTINUAR, TURNO DE EL JUGADOR " + jugadorActual);
                n.nextLine(); 
                n.nextLine(); 

                tableroOculto[f1][c1] = "?";
                tableroOculto[f2][c2] = "?";
                imprimirTablero(tableroOculto);
            }

            if (juegoTerminado(tableroOculto)) {
                System.out.println("SE ACABO EL JUEGO!");
                if (puntosJ1 > puntosJ2) System.out.println("GANA EL JUGADOR 1");
                else if (puntosJ1 < puntosJ2) System.out.println("GANA EL JUGADOR 2");
                else System.out.println("EMPATE CON " + puntosJ1);
                break;
            }
        }
    }
}

    
    

