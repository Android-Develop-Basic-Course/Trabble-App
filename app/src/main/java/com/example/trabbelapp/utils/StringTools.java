package com.example.trabbelapp.utils;

import java.text.Normalizer;

public class StringTools {

    public static String stripAccents(String message)
    {
        /*Salvamos las ñ*/
        message = message.replace('ñ', '\001');
        message = message.replace('Ñ', '\002');
        message = Normalizer.normalize(message, Normalizer.Form.NFD);
        message = message.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        message = message.replaceAll("'", "");
        /*Volvemos las ñ a la cadena*/
        message = message.replace('\001', 'ñ');
        message = message.replace('\002', 'Ñ');

        return message;
    }

    public static String strip(String cadena) {
        String limpio =null;
        if (cadena !=null) {
            String valor = cadena;
            valor = valor.toUpperCase();
            // Normalizar texto para eliminar acentos, dieresis, cedillas y tildes
            limpio = Normalizer.normalize(valor, Normalizer.Form.NFD);
            // Quitar caracteres no ASCII excepto la enie, interrogacion que abre, exclamacion que abre, grados, U con dieresis.
            limpio = limpio.replaceAll("[^\\p{ASCII}(N\u0303)(n\u0303)(\u00A1)(\u00BF)(\u00B0)(U\u0308)(u\u0308)]", "");
            // Regresar a la forma compuesta, para poder comparar la enie con la tabla de valores
            limpio = Normalizer.normalize(limpio, Normalizer.Form.NFC);
        }
        return limpio;
    }
}
