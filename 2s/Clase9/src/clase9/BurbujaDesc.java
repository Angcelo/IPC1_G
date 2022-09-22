package clase9;

import static clase9.Clase9.ArrayDatos;
import static clase9.Clase9.ArrayNombres;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.data.category.DefaultCategoryDataset;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author angel
 */
public class BurbujaDesc extends Thread {

    JPanel panel;
    BarChart barChart;

    public BurbujaDesc(JPanel panel, BarChart barChart) {
        this.panel = panel;
        this.barChart = barChart;
    }

    @Override
    public void run() {
        for (int i = ArrayDatos.length-1; i >0; i--) {
            for (int j = 0; j < i; j++) {
                if (ArrayDatos[j] < ArrayDatos[j + 1]) {
                    String auxX = ArrayNombres[j];
                    float auxY = ArrayDatos[j];

                    ArrayNombres[j] = ArrayNombres[j + 1];
                    ArrayDatos[j] = ArrayDatos[j + 1];

                    ArrayNombres[j + 1] = auxX;
                    ArrayDatos[j + 1] = auxY;
                    viodRedibujar();
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(BurbujaDesc.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
        HTML html = new HTML();
        html.generarHTML();
    }

    private void viodRedibujar() {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int j = 0; j < ArrayDatos.length; j++) {
            dataset.addValue(ArrayDatos[j], ArrayNombres[j], "Colores");
        }
        barChart = new BarChart("Colores", "Cantidad uso", dataset);
        ChartPanel CP = new ChartPanel(barChart.barChart);
        CP.setBounds(0, 0, panel.getWidth(), panel.getHeight());
        panel.removeAll();
        panel.add(CP);
        panel.repaint();
        panel.updateUI();
    }
}
