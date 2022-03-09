/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package chartejemplo;

import javafx.scene.Group;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.stage.Stage;

/**
 *
 * @author angel
 */
public class Pie extends Application {

    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Ejemplo gráfico de pie");
        stage.setWidth(500);
        stage.setHeight(500);
        ObservableList<PieChart.Data> pieChartData
            = FXCollections.observableArrayList(
                new PieChart.Data("Uvas", 13),
                new PieChart.Data("Naranjas", 25),
                new PieChart.Data("Limones", 10),
                new PieChart.Data("Peras", 22),
                new PieChart.Data("Mazanas", 30)
            );
        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Frutas");
        ((Group) scene.getRoot()).getChildren().add(chart);
        stage.setScene(scene);
        stage.show();
    }

    public void LanzarPie(String[] args) {
        launch(args);
    }
}
