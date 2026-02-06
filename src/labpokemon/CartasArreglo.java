
package labpokemon;

/**
 *
 * @author Dell
 */
public class CartasArreglo {
    
    public static Carta[] crearCarta(){
        Carta[] cartas = new Carta[18];
        cartas[0] = new CartaHija("Charmander");
        cartas[1] = new CartaHija("Squirt");
        cartas[2] = new CartaHija("Bulbasur");
        cartas[3] = new CartaHija("Pikachu");
        cartas[4] = new CartaHija("Jigglypuff");
        cartas[5] = new CartaHija("Meowth");
        cartas[6] = new CartaHija("Psyduck");
        cartas[7] = new CartaHija("Growlithe");
        cartas[8] = new CartaHija  ("Vulpix");
        cartas[9]  = new CartaHija ("Magmar");
        cartas[10] = new CartaHija ("Poliwag");
        cartas[11] = new CartaHija ("Staryu");
        cartas[12] = new CartaHija ("Seel");
        cartas[13] = new CartaHija ("Lapras");
        cartas[14] = new CartaHija ("Pidgey");
        cartas[15] = new CartaHija ("Spearow");
        cartas[16] = new CartaHija ("Zubat");
        cartas[17] = new CartaHija("Hoothoot");        
       return cartas;
    };
    
}
