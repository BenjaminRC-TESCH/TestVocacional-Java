package com.test_vocacional.view;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.test_vocacional.config.WindowConfig;
import com.test_vocacional.config.ScrollBarCustom;
import com.test_vocacional.constant.AvisoConstants;
import com.test_vocacional.constant.Constants;
import com.test_vocacional.constant.colors.ColorConstants;
import com.test_vocacional.constant.font.FontConstants;
import com.test_vocacional.constant.SourceConstants;
import com.test_vocacional.controller.AvisoController;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Objects;

public class AvisoView extends JFrame {

    private JTextPane textoAviso;
    private JCheckBox casillaAceptacion;
    private JButton botonAvisoPrivacidad;
    private JButton botonSiguiente;
    private JLabel etiquetaTitulo;
    private JPanel panelAviso;
    private JScrollPane panelDesplazamiento;

    private final AvisoController avisoController;

    public AvisoView() {

        initComponents();

        WindowConfig.configurar(
                this,
                600,
                500
        );

        configurarAviso();
        avisoController = new AvisoController(this);
    }

    private void initComponents() {
        panelAviso = new JPanel();
        etiquetaTitulo = new JLabel();
        panelDesplazamiento = new JScrollPane();
        textoAviso = new JTextPane();
        casillaAceptacion = new JCheckBox();
        botonAvisoPrivacidad = new JButton();
        botonSiguiente = new JButton();

        configurarComponentes();
        configurarEventos();
        configurarLayout();
    }

    private void configurarAviso() {

        textoAviso.setText(AvisoConstants.AVISO);
        textoAviso.setCaretPosition(0);
        textoAviso.setEditable(false);
        textoAviso.setCursor(null);
        textoAviso.setCaretColor(ColorConstants.BLANCO);

        SimpleAttributeSet atributosTexto =
                new SimpleAttributeSet();

        StyleConstants.setAlignment(
                atributosTexto,
                StyleConstants.ALIGN_JUSTIFIED
        );

        textoAviso
                .getStyledDocument()
                .setParagraphAttributes(
                        0,
                        AvisoConstants.AVISO.length(),
                        atributosTexto,
                        false
                );

        panelDesplazamiento.setVerticalScrollBar(
                new ScrollBarCustom()
        );

        panelDesplazamiento
                .getVerticalScrollBar()
                .setValue(0);

        botonSiguiente.setEnabled(false);

        getContentPane().setBackground(ColorConstants.BLANCO);
    }

    private void configurarComponentes(){

        panelAviso.setBackground(ColorConstants.BLANCO);

        etiquetaTitulo.setFont(new Font(FontConstants.ROBOTO_BLACK, Font.PLAIN, 24));
        etiquetaTitulo.setText(Constants.TITULO_AVISO);

        textoAviso.setFont(new Font(FontConstants.ROBOTO_BLACK, Font.PLAIN, 14));

        panelDesplazamiento.setViewportView(textoAviso);
        panelDesplazamiento.setBorder(null);

        casillaAceptacion.setBackground(ColorConstants.BLANCO);
        casillaAceptacion.setFont(new Font(FontConstants.ROBOT, Font.PLAIN, 12));
        casillaAceptacion.setText(Constants.CASILLA_ACEPTACION_AVISO);

        botonAvisoPrivacidad.setForeground(ColorConstants.AZUL_REY);
        botonAvisoPrivacidad.setBackground(ColorConstants.BLANCO);
        botonAvisoPrivacidad.setText(Constants.BOTON_AVISO_PRIVACIDAD);
        botonAvisoPrivacidad.setBorder(BorderFactory.createLineBorder(ColorConstants.BLANCO));

        botonSiguiente.setBackground(ColorConstants.ROJO_VINO);
        botonSiguiente.setForeground(ColorConstants.BLANCO);
        botonSiguiente.setText(Constants.BOTON_SIGUIENTE_AVISO);
        botonSiguiente.setBorder(null);
    }

    private void configurarEventos(){

        casillaAceptacion.addActionListener(
                e -> cambiarEstadoBotonSiguiente()
        );

        botonSiguiente.addActionListener(
                e -> siguienteVista()
        );

        botonAvisoPrivacidad.addActionListener(
                e -> avisoController.abrirAvisoPrivacidad()
        );
    }

    private void configurarLayout(){
        // =====================================================
        // DISTRIBUCIÓN DEL PANEL
        // =====================================================
        GroupLayout distribucionPanel =
                new GroupLayout(panelAviso);

        panelAviso.setLayout(distribucionPanel);

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
                                                panelDesplazamiento,
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

                                        .addGap(174)

                                        .addComponent(
                                                casillaAceptacion
                                        )

                                        .addPreferredGap(
                                                LayoutStyle.ComponentPlacement.RELATED
                                        )

                                        .addComponent(
                                                botonAvisoPrivacidad
                                        )
                        )

                        .addGroup(

                                distribucionPanel
                                        .createSequentialGroup()

                                        .addGap(225)

                                        .addComponent(
                                                botonSiguiente,
                                                GroupLayout.PREFERRED_SIZE,
                                                150,
                                                GroupLayout.PREFERRED_SIZE
                                        )
                        )
        );

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
                                                panelDesplazamiento,
                                                GroupLayout.PREFERRED_SIZE,
                                                220,
                                                GroupLayout.PREFERRED_SIZE
                                        )

                                        .addGap(18)

                                        .addGroup(

                                                distribucionPanel
                                                        .createParallelGroup(
                                                                GroupLayout.Alignment.BASELINE
                                                        )

                                                        .addComponent(
                                                                casillaAceptacion
                                                        )

                                                        .addComponent(
                                                                botonAvisoPrivacidad
                                                        )
                                        )

                                        .addGap(33)

                                        .addComponent(
                                                botonSiguiente,
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
                                panelAviso,
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
                                panelAviso,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE
                        )
        );

        pack();
    }

    private void cambiarEstadoBotonSiguiente() {

        botonSiguiente.setEnabled(
                casillaAceptacion.isSelected()
        );
    }

    private void siguienteVista() {

        DatosView ventanaDatosView = new DatosView();

        ventanaDatosView.setVisible(true);
        dispose();
    }

}
