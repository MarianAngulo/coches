/**
 * This code has been adapted from this github repo:
 * https://github.com/unaguil/prog3-ejemplos-codigo/tree/master/tema1/tema1C
 * 
 * Thanks to: Unai Aguilera (https://github.com/unaguil) 
 */
package es.deusto.prog3.practica1c.sockets;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;


// Este ejemplo muestra cómo crear un socket servidor y un socket de cliente
// El programa además hace uso de los argumentos del programa para poder pasar
// un parámetro por la línea de comandos para lanzarlo de una forma o de otra.

// ¡Atención! Este ejemplo no usa threads y el servidor se queda bloqueado hasta
// recibir un mensaje del cliente.

// Para lanzar el server: java es.deusto.prog3.cap03.api.EjemploSockets --server port
// Para lanzar el cliente: java es.deusto.prog3.cap03.api.EjemploSockets --client ip port


public class EjemploSocketsServer {


	private static final int PORT = 35500;
	
    public static void main(String[] args) {
        System.out.println(String.format("ServerSocket iniciado en el puerto %d esperando conexiones...", PORT));
        
        //Se inicia el ServerSocket, un Socket y los estreams IN/OUT.
        try (ServerSocket serverSocket = new ServerSocket(PORT); 
        	 Socket socket = serverSocket.accept();
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        	 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);) {            
        	
        	String request;
        	String response;
        	
        	System.out.println(
        			String.format("-> Conexión recibida desde el cliente HOST:%s - PORT:%d", socket.getLocalAddress(), socket.getLocalPort())
        	);
        	        	
        	do {
        		// Leemos el mensaje que llega desde el cliente
        		request = reader.readLine();
                System.out.println(String.format("-> Mensaje recibido desde el cliente: %s", request));
                 
                // Se responde al cliente con el mismo mensaje en mayúsculas
                response = request.toUpperCase();
                writer.println(response);
                System.out.println(String.format("<- El servidor responde: %s", response));
        	} while(!request.equalsIgnoreCase("EXIT"));

            System.out.println("Servidor finalizado!");

        } catch (Exception e) {
            System.err.println(String.format("Error en el proceso del servidor Socket: %s", e.getMessage()));
        }
    }
}