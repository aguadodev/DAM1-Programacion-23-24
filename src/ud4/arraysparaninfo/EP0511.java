package ud4.arraysparaninfo;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.Test;

public class EP0511 {

    public static int[] buscarTodos(int t[], int clave) {
        // Crea y devuelve una tabla con todos los índices de los elementos donde
        // se encuentra la clave de búsqueda. En el caso de que clave no se encuentre en
        // la tabla t, la función devolverá una tabla vacía.

        // TODO...

        return null;
    }

    // PRUEBAS JUNIT 5
    @Test
    public void testBuscarTodosElementoPresente() {
        int[] arreglo = { 1, 2, 3, 4, 5, 3, 6 };
        int clave = 3;

        int[] resultado = buscarTodos(arreglo, clave);

        assertArrayEquals(new int[] { 2, 5 }, resultado);
    }

    @Test
    public void testBuscarTodosElementoNoPresente() {
        int[] arreglo = { 1, 2, 3, 4, 5, 6 };
        int clave = 7;

        int[] resultado = buscarTodos(arreglo, clave);

        assertArrayEquals(new int[] {}, resultado);
    }

    @Test
    public void testBuscarTodosTablaVacia() {
        int[] arreglo = {};
        int clave = 3;

        int[] resultado = buscarTodos(arreglo, clave);

        assertArrayEquals(new int[] {}, resultado);
    }
}
