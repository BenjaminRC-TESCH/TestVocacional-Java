package com.test_vocacional.view;

import com.test_vocacional.config.WindowConfig;
import com.test_vocacional.constant.Constants;
import com.test_vocacional.constant.SourceConstants;
import com.test_vocacional.constant.colors.ColorConstants;
import com.test_vocacional.constant.font.FontConstants;
import com.test_vocacional.controller.DatosController;
import com.test_vocacional.model.Estudiante;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Objects;
import javax.swing.*;

import com.test_vocacional.config.TextField;

/**
 *
 * @author BENJAMIN RAYON CORONA
 */
public class DatosView extends JFrame {

    private JPanel panelPrincipal;
    private JLabel etiquetaLogo;
    private JLabel etiquetaTitulo;
    private TextField campoNombre;
    private TextField campoEdad;
    private TextField campoGrado;
    private TextField campoGrupo;
    private TextField campoEspecialidad;
    private JButton botonSiguiente;

    private Estudiante estudiante;

    private final DatosController controlador;

    public DatosView() {

        initComponents();

        WindowConfig.configurar(
                this,
                600,
                500
        );

        controlador = new DatosController(this);
    }

    ///GETTERS
    public String getCampoNombre() {
        return campoNombre.getText();
    }

    public String getCampoEdad() {
        return campoEdad.getText();
    }

    public String getCampoGrado() {
        return campoGrado.getText();
    }

    public String getCampoGrupo() {
        return campoGrupo.getText();
    }

    public String getCampoEspecialidad() {
        return campoEspecialidad.getText();
    }

    ///MENSAJES
    public void mostrarMensaje(String mensaje, String titulo) {

        JOptionPane.showMessageDialog(
                this,
                mensaje,
                titulo,
                JOptionPane.WARNING_MESSAGE
        );
    }

    private void initComponents() {
        panelPrincipal = new JPanel();

        etiquetaLogo = new JLabel();
        etiquetaTitulo = new JLabel();

        campoNombre = new TextField();
        campoEdad = new TextField();
        campoGrado = new TextField();
        campoGrupo = new TextField();
        campoEspecialidad = new TextField();

        botonSiguiente = new JButton();

        configurarComponentes();
        configurarEventos();
        configurarLayout();
    }

