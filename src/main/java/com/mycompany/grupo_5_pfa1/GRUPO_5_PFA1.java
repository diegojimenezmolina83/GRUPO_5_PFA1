/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.grupo_5_pfa1;
import java.util.Date; 

/**
 * @author Grupo 5
 */

public class GRUPO_5_PFA1 { 

    /**
     * Método principal del programa.
     * @author Grupo 5
     * @param args Argumentos del programa.
     */
    
    public static void main(String[] args) {

        // Muestra mensaje de bienvenida del sistema.
        System.out.println("Bienvenido al sistema del Hospital Su Salud!");

        // Muestra mensaje informativo.
        System.out.println("Prueba de estructuras: Colas y Pila");

        // Crea la cola para pacientes regulares.
        ColaPacientes colaRegular = new ColaPacientes();

        // Crea la cola para pacientes preferenciales.
        ColaPacientes colaPreferencial = new ColaPacientes();

        // Crea la pila que almacenará las quejas.
        PilaQuejas pilaQuejas = new PilaQuejas();

        // Crea el gestor encargado de atender pacientes.
        GestorAtencion gestor = new GestorAtencion(colaPreferencial, colaRegular);

        // **
        // CREACIÓN DE PACIENTES
        // **

        // Crea paciente regular número 1.
        Paciente paciente1 = new Paciente("R1","101010101","Carlos Mora",new Date());

        // Crea paciente regular número 2.
        Paciente paciente2 = new Paciente("R2","202020202","Ana Solis",new Date());

        // Crea paciente preferencial número 1.
        Paciente paciente3 = new Paciente("P1","303030303","Luis Rojas",new Date());

        // Crea paciente preferencial número 2.
        Paciente paciente4 = new Paciente("P2","404040404","Maria Perez",new Date());

        // Crea paciente preferencial número 3.
        Paciente paciente5 = new Paciente("P3","505050505","Jorge Castro",new Date());

        // **
        // INSERTAR PACIENTES EN COLAS
        // **

        // Inserta paciente regular 1 en la cola regular.
        colaRegular.encolar(paciente1);

        // Inserta paciente regular 2 en la cola regular.
        colaRegular.encolar(paciente2);

        // Inserta paciente preferencial 1 en la cola preferencial.
        colaPreferencial.encolar(paciente3);

        // Inserta paciente preferencial 2 en la cola preferencial.
        colaPreferencial.encolar(paciente4);

        // Inserta paciente preferencial 3 en la cola preferencial.
        colaPreferencial.encolar(paciente5);

        // Imprime línea en blanco.
        System.out.println();

        // Muestra título.
        System.out.println("Fichas pendientes antes de atender:");

        // Muestra pacientes regulares pendientes.
        colaRegular.mostrarCola("[REGULAR - VERDE]");

        // Muestra pacientes preferenciales pendientes.
        colaPreferencial.mostrarCola("[PREFERENCIAL - NARANJA]");

        // Imprime línea en blanco.
        System.out.println();

        // Muestra título.
        System.out.println("Atencion de pacientes:");

        // Atiende primer paciente.
        gestor.atenderPaciente();

        // Atiende segundo paciente.
        gestor.atenderPaciente();

        // Atiende tercer paciente.
        gestor.atenderPaciente();

        // Imprime línea en blanco.
        System.out.println();

        // Muestra título.
        System.out.println("Fichas pendientes despues de atender:");

        // Muestra cola regular actualizada.
        colaRegular.mostrarCola("[REGULAR - VERDE]");

        // Muestra cola preferencial actualizada.
        colaPreferencial.mostrarCola("[PREFERENCIAL - NARANJA]");

        // Imprime línea en blanco.
        System.out.println();

        // Muestra título para la prueba de abandono.
        System.out.println("Prueba de abandono de cola:");

        // Elimina de la cola regular el paciente con ficha R2.
        Paciente pacienteEliminado = colaRegular.eliminarPorFicha("R2");

        // Verifica si el paciente fue encontrado.
        if (pacienteEliminado != null) {

            // Muestra mensaje solicitado por el enunciado.
            System.out.println("Ficha # " + pacienteEliminado.getFicha() + " con cédula " + pacienteEliminado.getCedula() + " abandona la cola sin ser atendido (a).");

            // Crea la queja asociada al paciente.
            Queja queja = new Queja(pacienteEliminado.getFicha(),pacienteEliminado.getCedula(),"Tiempo de espera muy alto",new Date());

            // Inserta la queja en la pila.
            pilaQuejas.apilar(queja);
        } 
        
        else {

            // Muestra mensaje si no se encontró la ficha.
            System.out.println("No se encontró la ficha indicada.");
        }

        // Imprime línea en blanco.
        System.out.println();

        // Muestra título.
        System.out.println("Fichas pendientes despues del abandono:");

        // Muestra cola regular actualizada.
        colaRegular.mostrarCola("[REGULAR - VERDE]");

        // Muestra cola preferencial actualizada.
        colaPreferencial.mostrarCola("[PREFERENCIAL - NARANJA]");

        // Imprime línea en blanco.
        System.out.println();

        // Muestra título.
        System.out.println("Quejas recibidas:");

        // Muestra todas las quejas almacenadas en la pila.
        pilaQuejas.mostrarPila();

    } 
} 