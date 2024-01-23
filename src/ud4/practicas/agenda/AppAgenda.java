package ud4.practicas.agenda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

import com.google.gson.Gson;

public class AppAgenda {
    static Persona[] agenda;
    final static String FICHERO_AGENDA = "agenda.json";

    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        // Tareas iniciales
        agenda = new Persona[0];
        importarAgenda(FICHERO_AGENDA);

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

        exportarAgenda(FICHERO_AGENDA);

    }

    private static void importarAgenda(String ficheroAgenda) {
        Gson gson = new Gson();
        
        String json = readFileToString(ficheroAgenda); // contenido JSON;
        agenda = gson.fromJson(json, Persona[].class);

    }

    private static void exportarAgenda(String ficheroAgenda) {
        Gson gson = new Gson();

        String json = gson.toJson(agenda);      
        
        writeStringToFile(json, ficheroAgenda);
        

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

    /**
     * Crea un fichero de texto con el contenido de un String
     * @param str
     * @param filePath
     */
    public static void writeStringToFile(String str, String filePath) {
        try {
          // Creamos un objeto FileWriter que nos permitirá escribir en el fichero
          FileWriter writer = new FileWriter(filePath);
    
          // Escribimos el String en el fichero
          writer.write(str);
    
          // Cerramos el fichero
          writer.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
      
    /**
     * Lee y carga el contenido de un fichero de texto a un String
     * @param filePath
     * @return
     */
    public static String readFileToString(String filePath) {
        StringBuilder fileContent = new StringBuilder();
        try {
            // Creamos un objeto FileReader que nos permitirá leer el fichero
            FileReader reader = new FileReader(filePath);
        
            // Creamos un buffer para leer el fichero de forma más eficiente
            BufferedReader buffer = new BufferedReader(reader);
        
            // Leemos el fichero línea a línea
            String line;
            while ((line = buffer.readLine()) != null) {
                // Vamos añadiendo cada línea al StringBuilder
                fileContent.append(line);
                // Añadimos un salto de línea al final de cada línea
                fileContent.append("\n");
            }
        
            // Cerramos el buffer y el fichero
            buffer.close();
            reader.close();
        } catch (IOException e) {
            System.out.println("No existe el fichero.");
            //e.printStackTrace();
        }
    
        // Devolvemos el contenido del fichero como un String
        return fileContent.toString();
    }


}
