/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase5;

/**
 *
 * @author angel
 */
public abstract class Animal {
    public String familia;
    public String grupo;
    
    public Animal() {}
    public Animal(String familia, String grupo) {
        this.familia = familia;
        this.grupo = grupo;
    }
    
    public abstract void hacerRuido();
    public abstract void queSoy();
}
