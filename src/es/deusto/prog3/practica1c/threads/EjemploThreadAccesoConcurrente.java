/**
 * This code has been adapted from this github repo:
 * https://github.com/unaguil/prog3-ejemplos-codigo/tree/master/tema1/tema1C
 * 
 * Thanks to: Unai Aguilera (https://github.com/unaguil) 
 */

package es.deusto.prog3.practica1c.threads;

import java.util.Arrays;
import java.util.Random;

// En este ejemplo se muestra que el acceso a datos compartidos
// debe estar protegido por un método synchronized.

// En el ejemplo existe una clase Registro que contiene un array de N posiciones
// Si una posición está a 0 significa que está vacía, si tiene un valor > 0,
// que está ocupada.

// Se crean N threads que concurrentemente escogen aleatoriamente posiciones
// libres y las reservan (se suma uno a la posición para reservarla).

// En este ejemplo, se han introducido varios threads para aumentar la probabilidad de
// dos o más de ellos modifiquen una misma posición a la vez.

// Para resolver este problema es necesario que los métodos que pueden
// modificar concurrentemente un dato sean marcados como synchronized.
// Eso hace que solamente un thread pueda entrar cada vez en el método.

public class EjemploThreadAccesoConcurrente {

    private static class Registry {
        
        private final static int SIZE = 10;
        private int[] values = new int[SIZE];
        
        public int getSize() {
            return Registry.SIZE;
        }

        // ESTE MÉTODO DEBE SER synchronized para que dos
        synchronized public void reserve(int pos) {
        	//Si la posición es igual a 0, está vacía.
        	if (values[pos] == 0) {
            	// Antes de reservar la posición se detiene el hilo 10 mseg.;
                // de esta forma se aumenta la probabilidad de que otro hilo
        		// quiera accerder a la misma posición de manera concurrente.
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) { }
                //Se aumenta el valor de la posición (para reservarla).
                values[pos] += 1;
                
    			System.out.println(
    					String.format("+ Posición %d reservada por %s", pos, Thread.currentThread().getName())
    			);
    		//Si la posición está ocupada se muestra un mensaje indicando el bloqueo.
            } else {
    			System.out.println(
    					String.format("- Posición %d ocupada %s no puede reservarla", pos, Thread.currentThread().getName())
    			);
            }
        }

        @Override
        public String toString() {
            return Arrays.toString(values);
        }

    }    

    // Esta clase es un hilo cuyo método run() genera un número aleatorio
    // y lo utiliza para reservar una posición del Registro.
    private static class Processor implements Runnable {

        private Registry registry;

        public Processor(Registry registry) {
            this.registry = registry;
        }

        @Override
        public void run() {
        	//Se genera un posición aleatoria entre 0 y el tamaño del registro.
            Random random = new Random();         
	    	int pos = random.nextInt(registry.getSize());
	    	//Se intenta reservar la posición.
	    	registry.reserve(pos);
        }
    }

    private static final int NUM_THREADS = Registry.SIZE * 3;
    
    public static void main(String[] args) {
        Registry registry = new Registry();
        Thread t;
        
        System.out.println("Registro al inicio: " + registry);

        //Se incian todos los Threads y se invoca el join() para esperar
        //a que todo terminen.
        for (int i = 0; i < NUM_THREADS; i++) {
            t = new Thread(new Processor(registry));
            t.start();
            
            try {
				t.join();
			} catch (InterruptedException e) {
			}
        }

        System.out.println("Registro al finalizar: " + registry);
    }
}