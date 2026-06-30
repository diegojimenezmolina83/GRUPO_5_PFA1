package com.mycompany.grupo_5_pfa1;

import java.util.Date;

/**
 * Representa la queja generada cuando un paciente abandona la cola
 * sin haber sido atendido.
 * 
 * Almacena el número de ficha del paciente, su cédula, el motivo declarado
 * y la fecha y hora exacta en que abandonó la cola.
 *
 * @author Grupo 5
 * @version 1.0
 * @see PilaQuejas
 * @see NodoQueja
 */
public class Queja {

    /**
     * Número de ficha del paciente que abandonó la cola.
     */
    private String ficha;

    /**
     * Cédula de identidad del paciente que abandonó la cola.
     */
    private String cedula;

    /**
     * Motivo declarado por el paciente al abandonar la cola.
     */
    private String motivo;

    /**
     * Fecha y hora en que el paciente abandonó la cola.
     */
    private Date fechaSalida;

    /**
     * Construye una {@code Queja} sin inicializar ningún atributo.
     */
    public Queja() {
    }

    /**
     * Construye una {@code Queja} con todos sus atributos inicializados.
     *
     * @param ficha       número de ficha del paciente
     * @param cedula      cédula de identidad del paciente
     * @param motivo      motivo por el cual el paciente abandona la cola
     * @param fechaSalida fecha y hora en que el paciente abandona la cola
     */
    public Queja(String ficha, String cedula, String motivo, Date fechaSalida) {
        this.ficha = ficha;
        this.cedula = cedula;
        this.motivo = motivo;
        this.fechaSalida = fechaSalida;
    }

    /**
     * Retorna el número de ficha asociado a esta queja.
     *
     * @return número de ficha del paciente
     */
    public String getFicha() {
        return ficha;
    }

    /**
     * Asigna el número de ficha asociado a esta queja.
     *
     * @param ficha número de ficha a asignar
     */
    public void setFicha(String ficha) {
        this.ficha = ficha;
    }

    /**
     * Retorna la cédula del paciente asociado a esta queja.
     *
     * @return cédula de identidad del paciente
     */
    public String getCedula() {
        return cedula;
    }

    /**
     * Asigna la cédula del paciente asociado a esta queja.
     *
     * @param cedula cédula de identidad a asignar
     */
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    /**
     * Retorna el motivo declarado por el paciente al abandonar la cola.
     *
     * @return motivo de abandono
     */
    public String getMotivo() {
        return motivo;
    }

    /**
     * Asigna el motivo declarado por el paciente al abandonar la cola.
     *
     * @param motivo motivo de abandono a asignar
     */
    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    /**
     * Retorna la fecha y hora en que el paciente abandonó la cola.
     *
     * @return fecha y hora de salida
     */
    public Date getFechaSalida() {
        return fechaSalida;
    }

    /**
     * Asigna la fecha y hora en que el paciente abandonó la cola.
     *
     * @param fechaSalida fecha y hora de salida a asignar
     */
    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    /**
     * Genera el mensaje formal de la queja según el formato requerido por el enunciado.
     * 
     * Ejemplo de salida:
     * {@code Ficha # R3 con cédula 123456789 abandona la cola sin ser atendido (a)
     * a la fecha y hora Mon Jun 29 10:30:00 COT 2026 por el siguiente motivo: Tiempo de espera.}
     *
     * @return cadena con el mensaje completo de la queja
     */
    public String generarMensaje() {
        return "Ficha # " + ficha + " con cédula " + cedula
            + " abandona la cola sin ser atendido (a) a la fecha y hora "
            + fechaSalida + " por el siguiente motivo: " + motivo;
    }
}
