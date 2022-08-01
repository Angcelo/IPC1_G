/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clase2;

import java.util.Scanner;

/**
 *
 * @author angel
 */
public class Clase2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;
        
        while (!salir) {
            System.out.println("------------Menu-------------");
            System.out.println("1) Hacer aritmeticos y logicas");
            System.out.println("2) Prueba de ciclos");
            System.out.println("3) Salir");
            int eleccion = sc.nextInt();
            switch (eleccion) {
                case 1:
                    int resSuma;
                    resSuma = 1 + 2;
                    int resResta;
                    resResta = 1 - 2;
                    int resMultiplicacion;
                    resMultiplicacion = 2 * 2;
                    int resDivision;
                    resDivision = 2 / 2;

                    System.out.println("El resultado de la suma es: " + resSuma);
                    System.out.println("el resultado de la resta es: " + resResta);
                    System.out.println("El resultado de la multiplicacion es: " + resMultiplicacion);
                    System.out.println("El resultado de la division es: " + resDivision);

                    boolean resTrue = resSuma > resResta;
                    boolean resFalse = resMultiplicacion == resDivision;

                    System.out.println("El resultado de la comparacion es " + resTrue);
                    System.out.println("El resultado de la igualacion es " + resFalse);

                    if (resTrue && resFalse) {
                        System.out.println("No debería entrar aca");
                    }

                    if (resTrue && !resFalse) {
                        System.out.println("Correcto");
                    }

                    if (resTrue || resFalse) {
                        System.out.println("Correcto");
                    }
                    break;
                case 2:
                    for (int i = 0; i < 10; i++) {
                        System.out.println("El valor de la i es " + i);
                    }
                    int i = 10;
                    while (i != 10) {
                        System.out.println("el valor dentro de while de i es: " + i);
                        i += 2;
                    }
                    i = 0;
                    do {
                        System.out.println("el valor dentro de do-while de i es: " + i);
                        i -= 2;
                    } while (i > 0);
                case 3:
                    salir = true;
                    break;
                default:
                    break;
            }
        }
    }

}
