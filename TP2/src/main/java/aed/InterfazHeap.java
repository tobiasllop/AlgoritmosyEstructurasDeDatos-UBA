package aed;

public interface InterfazHeap {

    public int getMaximosVotos();
    public int obtenerMaximo_IdPartido();
    public void insertar(int elem,int idPartido);
    public void eliminarRaiz();
    public String toString();
    public int obtenerMaximo();
} 