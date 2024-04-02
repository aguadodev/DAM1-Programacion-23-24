package ud6.coleccionesapuntes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class E1215 {

    public static void main(String[] args) {
        /*
         * Implementamos un mapa con un Tree5et que matiene un orden basado en los códigos
         */
        Map<String, Integer> existencias = new TreeMap<>();

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("existencias.dat"))) {
            existencias = (TreeMap<String, Integer>) in.readObject();
        } catch (IOException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }

        int opcion;
        do {
            System.out.println("1.Alta producto");
            System.out.println("2.Baja producto");
            System.out.println("3.Cambio stock de producto");
            System.out.println("4.Listar existencias");
            System.out.println("5.Salir");
            System.out.print("Opción: ");
            opcion = new Scanner(System.in).nextInt();

            switch (opcion) {
                case 1 -> {
                    System.out.print("Código producto: ");
                    String codigo = new Scanner(System.in).next();
                    /*
                     * Antes de dar de alta un código debemos asegurarnos de que no existe, ya que
                     * machacaría su valor:
                     */
                    if (!existencias.containsKey(codigo)) {
                        existencias.put(codigo, 0);
                    } else {
                        System.out.println("El producto ya existe");
                    }
                }
                case 2 -> {
                    System.out.print("Código producto: ");
                    String codigo = new Scanner(System.in).next();
                    existencias.remove(codigo);
                }
                case 3 -> {
                    System.out.print("Código producto: ");
                    String codigo = new Scanner(System.in).next();
                    System.out.print("Nuevo stock: ");
                    int stock = new Scanner(System.in).nextInt();
                    existencias.put(codigo, stock);
                }
                case 4 -> {
                    System.out.println(existencias);
                }
            }
        } while (opcion != 5);
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("existencias.dat"))) {
            out.writeObject(existencias);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
}
