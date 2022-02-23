/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

/**
 *
 * @author angel
 */
public class Negativo extends Operacion {

    public Negativo(float numero1) {
        super(numero1);
    }

    @Override
    public float Operar() {
        return -this.getNumero1();
    }
}
