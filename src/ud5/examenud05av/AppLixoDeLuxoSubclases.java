package ud5.examenud05av;
import java.time.LocalDateTime;

public class AppLixoDeLuxoSubclases {

    static Objeto[] objetos = {
        new ObjetoElectronico("Laptop", "Laptop en buen estado", "Calle Principal",
                new User("aguado"), LocalDateTime.of(2024, 2, 20, 10, 0), new User("igarcrodr"),
                LocalDateTime.of(2024, 2, 20, 13, 0), true, "Dell", "Inspiron"),
        new ObjetoElectronico("Teléfono móvil", "Teléfono en buen estado", "Parque Central",
                null, LocalDateTime.of(2024, 2, 10, 20, 0), null, null, false, "Samsung", "Galaxy S20"),
        new Ropa("Camisa", "Camisa de algodón", "Avenida Central",
                new User("aguado"), LocalDateTime.of(2024, 3, 3, 12, 0), null, null, false, "M"),
        new Ropa("Pantalones", "Pantalones vaqueros", "Plaza Mayor",
                null, LocalDateTime.of(2024, 2, 21, 10, 0), null, LocalDateTime.of(2024, 2, 21, 12, 0), true, "32"),
        new Mueble("Silla", "Silla de madera", "Biblioteca Pública",
                null, LocalDateTime.of(2024, 2, 28, 10, 0), null, null, false, "Madera", 80, 40, 40, 8),
        new Mueble("Mesa", "Mesa de centro", "Parque",
                null, LocalDateTime.of(2024, 1, 31, 10, 0), null, null, false, "Madera", 100, 60, 60, 15),
        new Libro("Harry Potter", "Libro de fantasía", "Casa Abandonada",
                null, LocalDateTime.of(2024, 2, 20, 10, 0), new User("aguado"),
                LocalDateTime.of(2024, 2, 20, 12, 0), true, "Harry Potter", "J.K. Rowling"),
        new Libro("El Señor de los Anillos", "Libro de fantasía épica", "Callejón Oscuro",
                new User("aguado"), LocalDateTime.of(2024, 3, 5, 10, 0), null, null, false,
                "El Señor de los Anillos", "J.R.R. Tolkien")
};
    
    public static void main(String[] args) {
        System.out.println("\nLIXO DE LUXO");
        System.out.println("==============\n");

        // TO-DO: Implementar aplicación       
        for (int i = 0; i < objetos.length; i++) {
            System.out.println((i+1) + ". " + objetos[i]);
        }
        
        System.out.println();

    }
}
