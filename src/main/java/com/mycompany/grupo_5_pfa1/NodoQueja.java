/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_5_pfa1;

/**
 * Clase NodoQueja.
 * Representa cada nodo dentro de la pila de quejas.
 * @author Grupo 5
 */
public class NodoQueja { // Inicio de la clase NodoQueja.

    // Sección de atributos.
    private Queja queja; // Guarda el objeto Queja dentro del nodo.
    private NodoQueja anterior; // Guarda la referencia al nodo anterior de la pila.

    // Sección de constructores.
    public NodoQueja() { // Constructor vacío de la clase NodoQueja.
    } 
    public NodoQueja(Queja queja) { // Constructor que recibe una queja.
        this.queja = queja; // Asigna la queja recibida al atributo queja.
        this.anterior = null; // Inicializa el nodo anterior como null.
    } 

    // Sección de getter y setter.
    public Queja getQueja() { // Método getter que retorna la queja.
        return queja; // Retorna la queja guardada en el nodo.
    } 
    public void setQueja(Queja queja) { // Método setter que recibe una queja.
        this.queja = queja; // Asigna la queja recibida al atributo queja.
    } 
    public NodoQueja getAnterior() { // Método getter que retorna el nodo anterior.
        return anterior; // Retorna la referencia al nodo anterior.
    } 
    public void setAnterior(NodoQueja anterior) { // Método setter que recibe el nodo anterior.
        this.anterior = anterior; // Asigna el nodo recibido al atributo anterior.
    } 
} 