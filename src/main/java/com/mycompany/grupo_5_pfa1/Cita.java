/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_5_pfa1;

import java.util.Date;

/**
 * Clase que representa una cita médica realizada a un paciente.
 * Esta clase se utiliza en el Avance 2 para guardar el histórico
 * de citas dentro del expediente del paciente.
 *
 * @author Diego
 */
public class Cita {

    private Date fechaHoraCita;
    private String motivoConsulta;
    private String diagnostico;
    private String observaciones;

    /**
     * Constructor vacío de la clase Cita.
     */
    public Cita() {
    }

    /**
     * Constructor con parámetros de la clase Cita.
     *
     * @param fechaHoraCita Fecha y hora en que se realiza la cita.
     * @param motivoConsulta Motivo por el cual el paciente asiste a consulta.
     * @param diagnostico Diagnóstico indicado por el doctor.
     * @param observaciones Observaciones generales de la cita.
     */
    public Cita(Date fechaHoraCita, String motivoConsulta, String diagnostico, String observaciones) {

        this.fechaHoraCita = fechaHoraCita;
        this.motivoConsulta = motivoConsulta;
        this.diagnostico = diagnostico;
        this.observaciones = observaciones;
    }

    public Date getFechaHoraCita() {
        return fechaHoraCita;
    }

    public void setFechaHoraCita(Date fechaHoraCita) {
        this.fechaHoraCita = fechaHoraCita;
    }

    public String getMotivoConsulta() {
        return motivoConsulta;
    }

    public void setMotivoConsulta(String motivoConsulta) {
        this.motivoConsulta = motivoConsulta;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    /**
     * Retorna la información de la cita en formato texto.
     *
     * @return Datos completos de la cita.
     */
    public String mostrarDatos() {

        return "Fecha y hora: " + fechaHoraCita + "\nMotivo de consulta: " + motivoConsulta + "\nDiagnóstico: " + diagnostico + "\nObservaciones: " + observaciones;
    }
}