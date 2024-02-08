package varios.pendentes2324.ejercicio1;
/*
 Realiza un programa que reciba por teclado una frase y determine si es un palíndromo.
El programa no debe diferenciar mayúsculas de minúsculas ni tener en cuenta los
espacios en blanco de la frase que introduzca el usuario.
Un palíndromo es una frase que se lee igual de derecha a izquierda que de izquierda a
derecha. 
Ejemplos: 
- Ella te da detalle => Sí es palíndromo
- Di clase al Cid => NO es palíndromo
- Di clases al Cid => Sí es paíndromo
 * 
 */
import java.util.Scanner;

public class Palindromos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    
        System.out.print("Introduzca una frase y pulse Enter:");
        String frase = sc.nextLine();
        sc.close();

        String strIzquierda = "", strDerecha = "";
        for(int i = 0; i < frase.length(); i++){
            char ch = Character.toUpperCase(frase.charAt(i));
            if (!Character.isSpaceChar(ch)) {
                strIzquierda += ch;
                strDerecha = ch + strDerecha;    
            }
        }

        if (strIzquierda.equals(strDerecha))
            System.out.println("Es palíndromo");
        else
            System.out.println("No es palíndromo");   
    }

}
