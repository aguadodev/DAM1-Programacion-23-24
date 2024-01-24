package ud4.examenud04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MontanaRusa {
    static int contarPicos(int[] alturas) {
        int contarPicos = 0;

        for (int i = 0; i < alturas.length; i++) {
            if (i == 0) { // Comprueba la primera casilla
                if (alturas[i] > alturas[i + 1] && alturas[i] > alturas[alturas.length - 1]) {
                    contarPicos++;
                }
            } else if (i == alturas.length - 1) { // Comprueba la última casilla
                if (alturas[i] > alturas[i - 1] && alturas[i] > alturas[0]) {
                    contarPicos++;
                }
            } else if (alturas[i] > alturas[i - 1] && alturas[i] > alturas[i + 1]) {
                contarPicos++;
            }
        }

        return contarPicos;
    }

    @Test
    void testContarPicos_CasoBase() {
        int[] alturas = { 1, 2, 3, 2, 1 };
        assertEquals(1, contarPicos(alturas));
    }

    @Test
    void testContarPicos_MultiplesPicos() {
        int[] alturas = { 1, 2, 3, 2, 1, 0, 1, 2, 3, 2, 1 };
        assertEquals(2, contarPicos(alturas));
    }

    @Test
    void testContarPicos_PicoAlFinal() {
        int[] alturas = { 1, 2, 3, 4, 5 };
        assertEquals(1, contarPicos(alturas));
    }

    @Test
    void testContarPicos_PicoEnInicio() {
        int[] alturas = { 5, 4, 3, 2, 3, 4, 4 };
        assertEquals(1, contarPicos(alturas));
    }

    @Test
    void testContarPicos_MontañaCircularSinPicos() {
        int[] alturas = { 3, 2, 1, 2, 3 };
        assertEquals(0, contarPicos(alturas));
    }

    @Test
    void testContarPicos_MontañaCircularConVariosPicos() {
        int[] alturas = { 3, 2, 1, 2, 1, 2, 1, 2, 3 };
        assertEquals(2, contarPicos(alturas));
    }

}
