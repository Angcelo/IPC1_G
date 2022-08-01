/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hilosejemplo;

import static hilosejemplo.HilosEjemplo.Nave;
import java.util.Random;
import javax.swing.JLabel;

/**
 *
 * @author angel
 */
public class MovimientoEnemigo extends Thread {

    private final JLabel Enemigo;
    private final int Retraso;

    public MovimientoEnemigo(JLabel Enemigo, int Retraso) {
        this.Enemigo = Enemigo;
        this.Retraso = Retraso;
        Random random = new Random();
        int value = random.nextInt(17 + 1) + 1;
        Enemigo.setLocation(value * 25, 50);
    }

    public void run() {
        try {
            Thread.sleep(Retraso);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
        Enemigo.setVisible(true);
        while (Enemigo.getY() + 25 < 450 && Enemigo.isVisible()) {
            Enemigo.setLocation(Enemigo.getX(), Enemigo.getY() + 25);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
            if (Enemigo.getX() >= Nave.getX() && Enemigo.getX() <= Nave.getX() + 25 && Enemigo.getY() + 50 == Nave.getY()) {
                System.out.println("Colisionó");
                System.exit(0);
            }
        }
        MovimientoEnemigo me = new MovimientoEnemigo(Enemigo, 1000);
        me.start();
        Enemigo.setVisible(false);
    }
}
