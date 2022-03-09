/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package login;

/**
 *
 * @author angel
 */
public class Login {

    static Usuarios[] usuarios;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        usuarios = new Usuarios[10];
        usuarios[0] = new Usuarios("Angel", "12345", 1);
        usuarios[1] = new Usuarios("Marcelo", "1234", 2);

        PestanaLogin login = new PestanaLogin();
        login.setVisible(true);

    }

}
