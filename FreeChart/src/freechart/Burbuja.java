/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package freechart;

import static freechart.FreeChart.*;
import static freechart.NewJFrame.viodRedibujar;

/**
 *
 * @author angel
 */
public class Burbuja extends Thread {

    public void run() {
        String auxX = ArrayDatosX[0];
        float auxY = ArrayDatosY[0];

        ArrayDatosX[0] = ArrayDatosX[1];
        ArrayDatosY[0] = ArrayDatosY[1];

        ArrayDatosX[1] = auxX;
        ArrayDatosY[1] = auxY;

        viodRedibujar();
    }
}
