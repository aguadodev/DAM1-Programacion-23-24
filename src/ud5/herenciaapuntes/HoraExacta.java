package ud5.herenciaapuntes;

public class HoraExacta extends Hora {
    byte segundo;

    public HoraExacta(int hora, int minuto, int segundo) {
        super(hora, minuto);
        this.segundo = segundo < 0 ? 0 : segundo > 59 ? 59 : (byte) segundo;
    }

    public boolean setSegundo(int segundo) {
        boolean modificado = false;
        if (segundo >= 0 && segundo <= 59) {
            this.segundo = (byte) segundo;
            modificado = true;
        }
        return modificado;
    }

    
    @Override
    void inc() {
        if (segundo < 59) {
            segundo++;
        } else {
            segundo = 0;
            super.inc();
        }        
    }



    @Override
    public String toString() {
        return String.format("%s:%02d", super.toString(), segundo);
    }

    public static void main(String[] args) {
        HoraExacta h = new HoraExacta(23, 59, 59);
        HoraExacta h2 = new HoraExacta(23, 59, 59);

        System.out.println(h == h2);
        System.out.println(h.equals(h2));



/*
        h.setSegundo(56); // 23:59:56
        for (int i = 0; i < 10; i++){
            h.inc();
            System.out.println(h);
        }*/

    }

    /*
     * @Test
     * public void HoraExactaTest() {
     * HoraExacta hora = new HoraExacta(23,59,59);
     * hora.inc();
     * assertEquals(hora.hora, 0);
     * assertEquals(hora.minuto, 0);
     * assertEquals(hora.segundo, 0);
     * 
     * assertFalse(hora.setMinutos(-1));
     * assertFalse(hora.setMinutos(60));
     * assertTrue(hora.setMinutos(0));
     * assertTrue(hora.setMinutos(59));
     * 
     * assertFalse(hora.setHoras(-1));
     * assertFalse(hora.setHoras(24));
     * assertTrue(hora.setHoras(0));
     * assertTrue(hora.setHoras(23));
     * 
     * assertFalse(hora.setSegundos(-1));
     * assertFalse(hora.setSegundos(60));
     * assertTrue(hora.setSegundos(0));
     * assertTrue(hora.setSegundos(59));
     * }
     * 
     * 
     */
}
