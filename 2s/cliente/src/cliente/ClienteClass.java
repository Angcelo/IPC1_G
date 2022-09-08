/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cliente;

/**
 *
 * @author angel
 */
public class ClienteClass {
    private String cui;
    private String nombre;
    private String apellido;
    private String[] cuentas;

    public void setCui(String cui) {
        this.cui = cui;
    }

    public String getCui() {
        return cui;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCuentas(String[] cuentas) {
        this.cuentas = cuentas;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public String[] getCuentas() {
        return cuentas;
    }

    public String getApellido() {
        return apellido;
    }

    public ClienteClass(String cui, String nombre, String apellido) {
        this.cui = cui;
        this.nombre = nombre;
        this.apellido = apellido;
        this.cuentas = new String[5];
    }
    
    public ClienteClass() {
        this.cuentas = new String[5];
    }

}
