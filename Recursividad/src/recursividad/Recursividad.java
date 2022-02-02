/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package recursividad;

/**
 *
 * @author angel
 */
public class Recursividad {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*int resultadoFactorial = Factorial(4);
        System.out.println(resultadoFactorial);
        resultadoFactorial = 1;
        for (int i = 1; i <= 4; i++) {
            resultadoFactorial *= i;
        }*/
        int resultadoFibonacci = fibonacci(4);
        System.out.println(resultadoFibonacci);
    }

    static int Factorial(int numero) {
        int resultado = 0;
        if (numero > 1) {
            resultado = numero * Factorial(numero - 1);
        } else {
            resultado = 1;
        }
        return resultado;
    }

    static int fibonacci(int numero) {
        if (numero <= 1) {
            return 1;
        }
        return fibonacci(numero - 1) + fibonacci(numero - 2);
    }

}
