package com.mycompany.grupo_5_pfa1;

import java.text.SimpleDateFormat;

/**
 * Implementación de una cola genérica de pacientes mediante nodos enlazados.
 * 
 * Sigue la política FIFO (First In, First Out): los pacientes se insertan
 * al final y se retiran desde el frente. La clase expone sus punteros
 * {@code frente} y {@code fin} con visibilidad {@code protected} para que
 * las subclases y las clases del mismo paquete puedan recorrer la estructura
 * sin necesidad de métodos adicionales.
 *
 * @author Grupo 5
 * @version 1.0
 * @see ColaPacientes
 * @see NodoPaciente
 * @see Paciente
 */
public class ColaBase {

    /**
     * Primer nodo de la cola (frente); {@code null} cuando la cola está vacía.
     */
    protected NodoPaciente frente;

    /**
     * Último nodo de la cola (fin); {@code null} cuando la cola está vacía.
     */
    protected NodoPaciente fin;

    /**
     * Construye una cola vacía con {@code frente} y {@code fin} en {@code null}.
     */
    public ColaBase() {
        this.frente = null;
        this.fin = null;
    }

    /**
     * Inserta un paciente al final de la cola.
     *
     * @param paciente paciente que se desea encolar; no debe ser {@code null}
     */
    public void encolar(Paciente paciente) {
        NodoPaciente nuevoNodo = new NodoPaciente(paciente);
        if (esVacia()) {
            frente = nuevoNodo;
            fin = nuevoNodo;
        } else {
            fin.setSiguiente(nuevoNodo);
            fin = nuevoNodo;
        }
    }

    /**
     * Elimina y retorna el paciente que se encuentra al frente de la cola.
     *
     * @return paciente eliminado del frente, o {@code null} si la cola está vacía
     */
    public Paciente desencolar() {
        if (esVacia()) {
            return null;
        }
        Paciente pacienteAtendido = frente.getPaciente();
        frente = frente.getSiguiente();
        if (frente == null) {
            fin = null;
        }
        return pacienteAtendido;
    }

    /**
     * Busca y elimina el paciente cuyo número de ficha coincida con el
     * valor indicado (comparación sin distinción de mayúsculas/minúsculas).
     *
     * @param ficha número de ficha del paciente que se desea eliminar
     * @return paciente eliminado, o {@code null} si no se encontró la ficha
     */
    public Paciente eliminarPorFicha(String ficha) {
        if (esVacia()) {
            return null;
        }
        if (frente.getPaciente().getFicha().equalsIgnoreCase(ficha)) {
            return desencolar();
        }
        NodoPaciente anterior = frente;
        NodoPaciente actual = frente.getSiguiente();
        while (actual != null) {
            if (actual.getPaciente().getFicha().equalsIgnoreCase(ficha)) {
                anterior.setSiguiente(actual.getSiguiente());
                if (actual == fin) {
                    fin = anterior;
                }
                return actual.getPaciente();
            }
            anterior = actual;
            actual = actual.getSiguiente();
        }
        return null;
    }

    /**
     * Indica si la cola no contiene ningún paciente.
     *
     * @return {@code true} si la cola está vacía; {@code false} en caso contrario
     */
    public boolean esVacia() {
        return frente == null;
    }

    /**
     * Imprime en la salida estándar los datos de todos los pacientes de la cola,
     * precedidos por el texto {@code distintivo}.
     * 
     * Cada línea tiene el formato:
     * {@code [distintivo] Ficha: X | Cedula: Y | Nombre: Z | Llegada: dd/MM/yyyy HH:mm:ss}
     * 
     * @param distintivo texto identificador del tipo de cola (por ejemplo,
     *                   {@code "[REGULAR - VERDE]"})
     */
    public void mostrarCola(String distintivo) {
        NodoPaciente aux = frente;
        if (aux == null) {
            System.out.println(distintivo + " No hay fichas pendientes.");
            return;
        }
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        while (aux != null) {
            System.out.println(distintivo
                + " Ficha: "    + aux.getPaciente().getFicha()
                + " | Cedula: " + aux.getPaciente().getCedula()
                + " | Nombre: " + aux.getPaciente().getNombre()
                + " | Llegada: " + sdf.format(aux.getPaciente().getFechaLlegada()));
            aux = aux.getSiguiente();
        }
    }

    /**
     * Cuenta y retorna el número de pacientes actualmente en la cola.
     *
     * @return cantidad de pacientes en la cola (0 si está vacía)
     */
    public int retornarTamaño() {
        int contador = 0;
        NodoPaciente aux = frente;
        while (aux != null) {
            contador++;
            aux = aux.getSiguiente();
        }
        return contador;
    }
}
