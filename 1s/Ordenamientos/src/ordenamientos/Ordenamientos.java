/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ordenamientos;

/**
 *
 * @author angel
 */
public class Ordenamientos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] burbuja = {10, 50, 23, 56, 17, 29, 45, 14, 27, 33, 16, 21, 25, 28, 76};
        for (int i = 0; i < burbuja.length; i++) {
            System.out.print(burbuja[i] + ",");
        }
        System.out.print("\n");
        InsercionDirecta(burbuja);
        for (int i = 0; i < burbuja.length; i++) {
            System.out.print(burbuja[i] + ",");
        }
        System.out.print("\n");
    }

    public static void Burbuja(int[] Burbuja) {
        int j, i, aux;
        for (i = 0; i < Burbuja.length - 1; i++) {
            for (j = 0; j < Burbuja.length - i - 1; j++) {
                if (Burbuja[j + 1] < Burbuja[j]) {
                    aux = Burbuja[j + 1];
                    Burbuja[j + 1] = Burbuja[j];
                    Burbuja[j] = aux;
                }
            }
        }
    }

    public static void InsercionDirecta(int[] insercion) {
        int p, j;
        int aux;
        for (p = 1; p < insercion.length; p++) {
            aux = insercion[p];
            j = p - 1;
            while ((j >= 0) && (aux < insercion[j])) {
                insercion[j + 1] = insercion[j];
                j--;
            }
            insercion[j + 1] = aux;
        }
    }
}
