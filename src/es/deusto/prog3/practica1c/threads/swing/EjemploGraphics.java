/**
 * This code has been adapted from this github repo:
 * https://github.com/unaguil/prog3-ejemplos-codigo/tree/master/tema1/tema1C
 * 
 * Thanks to: Unai Aguilera (https://github.com/unaguil) 
 */
package es.deusto.prog3.practica1c.threads.swing;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.Timer;


//Este ejemplo pinta un círculo negro que se mueve por la ventana y rebota
//en los bordes. Para ello se utiliza un Timer de Swing que modifica la
//posición del círculo cada 25 mseg.

//La ventana se ejecuta en un Thread independiente para que no se bloquee
//la interfaz.

public class EjemploGraphics extends JFrame {

    private static final long serialVersionUID = 1L;
    
    private Timer timer;
    private Canvas canvas;

    public EjemploGraphics() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(640, 480);
        this.setLocationRelativeTo(null);
        this.setTitle("Ejemplo Graphics 2D");

        canvas = new Canvas();
        add(canvas);

        this.setVisible(true);

        //Se crea el Timer que cada 40 mseg. modifica la posición
        //del círculo y repinta el lienzo.
        timer = new Timer(25, new ActionListener() {           
            @Override
            public void actionPerformed(ActionEvent e) {
                canvas.updatePos();
                canvas.repaint();
            }
        });

        timer.start();
    }

    public static void main(String args[]) {
        SwingUtilities.invokeLater(new Runnable() {            
            @Override
            public void run() {
                new EjemploGraphics();
            }
        });   
    }

    class Canvas extends JComponent {
        private static final long serialVersionUID = 1L;
        
        private int x = 0;
        private int y = 0;
        private int xSpeed = 5;
        private int ySpeed = 5;

        private final static int RADIUS = 10;

        public Canvas() {
        	this.setDoubleBuffered(true);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            
            Graphics2D graphics2D = (Graphics2D)g;

            graphics2D.setPaint(Color.BLACK);
            graphics2D.fillOval(x, y, RADIUS * 2, RADIUS * 2);
        }
        
        //Este método modifica la posición del círculo controlando
        //que no se salga de los límites del marco de la ventana.
        public void updatePos() {
            int rightSide = x + RADIUS * 2;
            int leftSide = x;
            int upSide = y;
            int bottomSide = y + RADIUS * 2;

            if (rightSide > getWidth() || leftSide < 0) {
                xSpeed = -xSpeed;
            }

            if (upSide < 0 || bottomSide > getHeight()) {
                ySpeed = -ySpeed;
            }

            x += xSpeed;
            y += ySpeed;
        }       
    }
}