    private void configurarComponentes(){
        panelPrincipal.setBackground(ColorConstants.BLANCO);

        etiquetaLogo.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource(SourceConstants.RUTA_LOGO_CETIS_96))));

        etiquetaTitulo.setFont(new Font(FontConstants.ROBOTO_BLACK, Font.PLAIN, 18));
        etiquetaTitulo.setText(Constants.TITULO_DATOS);

        campoNombre.setLabelText("Nombre");
        campoEdad.setLabelText("Edad");
        campoGrado.setLabelText("Grado");
        campoGrupo.setLabelText("Grupo");
        campoEspecialidad.setLabelText("Especialidad");

        botonSiguiente.setText(Constants.BOTON_SIGUIENTE_DATOS);
        botonSiguiente.setBackground(ColorConstants.ROJO_VINO);
        botonSiguiente.setForeground(ColorConstants.BLANCO);
        botonSiguiente.setBorder(null);
    }

    private void configurarEventos(){

        campoNombre.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                validarNombreTecla(evt);
            }
        });

        campoEdad.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                validadEdadTecla(evt);
            }
        });

        campoGrado.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                validarGradoTecla(evt);
            }
        });

        campoGrupo.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                validarGrupoTecla(evt);
            }
        });

        campoEspecialidad.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                validarEspecialidadTecla(evt);
            }
        });

        botonSiguiente.addActionListener(
                this::siguienteVista
        );
    }

    private void configurarLayout(){

        GroupLayout layout = new GroupLayout(panelPrincipal);

        panelPrincipal.setLayout(layout);


        layout.setHorizontalGroup(
                layout.createSequentialGroup()
                        .addGap(50)
                        .addGroup(
                                layout.createParallelGroup(
                                                GroupLayout.Alignment.CENTER
                                        )

                                        // Logo y título
                                        .addGroup(
                                                layout.createParallelGroup(
                                                                GroupLayout.Alignment.CENTER
                                                        )
                                                        .addComponent(etiquetaLogo)
                                                        .addComponent(etiquetaTitulo)
                                        )

                                        // Nombre
                                        .addGroup(
                                                layout.createParallelGroup()
                                                        .addComponent(
                                                                campoNombre,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                500,
                                                                GroupLayout.PREFERRED_SIZE
                                                        )
                                        )

                                        // Edad
                                        .addGroup(
                                                layout.createParallelGroup()
                                                        .addComponent(
                                                                campoEdad,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                500,
                                                                GroupLayout.PREFERRED_SIZE
                                                        )
                                        )

                                        // Grado y grupo
                                        .addGroup(
                                                layout.createSequentialGroup()

                                                        // Grado
                                                        .addGroup(
                                                                layout.createParallelGroup()
                                                                        .addComponent(
                                                                                campoGrado,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                240,
                                                                                GroupLayout.PREFERRED_SIZE
                                                                        )
                                                        )

                                                        .addGap(20)

                                                        // Grupo
                                                        .addGroup(
                                                                layout.createParallelGroup()
                                                                        .addComponent(
                                                                                campoGrupo,
                                                                                GroupLayout.PREFERRED_SIZE,
                                                                                240,
                                                                                GroupLayout.PREFERRED_SIZE
                                                                        )
                                                        )
                                        )

                                        // Especialidad
                                        .addGroup(
                                                layout.createParallelGroup(
                                                                GroupLayout.Alignment.CENTER
                                                        )
                                                        .addComponent(
                                                                campoEspecialidad,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                500,
                                                                GroupLayout.PREFERRED_SIZE
                                                        )
                                        )

                                        // Botón
                                        .addGroup(
                                                layout.createParallelGroup(
                                                                GroupLayout.Alignment.CENTER
                                                        )
                                                        .addComponent(
                                                                botonSiguiente,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                150,
                                                                GroupLayout.PREFERRED_SIZE
                                                        )
                                        )
                        )
        );

        // =========================================================
        // TAMAÑOS VERTICALES
        // =========================================================

        layout.setVerticalGroup(
                layout.createSequentialGroup()


                        // Logo
                        .addComponent(etiquetaLogo)
                        .addGap(15)

                        // Título
                        .addComponent(etiquetaTitulo)
                        .addGap(20)

                        // Nombre

                        .addComponent(
                                campoNombre,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE
                        )
                        .addGap(15)

                        // Edad

                        .addComponent(
                                campoEdad,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE
                        )
                        .addGap(15)

                        // Grado y grupo
                        .addGroup(
                                layout.createParallelGroup(
                                                GroupLayout.Alignment.CENTER
                                        )

                                        // Grado
                                        .addGroup(
                                                layout.createSequentialGroup()

                                                        .addComponent(
                                                                campoGrado,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE
                                                        )
                                        )

                                        // Grupo
                                        .addGroup(
                                                layout.createSequentialGroup()

                                                        .addComponent(
                                                                campoGrupo,
                                                                GroupLayout.PREFERRED_SIZE,
                                                                GroupLayout.DEFAULT_SIZE,
                                                                GroupLayout.PREFERRED_SIZE
                                                        )
                                        )
                        )
                        .addGap(15)

                        // Especialidad

                        .addComponent(
                                campoEspecialidad,
                                GroupLayout.PREFERRED_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.PREFERRED_SIZE
                        )
                        .addGap(30)

                        // Botón
                        .addComponent(
                                botonSiguiente,
                                GroupLayout.PREFERRED_SIZE,
                                30,
                                GroupLayout.PREFERRED_SIZE
                        )
                        .addGap(20)
        );

        // =========================================================
        // FRAME
        // =========================================================

        GroupLayout frameLayout = new GroupLayout(
                getContentPane()
        );

        getContentPane().setLayout(frameLayout);

        frameLayout.setHorizontalGroup(
                frameLayout.createParallelGroup(
                                GroupLayout.Alignment.CENTER
                        )
                        .addComponent(
                                panelPrincipal,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE
                        )
        );

        frameLayout.setVerticalGroup(
                frameLayout.createParallelGroup(
                                GroupLayout.Alignment.CENTER
                        )
                        .addComponent(
                                panelPrincipal,
                                GroupLayout.DEFAULT_SIZE,
                                GroupLayout.DEFAULT_SIZE,
                                Short.MAX_VALUE
                        )
        );

        getContentPane().add(panelPrincipal);

        pack();
    }

    ///EVENTOS TECLADO
    private void validarNombreTecla(KeyEvent evt) {
        if (!DatosController.validarNombre(evt.getKeyChar())) {
            evt.consume();
        }
    }

    private void validadEdadTecla(KeyEvent evt) {
        if(!DatosController.validarEdad(evt.getKeyChar(), campoEdad.getText())){
            evt.consume();
        }
    }

    private void validarGradoTecla(KeyEvent evt) {
        if(!DatosController.validarGrado(evt.getKeyChar(), campoGrado.getText())){
            evt.consume();
        }

    }

    private void validarGrupoTecla(KeyEvent evt) {
        if(!DatosController.validarGrupo(evt.getKeyChar(), campoGrupo.getText())){
            evt.consume();
        }
    }

    private void validarEspecialidadTecla(KeyEvent evt) {
        if(!DatosController.validarEspecialidad(evt.getKeyChar())){
            evt.consume();
        }
    }

    private void siguienteVista(ActionEvent evento) {

        controlador.procesarDatos();
    }

}

