package ud5.herenciaapuntes;

public class Hora {
    byte hora;
    byte minuto;

    public Hora(int hora, int minuto) {
        this.hora = hora < 0 ? 0 : hora > 23 ? 23 : (byte) hora;
        this.minuto = minuto < 0 ? 0 : minuto > 59 ? 59 : (byte) minuto;
    }


    void inc() {
        if (minuto < 59) {
            minuto++;
        } else {
            minuto = 0;
            if (hora < 23) {
                hora++;
            } else {
                hora = 0;
            }
        }
    }

    public boolean setHora(int hora) {
        boolean modificado = false;
        if (hora >= 0 && hora <= 23) {
            this.hora = (byte) hora;
            modificado = true;
        }
        return modificado;
    }

    public boolean setMinuto(int minuto) {
        boolean modificado = false;
        if (minuto >= 0 && minuto <= 59) {
            this.minuto = (byte) minuto;
            modificado = true;
        }
        return modificado;
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d", hora, minuto);
    }


    @Override
    public boolean equals(Object obj) {
        Hora otra = (Hora) obj;
        return hora == otra.hora && minuto == otra.minuto;
    }


    public static void main(String[] args) {
        Hora h = new Hora(22, 58);

        for (int i = 0; i < 70; i++) {
            h.inc(); // 0:0

            System.out.println(h);
        }
    }

    /*
     * @Test
     * public void HoraTest() {
     * // Prueba el método inc
     * Hora hora = new Hora(23,59);
     * hora.inc();
     * assertEquals(hora.hora, 0);
     * assertEquals(hora.minuto, 0);
     * 
     * Hora hora2 = new Hora(22,58);
     * 
     * hora2.inc();
     * assertEquals(hora2.hora, 22);
     * assertEquals(hora2.minuto, 59);
     * 
     * hora2.inc();
     * assertEquals(hora2.hora, 23);
     * assertEquals(hora2.minuto, 0);
     * 
     * 
     * // Prueba los métodos setMinutos y setHora
     * Hora hora = new Hora(23,59);
     * 
     * assertFalse(hora.setMinuto(-1));
     * assertFalse(hora.setMinuto(60));
     * assertEquals(hora.minuto, 59);
     * assertTrue(hora.setMinuto(0));
     * assertEquals(hora.minuto, 0);
     * assertTrue(hora.setMinuto(59));
     * assertEquals(hora.minuto, 59);
     * 
     * 
     * Hora hora = new Hora(23,59);
     * 
     * assertFalse(hora.setHora(-1));
     * assertFalse(hora.setHora(24));
     * assertEquals(hora.hora, 23);
     * assertTrue(hora.setHora(0));
     * assertEquals(hora.hora, 0);
     * assertTrue(hora.setHora(23));
     * assertEquals(hora.hora, 23);
     * 
     * }
     * 
     */
}
