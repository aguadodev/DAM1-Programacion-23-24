package ud4.stringsapuntes;

public class E0604 {

    static int contarEspacios(String cad) {
        int contEspacios = 0;

        for (int i = 0; i < cad.length(); i++) {
            if (Character.isWhitespace(cad.charAt(i))) {
            //if (cad.charAt(i) == ' ') {
                contEspacios++;
            }
        }

        return contEspacios;
    }

}
