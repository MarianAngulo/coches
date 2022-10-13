/**
 * This code has been adapted from this github repo:
 * https://github.com/unaguil/prog3-ejemplos-codigo/tree/master/tema1/tema1C
 * 
 * Thanks to: Unai Aguilera (https://github.com/unaguil) 
 */
package es.deusto.prog3.practica1c.streams;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

// Este programa escribe 'Hola' de una vez en un fichero.
// Para ello utiliza un BufferedWriter intermedio.

public class EjemploBufferedWriter {

    public static void main(String[] args) {
        // Ahora construimos varios objetos conectados para escribir
        // líneas de texto directamente a un stream de salida a fichero.

        try (BufferedWriter buffWriter = new BufferedWriter(new FileWriter("data/BufferedWriter-output.txt"))) {

           buffWriter.write("Hola");

        } catch (FileNotFoundException e) {
            // Si no se encuentra el fichero al intentar abrirlo
            System.err.println("No se pudo encontrar el fichero");
        } catch (IOException e) {
            // Si hay problemas al escribir en el fichero.
            System.err.println("Hay problemas al escribir");
        }
        
        System.out.println("La ejecución ha finalizado");
    }
}