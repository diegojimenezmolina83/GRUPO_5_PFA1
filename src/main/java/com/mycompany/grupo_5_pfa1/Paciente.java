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

public class Paciente { // Inicio de la clase Paciente.

    // Sección de atributos.
    private String ficha; // Guarda el número de ficha del paciente, por ejemplo R1 o P1.
    private String cedula; // Guarda el número de cédula del paciente.
    private String nombre; // Guarda el nombre completo del paciente.
    private Date fechaLlegada; // Guarda la fecha y hora en que el paciente llegó.

    // Sección de constructores.
    public Paciente() { // Constructor vacío de la clase Paciente.
    } 
    public Paciente(String ficha, String cedula, String nombre, Date fechaLlegada) { // Constructor con parámetros.
        this.ficha = ficha; // Asigna el valor recibido al atributo ficha.
        this.cedula = cedula; // Asigna el valor recibido al atributo cedula.
        this.nombre = nombre; // Asigna el valor recibido al atributo nombre.
        this.fechaLlegada = fechaLlegada; // Asigna el valor recibido al atributo fechaLlegada.
    } 

    // Sección de getter y setter.
    public String getFicha() { // Método getter que retorna la ficha.
        return ficha; // Retorna la ficha del paciente.
    } 

    public void setFicha(String ficha) { // Método setter que recibe la ficha.
        this.ficha = ficha; // Asigna la ficha recibida al atributo ficha.
    } 

    public String getCedula() { // Método getter que retorna la cédula.
        return cedula; // Retorna la cédula del paciente.
    } 

    public void setCedula(String cedula) { // Método setter que recibe la cédula.
        this.cedula = cedula; // Asigna la cédula recibida al atributo cedula.
    } 

    public String getNombre() { // Método getter que retorna el nombre.
        return nombre; // Retorna el nombre del paciente.
    } 

    public void setNombre(String nombre) { // Método setter que recibe el nombre.
        this.nombre = nombre; // Asigna el nombre recibido al atributo nombre.
    } 

    public Date getFechaLlegada() { // Método getter que retorna la fecha de llegada.
        return fechaLlegada; // Retorna la fecha y hora de llegada.
    } 

    public void setFechaLlegada(Date fechaLlegada) { // Método setter que recibe la fecha de llegada.
        this.fechaLlegada = fechaLlegada; // Asigna la fecha recibida al atributo fechaLlegada.
    } 

} 