package ud1.operadores;

import java.time.LocalDate;
import java.util.Scanner;

public class E0104b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Obtengo el año actual de la API
        int anhoActual = 0;
        
        anhoActual = LocalDate.now().getYear();

        System.out.print("Introduce el año de nacimiento: ");
        int anhoNacimiento;
        anhoNacimiento = sc.nextInt(); 
        sc.close();


        int edad = anhoActual - anhoNacimiento;
        
        System.out.println("Tienes " + edad + " años.");
    }
}
