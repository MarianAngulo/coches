/**
 * This code has been adapted from this github repo:
 * https://github.com/unaguil/prog3-ejemplos-codigo/tree/master/tema1/tema1C
 * 
 * Thanks to: Unai Aguilera (https://github.com/unaguil) 
 */
package es.deusto.prog3.practica1c.format;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

// Este ejemplo muestra como utilizar las clases
// para mostrar fechas en distintos idiomas/locales.

public class EjemploLocale {

    public static void main(String[] args) {
        // Obtenemos la fecha/tiempo actual
        ZonedDateTime now = ZonedDateTime.now();

        // Escribimos por consola la fecha con formato de texto largo con locale actual.
        DateTimeFormatter formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        System.out.println(String.format("Fecha local: %s", formatter.format(now)));

        // Escribimos por consola la fecha con formato de texto largo en el locale italiano.
        formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.UK);
        System.out.println(String.format("Fecha United Kingdom: %s", formatter.format(now)));

        // Escribimos por consola la fecha con formato de texto largo en el locale italiano.
        formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.US);
        System.out.println(String.format("Fecha United States: %s", formatter.format(now)));

        // Escribimos por consola la fecha con formato de texto largo en el locale italiano.
        formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.ITALY);
        System.out.println(String.format("Fecha Italia: %s", formatter.format(now)));        
        
        // Escribimos por consola la fecha con formato de texto largo en con locale japonés.
        formatter = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL).withLocale(Locale.JAPAN);
        System.out.println(String.format("Fecha Japón: %s", formatter.format(now)));
    }
}