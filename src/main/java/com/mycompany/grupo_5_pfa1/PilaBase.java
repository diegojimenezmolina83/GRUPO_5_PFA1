/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_5_pfa1;

/**
 * Clase PilaBase.
 * Implementa una pila usando nodos enlazados.
 * @author Grupo 5
 */

public class PilaBase { // Inicio de la clase PilaBase.
    protected NodoQueja cima; // Guarda la cima de la pila.

    /**
     * Constructor vacío de PilaBase.
     * @author Grupo 5
     */
    
    public PilaBase() { // Inicio del constructor.
        this.cima = null; // Inicializa la cima como null.
    } 

    /**
     * Método que inserta una queja en la pila.
     * @author Grupo 5
     * @param queja Queja que se desea apilar.
     */
    
    public void apilar(Queja queja) { // Inicio del método apilar.
        NodoQueja nuevoNodo = new NodoQueja(queja); // Crea un nuevo nodo con la queja.
        if (esVacia()) { // Valida si la pila está vacía.
            cima = nuevoNodo; // Si está vacía, el nuevo nodo será la cima.
        } 
        
        else { // Si la pila tiene elementos.
            nuevoNodo.setAnterior(cima); // Enlaza el nuevo nodo con la cima actual.
            cima = nuevoNodo; // Actualiza la cima al nuevo nodo.
        } 
    } 

    /**
     * Método que elimina la queja de la cima.
     * @author Grupo 5
     * @return queja eliminada.
     */
    
    public Queja desapilar() { // Inicio del método desapilar.
        if (esVacia()) { // Valida si la pila está vacía.
            return null; // Si está vacía, retorna null.
        } 
        Queja quejaEliminada = cima.getQueja(); // Guarda la queja que está en la cima.
        cima = cima.getAnterior(); // Mueve la cima al nodo anterior.
        return quejaEliminada; // Retorna la queja eliminada.
    } 

    /**
     * Método que indica si la pila está vacía.
     * @author Grupo 5
     * @return true si está vacía, false si tiene quejas.
     */
    
    public boolean esVacia() { // Inicio del método esVacia.
        return cima == null; // Retorna true si la cima es null.
    } 
    
    /**
     * Método que muestra todas las quejas de la pila.
     * @author Grupo 5
     */
    
    public void mostrarPila() { // Inicio del método mostrarPila.
        NodoQueja aux = cima; // Crea un auxiliar que inicia en la cima.
        if (aux == null) { // Valida si no hay quejas.
            System.out.println("No hay quejas recibidas."); // Muestra mensaje de pila vacía.
            return; // Sale del método.
        } 
        while (aux != null) { // Recorre la pila mientras existan nodos.
            System.out.println(aux.getQueja().generarMensaje()); // Imprime el mensaje de la queja.
            aux = aux.getAnterior(); // Avanza al nodo anterior.
        } 
    } 
} 