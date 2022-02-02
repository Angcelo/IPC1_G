/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tablero;

import java.util.Scanner;

/**
 *
 * @author angel
 */
public class Tablero {

    static char tablero[][];

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca la cantidad de alto y ancho del tablero");
        int valor = sc.nextInt();
        tablero = new char[valor + 2][valor + 2];
        for (int i = 0; i < valor + 2; i++) {
            for (int j = 0; j < valor + 2; j++) {
                tablero[i][j] = ' ';
            }
        }
        Marco(valor);
        while (true) {
            System.out.print("Desea agregar comida al tablero, 's' para si");
            char respuesta = sc.next().charAt(0);
            if (respuesta == 's') {
                System.out.print("Introduzca la coordenada en X");
                int coorX = sc.nextInt();
                System.out.println("Introduzca la coordenada en Y");
                int coorY = sc.nextInt();
                if (coorX >= 0 && coorY >= 0 && coorX <= valor && coorY <= valor) {
                    if (tablero[coorX][coorY] == ' ') {
                        tablero[coorX][coorY] = '#';
                    } else {
                        System.out.println("La coordenada que introdujo ya se encuentra ocupada");
                    }
                } else {
                    System.out.println("Alguna coordenada que introdujo no es encuentra en el rango del tablero");
                }
            } else {
                break;
            }
        }
        ImprimirTablero(valor);
    }

    static void Marco(int tamaño) {
        for (int i = 0; i < tamaño + 2; i++) {
            tablero[0][i] = '*';
        }
        for (int i = 0; i < tamaño + 2; i++) {
            tablero[tamaño + 1][i] = '*';
        }
        for (int i = 0; i < tamaño + 2; i++) {
            tablero[i][0] = '*';
        }
        for (int i = 0; i < tamaño + 2; i++) {
            tablero[i][tamaño + 1] = '*';
        }
    }

    static void ImprimirTablero(int tamano) {
        for (int i = 0; i < tamano + 2; i++) {
            for (int j = 0; j < tamano + 2; j++) {
                System.out.print(tablero[i][j]);
            }
            System.out.print("\n");
        }
    }
}
