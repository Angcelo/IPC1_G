/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

/**
 *
 * @author angel
 */
public class Multiplicacion extends Operacion {

    public Multiplicacion(float numero1, float numero2) {
        super(numero1, numero2);
    }

    @Override
    public float Operar() {
        return this.getNumero1() * this.getNumero2();
    }
}
