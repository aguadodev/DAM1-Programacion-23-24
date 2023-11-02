package ud2.funcionesapuntes;

public class E0405 {
    public static void main(String[] args) {
        // Proceso
        System.out.println(esVocal('á'));
        System.out.println(esVocal('é'));
        System.out.println(esVocal('í'));
        System.out.println(esVocal('ó'));
        System.out.println(esVocal('ú'));
        System.out.println(esVocal('Á'));
        System.out.println(esVocal('É'));
        System.out.println(esVocal('Í'));
        System.out.println(esVocal('Ó'));
        System.out.println(esVocal('Ú'));
        System.out.println(esVocal('f'));

        // Salida
    }

    static boolean esVocal(char letra) {
        return switch (letra) {
            case 'A', 'E', 'I', 'O', 'U', 'a', 'e', 'i', 'o', 'u',
                    'á', 'é', 'í', 'ó', 'ú', 'Á', 'É', 'Í', 'Ó', 'Ú' -> {
                yield true;
            }
            default -> {
                yield false;
            }
        };
    }

}
