package ud5.interfacesejercicios.ep0913;

import java.util.Arrays;

public class Futbolista implements Comparable{
    String dni;
    String nombre;
    int edad;
    int numGoles;

    public Futbolista(String dni, String nombre, int edad, int numGoles) {
        this.dni = dni;
        this.nombre = nombre;
        this.edad = edad;
        this.numGoles = numGoles;
    }

    public Futbolista() {
    }

    @Override
    public String toString() {
        return "Futbolista [dni=" + dni + ", nombre=" + nombre + ", edad=" + edad + ", numGoles=" + numGoles + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Futbolista other = (Futbolista) obj;
        if (dni == null) {
            if (other.dni != null)
                return false;
        } else if (!dni.equals(other.dni))
            return false;
        return true;
    }

    @Override
    public int compareTo(Object o) {
        return dni.compareTo(((Futbolista) o).dni);
    }

    public static void main(String[] args) {
        Futbolista[] equipo = {
            new Futbolista("1111111", "Tristán", 21, 10),
            new Futbolista("3333333", "Mara", 25, 10),
            new Futbolista("2222222", "Fer", 18, 10),
            new Futbolista("5555555", "Laura", 24, 10),
            new Futbolista("4444444", "Gus", 27, 10)
        };

        System.out.println("EQUIPO DESORDENADO");
        System.out.println(Arrays.toString(equipo));

        System.out.println("EQUIPO ORDENADO POR DNI (ORDEN NATURAL)");
        Arrays.sort(equipo);
        System.out.println(Arrays.toString(equipo));

        System.out.println("EQUIPO ORDENADO POR NOMBRE");
        Arrays.sort(equipo, new ComparaNombre());
        System.out.println(Arrays.toString(equipo));

        System.out.println("EQUIPO ORDENADO POR EDAD");
        Arrays.sort(equipo, new ComparaEdad());
        System.out.println(Arrays.toString(equipo));



    }

    
}
