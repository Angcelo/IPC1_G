/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package login;

/**
 *
 * @author angel
 */
public class Usuarios {

    public String nombre;
    public String contrasena;
    public int rol;

    public Usuarios() {
    }

    public Usuarios(String nombre, String contrasena, int rol) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public int Verificar(String nombre, String contrasena) {
        if (this.nombre.equals(nombre)) {
            if (this.contrasena.equals(contrasena)) {
                return this.rol;
            }
            return 0;
        }
        return 0;
    }
}
