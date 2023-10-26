package ud02.condicionalesapuntes;

import java.util.Scanner;

public class Factura {
    public static void main(String[] args) {
        // Declaración de variables y constantes
        final double IVA = 0.21;
        final double UMBRAL_DESCUENTO = 100;
        final double DESCUENTO = 0.05;

        double precioProducto;
        int numUnidades;
        double precioSinIva;
        double iva;
        double precioConIva;
        double descuento;
        double precioFinal;

        // Entrada de datos
        Scanner sc = new Scanner(System.in);
        System.out.print("Precio del producto: ");
        precioProducto = sc.nextDouble();
        System.out.print("Número de unidades: ");
        numUnidades = sc.nextInt();
        sc.close();

        // Proceso
        precioSinIva = precioProducto * numUnidades;
        iva = precioSinIva * IVA;
        precioConIva = precioSinIva + iva;

        if (precioConIva > UMBRAL_DESCUENTO) {
            descuento = precioConIva * DESCUENTO;
            precioFinal = precioConIva - descuento;
        } else {
            precioFinal = precioConIva;
        }

        // Salida
        System.out.printf("Precio Final: %.2f € %n", precioFinal);
    }

}
