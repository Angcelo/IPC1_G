/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilosejemplo;

import static hilosejemplo.HilosEjemplo.milisegundos;
import static hilosejemplo.HilosEjemplo.minutos;
import static hilosejemplo.HilosEjemplo.segundos;
import static hilosejemplo.HilosEjemplo.tiempo;

/**
 *
 * @author angel
 */
public class Cronometro extends Thread {
    
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            milisegundos++;
            if (milisegundos > 1000) {
                segundos++;
                milisegundos = 0;
            }
            if (segundos > 60) {
                minutos++;
                segundos = 0;
            }
            tiempo.setText(String.valueOf(minutos) + ":" + String.valueOf(segundos) + ":" + String.valueOf(milisegundos));
        }
    }
}
