package ud4.stringsapuntes;

import java.util.Scanner;

public class E0601 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int codePoint = 0x0000; codePoint <= 0xffff; codePoint++) {
            String xxxx = Integer.toHexString(codePoint);
            System.out.println("\\u" + xxxx + ": " + (char) codePoint);
            if (codePoint % 16 == 0) {
                System.out.println("Pulsa ENTER para continuar...");
                sc.nextLine();
            }
        }
        sc.close();
    }
}
