/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoprogramacion;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author thama
 */
public class Usuario {

    private String identificacion;
    private String nombre;
    private int edad;
    private String usuario;
    private String correo;
    private String contrasenia;

    public Usuario() {
        this.identificacion = "";
        this.nombre = "";
        this.edad = 0;
        this.usuario = "";
        this.correo = "";
        this.contrasenia = "";
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if(correo.contains("@gmail.com")){
            this.correo = correo;
        }else{
            System.out.println("Error: correo no valido"+
                " debe contener @gmail.com");
        }
    }

    public String getContrasenia() {
        String cont = "";
        for (int i = 0; i < contrasenia.length(); i++) {
            cont += "*";
        }
        return cont;
    }

    public void setContrasenia(String contrasenia) {
        if (contrasenia.length() >= 8) {
            boolean bandera = true;
            for (int i = 0; i < (contrasenia.length() - 1); i++) {
                if (contrasenia.charAt(i) == contrasenia.charAt(i + 1)) {
                    bandera = false;
                    break;
                }
            }
            if (bandera) {
                this.contrasenia = contrasenia;
            } else {

                JOptionPane.showMessageDialog(null, "Error: contrasenna no valida caracteres repetidos", "Advertencia", 0);
            }
        }

    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void registrarUsuario() {
        JTextField identificacionPane = new JTextField();
        JTextField nombrePane = new JTextField();
        JTextField edadPane = new JTextField();
        JTextField usuarioPane = new JTextField();
        JTextField correoPane = new JTextField();
        JPasswordField contraseniaPane = new JPasswordField();

        Object[] message = {
            "Identificación:", identificacionPane,
            "Nombre:", nombrePane,
            "Edad:", edadPane,
            "Usuario:", usuarioPane,
            "Correo:", correoPane,
            "Contraseña:", contraseniaPane
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Ingrese los datos", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            setIdentificacion(identificacionPane.getText().trim());
            setNombre(nombrePane.getText().trim());
            setEdad(Integer.parseInt(edadPane.getText().trim()));
            setUsuario(usuarioPane.getText().trim());
            setCorreo(correoPane.getText().trim());
            setContrasenia(new String(contraseniaPane.getPassword()).trim());
            try {
                BufferedWriter writer;
                writer = new BufferedWriter(new FileWriter("usuarios.txt", true));
                writer.write(identificacion + "," + nombre + "," + edad + "," + usuario + "," + correo + "," + contrasenia);
                writer.newLine();
                writer.close();
                System.out.println("Usuario guardado exitosamente.");
            } catch (IOException e) {
                System.out.println("Error al guardar el usuario: " + e.getMessage());
            }
        }

    }

}
