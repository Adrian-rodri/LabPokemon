
package labpokemon;

import javax.swing.JButton;









public abstract class Carta extends JButton {
   
    protected String nombre;
    protected boolean revelada;
     
    public Carta (String nombre){
        this.nombre=nombre;
        this.revelada=false;
        this.setText("?");
    }
    
    public abstract void mostrarCarta();
    
    public void ocultarCarta(){
        this.revelada=false;
        this.setText("?");
        this.setBackground(null);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isRevelada() {
        return revelada;
    }

    public void setRevelada(boolean revelada) {
        this.revelada = revelada;
    }


    
    
    
     

    
}
