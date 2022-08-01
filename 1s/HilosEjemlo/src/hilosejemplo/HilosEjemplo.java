/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hilosejemplo;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;

/**
 *
 * @author angel
 */
public class HilosEjemplo {

    public static JFrame ventanaP;
    public static JLabel Nave;
    public static JLabel[] Enemigos;
    public static JLabel Disparo;
    public static int minutos;
    public static int segundos;
    public static int milisegundos;
    public static JLabel tiempo;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        milisegundos = 0;
        segundos = 0;
        minutos = 0;
        ventanaP = new JFrame("Space");
        tiempo = new JLabel();
        tiempo.setBounds(400, 0, 100, 10);
        Enemigos = new JLabel[10];
        for (int i = 0; i < 10; i++) {
            Enemigos[i] = new JLabel();
            Enemigos[i].setIcon(new ImageIcon("AlienT.png"));
            Enemigos[i].setBounds(25, 50, 50, 50);
            Enemigos[i].setVisible(false);
        }
        Nave = new JLabel();
        ventanaP.setSize(500, 500);
        ventanaP.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventanaP.setLayout(null);

        ventanaP.add(tiempo);
        Cronometro c = new Cronometro();
        c.start();

        Nave.setIcon(new ImageIcon("NaveT.png"));
        Nave.setBounds(25, 350, 50, 50);
        ventanaP.add(Nave);
        int i = 0;
        for (JLabel Enemigo : Enemigos) {
            ventanaP.add(Enemigo);
            MovimientoEnemigo me = new MovimientoEnemigo(Enemigo, 2000 * i);
            me.start();
            i++;
        }

        ventanaP.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent evt) {
                NaveKeyReleased(evt);
            }
        });

        ventanaP.setVisible(true);
    }

    static private void NaveKeyReleased(KeyEvent evt) {
        char key = evt.getKeyChar();
        switch (key) {
            case 'a':
                if (Nave.getX() - 25 > 0) {
                    Nave.setLocation(Nave.getX() - 25, Nave.getY());
                }
                break;
            case 'd':
                if (Nave.getX() + 25 < 450) {
                    Nave.setLocation(Nave.getX() + 25, Nave.getY());
                }
                break;
            case 'j':
                if (Disparo == null || !Disparo.isVisible()) {
                    System.out.println("Disparo");
                    Disparo = new JLabel();
                    Disparo.setIcon(new ImageIcon("DisparoT.png"));
                    Disparo.setBounds(Nave.getX(), 350, 25, 25);
                    Disparo.setVisible(false);
                    ventanaP.add(Disparo);
                    ventanaP.repaint();
                    disparo disparoObject = new disparo(Disparo);
                    disparoObject.start();
                }
        }
        int i = 0;
        for (JLabel Enemigo : Enemigos) {
            if (Enemigo.isVisible()) {
                if (Enemigo.getY() + 50 >= Nave.getY() && Enemigo.getY() <= Nave.getY()
                    && Enemigo.getX() >= Nave.getX() && Enemigo.getX() <= Nave.getX() + 50) {
                    System.out.println("Colisionó");
                    System.exit(0);
                }
            }
        }
    }
}
