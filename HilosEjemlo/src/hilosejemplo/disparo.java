/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilosejemplo;

import static hilosejemplo.HilosEjemplo.Enemigos;
import static hilosejemplo.HilosEjemplo.Nave;
import java.util.Random;
import javax.swing.JLabel;

/**
 *
 * @author angel
 */
public class disparo extends Thread {
    
    private JLabel Disparo;
    
    public disparo(JLabel Enemigo) {
        this.Disparo = Enemigo;
    }
    
    public void run() {
        Disparo.setVisible(true);
        while (Disparo.getY() - 25 > 0 && Disparo.isVisible()) {
            Disparo.setLocation(Disparo.getX(), Disparo.getY() - 25);
            try {
                Thread.sleep(250);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            int i = 0;
            for (JLabel Enemigo : Enemigos) {
                if (Enemigo.isVisible() && Disparo.isVisible()) {
                    if (Enemigo.getX() + 50 >= Disparo.getX() && Enemigo.getX() <= Disparo.getX()
                        && Enemigo.getY() + 50 == Disparo.getY()) {
                        System.out.println("Murió");
                        Enemigo.setVisible(false);
                        Disparo.setVisible(false);
                    }
                }
            }
        }
        this.Disparo.setVisible(false);
        Disparo = null;
    }
}
