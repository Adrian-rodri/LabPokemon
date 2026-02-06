
package labpokemon;

import javax.swing.ImageIcon;


public class CartaHija extends Carta{
   
    private ImageIcon imagen;

    public CartaHija(String nombre, String nombreArchivo){
        super(nombre);
this.imagen = new ImageIcon(getClass().getResource(nombreArchivo));
    }
    
     
    
    
    
    @Override
    public void mostrarCarta(){
        
        this.setIcon(imagen);
        this.setText(nombre);
    }
    
    @Override
    public void ocultarCarta(){
        this.revelada=false;
        this.setIcon(null);
        this.setText("?");
    }
    
    public ImageIcon getImagen(){
        return imagen;
    }
    
    
}
