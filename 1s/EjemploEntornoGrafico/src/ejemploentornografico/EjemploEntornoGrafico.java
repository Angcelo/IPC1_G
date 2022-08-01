/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejemploentornografico;

import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import Usuarios.Personas;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author angel
 */
public class EjemploEntornoGrafico {

    public static Personas personas[];
    public static int contador = 0;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        personas = new Personas[100];
        Vetanas ventana = new Vetanas();
        ventana.setVisible(true);
        /*JFrame ventana = new JFrame("Registro de personas");
        ventana.setSize(500, 500);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        ventana.setResizable(false);
        JTable tabla = new JTable();
        tabla.setModel(new DefaultTableModel(
            new Object[][]{
                {null, null, null, null, null, null}
            }, new String[]{
                "Nombre", "DPI", "Pais", "Ciudad", "fechaNacimiento", "EstadoCivil"
            }));
        tabla.setBounds(10, 10, 400, 400);
        ventana.add(tabla);

        ventana.setVisible(true);*/
    }
}
