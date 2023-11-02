package ud1.otrosejercicios;

public class EP0124 {
    public static void main(String[] args) {
        int horas = 20;
        int minutos = 45;
        int segundos = 34;

        int totalSegundos = segundos + minutos * 60 + horas * 60 * 60;

        System.out.println("Total de Segundos: " + totalSegundos);
    }
}
