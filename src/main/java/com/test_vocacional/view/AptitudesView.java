package com.test_vocacional.view;

import com.test_vocacional.config.WindowConfig;
import com.test_vocacional.config.RadioButtonCustom;
import com.test_vocacional.constant.AptitudesConstants;
import com.test_vocacional.constant.Constants;
import com.test_vocacional.constant.colors.ColorConstants;
import com.test_vocacional.constant.font.FontConstants;
import com.test_vocacional.model.DatosVocacionales;
import com.test_vocacional.model.Estudiante;
import com.test_vocacional.util.FormatQuestion;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Aptitudes extends JFrame {

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

    private int preguntaActual;

    private final List<Integer> respuestas = new ArrayList<>();

    // =========================================================
    // COMPONENTES
    // =========================================================

    private JPanel panelPrincipal;
    private JLabel etiquetaTitulo;
    private JLabel etiquetaPregunta;
    private RadioButtonCustom opcion0;
    private RadioButtonCustom opcion1;
    private RadioButtonCustom opcion2;
    private RadioButtonCustom opcion3;
    private RadioButtonCustom opcion4;
    private JButton botonSiguiente;
    private ButtonGroup grupoOpciones;

    private Estudiante estudiante;

    public Aptitudes(Estudiante estudiante) {

        this.estudiante = estudiante;

        initComponents();
        WindowConfig.configurar(
                this,
                600,
                550
        );

        mostrarPregunta();
    }

    private void initComponents() {

        grupoOpciones = new ButtonGroup();

        panelPrincipal = new JPanel();

        etiquetaTitulo = new JLabel();
        etiquetaPregunta = new JLabel();

        opcion0 = new RadioButtonCustom();
        opcion1 = new RadioButtonCustom();
        opcion2 = new RadioButtonCustom();
        opcion3 = new RadioButtonCustom();
        opcion4 = new RadioButtonCustom();

        botonSiguiente = new JButton();

        configurarComponentes();
        configurarEventos();
        configurarLayout();
    }

    private void configurarComponentes() {

        panelPrincipal.setBackground(ColorConstants.BLANCO);

        etiquetaTitulo.setText(Constants.TITULO_APTITUDES);
        etiquetaTitulo.setFont(new Font(FontConstants.ROBOTO_BLACK, Font.PLAIN, 24));

        etiquetaPregunta.setFont(new Font(FontConstants.ROBOTO_MEDIUM, Font.PLAIN, 18));

        Font fuenteOpciones = new Font(FontConstants.ROBOTO_MEDIUM, Font.PLAIN, 14);

        opcion0.setFont(fuenteOpciones);
        opcion1.setFont(fuenteOpciones);
        opcion2.setFont(fuenteOpciones);
        opcion3.setFont(fuenteOpciones);
        opcion4.setFont(fuenteOpciones);

        opcion0.setText(Constants.OPCION0);
        opcion1.setText(Constants.OPCION1);
        opcion2.setText(Constants.OPCION2);
        opcion3.setText(Constants.OPCION3);
        opcion4.setText(Constants.OPCION4);

        botonSiguiente.setBackground(ColorConstants.ROJO_VINO);
        botonSiguiente.setForeground(ColorConstants.BLANCO);
        botonSiguiente.setText(Constants.BOTON_ACEPTAR_APTITUDES);
        botonSiguiente.setBorder(null);
        botonSiguiente.setEnabled(false);

        grupoOpciones.add(opcion0);
        grupoOpciones.add(opcion1);
        grupoOpciones.add(opcion2);
        grupoOpciones.add(opcion3);
        grupoOpciones.add(opcion4);
    }

    private void configurarEventos() {

        opcion0.addActionListener(e -> habilitarBoton());
        opcion1.addActionListener(e -> habilitarBoton());
        opcion2.addActionListener(e -> habilitarBoton());
        opcion3.addActionListener(e -> habilitarBoton());
        opcion4.addActionListener(e -> habilitarBoton());

        botonSiguiente.addActionListener(
                e -> avanzarPregunta()
        );
    }

    private void configurarLayout() {

        GroupLayout layout = new GroupLayout(panelPrincipal);

        panelPrincipal.setLayout(layout);

        // =====================================================
        // TAMAÑOS HORIZONTALES
        // =====================================================

        layout.setHorizontalGroup(
                layout.createParallelGroup(GroupLayout.Alignment.CENTER)

                        // Título
                        .addComponent(etiquetaTitulo)

                        // Pregunta y opciones
                        .addGroup(
                                layout.createParallelGroup(
                                                GroupLayout.Alignment.LEADING
                                        )
                                        .addComponent(
                                                etiquetaPregunta,
                                                GroupLayout.PREFERRED_SIZE,
                                                500,
                                                GroupLayout.PREFERRED_SIZE
                                        )
                                        .addComponent(opcion4)
                                        .addComponent(opcion3)
                                        .addComponent(opcion2)
                                        .addComponent(opcion1)
                                        .addComponent(opcion0)
                        )

                        // Botón
                        .addComponent(
                                botonSiguiente,
                                GroupLayout.PREFERRED_SIZE,
                                150,
                                GroupLayout.PREFERRED_SIZE
                        )
        );

        // =====================================================
        // TAMAÑOS VERTICALES
        // =====================================================

        layout.setVerticalGroup(
                layout.createSequentialGroup()

                        // Margen superior
                        .addGap(50)

                        // Título
                        .addComponent(etiquetaTitulo)

                        .addGap(44)

                        // Pregunta
                        .addComponent(
                                etiquetaPregunta,
                                GroupLayout.PREFERRED_SIZE,
                                50,
                                GroupLayout.PREFERRED_SIZE
                        )

                        .addGap(41)

                        // Opción 4
                        .addComponent(opcion4)
                        .addGap(18)

                        // Opción 3
                        .addComponent(opcion3)
                        .addGap(18)

                        // Opción 2
                        .addComponent(opcion2)
                        .addGap(18)

                        // Opción 1
                        .addComponent(opcion1)
                        .addGap(18)

                        // Opción 0
                        .addComponent(opcion0)

                        .addGap(39)

                        // Botón
                        .addComponent(
                                botonSiguiente,
                                GroupLayout.PREFERRED_SIZE,
                                30,
                                GroupLayout.PREFERRED_SIZE
                        )

                        // Margen inferior
                        .addGap(40)
        );

        GroupLayout layoutVentana = new GroupLayout(
                getContentPane()
        );

        getContentPane().setLayout(layoutVentana);

        layoutVentana.setHorizontalGroup(
                layoutVentana.createParallelGroup(
                                GroupLayout.Alignment.CENTER
                        )
                        .addComponent(
                                panelPrincipal,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE
                        )
        );

        layoutVentana.setVerticalGroup(
                layoutVentana.createParallelGroup(
                                GroupLayout.Alignment.CENTER
                        )
                        .addComponent(
                                panelPrincipal,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE
                        )
        );
    }

    private void habilitarBoton() {

        botonSiguiente.setEnabled(true);
    }





    private void siguienteVista() {

        for (int i = 0; i < respuestas.size(); i++) {

            System.out.println(
                    "Pregunta "
                            + (i + 1)
                            + ": "
                            + respuestas.get(i)
            );
        }

        DatosVocacionales datosVocacionales = new DatosVocacionales();
        datosVocacionales.aptitudesServicioSocial = this.aptitudesServicioSocial;
        datosVocacionales.aptitudesEjecutivoPersuasiva = this.aptitudesEjecutivoPersuasiva;
        datosVocacionales.aptitudesVerbal = this.aptitudesVerbal;
        datosVocacionales.aptitudesArtisticoPlastica = this.aptitudesArtisticoPlastica;
        datosVocacionales.aptitudesMusical = this.aptitudesMusical;
        datosVocacionales.aptitudesOrganizacion = this.aptitudesOrganizacion;
        datosVocacionales.aptitudesCientifica = this.aptitudesCientifica;
        datosVocacionales.aptitudesCalculo = this.aptitudesCalculo;
        datosVocacionales.aptitudesMecanicoConstructiva = this.aptitudesMecanicoConstructiva;
        datosVocacionales.aptitudesTrabajoAlAireLibre = this.aptitudesTrabajoAlAireLibre;

        Resultado resultado = new Resultado(estudiante);
        resultado.setVisible(true);
        dispose();

    }





    private void mostrarPregunta() {

        if (preguntaActual >= AptitudesConstants.PREGUNTAS.length) {
            siguienteVista();
            return;
        }

        String pregunta = AptitudesConstants.PREGUNTAS[preguntaActual];

        etiquetaPregunta.setText(
                formatearPregunta(pregunta)
        );

        limpiarOpciones();

        botonSiguiente.setEnabled(false);
    }

    private int obtenerRespuestaSeleccionada() {

        if (opcion0.isSelected()) {
            return 0;
        }

        if (opcion1.isSelected()) {
            return 1;
        }

        if (opcion2.isSelected()) {
            return 2;
        }

        if (opcion3.isSelected()) {
            return 3;
        }

        if (opcion4.isSelected()) {
            return 4;
        }

        return -1;
    }

    private void guardarRespuesta() {

        int respuesta = obtenerRespuestaSeleccionada();

        if (respuesta < 0) {
            return;
        }

        System.out.println(respuesta);
        respuestas.add(respuesta);

        actualizarInteres(
                preguntaActual % 10,
                respuesta
        );
    }

    private void avanzarPregunta() {

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

        String[] lineas = FormatQuestion.dividirTexto(
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

    private void limpiarOpciones() {

        grupoOpciones.clearSelection();
    }

}
