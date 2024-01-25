package ud4.examenud04;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MontanaRusa {
    static int contarPicos(int[] alturas) {
        int contarPicos = 0;

        if (alturas != null && alturas.length > 2) {
            // Comprueba la primera casilla
            if (alturas[0] > alturas[1] && alturas[0] > alturas[alturas.length - 1]) {
                contarPicos++;
            }
            // Comprueba la última casilla
            if (alturas[alturas.length - 1] > alturas[alturas.length - 2] && alturas[alturas.length - 1] > alturas[0]) {
                contarPicos++;
            }
            // Comprueba el resto
            for (int i = 1; i < alturas.length - 1; i++) {
                if (alturas[i] > alturas[i - 1] && alturas[i] > alturas[i + 1]) {
                    contarPicos++;
                }
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

    @Test
    void testContarPicos_MontañaPequeña() {
        int[] alturas = { 3, 2 };
        assertEquals(0, contarPicos(alturas));
    }

    @Test
    void testContarPicos_MontañaDeUno() {
        int[] alturas = { 3 };
        assertEquals(0, contarPicos(alturas));
    }

    @Test
    void testContarPicos_MontañaVacía() {
        int[] alturas = {};
        assertEquals(0, contarPicos(alturas));
    }

}
