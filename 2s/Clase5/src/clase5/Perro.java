/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package clase5;

/**
 *
 * @author angel
 */
public class Perro extends Animal{

    private String colorPelaje;
    
    public Perro(){
        super();
    }
    
    public Perro(String familia, String grupo) {
        super(familia,grupo);
    }
    
    public Perro(String familia, String grupo, String colorPelaje) {
        super(familia,grupo);
        this.colorPelaje = colorPelaje;
    }
    
    public void setColorPelaje(String colorPelaje) {
        this.colorPelaje = colorPelaje;
    }
    
    public String getColorPelaje(String colorPelaje) {
        return this.colorPelaje;
    }
    
    @Override
    public void hacerRuido() {
        System.out.println("Woof!!");
    }

    @Override
    public void queSoy() {
        System.out.println("Soy de la familia: "+this.familia);
        System.out.println("Soy del grupo: "+this.grupo);
    }
    
    public void CualEsMiColor() {
        System.out.println("Mi color es: "+this.colorPelaje);
    }
}
