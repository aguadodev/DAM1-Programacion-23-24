package ud4.stringsapuntes;

import java.util.Scanner;

public class E0614 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String palabraOculta = "desenvolvemento";

        String anagrama = desordenar(palabraOculta);

        System.out.println("Anagrama = " + anagrama);

        System.out.print("Adivina la palabra oculta: ");
        String palabraUsuario = sc.nextLine();

        while (!palabraUsuario.equals(palabraOculta)) {

            if (palabraUsuario.isEmpty()){
                System.out.println("No se permite introducir cadenas vacías");
            }
            System.out.println("No has acertado. Prueba otra vez...");

            System.out.print("Adivina la palabra oculta: ");
            palabraUsuario = sc.nextLine();

        }

        System.out.println("Enhorabuena!! Has acertado!!");

    }

    private static String desordenar(String str) {
        char[] strAux = str.toCharArray();

        for (int i = 0; i < strAux.length; i++){
            int pos = (int) (Math.random()*str.length());
            char ch = strAux[i];
            strAux[i] = strAux[pos];
            strAux[pos] = ch;
        }

        return String.valueOf(strAux);
    }
}
