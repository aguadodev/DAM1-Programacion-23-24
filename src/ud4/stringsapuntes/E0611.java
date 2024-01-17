package ud4.stringsapuntes;

public class E0611 {

    public static void main(String[] args) {
        char[] conjunto1 = {'e','i','k','m','p','q','r','s','t','u','v'};
        char[] conjunto2 = "pviumterkqs".toCharArray();

        String palabra = "PaquiTo";

        String palabraCodificada = codifica(conjunto1, conjunto2, palabra);

        System.out.println(palabraCodificada);
    }


    public static String codifica(char[] conjunto1, char[] conjunto2, String palabra) {
        String res = "";

        for(int i = 0; i < palabra.length(); i++){
            res += codifica(conjunto1, conjunto2, palabra.charAt(i));
        }

        return res;
    }


    public static char codifica(char conjunto1[],char conjunto2[], char c){
        char ch = ' ';

        int pos = String.valueOf(conjunto1).indexOf(Character.toLowerCase(c));

        if (pos == -1) {
            ch = c;
        } else {
            ch = conjunto2[pos];
        }

        return ch;

    }
}
