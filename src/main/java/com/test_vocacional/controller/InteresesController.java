package com.test_vocacional.controller;

import com.test_vocacional.constant.InteresesConstants;
import com.test_vocacional.model.DatosVocacionales;
import com.test_vocacional.model.Estudiante;
import com.test_vocacional.util.FormatQuestion;
import com.test_vocacional.view.AptitudesView;
import com.test_vocacional.view.InteresesView;

import java.util.ArrayList;
import java.util.List;

public class InteresesController {

    // =========================================================
    // RESULTADOS DE INTERESES
    // =========================================================
    public static int interesServicioSocial;
    public static int interesEjecutivoPersuasiva;
    public static int interesVerbal;
    public static int interesArtisticoPlastica;
    public static int interesMusical;
    public static int interesOrganizacion;
    public static int interesCientifica;
    public static int interesCalculo;
    public static int interesMecanicoConstructiva;
    public static int interesTrabajoAlAireLibre;

    // =========================================================
    // DATOS DEL CUESTIONARIO
    // =========================================================
    private int preguntaActual = 0;

    private final List<Integer> respuestas = new ArrayList<>();

    private final Estudiante estudiante;

    private final InteresesView interesesView;

    private final DatosVocacionales datosVocacionales = new DatosVocacionales();

    // =========================================================
    // CONSTRUCTOR
    // =========================================================
    public InteresesController(InteresesView interesesView, Estudiante estudiante) {
        this.interesesView = interesesView;
        this.estudiante = estudiante;
    }

    // =========================================================
    // INICIAR CUESTIONARIO
    // =========================================================
    public void iniciarCuestionario() {
        mostrarPregunta();
    }

    // =========================================================
    // MOSTRAR PREGUNTA
    // =========================================================
    private void mostrarPregunta() {

        if (preguntaActual >= InteresesConstants.PREGUNTAS.length) {
            finalizarCuestionario();
            return;
        }

        String pregunta =
                InteresesConstants.PREGUNTAS[preguntaActual];

        interesesView.mostrarPregunta(
                formatearPregunta(pregunta)
        );
    }

    // =========================================================
    // OBTENER Y GUARDAR RESPUESTA
    // =========================================================
    private void guardarRespuesta() {

        int respuesta =
                interesesView.obtenerRespuestaSeleccionada();

        if (respuesta < 0) {
            return;
        }

        respuestas.add(respuesta);

        actualizarInteres(
                preguntaActual % 10,
                respuesta
        );
    }

    // =========================================================
    // AVANZAR PREGUNTA
    // =========================================================
    public void avanzarPregunta() {

        guardarRespuesta();

        preguntaActual++;

        mostrarPregunta();
    }

    // =========================================================
    // FORMATEAR PREGUNTA
    // =========================================================
    private String formatearPregunta(String pregunta) {

        if (pregunta.length() <= 60) {
            return pregunta;
        }

        StringBuilder textoFormateado =
                new StringBuilder("<html>");

        String[] lineas =
                FormatQuestion.dividirTexto(
                        pregunta,
                        60
                );

        for (String linea : lineas) {

            textoFormateado
                    .append(linea)
                    .append("<br>");
        }

        textoFormateado.append("</html>");

        return textoFormateado.toString();
    }

    // =========================================================
    // ACTUALIZAR INTERÉS
    // =========================================================
    private void actualizarInteres(int posicion, int respuesta) {

        switch (posicion) {

            case 0:
                interesServicioSocial += respuesta;
                break;

            case 1:
                interesEjecutivoPersuasiva += respuesta;
                break;

            case 2:
                interesVerbal += respuesta;
                break;

            case 3:
                interesArtisticoPlastica += respuesta;
                break;

            case 4:
                interesMusical += respuesta;
                break;

            case 5:
                interesOrganizacion += respuesta;
                break;

            case 6:
                interesCientifica += respuesta;
                break;

            case 7:
                interesCalculo += respuesta;
                break;

            case 8:
                interesMecanicoConstructiva += respuesta;
                break;

            case 9:
                interesTrabajoAlAireLibre += respuesta;
                break;

            default:
                break;
        }
    }

    // =========================================================
    // FINALIZAR CUESTIONARIO
    // =========================================================
    private void finalizarCuestionario() {

        for (int i = 0; i < respuestas.size(); i++) {

            System.out.println(
                    "Pregunta "
                            + (i + 1)
                            + ": "
                            + respuestas.get(i)
            );
        }

        /*
         * Se conservan las mismas asignaciones
         * que tenías originalmente.
         */

        datosVocacionales.interesServicioSocial = interesServicioSocial;
        datosVocacionales.interesEjecutivoPersuasiva = interesEjecutivoPersuasiva;
        datosVocacionales.interesVerbal = interesVerbal;
        datosVocacionales.interesArtisticoPlastica = interesArtisticoPlastica;
        datosVocacionales.interesMusical = interesMusical;
        datosVocacionales.interesOrganizacion = interesOrganizacion;
        datosVocacionales.interesCientifica = interesCientifica;
        datosVocacionales.interesCalculo = interesCalculo;
        datosVocacionales.interesMecanicoConstructiva = interesMecanicoConstructiva;
        datosVocacionales.interesTrabajoAlAireLibre = interesTrabajoAlAireLibre;

        AptitudesView aptitudesView = new AptitudesView(estudiante);

        aptitudesView.setVisible(true);

        interesesView.dispose();
    }
}