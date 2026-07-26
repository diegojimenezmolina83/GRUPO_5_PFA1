/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_5_pfa1;

/**
 * Clase nodo para almacenar una cita atendida dentro de la lista simple
 * de bitácora del día.
 *
 * @author Grupo 5
 */
public class NodoBitacora {

    private BitacoraCita dato;
    private NodoBitacora siguiente;

    /**
     * Constructor vacío de la clase NodoBitacora.
     */
    public NodoBitacora() {
    }

    /**
     * Constructor con parámetro.
     *
     * @param dato Cita atendida que se almacenará en el nodo.
     */
    public NodoBitacora(BitacoraCita dato) {

        this.dato = dato;
        this.siguiente = null;
    }

    /**
     * Retorna la cita atendida almacenada.
     *
     * @return Cita atendida.
     */
    public BitacoraCita getDato() {
        return dato;
    }

    /**
     * Modifica la cita atendida almacenada.
     *
     * @param dato Nueva cita atendida.
     */
    public void setDato(BitacoraCita dato) {
        this.dato = dato;
    }

    /**
     * Retorna el siguiente nodo.
     *
     * @return Siguiente nodo.
     */
    public NodoBitacora getSiguiente() {
        return siguiente;
    }

    /**
     * Modifica el siguiente nodo.
     *
     * @param siguiente Nuevo nodo siguiente.
     */
    public void setSiguiente(NodoBitacora siguiente) {
        this.siguiente = siguiente;
    }
}
