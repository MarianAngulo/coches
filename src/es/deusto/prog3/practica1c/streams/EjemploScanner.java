/**
 * This code has been adapted from this github repo:
 * https://github.com/unaguil/prog3-ejemplos-codigo/tree/master/tema1/tema1C
 * 
 * Thanks to: Unai Aguilera (https://github.com/unaguil) 
 */
package es.deusto.prog3.practica1c.streams;

import java.util.Scanner;

// Este programa lee datos de la consola utilizando
// la clase Scanner que facilita la conversión de datos.

public class EjemploScanner {

    public static void main(String[] args) {
        // Creamos una instance de la clase y le pasamos
        // el stream de entrada de la consola
        try(Scanner sc = new Scanner(System.in)) {
            
            System.out.print("Indica tu nombre: ");
            String name = sc.nextLine();

            System.out.print("Indica tu edad: ");
            int age = sc.nextInt();

            System.out.println(
                String.format("Te llamas %s y tienes %d años", name, age)
            );
        }
    }
}