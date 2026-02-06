
package labpokemon;

/**
 *
 * @author adria
 */
import javax.swing.*;
import java.awt.*;
public class Gui extends JFrame {
    //Colores
    Color bgr= new Color(0xFF6500);
    Color btn= new Color(0xC40C0C);
    Color txt= new Color(0xF6CE71);
    //Botones
    JButton btnJugar= new JButton();
    Gui(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(800,800);
        this.getContentPane().setBackground(bgr);
        
        //Botones
        btnJugar.setBounds(350,300,200,50);
        btnJugar.setBackground(btn);
        btnJugar.setForeground(txt);
        btnJugar.setText("JUGAR");
        
        //Add
        add(btnJugar);
        this.setVisible(true);
    }
    public static void main(String[] args) {
        Gui n= new Gui();
    }
}
