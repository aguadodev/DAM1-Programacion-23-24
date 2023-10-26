package ud02.funcionesapuntes;

public class E0406 {
    public static void main(String[] args) {

        // Salida
        System.out.println(esPrimo(23));
        System.out.println(esPrimo(110));
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
