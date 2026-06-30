package com.mycompany.grupo_5_pfa1;

/**
 * Nodo de la lista enlazada utilizada internamente por {@link ColaBase}.
 * 
 * Contiene una referencia a un {@link Paciente} y un puntero al siguiente
 * nodo, permitiendo encadenar los elementos de la cola.
 *
 * @author Grupo 5
 * @version 1.0
 * @see ColaBase
 * @see Paciente
 */
public class NodoPaciente {

    /**
     * Paciente almacenado en este nodo.
     */
    private Paciente paciente;

    /**
     * Referencia al siguiente nodo de la cola; {@code null} si es el último.
     */
    private NodoPaciente siguiente;

    /**
     * Construye un {@code NodoPaciente} vacío sin inicializar ningún atributo.
     */
    public NodoPaciente() {
    }

    /**
     * Construye un {@code NodoPaciente} con el paciente indicado.
     * El puntero {@code siguiente} queda en {@code null}.
     *
     * @param paciente paciente que almacenará este nodo
     */
    public NodoPaciente(Paciente paciente) {
        this.paciente = paciente;
        this.siguiente = null;
    }

    /**
     * Retorna el paciente almacenado en este nodo.
     *
     * @return paciente contenido en el nodo
     */
    public Paciente getPaciente() {
        return paciente;
    }

    /**
     * Asigna el paciente que almacenará este nodo.
     *
     * @param paciente paciente a asignar
     */
    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    /**
     * Retorna la referencia al siguiente nodo en la cola.
     *
     * @return siguiente nodo, o {@code null} si este es el último
     */
    public NodoPaciente getSiguiente() {
        return siguiente;
    }

    /**
     * Asigna la referencia al siguiente nodo en la cola.
     *
     * @param siguiente nodo que seguirá a este en la cola
     */
    public void setSiguiente(NodoPaciente siguiente) {
        this.siguiente = siguiente;
    }
}
