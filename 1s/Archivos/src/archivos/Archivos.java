/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package archivos;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author angel
 */
public class Archivos {

    private static String path = "aFile.txt";
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // formato de archivo
        /*
    nombre usuario, tipo de usuario, partidas ganadas
         */
        // crea el archivo
        createFile(path);
        // escribe en el archivo una cadena inicial
        writeFile("pancho,noob,1\ncasimiro,crack,30\n", path);

        // obtiene el contenido del archivo
        String contenido = readFile(path);
        System.out.println("Contenido: \n" + contenido); // imprime en consola el contenido del archivo

        String filas[] = contenido.split("\n"); // separar el arcihvo en filas, cada fila es un usuario
        ArrayList<Jugador> jugadores = new ArrayList<>(); // Create lista array 

        // recorre todas las filas del archivo
        for (int fila = 0; fila < filas.length; fila++) {
            String atributos[] = filas[fila].split(","); // separa una fila en columnas/atributos
            if (atributos.length == 3) {
                Jugador jugador = new Jugador(atributos[0], atributos[1], atributos[2]);
                jugadores.add(jugador);
            }
        }

        // recorrer array de jugadores
        for (int jugador = 0; jugador < jugadores.size(); jugador++) {
            System.out.println(jugadores.get(jugador).NombreJugador + "\t" + jugadores.get(jugador).TipoJugador + "\t" + jugadores.get(jugador).PartidasJugadas);
        }
    }

    static public Boolean createFile(String path) {
        Boolean response = true;
        try {
            // construir referencia del archivo
            File myObj = new File(path);

            // intenta crear el archivo, true si lo logró crear, false si el archivo ya existe
            if (myObj.createNewFile()) {
                System.out.println("File created: " + myObj.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            // en caso de error, se imprime el error
            System.out.println("An error occurred.");
            e.printStackTrace();
            response = false;
        }

        return response;
    }

    public static String readFile(String path) {
        String response = "";
        try {
            // construir referencia del archivo
            File myObj = new File(path);
            Scanner myReader = new Scanner(myObj); // obtener todo el archivo

            // leer línea por línea el archivo y convertirlo a string
            String data = "";
            while (myReader.hasNextLine()) {
                data += myReader.nextLine() + "\n";
                System.out.println(data);
            }

            myReader.close(); // cerrar el lector del archivo
            response = data;
        } catch (FileNotFoundException e) {
            // en caso de error, mostrar el mensaje de error
            System.out.println("An error occurred.");
            e.printStackTrace();
            response = "";
        }

        return response;
    }

    public static Boolean writeFile(String content, String path) {
        Boolean response = true;

        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.write(content);
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            // en caso de error, mostrar el mensaje de error
            System.out.println("An error occurred.");
            e.printStackTrace();
            response = false;
        }

        return response;
    }

}
