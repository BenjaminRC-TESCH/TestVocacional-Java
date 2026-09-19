package com.test_vocacional.controller;

import com.test_vocacional.constant.InteresesConstants;
import com.test_vocacional.model.DatosVocacionales;
import com.test_vocacional.model.Estudiante;
import com.test_vocacional.util.FormatQuestion;
import com.test_vocacional.view.AptitudesView;
import com.test_vocacional.view.InteresesView;

import java.util.ArrayList;
import java.util.List;

public class AptitudesController {

    // =========================================================
    // RESULTADOS DE APTITUDES
    // =========================================================
    public static int aptitudesServicioSocial;
    public static int aptitudesEjecutivoPersuasiva;
    public static int aptitudesVerbal;
    public static int aptitudesArtisticoPlastica;
    public static int aptitudesMusical;
    public static int aptitudesOrganizacion;
    public static int aptitudesCientifica;
    public static int aptitudesCalculo;
    public static int aptitudesMecanicoConstructiva;
    public static int aptitudesTrabajoAlAireLibre;

    // =========================================================
    // DATOS DEL CUESTIONARIO
    // =========================================================
    private int preguntaActual = 0;

    private final List<Integer> respuestas = new ArrayList<>();

    private final Estudiante estudiante;

    private final AptitudesView aptitudesView;

    private final DatosVocacionales datosVocacionales = new DatosVocacionales();

    // =========================================================
    // CONSTRUCTOR
    // =========================================================
    public AptitudesController(Estudiante estudiante, AptitudesView aptitudesView) {
        this.estudiante = estudiante;
        this.aptitudesView = aptitudesView;
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

        aptitudesView.mostrarPregunta(
                formatearPregunta(pregunta)
        );
    }

    // =========================================================
    // OBTENER Y GUARDAR RESPUESTA
    // =========================================================
    private void guardarRespuesta() {

        int respuesta =
                aptitudesView.obtenerRespuestaSeleccionada();

        if (respuesta < 0) {
            return;
        }

        respuestas.add(respuesta);

        actualizarAptitudes(
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
    // ACTUALIZAR APTITUDES
    // =========================================================
    private void actualizarAptitudes(int posicion, int respuesta) {

        switch (posicion) {

            case 0:
                aptitudesServicioSocial += respuesta;
                break;

            case 1:
                aptitudesEjecutivoPersuasiva += respuesta;
                break;

            case 2:
                aptitudesVerbal += respuesta;
                break;

            case 3:
                aptitudesArtisticoPlastica += respuesta;
                break;

            case 4:
                aptitudesMusical += respuesta;
                break;

            case 5:
                aptitudesOrganizacion += respuesta;
                break;

            case 6:
                aptitudesCientifica += respuesta;
                break;

            case 7:
                aptitudesCalculo += respuesta;
                break;

            case 8:
                aptitudesMecanicoConstructiva += respuesta;
                break;

            case 9:
                aptitudesTrabajoAlAireLibre += respuesta;
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

        datosVocacionales.interesServicioSocial = aptitudesServicioSocial;
        datosVocacionales.interesEjecutivoPersuasiva = aptitudesEjecutivoPersuasiva;
        datosVocacionales.interesVerbal = aptitudesVerbal;
        datosVocacionales.interesArtisticoPlastica = aptitudesArtisticoPlastica;
        datosVocacionales.interesMusical = aptitudesMusical;
        datosVocacionales.interesOrganizacion = aptitudesOrganizacion;
        datosVocacionales.interesCientifica = aptitudesCientifica;
        datosVocacionales.interesCalculo = aptitudesCalculo;
        datosVocacionales.interesMecanicoConstructiva = aptitudesMecanicoConstructiva;
        datosVocacionales.interesTrabajoAlAireLibre = aptitudesTrabajoAlAireLibre;

        AptitudesView aptitudesView = new AptitudesView(estudiante);

        aptitudesView.setVisible(true);

        aptitudesView.dispose();
    }


}
