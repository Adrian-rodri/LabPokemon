/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labpokemon;

import java.util.Collections;
import java.util.ArrayList;

public class TableroLogico implements controlarJuego {
    private Carta[][] tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private Carta primeraSeleccion;
    private Carta segundaSeleccion;

    public TableroLogico(Jugador j1, Jugador j2, ArrayList<Carta> cartas, int filas, int columnas){
        this.jugador1 = j1;
        this.jugador2 = j2;
        this.tablero = new Carta[filas][columnas];

        Collections.shuffle(cartas);

        int indice = 0;
        for (int f = 0; f < filas; f++){
            for (int c = 0; c < columnas; c++){
                tablero[f][c] = cartas.get(indice++);
            }
        }
    }

    public void seleccionarCarta(int fila, int columna){
        Carta carta = tablero[fila][columna];
        carta.mostrarCarta();

        if (primeraSeleccion == null){
            primeraSeleccion = carta;
        } else {
            segundaSeleccion = carta;
            verificarPareja(); 
        }
    }

    private void cambiarTurno(){
        jugador1.setTurno(!jugador1.isTurno());
        jugador2.setTurno(!jugador2.isTurno());
    }

    @Override
    public void verificarPareja(){
        if (primeraSeleccion != null && segundaSeleccion != null) {
            boolean match = primeraSeleccion.getNombre().equals(segundaSeleccion.getNombre());
            if (match){
                if (jugador1.isTurno()) jugador1.addAcierto();
                else jugador2.addAcierto();
            } else {
                primeraSeleccion.ocultarCarta();
                segundaSeleccion.ocultarCarta();
                cambiarTurno();
            }
            // reiniciamos selección
            primeraSeleccion = null;
            segundaSeleccion = null;
        }
    }

    @Override
    public void finalizarPartida(){
        boolean terminado = true;
        for(int f = 0; f < tablero.length; f++) {
            for(int c = 0; c < tablero[0].length; c++) {
                if(!tablero[f][c].isRevelada()) {
                    terminado = false;
                }
            }
        }
        if (terminado){
            System.out.println("Juego terminado");
            if (jugador1.getAciertos() > jugador2.getAciertos()) {
                System.out.println("Ganador: " + jugador1.getNombre());
            } else if (jugador2.getAciertos() > jugador1.getAciertos()) {
                System.out.println("Ganador: " + jugador2.getNombre());
            } else {
                System.out.println("Empate");
            }
        }
    }
}