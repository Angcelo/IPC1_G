/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package archivos;

/**
 *
 * @author angel
 */
public class Jugador {

    public String TipoJugador;
    public String NombreJugador;
    public String PartidasJugadas;

    public Jugador(String nj, String tj, String pj) {
        this.TipoJugador = tj;
        this.NombreJugador = nj;
        this.PartidasJugadas = pj;
    }
}
