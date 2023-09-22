package aed;

class VectorDeInts implements SecuenciaDeInts {
    private static final int CAPACIDAD_INICIAL = 1;
    private int cantidad_actual;
    private int[] secuencia;

    public VectorDeInts() {
        this.cantidad_actual = 0;
        this.secuencia = new int[CAPACIDAD_INICIAL];
    }

    public VectorDeInts(VectorDeInts vector) {
        throw new UnsupportedOperationException("No implementada aun");
    }

    public int longitud() {
        return cantidad_actual;
    }

    public void agregarAtras(int i) {
        while (cantidad_actual <= CAPACIDAD_INICIAL){
            secuencia[cantidad_actual] = i;
            cantidad_actual += 1;
        }
    }

    public int obtener(int i) {
        return secuencia[i];
    }

    public void quitarAtras() {
        cantidad_actual = cantidad_actual - 1;
    }

    public void modificarPosicion(int indice, int valor) {
        secuencia[indice] = valor;
    }

    public VectorDeInts copiar() {
        VectorDeInts ve = new VectorDeInts();
        return ve;
    }

}
