package ud2.examen;

public class MinutosTranscurridos {
    public static void main(String[] args) {
        assert minutosTranscurridos(13, 20, 10, 10) == 190;
        assert minutosTranscurridos(13, 10, 10, 20) == 170;
        assert minutosTranscurridos(10, 10, 13, 20) == 190;
        assert minutosTranscurridos(10, 20, 13, 10) == 170;
        assert minutosTranscurridos(11, 20, 10, 10) == 70;
        assert minutosTranscurridos(11, 10, 10, 20) == 50;
        assert minutosTranscurridos(10, 10, 11, 20) == 70;
        assert minutosTranscurridos(10, 20, 11, 10) == 50;
        assert minutosTranscurridos(10, 10, 10, 10) == 0;
        assert minutosTranscurridos(10, 20, 10, 10) == 10;
        assert minutosTranscurridos(10, 10, 10, 20) == 10;
        assert minutosTranscurridos(10, 10, 10, 60) == -1;        
    }

    public static int minutosTranscurridos(int hora1, int minuto1, int hora2, int minuto2) {
        int minutos1 = hora1 * 60 + minuto1;
        int minutos2 = hora2 * 60 + minuto2;
        return Math.abs(minutos2 - minutos1);
    }
}
