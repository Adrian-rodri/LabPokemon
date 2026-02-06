/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package labpokemon;

/**
 *
 * @author gpopo
 */
public class Jugador {
    private String nombre;
    private boolean turno;
    private int aciertos;
    
    public Jugador(String nombre, boolean turno, int aciertos){
        this.nombre = nombre;
        this.turno = turno;
        this.aciertos = 0;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public boolean isTurno(){
        return turno;
    }
    
    public int getAciertos(){
        return aciertos;
    }
    
    public boolean setTurno(boolean turno){
        return this.turno = turno;
    }
    
    public void addAcierto(){
        aciertos++;    
    }
    
    @Override
    public String toString(){
        return nombre+"| Aciertos: "+aciertos+"| Turno: "+(turno?"Su turno" : "");
    }
}
