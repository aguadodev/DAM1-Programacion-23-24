package ud7.ficherosbinariosapuntes;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import ud7.ficherostextoapuntes.Socio;

public class SociosEjemplo {
    public static void main(String[] args) {

        System.out.println("Menu de socios (socios.dat): ");
        System.out.println("1. Ver Socios");
        System.out.println("2. Añadir Socio");
        System.out.println("0. Salir");
        Scanner sc = new Scanner(System.in);
        int opcion = sc.nextInt();
        switch (opcion) {
            case 1:
                System.out.println("Ver Socios");
                try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("socios.dat"))) {
                    while (true) {
                        Socio socio = (Socio) in.readObject();
                        System.out.println(socio);
                    }
                } catch (EOFException e) {
                    System.out.println("### Fin de fichero ###");
                } catch (Exception e) {
                    System.out.println("Excepción: " + e.getMessage());
                }
                break;
            case 2:
                System.out.println("Añadir Socio");
                Scanner sc2 = new Scanner(System.in);
                System.out.println("Introduce el id, nombre, dirección y fecha de alta del socio (dd/mm/aaaa): ");
                int id = sc2.nextInt();
                sc2.nextLine();
                String nombre = sc2.nextLine();
                String direccion = sc2.nextLine();
                String fecha = sc2.nextLine();
                Socio socio = new Socio(id, nombre, direccion, fecha);
                try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("socios.dat", true))) {
                    out.reset();
                    out.writeObject(socio);
                } catch (Exception e) {
                    System.out.println("Excepción: " + e.getMessage());
                }
                break;
            case 0:
                System.out.println("Salir");
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }

    }
}
