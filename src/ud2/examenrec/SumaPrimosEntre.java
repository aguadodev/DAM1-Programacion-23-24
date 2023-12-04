package ud2.examenrec;

public class SumaPrimosEntre {

    public static void main(String[] args) {
        // Ejemplo de uso
        int min = 10;
        int max = 20;

        int suma = sumaPrimosEntre(min, max);

        System.out.println("La suma de los números primos entre " + min + " y " + max + " es: " + suma);
    }

    static int sumaPrimosEntre(int min, int max) {
        int suma = 0;

        // Validar que min y max sean números positivos y que max sea mayor que min
        if (min < 0 || max < 0 || max <= min) {
            System.out.println("Ingrese números positivos y asegúrese de que max sea mayor que min.");
            return suma;
        }

        for (int i = min + 1; i < max; i++) {
            if (esPrimo(i)) {
                suma += i;
            }
        }

        return suma;
    }

    static boolean esPrimo(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
