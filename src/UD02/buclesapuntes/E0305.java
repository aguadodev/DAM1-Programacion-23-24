package ud02.buclesapuntes;

import java.util.Scanner;

public class E0305 {
    public static void main(String[] args) {
        // Declaración de variables y constantes
        final int NUM_MAXIMO = 100;
        int operando1;
        int operando2;
        int numUsuario;
        int numAciertos = 0;
        boolean falloUsuario = false;

        // Entrada de datos
        Scanner sc = new Scanner(System.in);
        System.out.println("CALCULO MENTAL: SUMAS");

        // Proceso
        do {
            // Obtener dos números aleatorios
            operando1 = (int) (Math.random() * NUM_MAXIMO + 1);
            operando2 = (int) (Math.random() * NUM_MAXIMO + 1);

            // Mostrar al usuario y pedir el resultado
            System.out.print(operando1 + " + " + operando2 + " = ? ");
            numUsuario = sc.nextInt();

            // Comparar suma con el resultado del usuario
            if (numUsuario == operando1 + operando2) {
                numAciertos++;
            } else {
                System.out.println("Error! El resultado era " + (operando1 + operando2));
                falloUsuario = true;
            }
        } while (!falloUsuario);

        // Salida
        System.out.println("Has conseguido " + numAciertos + " aciertos.");

        sc.close();
    }

}
