package com.test_vocacional.controller;

import com.test_vocacional.model.DatosVocacionales;
import com.test_vocacional.model.Estudiante;
import com.test_vocacional.model.ResultadosVocacionales;
import com.test_vocacional.view.ReporteView;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class ResultadoController {

    private int valorInteresesSS;
    private int valorInteresesEP;
    private int valorInteresesV;
    private int valorInteresesAP;
    private int valorInteresesMS;
    private int valorInteresesOG;
    private int valorInteresesCT;
    private int valorInteresesCL;
    private int valorInteresesMC;
    private int valorInteresesAL;

    private int valorAptitudesSS;
    private int valorAptitudesEP;
    private int valorAptitudesV;
    private int valorAptitudesAP;
    private int valorAptitudesMS;
    private int valorAptitudesOG;
    private int valorAptitudesCT;
    private int valorAptitudesCL;
    private int valorAptitudesMC;
    private int valorAptitudesAL;

    private String puntajeIntereses;
    private String puntajeAptitudes;
    private String areaInteres;
    private String carreasInteres;


    public JFreeChart crearGrafico() {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        // =====================================================
        // CONVERTIR VALORES DE INTERESES
        // =====================================================

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

        // =====================================================
        // CONVERTIR VALORES DE APTITUDES
        // =====================================================

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

        // =====================================================
        // INTERESES
        // =====================================================

        dataset.addValue(valorInteresesSS, "Intereses", "SS");
        dataset.addValue(valorInteresesEP, "Intereses", "EP");
        dataset.addValue(valorInteresesV, "Intereses", "V");
        dataset.addValue(valorInteresesAP, "Intereses", "AP");
        dataset.addValue(valorInteresesMS, "Intereses", "MS");
        dataset.addValue(valorInteresesOG, "Intereses", "OG");
        dataset.addValue(valorInteresesCT, "Intereses", "CT");
        dataset.addValue(valorInteresesCL, "Intereses", "CL");
        dataset.addValue(valorInteresesMC, "Intereses", "MC");
        dataset.addValue(valorInteresesAL, "Intereses", "AL");

        // =====================================================
        // APTITUDES
        // =====================================================

        dataset.addValue(valorAptitudesSS, "Aptitudes", "SS");
        dataset.addValue(valorAptitudesEP, "Aptitudes", "EP");
        dataset.addValue(valorAptitudesV, "Aptitudes", "V");
        dataset.addValue(valorAptitudesAP, "Aptitudes", "AP");
        dataset.addValue(valorAptitudesMS, "Aptitudes", "MS");
        dataset.addValue(valorAptitudesOG, "Aptitudes", "OG");
        dataset.addValue(valorAptitudesCT, "Aptitudes", "CT");
        dataset.addValue(valorAptitudesCL, "Aptitudes", "CL");
        dataset.addValue(valorAptitudesMC, "Aptitudes", "MC");
        dataset.addValue(valorAptitudesAL, "Aptitudes", "AL");

        dataset.addValue(100, "", "");

        // =====================================================
        // CREAR GRÁFICO
        // =====================================================

        return ChartFactory.createBarChart3D(
                "",
                "",
                "",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );
    }

    /**
     * Convierte el valor original a su valor porcentual.
     */
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

    /**
     * Calcula el área de mayor interés.
     */
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

    /**
     * Calcula el área de mayor aptitud.
     */
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

    /**
     * Guarda los resultados calculados en el modelo.
     */
    public void guardarResultados() {

        ResultadosVocacionales resultadosVocacionales =
                new ResultadosVocacionales();

        resultadosVocacionales.puntajeIntereses =
                puntajeIntereses;

        resultadosVocacionales.puntajeAptitudes =
                puntajeAptitudes;

        resultadosVocacionales.carreasInteres =
                carreasInteres;
    }

    /**
     * Abre el reporte con los resultados obtenidos.
     */
    public void aceptar(Estudiante estudiante) {

        guardarResultados();

        ReporteView reporte =
                new ReporteView(estudiante);

        reporte.setVisible(true);
    }

    public String getPuntajeIntereses() {
        return puntajeIntereses;
    }

    public String getPuntajeAptitudes() {
        return puntajeAptitudes;
    }

    public String getAreaInteres() {
        return areaInteres;
    }

    public String getCarreasInteres() {
        return carreasInteres;
    }
}