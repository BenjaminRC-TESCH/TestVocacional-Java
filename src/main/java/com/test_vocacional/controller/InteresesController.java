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

    public void iniciarCuestionario() {

        mostrarPregunta();
    }

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

    public void avanzarPregunta() {

        guardarRespuesta();

        preguntaActual++;

        mostrarPregunta();
    }

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

    private void actualizarInteres(int posicion, int respuesta) {

        switch (posicion) {

            case 0:
                datosVocacionales.interesServicioSocial
                        += respuesta;
                break;

            case 1:
                datosVocacionales.interesEjecutivoPersuasiva
                        += respuesta;
                break;

            case 2:
                datosVocacionales.interesVerbal
                        += respuesta;
                break;

            case 3:
                datosVocacionales.interesArtisticoPlastica
                        += respuesta;
                break;

            case 4:
                datosVocacionales.interesMusical
                        += respuesta;
                break;

            case 5:
                datosVocacionales.interesOrganizacion
                        += respuesta;
                break;

            case 6:
                datosVocacionales.interesCientifica
                        += respuesta;
                break;

            case 7:
                datosVocacionales.interesCalculo
                        += respuesta;
                break;

            case 8:
                datosVocacionales.interesMecanicoConstructiva
                        += respuesta;
                break;

            case 9:
                datosVocacionales.interesTrabajoAlAireLibre
                        += respuesta;
                break;

            default:
                break;
        }
    }

    private void finalizarCuestionario() {

        for (int i = 0; i < respuestas.size(); i++) {

            System.out.println(
                    "Pregunta "
                            + (i + 1)
                            + ": "
                            + respuestas.get(i)
            );
        }



        datosVocacionales.interesServicioSocial = datosVocacionales.interesServicioSocial;

        datosVocacionales.interesEjecutivoPersuasiva = datosVocacionales.interesEjecutivoPersuasiva;

        datosVocacionales.interesVerbal = datosVocacionales.interesVerbal;

        datosVocacionales.interesArtisticoPlastica = datosVocacionales.interesArtisticoPlastica;

        datosVocacionales.interesMusical = datosVocacionales.interesMusical;

        datosVocacionales.interesOrganizacion = datosVocacionales.interesOrganizacion;

        datosVocacionales.interesCientifica = datosVocacionales.interesCientifica;

        datosVocacionales.interesCalculo = datosVocacionales.interesCalculo;

        datosVocacionales.interesMecanicoConstructiva = datosVocacionales.interesMecanicoConstructiva;

        datosVocacionales.interesTrabajoAlAireLibre = datosVocacionales.interesTrabajoAlAireLibre;

        AptitudesView aptitudesView = new AptitudesView(estudiante);

        aptitudesView.setVisible(true);

        interesesView.dispose();
    }
}
