/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_5_pfa1;

/**
 * Lista doble circular para almacenar el expediente único de pacientes.
 * Permite insertar expedientes, buscar por cédula y navegar hacia adelante
 * o hacia atrás entre expedientes.
 *
 * @author Diego
 */
public class ListaExpedientes {

    private NodoExpediente primero;
    private NodoExpediente ultimo;
    private NodoExpediente actual;

    /**
     * Constructor de la lista de expedientes.
     */
    public ListaExpedientes() {

        this.primero = null;
        this.ultimo = null;
        this.actual = null;
    }

    /**
     * Retorna el primer nodo de la lista.
     *
     * @return Primer nodo.
     */
    public NodoExpediente getPrimero() {
        return primero;
    }

    /**
     * Modifica el primer nodo de la lista.
     *
     * @param primero Nuevo primer nodo.
     */
    public void setPrimero(NodoExpediente primero) {
        this.primero = primero;
    }

    /**
     * Retorna el último nodo de la lista.
     *
     * @return Último nodo.
     */
    public NodoExpediente getUltimo() {
        return ultimo;
    }

    /**
     * Modifica el último nodo de la lista.
     *
     * @param ultimo Nuevo último nodo.
     */
    public void setUltimo(NodoExpediente ultimo) {
        this.ultimo = ultimo;
    }

    /**
     * Retorna el nodo actual utilizado para navegación.
     *
     * @return Nodo actual.
     */
    public NodoExpediente getActual() {
        return actual;
    }

    /**
     * Modifica el nodo actual utilizado para navegación.
     *
     * @param actual Nuevo nodo actual.
     */
    public void setActual(NodoExpediente actual) {
        this.actual = actual;
    }

    /**
     * Verifica si la lista está vacía.
     *
     * @return true si está vacía, false si contiene expedientes.
     */
    public boolean estaVacia() {

        if (primero == null) {

            return true;
        }

        return false;
    }

    /**
     * Inserta un expediente al final de la lista doble circular.
     *
     * @param expediente Expediente que se desea insertar.
     */
    public void insertarFinal(Expediente expediente) {

        NodoExpediente nuevoNodo = new NodoExpediente(expediente);

        if (primero == null) {

            primero = nuevoNodo;
            ultimo = nuevoNodo;
            actual = primero;

            primero.setSiguiente(primero);
            primero.setAnterior(ultimo);

        } else {

            ultimo.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(ultimo);
            nuevoNodo.setSiguiente(primero);
            primero.setAnterior(nuevoNodo);
            ultimo = nuevoNodo;
        }
    }

    /**
     * Busca un expediente por medio de la cédula del paciente.
     *
     * @param cedula Cédula que se desea buscar.
     * @return Expediente encontrado o null si no existe.
     */
    public Expediente buscarPorCedula(String cedula) {

        if (primero == null) {

            return null;
        }

        NodoExpediente aux = primero;

        while (aux != ultimo) {

            if (aux.getDato().getCedula().equals(cedula)) {

                return aux.getDato();
            }

            aux = aux.getSiguiente();
        }

        if (ultimo.getDato().getCedula().equals(cedula)) {

            return ultimo.getDato();
        }

        return null;
    }

    /**
     * Verifica si un expediente ya existe en la lista.
     *
     * @param cedula Cédula que se desea verificar.
     * @return true si existe, false si no existe.
     */
    public boolean existeExpediente(String cedula) {

        Expediente expedienteBuscado = buscarPorCedula(cedula);

        if (expedienteBuscado == null) {

            return false;
        }

        return true;
    }

    /**
     * Reinicia la navegación en el primer expediente.
     */
    public void iniciarNavegacion() {

        actual = primero;
    }

    /**
     * Muestra el expediente actual.
     *
     * @return Información del expediente actual.
     */
    public String mostrarExpedienteActual() {

        if (actual == null) {

            return "No hay expedientes registrados.";
        }

        return actual.getDato().mostrarExpedienteCompleto();
    }

    /**
     * Avanza al siguiente expediente de la lista doble circular.
     *
     * @return Información del siguiente expediente.
     */
    public String avanzarExpediente() {

        if (actual == null) {

            return "No hay expedientes registrados.";
        }

        actual = actual.getSiguiente();

        return actual.getDato().mostrarExpedienteCompleto();
    }

    /**
     * Retrocede al expediente anterior de la lista doble circular.
     *
     * @return Información del expediente anterior.
     */
    public String retrocederExpediente() {

        if (actual == null) {

            return "No hay expedientes registrados.";
        }

        actual = actual.getAnterior();

        return actual.getDato().mostrarExpedienteCompleto();
    }

    /**
     * Retorna todos los expedientes registrados en formato texto.
     *
     * @return Información general de todos los expedientes.
     */
    public String mostrarTodos() {

        String texto = "";

        if (primero == null) {

            texto = "No hay expedientes registrados.";

        } else {

            NodoExpediente aux = primero;

            while (aux != ultimo) {

                texto = texto + aux.getDato().mostrarDatosGenerales()
                        + "\n-----------------------------\n";

                aux = aux.getSiguiente();
            }

            texto = texto + ultimo.getDato().mostrarDatosGenerales()
                    + "\n-----------------------------\n";
        }

        return texto;
    }
}