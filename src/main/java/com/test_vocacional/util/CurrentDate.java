package com.test_vocacional.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CurrentDate {

    private static final String FORMATO_FECHA =
            "MM/dd/yyyy, hh:mm:ss a";

    public CurrentDate() {
    }

    public static String obtenerFechaActual() {

        DateTimeFormatter formato =
                DateTimeFormatter.ofPattern(
                        FORMATO_FECHA
                );

        return LocalDateTime.now()
                .format(formato);
    }
}
