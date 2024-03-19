package ud6.coleccionesapuntes;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class E1214 {

    static List<Temperatura> listaTemperaturas = new ArrayList<>();

    public static void main(String[] args) {

        // Leer, si existe, el fichero de registros del día actual
        // 1. generar el nombre de fichero de temperaturas del día actual.
        String nombreArchivo = "registros-" + LocalDate.now() + ".dat";
        // 2. leerlo si existe.
        listaTemperaturas.addAll(leerTemperaturas(nombreArchivo));

        Scanner sc = new Scanner(System.in);
        mostrarMenuPrincipal();   
        int opcion = sc.nextInt();
        while (opcion != 0){
            switch (opcion) {
                case 1: nuevoRegistro(); break;
                case 2: listarRegistros(); break;
                case 3: mostrarEstadistica(); break;
            }

            mostrarMenuPrincipal();
            opcion = sc.nextInt();
        }

        guardarTemperaturas(listaTemperaturas);

    }

    /*
    Dada la clase Temperatura, implementa el método guardarTemperaturas(Collection<Temperatura> cT) que guarde una colección de temperaturas en un fichero binario cuya nombre sigue el siguiente patrón: "registros-yyyyMMdd.dat", siendo "yyyyMMdd" la fecha del día.
     */
    // Método para guardar una colección de temperaturas en un archivo binario
    static void guardarTemperaturas(Collection<Temperatura> cT) {
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();
        String nombreArchivo = "registros-" + fechaActual + ".dat";

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(nombreArchivo))) {
            // Escribir la colección de temperaturas en el archivo
            out.writeObject(cT);
            System.out.println("Se han guardado las temperaturas en el archivo: " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al guardar las temperaturas en el archivo: " + e.getMessage());
            e.printStackTrace();
        }
    } 

    static Collection<Temperatura> leerTemperaturas(String nombreArchivo) {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(nombreArchivo))) {
            // Leer la colección de temperaturas del archivo
            return (Collection<Temperatura>) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer las temperaturas del archivo: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }    

    private static void mostrarEstadistica() {
        Temperatura tMax = Collections.max(listaTemperaturas);
        Temperatura tMin = Collections.min(listaTemperaturas);
        Double tMedia = 0.0;
        for (Temperatura t : listaTemperaturas)
            tMedia += t.grados;
        tMedia /= listaTemperaturas.size();

        System.out.println("\nESTADÍSTICAS");
        System.out.println("============");    
        System.out.println("Temperatura Máxima: " + tMax);           
        System.out.println("Temperatura Mínima: " + tMin);           
        System.out.println("Temperatura Media: " + tMedia + "º");          
    }

    private static void listarRegistros() {
        System.out.println("\nLISTADO DE REGISTROS");
        System.out.println("====================");
        System.out.println(listaTemperaturas);
    }

    private static void nuevoRegistro() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nNUEVO REGISTRO");
        System.out.println("==============");
        System.out.print("Introduce la temperatura en grados centígrados: ");
        double grados = sc.nextDouble();
        listaTemperaturas.add(new Temperatura(grados, LocalTime.now()));
        System.out.println("Temperatura añadida\n");
    }

    private static void mostrarMenuPrincipal() {
        System.out.println("\nMENÚ PRINCIPAL - REGISTRO DE TEMPERATURAS");
        System.out.println("=========================================");        
        System.out.println("1. Nuevo registro");
        System.out.println("2. Listar registros");
        System.out.println("3. Mostrar estadística");
        System.out.println("0. Salir");
    }
}


class Temperatura implements Comparable<Temperatura>, Serializable {
    Double grados;
    LocalTime hora;

    public Temperatura(Double grados, LocalTime hora) {
        this.grados = grados;
        this.hora = hora;
    }

    @Override
    public String toString() {
        return hora + " - " + grados + "º";
    }

    @Override
    public int compareTo(Temperatura o) {
        return grados.compareTo(o.grados);
    }   
    
    
   

}
