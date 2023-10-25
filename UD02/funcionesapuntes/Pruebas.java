package UD02.funcionesapuntes;

import java.util.Scanner;

public class Pruebas {

    public static void main(String[] args) {
        // Scanner Leer nombre.    
        Scanner sc = new Scanner(System.in);
        System.out.println("Nombre: ");
        String nombre = sc.nextLine();
        System.out.println("Número de saludos: ");
        int veces = sc.nextInt();
        saludar(nombre, veces);

        saludar("Marta");
        saludar(5);

        //saludar("María", 3);
        //saludar("Jaime", 5);
    }

    static void saludar(int numSaludos){
        for(int i = 0; i < numSaludos; i++){
            System.out.println("Hola!!!");
        }
    }

    static void saludar(String nombre){
        System.out.println("Hola " + nombre + "!!!");
    }

    static void saludar(String nombre, int numSaludos) {
        numSaludos = 5;
        for (int i = 0; i < numSaludos; i++) {
            int j = i + 1;
            System.out.println(j + ". Hola " + nombre + "!!!");
        }
    }

}
