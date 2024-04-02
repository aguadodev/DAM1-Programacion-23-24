package ud6.coleccionesejercicios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;



public class EP1225 {
    public static void main(String[] args) {

        Map<String, Socio> club = new TreeMap<>();

        club = leerFichero("club.dat");

        Scanner sc = new Scanner(System.in);

        menuPrincipal();
        int opcion = sc.nextInt();

        while (opcion != 7) {
            switch (opcion) {
                case 1 -> {
                    sc.nextLine();
                    System.out.print("Apodo: ");
                    String apodo = sc.nextLine();
                    if (club.containsKey(apodo)) {
                        System.out.println("Ese \"apodo\" ya está ocupado por otr@ soci@.");
                    } else {
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Fecha Ingreso (aaaa-mm-dd): ");
                        LocalDate fechaIngreso = LocalDate.parse(sc.nextLine());
                        club.put(apodo, new Socio(apodo, nombre, fechaIngreso));
                        System.out.println("Se ha dado de alta el socio");
                    }
                }
                case 2 -> {
                    sc.nextLine();
                    System.out.print("Apodo: ");
                    String apodo = sc.nextLine();
                    if (club.remove(apodo) == null)
                        System.out.println("No existe un socio con ese apodo");
                }
                case 3 -> {
                    sc.nextLine();
                    System.out.print("Apodo: ");
                    String apodo = sc.nextLine();
                    if (club.containsKey(apodo)) {
                        // Actualizar datos
                        System.out.print("Nombre: ");
                        String nombre = sc.nextLine();
                        System.out.print("Fecha Ingreso (aaaa-mm-dd): ");
                        LocalDate fechaIngreso = LocalDate.parse(sc.nextLine());
                        club.put(apodo, new Socio(apodo, nombre, fechaIngreso));
                        System.out.println("Se ha actualizado el socio");                        
                    } else
                        System.out.println("No existe un socio con ese apodo");
                }
                case 4 -> {
                    System.out.println(club);
                }
                case 5 -> {
                    List<Socio> listaSocios = new ArrayList<>(club.values());
                    listaSocios.sort(new Comparator<Socio>() {

                        @Override
                        public int compare(Socio o1, Socio o2) {
                            return o1.fechaIngreso.compareTo(o2.fechaIngreso);
                        }
                    });

                    System.out.println(listaSocios);

                }
                case 6 -> {
                    sc.nextLine();
                    System.out.print("Listar socios anteriores el año...: ");
                    int anho = sc.nextInt();

                    Set<Map.Entry<String, Socio>> entradas = club.entrySet();

                    Iterator<Map.Entry<String, Socio>> it = entradas.iterator();
                    while(it.hasNext()){
                        Map.Entry<String, Socio> entrada = it.next();
                        if (entrada.getValue().fechaIngreso.isBefore(LocalDate.ofYearDay(anho, 1)))
                            System.out.println(entrada.getValue());
                    }
                }
            }

            menuPrincipal();
            opcion = sc.nextInt();
        }

        escribirFichero(club, "club.dat");
    }

    private static void escribirFichero(Map<String, Socio> club, String fichero) {
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream(fichero))) {
            out.writeObject(club);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private static Map<String, Socio> leerFichero(String fichero) {
        Map<String, Socio> club = new TreeMap<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(fichero))) {
            club = (TreeMap<String, Socio>) in.readObject();
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }

        return club;
    }

    static void menuPrincipal() {
        System.out.println("1. Alta socio.");
        System.out.println("2. Baja socio.");
        System.out.println("3. Modificación socio.");
        System.out.println("4. Listar socios por apodo.");
        System.out.println("5. Listar socios por antigüedad.");
        System.out.println("6. Listar los socios con alta anterior a un año nado.");
        System.out.println("7. Salir.");
    }

}

// Clase Socio
class Socio implements Comparable<Socio>, Serializable {
    String apodo;
    String nombre;
    LocalDate fechaIngreso;

    public Socio(String apodo, String nombre, LocalDate fechaIngreso) {
        this.apodo = apodo;
        this.nombre = nombre;
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public String toString() {
        return "(" + apodo + ") - " + nombre + ", fechaIngreso=" + fechaIngreso;
    }

    @Override
    public int compareTo(Socio o) {
        return apodo.compareTo(o.apodo);
    }
}
