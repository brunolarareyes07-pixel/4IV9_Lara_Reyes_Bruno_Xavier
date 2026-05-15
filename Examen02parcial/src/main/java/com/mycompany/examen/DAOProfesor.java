/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen;

/**
 *
 * @author r
 */
import javax.swing.JOptionPane;

public class DAOProfesor {

    Profesor obj[] = new Profesor[10];
    int x = 0;

    public void menu() {
        int op = 0;

        do {
            try {
                op = Integer.parseInt(JOptionPane.showInputDialog(
                        "Menu profesores\n"
                        + "1.- Registrar profesor\n"
                        + "2.- Mostrar profesores\n"
                        + "3.- Editar profesor\n"
                        + "4.- Eliminar profesor\n"
                        + "5.- Buscar profesor\n"
                        + "6.- Salir"
                ));

                switch (op) {
                    case 1:
                        registrarProfesor();
                        break;

                    case 2:
                        mostrarProfesor();
                        break;

                    case 3:
                        editarProfesor();
                        break;

                    case 4:
                        eliminarProfesor();
                        break;

                    case 5:
                        buscarProfesor();
                        break;

                    case 6:
                        JOptionPane.showMessageDialog(null, "Programa finalizado");
                        break;

                    default:
                        JOptionPane.showMessageDialog(null, "Opción no válida");
                        break;
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: ingresa una opción válida");
            }

        } while (op != 6);
    }

    public void registrarProfesor() {

        String empleado = pedirEmpleado();
        String nombre = pedirTexto("Nombre del profesor:");
        int edad = pedirEdadProfesor();
        char sexo = pedirSexo();
        String materia = pedirTexto("Materia del profesor:");

        obj[x] = new Profesor(empleado, materia, nombre, edad, sexo);
        x++;

        JOptionPane.showMessageDialog(null, "Registrado correctamente");
    }

    public void mostrarProfesor() {

        if (x == 0) {
            JOptionPane.showMessageDialog(null, "No hay profesores registrados");
            return;
        }

        for (int i = 0; i < x; i++) {
            JOptionPane.showMessageDialog(null,
                    "Profesor #" + (i + 1) + "\n"
                    + "Número de empleado: " + obj[i].getNumEmpleado() + "\n"
                    + "Nombre: " + obj[i].getNombre() + "\n"
                    + "Edad: " + obj[i].getEdad() + "\n"
                    + "Sexo: " + obj[i].getSexo() + "\n"
                    + "Materia: " + obj[i].getMateria()
            );
        }
    }

    public void editarProfesor() {

        if (x == 0) {
            JOptionPane.showMessageDialog(null, "No hay profesores para editar");
            return;
        }

        String empleadoBuscar = pedirEmpleado();

        for (int i = 0; i < x; i++) {

            if (obj[i].getNumEmpleado().equals(empleadoBuscar)) {

                JOptionPane.showMessageDialog(null, "Profesor encontrado. Ingresa los nuevos datos.");

                String nuevoEmpleado = pedirEmpleado();
                String nuevoNombre = pedirTexto("Ingresa el nuevo nombre del profesor:");
                int nuevaEdad = pedirEdadProfesor();
                char nuevoSexo = pedirSexo();
                String nuevaMateria = pedirTexto("Ingresa la nueva materia del profesor:");

                obj[i].setNumEmpleado(nuevoEmpleado);
                obj[i].setNombre(nuevoNombre);
                obj[i].setEdad(nuevaEdad);
                obj[i].setSexo(nuevoSexo);
                obj[i].setMateria(nuevaMateria);

                JOptionPane.showMessageDialog(null, "Profesor editado correctamente");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontró un profesor con ese número de empleado");
    }

    public void eliminarProfesor() {

        if (x == 0) {
            JOptionPane.showMessageDialog(null, "No hay profesores para eliminar");
            return;
        }

        String empleadoBuscar = pedirEmpleado();

        for (int i = 0; i < x; i++) {

            if (obj[i].getNumEmpleado().equals(empleadoBuscar)) {

                for (int j = i; j < x - 1; j++) {
                    obj[j] = obj[j + 1];
                }

                obj[x - 1] = null;
                x--;

                JOptionPane.showMessageDialog(null, "Profesor eliminado correctamente");
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontró al profesor");
    }

    public void buscarProfesor() {

        if (x == 0) {
            JOptionPane.showMessageDialog(null, "No hay profesores registrados");
            return;
        }

        String empleadoBuscar = pedirEmpleado();

        for (int i = 0; i < x; i++) {

            if (obj[i].getNumEmpleado().equals(empleadoBuscar)) {
                JOptionPane.showMessageDialog(null,
                        "Profesor\n"
                        + "Número de empleado: " + obj[i].getNumEmpleado() + "\n"
                        + "Nombre: " + obj[i].getNombre() + "\n"
                        + "Edad: " + obj[i].getEdad() + "\n"
                        + "Sexo: " + obj[i].getSexo() + "\n"
                        + "Materia: " + obj[i].getMateria()
                );
                return;
            }
        }

        JOptionPane.showMessageDialog(null, "No se encontró un profesor con ese número de empleado");
    }

    public String pedirEmpleado() {
        String dato;

        do {
            dato = JOptionPane.showInputDialog("Ingresa el número de empleado, exactamente 10 números:");

            if (dato == null || !dato.matches("[0-9]{10}")) {
                JOptionPane.showMessageDialog(null,
                        "Error: el número de empleado esta mal.\n"
                        + "No debe llevar letras ni espacios.");
            }

        } while (dato == null || !dato.matches("[0-9]{10}"));

        return dato;
    }

    public String pedirTexto(String mensaje) {
        String dato;

        do {
            dato = JOptionPane.showInputDialog(mensaje);

            if (dato == null || !dato.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
                JOptionPane.showMessageDialog(null,
                        "Error: solo se permiten letras.\n"
                        + "No escribas números ni caracteres especiales.");
            }

        } while (dato == null || !dato.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+"));

        return dato;
    }

    public int pedirEdadProfesor() {
        int edad = 0;
        boolean valido = false;

        do {
            try {
                edad = Integer.parseInt(JOptionPane.showInputDialog("Ingresa la edad del profesor:"));

                if (edad >= 25 && edad <= 80) {
                    valido = true;
                } else {
                    JOptionPane.showMessageDialog(null,
                            "Error: la edad del profesor debe estar entre 25 y 80 años.");
                }

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,
                        "Error: ingresa solo números.");
            }

        } while (!valido);

        return edad;
    }

    public char pedirSexo() {
        String dato;

        do {
            dato = JOptionPane.showInputDialog(
                    "Ingresa el sexo del profesor:\n"
                    + "M = Masculino\n"
                    + "F = Femenino"
            );

            if (dato == null || !(dato.equalsIgnoreCase("m") || dato.equalsIgnoreCase("f"))) {
                JOptionPane.showMessageDialog(null,
                        "Error: solo puedes escribir M o F.");
            }

        } while (dato == null || !(dato.equalsIgnoreCase("m") || dato.equalsIgnoreCase("f")));

        return dato.toUpperCase().charAt(0);
    }
}