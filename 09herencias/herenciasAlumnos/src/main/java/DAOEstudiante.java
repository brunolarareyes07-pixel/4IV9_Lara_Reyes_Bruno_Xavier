/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author r
 */

import javax.swing.JOptionPane;

public class DAOEstudiante {

    Estudiante obj[] = new Estudiante[10];
    int x = 0;

    void menu() {
        String var = "si";

        while (var.equalsIgnoreCase("si")) {

            int op = Integer.parseInt(JOptionPane.showInputDialog(
                    "Ingresa la opción deseada:\n"
                    + "1.- Registrar estudiante\n"
                    + "2.- Mostrar estudiantes\n"
                    + "3.- Editar estudiante\n"
                    + "4.- Eliminar estudiante\n"
                    + "5.- Buscar estudiante\n"
                    + "6.- Salir"
            ));

            switch (op) {
                case 1:
                    registrarEstudiante();
                    break;

                case 2:
                    mostrarEstudiante();
                    break;

                case 3:
                    editarEstudiante();
                    break;

                case 4:
                    eliminarEstudiante();
                    break;

                case 5:
                    buscarEstudiante();
                    break;

                case 6:
                    JOptionPane.showMessageDialog(null, "Programa finalizado");
                    return;

                default:
                    JOptionPane.showMessageDialog(null, "Opción no válida");
                    break;
            }

            var = JOptionPane.showInputDialog("¿Desea repetir el programa? si/no");
        }
    }

    public void registrarEstudiante() {

        if (x >= obj.length) {
            JOptionPane.showMessageDialog(null, "Ya no hay espacio para más estudiantes");
            return;
        }

        int numboleta = Integer.parseInt(
                JOptionPane.showInputDialog("Ingresa la boleta del estudiante:"));

        String nom = JOptionPane.showInputDialog("Ingresa el nombre del estudiante:");

        int edad = Integer.parseInt(
                JOptionPane.showInputDialog("Ingresa la edad del estudiante:"));

        char gen = JOptionPane.showInputDialog("Ingresa el género del estudiante:").charAt(0);

        String chillon = JOptionPane.showInputDialog("¿El estudiante es chillón?");

        obj[x] = new Estudiante(numboleta, chillon, nom, edad, gen);
        x++;

        JOptionPane.showMessageDialog(null, "Estudiante registrado correctamente");
    }

    public void mostrarEstudiante() {

        if (x == 0) {
            JOptionPane.showMessageDialog(null, "No hay estudiantes registrados");
            return;
        }

        for (int i = 0; i < x; i++) {
            JOptionPane.showMessageDialog(null,
                    "Estudiante #" + (i + 1) + "\n"
                    + "Boleta: " + obj[i].getNumBoleta() + "\n"
                    + "Nombre: " + obj[i].getNombre() + "\n"
                    + "Edad: " + obj[i].getEdad() + "\n"
                    + "Género: " + obj[i].getGenero() + "\n"
                    + "Chillón: " + obj[i].getChillon()
            );
        }
    }

    public void editarEstudiante() {

        if (x == 0) {
            JOptionPane.showMessageDialog(null, "No hay estudiantes para editar");
            return;
        }

        int boletaBuscar = Integer.parseInt(
                JOptionPane.showInputDialog("Ingresa la boleta del estudiante a editar:"));

        for (int i = 0; i < x; i++) {

            if (obj[i].getNumBoleta() == boletaBuscar) {

                int nuevaBoleta = Integer.parseInt(
                        JOptionPane.showInputDialog("Nueva boleta:", obj[i].getNumBoleta()));

                String nuevoNombre = JOptionPane.showInputDialog(
                        "Nuevo nombre:", obj[i].getNombre());

                int nuevaEdad = Integer.parseInt(
                        JOptionPane.showInputDialog("Nueva edad:", obj[i].getEdad()));

                char nuevoGenero = JOptionPane.showInputDialog(
                        "Nuevo género:", obj[i].getGenero()).charAt(0);

                String nuevoChillon = JOptionPane.showInputDialog(
                        "¿Es chillón?", obj[i].getChillon());

                obj[i].setNumBoleta(nuevaBoleta);
                obj[i].setNombre(nuevoNombre);
                obj[i].setEdad(nuevaEdad);
                obj[i].setGenero(nuevoGenero);
                obj[i].setChillon(nuevoChillon);

                JOptionPane.showMessageDialog(null, "Estudiante editado correctamente");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontró un estudiante con esa boleta");
    }

    public void eliminarEstudiante() {

        if (x == 0) {
            JOptionPane.showMessageDialog(null, "No hay estudiantes para eliminar");
            return;
        }

        int boletaBuscar = Integer.parseInt(
                JOptionPane.showInputDialog("Ingresa la boleta del estudiante a eliminar:"));

        for (int i = 0; i < x; i++) {

            if (obj[i].getNumBoleta() == boletaBuscar) {

                for (int j = i; j < x - 1; j++) {
                    obj[j] = obj[j + 1];
                }

                obj[x - 1] = null;
                x--;

                JOptionPane.showMessageDialog(null, "Estudiante eliminado correctamente");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontró un estudiante con esa boleta");
    }

    public void buscarEstudiante() {

        if (x == 0) {
            JOptionPane.showMessageDialog(null, "No hay estudiantes registrados");
            return;
        }

        int boletaBuscar = Integer.parseInt(
                JOptionPane.showInputDialog("Ingresa la boleta del estudiante a buscar:"));

        for (int i = 0; i < x; i++) {

            if (obj[i].getNumBoleta() == boletaBuscar) {
                JOptionPane.showMessageDialog(null,
                        """
                        Estudiante encontrado:
                        Boleta: """ + obj[i].getNumBoleta() + "\n"
                        + "Nombre: " + obj[i].getNombre() + "\n"
                        + "Edad: " + obj[i].getEdad() + "\n"
                        + "Género: " + obj[i].getGenero() + "\n"
                        + "Chillón: " + obj[i].getChillon()
                );
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontró un estudiante con esa boleta");
    }
}