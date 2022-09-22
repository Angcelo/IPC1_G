/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase9;

import static clase9.Clase9.ArrayDatos;
import static clase9.Clase9.ArrayNombres;
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
        String textoHTML = "<!DOCTYPE html>\n<html>\n";
        textoHTML += "<head>";
        textoHTML += "\t<meta charset=\"UTF-8\">";
        textoHTML += "\t<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">";
        textoHTML += "\t<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">";
        textoHTML += "\t<title>Resultados</title>";
        textoHTML += "</head>";
        textoHTML += "<Body>";
        //Ya esta el head y el body
        textoHTML += "\t<table style=\"border: 1px solid;\">\n";
        for (int i = 0; i < ArrayNombres.length; i++) {
            textoHTML += "\t\t<tr>\n";
            textoHTML += "\t\t\t<td style=\"border: 1px solid;\">";
            textoHTML += ArrayNombres[i];
            textoHTML += "</td>\n";
            textoHTML += "\t\t\t<td style=\"border: 1px solid;\">";
            textoHTML += ArrayDatos[i];
            textoHTML += "</td>\n";
            textoHTML += "\t\t</tr>\n";
        }
        textoHTML += "</table>\n";
        textoHTML += "</Body>";
        textoHTML += "</html>\n";
        try {
            String nombre = "Reporte" + dtf.format(LocalDateTime.now()) + ".html";
            File html = new File(nombre);
            html.createNewFile();
            try (FileWriter writer = new FileWriter(nombre)) {
                writer.write(textoHTML);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
