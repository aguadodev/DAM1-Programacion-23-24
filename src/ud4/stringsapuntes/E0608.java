package ud4.stringsapuntes;

import java.util.Scanner;

public class E0608 {
    static final String COMIENZO = "Javalín, javalón";
    static final String COLETILLA = "javalén, len, len";

    public static void main(String[] args) {
        // Declaración de variables y constantes
        Scanner sc = new Scanner(System.in);
        String frase;

        // Entrada de datos
        System.out.print("Cadena: ");
        frase = sc.nextLine();
        sc.close();

        if (esJavalandia(frase) && esDialecto(frase)) {
            System.out.println("Idioma y dialecto de Javalandia");
            System.out.println(traducirDialecto(traducirJavalandia(frase)));
        } else {
            if (esJavalandia(frase)) {
                System.out.println("Idioma de Javalandia");
                System.out.println(traducirJavalandia(frase));
            }

            if (esDialecto(frase)) {
                System.out.println("Dialecto de Javalandia");
                System.out.println(traducirDialecto(frase));
            }
        }
    }

    static boolean esJavalandia(String frase) {
        return frase.startsWith(COMIENZO);
    }

    static String traducirJavalandia(String frase) {
        return frase.substring(COMIENZO.length(), frase.length()).trim();
    }

    static boolean esDialecto(String frase) {
        return frase.endsWith(COLETILLA);
    }

    static String traducirDialecto(String frase) {
        return frase.substring(0, frase.length() - COLETILLA.length()).trim();
    }

}
