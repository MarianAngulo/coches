/**
 * This code has been adapted from this github repo:
 * https://github.com/unaguil/prog3-ejemplos-codigo/tree/master/tema1/tema1C
 * 
 * Thanks to: Unai Aguilera (https://github.com/unaguil) 
 */
package es.deusto.prog3.practica1c.properties;

import java.util.Properties;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Este ejemplo muestra como leer un fichero de propiedades
// que puede contener cierta configuración del programa.

public class EjemploProperties {

    public static void main(String[] args) {
    	// Se abre el fichero de propiedades 
        try (FileReader reader = new FileReader("config/ejemplo.properties");) {
            // Se crea el objeto y se leen las propiedades del fichero
            Properties properties = new Properties();
            properties.load(reader);

            // Se obtienen todas las claves y se muestran por pantalla
            for (String key : properties.stringPropertyNames()) {
            	System.out.println(String.format("%s=%s", key, properties.get(key)));
            }
        } catch (IOException ioe) {
            System.err.println(String.format("No se pudo leer el fichero de propiedades %s", ioe.getMessage()));
            
            // Si el fichero de propuedades no existe, se crea
            Properties properties = new Properties();
            // Cada propiedad se almacena como un par CLAVE, VALOR
            properties.setProperty("database", "SQLite");
            properties.setProperty("data-dir", "data");
            properties.setProperty("config-dir", "config");
            properties.setProperty("log-dir", "log");
            
            try (FileWriter writer = new FileWriter("config/ejemplo.properties");) {
            	properties.store(writer, "Fichero de propiedades de ejemplo");
            	System.out.println("El fichero de propiedades se ha guardado correctamente");
            } catch (IOException ioe2) {
            	System.err.println(String.format("No se pudo leer el fichero de propiedades %s", ioe2.getMessage()));	
            }
        }
    }
}