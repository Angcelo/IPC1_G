/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GaussJordan;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author OMAR OLMEDO
 */
public class MetodoDeGaussJordan extends javax.swing.JFrame {

    int f, c;// variables usadas para almacenar las imensiones de la matriz aumentada

    DefaultTableModel modelo = new DefaultTableModel();
    Boolean ban = false;

    public MetodoDeGaussJordan() {
        initComponents();

        this.setLocationRelativeTo(null);// al momento de ejecutar la aplicacion lo ventana se  centra en la pantalla
    }

    /**
     * @param m almacena los coeficientes de la matriz aumentada
     * @param r almaena los valores de la solucion de acda expresion
     * @return
     */
    public double[] cargarMatriz(double m[][], double r[]) {

        // recuerde que el metodo de Gauss Jordan trabaja con la idea de convertir la matriz aumentada en la matriz identidad
        for (int i = 0; i <= r.length - 1; i++) {
            double d, c = 0;
            d = m[i][i];// seleccionamos el pivote
            area_de_texto.append(Double.toString(d / 2) + "*fila" + (i + 1) + "\n");// muesra en el area de texto el pivote seleccionado
            for (int s = 0; s <= r.length - 1; s++) {// pasamos a convertir en 1 al pivote seleionado
                m[i][s] = ((m[i][s]) / d);
            }
            r[i] = ((r[i]) / d);

            // paso a mostrar las opraciones realizadas en la matriz aumentada
            for (int j = 0; j < r.length; j++) {

                for (int k = 0; k < r.length; k++) {
                    area_de_texto.append(Double.toString(m[j][k]) + "\t");
                }
                area_de_texto.append("|\t" + Double.toString(r[j]) + "\n");
            }
            area_de_texto.append("\n\n");// fin paso a motrar las opraciones realizadas en la matriz aumentada

            for (int x = 0; x <= r.length - 1; x++) {
                if (i != x) {
                    c = m[x][i];
                    area_de_texto.append("-" + Double.toString(c) + " * fila" + (i + 1) + "+ fila" + (x + 1) + "\n");// mustra en pantalla las opraciones que se realizaran por fila
                    for (int y = 0; y <= r.length - 1; y++) {// se hace cero a todos los elemntos de la colunma que no sean el pivote
                        m[x][y] = m[x][y] - c * m[i][y];

                    }
                    r[x] = r[x] - c * r[i];

                    // paso a mostrar las opraciones realizadas en la matriz aumentada
                    for (int j = 0; j < r.length; j++) {

                        for (int k = 0; k < r.length; k++) {
                            area_de_texto.append(Double.toString(m[j][k]) + "\t");
                        }
                        area_de_texto.append("|\t" + Double.toString(r[j]) + "\n");
                    }
                    area_de_texto.append("\n\n");// fin paso a motrar las opraciones realizadas en la matriz aumentada

                }// fin if (i != x)
            }// fin for (int x = 0; x <= r.length - 1; x++)

        }//fin bucle i
        return r;// retorna la solucion l sistema

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextFieldNumeroDeIncognitas = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButtoncargar_matriz1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        area_de_texto = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jButtoncargar_matriz2 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jButtoncargar_matriz = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jButton1 = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Solución de Matrices By Olmedo"));
        jPanel1.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Matura MT Script Capitals", 0, 36)); // NOI18N
        jPanel1.add(jLabel3);
        jLabel3.setBounds(210, 10, 610, 40);

        jLabel6.setFont(new java.awt.Font("Segoe UI Semibold", 3, 24)); // NOI18N
        jLabel6.setText("Solución de Matrices por el método de Gauss Jordan");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(180, 30, 640, 60);

        jTextFieldNumeroDeIncognitas.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTextFieldNumeroDeIncognitas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumeroDeIncognitasActionPerformed(evt);
            }
        });
        jPanel1.add(jTextFieldNumeroDeIncognitas);
        jTextFieldNumeroDeIncognitas.setBounds(260, 130, 80, 30);

        jTable1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jTable1.setFont(new java.awt.Font("Comic Sans MS", 0, 14)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "x"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(0, 170, 550, 200);

        jButtoncargar_matriz1.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        jButtoncargar_matriz1.setText("Resolver Matriz");
        jButtoncargar_matriz1.setActionCommand("Resolver matriz");
        jButtoncargar_matriz1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButtoncargar_matriz1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncargar_matriz1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButtoncargar_matriz1);
        jButtoncargar_matriz1.setBounds(20, 380, 190, 30);

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));

        area_de_texto.setEditable(false);
        area_de_texto.setColumns(20);
        area_de_texto.setRows(5);
        jScrollPane2.setViewportView(area_de_texto);

        jLabel1.setFont(new java.awt.Font("Shruti", 0, 14)); // NOI18N
        jLabel1.setText("Solución");

        jButtoncargar_matriz2.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        jButtoncargar_matriz2.setText("Borrar");
        jButtoncargar_matriz2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButtoncargar_matriz2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncargar_matriz2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(135, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jButtoncargar_matriz2, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(101, 101, 101))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 18, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addComponent(jButtoncargar_matriz2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(550, 130, 430, 380);

        jLabel7.setFont(new java.awt.Font("Shruti", 0, 14)); // NOI18N
        jLabel7.setText("Número de incógnitas de la matriz");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(40, 120, 230, 50);

        jButtoncargar_matriz.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        jButtoncargar_matriz.setText("Diseñar Matriz");
        jButtoncargar_matriz.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jButtoncargar_matriz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtoncargar_matrizActionPerformed(evt);
            }
        });
        jPanel1.add(jButtoncargar_matriz);
        jButtoncargar_matriz.setBounds(350, 130, 190, 30);
        jPanel1.add(jSeparator1);
        jSeparator1.setBounds(10, 120, 970, 2);

        jButton1.setFont(new java.awt.Font("Consolas", 0, 13)); // NOI18N
        jButton1.setText("Salir");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(260, 460, 100, 40);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 990, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 535, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtoncargar_matrizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncargar_matrizActionPerformed
        /*
        * pasamos a mostrar los cuadros para llenar la matriz aumentada en la pantalla
         */

 /*
        * ejemplo si el sistema tiene 2 incognitas aparecera en la pantalla una matriz de 2x3
         */
        try {
            /*
            * ejemplo si el sistema tiene 2 incognitas aparecera en la pantalla una matriz de 2x3
             */
            f = Integer.parseInt(jTextFieldNumeroDeIncognitas.getText());
            c = f + 1;

            //
            Object col[] = new Object[c];//  al erreglo mostrara en el titulo del JTabel las las incognitas y su solucion de la ecuaciom
            // ejemplo si el sistema tiene 2 incognitas aparecera en la pantalla una matriz de 2x3
            // se motrara en el titulo del JTable  x1  x2   d
            for (int j = 0; j < c; j++) {
                if (j < c - 1) {
                    col[j] = "X" + (j + 1);
                } else {
                    col[j] = "d";
                }
            }
            modelo = new DefaultTableModel(col, f);// se muestra el titulo y el Jtablet toma la dimension de la matriz aumentada
            jTable1.setModel(modelo);// el Jtablet toma la dimension de la matriz aumentada

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "INGRESO ERRONEO", "MENSAJE", JOptionPane.PLAIN_MESSAGE);
        }
    }//GEN-LAST:event_jButtoncargar_matrizActionPerformed

    private void jButtoncargar_matriz2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncargar_matriz2ActionPerformed
        // TODO add your handling code here:
        area_de_texto.setText("");
    }//GEN-LAST:event_jButtoncargar_matriz2ActionPerformed

    private void jButtoncargar_matriz1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtoncargar_matriz1ActionPerformed
        /*
        * acontinuacion pasamos a gargar los datos ingresados en los cuadros del Jtablet en la matriz aumntada
         */
        try {

            int n = Integer.parseInt(jTextFieldNumeroDeIncognitas.getText());// alamacena el nuemro de ingonitas ingresado por teclado

            double m[][] = new double[n][n];// almacena los coeficientes de la matriz aumentada
            double r[] = new double[n];// almacena al valor de la solucion de cada ecuacion ejemplo si 2x+4x2=3 entonces debera ingresar el los cuadors  2   4   3   en donde , m[0][1]=2,m[0][2]=4  y   r[0]=3

            for (int i = 0; i < n; i++) {// pasamos a alamcenar en un arreglo los datos ingresados en el JTable
                for (int j = 0; j < n; j++) {//
                    m[i][j] = Double.parseDouble(String.valueOf(jTable1.getValueAt(i, j)));
                }
                r[i] = Double.parseDouble(String.valueOf(jTable1.getValueAt(i, n)));
            }

            double solucion[] = new double[n];// almacena la soluciones del sistema
            r = this.cargarMatriz(m, r);// llamada al metodo a calcula la solucion del sistema de eciones

            //pasamos a mostrar las soluciones del sistema en el area de texto
            for (int i = 0; i < n; i++) {
                area_de_texto.append("x" + (i + 1) + " = " + r[i] + "\n");
            }

        }//fin try
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "error ingreso de datos \n"
                    + "NOTA: verifique que no haya casillas seleccionadas ni vacias\n"
                    + " también verifique que el ingreso de tados sea correctos");
        }
    }//GEN-LAST:event_jButtoncargar_matriz1ActionPerformed

    private void jTextFieldNumeroDeIncognitasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumeroDeIncognitasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumeroDeIncognitasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MetodoDeGaussJordan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MetodoDeGaussJordan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MetodoDeGaussJordan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MetodoDeGaussJordan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MetodoDeGaussJordan().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea area_de_texto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButtoncargar_matriz;
    private javax.swing.JButton jButtoncargar_matriz1;
    private javax.swing.JButton jButtoncargar_matriz2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jTextFieldNumeroDeIncognitas;
    // End of variables declaration//GEN-END:variables
}
