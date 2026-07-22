/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.grupo_5_pfa1;

/**
 * Clase nodo para almacenar una cita dentro de una lista simple circular.
 *
 * @author Diego
 */
public class NodoCita {

    private Cita dato;
    private NodoCita siguiente;

    /**
     * Constructor vacío de la clase NodoCita.
     */
    public NodoCita() {
    }

    /**
     * Constructor con parámetro.
     *
     * @param dato Cita que se almacenará en el nodo.
     */
    public NodoCita(Cita dato) {

        this.dato = dato;
        this.siguiente = null;
    }

    /**
     * Retorna la cita almacenada en el nodo.
     *
     * @return Cita almacenada.
     */
    public Cita getDato() {
        return dato;
    }

    /**
     * Modifica la cita almacenada en el nodo.
     *
     * @param dato Nueva cita.
     */
    public void setDato(Cita dato) {
        this.dato = dato;
    }

    /**
     * Retorna el siguiente nodo de la lista.
     *
     * @return Siguiente nodo.
     */
    public NodoCita getSiguiente() {
        return siguiente;
    }

    /**
     * Modifica el siguiente nodo de la lista.
     *
     * @param siguiente Nuevo nodo siguiente.
     */
    public void setSiguiente(NodoCita siguiente) {
        this.siguiente = siguiente;
    }
}