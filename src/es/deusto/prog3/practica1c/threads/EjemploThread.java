/**
 * This code has been adapted from this github repo:
 * https://github.com/unaguil/prog3-ejemplos-codigo/tree/master/tema1/tema1C
 * 
 * Thanks to: Unai Aguilera (https://github.com/unaguil) 
 */

package es.deusto.prog3.practica1c.threads;
// Este ejemplo muestra cómo crear un nuevo hilo de ejecución para realizar una
// tarea de forma concurrente al hilo del programa principal.
// Se hace uso también del método Thread.sleep para dormir los hilos.

public class EjemploThread {

	public static void main(String[] args) {
		// Vamos a crear un thread para contar desde 10 a 0.
		// Además, el hilo se va a dormir después de imprimir cada
		// valor durante 1000 ms.
		// Este hilo usa la salida de error para diferenciar el color (rojo)
		// en la consola de eclipse
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 10; i >= 0; i--) {
					System.err.println(
							String.format("%s -> %d", Thread.currentThread().getName(), i)
					);
					
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) { }
				}
				
				System.err.println(
						String.format("%s -> finalizado", Thread.currentThread().getName())
				);
			}
		});

		// Al iniciar el thread y se invoca el método run()
		t.start();

		//El programa principal empieza a contar de 0 a 5
		//lo que se realizará de forma concurrente al hilo creado
		//después de cada número el hilo se detiene 1 segundo.
		for (int i = 0; i < 5; i++) {
			System.out.println(
					String.format("%s -> %d", Thread.currentThread().getName(), i)
			);

			try {
				//Se detiene el hilo principal 1seg.
				Thread.sleep(1000);
			} catch (InterruptedException e) { }
		}

		// Hasta que no terminen el hilo principal (main) y el hilo que
		// hemos creado, el programa sigue en ejecución.

		System.out.println("Hilo main terminado");
	}
}