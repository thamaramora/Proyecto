/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyectoprogramacion;

import javax.swing.JOptionPane;

/**
 *
 * @author thama
 */
public class ProyectoProgramacion {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        formulario();
       
    }
    
    
    public static void formulario() {
        boolean i = false;
        while (i == false) {
            int opcion = JOptionPane.showOptionDialog(null, "Seleccione una opción:", "Registro e inicio de sesión",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    new Object[]{"Registrar", "Iniciar sesión"},
                    null);
            if (opcion == JOptionPane.YES_OPTION) {
                Usuario nuevoUsuario = new Usuario();
                nuevoUsuario.registrarUsuario();
            } else if (opcion == JOptionPane.NO_OPTION) {
                InicioSesion login = new InicioSesion();

                if (login.validarUsuario()) {
                    JOptionPane.showMessageDialog(null, "Ha ingresado correctamente");
                    i = true;
                } else {
                    i = false;
                }
            }
        }

    }
    
}
