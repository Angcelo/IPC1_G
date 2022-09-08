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
    // An = An-1 * An-2
    public static void main(String[] args) {
        System.out.println(hanoi(4,"origen","auxiliar","destino"));
    }

    public static int Recursiva(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return Recursiva(n - 1) * Recursiva(n - 2);
    }

    //Factorial
    //4 3 2 1
    //4 3 2
    //4 6
    //24
    public static int Factorial(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return n * Factorial(n - 1);
    }

    //fibonacci
    //0 1 2 3 4 5 6 7   6
    //1 1 2 3 5 8 13 ...
    public static int Fibonacci(int n) {
        if (n == 1 || n == 0) {
            return 1;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public static int hanoi(int n, String origen, String auxiliar, String destino) {
        int movimientos=0;
        if (n == 1) {
            System.out.println("mover el disco de " + origen + " hacia "
                    + destino);
            return 1;
        } else {
            movimientos += hanoi(n - 1, origen, destino, auxiliar);
            System.out.println("mover el disco de " + origen + " hacia " + destino);
            movimientos++;
            movimientos += hanoi(n - 1, auxiliar, origen, destino);
        }
        return movimientos;
    }
}
