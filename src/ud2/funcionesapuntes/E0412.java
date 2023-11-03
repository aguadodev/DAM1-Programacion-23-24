package ud2.funcionesapuntes;

public class E0412 {
    public static void main(String[] args) {
        System.out.println(fibonacci(5));
    }

    static int fibonacci(int n){
        if (n == 1 || n == 0)
            return 1;
        else 
            return fibonacci(n-1) + fibonacci(n-2);
    }

}
