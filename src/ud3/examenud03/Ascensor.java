package ud3.examenud03;

public class Ascensor {
    private int pisoActual;
    public final int PLANTA_MAS_BAJA;
    public final int PLANTA_MAS_ALTA;

    // Constructor que permite indicar el piso actual, la planta más baja y la planta más alta
    public Ascensor(int pisoActual, int plantaMasBaja, int plantaMasAlta) {
        if (plantaMasBaja >= plantaMasAlta || pisoActual < plantaMasBaja || pisoActual > plantaMasAlta) {
            throw new IllegalArgumentException("Argumentos no válidos");
        }
        this.pisoActual = pisoActual;
        this.PLANTA_MAS_BAJA = plantaMasBaja;
        this.PLANTA_MAS_ALTA = plantaMasAlta;
    }

    // Constructor que permite indicar la planta más baja y la planta más alta, situando el piso actual del ascensor en la planta más baja
    public Ascensor(int plantaMasBaja, int plantaMasAlta) {
        this(plantaMasBaja, plantaMasBaja, plantaMasAlta);
    }

    // Constructor predeterminado que sitúa el ascensor por defecto en la planta baja de un edificio de 9 plantas de viviendas y 2 sótanos de aparcamientos
    public Ascensor() {
        this(0, -2, 9);
    }

    // Método para obtener el piso actual del ascensor
    public int getPisoActual() {
        return pisoActual;
    }


    // Métodos para las operaciones básicas
    public boolean subir() {
        if (pisoActual < PLANTA_MAS_ALTA) {
            pisoActual++;
            return true;
        }
        return false;
    }

    public boolean bajar() {
        if (pisoActual > PLANTA_MAS_BAJA) {
            pisoActual--;
            return true;
        }
        return false;
    }

    public boolean subirN(int n) {
        if (pisoActual + n <= PLANTA_MAS_ALTA) {
            pisoActual += n;
            return true;
        }
        return false;
    }

    public boolean bajarN(int n) {
        if (pisoActual - n >= PLANTA_MAS_BAJA) {
            pisoActual -= n;
            return true;
        }
        return false;
    }

    public boolean irAlPiso(int destino) {
        if (destino >= PLANTA_MAS_BAJA && destino <= PLANTA_MAS_ALTA) {
            pisoActual = destino;
            return true;
        }
        return false;
    }

    // Método para mostrar el piso actual del ascensor
    public void mostrar() {
        System.out.println("El ascensor está en el piso: " + pisoActual);
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        Ascensor ascensor = new Ascensor(); // Se crea un ascensor en la planta baja por defecto
        ascensor.subir(); // El ascensor sube un piso
        ascensor.mostrar(); // Debería imprimir "El ascensor está en el piso: 1"
    }
}
