
package labpokemon;

/**
 *
 * @author Dell
 */
public class CartasArreglo {
    
    public static Carta[] crearCarta(){
        Carta[] cartas = new Carta[18];


        cartas[0] = new CartaHija("Charmander","/resources/charmande.png");
        cartas[1] = new CartaHija("Squirtle", "/resources/squirtle.png");
        cartas[2] = new CartaHija("Bulbasaur", "/resources/bulbasaur.png");
        cartas[3] = new CartaHija("Pikachu", "/resources/pikachu.png");
        cartas[4] = new CartaHija("Jigglypuff", "/resources/jigglypuff.png");
        cartas[5] = new CartaHija("Meowth", "/resources/meowth.png");
        cartas[6] = new CartaHija("Psyduck", "/resources/psyduck.png");
        cartas[7] = new CartaHija("Growlithe", "/resources/growlithe.png");
        cartas[8] = new CartaHija("Vulpix", "/resources/vulpix.png");
        cartas[9] = new CartaHija("Magmar", "/resources/magmar.png");
        cartas[10] = new CartaHija("Poliwag", "/resources/poliwag.png");
        cartas[11] = new CartaHija("Staryu", "/resources/staryu.png");
        cartas[12] = new CartaHija("Seel", "/resources/seel.png");
        cartas[13] = new CartaHija("Lapras", "/resources/lapras.png");
        cartas[14] = new CartaHija("Pidgey", "/resources/pidgey.png");
        cartas[15] = new CartaHija("Spearow", "/resources/spearow.png");
        cartas[16] = new CartaHija("Zubat", "/resources/zubat.png");
        cartas[17] = new CartaHija("Hoothoot", "/resources/hoothoot.png");        


       return cartas;
    };
    
}
