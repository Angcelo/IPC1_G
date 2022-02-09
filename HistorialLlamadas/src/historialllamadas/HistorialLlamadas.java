/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package historialllamadas;

import java.util.Scanner;

/**
 *
 * @author angel
 */
public class HistorialLlamadas {

    public static String[][] llamadas;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        llamadas = new String[10][2];
        Scanner sc = new Scanner(System.in);
        System.out.println("Desea realizar una llamada?");
        System.out.println("1) Realizar llamada");
        System.out.println("2) Ver ultimas llamadas");
        int respuesta = sc.nextInt();
        switch (respuesta) {
            case 1:
                System.out.println("Ingrese el nombre del usaurio a llamar");
                String nombre = sc.next();
                System.out.println("Ingrese el numero del telefono");
                String telefono = sc.next();
                Reordenar();

                break;
            case 2:
                imprimir();
                break;
        }

        System.out.println("");
    }

    static void Reordenar() {
        for (int i = llamadas.length - 1; i < 1; i++) {
            llamadas[i] = llamadas[i - 1];
        }
    }

    static void GuardarNuevoContacto(String nombre, String telefono) {
        llamadas[0][0] = nombre;
        llamadas[0][1] = telefono;
    }

    static void imprimir() {
        for (int i = 0; i < llamadas.length - 1; i++) {
            System.out.println("Nombre:" + llamadas[i][0] + ", telefono: " + llamadas[i][1]);
        }
    }

}
