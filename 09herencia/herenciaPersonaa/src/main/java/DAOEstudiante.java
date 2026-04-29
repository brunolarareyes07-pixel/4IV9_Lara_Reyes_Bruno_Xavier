/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alumno
 */
import javax.swing.JOptionPane;

public class DAOEstudiante {

    // Arreglo para guardar 10 estudiantes
    Estudiante obj[] = new Estudiante[10];
    int contador = 0;
    private int x;

    // Método del menú
    void menu() {
        String var = "si";

        while (var.equalsIgnoreCase("si")) {

            int op = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingresa la opción deseada:\n"
                    + "1. Dar de alta a nuevo estudiante\n"
                    + "2. Mostrar los datos de todos los estudiantes"
            ));

            switch (op) {
                case 1:
                    pedirEstudiante();
                    break;

                case 2:
                    mostrarEstudiante();
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    break;
            }

            var = JOptionPane.showInputDialog("¿Deseas regresar al menú? si/no");
        }
    }

    private void pedirEstudiante() {
    
            int boleta = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la boleta:"));
            String chillon = JOptionPane.showInputDialog("Ingresa chillon:");
            String nombre = JOptionPane.showInputDialog("Ingresa el nombre:");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la edad:"));
            char genero = JOptionPane.showInputDialog("Ingresa el género (M/F):").charAt(0);

            obj[x] = new Estudiante(boleta, chillon, nombre, edad, genero);
            x++;
            
            
    }

    private void mostrarEstudiante() {
        //necesito recorrer el arreglo
        for(int i =0; i < x; i++){
            JOptionPane.showInputDialog(null, "La boleta del estudiante es:" + obj[i].getBoleta() + "\n");
            
        }
    }
}
