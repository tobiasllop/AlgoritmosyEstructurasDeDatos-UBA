package aed;

import java.util.*;

public class ListaEnlazada<T> implements Secuencia<T> {
    private Nodo primerNodo;
    private Nodo ultimoNodo;

    private class Nodo {
        T valor;
        Nodo siguiente;
        Nodo anterior;

        public Nodo(T valor) {
            this.valor = valor;
            this.siguiente = null;
            this.anterior = null;
        }
    }

    public ListaEnlazada() {
        this.primerNodo = null;
        this.ultimoNodo = null;
    }

    public int longitud() {
        int contador = 0;
        Nodo actual = primerNodo;
        
        while (actual != null) {
            contador++;
            actual = actual.siguiente;
        }
        
        return contador;
    }

    public void agregarAdelante(T elem) {
        Nodo nuevoNodo = new Nodo(elem);

        if (primerNodo == null) {
            primerNodo = nuevoNodo;
            ultimoNodo = nuevoNodo;
        } else {
            nuevoNodo.siguiente = primerNodo;
            primerNodo.anterior = nuevoNodo;
            primerNodo = nuevoNodo;
        }
    }

    public void agregarAtras(T elem) {
        Nodo nuevoNodo = new Nodo(elem);

        if (ultimoNodo == null) {
            primerNodo = nuevoNodo;
            ultimoNodo = nuevoNodo;
        } else {
            nuevoNodo.anterior = ultimoNodo;
            ultimoNodo.siguiente = nuevoNodo;
            ultimoNodo = nuevoNodo;
        }
    }

    public T obtener(int i) {
        if (i < 0 || i >= longitud()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        Nodo actual = primerNodo;
        for (int j = 0; j < i; j++) {
            actual = actual.siguiente;
        }

        return actual.valor;
    }

    public void eliminar(int i) {
        if (i < 0 || i >= longitud()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        if (i == 0) {
            primerNodo = primerNodo.siguiente;
            if (primerNodo != null) {
                primerNodo.anterior = null;
            } else {
                ultimoNodo = null;
            }
            return;
        }

        Nodo actual = primerNodo;
        for (int j = 0; j < i - 1; j++) {
            actual = actual.siguiente;
        }

        actual.siguiente = actual.siguiente.siguiente;
        if (actual.siguiente != null) {
            actual.siguiente.anterior = actual;
        } else {
            ultimoNodo = actual;
        }
    }

    public void modificarPosicion(int indice, T elem) {
        if (indice < 0 || indice >= longitud()) {
            throw new IndexOutOfBoundsException("Índice fuera de rango");
        }

        Nodo actual = primerNodo;
        for (int j = 0; j < indice; j++) {
            actual = actual.siguiente;
        }

        actual.valor = elem;
    }

    public ListaEnlazada<T> copiar() {
        ListaEnlazada<T> nuevaLista = new ListaEnlazada<>();
        Nodo actual = primerNodo;

        while (actual != null) {
            nuevaLista.agregarAtras(actual.valor);
            actual = actual.siguiente;
        }

        return nuevaLista;
    }

    public ListaEnlazada(ListaEnlazada<T> lista) {
        Nodo actual = lista.primerNodo;

        while (actual != null) {
            this.agregarAtras(actual.valor);
            actual = actual.siguiente;
        }
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Nodo actual = primerNodo;

        while (actual != null) {
            sb.append(actual.valor);
            if (actual.siguiente != null) {
                sb.append(", ");
            }
            actual = actual.siguiente;
        }

        sb.append("]");
        return sb.toString();
    }

    private class ListaIterador implements Iterador<T> {
    	private Nodo actual;
        // Agrega este constructor
         public ListaIterador() {
            this.actual = primerNodo;
        }
        public boolean haySiguiente() {
	        return actual != null ;
        }
        
        public boolean hayAnterior() {
            return (actual == null && ultimoNodo != null) || (actual != null && actual.anterior != null);
        }

        public T siguiente() {
            if (!haySiguiente()) {
                throw new NoSuchElementException("No hay siguiente elemento");
            }
    
            T valor = actual.valor;
            actual = actual.siguiente;
            return valor;
        }
        

        public T anterior() {
            if (!hayAnterior()) {
                throw new NoSuchElementException("No hay elemento anterior");
            }
        
            if (actual == null) {
                actual = ultimoNodo;
            } else {
                actual = actual.anterior;
            }
        
            return actual.valor;

        }
    }

    public Iterador<T> iterador() {
        return new ListaIterador();
    }
    

}
