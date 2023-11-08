package ud2.practicas;

public class CalculadoraHumana {
    public static void main(String[] args) {

        // Declaración de variables y Constantes
        int MAX_ACIERTOS = 7;
        int VALOR_MAX_OPERANDO = 200;
        int num_aciertos = 0;
        int num_intentos = 0;
        int operando1, operando2, operador;

        // Inicialización del Juego
        // Genera el primer número aleatorio entre 2 y 200
        operando1 = random(2, 200);

        // Bucle principal del Juego
        while (num_aciertos < MAX_ACIERTOS) {

        }

        // Fin del Juego
    }

    /**
     * Obtiene un número entero aleatorio entre un número mínimo y un máximo, inclusives.
     * @param min
     * @param max
     * @return
     */
    private static int random(int min, int max) {
        return (int) (Math.random() * (max - min + 1) + min);
    }

}
