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
        Scanner sc = new Scanner(System.in);
        String respuesta = "0";
//Menu hecho en java
        do {
            System.out.println("----ejemplo menu en java----");
            System.out.println("---Menu Principal---");
            System.out.println("1) Ejemplo de datos primitivos");
            System.out.println("2) Ejemplo de datos no primitivos");
            System.out.println("3) Ejemplo If");
            System.out.println("4) Ejemplo Switch");
            System.out.println("5) Ejemplo For");
            System.out.println("6) Ejemplo While");
            System.out.print("7) Presione 0 si desea salir");
            respuesta = sc.nextLine();
//Switch para seleccionar la elección del usaurio
            switch (respuesta) {
//Ejemplo datos primitivos
                case "1":
                    System.out.println("Tipos de datos primitivos");
                    // entero
                    int numero1 = 2;
                    int numero2 = 100;
                    //int numero3 = 2.5; // error, no puedes asignar un decimal a una variable de tipo entero
                    System.out.println(numero1);
                    System.out.println(numero2);
                    // decimales
                    float decimalCorto = (float) 3.0123456789; // error, float soporta solo 7 decimales, redondea superior
                    double decimalLargo = 3.01234567890123456789; // soporta 15 decimales, redondea superior
                    System.out.println(decimalCorto);
                    System.out.println(decimalLargo);
                    // caracteres
                    char caracter1 = 'a'; // caracter se encierra en apóstrofo
                    char caracter2 = '-';
                    // booleano
                    boolean booleano1 = true;
                    boolean booleano2 = false;
                    System.out.println(booleano1);
                    System.out.println(booleano2);

                    // operadores
                    System.out.println("\nOperadores");
                    int incremento = 1;
                    System.out.println(incremento + " número inicial");
                    System.out.println(incremento++ + " ocurrencia de incremento");
                    System.out.println(incremento + " número incrementado");
                    System.out.println(incremento-- + " ocurrencia de decremento");
                    System.out.println(incremento + " número decrementado");

                    // usaremos numero1 y numero2
                    System.out.println("Aritméticos");
                    int suma = numero1 + numero2;
                    System.out.println(suma);

                    int resta = numero1 - numero2;
                    System.out.println(resta);

                    int multiplicacion = numero1 * numero2;
                    System.out.println(multiplicacion);

                    int division = numero2 / numero1;
                    System.out.println(division);

                    int modulo = numero2 % numero1;
                    System.out.println(modulo);

                    // comparativos
                    System.out.println("Comparativos");
                    boolean menorque = numero1 < numero2;
                    System.out.println(menorque);

                    boolean mayorque = numero1 > numero2;
                    System.out.println(mayorque);

                    boolean menorigual = numero1 <= numero2;
                    System.out.println(menorigual);

                    boolean mayorigual = numero1 >= numero2;
                    System.out.println(mayorigual);

                    boolean igual = numero1 == numero2;
                    System.out.println(igual);

                    boolean diferente = numero1 != numero2;
                    System.out.println(diferente);

                    // booleanos
                    System.out.println("Booleanos");
                    boolean verdadero = true;
                    boolean falso = false;
                    boolean and = verdadero && verdadero; // tabla Y, conjunción
                    System.out.println(and);

                    boolean or = verdadero || falso; // tabla O, disyunción
                    System.out.println(or);

                    boolean xor = verdadero ^ verdadero; // tabla XOR, disyunción exclusiva
                    System.out.println(xor);

                    break;
//Ejemplo datos no primitivos
                case "2":
                    System.out.println("\nTipos de datos no primitivos");
                    // cadena de caracteres
                    String cadena1 = "Soy una cadena"; // cadena se encierra en comillas dobles
                    System.out.println(cadena1);
                    System.out.println("Y puedo saber mi tamaño: " + cadena1.length());
                    break;
//Ejemplo If
                case "3":
                    System.out.println("Indique la temperatura a la que se encuentra");
                    int temperatura = sc.nextInt();
                    if (temperatura < 36) {
                        System.out.println("Su temperatura es muy baja");
                    } else if (temperatura >= 36 && temperatura <= 37) {
                        System.out.println("Temperatura normal");
                    } else {
                        System.out.println("Temperatura muy alta");
                    }
                    break;
//Ejemplo Switch
                case "4":
                    System.out.println("De numero a dia de la semana");
                    System.out.println("Introduzca un numero entre 1 y 7");
                    int dia = sc.nextInt();
                    switch (dia) {
                        case 1:
                            System.out.println("El dia es Lunes");
                            break;
                        case 2:
                            System.out.println("El dia es Martes");
                            break;
                        case 3:
                            System.out.println("El dia es Miercoles");
                            break;
                        case 4:
                            System.out.println("El dia es Jueves");
                            break;
                        case 5:
                            System.out.println("El dia es Viernes");
                            break;
                        case 6:
                            System.out.println("El dia es Sabado");
                            break;
                        case 7:
                            System.out.println("El dia es Domingo");
                            break;
                        default:
                            System.out.println("No selecciono un dia correcto");
                            break;
                    }
                    break;
//Ejemplo semi piramide
                case "5":
                    System.out.println("Semi piramide, indique el tamaño que desea que tenga");
                    int tamano = sc.nextInt();
                    for (int i = 0; i <= tamano; i++) {
                        for (int j = 0; j < i; j++) {
                            System.out.print("*");
                        }
                        System.out.print("\n");
                    }
                    break;
                case "6":
                    System.out.println("Introduzca un numero");
                    int numero = sc.nextInt();
                    int cantidadDecimales = 0;
                    while (numero > 0) {
                        numero /= 10;
                        cantidadDecimales++;
                    }
                    System.out.println("Su cantidad de decimales es: " + cantidadDecimales);
                    break;
                default:
                    break;
            }
        } while (!respuesta.equals("0"));
    }

}
