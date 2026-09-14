package com.test_vocacional.model;

public class Estudiante {

    private String nombre;
    private int edad;
    private int grado;
    private String grupo;
    private String especialidad;

    public Estudiante() {
    }

    public Estudiante(
            String nombre,
            int edad,
            int grado,
            String grupo,
            String especialidad
    ) {
        this.nombre = nombre;
        this.edad = edad;
        this.grado = grado;
        this.grupo = grupo;
        this.especialidad = especialidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    @Override
    public String toString() {
        return "Estudiante{"
                + "nombre='" + nombre + '\''
                + ", edad=" + edad
                + ", grado=" + grado
                + ", grupo='" + grupo + '\''
                + ", especialidad='" + especialidad + '\''
                + '}';
    }
}
