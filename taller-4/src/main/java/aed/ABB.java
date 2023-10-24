package aed;

import java.util.*;
import java.util.stream.Collectors;

public class ABB<T extends Comparable<T>> implements Conjunto<T> {

    private class Nodo {
        T dato;
        Nodo izquierdo;
        Nodo derecho;

        Nodo(T dato) {
            this.dato = dato;
            izquierdo = null;
            derecho = null;
        }
    }

    private Nodo raiz;

    public ABB() {
        raiz = null;
    }

    public int cardinal() {
        return contarNodos(raiz);
    }

    private int contarNodos(Nodo actual) {
        if (actual == null) {
            return 0;
        }
        return 1 + contarNodos(actual.izquierdo) + contarNodos(actual.derecho);
    }

    public T minimo() {
        if (raiz == null) {
            return null;
        }
        Nodo actual = raiz;
        while (actual.izquierdo != null) {
            actual = actual.izquierdo;
        }
        return actual.dato;
    }

    public T maximo() {
        if (raiz == null) {
            return null;
        }
        Nodo actual = raiz;
        while (actual.derecho != null) {
            actual = actual.derecho;
        }
        return actual.dato;
    }

    public void insertar(T elem) {
        raiz = insertarRecursivo(raiz, elem);
    }

    private Nodo insertarRecursivo(Nodo actual, T elem) {
        if (actual == null) {
            return new Nodo(elem);
        }

        if (elem.compareTo(actual.dato) < 0) {
            actual.izquierdo = insertarRecursivo(actual.izquierdo, elem);
        } else if (elem.compareTo(actual.dato) > 0) {
            actual.derecho = insertarRecursivo(actual.derecho, elem);
        }
        return actual;
    }

    public boolean pertenece(T elem) {
        return perteneceRecursivo(raiz, elem);
    }

    private boolean perteneceRecursivo(Nodo actual, T elem) {
        if (actual == null) {
            return false;
        }
        if (elem.compareTo(actual.dato) == 0) {
            return true;
        }
        return elem.compareTo(actual.dato) < 0
                ? perteneceRecursivo(actual.izquierdo, elem)
                : perteneceRecursivo(actual.derecho, elem);
    }

    public void eliminar(T elem) {
        raiz = eliminarRecursivo(raiz, elem);
    }

    private Nodo eliminarRecursivo(Nodo actual, T elem) {
        if (actual == null) {
            return null;
        }
        if (elem.compareTo(actual.dato) == 0) {
            if (actual.izquierdo == null && actual.derecho == null) {
                return null;
            }
            if (actual.izquierdo == null) {
                return actual.derecho;
            }
            if (actual.derecho == null) {
                return actual.izquierdo;
            }
            T menorDelDerecho = encontrarMenor(actual.derecho);
            actual.dato = menorDelDerecho;
            actual.derecho = eliminarRecursivo(actual.derecho, menorDelDerecho);
            return actual;
        }
        if (elem.compareTo(actual.dato) < 0) {
            actual.izquierdo = eliminarRecursivo(actual.izquierdo, elem);
            return actual;
        }
        actual.derecho = eliminarRecursivo(actual.derecho, elem);
        return actual;
    }

    private T encontrarMenor(Nodo raiz) {
        return raiz.izquierdo == null ? raiz.dato : encontrarMenor(raiz.izquierdo);
    }

    @Override
    public String toString() {
        List<T> lista = new ArrayList<>();
        inOrden(raiz, lista);
        return "{" + String.join(",", lista.stream().map(Object::toString).collect(Collectors.toList())) + "}";
    }

    private void inOrden(Nodo actual, List<T> lista) {
        if (actual != null) {
            inOrden(actual.izquierdo, lista);
            lista.add(actual.dato);
            inOrden(actual.derecho, lista);
        }
    }

    private class ABB_Iterador implements Iterador<T> {
        private Stack<Nodo> pila = new Stack<>();

        public ABB_Iterador() {
            Nodo actual = raiz;
            while (actual != null) {
                pila.push(actual);
                actual = actual.izquierdo;
            }
        }

        public boolean haySiguiente() {
            return !pila.isEmpty();
        }

        public T siguiente() {
            if (pila.isEmpty()) {
                throw new NoSuchElementException();
            }

            Nodo actual = pila.pop();
            T datoActual = actual.dato;

            if (actual.derecho != null) {
                actual = actual.derecho;
                while (actual != null) {
                    pila.push(actual);
                    actual = actual.izquierdo;
                }
            }

            return datoActual;
        }
    }

    public Iterador<T> iterador() {
        return new ABB_Iterador();
    }
}
