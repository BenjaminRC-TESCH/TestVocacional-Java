package com.test_vocacional.config;

import com.test_vocacional.constant.Constants;
import com.test_vocacional.constant.SourceConstants;

import java.awt.Dimension;
import java.util.Objects;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.WindowConstants;

public final class WindowConfig {

    private WindowConfig() {}

    public static void configurar(JFrame ventana, int ancho, int alto) {

        ventana.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        ventana.setTitle(Constants.TITULO_VENTANA);

        ventana.setIconImage(
                new ImageIcon(
                        Objects.requireNonNull(
                                WindowConfig.class
                                        .getResource(
                                                SourceConstants.RUTA_LOGO_CETIS_96
                                        )
                        )
                ).getImage()
        );

        // Tamaño de la ventana: ancho x alto
        ventana.setSize(new Dimension(ancho, alto));

        // Centrar la ventana
        ventana.setLocationRelativeTo(null);

        // Evitar que cambie de tamaño
        ventana.setResizable(false);
    }
}
