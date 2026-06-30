package com.mycompany.grupo_5_pfa1;

import java.util.Date;
import javax.swing.JOptionPane;

/**
 * Pila especializada para registrar las quejas de pacientes que abandonan
 * la cola sin ser atendidos.
 * 
 * Extiende {@link PilaBase} añadiendo la lógica de negocio necesaria para
 * retirar a un paciente de una {@link ColaBase} y generar automáticamente
 * la {@link Queja} correspondiente.
 *
 * @author Grupo 5
 * @version 1.0
 * @see PilaBase
 * @see ColaBase
 * @see Queja
 */
public class PilaQuejas extends PilaBase {

    /**
     * Construye una pila de quejas vacía invocando al constructor de
     * {@link PilaBase}.
     */
    public PilaQuejas() {
        super();
    }

    /**
     * Retira el paciente con la ficha indicada de la cola especificada y
     * registra una queja en la pila con el motivo proporcionado.
     * 
     * Si la ficha no se encuentra en la cola, no se apila ninguna queja y
     * el método retorna {@code false}.
     *
     * @param cola   cola (regular o preferencial) de la que se retirará el paciente
     * @param ficha  número de ficha del paciente que abandona la cola
     * @param motivo motivo declarado por el paciente al abandonar
     * @return {@code true} si el paciente fue encontrado, retirado y la queja
     *         apilada exitosamente; {@code false} si la ficha no existe en la cola
     */
    public boolean abandonarCola(ColaBase cola, String ficha, String motivo) {
        Paciente pacienteEliminado = cola.eliminarPorFicha(ficha);
        if (pacienteEliminado == null) {
            return false;
        }
        Queja queja = new Queja(
            pacienteEliminado.getFicha(),
            pacienteEliminado.getCedula(),
            motivo,
            new Date()
        );
        apilar(queja);
        return true;
    }

    /**
     * Solicita al usuario la ficha y el motivo de abandono mediante diálogos
     * {@code JOptionPane}, e intenta retirar al paciente primero de la cola
     * regular y, si no se encuentra, de la cola preferencial.
     * 
     * Muestra un mensaje de error si la ficha no se encontró en ninguna de
     * las dos colas. La operación se cancela silenciosamente si el usuario
     * cierra cualquiera de los diálogos o deja los campos vacíos.
     *
     * @param colaRegular      cola de pacientes regulares
     * @param colaPreferencial cola de pacientes preferenciales
     */
    public void abandonarColaInteractivo(ColaPacientes colaRegular, ColaPacientes colaPreferencial) {
        String ficha = JOptionPane.showInputDialog(null, "Ingrese el número de ficha a retirar:",
            "Abandonar Cola", JOptionPane.PLAIN_MESSAGE);
        if (ficha == null || ficha.trim().isEmpty()) return;

        String motivo = JOptionPane.showInputDialog(null, "Ingrese el motivo de salida:",
            "Abandonar Cola", JOptionPane.PLAIN_MESSAGE);
        if (motivo == null || motivo.trim().isEmpty()) return;

        boolean exito = abandonarCola(colaRegular, ficha.trim(), motivo.trim());
        if (!exito) {
            exito = abandonarCola(colaPreferencial, ficha.trim(), motivo.trim());
        }
        if (!exito) {
            JOptionPane.showMessageDialog(null, "No se encontró la ficha indicada.",
                "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
