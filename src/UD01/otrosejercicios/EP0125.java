package UD01.otrosejercicios;

public class EP0125 {
    public static void main(String[] args) {
        int totalSegundos = 74000 + 34;

        int horas, minutos, segundos;

        horas = totalSegundos / 3600;
        minutos = totalSegundos % 3600 / 60;
        segundos = totalSegundos % 60;

        System.out.println("horas: " + horas);
        System.out.println("minutos: " + minutos);
        System.out.println("segundos: " + segundos);

    }
}
