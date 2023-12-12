package ud3.examenud03;

import java.util.Scanner;

public class RecorridoAscensor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el piso inicial del ascensor: ");
        int pisoInicial = scanner.nextInt();

        Ascensor ascensor = new Ascensor(pisoInicial, 0, 9);

        int recorridoTotal = 0;

        System.out.print("Ingrese el piso desde el que llama al ascensor (-1 para finalizar): ");
        int pisoOrigen = scanner.nextInt();

        while (pisoOrigen != -1) {
            System.out.print("Ingrese el piso de destino: ");
            int pisoDestino = scanner.nextInt();

            // Utilizamos el ascensor para ir desde el pisoOrigen hasta el pisoDestino
            recorridoTotal += Math.abs(ascensor.getPisoActual() - pisoOrigen);
            ascensor.irAlPiso(pisoOrigen);

            recorridoTotal += Math.abs(ascensor.getPisoActual() - pisoDestino);
            ascensor.irAlPiso(pisoDestino);
            
            System.out.print("Ingrese el piso desde el que llama al ascensor (-1 para finalizar): ");
            pisoOrigen = scanner.nextInt();            
        }

        System.out.println("\nEl recorrido total del ascensor es: " + recorridoTotal + " pisos.");

        scanner.close();
    }
}
