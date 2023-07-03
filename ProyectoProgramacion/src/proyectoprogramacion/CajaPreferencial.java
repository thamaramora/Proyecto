package proyectoprogramacion;
import javax.swing.JOptionPane;

public class CajaPreferencial {
  
        JOptionPane.showMessageDialog(null, "Bienvenido al Banco XYZ");

        String nombre = JOptionPane.showInputDialog("Ingrese el nombre del usuario:");

        int cedula = Integer.parseInt(JOptionPane.showInputDialog("El numero de cedula del usuario es: "));

        int tipoTramite = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                       Ingrese el tramite a realizar: 
                                                                       1. Depositos
                                                                       2. Retiros
                                                                       3. Cambio de divisas"""));

        String mensaje = "Nombre: " + nombre + "\n"
                + "Número de cédula: " + cedula + "\n"
                + "Tipo de trámite: " + tipoTramite;
        JOptionPane.showMessageDialog(null, mensaje);
    
    
}
