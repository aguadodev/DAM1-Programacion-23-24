package ud4.examenud04rec;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class SumasTest {

    @Test
    void testSumas() {
        int[] arr = {1, -2, 3, -4, 5};
        int[] expected = {3, 9, -6};
        assertArrayEquals(expected, Sumas.sumas(arr));
    }

    @Test
    void testSumasWithNullArray() {
        assertNull(Sumas.sumas(null));
    }

    @Test
    void testSumasWithEmptyArray() {
        int[] arr = {};
        int[] expected = {0, 0, 0};
        assertArrayEquals(expected, Sumas.sumas(arr));
    }
}
