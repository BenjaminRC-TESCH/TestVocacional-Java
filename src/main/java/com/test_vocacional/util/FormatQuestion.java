package com.test_vocacional.util;

import java.util.ArrayList;
import java.util.List;

public class FormatQuestion {

    public FormatQuestion() {
    }

    public static String[] dividirTexto(String texto, int longitudMaxima) {

        List<String> lineas = new ArrayList<>();

        StringBuilder lineaActual = new StringBuilder();

        for (String palabra : texto.split(" ")) {

            int longitudNueva =
                    lineaActual.length()
                            + palabra.length()
                            + 1;

            if (longitudNueva <= longitudMaxima) {

                if (lineaActual.length() > 0) {
                    lineaActual.append(" ");
                }

                lineaActual.append(palabra);

            } else {

                lineas.add(lineaActual.toString());

                lineaActual.setLength(0);

                lineaActual.append(palabra);
            }
        }

        if (lineaActual.length() > 0) {
            lineas.add(lineaActual.toString());
        }

        return lineas.toArray(new String[0]);
    }
}
