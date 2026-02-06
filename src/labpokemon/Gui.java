
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
    //Text fields
    JTextField txtNombre1= new JTextField();
    JTextField txtNombre2 = new JTextField();
    //Titulo
    JLabel lblJug1= new JLabel("Ingresar Jugador #1");
    JLabel lblJug2= new JLabel("Ingresar Jugador #2");
    //Tablero
    TableroGui tablero;
    //Extras
    Component frame= new JFrame();
    Gui(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(800,800);
        this.getContentPane().setBackground(bgr);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        
        //Botones
        btnJugar.setBounds(300,300,200,50);
        btnJugar.setBackground(btn);
        btnJugar.setForeground(txt);
        btnJugar.setText("JUGAR");
        //TXT
        txtNombre1.setBounds(300,200,200,30);
        txtNombre2.setBounds(300,250,200,30);
        //Labels
        lblJug1.setBounds(300,170,200,30);
        lblJug2.setBounds(300,220,200,30);
        //Acciones
        btnJugar.addActionListener(e->{
            String n1= txtNombre1.getText();
            String n2= txtNombre2.getText();
            if(n1.isEmpty() || n2.isEmpty()){
                JOptionPane.showMessageDialog(frame, "Ingrese Todos los Campos");
                return;
            }else{
            tablero= new TableroGui(n1,n2);
            add(tablero);
            tablero.setBounds(0,0,801,800);
            tablero.setVisible(true);
            
        txtNombre1.setVisible(false);
        txtNombre2.setVisible(false);
        lblJug1.setVisible(false);
        lblJug2.setVisible(false);
        btnJugar.setVisible(false);
        
        }});
        
        
        
        //Add
        
        add(lblJug2);
        add(lblJug1);
        add(txtNombre1);
        add(txtNombre2);
        add(btnJugar);
        this.setVisible(true);
    }
    
    
}
