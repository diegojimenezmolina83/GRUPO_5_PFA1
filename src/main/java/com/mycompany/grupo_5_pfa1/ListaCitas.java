/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_5_pfa1;

/**
 * Lista simple circular para almacenar el histórico de citas de un paciente.
 *
 * @author Diego
 */
public class ListaCitas {

    private NodoCita primero;
    private NodoCita ultimo;

    /**
     * Constructor de la lista de citas.
     */
    public ListaCitas() {

        this.primero = null;
        this.ultimo = null;
    }

    /**
     * Retorna el primer nodo de la lista.
     *
     * @return Primer nodo.
     */
    public NodoCita getPrimero() {
        return primero;
    }

    /**
     * Modifica el primer nodo de la lista.
     *
     * @param primero Nuevo primer nodo.
     */
    public void setPrimero(NodoCita primero) {
        this.primero = primero;
    }

    /**
     * Retorna el último nodo de la lista.
     *
     * @return Último nodo.
     */
    public NodoCita getUltimo() {
        return ultimo;
    }

    /**
     * Modifica el último nodo de la lista.
     *
     * @param ultimo Nuevo último nodo.
     */
    public void setUltimo(NodoCita ultimo) {
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
     * Inserta una cita al final de la lista simple circular.
     *
     * @param cita Cita que se desea agregar al histórico.
     */
    public void insertarFinal(Cita cita) {

        NodoCita nuevoNodo = new NodoCita(cita);

        if (primero == null) {

            primero = nuevoNodo;
            ultimo = nuevoNodo;
            ultimo.setSiguiente(primero);

        } else {

            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
            ultimo.setSiguiente(primero);
        }
    }

    /**
     * Retorna el histórico de citas en formato texto.
     *
     * @return Información de todas las citas registradas.
     */
    public String mostrarCitas() {

        String texto = "";

        if (primero == null) {

            texto = "No hay citas registradas.";

        } else {

            NodoCita aux = primero;

            while (aux != ultimo) {

                texto = texto + aux.getDato().mostrarDatos()
                        + "\n-----------------------------\n";

                aux = aux.getSiguiente();
            }

            texto = texto + ultimo.getDato().mostrarDatos()
                    + "\n-----------------------------\n";
        }

        return texto;
    }
}
