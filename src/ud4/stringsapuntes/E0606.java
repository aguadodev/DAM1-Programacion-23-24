package ud4.stringsapuntes;

public class E0606 {

    public static void main(String[] args) {
        System.out.println(sinVocales("Álvaro Pérez"));
    }

    static String sinVocales(String cad) {
        String cadSinVocales = "";
        
        for (int i = 0; i < cad.length(); i++) {
            char ch = cad.charAt(i);
            if (!esVocal(ch))
                cadSinVocales += cad.charAt(i);
        }

        return cadSinVocales;
    }


    static final boolean esVocal(char ch) {
        String vocales = "aeiouAEIOUáéíóúüÁÉÍÓÚÜ";

        return vocales.contains(String.valueOf(ch));
    }

}
