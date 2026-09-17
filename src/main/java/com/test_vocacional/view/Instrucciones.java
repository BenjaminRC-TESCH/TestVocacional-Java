package com.test_vocacional.view;

import com.test_vocacional.config.WindowConfig;
import com.test_vocacional.config.ScrollBarCustom;
import com.test_vocacional.constant.Constants;
import com.test_vocacional.constant.InstruccionesConstants;
import com.test_vocacional.constant.colors.ColorConstants;
import com.test_vocacional.constant.font.FontConstants;
import com.test_vocacional.model.Estudiante;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Instrucciones extends JFrame {

    private JTextPane textoInstrucciones;
    private JButton botonIniciar;
    private JLabel etiquetaTitulo;
    private JPanel panelAviso;
    private JScrollPane panelDesplazamiento;

    private Estudiante estudiante;

    public Instrucciones(Estudiante estudiante) {

        this.estudiante = estudiante;

        initComponents();

        WindowConfig.configurar(
                this,
                600,
                500
        );

        configurarInstrucciones();

    }

    private void initComponents() {

        panelAviso = new JPanel();
        etiquetaTitulo = new JLabel();
        panelDesplazamiento = new JScrollPane();
        textoInstrucciones = new JTextPane();
        botonIniciar = new JButton();

        configurarComponentes();
        configurarEventos();
        configurarLayout();
    }

    private void configurarComponentes() {

        // =====================================================
        // PANEL PRINCIPAL
        // =====================================================
        panelAviso.setBackground(ColorConstants.BLANCO);

        // =====================================================
        // TÍTULO
        // =====================================================
        etiquetaTitulo.setFont(new Font(FontConstants.ROBOTO_BLACK, Font.PLAIN, 24));
        etiquetaTitulo.setText(Constants.TITULO_INSTRUCCIONES);

        // =====================================================
        // TEXTO DEL AVISO
        // =====================================================
        panelDesplazamiento.setBorder(null);

        textoInstrucciones.setFont(new Font(FontConstants.ROBOT, Font.PLAIN, 14));

        panelDesplazamiento.setViewportView(textoInstrucciones);

        // =====================================================
        // BOTÓN INICIAR
        // =====================================================
        botonIniciar.setBackground(ColorConstants.ROJO_VINO);
        botonIniciar.setForeground(ColorConstants.BLANCO);
        botonIniciar.setText(Constants.BOTON_INICIAR_INSTRUCCIONES);
        botonIniciar.setBorder(null);
    }

    private void configurarEventos() {
        botonIniciar.addActionListener(
                this::iniciarTest
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

                                        .addGap(225)

                                        .addComponent(
                                                botonIniciar,
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

                                        .addGap(33)

                                        .addComponent(
                                                botonIniciar,
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

    private void configurarInstrucciones() {

        textoInstrucciones.setText(InstruccionesConstants.INSTRUCCIONES);
        textoInstrucciones.setCaretPosition(0);
        textoInstrucciones.setEditable(false);
        textoInstrucciones.setCursor(null);
        textoInstrucciones.setCaretColor(ColorConstants.BLANCO);

        SimpleAttributeSet atributosTexto = new SimpleAttributeSet();

        StyleConstants.setAlignment(atributosTexto, StyleConstants.ALIGN_JUSTIFIED);

        textoInstrucciones
                .getStyledDocument()
                .setParagraphAttributes(
                        0,
                        InstruccionesConstants.INSTRUCCIONES.length(),
                        atributosTexto,
                        false
                );

        panelDesplazamiento.setVerticalScrollBar(new ScrollBarCustom());

        panelDesplazamiento
                .getVerticalScrollBar()
                .setValue(0);

        getContentPane().setBackground(ColorConstants.BLANCO);
    }

    private void iniciarTest(ActionEvent evento) {

        Intereses intereses = new Intereses(estudiante);

        intereses.setVisible(true);
        dispose();
    }

}