package ud2.examenrec;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SumaPrimosEntreTest {

    @Test
    void testSumaPrimosEntre() {
        assertEquals(0, SumaPrimosEntre.sumaPrimosEntre(1, 1));
        assertEquals(0, SumaPrimosEntre.sumaPrimosEntre(1, 2));
        assertEquals(0, SumaPrimosEntre.sumaPrimosEntre(2, 1));
        assertEquals(0, SumaPrimosEntre.sumaPrimosEntre(2, 2));
        assertEquals(0, SumaPrimosEntre.sumaPrimosEntre(30, 20));
        assertEquals(5, SumaPrimosEntre.sumaPrimosEntre(1, 5));
        assertEquals(17, SumaPrimosEntre.sumaPrimosEntre(0, 10));
        assertEquals(17, SumaPrimosEntre.sumaPrimosEntre(1, 10));
        assertEquals(31, SumaPrimosEntre.sumaPrimosEntre(5, 15));
        assertEquals(52, SumaPrimosEntre.sumaPrimosEntre(20, 30));
        assertEquals(77, SumaPrimosEntre.sumaPrimosEntre(1, 20));
        assertEquals(1060, SumaPrimosEntre.sumaPrimosEntre(1, 100));
        assertEquals(3167, SumaPrimosEntre.sumaPrimosEntre(100, 200));
        assertEquals(76127, SumaPrimosEntre.sumaPrimosEntre(1, 1000));
        assertEquals(200923, SumaPrimosEntre.sumaPrimosEntre(1000, 2000));
    }
}
