
package labpokemon;

/**
 *
 * @author adria
 */
import java.awt.*;
import javax.swing.*;
public class TableroGui extends JPanel {
    //Colores
    Color bgr= new Color(0xFF6500);
    Color btn= new Color(0xC40C0C);
    Color txt= new Color(0xF6CE71);
    //Titulos
    JLabel titulo= new JLabel("Match the Pokemons");
    JLabel turnos;
    //Grid
    JPanel grid= new JPanel(new GridLayout(6,6));
    //Botones
    JButton[][] botones= new JButton[6][6];
    //Extras
    Jugador player1;
    Jugador player2;
    Jugador jugadorActual;
    
    TableroGui(String nombre1, String nombre2){
        player1= new Jugador(nombre1,true,0);
        player2= new Jugador(nombre2,false,0);
        jugadorActual = player1; // Inicia el P1
        
        turnos = new JLabel("Turno de: " + jugadorActual.getNombre());
        
        this.setSize(800,800);
        this.setBackground(btn);
        this.setLayout(null);
        //Titulos
        titulo.setBounds(100,30,500,100);
        titulo.setForeground(txt);
        titulo.setFont(new Font("Times New Roman", Font.BOLD,30));
        
        turnos.setBounds(100,690,500,100);
        turnos.setFont(new Font("Times New Roman", Font.BOLD,30));
        turnos.setForeground(txt);
        //Generar Tablero
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                botones[i][j] = new JButton();
                
                // Estilo de los botones
                botones[i][j].setBackground(bgr);
                botones[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
                
                // Acción de ejemplo (opcional)
                final int fila = i;
                final int col = j;
                botones[i][j].addActionListener(e -> {
                    System.out.println("Click en: " + fila + ", " + col);
                    cambiarTurno(true);
                });
            grid.add(botones[i][j]);    }
            grid.setBounds(100,100,600,600);
        //Add
        add(turnos);
        add(titulo);
        add(grid);
        
        
    }}
    public void cambiarTurno(boolean huboAcierto) {
    if (huboAcierto) {
        jugadorActual.addAcierto();
        // Opcional: Mostrar mensaje de "¡Acertaste!"
    } else {
        // Intercambio simple
        jugadorActual = (jugadorActual == player1) ? player2 : player1;
        turnos.setText("Turno de: " + jugadorActual.getNombre());
    }}
}

