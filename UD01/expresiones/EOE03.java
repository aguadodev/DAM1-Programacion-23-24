package expresiones;

public class EOE03 {
    public static void main(String[] args) {
        // Declaración de variables y constantes
        int a=8, b=3, c=-5;

        System.out.println(a + b + c);
        System.out.println(2 * b + 3 * (a - c));
        System.out.println(a / b);
        System.out.println(a % b);
        System.out.println(a / c);
        System.out.println(a % c);
        System.out.println(a * b / c);
        System.out.println(a * (b / c));
        System.out.println((a * c) % b);
        System.out.println(a * (c % b));
        System.out.println((3 * a - 2 * b) % (2 * a - c));
        System.out.println(2 * ( a / 5 + (4 - b * 3)) % (a + c - 2));
        System.out.println((a - 3 * b) % (c + 2 * a) / (a - c));
        System.out.println(a - b - c * 2);
    }

}
/**
 * operadores
 */
public class operadores {

    public static void main(String[] args) {
        int i = 8, j = 5;
        float x = 0.005F, y = -0.01F;
        char c = 'c', d = 'd';

        System.out.println(i <= j);
        System.out.println();
/*
c > d
x >= 0
x < y--
j != 6
c == 99
!(i <= j)
!(c == 99)
!(x > 0)
*/
System.out.println(-j == i - 13);

/*
++x > 0
y-- < 1
c > d || c > 0
5 * (i + j) > 'c'
*/
System.out.println(2 * x + y == 0);
//System.out.println(2 * x + (y == 0));
/*
x + y  >= 0
x < ++y
*/
System.out.println(- (i + j) != -i + j);
/*
i <= j && i >= c
i > 0 && j < 5
i > 0 || j < 5
x > y && i > 0 || j < 5
(3 * i – 2 * j) % (2 * d – c) > 3 * d
2 * ((i / 5) + (4 * (j – 3)) % (i + j – 2)) >= 10
(i – 3 * j) % (c + 2 * d) / (x – y) >= 0
*/


    }
}