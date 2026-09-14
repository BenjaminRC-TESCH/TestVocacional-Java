package com.test_vocacional.view;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.test_vocacional.config.WindowConfig;
import com.test_vocacional.config.ScrollBarCustom;
import com.test_vocacional.constant.Constants;
import com.test_vocacional.constant.colors.ColorConstants;
import com.test_vocacional.constant.font.FontConstants;
import com.test_vocacional.model.Estudiante;
import com.test_vocacional.model.ResultadosVocacionales;
import com.test_vocacional.util.CurrentDate;
import com.test_vocacional.util.GetNameFile;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.Desktop;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;

public class Reporte extends JFrame {

    // =========================================================
    // CONFIGURACIÓN
    // =========================================================


    // =========================================================
    // COMPONENTES
    // =========================================================

    private JPanel panelPrincipal;
    private JLabel etiquetaTitulo;
    private JTextPane textoReporte;
    private JScrollPane scrollPaneReporte;
    private JButton botonGenerarReporte;

    // =========================================================
    // DATOS
    // =========================================================

    private String textoInforme;

    private Estudiante estudiante;

    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public Reporte(Estudiante estudiante) {

        this.estudiante = estudiante;

        initComponents();
        WindowConfig.configurar(
                this,
                600,
                500
        );

        generarTextoInforme();
        configurarReporte();
    }

    // =========================================================
    // CONFIGURACIÓN DE LA VENTANA
    // =========================================================

    // =========================================================
    // INICIALIZACIÓN DE COMPONENTES
    // =========================================================

    private void initComponents() {
        panelPrincipal = new JPanel();
        etiquetaTitulo = new JLabel();
        textoReporte = new JTextPane();

        scrollPaneReporte = new JScrollPane(
                textoReporte
        );

        botonGenerarReporte = new JButton();


        configurarComponentes();
        configurarEventos();
        configurarLayout();
    }

    private void configurarComponentes() {

        panelPrincipal.setBackground(ColorConstants.BLANCO);

        etiquetaTitulo.setFont(new Font(FontConstants.ROBOTO_BLACK, Font.PLAIN, 24));
        etiquetaTitulo.setText(Constants.TITULO_REPORTE);

        textoReporte.setFont(new Font(FontConstants.ROBOT, Font.PLAIN, 14));

        textoReporte.setEditable(false);

        textoReporte.setCursor(
                Cursor.getPredefinedCursor(
                        Cursor.DEFAULT_CURSOR
                )
        );

        scrollPaneReporte.setBorder(null);

        scrollPaneReporte.setVerticalScrollBar(new ScrollBarCustom());

        botonGenerarReporte.setBackground(ColorConstants.ROJO_VINO);

        botonGenerarReporte.setForeground(ColorConstants.BLANCO);

        botonGenerarReporte.setText(Constants.BOTON_ACEPTAR_REPORTE);

        botonGenerarReporte.setBorder(null);
    }

    private void configurarEventos() {
        botonGenerarReporte.addActionListener(
                this::generarReporte
        );
    }

    private void configurarLayout() {

        GroupLayout distribucionPanel =
                new GroupLayout(panelPrincipal);

        panelPrincipal.setLayout(distribucionPanel);

        distribucionPanel.setHorizontalGroup(

                distribucionPanel.createParallelGroup(
                                GroupLayout.Alignment.LEADING
                        )

                        .addGroup(
                                distribucionPanel
                                        .createSequentialGroup()
                                        .addContainerGap(
                                                GroupLayout.DEFAULT_SIZE,
                                                Short.MAX_VALUE
                                        )
                                        .addComponent(etiquetaTitulo)
                                        .addContainerGap(
                                                193,
                                                193
                                        )
                        )
                        .addGroup(
                                distribucionPanel
                                        .createSequentialGroup()
                                        .addGap(44)
                                        .addComponent(
                                                scrollPaneReporte,
                                                GroupLayout.PREFERRED_SIZE,
                                                500,
                                                GroupLayout.PREFERRED_SIZE
                                        )
                                        .addContainerGap(
                                                56,
                                                Short.MAX_VALUE
                                        )
                        )
                        .addGroup(

                                distribucionPanel
                                        .createSequentialGroup()

                                        .addGap(225)
                                        .addComponent(
                                                botonGenerarReporte,
                                                GroupLayout.PREFERRED_SIZE,
                                                150,
                                                GroupLayout.PREFERRED_SIZE
                                        )
                        )
        );

        // =====================================================
        // TAMAÑOS VERTICALES
        // =====================================================

        distribucionPanel.setVerticalGroup(

                distribucionPanel.createParallelGroup(
                                GroupLayout.Alignment.LEADING
                        )

                        .addGroup(

                                distribucionPanel
                                        .createSequentialGroup()

                                        .addGap(40)
                                        .addComponent(
                                                etiquetaTitulo
                                        )
                                        .addGap(40)
                                        .addComponent(
                                                scrollPaneReporte,
                                                GroupLayout.PREFERRED_SIZE,
                                                250,
                                                GroupLayout.PREFERRED_SIZE
                                        )
                                        .addGap(18)
                                        .addComponent(
                                                botonGenerarReporte,
                                                GroupLayout.PREFERRED_SIZE,
                                                30,
                                                GroupLayout.PREFERRED_SIZE
                                        )

                                        .addContainerGap(
                                                71,
                                                Short.MAX_VALUE
                                        )
                        )
        );

        // =========================================================
        // DISTRIBUCIÓN DE LA VENTANA
        // =========================================================
        GroupLayout distribucionVentana =
                new GroupLayout(getContentPane());

        getContentPane().setLayout(
                distribucionVentana
        );

        distribucionVentana.setHorizontalGroup(

                distribucionVentana.createParallelGroup(
                                GroupLayout.Alignment.LEADING
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
                                GroupLayout.Alignment.LEADING
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

    private void generarTextoInforme() {

        textoInforme =
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
    }


    private void configurarReporte() {

        textoReporte.setText(
                textoInforme
        );

        // Colocar el cursor al inicio
        textoReporte.setCaretPosition(0);

        // Justificar el contenido
        SimpleAttributeSet atributos =
                new SimpleAttributeSet();

        StyleConstants.setAlignment(
                atributos,
                StyleConstants.ALIGN_JUSTIFIED
        );

        textoReporte
                .getStyledDocument()
                .setParagraphAttributes(
                        0,
                        textoInforme.length(),
                        atributos,
                        false
                );
    }





    private void generarReporte(ActionEvent evento) {

        String nombreAlumno = estudiante.getNombre();

        String nombreArchivo = GetNameFile.obtenerNombreArchivo(nombreAlumno);

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

            abrirArchivo(archivoPdf);

            dispose();

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
                    this,
                    "No fue posible generar el reporte:\n"
                            + excepcion.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }


    private void abrirArchivo(File archivo) throws IOException {

        if (!Desktop.isDesktopSupported()) {

            JOptionPane.showMessageDialog(
                    this,
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