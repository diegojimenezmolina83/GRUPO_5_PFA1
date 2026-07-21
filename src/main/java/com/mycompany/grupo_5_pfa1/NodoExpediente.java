/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_5_pfa1;

/**
 * Clase nodo para almacenar un expediente dentro de una lista doble circular.
 *
 * @author Diego
 */
public class NodoExpediente {

    private Expediente dato;
    private NodoExpediente anterior;
    private NodoExpediente siguiente;

    /**
     * Constructor vacío de la clase NodoExpediente.
     */
    public NodoExpediente() {
    }

    /**
     * Constructor con parámetro.
     *
     * @param dato Expediente que se almacenará en el nodo.
     */
    public NodoExpediente(Expediente dato) {

        this.dato = dato;
        this.anterior = null;
        this.siguiente = null;
    }

    /**
     * Retorna el expediente almacenado en el nodo.
     *
     * @return Expediente almacenado.
     */
    public Expediente getDato() {
        return dato;
    }

    /**
     * Modifica el expediente almacenado en el nodo.
     *
     * @param dato Nuevo expediente.
     */
    public void setDato(Expediente dato) {
        this.dato = dato;
    }

    /**
     * Retorna el nodo anterior.
     *
     * @return Nodo anterior.
     */
    public NodoExpediente getAnterior() {
        return anterior;
    }

    /**
     * Modifica el nodo anterior.
     *
     * @param anterior Nuevo nodo anterior.
     */
    public void setAnterior(NodoExpediente anterior) {
        this.anterior = anterior;
    }

    /**
     * Retorna el siguiente nodo.
     *
     * @return Siguiente nodo.
     */
    public NodoExpediente getSiguiente() {
        return siguiente;
    }

    /**
     * Modifica el siguiente nodo.
     *
     * @param siguiente Nuevo nodo siguiente.
     */
    public void setSiguiente(NodoExpediente siguiente) {
        this.siguiente = siguiente;
    }
}