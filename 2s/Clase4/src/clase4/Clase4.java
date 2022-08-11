/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase4;

/**
 *
 * @author angel
 */
public class Clase4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] arrayDesordenado = {5,7,9,1,2,14,20,6,8,13};
        Insercion(arrayDesordenado);
        for (int i = 0; i < arrayDesordenado.length; i++) {
            if(i==0) {
                System.out.print(arrayDesordenado[i]);
            } else {
                System.out.print(", " + arrayDesordenado[i]);
            }
        }
    }
    
    public static void Burbuja(int[] array) {
        int i,j,aux;
        for (i = 0; i < array.length; i++) {
            for (j = 0; j < array.length -i -1 ; j++) {
                if(array[j+1] > array[j]) {
                    aux = array[j+1];
                    array[j+1] = array[j];
                    array[j] = aux;
                }
            }
        }
    }  
    
    public static void Insercion(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int actual = array[i];
            int j = i - 1;
            while ((j > -1) && (array[j] > actual)) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = actual;
        }
    }
}
