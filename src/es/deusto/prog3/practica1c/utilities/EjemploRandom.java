/**
 * This code has been adapted from this github repo:
 * https://github.com/unaguil/prog3-ejemplos-codigo/tree/master/tema1/tema1C
 * 
 * Thanks to: Unai Aguilera (https://github.com/unaguil) 
 */
package es.deusto.prog3.practica1c.utilities;

import java.util.Random;

// En este ejemplo se muestran diferentes formas de generar
// números aleatorios. Se muestra que los números no son
// aleatorios sino pseudo-aleatorios.

public class EjemploRandom {

    public static void main(String[] args) {
        Random r = new Random();
        System.out.println("Generación de números aleatorios:");
        System.out.println(
				String.format(" - Tres enteros entre 0 y 99: %d, %d, %d", 
						r.nextInt(100), r.nextInt(100), r.nextInt(100))
		);
		System.out.println(
				String.format(" - Tres doubles entre 0 y 99: %.4f, %.4f, %.4f", 
						r.nextDouble(100), r.nextDouble(100), r.nextDouble(100))
		);

        r = new Random(15);//ponemos una semilla para forzar la secuencia

		System.out.println(
				String.format(" - Tres enteros entre 0 y 99 (semilla 15): %d, %d, %d", 
						r.nextInt(100), r.nextInt(100), r.nextInt(100))
		);

        r = new Random(17);//cambiando la semilla la secuencia cambia

		System.out.println(
				String.format(" - Tres enteros entre 0 y 99 (semilla 17): %d, %d, %d", 
						r.nextInt(100), r.nextInt(100), r.nextInt(100))
		);
		
        r = new Random(15);//con la misma semilla la secuencia se repite

		System.out.println(
				String.format(" - Tres enteros entre 0 y 99 (semilla 15): %d, %d, %d", 
						r.nextInt(100), r.nextInt(100), r.nextInt(100))
		);

    }
}