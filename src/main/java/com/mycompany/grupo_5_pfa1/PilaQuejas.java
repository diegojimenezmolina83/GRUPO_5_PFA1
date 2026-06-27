/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_5_pfa1;

import java.util.Date;

/**
 * Clase PilaQuejas.
 * Hereda de PilaBase para manejar quejas.
 * @author Grupo 5
 */

public class PilaQuejas extends PilaBase {

    
    public PilaQuejas() {
        super(); // Llama al constructor de la clase padre PilaBase
    } 
    
    public boolean abandonarCola(ColaBase cola, String ficha, String motivo) {
        Paciente pacienteEliminado = cola.eliminarPorFicha(ficha); // Elimina al paciente de la cola y lo guarda.
        if (pacienteEliminado == null) { // Valida si no se encontro la ficha en la cola
            return false; // Si no se encontro, no apila
        }
        Queja queja = new Queja(pacienteEliminado.getFicha(), pacienteEliminado.getCedula(), motivo, new Date()); // Crea la queja con los datos del paciente,motivo y la fecha/hora actual
        apilar(queja); // Apila la queja usando el metodo de PilaBase
        return true; // Retorna true si se apila con exito
        
    }
} 