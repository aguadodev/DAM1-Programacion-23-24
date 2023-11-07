package ud2.practicas;

public class Dado {
    public static void main(String[] args) {
        int NUM_LANZAMIENTOS = 100;
        int c1 = 0, c2 = 0, c3 = 0, c4 = 0, c5 = 0, c6 = 0;

        for (int i = 0; i < NUM_LANZAMIENTOS; i++) {
            int valorDado = (int) (Math.random() * 6 + 1);
            switch (valorDado) {
                case 1 -> c1++;
                case 2 -> c2++;
                case 3 -> c3++;
                case 4 -> c4++;
                case 5 -> c5++;
                case 6 -> c6++;
            }
        }

        System.out.println("LANZANDO UN DADO " + NUM_LANZAMIENTOS + " VECES");
        System.out.println("\nRESULTADOS:");
        System.out.println("Ha salido 1: " + c1 + " veces (" + 100 * c1 / NUM_LANZAMIENTOS + "%)");
        System.out.println("Ha salido 2: " + c2 + " veces (" + 100 * c2 / NUM_LANZAMIENTOS + "%)");
        System.out.println("Ha salido 3: " + c3 + " veces (" + 100 * c3 / NUM_LANZAMIENTOS + "%)");
        System.out.println("Ha salido 4: " + c4 + " veces (" + 100 * c4 / NUM_LANZAMIENTOS + "%)");
        System.out.println("Ha salido 5: " + c5 + " veces (" + 100 * c5 / NUM_LANZAMIENTOS + "%)");
        System.out.println("Ha salido 6: " + c6 + " veces (" + 100 * c6 / NUM_LANZAMIENTOS + "%)");

    }

}
