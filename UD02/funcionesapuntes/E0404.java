package UD02.funcionesapuntes;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class E0404 {
    public static void main(String[] args) {
        System.out.println(maximo(5, 10));
        System.out.println(maximo(10, 5));
        System.out.println(maximo(5, 5));
    }

    static int maximo(int a, int b) {
        return a > b ? b : a;
    }

    @Test
    public void testMaximo() {
        assertEquals(10, E0404.maximo(5, 10));
        assertEquals(10, E0404.maximo(10, 5));
        assertEquals(5, E0404.maximo(5, 5));
    }

}
