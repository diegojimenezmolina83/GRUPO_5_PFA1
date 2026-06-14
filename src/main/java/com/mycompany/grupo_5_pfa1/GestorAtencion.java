/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_5_pfa1;

/**
 *
 * @author Grupo 5
 */

public class GestorAtencion { // Inicio de la clase GestorAtencion.
    private ColaPacientes colaPreferencial; // Guarda la cola de pacientes preferenciales.
    private ColaPacientes colaRegular; // Guarda la cola de pacientes regulares.
    private int contadorPreferenciales; // Cuenta cuántos pacientes preferenciales se atendieron de forma seguida.

    public GestorAtencion(ColaPacientes colaPreferencial, ColaPacientes colaRegular) { // Constructor que recibe las dos colas.
        this.colaPreferencial = colaPreferencial; // Asigna la cola preferencial recibida al atributo colaPreferencial.
        this.colaRegular = colaRegular; // Asigna la cola regular recibida al atributo colaRegular.
        this.contadorPreferenciales = 0; // Inicializa el contador de preferenciales en cero.
    } 

    public Paciente atenderPaciente() { // Método que atiende un paciente según la regla 2 preferenciales y 1 regular.
        Paciente pacienteAtendido = null; // Variable donde se guardará el paciente que será atendido.
        if (!colaPreferencial.esVacia() && !colaRegular.esVacia()) { // Valida si ambas colas tienen pacientes.
            if (contadorPreferenciales < 2) { // Valida si todavía no se han atendido 2 preferenciales seguidos.
                pacienteAtendido = colaPreferencial.desencolar(); // Saca el primer paciente de la cola preferencial.
                contadorPreferenciales++; // Aumenta el contador de pacientes preferenciales atendidos.
            } 
   
            else { // Si ya se atendieron 2 pacientes preferenciales seguidos.
                pacienteAtendido = colaRegular.desencolar(); // Saca el primer paciente de la cola regular.
                contadorPreferenciales = 0; // Reinicia el contador de preferenciales.
            } 
        } 
       
        else if (!colaPreferencial.esVacia()) { // Valida si solo hay pacientes preferenciales.
            pacienteAtendido = colaPreferencial.desencolar(); // Saca el primer paciente preferencial.
            contadorPreferenciales++; // Aumenta el contador de preferenciales.
        } 
        
        else if (!colaRegular.esVacia()) { // Valida si solo hay pacientes regulares.
            pacienteAtendido = colaRegular.desencolar(); // Saca el primer paciente regular.
            contadorPreferenciales = 0; // Reinicia el contador de preferenciales.
        } 
        
        else { // Si no hay pacientes en ninguna cola.
            System.out.println("No hay pacientes pendientes por atender."); // Muestra mensaje si ambas colas están vacías.
            return null; // Retorna null porque no hay paciente para atender.
        } 

        System.out.println("Ficha # " + pacienteAtendido.getFicha() + " con cédula " + pacienteAtendido.getCedula() + " pasar a consulta médica."); 
        return pacienteAtendido; // Retorna el paciente que fue atendido.
    } 

} 