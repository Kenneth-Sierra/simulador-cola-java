public class Pila<T> {
    private Nodo<T> tope;

    public Pila() {
        tope = null;
    }

    public void push(T dato) {
        Nodo<T> nuevo = new Nodo<>(dato);
        nuevo.siguiente = tope;
        tope = nuevo;
    }

    public T pop() {
        if (estaVacia()) return null;
        T dato = tope.dato;
        tope = tope.siguiente;
        return dato;
    }

    public T peek() {
        return estaVacia() ? null : tope.dato;
    }

    public boolean estaVacia() {
        return tope == null;
    }

    public void mostrar() {
        Nodo<T> aux = tope;
        while (aux != null) {
            System.out.println(aux.dato);
            aux = aux.siguiente;
        }
    }
}
