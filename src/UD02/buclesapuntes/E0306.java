package ud02.buclesapuntes;

import java.util.Scanner;

public class E0306 {
    public static void main(String[] args) {
        System.out.print("Número: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.close();


        for(int i = 1; i <= n; i++) {
            System.out.println(i);
        }
            
    }
}
