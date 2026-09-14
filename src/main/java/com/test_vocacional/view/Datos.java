package com.test_vocacional.view;

import com.test_vocacional.config.WindowConfig;
import com.test_vocacional.constant.Constants;
import com.test_vocacional.constant.SourceConstants;
import com.test_vocacional.constant.colors.ColorConstants;
import com.test_vocacional.constant.font.FontConstants;
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
public class Datos extends JFrame {

    private JPanel panelPrincipal;
    private JLabel etiquetaLogo;
    private JLabel etiquetaTitulo;
    private TextField campoNombre;
    private TextField campoEdad;
    private TextField campoGrado;
    private TextField campoGrupo;
    private TextField campoEspecialidad;
    private JButton botonAceptar;

    private Estudiante estudiante;

    public Datos() {
        initComponents();

        WindowConfig.configurar(
                this,
                600,
                500
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

        campoNombre.setLabelText("Nombre");
        campoEdad.setLabelText("Edad");
        campoGrado.setLabelText("Grado");
        campoGrupo.setLabelText("Grupo");
        campoEspecialidad.setLabelText("Especialidad");

        botonAceptar = new JButton();

        configurarComponentes();
        configurarEventos();
        configurarLayout();


    }



    private void configurarComponentes(){

        panelPrincipal.setBackground(ColorConstants.BLANCO);

        etiquetaLogo.setIcon(new ImageIcon(Objects.requireNonNull(getClass().getResource(SourceConstants.RUTA_LOGO_CETIS_96))));

        etiquetaTitulo.setFont(new Font(FontConstants.ROBOTO_BLACK, Font.PLAIN, 18));
        etiquetaTitulo.setText(Constants.TITULO_DATOS);

        botonAceptar.setText(Constants.BOTON_ACEPTAR_DATOS);
        botonAceptar.setBackground(ColorConstants.ROJO_VINO);
        botonAceptar.setForeground(ColorConstants.BLANCO);
        botonAceptar.setBorder(null);
    }

    private void configurarEventos(){

        campoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldNombreKeyTyped(evt);
            }
        });

        campoEdad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldEdadKeyTyped(evt);
            }
        });


        campoGrado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldGradoKeyTyped(evt);
            }
        });

        campoGrupo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldGrupoKeyTyped(evt);
            }
        });

        campoEspecialidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                fieldEspecialidadKeyTyped(evt);
            }
        });

        botonAceptar.addActionListener(
                this::botonAceptarActionPerformed
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
                                                                botonAceptar,
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
                                botonAceptar,
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

    private void botonAceptarActionPerformed(ActionEvent evt) {

        if (!validarCampos()) {
            return;
        }

        String nombre = campoNombre.getText().trim();
        int edad = Integer.parseInt(campoEdad.getText().trim());
        int grado = Integer.parseInt(campoGrado.getText().trim());
        String grupo = campoGrupo.getText().trim();
        String especialidad = campoEspecialidad.getText().trim();

        estudiante = new Estudiante(
                nombre,
                edad,
                grado,
                grupo,
                especialidad
        );


        Instrucciones instrucciones = new Instrucciones(estudiante);
        instrucciones.setVisible(true);
        dispose();
    }

    private boolean validarCampos() {

        if (campoNombre.getText().trim().isEmpty()
                || campoEdad.getText().trim().isEmpty()
                || campoGrado.getText().trim().isEmpty()
                || campoGrupo.getText().trim().isEmpty()
                || campoEspecialidad.getText().trim().isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Completa todos los campos",
                    "Datos incompletos",
                    JOptionPane.INFORMATION_MESSAGE
            );

            return false;
        }

        if (!campoNombre.getText().trim()
                .matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {

            JOptionPane.showMessageDialog(
                    this,
                    "El nombre solamente puede contener letras",
                    "Nombre inválido",
                    JOptionPane.WARNING_MESSAGE
            );

            return false;
        }

        return true;
    }



    private void fieldNombreKeyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();

        if (!((c >= 'a' && c <= 'z') ||
                (c >= 'A' && c <= 'Z') ||
                c == ' ')) {
            evt.consume();
        }
    }

    private void fieldEdadKeyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        String text = campoEdad.getText();

        if ((c < '0' || c > '9') ||
                (text.length() >= 2 &&
                Integer.parseInt(text + c) > 99) ||
                (Integer.parseInt(text + c) == 0)) {

            evt.consume();
        }
    }

    private void fieldGradoKeyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        String text = campoGrado.getText();

        if ((c < '1' || c > '6') || (text.length() >= 1 && Integer.parseInt(text + c) > 6)) {
            evt.consume();
        }

    }

    private void fieldGrupoKeyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();
        String text = campoGrupo.getText();

        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) || (text.length() >= 1)) {
            evt.consume();
        }
    }

    private void fieldEspecialidadKeyTyped(java.awt.event.KeyEvent evt) {
        char c = evt.getKeyChar();

        if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || c == ' ')) {
            evt.consume();
        }
    }

}

