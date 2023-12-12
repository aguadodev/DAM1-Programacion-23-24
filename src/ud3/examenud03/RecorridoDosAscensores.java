package ud3.examenud03;

import java.util.Scanner;

public class RecorridoDosAscensores {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el piso inicial del primer ascensor: ");
        int pisoInicial = scanner.nextInt();

        Ascensor ascensor = new Ascensor(pisoInicial, 0, 9);

        System.out.print("Ingrese el piso inicial del segundo ascensor: ");
        pisoInicial = scanner.nextInt();

        Ascensor ascensor2 = new Ascensor(pisoInicial, 0, 9);

        int recorridoTotal = 0;
        int recorridoTotal2 = 0;

        System.out.print("Ingrese el piso desde el que llama al ascensor (-1 para finalizar): ");
        int pisoOrigen = scanner.nextInt();

        while (pisoOrigen != -1) {
            System.out.print("Ingrese el piso de destino: ");
            int pisoDestino = scanner.nextInt();

            // Compara la distancia del pisoOrigen con la posición de los dos ascensores
            if (Math.abs(pisoOrigen - ascensor.getPisoActual()) <= Math.abs(pisoOrigen - ascensor2.getPisoActual())) {
                // Utilizamos el primer ascensor para ir desde el pisoOrigen hasta el
                // pisoDestino
                recorridoTotal += Math.abs(ascensor.getPisoActual() - pisoOrigen);
                ascensor.irAlPiso(pisoOrigen);

                recorridoTotal += Math.abs(ascensor.getPisoActual() - pisoDestino);
                ascensor.irAlPiso(pisoDestino);
            } else {
                // Utilizamos el segundo ascensor para ir desde el pisoOrigen hasta el
                // pisoDestino
                recorridoTotal2 += Math.abs(ascensor2.getPisoActual() - pisoOrigen);
                ascensor2.irAlPiso(pisoOrigen);

                recorridoTotal2 += Math.abs(ascensor2.getPisoActual() - pisoDestino);
                ascensor2.irAlPiso(pisoDestino);
            }

            System.out.print("Ingrese el piso desde el que llama al ascensor (-1 para finalizar): ");
            pisoOrigen = scanner.nextInt();

        }

        System.out.println("\nEl recorrido total del primer ascensor es: " + recorridoTotal + " pisos.");
        System.out.println("\nEl recorrido total del segundo ascensor es: " + recorridoTotal2 + " pisos.");

        scanner.close();
    }
}
