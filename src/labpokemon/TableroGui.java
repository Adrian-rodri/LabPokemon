package labpokemon;

import java.awt.*;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;

public class TableroGui extends JPanel {

    //Colores
    Color bgr = new Color(0xFF6500);
    Color btn = new Color(0xC40C0C);
    Color txt = new Color(0xF6CE71);
    
    //Titulos
    JLabel titulo = new JLabel("Match the Pokemons");
    JLabel turnos;
    
    //Grid
    JPanel grid = new JPanel(new GridLayout(6, 6, 5, 5)); 
    
    //Botones
    Carta[][] botones = new Carta[6][6];
    Carta primeraSeleccion = null;
    Carta segundaSeleccion = null;
    boolean bloqueado = false; 

    //Extras
    Jugador player1;
    Jugador player2;
    Jugador jugadorActual;

    TableroGui(String nombre1, String nombre2) {
        player1 = new Jugador(nombre1, true, 0);
        player2 = new Jugador(nombre2, false, 0);
        jugadorActual = player1; 

        turnos = new JLabel("Turno de: " + jugadorActual.getNombre());

        this.setSize(800, 800);
        this.setBackground(btn);
        this.setLayout(null);
        
        //Títulos
        titulo.setBounds(100, 30, 500, 100);
        titulo.setForeground(txt);
        titulo.setFont(new Font("Times New Roman", Font.BOLD, 30));

        turnos.setBounds(100, 690, 500, 100);
        turnos.setFont(new Font("Times New Roman", Font.BOLD, 30));
        turnos.setForeground(txt);

        ArrayList<CartaHija> lista = new ArrayList<>();
        
        Carta[] barajaBase = CartasArreglo.crearCarta();

        for (Carta c : barajaBase) {
            String nombre = c.getNombre();
            String ruta = ((CartaHija) c).getRuta();
            lista.add(new CartaHija(nombre, ruta));
            lista.add(new CartaHija(nombre, ruta));
        }

        Collections.shuffle(lista);
        
        // Llenar el tablero visual
        int contador = 0;
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                botones[i][j] = lista.get(contador);
                botones[i][j].setBackground(bgr);

                botones[i][j].addActionListener(e -> {
                    Carta cartaClick = (Carta) e.getSource();
                    manejarSeleccion(cartaClick);
                });

                grid.add(botones[i][j]);
                contador++;
            }
        }

        grid.setBounds(100, 100, 600, 600);
        grid.setBackground(btn);

        //Add
        add(turnos);
        add(titulo);
        add(grid);
    }

    private void manejarSeleccion(Carta carta) {
        if (bloqueado || carta.isRevelada() || carta == primeraSeleccion) {
            return;
        }

        carta.mostrarCarta();

        if (primeraSeleccion == null) {
            primeraSeleccion = carta;
        } else {
            segundaSeleccion = carta;
            bloqueado = true; 

            Timer timer = new Timer(1000, e -> {
                verificarPareja();
                bloqueado = false;
            });
            timer.setRepeats(false);
            timer.start();
        }
    }

    private void verificarPareja() {
        if (primeraSeleccion.getNombre().equals(segundaSeleccion.getNombre())) {
            cambiarTurno(true);
        } else {
            primeraSeleccion.ocultarCarta();
            segundaSeleccion.ocultarCarta();
            cambiarTurno(false);
        }
        primeraSeleccion = null;
        segundaSeleccion = null;
        
        if (player1.getAciertos() + player2.getAciertos() == 18) {
            String ganador = (player1.getAciertos() > player2.getAciertos()) ? player1.getNombre() : player2.getNombre();
            if(player1.getAciertos() == player2.getAciertos()) ganador = "Empate";
            JOptionPane.showMessageDialog(this, "¡Juego Terminado! Ganador: " + ganador);
        }
    }

    public void cambiarTurno(boolean huboAcierto) {
        if (huboAcierto) {
            jugadorActual.addAcierto();
        } else {
            jugadorActual = (jugadorActual == player1) ? player2 : player1;
            turnos.setText("Turno de: " + jugadorActual.getNombre());
        }
    }
}