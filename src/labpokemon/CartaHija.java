package labpokemon;

import javax.swing.ImageIcon;
import java.awt.Image; // Necesario para el escalado

public class CartaHija extends Carta {

    private ImageIcon imagen;
    private String ruta;

    public CartaHija(String nombre, String rutaImagen) {
        super(nombre);
        this.ruta = rutaImagen;

        // Agregamos el try-catch para manejar errores de carga
        try {
            java.net.URL imgURL = getClass().getResource(rutaImagen);

            if (imgURL != null) {
                // 1. Cargamos la imagen original
                ImageIcon iconoOriginal = new ImageIcon(imgURL);
                
                // 2. La escalamos a un tamaño fijo (ejemplo 80x80) para que no se vea grande
                // Image.SCALE_SMOOTH mantiene la calidad de la imagen
                Image imagenEscalada = iconoOriginal.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH);
                
                // 3. Asignamos la imagen ya escalada al objeto
                this.imagen = new ImageIcon(imagenEscalada);
                
            } else {
                System.err.println("No se encontró el archivo: " + rutaImagen);
                this.imagen = null;
            }
        } catch (Exception e) {
            // Captura cualquier error inesperado (formato de imagen corrupto, etc.)
            System.err.println("Error al procesar la imagen: " + e.getMessage());
            this.imagen = null;
        }
    }

    @Override
    public void mostrarCarta() {
        this.revelada = true; // Importante marcarla como revelada
        this.setIcon(imagen);
        this.setText(""); // Quitamos el texto para que solo se vea el Pokémon
    }

    @Override
    public void ocultarCarta() {
        this.revelada = false;
        this.setIcon(null);
        this.setText("?");
    }

    public ImageIcon getImagen() {
        return imagen;
    }

    public String getRuta() {
        return ruta;
    }
}