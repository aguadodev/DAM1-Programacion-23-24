package ud4.stringsapuntes;

public class E0605 {
    public static void main(String[] args) {
        System.out.println(invertirCadena("Hola mundo"));
    }
    
    static String invertirCadena(String cad) {
        String cadInvertida = "";

        for (int i = cad.length() - 1; i >= 0; i--) {
            cadInvertida += cad.charAt(i);
        }

        return cadInvertida;
    }

}
