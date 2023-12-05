package ud4.arraysapuntes;

public class ValidarDNI {
    public static void main(String[] args) {
        System.out.println(esValidoDNI(23456346, 'F'));
        System.out.println(esValidoDNI(22726985, 'H'));
    }

    static boolean esValidoDNI(int numero, char letra) {
        char[] letrasDNI = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V',
                'H', 'L', 'C', 'K', 'E', };

        return letra == letrasDNI[numero % 23];
    }

}
