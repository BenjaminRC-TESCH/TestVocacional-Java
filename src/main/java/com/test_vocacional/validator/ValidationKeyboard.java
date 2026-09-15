package com.test_vocacional.validator;

public class ValidationKeyboard {

    public ValidationKeyboard() {
    }

    public static boolean esLetraOEspacio(char caracter) {
        return Character.isLetter(caracter) || caracter == ' ';
    }

    public static boolean esDigito(char caracter) {
        return Character.isDigit(caracter);
    }

    public static boolean esLetra(char caracter) {
        return Character.isLetter(caracter);
    }
}
