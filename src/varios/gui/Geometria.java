package varios.gui;

/**
 * Programa de ejemplo que utiliza las librerías Swing y Awt para dibujar un lienzo y figuras geométricas.
 */

import javax.swing.*;
import java.awt.*;

public class Geometria extends JFrame {

    public Geometria() {
        // Dibuja el lienzo y define sus características básicas
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String a[]) {
        new Geometria();
    }

    public void paint(Graphics g) {
        g.drawLine(50, 0, 0, 150); // Dibuja una línea
        g.drawOval(40, 40, 60, 60); // Dibuja un circulo
        g.drawRect(80, 60, 200, 200); // Dibuja un cuadrado
        g.drawRect(200, 100, 100, 200); // Dibuja un rectángulo
    }
}
