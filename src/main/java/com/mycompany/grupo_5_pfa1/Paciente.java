package com.mycompany.grupo_5_pfa1;

import java.util.Date;

/**
 * Representa a un paciente registrado en el sistema de atención del hospital.
 * 
 * Almacena el número de ficha asignado, la cédula de identidad, el nombre
 * completo y la fecha y hora de llegada del paciente.
 *
 * @author Grupo 5
 * @version 1.0
 */
public class Paciente {

    /**
     * Número de ficha asignado al paciente (por ejemplo, {@code R1} o {@code P1}).
     */
    private String ficha;

    /**
     * Número de cédula de identidad del paciente.
     */
    private String cedula;

    /**
     * Nombre completo del paciente.
     */
    private String nombre;

    /**
     * Fecha y hora en que el paciente llegó al hospital.
     */
    private Date fechaLlegada;

    /**
     * Construye un {@code Paciente} sin inicializar ningún atributo.
     */
    public Paciente() {
    }

    /**
     * Construye un {@code Paciente} con todos sus atributos inicializados.
     *
     * @param ficha        número de ficha asignado al paciente
     * @param cedula       número de cédula de identidad del paciente
     * @param nombre       nombre completo del paciente
     * @param fechaLlegada fecha y hora de llegada al hospital
     */
    public Paciente(String ficha, String cedula, String nombre, Date fechaLlegada) {
        this.ficha = ficha;
        this.cedula = cedula;
        this.nombre = nombre;
        this.fechaLlegada = fechaLlegada;
    }

    /**
     * Retorna el número de ficha del paciente.
     *
     * @return número de ficha (por ejemplo, {@code "R1"} o {@code "P2"})
     */
    public String getFicha() {
        return ficha;
    }

    /**
     * Asigna el número de ficha del paciente.
     *
     * @param ficha número de ficha a asignar
     */
    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    /**
     * Retorna el número de cédula del paciente.
     *
     * @return cédula de identidad del paciente
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Asigna el número de cédula del paciente.
     *
     * @param cedula cédula de identidad a asignar
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Retorna el nombre completo del paciente.
     *
     * @return nombre completo del paciente
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Asigna el nombre completo del paciente.
     *
     * @param nombre nombre completo a asignar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Retorna la fecha y hora de llegada del paciente al hospital.
     *
     * @return fecha y hora de llegada
     */
    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    /**
     * Asigna la fecha y hora de llegada del paciente al hospital.
     *
     * @param fechaLlegada fecha y hora de llegada a asignar
     */
    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }
}
