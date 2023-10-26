package UD02.condicionalesapuntes;

import java.util.Scanner;

public class E0213 {
    public static void main(String[] args) {
        byte horas, minutos, segundos;

        Scanner sc = new Scanner(System.in);
        System.out.print("Hora (0-23): ");
        horas = sc.nextByte();
        System.out.print("Minutos (0-59): ");
        minutos = sc.nextByte();
        System.out.print("Segundos (0-59): ");
        segundos = sc.nextByte();
        sc.close();


        segundos++;
        if (segundos == 60) {
            segundos = 0;
            minutos++;
            if (minutos == 60) {
                minutos = 0;
                horas++;
                if (horas == 24) {
                    horas = 0;
                }
            }
        }

        String horaTexto = String.format("La hora incrementada en 1 segundo es %02d:%02d:%02d", horas, minutos, segundos);

        System.out.println(horaTexto);



    }
}
