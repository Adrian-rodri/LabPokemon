/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labpokemon;


public abstract class Carta {
    protected String contenido;
    protected boolean descubierta;

    public abstract void mostrar();
    public abstract void ocultar();

    public String getContenido() {
        return contenido;
    }

    public boolean isDescubierta() {
        return descubierta;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public void setDescubierta(boolean descubierta) {
        this.descubierta = descubierta;
    }    
    
}
