/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package freechart;

import static freechart.FreeChart.ArrayDatosX;
import static freechart.FreeChart.ArrayDatosY;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author angel
 */
public class HTML {

    public void generarHTML() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH_mm_ss");
        String textoHTML = "<html>\n";
//Ya esta el head y el body
        textoHTML += "<table style=\"border: 1px solid;\">\n";
        for (int i = 0; i < ArrayDatosX.length; i++) {
            textoHTML += "<tr>\n";
            textoHTML += "<td style=\"border: 1px solid;\">\n";
            textoHTML += ArrayDatosX[i] + "\n";
            textoHTML += "</td>\n";
            textoHTML += "<td style=\"border: 1px solid;\">\n";
            textoHTML += ArrayDatosY[i] + "\n";
            textoHTML += "</td>\n";
            textoHTML += "</tr>\n";
        }
        textoHTML += "</table>\n";
        textoHTML += "</html>\n";
        try {
            System.out.println(dtf.format(LocalDateTime.now()));
            File html = new File("Reporte.html");
            html.createNewFile();
            FileWriter writer = new FileWriter("Reporte.html");
            writer.write(textoHTML);
            writer.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
