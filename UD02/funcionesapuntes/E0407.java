package UD02.funcionesapuntes;

public class E0407 {
    public static void main(String[] args) {
        System.out.println(numDivisoresPrimos(4)); // 1
        System.out.println(numDivisoresPrimos(6)); // 2
        System.out.println(numDivisoresPrimos(10)); // 2
        System.out.println(numDivisoresPrimos(12)); // 2
        System.out.println(numDivisoresPrimos(20)); // 2
        System.out.println(numDivisoresPrimos(30)); // 3

    }

    static int numDivisoresPrimos(int n){
        int numDivisoresPrimos = 0;

        for(int i = 2; i < n; i++){
            if (n % i == 0 && esPrimo(i)) {
                numDivisoresPrimos++;
            }
        }

        return numDivisoresPrimos; 
    }


    static boolean esPrimo(int n) {
        boolean primo = true;
        int i = 2;
    
        while (i <= n/2 && primo) {
            if (n % i == 0) {
                primo = false;
            }
            i++;
        }
    
        return primo;
    }

}
