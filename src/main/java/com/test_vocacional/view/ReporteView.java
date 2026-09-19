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
import com.test_vocacional.controller.InteresesController;
import com.test_vocacional.controller.ReporteController;
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

public class ReporteView extends JFrame {

    private JPanel panelPrincipal;
    private JLabel etiquetaTitulo;
    private JTextPane textoReporte;
    private JScrollPane scrollPaneReporte;
    private JButton botonGenerarReporte;

    private String textoInforme;

    private Estudiante estudiante;

    private final ReporteController reporteController;

    // =====================================================
    // CONSTRUCTOR
    // =====================================================
    public ReporteView(Estudiante estudiante) {

        this.estudiante = estudiante;

        initComponents();

        WindowConfig.configurar(
                this,
                600,
                500
        );

        reporteController =
                new ReporteController();

        generarTextoInforme();
        configurarReporte();
    }

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

    // =====================================================
    // COMPONENTES
    // =====================================================
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

    // =====================================================
    // EVENTOS
    // =====================================================
    private void configurarEventos() {
        botonGenerarReporte.addActionListener(
                this::generarReporte
        );
    }

    // =====================================================
    // TEXTO DEL INFORME
    // =====================================================

    private void generarTextoInforme() {

        textoInforme =
                reporteController.generarTextoInforme(
                        estudiante
                );
    }

    // =====================================================
    // MOSTRAR REPORTE
    // =====================================================

    private void configurarReporte() {

        textoReporte.setText(
                textoInforme
        );

        // Colocar el cursor al inicio
        textoReporte.setCaretPosition(0);

        // Justificar el contenido
        javax.swing.text.SimpleAttributeSet atributos =
                new javax.swing.text.SimpleAttributeSet();

        javax.swing.text.StyleConstants.setAlignment(
                atributos,
                javax.swing.text.StyleConstants.ALIGN_JUSTIFIED
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

    // =====================================================
    // GENERAR PDF
    // =====================================================
    private void generarReporte(ActionEvent evento) {

        reporteController.generarReporte(
                estudiante,
                textoInforme,
                this
        );

        dispose();
    }

    // =====================================================
    // LAYOUT
    // =====================================================
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
}