/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_5_pfa1;

/**
 * Lista simple para almacenar la bitácora de citas atendidas durante el día.
 *
 * @author Diego
 */
public class ListaBitacora {

    private NodoBitacora primero;
    private NodoBitacora ultimo;

    /**
     * Constructor de la lista de bitácora.
     */
    public ListaBitacora() {

        this.primero = null;
        this.ultimo = null;
    }

    /**
     * Retorna el primer nodo de la lista.
     *
     * @return Primer nodo.
     */
    public NodoBitacora getPrimero() {
        return primero;
    }

    /**
     * Modifica el primer nodo de la lista.
     *
     * @param primero Nuevo primer nodo.
     */
    public void setPrimero(NodoBitacora primero) {
        this.primero = primero;
    }

    /**
     * Retorna el último nodo de la lista.
     *
     * @return Último nodo.
     */
    public NodoBitacora getUltimo() {
        return ultimo;
    }

    /**
     * Modifica el último nodo de la lista.
     *
     * @param ultimo Nuevo último nodo.
     */
    public void setUltimo(NodoBitacora ultimo) {
        this.ultimo = ultimo;
    }

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si está vacía, false si contiene datos.
     */
    public boolean estaVacia() {

        if (primero == null) {

            return true;
        }

        return false;
    }

    /**
     * Inserta una cita atendida al final de la lista simple.
     *
     * @param bitacoraCita Cita atendida que se desea insertar.
     */
    public void insertarFinal(BitacoraCita bitacoraCita) {

        NodoBitacora nuevoNodo = new NodoBitacora(bitacoraCita);

        if (primero == null) {

            primero = nuevoNodo;
            ultimo = nuevoNodo;

        } else {

            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
        }
    }

    /**
     * Retorna todas las citas atendidas durante la sesión.
     *
     * @return Información completa de la bitácora.
     */
    public String mostrarBitacora() {

        String texto = "";

        if (primero == null) {

            texto = "No hay citas registradas en la bitácora del día.";

        } else {

            NodoBitacora aux = primero;

            while (aux != null) {

                texto = texto + aux.getDato().mostrarDatos()
                        + "\n-----------------------------\n";

                aux = aux.getSiguiente();
            }
        }

        return texto;
    }
}
