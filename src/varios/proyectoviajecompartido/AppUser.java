package varios.proyectoviajecompartido;

import varios.proyectoviajecompartido.modelo.User;
import varios.proyectoviajecompartido.modelo.Viaje;

public class AppUser {
    private static User usuarioLogueado = null; // Usuario logueado en la aplicación

    public static void main(String[] args) {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        int opcion;
        do {
            System.out.println("\nBienvenid@ a la aplicación de viajes compartidos");
            System.out.println("------------------------------------------------");
            System.out.println("1. Iniciar sesión de usuario");
            System.out.println("2. Registrar usuario");
            System.out.println("0. Salir");
            opcion = leerOpcion(0, 2);
            switch (opcion) {
                case 1:
                    System.out.println("\n>>> Inicio Sesión");
                    iniciarSesion();
                    break;
                case 2:
                    System.out.println("\n>>> Registrar usuario (Próximamente...)");
                    break;
                case 0:
                    System.out.println("XXX Hasta pronto");
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        } while (opcion != 0);

    }


    private static void iniciarSesion() {
        System.out.print("Introduce tu nombre de usuario: ");
        String username = System.console().readLine();
        System.out.print("Introduce tu contraseña: ");
        String password = System.console().readLine();
        usuarioLogueado = User.loginUsuario(username, password);
        if (usuarioLogueado != null) {
            System.out.println("\n>>>Inicio de sesión correcto");
            menuUsuario();
        } else {
            System.out.println("\n>>>Inicio de sesión incorrecto");
        }
    }


    private static void menuUsuario() {
        int opcion;
        do {
            System.out.println("\nViajes compartidos. Menú Usuario (" + usuarioLogueado + ")");
            System.out.println("------------------------------------------------");
            System.out.println("1. Ver viajes disponibles");
            System.out.println("2. Ver mis viajes");
            System.out.println("0. Cerrar sesión");
            opcion = leerOpcion(0, 2);
            switch (opcion) {
                case 1:
                    System.out.println(">>> Ver viajes disponibles");
                    verViajesDisponibles();
                    break;
                case 2:
                    System.out.println(">>> Ver mis viajes");
                    verMisViajes();
                    break;
                case 0:
                    System.out.println("XXX Cerrar sesión");
                    usuarioLogueado = null;
                    break;
                default:
                    System.out.println("Opción incorrecta");
                    break;
            }
        } while (opcion != 0);

    }


    private static void verMisViajes() {
        System.out.println("\nMis viajes");
        System.out.println("------------");

        for (Viaje viaje : Viaje.getViajes(usuarioLogueado)) {
            System.out.println(viaje);
        }        
    }


    private static void verViajesDisponibles() {
        System.out.println("\nViajes disponibles");
        System.out.println("------------------");

        for (Viaje viaje : Viaje.getViajesDisponibles()) {
            System.out.println(viaje);
        }
    }

    
    // Utilidad: Lee una opción válida del menú entre un número de opción mínimo y un máximo
    private static int leerOpcion(int min, int max) {
        int opcion = -1;
        System.out.print("Elige una opción: ");
        do {
            try {
                opcion = Integer.parseInt(System.console().readLine());
            } catch (NumberFormatException e) {
                System.out.println("Opción incorrecta");
                System.out.print("Elige una opción: ");
            }
        } while (opcion < min || opcion > max);

        return opcion;
    }

}
