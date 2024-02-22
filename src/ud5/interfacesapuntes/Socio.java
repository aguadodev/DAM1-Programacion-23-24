package ud5.interfacesapuntes;

import java.time.LocalDate;
import java.util.Arrays;

public class Socio implements Comparable {
    int id;
    String nombre;
    String apellidos;
    LocalDate fechaAlta;

    public Socio() {
    }

    public Socio(int id) {
        this.id = id;
    }

    public Socio(int id, String nombre, String apellidos) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    public Socio(int id, String nombre, String apellidos, LocalDate fechaAlta) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String toString() {
        return id + " - " + nombre + " " + apellidos;
    }

    @Override
    public int compareTo(Object o) {
        Socio otro = (Socio) o;

        int res = nombre.compareTo(otro.nombre);

        if (res == 0) {
            res = id - otro.id;
        }

        return res;
    }

@Override
    public boolean equals(Object obj) {
        return id == ((Socio) obj).id;
    }


public static void main(String[] args) {
    Socio[] socios = {
        new Socio (5, "Juan", "Alonso", LocalDate.of(2023, 2, 9)),
        new Socio (2, "Mara", "Martínez", LocalDate.of(2023, 2, 9)),
        new Socio (3, "Juan", "Salcedo", LocalDate.of(2022, 4, 7)),
        new Socio (1, "Julia", "López", LocalDate.of(2022, 2, 9)),
        new Socio (8, "Juan", "López", LocalDate.of(2023, 3, 17)),
        new Socio (6, "Juan", "Pardo", LocalDate.of(2024, 12, 19)),
        new Socio (9, "Mara", "Pardo", LocalDate.of(2024, 2, 9))
    };

    System.out.println(Arrays.deepToString(socios));

    Arrays.sort(socios);
    
    System.out.println();
    System.out.println(Arrays.deepToString(socios));

    System.out.println(Arrays.binarySearch(socios, new Socio(8, "Juan", null)));

}

}
