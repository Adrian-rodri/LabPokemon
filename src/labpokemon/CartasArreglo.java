
package labpokemon;

import java.util.Random;

/**
 *
 * @author Dell
 */
public class CartasArreglo {
   private static Random random = new Random(); 
    public static Carta[] crearCarta(){
        Carta[] cartas = new Carta[18];
    


        cartas[0] = new CartaHija("Charmander", "charmander.png");
        cartas[1] = new CartaHija("Squirtle", "squirtle.png");
        cartas[2] = new CartaHija("Bulbasaur", "bulbasaur.png");
        cartas[3] = new CartaHija("Pikachu", "pikachu.png");
        cartas[4] = new CartaHija("Jigglypuff", "jigglypuff.png");
        cartas[5] = new CartaHija("Meowth", "meowth.png");
        cartas[6] = new CartaHija("Psyduck", "psyduck.png");
        cartas[7] = new CartaHija("Growlithe", "growlithe.png");
        cartas[8] = new CartaHija("Vulpix", "vulpix.png");
        cartas[9] = new CartaHija("Magmar", "magmar.png");
        cartas[10] = new CartaHija("Poliwag", "poliwag.png");
        cartas[11] = new CartaHija("Staryu", "staryu.png");
        cartas[12] = new CartaHija("Seel", "seel.png");
        cartas[13] = new CartaHija("Lapras", "lapras.png");
        cartas[14] = new CartaHija("Pidgey", "pidgey.png");
        cartas[15] = new CartaHija("Spearow", "spearow.png");
        cartas[16] = new CartaHija("Zubat", "zubat.png");
        cartas[17] = new CartaHija("Hoothoot", "hoothoot.png");       


       return cartas;
    }
    
    public static Carta getCartaRandom(){
        Carta[] cartas = crearCarta();
         int indice = random.nextInt(cartas.length);
        return cartas[indice];
    }
    
    
    
}
