/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_5_pfa1;

/**
 * Clase nodo para almacenar un medicamento dentro de una lista simple circular.
 *
 * @author Diego
 */
public class NodoMedicamento {

    private Medicamento dato;
    private NodoMedicamento siguiente;

    /**
     * Constructor vacío de la clase NodoMedicamento.
     */
    public NodoMedicamento() {
    }

    /**
     * Constructor con parámetro.
     *
     * @param dato Medicamento que se almacenará en el nodo.
     */
    public NodoMedicamento(Medicamento dato) {

        this.dato = dato;
        this.siguiente = null;
    }

    /**
     * Retorna el medicamento almacenado en el nodo.
     *
     * @return Medicamento almacenado.
     */
    public Medicamento getDato() {
        return dato;
    }

    /**
     * Modifica el medicamento almacenado en el nodo.
     *
     * @param dato Nuevo medicamento.
     */
    public void setDato(Medicamento dato) {
        this.dato = dato;
    }

    /**
     * Retorna el siguiente nodo.
     *
     * @return Siguiente nodo.
     */
    public NodoMedicamento getSiguiente() {
        return siguiente;
    }

    /**
     * Modifica el siguiente nodo.
     *
     * @param siguiente Nuevo nodo siguiente.
     */
    public void setSiguiente(NodoMedicamento siguiente) {
        this.siguiente = siguiente;
    }
}