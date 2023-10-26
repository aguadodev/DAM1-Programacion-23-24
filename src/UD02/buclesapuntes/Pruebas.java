package ud02.buclesapuntes;

public class Pruebas {
    public static void main(String[] args) {
        int i = 1;
        while (i <= 3){
            System.out.println(i);
            i++;
        }

        // El cuerpo no se ejecutará
        while (i < 0) {
            System.out.println(i);
        }

        // Bucle infinito
        while (i <= 5) {
            System.out.println(i);
        }
    }
}
