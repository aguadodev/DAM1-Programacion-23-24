package ud4.examenud04rec;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ConjugarVerbosTest {

    @Test
    public void testConjugarPresenteAr() {
        String verbo = "hablar";
        String[] conjugacionesEsperadas = {"hablo", "hablas", "habla", "hablamos", "habláis", "hablan"};
        assertArrayEquals(conjugacionesEsperadas, ConjugarVerbos.conjugarPresente(verbo));
    }

    @Test
    public void testConjugarPresenteEr() {
        String verbo = "comer";
        String[] conjugacionesEsperadas = {"como", "comes", "come", "comemos", "coméis", "comen"};
        assertArrayEquals(conjugacionesEsperadas, ConjugarVerbos.conjugarPresente(verbo));
    }

    @Test
    public void testConjugarPresenteIr() {
        String verbo = "vivir";
        String[] conjugacionesEsperadas = {"vivo", "vives", "vive", "vivimos", "vivís", "viven"};
        assertArrayEquals(conjugacionesEsperadas, ConjugarVerbos.conjugarPresente(verbo));
    }

    @Test
    public void testConjugarPresenteVerboNoValido() {
        String verbo = "sur";
        assertArrayEquals(null, ConjugarVerbos.conjugarPresente(verbo));
    }


    
    @Test
    public void testConjugarAr() {
        String verbo = "hablar";
        String[] conjugacionesPresente = {"hablo", "hablas", "habla", "hablamos", "habláis", "hablan"};
        String[] conjugacionesPasado = {"hablé", "hablaste", "habló", "hablamos", "hablásteis", "hablaron"};
        String[] conjugacionesFuturo = {"hablaré", "hablarás", "hablará", "hablaremos", "hablaréis", "hablarán"};
        assertArrayEquals(conjugacionesPresente, ConjugarVerbos.conjugarTiempoVerbal(verbo, "Presente simple"));
        assertArrayEquals(conjugacionesPasado, ConjugarVerbos.conjugarTiempoVerbal(verbo, "Pretérito perfecto simple"));
        assertArrayEquals(conjugacionesFuturo, ConjugarVerbos.conjugarTiempoVerbal(verbo, "Futuro simple"));
    }

    @Test
    public void testConjugarEr() {
        String verbo = "comer";
        String[] conjugacionesPresente = {"como", "comes", "come", "comemos", "coméis", "comen"};
        String[] conjugacionesPasado = {"comí", "comiste", "comió", "comimos", "comísteis", "comieron"};
        String[] conjugacionesFuturo = {"comeré", "comerás", "comerá", "comeremos", "comeréis", "comerán"};
        assertArrayEquals(conjugacionesPresente, ConjugarVerbos.conjugarTiempoVerbal(verbo, "Presente simple"));
        assertArrayEquals(conjugacionesPasado, ConjugarVerbos.conjugarTiempoVerbal(verbo, "Pretérito perfecto simple"));
        assertArrayEquals(conjugacionesFuturo, ConjugarVerbos.conjugarTiempoVerbal(verbo, "Futuro simple"));
    }

    @Test
    public void testConjugarIr() {
        String verbo = "vivir";
        String[] conjugacionesPresente = {"vivo", "vives", "vive", "vivimos", "vivís", "viven"};
        String[] conjugacionesPasado = {"viví", "viviste", "vivió", "vivimos", "vivísteis", "vivieron"};
        String[] conjugacionesFuturo = {"viviré", "vivirás", "vivirá", "viviremos", "viviréis", "vivirán"};
        assertArrayEquals(conjugacionesPresente, ConjugarVerbos.conjugarTiempoVerbal(verbo, "Presente simple"));
        assertArrayEquals(conjugacionesPasado, ConjugarVerbos.conjugarTiempoVerbal(verbo, "Pretérito perfecto simple"));
        assertArrayEquals(conjugacionesFuturo, ConjugarVerbos.conjugarTiempoVerbal(verbo, "Futuro simple"));
    }

    @Test
    public void testConjugarVerboNoValido() {
        assertArrayEquals(null, ConjugarVerbos.conjugarTiempoVerbal("sur", "Presente simple"));
        assertArrayEquals(null, ConjugarVerbos.conjugarTiempoVerbal("hablar", "Presente superperfecto"));
    }
















}

