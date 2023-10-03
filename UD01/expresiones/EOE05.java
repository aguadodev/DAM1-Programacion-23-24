package expresiones;

public class EOE05 {
    public static void main(String[] args) {
        // Declaración de variables y constantes
        int i = 8, j = 5;
        float x = 0.005F, y = -0.01F;
        char c = 'c', d = 'd';

        System.out.print("A: ");
        System.out.println(i <= j);

        System.out.print("B: ");
        System.out.println(c > d);

        System.out.print("C: ");
        System.out.println(x >= 0);

        System.out.print("D: ");
        System.out.println(x < y--);

        System.out.print("E: ");
        System.out.println(j != 6);

        System.out.print("F: ");
        System.out.println(c == 99);

        System.out.print("G: ");
        System.out.println(!(i <= j));

        System.out.print("H: ");
        System.out.println(!(c == 99));

        System.out.print("I: ");
        System.out.println(!(x > 0));

        System.out.print("J: ");
        System.out.println(-j == i - 13);

        System.out.print("K: ");
        System.out.println(++x > 0);

        System.out.print("L: ");
        System.out.println(y-- < 1);

        System.out.print("M: ");
        System.out.println(c > d || c > 0);

        System.out.print("N: ");
        System.out.println(5 * (i + j) > 'c');

        System.out.print("O: ");
        System.out.println(2 * x + y == 0);

        System.out.print("P: ");
        System.out.println();
        //System.out.println(2 * x + (y == 0));

        System.out.print("Q: ");
        System.out.println(x + y >= 0);

        System.out.print("R: ");
        System.out.println(x < ++y);

        System.out.print("S: ");
        System.out.println(-(i + j) != -i + j);


        
        System.out.print("T: ");
        System.out.println(i <= j);

        System.out.print("U: ");
        System.out.println(i <= j);

        System.out.print("V: ");
        System.out.println(i <= j);

        System.out.print("W: ");
        System.out.println(i <= j);

        System.out.print("X: ");
        System.out.println(i <= j);

        System.out.print("Y: ");
        System.out.println(i <= j);

        System.out.print("Z: ");
        System.out.println(i <= j);


        /*
         * i <= j && i >= c
         * i > 0 && j < 5
         * i > 0 || j < 5
         * x > y && i > 0 || j < 5
         * (3 * i – 2 * j) % (2 * d – c) > 3 * d
         * 2 * ((i / 5) + (4 * (j – 3)) % (i + j – 2)) >= 10
         * (i – 3 * j) % (c + 2 * d) / (x – y) >= 0
         */
    }

}
