/**
 * This code has been adapted from this github repo:
 * https://github.com/unaguil/prog3-ejemplos-codigo/tree/master/tema1/tema1C
 * 
 * Thanks to: Unai Aguilera (https://github.com/unaguil) 
 */

package es.deusto.prog3.practica1c.streams;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


// Este programa escribe 'Hola' caracter a caracter en un fichero.
// Esta es la manera recomendaba de gestionar los recursos a 
// partir de Java 7 gracias a la interfaz Closeable.

public class EjemploFileOutputStream {

    public static void main(String[] args) {
        // Creamos el objeto FileOutputStream usando el constructor 
        // que recibe la ruta al fichero de salida.

        try (FileOutputStream fos = new FileOutputStream("data/FileOutputStream-output.txt")) {

            fos.write('H');
            fos.write('o');
            fos.write('l');
            fos.write('a');

        } catch (FileNotFoundException e) {
            // Si no se encuentra el fichero al intentar abrirlo
            System.out.println("No se pudo encontrar el fichero");
        } catch (IOException e) {
            // Si hay problemas al escribir en el fichero.
            System.out.println("Hay problemas al escribir");
        }
        
        System.out.println("La ejecución ha finalizado");
    }
}