package UD02.apuntes01;

import java.util.Scanner;

public class E0211 {
    public static void main(String[] args) {
        System.out.print("Introduce el número de día de la semana: ");

        int dia = new Scanner(System.in).nextInt();

        switch (dia) {
            case 1 -> 
                System.out.println("Lunes");
            case 2 ->
                System.out.println("Martes");
            case 3 ->
                System.out.println("Miércoles");
            case 4 ->
                System.out.println("Jueves");
            case 5 ->
                System.out.println("Viernes");
            case 6 ->
                System.out.println("Sábado");
            case 7 ->
                System.out.println("Domingo");
            default ->
                System.out.println("ERROR!!");
        }
    }
}
