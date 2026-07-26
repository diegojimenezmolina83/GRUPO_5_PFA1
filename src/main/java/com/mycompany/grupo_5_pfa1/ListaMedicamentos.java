/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_5_pfa1;

/**
 * Lista simple circular para almacenar el histórico de medicamentos
 * prescritos a un paciente.
 *
 * @author Grupo 5
 */
public class ListaMedicamentos {

    private NodoMedicamento primero;
    private NodoMedicamento ultimo;

    /**
     * Constructor de la lista de medicamentos.
     */
    public ListaMedicamentos() {

        this.primero = null;
        this.ultimo = null;
    }

    /**
     * Retorna el primer nodo de la lista.
     *
     * @return Primer nodo.
     */
    public NodoMedicamento getPrimero() {
        return primero;
    }

    /**
     * Modifica el primer nodo de la lista.
     *
     * @param primero Nuevo primer nodo.
     */
    public void setPrimero(NodoMedicamento primero) {
        this.primero = primero;
    }

    /**
     * Retorna el último nodo de la lista.
     *
     * @return Último nodo.
     */
    public NodoMedicamento getUltimo() {
        return ultimo;
    }

    /**
     * Modifica el último nodo de la lista.
     *
     * @param ultimo Nuevo último nodo.
     */
    public void setUltimo(NodoMedicamento ultimo) {
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
     * Inserta un medicamento al final de la lista simple circular.
     *
     * @param medicamento Medicamento que se desea agregar al histórico.
     */
    public void insertarFinal(Medicamento medicamento) {

        NodoMedicamento nuevoNodo = new NodoMedicamento(medicamento);

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
     * Retorna el histórico de medicamentos en formato texto.
     *
     * @return Información de todos los medicamentos registrados.
     */
    public String mostrarMedicamentos() {

        String texto = "";

        if (primero == null) {

            texto = "No hay medicamentos registrados.";

        } else {

            NodoMedicamento aux = primero;

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