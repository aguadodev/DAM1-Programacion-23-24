package ud5.examenud05;

import java.time.LocalDateTime;
import java.util.Scanner;

public class AppLixoDeLuxoSolucion {

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

    private static User usuarioActual = null;

    public static void main(String[] args) {
        System.out.println("\nLIXO DE LUXO");
        System.out.println("============\n");

        Scanner scanner = new Scanner(System.in);

        mostrarMenuPrincipal();
        int opcion = scanner.nextInt();

        while (opcion != 0) {
            switch (opcion) {
                case 1:
                    iniciarSesion();
                    break;
                case 2:
                    // Publicar Objeto
                    break;
                case 3:
                    listarObjetosPublicados();
                    break;
                case 4:
                    // Recoger Objeto
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

            mostrarMenuPrincipal();
            opcion = scanner.nextInt();            
        }

        System.out.println("¡Hasta luego!");
    }


    private static void iniciarSesion() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nombre de usuario: ");
        String nombreUsuario = scanner.nextLine();
        System.out.print("Contraseña: ");
        String contrasena = scanner.nextLine();

        User user = User.loginUsuario(nombreUsuario, contrasena);

        if (user == null) {
            System.out.println("Usuario y/o contraseña no válidos");
        } else {
            menuUsuario(user);
        }


        //
    }

    private static void menuUsuario(User user) {
        Scanner scanner = new Scanner(System.in);

        mostrarMenuUsuario(user);
        int opcion = scanner.nextInt();

        while (opcion != 0) {
            switch (opcion) {
                case 1:
                    // Publicar Objeto
                    break;
                case 2:
                    listarObjetosPublicados();
                    break;
                case 3:
                    // Recoger Objeto
                    break;
                default:
                    System.out.println("Opción no válida. Inténtelo de nuevo.");
            }

            mostrarMenuUsuario(user);
            opcion = scanner.nextInt();            
        }
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\n=== MENÚ PRINCIPAL ===");
        System.out.println("1. Iniciar sesión de usuario");
        System.out.println("2. Publicar objeto encontrado");
        System.out.println("3. Listar objetos publicados anónimamente");
        System.out.println("4. Recoger objeto");
        System.out.println("0. SALIR");
        System.out.print("Seleccione una opción: ");
    }

    private static void mostrarMenuUsuario(User user) {
        System.out.println("\n=== MENÚ USUARIO (" + user.getUsername() + ") ===");
        System.out.println("1. Publicar objeto encontrado");
        System.out.println("2. Listar objetos publicados anónimamente");
        System.out.println("3. Recoger objeto");
        System.out.println("0. SALIR");
        System.out.print("Seleccione una opción: ");
    }    

    private static void publicarObjetoEncontrado() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nombre del objeto: ");
        String nombreObjeto = scanner.nextLine();
        System.out.print("Ubicación del objeto: ");
        String ubicacionObjeto = scanner.nextLine();
        System.out.print("Descripción detallada (opcional): ");
        String descripcion = scanner.nextLine();
        // ...
        System.out.println("Objeto publicado con éxito.");
    }



    private static void listarObjetosPublicados() {

    }

    private static void recogerObjeto() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el número de objeto que desea recoger: ");
        int numeroObjeto = scanner.nextInt();


    }
}
