package model;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class PersonajeTest {

    Personaje p;

    @Before
    public void setUp() {
        p = new Personaje(null, "HUMANO");
    }

    @Test
    public void testGetNivelSegunPX() {
        p.setExperiencia(0);
        assertEquals(1, p.getNivelSegunPX());
        p.setExperiencia(101);
        assertEquals(2, p.getNivelSegunPX());
        p.setExperiencia(251);
        assertEquals(3, p.getNivelSegunPX());
        p.setExperiencia(451);
        assertEquals(4, p.getNivelSegunPX());
        p.setExperiencia(701);
        assertEquals(5, p.getNivelSegunPX());
    }
}
/*package model;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PersonajeTest {


    Personaje arturo;

    @Before
    public void setUpArturo() {
        arturo = new Personaje("Arturo", "HUMANO");
        // arturo.constitucion = 50;

        arturo.setMonedas(1500);

        arturo.addToInventario(new Item("Cota de Malla", 10, 2000));
        arturo.addToInventario(new Item("Espada larga", 3, 10000));
        arturo.addToInventario(new Item("Espadón a dos manos", 5, 1000));
        arturo.addToInventario(new Item("Pan", 1, 1));
        arturo.addToInventario(new Item("Agua", 2, 1));
        arturo.addToInventario(new Item("Daga", 0.5, 200));
        arturo.addToInventario(new Item("Antorcha", 0.75, 10));
    }

    @Test
    public void testAddToInventario() {
        Item[] inventario = {
                new Item("Cota de Malla", 10, 2000),
                new Item("Espada larga", 3, 10000),
                new Item("Espadón a dos manos", 5, 1000),
                new Item("Pan", 1, 1),
                new Item("Agua", 2, 1),
                new Item("Daga", 0.5, 200),
                new Item("Antorcha", 0.75, 10)
        };

        assertArrayEquals(arturo.getInventario(), inventario);

        assertFalse(arturo.addToInventario(new Item("Estatua de plomo", 300, 2000)));
        assertTrue(arturo.addToInventario(new Item("Libro", 1, 5)));
    }

    @Test
    public void testGetCargaActual() {
        assertTrue(arturo.getCargaActual() == 22.25);
    }

    @Test
    public void testEquipar() {
        Personaje valkiria = new Personaje("Valkiria", "HUMANO");
        assertTrue(valkiria.equipar(new Armadura("Cota de Malla", 10, 2000, 20, "ARMADURA")));
        assertTrue(valkiria.equipar(new Arma("Espada larga", 3, 10000, 60, false)));
        assertFalse(valkiria.equipar(new Arma("Espadón a dos manos", 5, 1000, 50, true)));
        assertTrue(valkiria.equipar(new Armadura("Yelmo de hierro", 10, 200, 5, "YELMO")));
        assertTrue(valkiria.equipar(new Armadura("Escudo de madera", 10, 100, 10, "ESCUDO")));

        assertTrue(valkiria.armaduraCuerpo.equals(new Armadura("Cota de Malla", 10, 2000, 20, "ARMADURA")));
        assertTrue(valkiria.armaduraCabeza.equals(new Armadura("Yelmo de hierro", 10, 200, 5, "YELMO")));
        // Comprobar que los objetos a una mano están bien colocados "requiere" definir la mano por defecto.


        Personaje arturo = new Personaje("Arturo", "HUMANO");

        assertTrue(arturo.equipar(new Armadura("Coraza", 15, 3000, 30, "ARMADURA")));
        assertFalse(arturo.equipar(new Armadura("Armadura de cuero", 5, 500, 10, "ARMADURA")));
        assertTrue(arturo.equipar(new Arma("Espadón a dos manos", 5, 1000, 50, true)));
        assertFalse(arturo.equipar(new Arma("Espada larga", 3, 10000, 60, false)));
        assertTrue(arturo.equipar(new Armadura("Yelmo de plata", 2, 2000, 5, "YELMO")));
        assertFalse(arturo.equipar(new Armadura("Escudo de madera", 10, 100, 10, "ESCUDO")));

        assertTrue(arturo.armaduraCuerpo.equals(new Armadura("Coraza", 15, 3000, 30, "ARMADURA")));
        assertFalse(arturo.armaduraCuerpo.equals(new Armadura("Armadura de cuero", 5, 500, 10, "ARMADURA")));
        assertTrue(arturo.itemManoDch.equals(new Arma("Espadón a dos manos", 5, 1000, 50, true)));
        assertTrue(arturo.itemManoIzq.equals(new Arma("Espadón a dos manos", 5, 1000, 50, true)));
        assertTrue(arturo.armaduraCabeza.equals(new Armadura("Yelmo de plata", 2, 2000, 5, "YELMO")));

    }


}
*/