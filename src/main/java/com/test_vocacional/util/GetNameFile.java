package com.test_vocacional.util;

public class GetNameFile {

    public GetNameFile() {
    }

    public static String obtenerNombreArchivo(String nombreAlumno) {

        String nombreLimpio =
                nombreAlumno
                        .toLowerCase()
                        .replaceAll(
                                "[\\\\/:*?\"<>|]",
                                "_"
                        );

        return nombreLimpio
                + " resultados test.pdf";
    }
}
