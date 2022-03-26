/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package freechart;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import org.jfree.ui.RefineryUtilities;
import org.jfree.chart.ChartPanel;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author angel
 */
public class FreeChart {

    public static JFrame ventana;
    public static JPanel grafico;
    public static JTextField nombretxt;
    public static JTextField categorytxt;
    public static JTextField valortxt;
    public static float[] ArrayDatosY;
    public static String[] ArrayDatosX;


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        NewJFrame nf = new NewJFrame();
        nf.setVisible(true);
        /*ventana = new JFrame();
        ventana.setSize(1344, 756);
        ventana.setLayout(null);
        ventana.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        dataset = new DefaultCategoryDataset();
        
        JFileChooser Filechooser = new JFileChooser();
        Filechooser.setBounds(100, 150, 100, 50);
        
        JLabel titulo = new JLabel("Ejemplo Chart", SwingConstants.CENTER);
        titulo.setFont(new Font("Serif", Font.BOLD, 50));
        titulo.setBounds(100, 50, 700, 60);
        
        grafico = new JPanel();
        grafico.setBounds(100, 200, 700, 500);
        
        BarChart barChart = new BarChart("Ejemplo JFreeChar",
            "Barras", dataset);
        ChartPanel CP = new ChartPanel(barChart.barChart);
        
        grafico.add(CP);
        
        JLabel Agregar = new JLabel("Agregar valor", SwingConstants.CENTER);
        Agregar.setFont(new Font("Serif", Font.BOLD, 25));
        Agregar.setBounds(900, 50, 200, 60);
        
        JLabel nombrelbl = new JLabel("Nombre de Conjunto");
        nombrelbl.setFont(new Font("Serif", Font.BOLD, 20));
        nombrelbl.setBounds(900, 120, 200, 30);
        nombretxt = new JTextField();
        nombretxt.setFont(new Font("Serif", Font.BOLD, 20));
        nombretxt.setBounds(900, 160, 200, 30);
        
        JLabel categorylbl = new JLabel("Nombre Categoría");
        categorylbl.setFont(new Font("Serif", Font.BOLD, 20));
        categorylbl.setBounds(900, 220, 200, 30);
        categorytxt = new JTextField();
        categorytxt.setFont(new Font("Serif", Font.BOLD, 20));
        categorytxt.setBounds(900, 260, 200, 30);
        
        JLabel valorlbl = new JLabel("Valor Categoría");
        valorlbl.setFont(new Font("Serif", Font.BOLD, 20));
        valorlbl.setBounds(900, 320, 200, 30);
        valortxt = new JTextField();
        valortxt.setFont(new Font("Serif", Font.BOLD, 20));
        valortxt.setBounds(900, 360, 200, 30);
        
        JButton agregarBtn = new JButton("Agregar");
        agregarBtn.setBounds(900, 420, 200, 30);
        
        agregarBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                AccionAgregar(evt);
            }
        });
        
        ventana.add(grafico);
        ventana.add(titulo);
        ventana.add(Agregar);
        ventana.add(nombrelbl);
        ventana.add(nombretxt);
        ventana.add(categorylbl);
        ventana.add(categorytxt);
        ventana.add(valorlbl);
        ventana.add(valortxt);
        ventana.add(agregarBtn);
        ventana.setVisible(true);
        ventana.add(Filechooser);*/
    }

    /*static private void AccionAgregar(ActionEvent evt) {
        if (!nombretxt.getText().equals("") /*&& !categorytxt.getText().equals("")*/ /*&& !valortxt.getText().equals("")) {
            try {
                float valor = Float.parseFloat(valortxt.getText());
                dataset.addValue(valor, nombretxt.getText(), "Numeros");
                BarChart barChart = new BarChart("Car Usage Statistics",
                    "Which car do you like?", dataset);
                ChartPanel CP = new ChartPanel(barChart.barChart);
                grafico.removeAll();
                grafico.add(CP);
                grafico.repaint();
                grafico.updateUI();
                valortxt.setText("");
                nombretxt.setText("");
                categorytxt.setText("");
            } catch (NumberFormatException ex) {
                valortxt.setText("");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
        }
    }*/
}
