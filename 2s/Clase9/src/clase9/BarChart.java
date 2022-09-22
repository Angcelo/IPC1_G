/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase9;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

/**
 *
 * @author angel
 */
public class BarChart extends ApplicationFrame{
    public JFreeChart barChart;
    
    public BarChart(String title, String chartTitle, DefaultCategoryDataset dataset) {
    super(title);
        this.barChart = ChartFactory.createBarChart(
            chartTitle,
            "x-axis",
            "y-axis",
            dataset,
            PlotOrientation.VERTICAL,
            true, true, false);
    }
}
