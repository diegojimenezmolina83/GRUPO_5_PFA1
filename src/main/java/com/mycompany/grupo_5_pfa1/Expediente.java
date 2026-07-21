/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_5_pfa1;

/**
 * Clase que representa el expediente único de un paciente.
 * Esta clase almacena los datos generales del paciente, su histórico
 * de citas y su histórico de medicamentos.
 *
 * @author Diego
 */
public class Expediente {

    private String cedula;
    private String nombreCompleto;
    private int edad;
    private String genero;
    private ListaCitas historialCitas;
    private ListaMedicamentos historialMedicamentos;

    /**
     * Constructor vacío de la clase Expediente.
     */
    public Expediente() {

        this.historialCitas = new ListaCitas();
        this.historialMedicamentos = new ListaMedicamentos();
    }

    /**
     * Constructor con parámetros de la clase Expediente.
     *
     * @param cedula Cédula del paciente.
     * @param nombreCompleto Nombre completo del paciente.
     * @param edad Edad del paciente.
     * @param genero Género del paciente.
     */
    public Expediente(String cedula, String nombreCompleto, int edad, String genero) {

        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.genero = genero;
        this.historialCitas = new ListaCitas();
        this.historialMedicamentos = new ListaMedicamentos();
    }

    /**
     * Retorna la cédula del paciente.
     *
     * @return Cédula del paciente.
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Modifica la cédula del paciente.
     *
     * @param cedula Nueva cédula.
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Retorna el nombre completo del paciente.
     *
     * @return Nombre completo del paciente.
     */
    public String getNombreCompleto() {
        return nombreCompleto;
    }

    /**
     * Modifica el nombre completo del paciente.
     *
     * @param nombreCompleto Nuevo nombre completo.
     */
    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    /**
     * Retorna la edad del paciente.
     *
     * @return Edad del paciente.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Modifica la edad del paciente.
     *
     * @param edad Nueva edad del paciente.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Retorna el género del paciente.
     *
     * @return Género del paciente.
     */
    public String getGenero() {
        return genero;
    }

    /**
     * Modifica el género del paciente.
     *
     * @param genero Nuevo género del paciente.
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * Retorna el historial de citas del paciente.
     *
     * @return Lista de citas.
     */
    public ListaCitas getHistorialCitas() {
        return historialCitas;
    }

    /**
     * Modifica el historial de citas del paciente.
     *
     * @param historialCitas Nueva lista de citas.
     */
    public void setHistorialCitas(ListaCitas historialCitas) {
        this.historialCitas = historialCitas;
    }

    /**
     * Retorna el historial de medicamentos del paciente.
     *
     * @return Lista de medicamentos.
     */
    public ListaMedicamentos getHistorialMedicamentos() {
        return historialMedicamentos;
    }

    /**
     * Modifica el historial de medicamentos del paciente.
     *
     * @param historialMedicamentos Nueva lista de medicamentos.
     */
    public void setHistorialMedicamentos(ListaMedicamentos historialMedicamentos) {
        this.historialMedicamentos = historialMedicamentos;
    }

    /**
     * Agrega una cita al historial del expediente.
     *
     * @param cita Cita que se desea agregar.
     */
    public void agregarCita(Cita cita) {

        historialCitas.insertarFinal(cita);
    }

    /**
     * Agrega un medicamento al historial del expediente.
     *
     * @param medicamento Medicamento que se desea agregar.
     */
    public void agregarMedicamento(Medicamento medicamento) {

        historialMedicamentos.insertarFinal(medicamento);
    }

    /**
     * Retorna los datos generales del paciente.
     *
     * @return Información general del expediente.
     */
    public String mostrarDatosGenerales() {

        return "Cédula: " + cedula
                + "\nNombre completo: " + nombreCompleto
                + "\nEdad: " + edad
                + "\nGénero: " + genero;
    }

    /**
     * Retorna toda la información del expediente del paciente.
     *
     * @return Información completa del expediente.
     */
    public String mostrarExpedienteCompleto() {

        return "DATOS DEL PACIENTE"
                + "\n-----------------------------"
                + "\n" + mostrarDatosGenerales()
                + "\n\nHISTÓRICO DE CITAS"
                + "\n-----------------------------"
                + "\n" + historialCitas.mostrarCitas()
                + "\nHISTÓRICO DE MEDICAMENTOS"
                + "\n-----------------------------"
                + "\n" + historialMedicamentos.mostrarMedicamentos();
    }
}