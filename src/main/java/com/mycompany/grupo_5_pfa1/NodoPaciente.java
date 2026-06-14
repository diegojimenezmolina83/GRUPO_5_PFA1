/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_5_pfa1;

/**
 * Clase NodoPaciente.
 * Representa cada nodo dentro de la cola de pacientes.
 * @author Grupo 5
 */

public class NodoPaciente { // Inicio de la clase NodoPaciente.

    // Sección de atributos.
    private Paciente paciente; // Guarda el objeto Paciente dentro del nodo.
    private NodoPaciente siguiente; // Guarda la referencia al siguiente nodo de la cola.

    // Sección de constructores.
    public NodoPaciente() { // Constructor vacío de la clase NodoPaciente.
    } 

    public NodoPaciente(Paciente paciente) { // Constructor que recibe un paciente.
        this.paciente = paciente; // Asigna el paciente recibido al atributo paciente.
        this.siguiente = null; // Inicializa el siguiente nodo como null.
    } 

    // Sección de getter y setter.
    public Paciente getPaciente() { // Método getter que retorna el paciente.
        return paciente; // Retorna el paciente guardado en el nodo.
    } 

    public void setPaciente(Paciente paciente) { // Método setter que recibe un paciente.
        this.paciente = paciente; // Asigna el paciente recibido al atributo paciente.
    } 

    public NodoPaciente getSiguiente() { // Método getter que retorna el siguiente nodo.
        return siguiente; // Retorna la referencia al siguiente nodo.
    } 

    public void setSiguiente(NodoPaciente siguiente) { // Método setter que recibe el siguiente nodo.
        this.siguiente = siguiente; // Asigna el nodo recibido al atributo siguiente.
    } 

} 