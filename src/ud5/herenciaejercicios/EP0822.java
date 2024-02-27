package ud5.herenciaejercicios;

public class EP0822 {
    public static void main(String[] args) {
        EP0822 obj;
        for (int i = 0; i < 10000; i++){
            obj = new EP0822();
        }
    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Finalizando Objeto");
    }
    
}
