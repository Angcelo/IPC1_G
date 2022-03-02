/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Usuarios;

/**
 *
 * @author angel
 */
public class Personas {

    public String nombre;
    public String genero;
    public String DPI;
    public String pais;
    public String ciudad;
    public String fechaNacimiento;
    public String EstadoCivil;

    public Personas() {
    }

    public Personas(String nombre,
        String genero,
        String DPI, String pais,
        String ciudad,
        String fechaNacimiento,
        String EstadoCivil) {
        this.nombre = nombre;
        this.genero = genero;
        this.DPI = DPI;
        this.pais = pais;
        this.ciudad = ciudad;
        this.fechaNacimiento = fechaNacimiento;
        this.EstadoCivil = EstadoCivil;
    }

    public String retornoPersona() {
        return "Nombre: " + this.nombre
            + ", Genero: " + this.genero
            + ", DPI: " + this.DPI
            + ", pais: " + this.pais
            + " ciudad: " + this.ciudad
            + " fechaNacimiento: " + this.fechaNacimiento
            + ", EstadoCivil: " + this.EstadoCivil;
    }
}
