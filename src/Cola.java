public class Cola<T> {
    private Nodo<T> frente;
    private Nodo<T> finalCola;

    public Cola() {
        frente = null;
        finalCola = null;
    }

    public void encolar(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        if (estaVacia()) {
            frente = nuevo;
            finalCola = nuevo;
        } else {
            finalCola.siguiente = nuevo;
            finalCola = nuevo;
        }
    }

    public T desencolar() {
        if (estaVacia()) return null;
        T dato = frente.dato;
        frente = frente.siguiente;
        if (frente == null) finalCola = null;
        return dato;
    }

    public boolean estaVacia() {
        return frente == null;
    }

    public void mostrar() {
        Nodo<T> aux = frente;
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }
}
