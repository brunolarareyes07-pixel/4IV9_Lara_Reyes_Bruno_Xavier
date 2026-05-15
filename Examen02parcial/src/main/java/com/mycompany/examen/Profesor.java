/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.examen;

/**
 *
 * @author r
 */
public class Profesor extends Caracteristicas {

    private String numEmpleado;
    private String materia;

    public Profesor() {
    }

    public Profesor(String numEmpleado, String materia, String nombre, int edad, char sexo) {
        super(nombre, edad, sexo);
        this.numEmpleado = numEmpleado;
        this.materia = materia;
    }

    public String getNumEmpleado() {
        return numEmpleado;
    }

    public void setNumEmpleado(String numEmpleado) {
        this.numEmpleado = numEmpleado;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }
}
