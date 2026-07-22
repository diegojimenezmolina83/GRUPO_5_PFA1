/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_5_pfa1;

import java.util.Date;

/**
 * Clase que representa una cita atendida durante la sesión actual.
 * Se utiliza para alimentar la bitácora de citas del día.
 *
 * @author Diego
 */
public class BitacoraCita {

    private String cedula;
    private String nombreCompleto;
    private Date fechaHoraLlegada;
    private Date fechaHoraAtencion;
    private long tiempoEsperaSegundos;
    private String codigoColor;

    /**
     * Constructor vacío de la clase BitacoraCita.
     */
    public BitacoraCita() {
    }

    /**
     * Constructor con parámetros de la clase BitacoraCita.
     *
     * @param cedula Cédula del paciente.
     * @param nombreCompleto Nombre completo del paciente.
     * @param fechaHoraLlegada Fecha y hora en que el paciente tomó ficha.
     * @param fechaHoraAtencion Fecha y hora en que el paciente fue atendido.
     */
    public BitacoraCita(String cedula, String nombreCompleto,Date fechaHoraLlegada, Date fechaHoraAtencion) {

        this.cedula = cedula;
        this.nombreCompleto = nombreCompleto;
        this.fechaHoraLlegada = fechaHoraLlegada;
        this.fechaHoraAtencion = fechaHoraAtencion;
        this.tiempoEsperaSegundos = calcularTiempoEspera();
        this.codigoColor = calcularCodigoColor();
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
     * Retorna la fecha y hora de llegada.
     *
     * @return Fecha y hora de llegada.
     */
    public Date getFechaHoraLlegada() {
        return fechaHoraLlegada;
    }

    /**
     * Modifica la fecha y hora de llegada.
     *
     * @param fechaHoraLlegada Nueva fecha y hora de llegada.
     */
    public void setFechaHoraLlegada(Date fechaHoraLlegada) {
        this.fechaHoraLlegada = fechaHoraLlegada;
    }

    /**
     * Retorna la fecha y hora de atención.
     *
     * @return Fecha y hora de atención.
     */
    public Date getFechaHoraAtencion() {
        return fechaHoraAtencion;
    }

    /**
     * Modifica la fecha y hora de atención.
     *
     * @param fechaHoraAtencion Nueva fecha y hora de atención.
     */
    public void setFechaHoraAtencion(Date fechaHoraAtencion) {
        this.fechaHoraAtencion = fechaHoraAtencion;
    }

    /**
     * Retorna el tiempo de espera en segundos.
     *
     * @return Tiempo de espera en segundos.
     */
    public long getTiempoEsperaSegundos() {
        return tiempoEsperaSegundos;
    }

    /**
     * Modifica el tiempo de espera en segundos.
     *
     * @param tiempoEsperaSegundos Nuevo tiempo de espera.
     */
    public void setTiempoEsperaSegundos(long tiempoEsperaSegundos) {
        this.tiempoEsperaSegundos = tiempoEsperaSegundos;
    }

    /**
     * Retorna el código de color según el tiempo de espera.
     *
     * @return Código de color.
     */
    public String getCodigoColor() {
        return codigoColor;
    }

    /**
     * Modifica el código de color.
     *
     * @param codigoColor Nuevo código de color.
     */
    public void setCodigoColor(String codigoColor) {
        this.codigoColor = codigoColor;
    }

    /**
     * Calcula el tiempo de espera en segundos.
     *
     * @return Tiempo de espera en segundos.
     */
    public long calcularTiempoEspera() {

        long diferenciaMilisegundos = fechaHoraAtencion.getTime()
                - fechaHoraLlegada.getTime();

        return diferenciaMilisegundos / 1000;
    }

    /**
     * Calcula el código de color según el tiempo de espera.
     *
     * @return Verde, amarillo o rojo.
     */
    public String calcularCodigoColor() {

        if (tiempoEsperaSegundos <= 30) {

            return "VERDE";

        } else if (tiempoEsperaSegundos < 60) {

            return "AMARILLO";

        } else {

            return "ROJO";
        }
    }

    /**
     * Retorna los datos de la bitácora en formato texto.
     *
     * @return Información de la cita atendida.
     */
    public String mostrarDatos() {

        return "Cédula: " + cedula
                + "\nNombre completo: " + nombreCompleto
                + "\nLlegada: " + fechaHoraLlegada
                + "\nAtención: " + fechaHoraAtencion
                + "\nTiempo de espera: " + tiempoEsperaSegundos + " segundos"
                + "\nCódigo de color: " + codigoColor;
    }
}
