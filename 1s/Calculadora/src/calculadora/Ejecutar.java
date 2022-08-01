/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

import static calculadora.Calculadora.l;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author angel
 */
public class Ejecutar implements ActionListener {

    String n1, op, n2;
    boolean esUnario = false;

    Ejecutar() {
        n1 = op = n2 = "";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String s = e.getActionCommand();

        // if the value is a number
        if ((s.charAt(0) >= '0' && s.charAt(0) <= '9') || s.charAt(0) == '.') {
            // if operand is present then add to second no
            if (!op.equals("") || esUnario) {
                n2 = n2 + s;
            } else {
                n1 = n1 + s;
            }

            // set the value of text
            l.setText(n1 + op + n2);
        } else if (s.charAt(0) == 'C') {
            // clear the one letter
            n1 = op = n2 = "";
            esUnario = false;
            // set the value of text
            l.setText(n1 + op + n2);
        } else if (s.charAt(0) == '=') {
            try {
                float te;
                if (n2.equals("")) {
                    throw new Exception("Error de sintaxis");
                } else if (n1.equals("")) {
                    te = this.SwitchOperar(op, Float.parseFloat(n2));
                } else {
                    te = this.SwitchOperar(Float.parseFloat(n1), op, Float.parseFloat(n2));
                }
                l.setText(n1 + op + n2 + "=" + te);
                n1 = Float.toString(te);
                op = n2 = "";
                // set the value of text
                // convert it to string
            } catch (Exception error) {
                l.setText(error.getMessage());
                n1 = op = n2 = "";
            }
        } else {
            try {
                if (op.equals("") && n2.equals("")) {
                    if (n1.equals("")) {
                        esUnario = true;
                    }
                    op = s;
                } else if (!op.equals("") && n2.equals("")) {
                    op = s;
                } else {
                    if (esUnario && !n2.equals("")) {
                        float te = this.SwitchOperar(op, Float.parseFloat(n2));
                        n1 = Float.toString(te);
                        esUnario = false;
                        op = s;
                        n2 = "";
                    } else {
                        float te = this.SwitchOperar(Float.parseFloat(n1), op, Float.parseFloat(n2));

                        // convert it to string
                        n1 = Double.toString(te);

                        // place the operator
                        op = s;

                        // make the operand blank
                        n2 = "";
                    }
                }
                // set the value of text
                l.setText(n1 + op + n2);
            } catch (Exception error) {
                l.setText(error.getMessage());
            }
            // if there was no operand}
        }

    }

    private float SwitchOperar(float s0, String s1, float s2) throws Exception {// store the value in 1st
        Operacion operacion;
        if (s1.equals("+")) {
            operacion = new Suma(s0, s2);
            return operacion.Operar();
        } else if (s1.equals("-")) {
            operacion = new Resta(s0, s2);
            return operacion.Operar();
        } else if (s1.equals("*")) {
            operacion = new Multiplicacion(s0, s2);
            return operacion.Operar();
        } else {
            operacion = new Division(s0, s2);
            return operacion.Operar();
        }
    }

    private float SwitchOperar(String s1, float s2) throws Exception {
        Operacion operacion;
        if (s1.equals("+")) {
            return s2;
        } else if (s1.equals("-")) {
            operacion = new Negativo(s2);
            return operacion.Operar();
        } else {
            throw new Exception("Error sintáctico");
        }
    }
}
