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

    public Socio(int id, String nombre, String apellidos) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
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
        new Socio (5, "Juan", " "),
        new Socio (2, "SocioB", " "),
        new Socio (3, "Juan", " "),
        new Socio (1, "SocioA", " "),
        new Socio (8, "Juan", " "),
        new Socio (6, "Juan", " "),
    };

    System.out.println(Arrays.deepToString(socios));

    Arrays.sort(socios);
    
    System.out.println();
    System.out.println(Arrays.deepToString(socios));

}

}
