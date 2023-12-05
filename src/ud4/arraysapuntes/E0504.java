package ud4.arraysapuntes;

public class E0504 {
    public static void main(String[] args) {
        // Declaración de variables y constantes
        int enteros[] = { 3, 5, 1, -9, -4, -6, 2 };

        // Proceso
        int maximo = maximo(enteros);

        // Salida
        System.out.println(maximo);
    }

    static int maximo(int t[]) {
        int maximo = t[0]; // Contiene el maximo valor encontrado hasta el momento

        for (int i = 1; i < t.length; i++) {
            if (t[i] > maximo) {
                maximo = t[i];
            }
        }

        return maximo;
    }

}
