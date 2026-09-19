package com.test_vocacional.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.test_vocacional.model.Estudiante;
import com.test_vocacional.model.ResultadosVocacionales;
import com.test_vocacional.util.CurrentDate;
import com.test_vocacional.util.GetNameFile;
import com.test_vocacional.view.ReporteView;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReporteController {

    public String generarTextoInforme(Estudiante estudiante) {

        String textoInforme =
                "Se realizó la prueba Inventario Herrera y Montes, "
                        + "perfil de intereses y perfil de aptitudes a "
                        + estudiante.getNombre()
                        + ", el cual arrojó los siguientes resultados."
                        + "\n\n"

                        + "De acuerdo al puntaje obtenido en la prueba "
                        + "de perfil de intereses:"
                        + "\n"
                        + "1. "
                        + ResultadosVocacionales.puntajeIntereses
                        + "\n\n"

                        + "Por otro lado, de acuerdo al puntaje obtenido "
                        + "en la prueba de perfil de aptitudes:"
                        + "\n"
                        + "1. "
                        + ResultadosVocacionales.puntajeAptitudes
                        + "\n\n"

                        + "La mejor opción para "
                        + estudiante.getNombre()
                        + " de acuerdo a la prueba realizada son las "
                        + "carreras de "
                        + ResultadosVocacionales.carreasInteres
                        + "."
                        + "\n\n"

                        + "Cabe mencionar que depende de cada persona "
                        + "la selección de la carrera que quiere estudiar. "
                        + "Esta es una prueba estandarizada que puede ayudar "
                        + "a tener un mejor panorama de los intereses y las "
                        + "aptitudes. Se recomienda aplicar otra prueba de "
                        + "orientación vocacional para confirmar sus intereses "
                        + "vocacionales.";

        return textoInforme;
    }

    public void generarReporte(Estudiante estudiante, String textoInforme, Component componentePadre) {

        String nombreAlumno = estudiante.getNombre();

        String nombreArchivo =
                GetNameFile.obtenerNombreArchivo(nombreAlumno);

        String rutaEscritorio =
                System.getProperty("user.home")
                        + File.separator
                        + "Desktop";

        File archivoPdf = new File(
                rutaEscritorio,
                nombreArchivo
        );

        Document documento = new Document(
                PageSize.A4,
                72,
                72,
                36,
                36
        );

        FileOutputStream salida = null;

        try {

            salida = new FileOutputStream(
                    archivoPdf
            );

            PdfWriter.getInstance(
                    documento,
                    salida
            );

            documento.open();

            // =================================================
            // TÍTULO
            // =================================================

            Paragraph titulo =
                    new Paragraph(
                            "Resultados de test vocacional"
                    );

            titulo.setAlignment(
                    Element.ALIGN_CENTER
            );

            documento.add(titulo);

            documento.add(
                    Chunk.NEWLINE
            );

            // =================================================
            // DATOS DEL ALUMNO
            // =================================================

            documento.add(
                    new Paragraph(
                            "Nombre del test: "
                                    + "Inventario Herrera y Montes"
                    )
            );

            documento.add(
                    new Paragraph(
                            "Nombre del alumno: "
                                    + nombreAlumno.toUpperCase()
                    )
            );

            documento.add(
                    new Paragraph(
                            "Fecha de aplicación de la prueba: "
                                    + CurrentDate.obtenerFechaActual()
                    )
            );

            documento.add(
                    Chunk.NEWLINE
            );

            // =================================================
            // RESULTADOS
            // =================================================

            Paragraph resultados =
                    new Paragraph(
                            textoInforme
                    );

            resultados.setAlignment(
                    Element.ALIGN_JUSTIFIED
            );

            documento.add(
                    resultados
            );

            documento.add(
                    Chunk.NEWLINE
            );

            documento.add(
                    Chunk.NEWLINE
            );

            documento.add(
                    Chunk.NEWLINE
            );

            // =================================================
            // FIRMA
            // =================================================

            Paragraph lineaFirma =
                    new Paragraph(
                            "__________________________________"
                    );

            lineaFirma.setAlignment(
                    Element.ALIGN_CENTER
            );

            documento.add(
                    lineaFirma
            );

            Paragraph nombreFirma =
                    new Paragraph(
                            "Nombre y firma del aplicador"
                    );

            nombreFirma.setAlignment(
                    Element.ALIGN_CENTER
            );

            documento.add(
                    nombreFirma
            );

            // =================================================
            // CERRAR DOCUMENTO
            // =================================================

            documento.close();

            if (salida != null) {
                salida.close();
            }

            // =================================================
            // ABRIR PDF
            // =================================================

            abrirArchivo(
                    archivoPdf,
                    componentePadre
            );

        } catch (DocumentException
                 | IOException excepcion) {

            if (documento.isOpen()) {
                documento.close();
            }

            try {

                if (salida != null) {
                    salida.close();
                }

            } catch (IOException errorSalida) {
                // No es necesario mostrar este error al usuario.
            }

            JOptionPane.showMessageDialog(
                    componentePadre,
                    "No fue posible generar el reporte:\n"
                            + excepcion.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void abrirArchivo(File archivo, Component componentePadre) throws IOException {

        if (!Desktop.isDesktopSupported()) {

            JOptionPane.showMessageDialog(
                    componentePadre,
                    "El sistema no permite abrir el archivo automáticamente.",
                    "Reporte generado",
                    JOptionPane.INFORMATION_MESSAGE
            );

            return;
        }

        Desktop.getDesktop().open(
                archivo
        );
    }
}
