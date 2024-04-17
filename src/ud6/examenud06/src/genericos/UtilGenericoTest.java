package genericos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

class UtilGenericoTest {

    @Test
    void sinRepetidos_debeEliminarElementosRepetidos() {
        List<Integer> listaConRepetidos = Arrays.asList(1, 2, 3, 1, 2, 4);
        Collection<Integer> resultado = UtilGenerico.sinRepetidos(listaConRepetidos);
        assertEquals(4, resultado.size());
        assertTrue(resultado.contains(1));
        assertTrue(resultado.contains(2));
        assertTrue(resultado.contains(3));
        assertTrue(resultado.contains(4));
        // Comprobar el orden
        int i = 1;
        for(Integer n : resultado) {
            assertEquals(n, i);
            i++;
        }
    }

    @Test
    void contarRepetidos_debeContarElementosRepetidos() {
        List<String> listaConRepetidos = Arrays.asList("a", "b", "c", "a", "b", "d", "a", "a");
        Map<String, Integer> resultado = UtilGenerico.contarRepetidos(listaConRepetidos);
        assertEquals(4, resultado.size());
        assertEquals(4, resultado.get("a"));
        assertEquals(2, resultado.get("b"));
        assertEquals(1, resultado.get("c"));
        assertEquals(1, resultado.get("d"));
    }

    @Test
    void iniciarMapa_debeInicializarMapaConClavesYValores() {
        Set<String> claves = new TreeSet<>(Arrays.asList("a", "b", "c", "d"));
        List<Integer> valores = Arrays.asList(1, 2, 3);
        Map<String, Integer> resultado = UtilGenerico.iniciarMapa(claves, valores);
        assertEquals(4, resultado.size());
        assertEquals(1, resultado.get("a"));
        assertEquals(2, resultado.get("b"));
        assertEquals(3, resultado.get("c"));
        assertNull(resultado.get("d"));
    }
}
