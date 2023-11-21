package ud3.apuntes;

public class Sintonizador {
    private double frecuencia;
    private double memoria1, memoria2, memoria3;

    public final static double FRECUENCIA_MIN = 80;
    public final static double FRECUENCIA_MAX = 108;
    public final static double FRECUENCIA_SALTO = 0.5;
    public final static double FRECUENCIA_SALTO_FINO = 0.1;

    public Sintonizador(double frecuencia) {
        try {
            this.setFrecuencia(frecuencia);
        } catch (IllegalArgumentException e) {
            throw e;
        }

        memoria1 = FRECUENCIA_MIN;
        memoria2 = FRECUENCIA_MIN;
        memoria3 = FRECUENCIA_MIN;
    }

    public Sintonizador() {
        this(80);
    }

    public double getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(double frecuencia) {
        if (frecuencia < FRECUENCIA_MIN)
            // this.frecuencia = FRECUENCIA_MIN;
            throw new IllegalArgumentException("FRECUENCIA DEMASIADO BAJA. DEBE SER >= " + FRECUENCIA_MIN);
        else if (frecuencia > FRECUENCIA_MAX)
            // this.frecuencia = FRECUENCIA_MAX;
            throw new IllegalArgumentException("FRECUENCIA DEMASIADO ALTA. DEBE SER <= " + FRECUENCIA_MAX);
        else
            this.frecuencia = frecuencia;
    }

    public void display() {
        System.out.println("Frecuencia = " + frecuencia + " MHz");
    }

    public void up() {
        frecuencia += FRECUENCIA_SALTO;
        if (frecuencia > FRECUENCIA_MAX)
            frecuencia = FRECUENCIA_MIN;
    }

    public void down() {
        frecuencia -= FRECUENCIA_SALTO;
        if (frecuencia < FRECUENCIA_MIN)
            frecuencia = FRECUENCIA_MAX;
    }

    public void upFino() {
        frecuencia += FRECUENCIA_SALTO_FINO;
        if (frecuencia > FRECUENCIA_MAX)
            frecuencia = FRECUENCIA_MIN;
    }

    public void downFino() {
        frecuencia -= FRECUENCIA_SALTO_FINO;
        if (frecuencia < FRECUENCIA_MIN)
            frecuencia = FRECUENCIA_MAX;
    }

    public void guardarFrecuencia(int numMemoria) {
        switch (numMemoria) {
            case 1 -> memoria1 = frecuencia;
            case 2 -> memoria2 = frecuencia;
            case 3 -> memoria3 = frecuencia;
        }
    }

    public void recuperarFrecuencia(int numMemoria) {
        switch (numMemoria) {
            case 1 -> frecuencia = memoria1;
            case 2 -> frecuencia = memoria2;
            case 3 -> frecuencia = memoria3;
        }
    }

    public static void main(String[] args) {
        Sintonizador s1 = new Sintonizador();
        Sintonizador s2 = new Sintonizador(100.5);

        s1.display(); // 80
        s2.display(); // 100.5

        s1.down();
        s1.recuperarFrecuencia(1);
        s1.display(); // 108

        s2.guardarFrecuencia(1);
        s2.up();
        s2.display(); // 101
        s2.recuperarFrecuencia(1);
        s2.display(); // 100.5

        try {
            Sintonizador s3 = new Sintonizador(50);
            s3.display(); // 80
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


        try {
            Sintonizador s4 = new Sintonizador(200);
            s4.display(); // 108

            s4.up();
            s4.display(); // 80
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }


    }

}
