package com.mycompany.grupo_5_pfa1;

/**
 * Implementación de una pila genérica de quejas mediante nodos enlazados.
 * 
 * Sigue la política LIFO (Last In, First Out): las quejas se insertan y
 * se retiran siempre desde la cima. La referencia {@code cima} es
 * {@code protected} para que {@link PilaQuejas} y las clases del mismo
 * paquete puedan acceder directamente a la estructura si fuera necesario.
 *
 * @author Grupo 5
 * @version 1.0
 * @see PilaQuejas
 * @see NodoQueja
 * @see Queja
 */
public class PilaBase {

    /**
     * Nodo en la cima de la pila; {@code null} cuando la pila está vacía.
     */
    protected NodoQueja cima;

    /**
     * Construye una pila vacía con {@code cima} en {@code null}.
     */
    public PilaBase() {
        this.cima = null;
    }

    /**
     * Inserta una queja en la cima de la pila.
     *
     * @param queja queja que se desea apilar; no debe ser {@code null}
     */
    public void apilar(Queja queja) {
        NodoQueja nuevoNodo = new NodoQueja(queja);
        if (esVacia()) {
            cima = nuevoNodo;
        } else {
            nuevoNodo.setAnterior(cima);
            cima = nuevoNodo;
        }
    }

    /**
     * Elimina y retorna la queja que se encuentra en la cima de la pila.
     *
     * @return queja eliminada de la cima, o {@code null} si la pila está vacía
     */
    public Queja desapilar() {
        if (esVacia()) {
            return null;
        }
        Queja quejaEliminada = cima.getQueja();
        cima = cima.getAnterior();
        return quejaEliminada;
    }

    /**
     * Indica si la pila no contiene ninguna queja.
     *
     * @return {@code true} si la pila está vacía; {@code false} en caso contrario
     */
    public boolean esVacia() {
        return cima == null;
    }

    /**
     * Imprime en la salida estándar el mensaje de cada queja de la pila,
     * comenzando desde la cima (queja más reciente) hasta la base.
     * 
     * Si la pila está vacía, imprime {@code "No hay quejas recibidas."}.
     */
    public void mostrarPila() {
        NodoQueja aux = cima;
        if (aux == null) {
            System.out.println("No hay quejas recibidas.");
            return;
        }
        while (aux != null) {
            System.out.println(aux.getQueja().generarMensaje());
            aux = aux.getAnterior();
        }
    }
}
