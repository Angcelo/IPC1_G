/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package prueba;

import java.util.Scanner;

/**
 *
 * @author angel
 */
public class Prueba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int resultado = Factorial(2);
        System.out.print(resultado);
    }

    static int Factorial(int num1) {
        int res;
        if (num1 > 0) {
            res = num1 * Factorial(num1 - 1);
        } else {
            res = 1;
        }
        return res;
    }
