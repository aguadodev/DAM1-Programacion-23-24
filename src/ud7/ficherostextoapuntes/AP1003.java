package ud7.ficherostextoapuntes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class AP1003 {
    public static void main(String[] args) {
        BufferedReader in = null;
        List<Jugador> jugadores = new ArrayList<>();

        try {
            in = new BufferedReader(new FileReader("src\\ud7\\ficherostextoapuntes\\Jugadores.txt"));

            String linea = in.readLine();
            while (linea != null) {
                Scanner sc = new Scanner(linea).useLocale(Locale.US);
                jugadores.add(new Jugador(sc.next(), sc.nextInt(), sc.nextDouble()));
                sc.close();
                linea = in.readLine();
            }
        } catch (FileNotFoundException e) {
            System.out.println("No se encuentra el archivo");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }

        if (jugadores.size() > 0) {
            System.out.println("LISTA DE JUGADORES:");
            for (Jugador j : jugadores) {
                System.out.println(j);
            }

            System.out.println();
            System.out.printf("Media de edad: %.2f años%n", Jugador.mediaEdad(jugadores));
            System.out.printf("Media de edad: %.2f metros%n", Jugador.mediaEstatura(jugadores));
            System.out.println();            
        } else {
            System.out.println("No hay jugadores que listar");
        }

    }
}

class Jugador {
    String nombre;
    int edad;
    double estatura;

    public Jugador(String nombre, int edad, double estatura) {
        this.nombre = nombre;
        this.edad = edad;
        this.estatura = estatura;
    }

    public static double mediaEstatura(List<Jugador> jugadores) {
        double media = 0;
        if (jugadores.size() > 0) {
            for (Jugador j : jugadores)
                media += j.estatura;
            media /= jugadores.size();
        }

        return media;
    }

    public static double mediaEdad(List<Jugador> jugadores) {
        double media = 0;
        if (jugadores.size() > 0) {
            for (Jugador j : jugadores)
                media += j.edad;
            media /= jugadores.size();
        }

        return media;
    }

    @Override
    public String toString() {
        return "Jugador [nombre=" + nombre + ", edad=" + edad + ", estatura=" + estatura + "]";
    }

}