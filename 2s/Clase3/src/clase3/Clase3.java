/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase3;

import java.util.Scanner;

/**
 *
 * @author angel
 */
public class Clase3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Una oración");
        String oracion = sc.nextLine();
        String[] palabras = oracion.split(" ");
        for (int i = 0; i < palabras.length; i++) {
            System.out.println("Palabra en la posicion: " + i + 
                    " es " + palabras[i]);
        }
    }
}
