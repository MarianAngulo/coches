/**
 * This code has been adapted from this github repo:
 * https://github.com/unaguil/prog3-ejemplos-codigo/tree/master/tema1/tema1C
 * 
 * Thanks to: Unai Aguilera (https://github.com/unaguil) 
 */
package es.deusto.prog3.practica1c.threads.swing;

import javax.swing.SwingUtilities;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


//En este ejemplo se lanza una tarea larga (contar hasta 100.000)
//dentro de un listener. Esto bloquea el thread de Swing y
//la UI deja de responder correctamente al usuario.

// ¡Atención! Esto es un ejemplo de cómo NO hacer las cosas.

public class EjemploSwingBloqueo extends JFrame {

    private static final long serialVersionUID = 1L;

    public EjemploSwingBloqueo() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(320, 80);
        this.setLocationRelativeTo(null);
        this.setTitle("Bloqueo de Swing");

        JButton button = new JButton("Haz click!!!");
        JPanel panel = new JPanel();

        panel.add(button);

        this.add(panel);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Este método imprime por pantalla números de 1 a 1 millón.
            	// La tarea bloquea la ventana porque se ejecuta desde el
            	// hilo principal de Swing.

                for (int i = 0; i < 1000000; i++) {
                    System.out.println(i);
                }
            }
        });

        this.setVisible(true);
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EjemploSwingBloqueo();
            }
        }); 
    }
}