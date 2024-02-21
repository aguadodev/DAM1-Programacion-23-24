package ud4.examenud04rec;

public class ConjugarVerbos {

    public static String[] conjugarPresente(String verbo) {
        // Implementación de la conjugación en Pretérito Perfecto Simple
        String[] presenteAr = { "o", "as", "a", "amos", "áis", "an" };
        String[] presenteEr = { "o", "es", "e", "emos", "éis", "en" };
        String[] presenteIr = { "o", "es", "e", "imos", "ís", "en" };

        String[] conjugaciones = null;

        if (verbo.endsWith("ar")) {
            conjugaciones = new String[6];
            for (int i = 0; i < 6; i++) {
                conjugaciones[i] = verbo.substring(0, verbo.length() - 2) + presenteAr[i];
            }
        } else if (verbo.endsWith("er")) {
            conjugaciones = new String[6];
            for (int i = 0; i < 6; i++) {
                conjugaciones[i] = verbo.substring(0, verbo.length() - 2) + presenteEr[i];
            }
        } else if (verbo.endsWith("ir")) {
            conjugaciones = new String[6];
            for (int i = 0; i < 6; i++) {
                conjugaciones[i] = verbo.substring(0, verbo.length() - 2) + presenteIr[i];
            }
        }

        return conjugaciones;
    }

    public static String[] conjugarTiempoVerbal(String verbo, String tiempoVerbal) {
        String[] conjugaciones;

        // Verificamos la terminación del verbo
        if (verbo.endsWith("ar") || verbo.endsWith("er") || verbo.endsWith("ir")) {
            if (tiempoVerbal.equals("Presente simple")) {
                conjugaciones = conjugarPresente(verbo);
            } else if (tiempoVerbal.equals("Pretérito perfecto simple")) {
                conjugaciones = conjugarPreteritoPerfectoSimple(verbo);
            } else if (tiempoVerbal.equals("Futuro simple")) {
                conjugaciones = conjugarFuturoSimple(verbo);
            } else {
                return null; // Tiempo verbal no válido
            }
        } else {
            return null; // Verbo no válido
        }

        return conjugaciones;
    }

    private static String[] conjugarPreteritoPerfectoSimple(String verbo) {
        // Implementación de la conjugación en Pretérito Perfecto Simple
        String[] pasadoAr = { "é", "aste", "ó", "amos", "ásteis", "aron" };
        String[] pasadoErIr = { "í", "iste", "ió", "imos", "ísteis", "ieron" };

        String[] conjugaciones = null;

        if (verbo.endsWith("ar")) {
            conjugaciones = new String[6];
            for (int i = 0; i < 6; i++) {
                conjugaciones[i] = verbo.substring(0, verbo.length() - 2) + pasadoAr[i];
            }
        } else if (verbo.endsWith("er") || verbo.endsWith("ir")) {
            conjugaciones = new String[6];
            for (int i = 0; i < 6; i++) {
                conjugaciones[i] = verbo.substring(0, verbo.length() - 2) + pasadoErIr[i];
            }
        }

        return conjugaciones;
    }

    private static String[] conjugarPretéritoPerfectoCompuesto(String verbo) {
        // Implementación de la conjugación en pretérito perfecto simple
        // Utiliza el participio regular del verbo más el presente del verbo "haber"
        String participio = obtenerParticipio(verbo);
        String[] conjugaciones = new String[6];
        String[] haberConjugado = { "he", "has", "ha", "hemos", "habéis", "han" };

        for (int i = 0; i < 6; i++) {
            conjugaciones[i] = haberConjugado[i] + " " + participio;
        }

        return conjugaciones;
    }

    private static String[] conjugarFuturoSimple(String verbo) {
        // Implementación de la conjugación en futuro simple
        String[] futuro = { "é", "ás", "á", "emos", "éis", "án" };

        String[] conjugaciones = null;

        if (verbo.endsWith("ar") || verbo.endsWith("er") || verbo.endsWith("ir")) {
            conjugaciones = new String[6];
            for (int i = 0; i < 6; i++) {
                conjugaciones[i] = verbo + futuro[i];
            }
        }

        return conjugaciones;
    }

    private static String obtenerParticipio(String verbo) {
        String participio = "";
        if (verbo.endsWith("ar")) {
            participio = verbo.substring(0, verbo.length() - 2) + "ado";
        } else if (verbo.endsWith("er") || verbo.endsWith("ir")) {
            participio = verbo.substring(0, verbo.length() - 2) + "ido";
        }
        return participio;
    }

}
