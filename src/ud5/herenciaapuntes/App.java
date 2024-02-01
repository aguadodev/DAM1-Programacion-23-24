package ud5.herenciaapuntes;

public class App {
    public static void main(String[] args) {

        Persona p = new Persona("Marta", (byte) 35, 1.70);

        Empleado e = new Empleado("Sancho", (byte) -25, 1.80, 1725.49);

        Cliente c = new Cliente("Juan", (byte) 40, 1.75, 12345);

        Estudiante es = new Estudiante("Marcos", 6, 7, 8);

        Persona[] gente = new Persona[4];
        gente[0] = p;
        gente[1] = e;
        gente[2] = c;
        gente[3] = es;

        for(Persona x : gente){
            System.out.println(x);
        }

        Cliente c2 = new Cliente("Juan", (byte) 40, 1.75, 12345);

        System.out.println(c == c2);
        System.out.println(c.equals(c2));
















        // 8.4.2
        /* Comparación de objetos Persona
        Persona a = new Persona("Claudia", 8, 1.20);
        Persona b = new Persona("Claudia", 8, 0);
        Persona c = new Persona("Pepe", 24, 1.89);

        /* Comparación de números reales */
        //System.out.println(5.6 + 5.8 == 5.7 * 2); // false debido a problemas de precisión de los números decimales
        
        /* Comparación de Arrays
        int[] array1 = {1, 2, 3};
        int[] array2 = {1, 2, 3};
        System.out.println(array1 == array2); // false
        system.out.println(Arrays.equals(array1, array2); // true
        */

        // 8.4.3
        // System.out.println("Hola".getClass().getName()); // java.lang.String
        // System.out.println("Hola".getClass().getSimpleName()); // String
        // System.out.println(Double.valueOf(5.6).getClass().getSuperclass().getName()); // java.lang.Number
    }
}
