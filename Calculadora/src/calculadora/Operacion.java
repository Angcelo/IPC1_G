/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package calculadora;

/**
 *
 * @author angel
 */
public abstract class Operacion {

    public float numero1;
    public float numero2;

    public Operacion(float numero1, float numero2) {
        super();
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public Operacion(float numero1) {
        super();
        this.numero1 = numero1;
    }

    public float getNumero1() {
        return this.numero1;
    }

    public float getNumero2() {
        return this.numero2;
    }

    public abstract float Operar();
}
