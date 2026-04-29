/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Alumno
 */
public class Estudiante extends Persona {
    
    private int boleta;
    private String chillon;

    public Estudiante(int boleta, String chillon, String nombre, int edad, char genero) {
        super(nombre, edad, genero);
        this.boleta = boleta;
        this.chillon = chillon;
    }

    public int getBoleta() {
        return boleta;
    }

    public void setBoleta(int boleta) {
        this.boleta = boleta;
    }

    public String getChillon() {
        return chillon;
    }

    public void setChillon(String chillon) {
        this.chillon = chillon;
    }
    
}
