package ud4;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class Matriculas {

    static boolean esMatriculaValida(String matricula) {
        return matricula == null ? false : matricula.matches("[0-9]{4}[BCDFGHJKLMNPQRSTVWXYZ]{3}");
    }

    static boolean esMatriculaValida2(String matricula) {
        boolean esMatriculaValida = true;

        if (matricula == null || matricula.length() != 7) {
            esMatriculaValida = false;
        } else {
            int i = 0;
            while (esMatriculaValida && i < 4) {
                if (!Character.isDigit(matricula.charAt(i)))
                    esMatriculaValida = false;
                i++;
            }

            while (esMatriculaValida && i < 7) {
                String letrasValidas = "BCDFGHJKLMNPQRSTVWXYZ";
                if (!letrasValidas.contains(matricula.substring(i, i + 1)))
                    esMatriculaValida = false;
                i++;
            }
        }
        return esMatriculaValida;
    }

    static String siguienteMatricula(String matricula) {
        String siguienteMatricula = null;

        if (esMatriculaValida(matricula)) {            
            // Incrementar números
                // 1. Convertir 4 caracteres a int
                // 2. Sumar 1
                // 3. Comprobar > 9999
                // 4. Convertir a String

            // Incrementar Letras
            String letrasValidas = "BCDFGHJKLMNPQRSTVWXYZ";
               // de chatAt(6) a charAt(4)
               // Si letra = "Z"
               //   letra = "B"
               //   incrementar siguiente;
               // Si no
               //   Incrementar Obtener siguiente letra

        }

        return siguienteMatricula;
    }

    static int comparaMatriculas(String m1, String m2) {
        return 0;
    }

    @Test
    void esMatriculaValidaTest() {
        assertTrue(esMatriculaValida("9876XYZ"));
        assertTrue(esMatriculaValida("5678XYZ"));
        assertTrue(esMatriculaValida("1234BBB"));
        assertTrue(esMatriculaValida("9999BBZ"));
        assertTrue(esMatriculaValida("9999BBD"));
        assertTrue(esMatriculaValida("9999ZZZ"));

        assertFalse(esMatriculaValida("1234ABC"));
        assertFalse(esMatriculaValida("1234AEI"));
        assertFalse(esMatriculaValida("ABCD123"));
        assertFalse(esMatriculaValida("1234ÑYZ"));
        assertFalse(esMatriculaValida("123"));
        assertFalse(esMatriculaValida("1234BBBB"));
        assertFalse(esMatriculaValida("12A4BBB"));
        assertFalse(esMatriculaValida("12.4BBB"));
        assertFalse(esMatriculaValida("1234BAB"));
        assertFalse(esMatriculaValida("1234BB."));
        assertFalse(esMatriculaValida("1234B5B"));
        assertFalse(esMatriculaValida("1234BúB"));
        assertFalse(esMatriculaValida("1234BÚB"));
        assertFalse(esMatriculaValida("1234BñB"));
        assertFalse(esMatriculaValida("1234BbB"));

        assertFalse(esMatriculaValida(""));
        assertFalse(esMatriculaValida(null));
    }

    @Test
    void siguienteMatriculaTest() {
        assertEquals(siguienteMatricula("1234BBB"), "1235BBB");
        assertEquals(siguienteMatricula("9999BBZ"), "0000BCB");
        assertEquals(siguienteMatricula("9999BBD"), "0000BBF");
        assertEquals(siguienteMatricula("9999ZZZ"), "0000BBB");
        assertEquals(siguienteMatricula(""), null);
        assertEquals(siguienteMatricula(null), null);
    }    

}
