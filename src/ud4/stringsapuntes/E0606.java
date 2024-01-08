package ud4.stringsapuntes;

public class E0606 {

    static String sinVocales(String cad) {
        String cadSinVocales = "";
        String vocales = "aeiouAEIOUáéíóúüÁÉÍÓÚÜ";

        for (int i = 0; i < cad.length(); i++) {
            char ch = cad.charAt(i);
            if (!vocales.contains(String.valueOf(ch)))
                cadSinVocales += cad.charAt(i);
        }

        return cadSinVocales;
    }

}
