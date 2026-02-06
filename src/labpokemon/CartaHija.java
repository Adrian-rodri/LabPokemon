
package labpokemon;

import javax.swing.ImageIcon;


public class CartaHija extends Carta{
   
    private ImageIcon imagen;

    public CartaHija(String nombre, String rutaImagen){
        super(nombre);
        this.imagen = new ImageIcon(getClass().getResource(rutaImagen));
    }
    
     
    
    
    
    @Override
    public void mostrarCarta(){
        this.revelada=true;
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
