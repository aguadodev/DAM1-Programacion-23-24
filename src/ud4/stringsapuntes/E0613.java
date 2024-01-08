package ud4.stringsapuntes;

public class E0613 {
    public static void main(String[] args) {
        // Declaración de variables y constantes
        String frase = "En un lugar de La Mancha.";
        int[] cuentaLetras = new int[26]; // Array de contadores para cada letra del abecedario

        // Recorremos la frase letra a letra
        for (int i = 0; i < frase.length(); i++) {
            char letra = frase.charAt(i);

            if (Character.isLetter(letra)) {
                // Si es una letra incrementamos el contador correspondiente
                letra = Character.toLowerCase(letra);
                // Si es una 'a' (97) incrementa cuentaLetras[0]
                // Si es una 'b' (98) incrementa cuentaLetras[1]
                int indiceArray = (int) letra - (int) 'a';
                cuentaLetras[indiceArray]++;
            }
        }

        // Recorre el array de contadores e imprime las posiciones > 0
        for (int i = 0; i < cuentaLetras.length; i++) {
            if (cuentaLetras[i] > 0) {
                System.out.print((char) (i + 'a') + ": " + cuentaLetras[i]);
                if (cuentaLetras[i] > 1) {
                    System.out.println(" veces");
                } else {
                    System.out.println(" vez");
                }
            }
        }
    }

}
