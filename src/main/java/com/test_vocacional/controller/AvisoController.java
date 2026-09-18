package com.test_vocacional.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.Image;
import com.itextpdf.text.pdf.PdfWriter;
import com.test_vocacional.constant.AvisoConstants;
import com.test_vocacional.constant.Constants;
import com.test_vocacional.constant.SourceConstants;
import com.test_vocacional.view.AvisoView;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Objects;

public class AvisoController {

    private final AvisoView avisoView;

    public AvisoController(AvisoView avisoView) {
        this.avisoView = avisoView;
    }

    public void abrirAvisoPrivacidad() {
        File archivoPdf = new File(SourceConstants.RUTA_AVISO_PDF);

        try {

            generarAvisoPdf(archivoPdf);

            if (Desktop.isDesktopSupported()) {
                Desktop.getDesktop().open(archivoPdf);
            } else {
                JOptionPane.showMessageDialog(
                        avisoView,
                        "No es posible abrir el archivo automáticamente."
                );
            }

        } catch (Exception excepcion) {

            JOptionPane.showMessageDialog(
                    avisoView,
                    "No fue posible generar o abrir el aviso de privacidad: "
                            + excepcion.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    private void generarAvisoPdf(File archivoPdf) throws Exception {

        File carpeta = archivoPdf.getParentFile();

        if (carpeta != null) {
            carpeta.mkdirs();
        }

        Document documento = new Document(
                PageSize.LEGAL,
                72,
                72,
                36,
                36
        );

        PdfWriter.getInstance(
                documento,
                new FileOutputStream(archivoPdf)
        );

        documento.open();

        agregarEncabezadoPdf(documento);
        agregarParrafosPdf(documento);

        documento.close();
    }

    private void agregarEncabezadoPdf(Document documento) throws Exception {

        Image logo = Image.getInstance(
                Objects.requireNonNull(getClass().getResource(
                        SourceConstants.RUTA_LOGO_CETIS
                ))
        );

        logo.setAlignment(Element.ALIGN_CENTER);

        documento.add(logo);
        documento.add(Chunk.NEWLINE);

        Paragraph titulo = new Paragraph(Constants.ENCABEZADO_AVISO_PRIVACIDAD_AVISO);

        titulo.setAlignment(
                Element.ALIGN_CENTER
        );

        documento.add(titulo);
        documento.add(Chunk.NEWLINE);
    }

    private void agregarParrafosPdf(Document documento) throws Exception {

        for (String texto : AvisoConstants.PARRAFOS_AVISO) {

            Paragraph parrafo = new Paragraph(texto);

            parrafo.setAlignment(
                    Element.ALIGN_JUSTIFIED
            );

            documento.add(parrafo);
            documento.add(Chunk.NEWLINE);
        }
    }
}
