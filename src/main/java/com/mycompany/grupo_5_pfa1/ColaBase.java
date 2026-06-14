/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_5_pfa1;

/**
 * Clase ColaBase.
 * Implementa una cola usando nodos enlazados.
 * @author Grupo 5
 */

public class ColaBase { 
    protected NodoPaciente frente; // Guarda el primer nodo de la cola.
    protected NodoPaciente fin; // Guarda el último nodo de la cola.

    /**
     * Constructor vacío de la cola.
     * @author Grupo 5
     */
    
    public ColaBase() { // Inicio del constructor.
        this.frente = null; // Inicializa el frente como null.
        this.fin = null; // Inicializa el final como null.
    } 

    /**
     * Método que inserta un paciente al final de la cola.
     * @author Grupo 5
     * @param paciente Paciente que se desea insertar.
     */
    
    public void encolar(Paciente paciente) { // Inicio del método encolar.
        NodoPaciente nuevoNodo = new NodoPaciente(paciente); // Crea un nuevo nodo con el paciente recibido.
        if (esVacia()) { // Valida si la cola está vacía.
            frente = nuevoNodo; // Si está vacía, el nuevo nodo será el frente.
            fin = nuevoNodo; // Si está vacía, el nuevo nodo también será el final.
        } 
        else { // Si la cola ya tiene elementos.
            fin.setSiguiente(nuevoNodo); // Enlaza el último nodo actual con el nuevo nodo.
            fin = nuevoNodo; // Actualiza el final de la cola al nuevo nodo.
        } 
    } 

    /**
     * Método que elimina y retorna el primer paciente de la cola.
     * @author Grupo 5
     * @return paciente que estaba al frente de la cola.
     */
    
    public Paciente desencolar() { // Inicio del método desencolar.
        if (esVacia()) { // Valida si la cola está vacía.
            return null; // Si está vacía, retorna null.
        } 
        Paciente pacienteAtendido = frente.getPaciente(); // Guarda el paciente que está en el frente.
        frente = frente.getSiguiente(); // Mueve el frente al siguiente nodo.
        if (frente == null) { // Valida si la cola quedó vacía después de desencolar.
            fin = null; // Si quedó vacía, también limpia el final.
        } 
        return pacienteAtendido; // Retorna el paciente eliminado de la cola.
    } 

    /**
     * Método que elimina un paciente específico por número de ficha.
     * @author Grupo 5
     * @param ficha Número de ficha que se desea eliminar.
     * @return paciente eliminado, o null si no se encontró.
     */
    
    public Paciente eliminarPorFicha(String ficha) { // Inicio del método eliminarPorFicha.
        if (esVacia()) { // Valida si la cola está vacía.
            return null; // Si está vacía, no hay nada que eliminar.
        } 
        if (frente.getPaciente().getFicha().equalsIgnoreCase(ficha)) { // Valida si el paciente a eliminar está al frente.
            return desencolar(); // Si está al frente, se elimina usando desencolar.
        } 
        NodoPaciente anterior = frente; // Crea un auxiliar que inicia en el frente.
        NodoPaciente actual = frente.getSiguiente(); // Crea otro auxiliar que inicia en el segundo nodo.
        while (actual != null) { // Recorre la cola mientras existan nodos.
            if (actual.getPaciente().getFicha().equalsIgnoreCase(ficha)) { // Valida si encontró la ficha buscada.
                anterior.setSiguiente(actual.getSiguiente()); // Salta el nodo actual para eliminarlo de la cola.
                if (actual == fin) { // Valida si el nodo eliminado era el último.
                    fin = anterior; // Si era el último, actualiza el final.
                } 
                return actual.getPaciente(); // Retorna el paciente eliminado.
            } 
            anterior = actual; // Avanza el nodo anterior.
            actual = actual.getSiguiente(); // Avanza el nodo actual.
        } 
        return null; // Retorna null si no encontró la ficha.
    } 

    /**
     * Método que indica si la cola está vacía.
     * @author Grupo 5
     * @return true si está vacía, false si tiene pacientes.
     */
    
    public boolean esVacia() { // Inicio del método esVacia.
        return frente == null; // Retorna true si el frente es null.
    } 

    /**
     * Método que muestra todos los pacientes de la cola.
     * @author Grupo 5
     * @param distintivo Texto para identificar el tipo de cola.
     */
    
    public void mostrarCola(String distintivo) { // Inicio del método mostrarCola.
        NodoPaciente aux = frente; // Crea un auxiliar para recorrer la cola sin alterar el frente.
        if (aux == null) { // Valida si no hay pacientes.
            System.out.println(distintivo + " No hay fichas pendientes."); // Muestra mensaje de cola vacía.
            return; // Sale del método.
        } 
        while (aux != null) { // Recorre la cola mientras existan nodos.
            System.out.println(distintivo + " Ficha: "+ aux.getPaciente().getFicha()+ " | Cedula: "+ aux.getPaciente().getCedula()+ " | Nombre: "+ aux.getPaciente().getNombre()); // Imprime los datos del paciente.
            aux = aux.getSiguiente(); // Avanza al siguiente nodo.
        } 
    } 

    /**
     * Método que retorna la cantidad de pacientes en la cola.
     * @author Grupo 5
     * @return cantidad de pacientes.
     */
    
    public int retornarTamaño() { // Inicio del método retornarTamaño.
        int contador = 0; // Inicializa contador en cero.
        NodoPaciente aux = frente; // Crea un auxiliar que inicia en el frente.
        while (aux != null) { // Recorre la cola mientras existan nodos.
            contador++; // Aumenta el contador.
            aux = aux.getSiguiente(); // Avanza al siguiente nodo.
        } 
        return contador; // Retorna la cantidad de pacientes.
    } 
} 