/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_5_pfa1;
import java.util.Date; 

/**
 *
 * @author Grupo 5
 */
public class Queja { // Inicio de la clase Queja.
    // Sección de atributos.
    private String ficha; // Guarda el número de ficha del paciente que abandonó la cola.
    private String cedula; // Guarda la cédula del paciente que abandonó la cola.
    private String motivo; // Guarda el motivo por el cual el paciente abandonó la cola.
    private Date fechaSalida; // Guarda la fecha y hora en que el paciente abandonó la cola.

    // Sección de constructores.
    public Queja() { // Constructor vacío de la clase Queja.
    } 
    public Queja(String ficha, String cedula, String motivo, Date fechaSalida) { // Constructor con parámetros.
        this.ficha = ficha; // Asigna la ficha recibida al atributo ficha.
        this.cedula = cedula; // Asigna la cédula recibida al atributo cedula.
        this.motivo = motivo; // Asigna el motivo recibido al atributo motivo.
        this.fechaSalida = fechaSalida; // Asigna la fecha recibida al atributo fechaSalida.
    } 

    // Sección de getter y setter.
    public String getFicha() { // Método getter que retorna la ficha.
        return ficha; // Retorna la ficha de la queja.
    } 
    public void setFicha(String ficha) { // Método setter que recibe la ficha.
        this.ficha = ficha; // Asigna la ficha recibida al atributo ficha.
    } 
    public String getCedula() { // Método getter que retorna la cédula.
        return cedula; // Retorna la cédula de la queja.
    } 
    public void setCedula(String cedula) { // Método setter que recibe la cédula.
        this.cedula = cedula; // Asigna la cédula recibida al atributo cedula.
    } 
    public String getMotivo() { // Método getter que retorna el motivo.
        return motivo; // Retorna el motivo de la queja.
    } 
    public void setMotivo(String motivo) { // Método setter que recibe el motivo.
        this.motivo = motivo; // Asigna el motivo recibido al atributo motivo.
    } 
    public Date getFechaSalida() { // Método getter que retorna la fecha de salida.
        return fechaSalida; // Retorna la fecha y hora de salida.
    } 
    public void setFechaSalida(Date fechaSalida) { // Método setter que recibe la fecha de salida.
        this.fechaSalida = fechaSalida; // Asigna la fecha recibida al atributo fechaSalida.
    } 
    public String generarMensaje() { // Método que genera el mensaje solicitado por el enunciado.
        return "Ficha # " + ficha + " con cédula " + cedula + " abandona la cola sin ser atendido (a) a la fecha y hora " + fechaSalida + " por el siguiente motivo: " + motivo; 
    } 

} 