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
import java.net.Socket;
import java.util.Scanner;


// Este ejemplo muestra la creación del lado cliente de un Socket.

public class EjemploSocketsCliente {
	private static final String HOST = "0.0.0.0";
	private static final int PORT = 35500;
	
    public static void main(String[] args) {
        //Se inicializa el Socket, los estreams IN/OUT y un scanner
        try (Socket socket = new Socket(HOST, PORT); 
        	 BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        	 PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);
             Scanner scanner = new Scanner(System.in);) {            
        	
        	String request;
        	String response;
        	
        	System.out.println(
        			String.format("-> Conexión establecida con el servidor HOST:%s - PORT:%d", socket.getLocalAddress(), socket.getLocalPort())
        	);
        	        	
        	do {
                // Leemos el mensaje desde teclaro y lo enviamos al servidor 
        		System.out.print("-> Mensaje para el servidor: ");
                request = scanner.nextLine();
                writer.println(request);
                
                // Se obtiene la respuesta del servidor y se muestra en la consola.
                response = reader.readLine();
                System.out.println(String.format("<- El servidor dice: %s", response));
        	} while(!request.equalsIgnoreCase("EXIT"));

            System.out.println("Cliente finalizado!");

        } catch (Exception e) {
            System.err.println(String.format("Error en el proceso del client Socket: %s", e.getMessage()));
        }
    }
}