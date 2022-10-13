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

/////////////////
// ¡Atención! No se recomienda utilizar esta gestión
// de recursos a partir de Java 7. 
/////////////////

public class EjemploFileOutputStreamOld {

    public static void main(String[] args) {
        // Creamos el objeto FileOutputStream usando el constructor 
        // que recibe la ruta al fichero de salida.
        FileOutputStream fos = null;
        
        try {
            fos = new FileOutputStream("data/FileOutputStreamOld-output.txt");

            fos.write('H');
            fos.write('o');
            fos.write('l');
            fos.write('a');

        } catch (FileNotFoundException e) {
            // Si no se encuentra el fichero al intentar abrirlo
            System.err.println("No se pudo encontrar el fichero");
        } catch (IOException e) {
            // Si hay problemas al escribir en el fichero.
        } finally {
            // En cualquier caso, tanto si hay error como si no hay,
            // se comprueba si el stream está abierto y se cierra
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                	System.err.println("No se pudo cerrar el fichero");
                }
            }
        }
        
        System.out.println("La ejecución ha finalizado");
    }
}