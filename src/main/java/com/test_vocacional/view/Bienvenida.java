package com.test_vocacional.view;

import com.test_vocacional.config.WindowConfig;
import com.test_vocacional.constant.Constants;
import com.test_vocacional.constant.colors.ColorConstants;
import com.test_vocacional.constant.font.FontConstants;
import com.test_vocacional.constant.SourceConstants;

import javax.swing.JFrame;
import java.util.Objects;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

public class Bienvenida extends JFrame {

    private JButton botonComenzar;
    private JLabel etiquetaLogo;
    private JLabel etiquetaTitulo;
    private JLabel etiquetaSubtitulo;
    private JPanel panelBienvenida;

    public Bienvenida() {

        initComponents();

        WindowConfig.configurar(
                this,
                600,
                500
        );

        configurarPanel();
    }

    private void initComponents() {

        panelBienvenida = new JPanel();

        etiquetaLogo = new JLabel();
        etiquetaTitulo = new JLabel();
        etiquetaSubtitulo = new JLabel();
        botonComenzar = new JButton();

        configurarComponentes();
        configurarEventos();
        configurarLayout();
    }



    private void configurarPanel(){
        JPanelConFondo panelConFondo = new JPanelConFondo();

        panelConFondo.add(etiquetaLogo);
        panelConFondo.add(etiquetaTitulo);
        panelConFondo.add(etiquetaSubtitulo);
        panelConFondo.add(botonComenzar);

        setContentPane(panelConFondo);
    }


    private class JPanelConFondo extends JPanel {

        private final Image imagenFondo;

        public JPanelConFondo() {

            ImageIcon iconoFondo = new ImageIcon(
                    Objects.requireNonNull(
                            getClass().getResource(SourceConstants.RUTA_FONDO)
                    )
            );

            imagenFondo = iconoFondo.getImage();

            Dimension dimension = new Dimension(
                    iconoFondo.getIconWidth(),
                    iconoFondo.getIconHeight()
            );

            setPreferredSize(dimension);
            setMinimumSize(dimension);
            setMaximumSize(dimension);
            setSize(dimension);

            setLayout(null);
        }

        @Override
        protected void paintComponent(Graphics grafico) {

            super.paintComponent(grafico);

            grafico.drawImage(
                    imagenFondo,
                    0,
                    0,
                    this
            );
        }
    }



    private void configurarComponentes(){

        panelBienvenida.setBackground(ColorConstants.BLANCO);

        etiquetaLogo.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource(SourceConstants.RUTA_LOGO_CETIS_96_SECUNDARIO))));

        etiquetaTitulo.setFont(new Font(FontConstants.ROBOTO_BLACK, Font.PLAIN, 30));
        etiquetaTitulo.setForeground(ColorConstants.BLANCO);
        etiquetaTitulo.setText(Constants.TITULO_BIENVENIDO);

        etiquetaSubtitulo.setFont(new Font(FontConstants.ROBOTO_BLACK, Font.PLAIN, 30));
        etiquetaSubtitulo.setForeground(ColorConstants.BLANCO);
        etiquetaSubtitulo.setText(Constants.SUBTITULO_BIENVENIDO);

        botonComenzar.setBackground(ColorConstants.ROJO_VINO);
        botonComenzar.setForeground(ColorConstants.BLANCO);
        botonComenzar.setText(Constants.BOTON_COMENZAR_BIENVENIDO);
        botonComenzar.setBorder(null);

    }

    private void configurarEventos(){
        botonComenzar.addActionListener(
                this::comenzarTest
        );
    }

    private void configurarLayout(){
        // =====================================================
        // CONFIGURACIÓN DEL PANEL
        // =====================================================
        GroupLayout distribucionPanel = new GroupLayout(
                panelBienvenida
        );

        panelBienvenida.setLayout(distribucionPanel);

        // =====================================================
        // DISTRIBUCIÓN HORIZONTAL
        // =====================================================
        distribucionPanel.setHorizontalGroup(
                distribucionPanel.createParallelGroup(
                                GroupLayout.Alignment.CENTER
                        )
                        .addComponent(etiquetaLogo)
                        .addComponent(etiquetaTitulo)
                        .addComponent(etiquetaSubtitulo)
                        .addComponent(
                                botonComenzar,
                                GroupLayout.PREFERRED_SIZE,
                                150,
                                GroupLayout.PREFERRED_SIZE
                        )
        );

        // =====================================================
        // DISTRIBUCIÓN VERTICAL
        // =====================================================
        distribucionPanel.setVerticalGroup(
                distribucionPanel.createSequentialGroup()
                        .addGap(40)
                        .addComponent(etiquetaLogo)
                        .addGap(40)
                        .addComponent(etiquetaTitulo)
                        .addGap(18)
                        .addComponent(etiquetaSubtitulo)
                        .addGap(49)
                        .addComponent(
                                botonComenzar,
                                GroupLayout.PREFERRED_SIZE,
                                30,
                                GroupLayout.PREFERRED_SIZE
                        )
                        .addContainerGap(
                                150,
                                Short.MAX_VALUE
                        )
        );

        // =========================================================
        // CONFIGURACIÓN DEL LAYOUT PRINCIPAL
        // =========================================================
        GroupLayout distribucionVentana = new GroupLayout(
                getContentPane()
        );

        getContentPane().setLayout(distribucionVentana);

        // =========================================================
        // DISTRIBUCIÓN HORIZONTAL DE LA VENTANA
        // =========================================================
        distribucionVentana.setHorizontalGroup(
                distribucionVentana.createParallelGroup(
                                GroupLayout.Alignment.LEADING
                        )
                        .addComponent(
                                panelBienvenida,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE
                        )
        );

        // =========================================================
        // DISTRIBUCIÓN VERTICAL DE LA VENTANA
        // =========================================================
        distribucionVentana.setVerticalGroup(
                distribucionVentana.createParallelGroup(
                                GroupLayout.Alignment.LEADING
                        )
                        .addComponent(
                                panelBienvenida,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE
                        )
        );

        pack();
    }




    private void comenzarTest(ActionEvent evento) {

        Aviso ventanaAviso = new Aviso();

        ventanaAviso.setVisible(true);
        dispose();
    }
}


