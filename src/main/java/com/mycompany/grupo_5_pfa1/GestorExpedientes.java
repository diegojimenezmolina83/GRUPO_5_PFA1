/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_5_pfa1;

import java.util.Date;
import java.util.Scanner;

/**
 * Clase encargada de gestionar la creación y actualización
 * del expediente único de pacientes durante la atención médica.
 *
 * @author Diego
 */
public class GestorExpedientes {

    /**
     * Constructor vacío de la clase GestorExpedientes.
     */
    public GestorExpedientes() {
    }

    /**
     * Procesa la atención médica de un paciente.
     * Busca si el paciente ya existe en el expediente único. Si no existe,
     * crea un nuevo expediente. Luego registra la cita, medicamentos
     * y alimenta la bitácora de citas del día.
     *
     * @param paciente Paciente que será atendido.
     * @param listaExpedientes Lista doble circular de expedientes.
     * @param listaBitacora Lista simple de bitácora del día.
     * @param entrada Scanner para ingreso de datos.
     */
    public void procesarAtencion(Paciente paciente,
            ListaExpedientes listaExpedientes,
            ListaBitacora listaBitacora,
            Scanner entrada) {

        Date fechaHoraAtencion = new Date();

        System.out.println("\n====================================");
        System.out.println("DATOS DE LA FICHA SELECCIONADA");
        System.out.println("====================================");
        System.out.println("Ficha: " + paciente.getFicha());
        System.out.println("Cédula: " + paciente.getCedula());
        System.out.println("Nombre: " + paciente.getNombre());

        Expediente expediente = listaExpedientes.buscarPorCedula(paciente.getCedula());

        if (expediente == null) {

            System.out.println("\nPaciente " + paciente.getNombre() + " asiste a consulta por primera vez.");

            System.out.println("\nIngrese los datos del paciente:");

            System.out.print("Nombre completo: ");
            String nombreCompleto = entrada.nextLine();

            System.out.print("Edad: ");
            int edad = entrada.nextInt();
            entrada.nextLine();

            System.out.print("Género: ");
            String genero = entrada.nextLine();

            expediente = new Expediente(paciente.getCedula(), nombreCompleto, edad, genero);

            listaExpedientes.insertarFinal(expediente);

        } else {

            System.out.println("\nPaciente existente en expediente único.");
            System.out.println("------------------------------------");
            System.out.println(expediente.mostrarDatosGenerales());
        }

        System.out.println("\n====================================");
        System.out.println("DATOS DE LA CITA ACTUAL");
        System.out.println("====================================");

        System.out.print("Motivo de consulta: ");
        String motivoConsulta = entrada.nextLine();

        System.out.print("Diagnóstico: ");
        String diagnostico = entrada.nextLine();

        System.out.print("Observaciones: ");
        String observaciones = entrada.nextLine();

        Cita cita = new Cita(fechaHoraAtencion, motivoConsulta, diagnostico, observaciones);

        expediente.agregarCita(cita);

        System.out.println("\n====================================");
        System.out.println("MEDICAMENTOS PRESCRITOS");
        System.out.println("====================================");

        System.out.print("Cantidad de medicamentos prescritos: ");
        int cantidadMedicamentos = entrada.nextInt();
        entrada.nextLine();

        for (int i = 0; i < cantidadMedicamentos; i++) {

            System.out.println("\nMedicamento #" + (i + 1));

            System.out.print("Nombre del medicamento: ");
            String nombreMedicamento = entrada.nextLine();

            System.out.print("Dosis: ");
            String dosis = entrada.nextLine();

            System.out.print("Frecuencia: ");
            String frecuencia = entrada.nextLine();

            System.out.print("Duración: ");
            String duracion = entrada.nextLine();

            System.out.print("Indicaciones: ");
            String indicaciones = entrada.nextLine();

            Medicamento medicamento = new Medicamento(nombreMedicamento, dosis, frecuencia, duracion, indicaciones);

            expediente.agregarMedicamento(medicamento);
        }

        BitacoraCita bitacoraCita = new BitacoraCita( expediente.getCedula(), expediente.getNombreCompleto(),paciente.getFechaLlegada(), fechaHoraAtencion);

        listaBitacora.insertarFinal(bitacoraCita);

        System.out.println("\nPaciente " + expediente.getNombreCompleto()
                + ", su cita ha concluido.");
    }
}
