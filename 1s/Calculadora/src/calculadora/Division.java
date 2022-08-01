/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

/**
 *
 * @author angel
 */
public class Division extends Operacion {

    public Division(float numero1, float numero2) {
        super(numero1, numero2);
    }

    @Override
    public float Operar() {
        if (this.getNumero2() != 0) {
            return this.getNumero1() / this.getNumero2();
        }
        return 0;
    }
}
