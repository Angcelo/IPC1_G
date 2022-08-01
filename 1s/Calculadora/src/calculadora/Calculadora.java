/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadora;

import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author angel
 */
public class Calculadora extends JFrame {
    
    static JFrame f;

    // create a textfield
    static JTextField l;

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        // create a frame
        f = new JFrame("Calculadora");
        f.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        f.setResizable(false);
        // create a object of class
        // create a textfield
        l = new JTextField();

        // set the textfield to non editable
        l.setEditable(false);
        l.setBounds(30, 30, 430, 50);

        // create number buttons and some operators
        JButton b0, b1, b2, b3, b4, b5, b6, b7, b8, b9, ba, bs, bd, bm, be, beq, beq1;

        // create number buttons
        b0 = new JButton("7");
        b0.setBounds(30, 150, 100, 50);
        b1 = new JButton("8");
        b1.setBounds(140, 150, 100, 50);
        b2 = new JButton("9");
        b2.setBounds(250, 150, 100, 50);
        b3 = new JButton("4");
        b3.setBounds(30, 210, 100, 50);
        b4 = new JButton("5");
        b4.setBounds(140, 210, 100, 50);
        b5 = new JButton("6");
        b5.setBounds(250, 210, 100, 50);
        b6 = new JButton("1");
        b6.setBounds(30, 270, 100, 50);
        b7 = new JButton("2");
        b7.setBounds(140, 270, 100, 50);
        b8 = new JButton("3");
        b8.setBounds(250, 270, 100, 50);
        b9 = new JButton("0");
        b9.setBounds(30, 330, 210, 50);
        be = new JButton(".");
        be.setBounds(250, 330, 100, 50);

        // equals button
        beq1 = new JButton("=");
        beq1.setBounds(360,210,100,170);

        // create operator buttons
        ba = new JButton("+");
        ba.setBounds(30,90,100,50);
        bs = new JButton("-");
        bs.setBounds(140,90,100,50);
        bd = new JButton("/");
        bd.setBounds(250,90,100,50);
        bm = new JButton("*");
        bm.setBounds(360,90,100,50);
        beq = new JButton("C");
        beq.setBounds(360,150,100,50);

        // create . button
        // create a panel
        JPanel p = new JPanel();
        Ejecutar accion = new Ejecutar();
// add action listeners
        bm.addActionListener(accion);
        bd.addActionListener(accion);
        bs.addActionListener(accion);
        ba.addActionListener(accion);
        b9.addActionListener(accion);
        b8.addActionListener(accion);
        b7.addActionListener(accion);
        b6.addActionListener(accion);
        b5.addActionListener(accion);
        b4.addActionListener(accion);
        b3.addActionListener(accion);
        b2.addActionListener(accion);
        b1.addActionListener(accion);
        b0.addActionListener(accion);
        be.addActionListener(accion);
        beq.addActionListener(accion);
        beq1.addActionListener(accion);

        // add elements to panel
        f.add(l);
        f.add(ba);
        f.add(b1);
        f.add(b2);
        f.add(b3);
        f.add(bs);
        f.add(b4);
        f.add(b5);
        f.add(b6);
        f.add(bm);
        f.add(b7);
        f.add(b8);
        f.add(b9);
        f.add(bd);
        f.add(be);
        f.add(b0);
        f.add(beq);
        f.add(beq1);

        // set Background of panel
        p.setBackground(Color.blue);

        // add panel to frame
        f.setLayout(null);
        
        f.setSize(510, 460);
        f.setVisible(true);
    }
}
