package proyectoprogramacion;

import javax.swing.JOptionPane;

public class Caja {

    // Atributos
    private String nombre;
    private int cedula;
    private String correo;
    private int edad;
    private int tramite;
    


    //Metodos
    public void ingresarInformacion() {
        nombre = JOptionPane.showInputDialog("Ingrese su nombre:");
        edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la edad del usuario: "));
        cedula = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el numero de cedula del usuario:"));

        correo = JOptionPane.showInputDialog("Ingrese su correo electrónico:");
        tramite = Integer.parseInt(JOptionPane.showInputDialog("""
                                                               Ingrese el tramite que desea realizar: 
                                                               1. Depositos
                                                               2. Retiros
                                                               3. Cambio de divisas"""));   
    }
    // Metodo
    public void mostrarInformacion() {
        String mensaje = """
                         Informacion del usuario:
                         Nombre: """ + nombre + "\n" +
                        "Cédula: " + cedula + "\n" +
                        "Correo: " + correo + "\n" +
                        "Edad: " + edad +
                        "Tramite: " + tramite
                        ;

        JOptionPane.showMessageDialog(null, mensaje);
    }
    
    }


