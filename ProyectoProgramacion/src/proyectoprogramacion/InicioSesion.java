/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogramacion;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author thama
 */
public class InicioSesion {
    private  String usuario;
    private  String contrasenia;

    public InicioSesion() {
        usuario = "";
        contrasenia = "";

    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
    
    public boolean validarUsuario() {
        try {
            JTextField usuarioPane = new JTextField();
            JPasswordField contraseniaPane = new JPasswordField();

            Object[] message = {
                "Usuario:", usuarioPane,
                "Contraseña:", contraseniaPane
            };

            int option = JOptionPane.showConfirmDialog(null, message, "Ingrese los datos", JOptionPane.OK_CANCEL_OPTION);

            if (option == JOptionPane.OK_OPTION) {
                setUsuario(usuarioPane.getText().trim());
                setContrasenia(new String(contraseniaPane.getPassword()).trim());
                BufferedReader reader;
                reader = new BufferedReader(new FileReader("usuarios.txt"));
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] datos = line.split(",");
                    if (datos.length >= 5) {
                        String usuarioGuardado = datos[3];
                        String contraseniaGuardada = datos[5];
                        if (getUsuario().equals(usuarioGuardado) && getContrasenia().equals(contraseniaGuardada)) {
                            reader.close();
                            return true;
                        }
                    }
                }
                reader.close();
            }

        } catch (IOException e) {
            System.out.println("Error al leer el archivo de usuarios: " + e.getMessage());
        }
        return false;
    }

  
    
}
