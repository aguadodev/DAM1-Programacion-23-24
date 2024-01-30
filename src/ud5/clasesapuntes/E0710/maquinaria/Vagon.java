package ud5.clasesapuntes.E0710.maquinaria;

class Vagon {
    int numero;
    final double CARGA_MAXIMA;
    double cargaActual;
    String tipoMercancia;

    public Vagon(int numero, double cargaMaxima, double cargaActual, String tipoMercancia) {
        this.numero = numero;
        this.CARGA_MAXIMA = cargaMaxima;
        this.cargaActual = cargaActual;
        this.tipoMercancia = tipoMercancia;
    }

    @Override
    public String toString() {
        String str = String.valueOf(numero);

        str += "; Carga = (" + cargaActual + "/" + CARGA_MAXIMA + ")";
        str += tipoMercancia != null ? "; Tipo Mercancia=" + tipoMercancia : "";

        return str;
    }

        

    
}
