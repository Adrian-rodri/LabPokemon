
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
        cartas[0] = new CartaHija("Charmander", "/labpokemon/charmander.png");
        cartas[1] = new CartaHija("Squirtle", "/labpokemon/squirtle.png");
        cartas[2] = new CartaHija("Bulbasaur", "/labpokemon/bulbasaur.png");
        cartas[3] = new CartaHija("Pikachu", "/labpokemon/pikachu.png");
        cartas[4] = new CartaHija("Jigglypuff", "/labpokemon/jigglypuff.png");
        cartas[5] = new CartaHija("Meowth", "/labpokemon/meowth.png");
        cartas[6] = new CartaHija("Psyduck", "/labpokemon/psyduck.png");
        cartas[7] = new CartaHija("Growlithe", "/labpokemon/growlithe.png");
        cartas[8] = new CartaHija("Vulpix", "/labpokemon/vulpix.png");
        cartas[9] = new CartaHija("Magmar", "/labpokemon/magmar.png");
        cartas[10] = new CartaHija("Poliwag", "/labpokemon/poliwag.png");
        cartas[11] = new CartaHija("Staryu", "/labpokemon/staryu.png");
        cartas[12] = new CartaHija("Seel", "/labpokemon/seel.png");
        cartas[13] = new CartaHija("Lapras", "/labpokemon/lapras.png");
        cartas[14] = new CartaHija("Pidgey", "/labpokemon/pidgey.png");
        cartas[15] = new CartaHija("Spearow", "/labpokemon/spearow.png");
        cartas[16] = new CartaHija("Zubat", "/labpokemon/zubat.png");
        cartas[17] = new CartaHija("Hoothoot", "/labpokemon/hoothoot.png");       


       return cartas;
    }
    
    public static Carta getCartaRandom(){
        Carta[] cartas = crearCarta();
         int indice = random.nextInt(cartas.length);
        return cartas[indice];
    }
    
    
    
}
