
package labpokemon;


public class CartaHija extends Carta{
   
    public CartaHija(String nombre){
        super(nombre);
    }
    
    @Override
    public void mostrarCarta(){
        this.revelada=true;
        this.setText(nombre);
    }
    
    
}
