/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_5_pfa1;

/**
 * Clase que representa un medicamento prescrito durante una cita médica.
 * Esta clase se utiliza en el Avance 2 para guardar el histórico
 * de medicamentos dentro del expediente del paciente.
 *
 * @author Grupo 5
 */
public class Medicamento {

    private String nombreMedicamento;
    private String dosis;
    private String frecuencia;
    private String duracion;
    private String indicaciones;

    /**
     * Constructor vacío de la clase Medicamento.
     */
    public Medicamento() {
    }

    /**
     * Constructor con parámetros de la clase Medicamento.
     *
     * @param nombreMedicamento Nombre del medicamento prescrito.
     * @param dosis Dosis indicada por el doctor.
     * @param frecuencia Frecuencia con la que debe tomarse el medicamento.
     * @param duracion Duración del tratamiento.
     * @param indicaciones Indicaciones adicionales del medicamento.
     */
    public Medicamento(String nombreMedicamento, String dosis, String frecuencia,
            String duracion, String indicaciones) {

        this.nombreMedicamento = nombreMedicamento;
        this.dosis = dosis;
        this.frecuencia = frecuencia;
        this.duracion = duracion;
        this.indicaciones = indicaciones;
    }

    /**
     * Retorna el nombre del medicamento.
     *
     * @return Nombre del medicamento.
     */
    public String getNombreMedicamento() {
        return nombreMedicamento;
    }

    /**
     * Modifica el nombre del medicamento.
     *
     * @param nombreMedicamento Nuevo nombre del medicamento.
     */
    public void setNombreMedicamento(String nombreMedicamento) {
        this.nombreMedicamento = nombreMedicamento;
    }

    /**
     * Retorna la dosis del medicamento.
     *
     * @return Dosis indicada.
     */
    public String getDosis() {
        return dosis;
    }

    /**
     * Modifica la dosis del medicamento.
     *
     * @param dosis Nueva dosis indicada.
     */
    public void setDosis(String dosis) {
        this.dosis = dosis;
    }

    /**
     * Retorna la frecuencia del medicamento.
     *
     * @return Frecuencia indicada.
     */
    public String getFrecuencia() {
        return frecuencia;
    }

    /**
     * Modifica la frecuencia del medicamento.
     *
     * @param frecuencia Nueva frecuencia indicada.
     */
    public void setFrecuencia(String frecuencia) {
        this.frecuencia = frecuencia;
    }

    /**
     * Retorna la duración del tratamiento.
     *
     * @return Duración del tratamiento.
     */
    public String getDuracion() {
        return duracion;
    }

    /**
     * Modifica la duración del tratamiento.
     *
     * @param duracion Nueva duración del tratamiento.
     */
    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    /**
     * Retorna las indicaciones adicionales.
     *
     * @return Indicaciones del medicamento.
     */
    public String getIndicaciones() {
        return indicaciones;
    }

    /**
     * Modifica las indicaciones adicionales.
     *
     * @param indicaciones Nuevas indicaciones del medicamento.
     */
    public void setIndicaciones(String indicaciones) {
        this.indicaciones = indicaciones;
    }

    /**
     * Retorna la información del medicamento en formato texto.
     *
     * @return Datos completos del medicamento.
     */
    public String mostrarDatos() {

        return "Medicamento: " + nombreMedicamento + "\nDosis: " + dosis + "\nFrecuencia: " + frecuencia + "\nDuración: " + duracion + "\nIndicaciones: " + indicaciones;
    }
}