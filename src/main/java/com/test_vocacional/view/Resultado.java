package com.test_vocacional.view;

import com.test_vocacional.config.WindowConfig;
import com.test_vocacional.constant.Constants;
import com.test_vocacional.constant.colors.ColorConstants;
import com.test_vocacional.constant.font.FontConstants;
import com.test_vocacional.model.DatosVocacionales;
import com.test_vocacional.model.Estudiante;
import com.test_vocacional.model.ResultadosVocacionales;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;

import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Resultado extends JFrame {
    JFreeChart chart;

    public static String puntajeIntereses;
    public static String puntajeAptitudes;
    public static String areaInteres;

    public static String carreasInteres;

    public static int valorInteresesSS;
    public static int valorInteresesEP;
    public static int valorInteresesV;
    public static int valorInteresesAP;
    public static int valorInteresesMS;
    public static int valorInteresesOG;
    public static int valorInteresesCT;
    public static int valorInteresesCL;
    public static int valorInteresesMC;
    public static int valorInteresesAL;

    public static int valorAptitudesSS;
    public static int valorAptitudesEP;
    public static int valorAptitudesV;
    public static int valorAptitudesAP;
    public static int valorAptitudesMS;
    public static int valorAptitudesOG;
    public static int valorAptitudesCT;
    public static int valorAptitudesCL;
    public static int valorAptitudesMC;
    public static int valorAptitudesAL;

    private JButton botonAceptar;
    private JLabel etiquetaTitulo;
    private JPanel panelPrincipal;
    private JPanel panelResultados;

    private Estudiante estudiante;

    public Resultado(Estudiante estudiante){
        this.estudiante = estudiante;

        initComponents();

        crearGrafico();
        calcularAreasIntereses();
        calcularAreasAptitudes();

        WindowConfig.configurar(
                this,
                600,
                550
        );
    }



    private void initComponents() {
        panelPrincipal = new JPanel();
        etiquetaTitulo = new JLabel();
        panelResultados = new JPanel();
        botonAceptar = new JButton();

        configurarComponentes();
        configurarEventos();
        configurarLayout();
    }



    private void configurarComponentes() {

        panelPrincipal.setBackground(ColorConstants.BLANCO);

        etiquetaTitulo.setFont(new Font(FontConstants.ROBOTO_BLACK, Font.PLAIN, 24));
        etiquetaTitulo.setText(Constants.TITULO_RESULTADOS);

        panelResultados.setPreferredSize(new Dimension(550, 300));

        botonAceptar.setBackground(new Color(105, 20, 50));
        botonAceptar.setForeground(ColorConstants.BLANCO);
        botonAceptar.setText(Constants.BOTON_ACEPTAR_RESULTADOS);
    }

    private void configurarEventos() {
        botonAceptar.addActionListener(
                this::aceptar
        );
    }

    private void configurarLayout() {

        // =====================================================
        // DISTRIBUCIÓN DEL PANEL PRINCIPAL
        // =====================================================

        GroupLayout distribucionPanel =
                new GroupLayout(panelPrincipal);

        panelPrincipal.setLayout(distribucionPanel);

        // =====================================================
        // TAMAÑOS HORIZONTALES
        // =====================================================

        distribucionPanel.setHorizontalGroup(
                distribucionPanel.createParallelGroup(
                                GroupLayout.Alignment.CENTER
                        )
                        .addComponent(
                                etiquetaTitulo
                        )
                        .addComponent(
                                panelResultados,
                                GroupLayout.PREFERRED_SIZE,
                                550,
                                GroupLayout.PREFERRED_SIZE
                        )
                        .addComponent(
                                botonAceptar,
                                GroupLayout.PREFERRED_SIZE,
                                150,
                                GroupLayout.PREFERRED_SIZE
                        )
        );

        // =====================================================
        // TAMAÑOS VERTICALES
        // =====================================================

        distribucionPanel.setVerticalGroup(
                distribucionPanel.createSequentialGroup()

                        .addGap(37)

                        // Título
                        .addComponent(etiquetaTitulo)

                        .addGap(0)

                        // Resultados
                        .addComponent(
                                panelResultados,
                                GroupLayout.PREFERRED_SIZE,
                                300,
                                GroupLayout.PREFERRED_SIZE
                        )

                        .addGap(37)

                        // Botón
                        .addComponent(
                                botonAceptar,
                                GroupLayout.PREFERRED_SIZE,
                                25,
                                GroupLayout.PREFERRED_SIZE
                        )

                        .addGap(72)
        );

        // =====================================================
        // FRAME
        // =====================================================

        GroupLayout distribucionVentana =
                new GroupLayout(getContentPane());

        getContentPane().setLayout(distribucionVentana);

        distribucionVentana.setHorizontalGroup(
                distribucionVentana.createParallelGroup(
                                GroupLayout.Alignment.CENTER
                        )
                        .addComponent(
                                panelPrincipal,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE
                        )
        );

        distribucionVentana.setVerticalGroup(
                distribucionVentana.createParallelGroup(
                                GroupLayout.Alignment.CENTER
                        )
                        .addComponent(
                                panelPrincipal,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE
                        )
        );

        pack();
    }





    public void crearGrafico() {

        DefaultCategoryDataset dataset1 = new DefaultCategoryDataset();

        valorInteresesSS = convertirValor(DatosVocacionales.interesServicioSocial);
        valorInteresesEP = convertirValor(DatosVocacionales.interesEjecutivoPersuasiva);
        valorInteresesV = convertirValor(DatosVocacionales.interesVerbal);
        valorInteresesAP = convertirValor(DatosVocacionales.interesArtisticoPlastica);
        valorInteresesMS = convertirValor(DatosVocacionales.interesMusical);
        valorInteresesOG = convertirValor(DatosVocacionales.interesOrganizacion);
        valorInteresesCT = convertirValor(DatosVocacionales.interesCientifica);
        valorInteresesCL = convertirValor(DatosVocacionales.interesCalculo);
        valorInteresesMC = convertirValor(DatosVocacionales.interesMecanicoConstructiva);
        valorInteresesAL = convertirValor(DatosVocacionales.interesTrabajoAlAireLibre);

        valorAptitudesSS = convertirValor(DatosVocacionales.aptitudesServicioSocial);
        valorAptitudesEP = convertirValor(DatosVocacionales.aptitudesEjecutivoPersuasiva);
        valorAptitudesV = convertirValor(DatosVocacionales.aptitudesVerbal);
        valorAptitudesAP = convertirValor(DatosVocacionales.aptitudesArtisticoPlastica);
        valorAptitudesMS = convertirValor(DatosVocacionales.aptitudesMusical);
        valorAptitudesOG = convertirValor(DatosVocacionales.aptitudesOrganizacion);
        valorAptitudesCT = convertirValor(DatosVocacionales.aptitudesCientifica);
        valorAptitudesCL = convertirValor(DatosVocacionales.aptitudesCalculo);
        valorAptitudesMC = convertirValor(DatosVocacionales.aptitudesMecanicoConstructiva);
        valorAptitudesAL = convertirValor(DatosVocacionales.aptitudesTrabajoAlAireLibre);

        dataset1.addValue(valorInteresesSS, "Intereses", "SS");
        dataset1.addValue(valorInteresesEP, "Intereses", "EP");
        dataset1.addValue(valorInteresesV, "Intereses", "V");
        dataset1.addValue(valorInteresesAP, "Intereses", "AP");
        dataset1.addValue(valorInteresesMS, "Intereses", "MS");
        dataset1.addValue(valorInteresesOG, "Intereses", "OG");
        dataset1.addValue(valorInteresesCT, "Intereses", "CT");
        dataset1.addValue(valorInteresesCL, "Intereses", "CL");
        dataset1.addValue(valorInteresesMC, "Intereses", "MC");
        dataset1.addValue(valorInteresesAL, "Intereses", "AL");

        dataset1.addValue(valorAptitudesSS, "Aptitudes", "SS");
        dataset1.addValue(valorAptitudesEP, "Aptitudes", "EP");
        dataset1.addValue(valorAptitudesV, "Aptitudes", "V");
        dataset1.addValue(valorAptitudesAP, "Aptitudes", "AP");
        dataset1.addValue(valorAptitudesMS, "Aptitudes", "MS");
        dataset1.addValue(valorAptitudesOG, "Aptitudes", "OG");
        dataset1.addValue(valorAptitudesCT, "Aptitudes", "CT");
        dataset1.addValue(valorAptitudesCL, "Aptitudes", "CL");
        dataset1.addValue(valorAptitudesMC, "Aptitudes", "MC");
        dataset1.addValue(valorAptitudesAL, "Aptitudes", "AL");

        dataset1.addValue(100, "", "");

        chart = ChartFactory.createBarChart3D(
                "", // chart title
                "", // domain axis label
                "", // range axis label
                dataset1, // data
                PlotOrientation.VERTICAL,
                true, // include legend
                true,
                false
        );
    }

    public int convertirValor(int valorOriginal) {
        if (valorOriginal == 0) {
            return 0;
        } else if (valorOriginal == 1) {
            return 4;
        } else if (valorOriginal == 2) {
            return 8;
        } else if (valorOriginal == 3) {
            return 13;
        } else if (valorOriginal == 4) {
            return 17;
        } else if (valorOriginal == 5) {
            return 21;
        } else if (valorOriginal == 6) {
            return 25;
        } else if (valorOriginal == 7) {
            return 29;
        } else if (valorOriginal == 8) {
            return 33;
        } else if (valorOriginal == 9) {
            return 38;
        } else if (valorOriginal == 10) {
            return 42;
        } else if (valorOriginal == 11) {
            return 46;
        } else if (valorOriginal == 12) {
            return 50;
        } else if (valorOriginal == 13) {
            return 54;
        } else if (valorOriginal == 14) {
            return 58;
        } else if (valorOriginal == 15) {
            return 63;
        } else if (valorOriginal == 16) {
            return 67;
        } else if (valorOriginal == 17) {
            return 71;
        } else if (valorOriginal == 18) {
            return 75;
        } else if (valorOriginal == 19) {
            return 79;
        } else if (valorOriginal == 20) {
            return 83;
        } else if (valorOriginal == 21) {
            return 89;
        } else if (valorOriginal == 22) {
            return 92;
        } else if (valorOriginal == 23) {
            return 96;
        } else if (valorOriginal == 24) {
            return 100;
        } else {
            return valorOriginal;
        }
    }

    public void calcularAreasIntereses() {
        // Calcular el máximo valor de intereses
        int maxIntereses = Math.max(valorInteresesSS, Math.max(valorInteresesEP, Math.max(valorInteresesV, Math.max(valorInteresesAP,
                Math.max(valorInteresesMS, Math.max(valorInteresesOG, Math.max(valorInteresesCT, Math.max(valorInteresesCL,
                        Math.max(valorInteresesMC, valorInteresesAL)))))))));
        // Asignar el valor correspondiente a puntajeIntereses
        if (maxIntereses == valorInteresesSS) {
            areaInteres = "Servicio Social";
            carreasInteres = "Urbanismo, Ingeniería Civil, Sociología, Trabajo Social, Derecho, Enfermería y Obstetricia, Psicología, Pedagogía, Medicina, Odontología, Ciencias Políticas y Administración Pública, Economía, Relaciones Internacionales, Enseñanza de Inglés, Optometría, Planificación para el Desarrollo Agropecuario, Estudios Latinoamericanos, Bibliotecología y Estudios de la Información, Educación Musical.";
            puntajeIntereses = "Preferencia por participar en actividades directamente relacionadas con el bienestar de las personas.";
        } else if (maxIntereses == valorInteresesEP) {
            areaInteres = "Ejecutivo Persuasiva";
            carreasInteres = "Actuaría, Economía, Administración, Ciencias  Políticas y Administración Pública, Derecho, Ingeniería Industrial, Ingeniería de Alimentos, Ingeniería Petrolera, Psicología, Medicina, Relaciones Internacionales.";
            puntajeIntereses = "Agrado por planear, organizar o dirigir las actividades de personas o agrupaciones.";
        } else if (maxIntereses == valorInteresesV) {
            areaInteres = "Verbal";
            carreasInteres = "Derecho, Ciencias de la Comunicación, Letras Clásicas, Lengua y Literaturas Modernas, Relaciones Internacionales, Literatura Dramática y Teatro, Sociología, Ciencias Políticas y Administración Pública.";
            puntajeIntereses = "Gusto por la lectura de obras diversas y satisfacción al expresarse verbalmente o por escrito.";
        } else if (maxIntereses == valorInteresesAP) {
            areaInteres = "Artístico Plástica";
            carreasInteres = "Artes  Visuales, Diseño y Comunicación Visual, Diseño Gráfico, Arquitectura, Arquitectura de Paisaje, Odontología, Literatura Dramática y Teatro.";
            puntajeIntereses = "Agrado por conocer o realizar actividades creativas como dibujo, la pintura, la escultura, el modelado, etcétera.";
        } else if (maxIntereses == valorInteresesMS) {
            areaInteres = "Musical";
            carreasInteres = "Composición, Instrumentista, Canto, Etnomusicología, Piano, Educación Musical.";
            puntajeIntereses = "Gusto por la ejecución, estudio o composición de la música.";
        } else if (maxIntereses == valorInteresesOG) {
            areaInteres = "Organización";
            carreasInteres = "Bibliotecología y Estudios de la Información, Actuaría, Matemáticas Aplicadas y Computación, Informática, Contaduría, Administración, Ciencias de la Comunicación, Matemáticas, Relaciones Internacionales, Economía, Ciencias Políticas y Administración Pública.";
            puntajeIntereses = "Preferencia por actividades que requieren orden y sistematización.";
        } else if (maxIntereses == valorInteresesCT) {
            areaInteres = "Científica";
            carreasInteres = "Investigación Biomédica Básica, Ciencias Genómicas, Matemáticas, Física, Ingeniería Mecatrónica, Química, Biología, Psicología, Medicina Veterinaria y Zootecnia, Ingeniería Química, Química Farmacéutico-Biológica, Química Industrial, Química de Alimentos, Ingeniería en Alimentos, Filosofía, Historia.";
            puntajeIntereses = "Gusto por conocer o investigar los fenómenos, las causas que los provocan y los principios que los explican.";
        } else if (maxIntereses == valorInteresesCL) {
            areaInteres = "Cálculo";
            carreasInteres = "Matemáticas, Economía, Contaduría, Física, Ingenierías: Geológica, Geofísica, Civil, en Telecomunicaciones, Computación, Topográfica, Industrial, Química; Arquitectura, Geografía, Actuaría, Informática, Química, Matemáticas Aplicadas y Computación, Ciencias de la Comunicación.";
            puntajeIntereses = "Gusto por resolver problemas de tipo cuantitativo, donde se utilizan las operaciones matemáticas.";
        } else if (maxIntereses == valorInteresesMC) {
            areaInteres = "Mecánico Constructiva";
            carreasInteres = "Ingenierías: Eléctrica-Electrónica, Geofísica, Topográfica, Civil, Petrolera, Mecánica Eléctrica, Química, en Computación, Mecánica Química Metalúrgica, Mecatrónica, Arquitectura, Diseño Industrial.";
            puntajeIntereses = "Atracción por armar, conocer o descubrir mecanismos mediante los cuales funciona un aparato, así como proyectar y construir objetos diversos.";
        } else if (maxIntereses == valorInteresesAL) {
            areaInteres = "Trabajo Al Aire Libre ";
            carreasInteres = "Biología, Ingeniería Agrícola, Ingeniería Geológica, Ingeniería Petrolera, Geografía, Ingeniería Civil, Ingeniería Topográfica y Geodésica, Medicina Veterinaria y Zootecnia, Planificación para el Desarrollo Agropecuario, Urbanismo.";
            puntajeIntereses = "Satisfacción por actividades que se realizan en lugares abiertos y/o apartados de los conglomerados urbanos.";
        } else {
            areaInteres = "Servicio Social";
            carreasInteres = "Urbanismo, Ingeniería Civil, Sociología, Trabajo Social, Derecho, Enfermería y Obstetricia, Psicología, Pedagogía, Medicina, Odontología, Ciencias Políticas y Administración Pública, Economía, Relaciones Internacionales, Enseñanza de Inglés, Optometría, Planificación para el Desarrollo Agropecuario, Estudios Latinoamericanos, Bibliotecología y Estudios de la Información, Educación Musical.";
            puntajeIntereses = "Preferencia por participar en actividades directamente relacionadas con el bienestar de las personas.";
        }

    }

    public void calcularAreasAptitudes() {
        // Calcular el máximo valor de aptitudes
        int maxAptitudes = Math.max(valorAptitudesSS, Math.max(valorAptitudesEP, Math.max(valorAptitudesV, Math.max(valorAptitudesAP,
                Math.max(valorAptitudesMS, Math.max(valorAptitudesOG, Math.max(valorAptitudesCT, Math.max(valorAptitudesCL,
                        Math.max(valorAptitudesMC, valorAptitudesAL)))))))));
        if (maxAptitudes == valorAptitudesSS) {
            puntajeAptitudes = "Habilidad para comprender problemas humanos, para tratar personas, cooperar y persuadir; para hacer lo más adecuado ante situaciones sociales. Actitud de ayuda afectuosa y desinteresada hacia sus semejantes.";
        } else if (maxAptitudes == valorAptitudesEP) {
            puntajeAptitudes = "Capacidad para organizar, dirigir y supervisar a otros adecuadamente; poseer iniciativa, confianza en sí mismo, ambición de progreso, habilidad para dominar en situaciones sociales y en relaciones de persona a persona.";
        } else if (maxAptitudes == valorAptitudesV) {
            puntajeAptitudes = "Habilidad  para  comprender  y  expresarse  correctamente.  También  para  utilizar  las  palabras precisas y adecuadas.";
        } else if (maxAptitudes == valorAptitudesAP) {
            puntajeAptitudes = "Habilidad para apreciar las formas o colores de un objeto, dibujo, escultura o pintura y para crear obras de mérito artístico en pintura, escultura, grabado o dibujo.";
        } else if (maxAptitudes == valorAptitudesMS) {
            puntajeAptitudes = "Habilidad para captar y distinguir sonidos en  sus diversas modalidades, para imaginar estos sonidos, reproducirlos o utilizarlos en forma creativa; sensibilidad a la combinación y armonía de sonidos.";
        } else if (maxAptitudes == valorAptitudesOG) {
            puntajeAptitudes = "Capacidad de  organización, orden,  exactitud  y  rapidez en  el  manejo de  nombres, números, documentos, sistemas y sus detalles en trabajos rutinarios.";
        } else if (maxAptitudes == valorAptitudesCT) {
            puntajeAptitudes = "Habilidad para la investigación; aptitud para captar, definir y comprender principios y relaciones causales de los fenómenos proponiéndose siempre la obtención de la novedad.";
        } else if (maxAptitudes == valorAptitudesCL) {
            puntajeAptitudes = "Dominio de las operaciones y mecanizaciones numéricas, así como habilidad para el cálculo matemático.";
        } else if (maxAptitudes == valorAptitudesMC) {
            puntajeAptitudes = "Comprensión y habilidad en la manipulación de objetos y facilidad para percibir, imaginar y analizar formas en dos o tres dimensiones, así como para abstraer sistemas, mecanismos y movimientos.";
        } else if (maxAptitudes == valorAptitudesAL) {
            puntajeAptitudes = "Habilidad en el uso de las manos para el manejo de herramientas; ejecución de movimientos coordinados y precisos.";
        } else {
            puntajeAptitudes = "Habilidad para comprender problemas humanos, para tratar personas, cooperar y persuadir; para hacer lo más adecuado ante situaciones sociales. Actitud de ayuda afectuosa y desinteresada hacia sus semejantes.";
        }
    }


    private void aceptar(ActionEvent evt) {
        ResultadosVocacionales resultadosVocacionales = new ResultadosVocacionales();
        resultadosVocacionales.puntajeIntereses = this.puntajeIntereses;
        resultadosVocacionales.puntajeAptitudes = this.puntajeAptitudes;
        resultadosVocacionales.carreasInteres = this.carreasInteres;

        Reporte reporte = new Reporte(estudiante);
        reporte.setVisible(true);
        dispose();
    }

}
