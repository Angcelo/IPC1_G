/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chartejemplo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 *
 * @author angel
 */
public class Barras extends Application {

    final static String Guatemala = "Guatemalas";
    final static String ElSalvador = "El Salvador";
    final static String Honduras = "Honduras";
    final static String Nicaragua = "Nicaragua";
    final static String CostaRica = "Costa Rica";
    final static String Panama = "Panama";

    @Override
    public void start(Stage stage) {
        stage.setTitle("Ejemplo gráfico de barras");
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> barChart = new BarChart(xAxis, yAxis);
        barChart.setTitle("Población");
        xAxis.setLabel("Paises");
        yAxis.setLabel("Cantidad");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("2003");
        series1.getData().add(new XYChart.Data(Guatemala, 12.42));
        series1.getData().add(new XYChart.Data(ElSalvador, 5.99));
        series1.getData().add(new XYChart.Data(Honduras, 7.11));
        series1.getData().add(new XYChart.Data(Nicaragua, 5.29));
        series1.getData().add(new XYChart.Data(CostaRica, 4.16));
        series1.getData().add(new XYChart.Data(Panama, 3.21));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("2004");
        series2.getData().add(new XYChart.Data(Guatemala, 12.68));
        series2.getData().add(new XYChart.Data(ElSalvador, 6.02));
        series2.getData().add(new XYChart.Data(Honduras, 7.28));
        series2.getData().add(new XYChart.Data(Nicaragua, 5.37));
        series2.getData().add(new XYChart.Data(CostaRica, 4.22));
        series2.getData().add(new XYChart.Data(Panama, 3.27));

        Scene scene = new Scene(barChart, 800, 600);
        barChart.getData().addAll(series1, series2);
        stage.setScene(scene);
        stage.show();
    }

    public void LanzarBarras(String[] args) {
        launch(args);
    }
}
