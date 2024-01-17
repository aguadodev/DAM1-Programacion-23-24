package ud4.practicas.agenda;

import java.util.Arrays;
import java.util.Scanner;

public class AppAgenda {
    static Persona[] agenda;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Tareas iniciales
        agenda = new Persona[0];

        // Mostrar repetidamente el menú hasta Salir
        mostrarMenu();
        System.out.print("Opción: ");
        int opcion = sc.nextInt();

        while (opcion != 0) {
            switch (opcion) {
                case 1 -> add();
                case 2 -> list();
                case 3 -> del();
                case 4 -> empty();
                case 5 -> search();
            }

            mostrarMenu();
            System.out.print("Opción: ");
            opcion = sc.nextInt();
        }

    }

    private static void search() {
        System.out.println("\n BUSCAR\n");

        if (agenda.length == 0)
            System.out.println("La agenda está vacía.");
        else {
            Scanner sc = new Scanner(System.in);
            System.out.print("Información a buscar: ");
            String str = sc.nextLine();

            for (int i = 0; i < agenda.length; i++) {
                if (agenda[i].getNombre().contains(str)
                        || agenda[i].getApellidos().contains(str)
                        || agenda[i].getTelefono().contains(str)
                        || agenda[i].getEmail().contains(str))
                    System.out.println(i + ". " + agenda[i]);
            }
        }

    }

    private static void empty() {
        System.out.println("\n VACIAR AGENDA\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("Seguro que quieres vaciar la agenda? (S/N)");
        char ch = sc.nextLine().charAt(0);
        if (Character.toLowerCase(ch) == 's')
            agenda = new Persona[0];
    }

    private static void del() {
        System.out.println("\n BORRAR CONTACTO\n");
        Scanner sc = new Scanner(System.in);
        System.out.print("Indice del contacto a borrar: ");
        int i = sc.nextInt();

        if (i >= 0 && i < agenda.length) {
            Persona[] agendaAux = Arrays.copyOf(agenda, agenda.length - 1);
            System.arraycopy(agenda, i + 1, agendaAux, i, agenda.length - i - 1);
            agenda = agendaAux;
        }

    }

    private static void list() {
        System.out.println("\n LISTADO DE CONTACTOS\n");
        if (agenda.length == 0)
            System.out.println("La agenda está vacía.");
        else {
            for (int i = 0; i < agenda.length; i++) {
                System.out.println(i + ". " + agenda[i]);
            }
        }
    }

    private static void add() {
        System.out.println("\n AÑADIR CONTACTO\n");
        Scanner sc = new Scanner(System.in);
        Persona p = new Persona();
        System.out.print("Nombre: ");
        p.setNombre(sc.nextLine());
        System.out.print("Apellidos: ");
        p.setApellidos(sc.nextLine());
        System.out.print("Teléfono: ");
        p.setTelefono(sc.nextLine());
        System.out.print("Correo electrónico: ");
        p.setEmail(sc.nextLine());

        agenda = Arrays.copyOf(agenda, agenda.length + 1);
        agenda[agenda.length - 1] = p;
    }

    private static void mostrarMenu() {
        System.out.println("\nAGENDA");
        System.out.println("======\n");
        System.out.println("1. Añadir contacto");
        System.out.println("2. Listar contactos");
        System.out.println("3. Eliminar contacto");
        System.out.println("4. Vaciar agenda");
        System.out.println("5. Buscar contacto");
        System.out.println("0. SALIR ");

    }
}
