package com.test_vocacional.view;

import com.test_vocacional.config.WindowConfig;
import com.test_vocacional.constant.Constants;
import com.test_vocacional.constant.colors.ColorConstants;
import com.test_vocacional.constant.font.FontConstants;
import com.test_vocacional.controller.ResultadoController;
import com.test_vocacional.model.Estudiante;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ResultadoView extends JFrame {

    private JButton botonAceptar;
    private JLabel etiquetaTitulo;
    private JPanel panelPrincipal;
    private JPanel panelResultados;

    private Estudiante estudiante;

    private final ResultadoController resultadoController;

    // =====================================================
    // CONSTRUCTOR
    // =====================================================

    public ResultadoView(Estudiante estudiante) {

        this.estudiante = estudiante;

        this.resultadoController =
                new ResultadoController();

        initComponents();

        crearResultados();

        WindowConfig.configurar(
                this,
                600,
                550
        );
    }

    // =====================================================
    // PROCESAR RESULTADOS
    // =====================================================

    private void crearResultados() {
        resultadoController.crearGrafico();
        resultadoController.calcularAreasIntereses();
        resultadoController.calcularAreasAptitudes();

        mostrarGrafico();
    }

    // =====================================================
    // MOSTRAR GRÁFICO
    // =====================================================

    private void mostrarGrafico() {

        JFreeChart chart = resultadoController.crearGrafico();

        ChartPanel panelGrafico =
                new ChartPanel(
                        chart,
                        false
                );

        panelGrafico.setPreferredSize(
                new Dimension(
                        550,
                        300
                )
        );

        panelResultados.setLayout(
                new BorderLayout()
        );

        panelResultados.add(
                panelGrafico,
                BorderLayout.CENTER
        );

        panelResultados.revalidate();
        panelResultados.repaint();
    }

    // =====================================================
    // INICIALIZAR COMPONENTES
    // =====================================================

    private void initComponents() {

        panelPrincipal = new JPanel();
        etiquetaTitulo = new JLabel();
        panelResultados = new JPanel();

        botonAceptar = new JButton();

        configurarComponentes();
        configurarEventos();
        configurarLayout();
    }

    // =====================================================
    // CONFIGURAR COMPONENTES
    // =====================================================

    private void configurarComponentes() {

        panelPrincipal.setBackground(
                ColorConstants.BLANCO
        );

        etiquetaTitulo.setFont(
                new Font(
                        FontConstants.ROBOTO_BLACK,
                        Font.PLAIN,
                        24
                )
        );

        etiquetaTitulo.setText(
                Constants.TITULO_RESULTADOS
        );

        panelResultados.setPreferredSize(
                new Dimension(
                        550,
                        300
                )
        );

        botonAceptar.setBackground(
                new Color(
                        105,
                        20,
                        50
                )
        );

        botonAceptar.setForeground(
                ColorConstants.BLANCO
        );

        botonAceptar.setText(
                Constants.BOTON_ACEPTAR_RESULTADOS
        );
    }

    // =====================================================
    // EVENTOS
    // =====================================================

    private void configurarEventos() {

        botonAceptar.addActionListener(
                this::aceptar
        );
    }

    // =====================================================
    // ACEPTAR
    // =====================================================

    private void aceptar(ActionEvent evento) {

        resultadoController.aceptar(
                estudiante
        );

        dispose();
    }

    // =====================================================
    // LAYOUT
    // =====================================================

    private void configurarLayout() {

        GroupLayout distribucionPanel =
                new GroupLayout(panelPrincipal);

        panelPrincipal.setLayout(
                distribucionPanel
        );

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

                        .addComponent(
                                etiquetaTitulo
                        )

                        .addGap(0)

                        .addComponent(
                                panelResultados,
                                GroupLayout.PREFERRED_SIZE,
                                300,
                                GroupLayout.PREFERRED_SIZE
                        )

                        .addGap(37)

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
                new GroupLayout(
                        getContentPane()
                );

        getContentPane().setLayout(
                distribucionVentana
        );

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
}