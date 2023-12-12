package ud3.examenud03;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AscensorTest {

    @Test
    public void testConstructores() {
        Ascensor ascensor1 = new Ascensor(3, 1, 10);
        assertEquals(3, ascensor1.getPisoActual());
        assertEquals(1, ascensor1.PLANTA_MAS_BAJA);
        assertEquals(10, ascensor1.PLANTA_MAS_ALTA);

        Ascensor ascensor2 = new Ascensor(5, 8);
        assertEquals(5, ascensor2.getPisoActual());
        assertEquals(5, ascensor2.PLANTA_MAS_BAJA);
        assertEquals(8, ascensor2.PLANTA_MAS_ALTA);

        Ascensor ascensor3 = new Ascensor();
        assertEquals(0, ascensor3.getPisoActual());
        assertEquals(-2, ascensor3.PLANTA_MAS_BAJA);
        assertEquals(9, ascensor3.PLANTA_MAS_ALTA);
    }

    @Test
    public void testConstructorConValoresIncorrectos() {
        // Constructor 1: piso actual fuera de los límites
        assertThrows(IllegalArgumentException.class, () -> new Ascensor(12, 1, 10));

        // Constructor 1: planta más baja mayor o igual que planta más alta
        assertThrows(IllegalArgumentException.class, () -> new Ascensor(5, 8, 5));

        // Constructor 2: planta más baja mayor o igual que planta más alta
        assertThrows(IllegalArgumentException.class, () -> new Ascensor(8, 8));

        // Constructor predeterminado: planta más baja mayor o igual que planta más alta
        assertThrows(IllegalArgumentException.class, () -> new Ascensor(8, 5));
    }    

    @Test
    public void testSubirOk() {
        Ascensor ascensor = new Ascensor(0, 0, 9);
        assertTrue(ascensor.subir());
        assertEquals(1, ascensor.getPisoActual());
    }

    @Test
    public void testSubirExcederLimite() {
        Ascensor ascensor = new Ascensor(9, 0, 9);
        assertFalse(ascensor.subir());
        assertEquals(9, ascensor.getPisoActual());
    }

    @Test
    public void testSubirN() {
        Ascensor ascensor = new Ascensor(0, 0, 9);
        assertTrue(ascensor.subirN(3)); // El ascensor sube correctamente
        assertEquals(3, ascensor.getPisoActual());
    }

    @Test
    public void testSubirNExcederLimite() {
        Ascensor ascensor = new Ascensor(0, 0, 9);
        assertFalse(ascensor.subirN(12)); // Intento de subir más allá del límite superior
        assertEquals(0, ascensor.getPisoActual()); // El ascensor debería mantenerse en el piso actual
    }

    @Test
    public void testBajarOk() {
        Ascensor ascensor = new Ascensor(5, 0, 9); // El ascensor se inicia en la planta 5
        assertTrue(ascensor.bajar()); // El ascensor baja 1 piso correctamente
        assertEquals(4, ascensor.getPisoActual());        
    }    

    @Test
    public void testBajarExcederLimite() {
        Ascensor ascensor = new Ascensor(0, 0, 9);
        assertFalse(ascensor.bajar()); // El ascensor ya está en la planta más baja
        assertEquals(0, ascensor.getPisoActual());
    }    

    @Test
    public void testBajarNOk() {
        Ascensor ascensor = new Ascensor(5, 0, 9); // El ascensor se inicia en la planta 5
        assertTrue(ascensor.bajarN(3)); // El ascensor baja 3 pisos correctamente
        assertEquals(2, ascensor.getPisoActual());        
    }

    @Test
    public void testBajarNExcederLimiteInferior() {
        Ascensor ascensor = new Ascensor(0, 0, 9);
        assertFalse(ascensor.bajarN(5)); // Intento de bajar más allá del límite inferior
        assertEquals(0, ascensor.getPisoActual()); // El ascensor debería mantenerse en el piso actual
    }

    @Test
    public void testIrAlPisoOk() {
        Ascensor ascensor = new Ascensor();
        assertTrue(ascensor.irAlPiso(5));
        assertEquals(5, ascensor.getPisoActual());
    }

    @Test
    public void testIrAlPisoFueraDeLimitesSuperiores() {
        Ascensor ascensor = new Ascensor();
        assertFalse(ascensor.irAlPiso(12)); // Piso fuera de los límites superiores
        assertEquals(0, ascensor.getPisoActual()); // El ascensor debería mantenerse en el piso actual
    }

    @Test
    public void testIrAlPisoFueraDeLimitesInferiores() {
        Ascensor ascensor = new Ascensor();
        assertFalse(ascensor.irAlPiso(-3)); // Piso fuera de los límites inferiores
        assertEquals(0, ascensor.getPisoActual()); // El ascensor debería mantenerse en el piso actual
    }

}
