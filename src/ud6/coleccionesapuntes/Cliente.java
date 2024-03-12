package ud6.coleccionesapuntes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

// Clase Cliente para ejemplos posteriores.
public class Cliente implements Comparable<Cliente> {
    String dni;
    String nombre;
    LocalDate fechaNacimiento;

    public Cliente(String dni, String nombre, String fechaNacimiento) {
        this.dni = dni;
        this.nombre = nombre;
        DateTimeFormatter formatoFechas = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try {
            this.fechaNacimiento = LocalDate.parse(fechaNacimiento, formatoFechas);
        } catch (Exception e) {
            this.fechaNacimiento = null;
        }
    }

    private int edad() {
        return (int) fechaNacimiento.until(LocalDate.now(), ChronoUnit.YEARS);
    }

    @Override
    public boolean equals(Object obj) {
        return dni.equals(((Cliente) obj).dni);
    }

    @Override
    public String toString() {
        return "DNI: " + dni + " Nombre: " + nombre + " Edad: " + edad() + " \n";
    }

    @Override
    public int compareTo(Cliente o) {
        return dni.compareTo(o.dni);
    }

}
