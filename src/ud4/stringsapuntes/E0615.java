package ud4.stringsapuntes;

import java.util.Scanner;

public class E0615 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palabraOculta = "desenvolvemento";

        String anagrama = desordenar(palabraOculta);

        System.out.println("Anagrama = " + anagrama);

        System.out.print("Adivina la palabra oculta: ");
        String palabraUsuario = sc.nextLine();

        while (!palabraUsuario.equals(palabraOculta)) {

            if (palabraUsuario.isEmpty()) {
                System.out.println("No se permite introducir cadenas vacías");
            } else {
                System.out.println("Coinciden " + contarCoincidencias(palabraOculta, palabraUsuario) + " letras");
            }
            System.out.println("No has acertado. Prueba otra vez...");

            System.out.print("Adivina la palabra oculta: ");
            palabraUsuario = sc.nextLine();

        }
        sc.close();
        
        System.out.println("Enhorabuena!! Has acertado!!");
    }

    private static int contarCoincidencias(String str1, String str2) {
        int contarCoincidencias = 0;

        try {
            for (int i = 0; i < str1.length(); i++)
                if (str1.charAt(i) == str2.charAt(i))
                    contarCoincidencias++;
        } catch (Exception e) {
            // Controla la excepción de que el segundo String sea más corto
        }

        return contarCoincidencias;
    }

    private static String desordenar(String str) {
        char[] strAux = str.toCharArray();

        for (int i = 0; i < strAux.length; i++) {
            int pos = (int) (Math.random() * str.length());
            char ch = strAux[i];
            strAux[i] = strAux[pos];
            strAux[pos] = ch;
        }

        return String.valueOf(strAux);
    }
}
