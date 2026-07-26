/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_5_pfa1;

import java.util.Date;
import javax.swing.JOptionPane;

/**
 * Clase encargada de gestionar la creación y actualización
 * del expediente único de pacientes durante la atención médica.
 *
 * @author Grupo 5
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
     */
    public void procesarAtencion(Paciente paciente,
            ListaExpedientes listaExpedientes,
            ListaBitacora listaBitacora) {

        Date fechaHoraAtencion = new Date();

        JOptionPane.showMessageDialog(null,
                "DATOS DE LA FICHA SELECCIONADA"
                + "\n-----------------------------"
                + "\nFicha: " + paciente.getFicha()
                + "\nCédula: " + paciente.getCedula()
                + "\nNombre registrado: " + paciente.getNombre(),
                "Atender Paciente",
                JOptionPane.INFORMATION_MESSAGE);

        Expediente expediente = listaExpedientes.buscarPorCedula(paciente.getCedula());

        if (expediente == null) {

            JOptionPane.showMessageDialog(null,
                    "Paciente " + paciente.getNombre()
                    + " asiste a consulta por primera vez.",
                    "Expediente nuevo",
                    JOptionPane.INFORMATION_MESSAGE);

            String nombreCompleto = JOptionPane.showInputDialog(null,
                    "Ingrese el nombre completo del paciente:",
                    paciente.getNombre());

            if (nombreCompleto == null || nombreCompleto.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "Nombre inválido. Atención cancelada.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            String textoEdad = JOptionPane.showInputDialog(null,
                    "Ingrese la edad del paciente:",
                    "Datos del Paciente",
                    JOptionPane.PLAIN_MESSAGE);

            if (textoEdad == null || textoEdad.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "Edad inválida. Atención cancelada.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            int edad = Integer.parseInt(textoEdad.trim());

            String genero = JOptionPane.showInputDialog(null,
                    "Ingrese el género del paciente:",
                    "Datos del Paciente",
                    JOptionPane.PLAIN_MESSAGE);

            if (genero == null || genero.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null,
                        "Género inválido. Atención cancelada.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }

            expediente = new Expediente(paciente.getCedula(),
                    nombreCompleto.trim(),
                    edad,
                    genero.trim());

            listaExpedientes.insertarFinal(expediente);

        } else {

            JOptionPane.showMessageDialog(null,
                    "Paciente existente en expediente único."
                    + "\n-----------------------------"
                    + "\n" + expediente.mostrarDatosGenerales(),
                    "Expediente existente",
                    JOptionPane.INFORMATION_MESSAGE);
        }

        String motivoConsulta = JOptionPane.showInputDialog(null,
                "Ingrese el motivo de consulta:",
                "Datos de la Cita Actual",
                JOptionPane.PLAIN_MESSAGE);

        if (motivoConsulta == null || motivoConsulta.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Motivo de consulta inválido. Atención cancelada.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String diagnostico = JOptionPane.showInputDialog(null,
                "Ingrese el diagnóstico:",
                "Datos de la Cita Actual",
                JOptionPane.PLAIN_MESSAGE);

        if (diagnostico == null || diagnostico.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null,
                    "Diagnóstico inválido. Atención cancelada.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String observaciones = JOptionPane.showInputDialog(null,
                "Ingrese las observaciones:",
                "Datos de la Cita Actual",
                JOptionPane.PLAIN_MESSAGE);

        if (observaciones == null || observaciones.trim().isEmpty()) {
            observaciones = "Sin observaciones.";
        }

        Cita cita = new Cita(fechaHoraAtencion,
                motivoConsulta.trim(),
                diagnostico.trim(),
                observaciones.trim());

        expediente.agregarCita(cita);

        String textoCantidadMedicamentos = JOptionPane.showInputDialog(null,
                "Ingrese la cantidad de medicamentos prescritos:",
                "Medicamentos Prescritos",
                JOptionPane.PLAIN_MESSAGE);

        if (textoCantidadMedicamentos == null
                || textoCantidadMedicamentos.trim().isEmpty()) {

            textoCantidadMedicamentos = "0";
        }

        int cantidadMedicamentos = Integer.parseInt(textoCantidadMedicamentos.trim());

        for (int i = 0; i < cantidadMedicamentos; i++) {

            String nombreMedicamento = JOptionPane.showInputDialog(null,
                    "Medicamento #" + (i + 1)
                    + "\nIngrese el nombre del medicamento:",
                    "Medicamentos Prescritos",
                    JOptionPane.PLAIN_MESSAGE);

            if (nombreMedicamento == null || nombreMedicamento.trim().isEmpty()) {
                nombreMedicamento = "No indicado";
            }

            String dosis = JOptionPane.showInputDialog(null,
                    "Ingrese la dosis:",
                    "Medicamentos Prescritos",
                    JOptionPane.PLAIN_MESSAGE);

            if (dosis == null || dosis.trim().isEmpty()) {
                dosis = "No indicada";
            }

            String frecuencia = JOptionPane.showInputDialog(null,
                    "Ingrese la frecuencia:",
                    "Medicamentos Prescritos",
                    JOptionPane.PLAIN_MESSAGE);

            if (frecuencia == null || frecuencia.trim().isEmpty()) {
                frecuencia = "No indicada";
            }

            String duracion = JOptionPane.showInputDialog(null,
                    "Ingrese la duración:",
                    "Medicamentos Prescritos",
                    JOptionPane.PLAIN_MESSAGE);

            if (duracion == null || duracion.trim().isEmpty()) {
                duracion = "No indicada";
            }

            String indicaciones = JOptionPane.showInputDialog(null,
                    "Ingrese las indicaciones:",
                    "Medicamentos Prescritos",
                    JOptionPane.PLAIN_MESSAGE);

            if (indicaciones == null || indicaciones.trim().isEmpty()) {
                indicaciones = "Sin indicaciones adicionales.";
            }

            Medicamento medicamento = new Medicamento(nombreMedicamento.trim(),
                    dosis.trim(),
                    frecuencia.trim(),
                    duracion.trim(),
                    indicaciones.trim());

            expediente.agregarMedicamento(medicamento);
        }

        BitacoraCita bitacoraCita = new BitacoraCita(
                expediente.getCedula(),
                expediente.getNombreCompleto(),
                paciente.getFechaLlegada(),
                fechaHoraAtencion);

        listaBitacora.insertarFinal(bitacoraCita);

        JOptionPane.showMessageDialog(null,
                "Paciente " + expediente.getNombreCompleto()
                + ", su cita ha concluido.",
                "Cita finalizada",
                JOptionPane.INFORMATION_MESSAGE);
    }
}
