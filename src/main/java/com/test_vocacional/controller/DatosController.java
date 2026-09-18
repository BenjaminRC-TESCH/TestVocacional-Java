package com.test_vocacional.controller;

import com.test_vocacional.model.Estudiante;
import com.test_vocacional.view.DatosView;
import com.test_vocacional.view.InstruccionesView;

public class DatosController {

    private final DatosView datosView;

    public DatosController(DatosView datosView) {
        this.datosView = datosView;
    }

    public void procesarDatos() {

        if (!validarCampos()) {
            return;
        }

        Estudiante estudiante = crearEstudiante();

        abrirInstrucciones(estudiante);
    }

    private Estudiante crearEstudiante() {

        return new Estudiante(
                datosView.getCampoNombre().trim(),
                Integer.parseInt(datosView.getCampoEdad().trim()),
                Integer.parseInt(datosView.getCampoGrado().trim()),
                datosView.getCampoGrupo().trim(),
                datosView.getCampoEspecialidad().trim()
        );
    }

    private void abrirInstrucciones(Estudiante estudiante) {
        InstruccionesView instruccionesView = new InstruccionesView(estudiante);
        instruccionesView.setVisible(true);
        datosView.dispose();
    }

    private boolean validarCampos() {

        if (estaVacio(datosView.getCampoNombre())
                || estaVacio(datosView.getCampoEdad())
                || estaVacio(datosView.getCampoGrado())
                || estaVacio(datosView.getCampoGrupo())
                || estaVacio(datosView.getCampoEspecialidad())) {

            datosView.mostrarMensaje(
                    "Completa todos los campos",
                    "Datos incompletos"
            );

            return false;
        }

        if (!datosView.getCampoNombre()
                .trim()
                .matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {

            datosView.mostrarMensaje(
                    "El nombre solamente puede contener letras",
                    "Nombre inválido"
            );

            return false;
        }

        return true;
    }

    private boolean estaVacio(String texto) {
        return texto == null || texto.trim().isEmpty();
    }

    public static boolean validarNombre(char caracter) {
        return Character.isLetter(caracter) || caracter == ' ';
    }

    public static boolean validarEdad(char caracter, String campoEdad) {
        return Character.isDigit(caracter) && campoEdad.length() < 2;
    }

    public static boolean validarGrado(char caracter, String campoGrado){
        return Character.isDigit(caracter) && campoGrado.length() < 1;
    }

    public static boolean validarGrupo(char caracter, String campoGrupo){
        return Character.isLetter(caracter) && campoGrupo.length() < 1;
    }

    public static boolean validarEspecialidad(char caracter) {
        return Character.isLetter(caracter) || caracter == ' ';
    }
}
