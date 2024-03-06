package ud5.examenud05;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class AppLixoDeLuxo {

        static User user = null;

        static Objeto[] objetos = {
                        new ObjetoElectronico("Laptop", "Laptop en buen estado", "Calle Principal",
                                        new User("aguado"), LocalDateTime.of(2024, 2, 20, 10, 0), new User("igarcrodr"),
                                        LocalDateTime.of(2024, 2, 20, 13, 0), true, "Dell", "Inspiron"),
                        new ObjetoElectronico("Teléfono móvil", "Teléfono en buen estado", "Parque Central",
                                        null, LocalDateTime.of(2024, 2, 10, 20, 0), null, null, false, "Samsung",
                                        "Galaxy S20"),
                        new Ropa("Camisa", "Camisa de algodón", "Avenida Central",
                                        new User("aguado"), LocalDateTime.of(2024, 3, 3, 12, 0), null, null, false,
                                        "M"),
                        new Ropa("Pantalones", "Pantalones vaqueros", "Plaza Mayor",
                                        null, LocalDateTime.of(2024, 2, 21, 10, 0), null,
                                        LocalDateTime.of(2024, 2, 21, 12, 0), true, "32"),
                        new Mueble("Silla", "Silla de madera", "Biblioteca Pública",
                                        null, LocalDateTime.of(2024, 2, 28, 10, 0), null, null, false, "Madera", 80, 40,
                                        40, 8),
                        new Mueble("Mesa", "Mesa de centro", "Parque",
                                        null, LocalDateTime.of(2024, 1, 31, 10, 0), null, null, false, "Madera", 100,
                                        60, 60, 15),
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

                Scanner sc = new Scanner(System.in);
                // Mostrar Menú y leer opción
                mostrarMenuPrincipal();
                int opcion = sc.nextInt();

                while (opcion != 0) {
                        // Ejecutar opción
                        switch (opcion) {
                                case 1: // Iniciar sesión de usuario
                                        iniciarSesion();
                                        break;
                                case 2: // Publicar objeto encontrado
                                        publicarObjeto();
                                        break;
                                case 3: // Listar objetos publicados anónimamente
                                        listarObjetosAnonimos();
                                        break;
                                case 4: // Recoger objeto
                                        recogerObjeto();
                                        break;
                        }

                        // Mostrar Menú y leer opción
                        mostrarMenuPrincipal();
                        opcion = sc.nextInt();
                }

                System.out.println("Hasta luego");
        }

        private static void iniciarSesion() {
                Scanner sc = new Scanner(System.in);
                System.out.println("Nombre usuario: ");                
                String username = sc.nextLine();
                System.out.println("Contraseña: ");                
                String password = sc.nextLine();         
                user = User.loginUsuario(username, password);
                if (user == null) {
                        System.out.println("Error al iniciar sesión");
                } else {
                       menuUsuario(); 
                }
        }

        private static void menuUsuario() {
                Scanner sc = new Scanner(System.in);
                // Mostrar Menú y leer opción
                mostrarMenuUsuario();
                int opcion = sc.nextInt();

                while (opcion != 0) {
                        // Ejecutar opción
                        switch (opcion) {
                                case 1: // Publicar objeto encontrado
                                        publicarObjeto();
                                        break;
                                case 2: // Listar objetos publicados anónimamente
                                        listarObjetosAnonimos();
                                        break;
                                case 3: // Recoger objeto
                                        recogerObjeto();
                                        break;
                        }

                        // Mostrar Menú y leer opción
                        mostrarMenuUsuario();
                        opcion = sc.nextInt();
                }

                System.out.println("Cerrando sesión");
                user = null;
        }

        private static void publicarObjeto() {
                Scanner sc = new Scanner(System.in);
                Objeto obj = new Objeto();
                System.out.println("Nombre: ");                
                obj.nombre = sc.nextLine();
                System.out.println("Ubicación: ");                
                obj.ubicacion = sc.nextLine();
                obj.fechaHoraPublicacion = LocalDateTime.now();
                if (user != null) {
                        obj.usuarioPublicacion = user;
                }

                objetos = Arrays.copyOf(objetos, objetos.length + 1);
                objetos[objetos.length - 1] = obj;
                Arrays.sort(objetos, new CompFechaPublicado().reversed());
        }

        private static void recogerObjeto() {
                Scanner sc = new Scanner(System.in);
                System.out.println("Introduce el índice del objeto: ");
                int i = sc.nextInt();
                if (objetos[i].usuarioPublicacion == null && !objetos[i].recogido){
                        objetos[i].recogido = true;
                        objetos[i].fechaHoraRecogida = LocalDateTime.now();
                        System.out.println("Has recogido el objeto " + objetos[i].nombre + " con fecha " + objetos[i].fechaHoraRecogida);
                } else {
                        System.out.println("No puedes recoger ese objeto.");
                }
        }

        private static void listarObjetosAnonimos() {
                Arrays.sort(objetos, new CompFechaPublicado().reversed());

                for (int i = 0; i < objetos.length; i++){
                        if (objetos[i].usuarioPublicacion == null && !objetos[i].recogido) {
                                System.out.println("Objeto nº " + i);
                                objetos[i].mostrarDetalles();
                        }
                }
        }

        private static void mostrarMenuPrincipal() {
                System.out.println("=== MENÚ PRINCIPAL ===");
                System.out.println("1. Iniciar sesión de usuario");
                System.out.println("2. Publicar objeto encontrado");
                System.out.println("3. Listar objetos publicados anónimamente");
                System.out.println("4. Recoger objeto");
                System.out.println("0. SALIR");

                System.out.println("\nSeleccione una opción:");
        }

        private static void mostrarMenuUsuario() {
                System.out.println("=== MENÚ  DE USUARIO (" + user.getUsername() + ") ===");
                System.out.println("1. Publicar objeto encontrado");
                System.out.println("2. Listar objetos publicados");
                System.out.println("3. Recoger objeto");
                System.out.println("0. SALIR");

                System.out.println("\nSeleccione una opción:");
        }


}
