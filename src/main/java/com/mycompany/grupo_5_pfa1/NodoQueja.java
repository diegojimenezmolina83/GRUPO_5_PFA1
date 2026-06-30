package com.mycompany.grupo_5_pfa1;

/**
 * Nodo de la lista enlazada utilizada internamente por {@link PilaBase}.
 * 
 * Contiene una referencia a una {@link Queja} y un puntero al nodo anterior,
 * lo que permite implementar la pila como una lista enlazada simple donde
 * la cima apunta al nodo más reciente.
 *
 * @author Grupo 5
 * @version 1.0
 * @see PilaBase
 * @see Queja
 */
public class NodoQueja {

    /**
     * Queja almacenada en este nodo.
     */
    private Queja queja;

    /**
     * Referencia al nodo anterior en la pila; {@code null} si es el nodo base.
     */
    private NodoQueja anterior;

    /**
     * Construye un {@code NodoQueja} vacío sin inicializar ningún atributo.
     */
    public NodoQueja() {
    }

    /**
     * Construye un {@code NodoQueja} con la queja indicada.
     * El puntero {@code anterior} queda en {@code null}.
     *
     * @param queja queja que almacenará este nodo
     */
    public NodoQueja(Queja queja) {
        this.queja = queja;
        this.anterior = null;
    }

    /**
     * Retorna la queja almacenada en este nodo.
     *
     * @return queja contenida en el nodo
     */
    public Queja getQueja() {
        return queja;
    }

    /**
     * Asigna la queja que almacenará este nodo.
     *
     * @param queja queja a asignar
     */
    public void setQueja(Queja queja) {
        this.queja = queja;
    }

    /**
     * Retorna la referencia al nodo anterior en la pila.
     *
     * @return nodo anterior, o {@code null} si este es el nodo base
     */
    public NodoQueja getAnterior() {
        return anterior;
    }

    /**
     * Asigna la referencia al nodo anterior en la pila.
     *
     * @param anterior nodo que precede a este en la pila
     */
    public void setAnterior(NodoQueja anterior) {
        this.anterior = anterior;
    }
}
