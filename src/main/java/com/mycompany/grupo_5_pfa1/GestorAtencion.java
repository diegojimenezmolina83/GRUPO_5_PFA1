package com.mycompany.grupo_5_pfa1;

import javax.swing.JOptionPane;

/**
 * Gestiona la asignación de fichas y la atención de pacientes en el hospital.
 * 
 * Administra dos colas —preferencial y regular— aplicando la regla de
 * prioridad: por cada paciente regular atendido se atienden dos preferenciales.
 * Soporta dos modos de numeración de fichas:
 * 
 * Secuencia separada (predeterminada): cada cola tiene su propio
 * contador ({@code R1, R2, ...} y {@code P1, P2, ...}).
 * Secuencia única: ambas colas comparten un único contador global
 *       ({@code R1, P2, R3, P4, ...}).
 *
 * @author Grupo 5
 * @version 1.0
 * @see ColaPacientes
 * @see Paciente
 */
public class GestorAtencion {

    /**
     * Cola de pacientes con prioridad preferencial.
     */
    private ColaPacientes colaPreferencial;

    /**
     * Cola de pacientes sin prioridad (regulares).
     */
    private ColaPacientes colaRegular;

    /**
     * Cantidad de pacientes preferenciales atendidos de forma consecutiva.
     * Se reinicia a 0 cada vez que se atiende un paciente regular.
     */
    private int contadorPreferenciales;

    /**
     * Número consecutivo del último ticket regular emitido (secuencia separada).
     */
    private int contadorFichaRegular;

    /**
     * Número consecutivo del último ticket preferencial emitido (secuencia separada).
     */
    private int contadorFichaPreferencial;

    /**
     * Número consecutivo global compartido entre ambas colas (secuencia única).
     */
    private int contadorFichaGlobal;

    /**
     * Indica el modo de numeración de fichas.
     * {@code true} para secuencia única compartida; {@code false} para secuencias separadas.
     */
    private boolean secuenciaUnica;

    /**
     * Construye un {@code GestorAtencion} con secuencias de numeración separadas
     * para la cola regular y la preferencial.
     *
     * @param colaPreferencial cola de pacientes preferenciales
     * @param colaRegular      cola de pacientes regulares
     */
    public GestorAtencion(ColaPacientes colaPreferencial, ColaPacientes colaRegular) {
        this.colaPreferencial = colaPreferencial;
        this.colaRegular = colaRegular;
        this.contadorPreferenciales = 0;
        this.contadorFichaRegular = 0;
        this.contadorFichaPreferencial = 0;
        this.contadorFichaGlobal = 0;
        this.secuenciaUnica = false;
    }

    /**
     * Construye un {@code GestorAtencion} permitiendo seleccionar el modo de
     * numeración de fichas.
     *
     * @param colaPreferencial cola de pacientes preferenciales
     * @param colaRegular      cola de pacientes regulares
     * @param secuenciaUnica   {@code true} para numeración global compartida;
     *                         {@code false} para numeración separada por tipo
     */
    public GestorAtencion(ColaPacientes colaPreferencial, ColaPacientes colaRegular, boolean secuenciaUnica) {
        this(colaPreferencial, colaRegular);
        this.secuenciaUnica = secuenciaUnica;
    }

    /**
     * Presenta al usuario un diálogo para seleccionar el tipo de paciente
     * (Regular o Preferencial), solicita la cédula y el nombre, y delega
     * la creación e inserción en cola a {@link #seleccionarFichaLogica(String, String, char)}.
     * 
     * La operación se cancela silenciosamente si el usuario cierra alguno de
     * los diálogos o deja la cédula o el nombre vacíos.
     * 
     */
    public void seleccionarFicha() {
        String[] opciones = {"Paciente Regular", "Paciente Preferencial"};
        int eleccion = JOptionPane.showOptionDialog(
            null,
            "Seleccione el tipo de paciente:",
            "Seleccionar Ficha",
            JOptionPane.DEFAULT_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            opciones,
            opciones[0]
        );

        if (eleccion == JOptionPane.CLOSED_OPTION) {
            return;
        }

        char tipo = (eleccion == 0) ? 'R' : 'P';

        String cedula = JOptionPane.showInputDialog(null, "Ingrese el número de cédula del paciente:",
            "Seleccionar Ficha", JOptionPane.PLAIN_MESSAGE);
        if (cedula == null || cedula.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Cédula inválida. Operación cancelada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre completo del paciente:",
            "Seleccionar Ficha", JOptionPane.PLAIN_MESSAGE);
        if (nombre == null || nombre.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nombre inválido. Operación cancelada.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        seleccionarFichaLogica(cedula.trim(), nombre.trim(), tipo);
    }

    /**
     * Genera el número de ficha según el tipo y el modo de secuencia configurado,
     * crea el {@link Paciente} con la fecha y hora actuales y lo inserta en la
     * cola correspondiente.
     * 
     * Reglas de numeración:
     * 
     * Secuencia separada — Regular: {@code R1, R2, R3, ...}
     * Secuencia separada — Preferencial: {@code P1, P2, P3, ...}
     * Secuencia única — compartida: {@code R1, P2, R3, P4, ...}
     *
     * @param cedula cédula de identidad del paciente
     * @param nombre nombre completo del paciente
     * @param tipo   tipo de ficha: {@code 'R'} o {@code 'r'} para regular;
     *               {@code 'P'} o {@code 'p'} para preferencial
     * @return {@link Paciente} creado e insertado en la cola, o {@code null}
     *         si el tipo no es válido
     */
    public Paciente seleccionarFichaLogica(String cedula, String nombre, char tipo) {
        String ficha;
        Paciente nuevoPaciente;

        if (tipo == 'R' || tipo == 'r') {
            if (secuenciaUnica) {
                contadorFichaGlobal++;
                ficha = "R" + contadorFichaGlobal;
            } else {
                contadorFichaRegular++;
                ficha = "R" + contadorFichaRegular;
            }
            nuevoPaciente = new Paciente(ficha, cedula, nombre, new java.util.Date());
            colaRegular.encolar(nuevoPaciente);
            JOptionPane.showMessageDialog(null, "Su número de ficha es la: " + ficha,
                "Ficha Asignada", JOptionPane.INFORMATION_MESSAGE);
            return nuevoPaciente;

        } else if (tipo == 'P' || tipo == 'p') {
            if (secuenciaUnica) {
                contadorFichaGlobal++;
                ficha = "P" + contadorFichaGlobal;
            } else {
                contadorFichaPreferencial++;
                ficha = "P" + contadorFichaPreferencial;
            }
            nuevoPaciente = new Paciente(ficha, cedula, nombre, new java.util.Date());
            colaPreferencial.encolar(nuevoPaciente);
            JOptionPane.showMessageDialog(null, "Su número de ficha es la: " + ficha,
                "Ficha Asignada", JOptionPane.INFORMATION_MESSAGE);
            return nuevoPaciente;

        } else {
            System.out.println("Tipo de ficha inválido.");
            return null;
        }
    }

    /**
     * Atiende al siguiente paciente aplicando la regla de prioridad
     * 2 preferenciales : 1 regular
     * 
     * Lógica de selección:
     * 
     *   Si ambas colas tienen pacientes y se han atendido menos de 2
     *   preferenciales consecutivos, se atiende el siguiente preferencial.
     *   Si ambas colas tienen pacientes y ya se atendieron 2 preferenciales
     *   consecutivos, se atiende el siguiente regular y se reinicia el contador.
     *   Si solo existe la cola preferencial con pacientes, se atiende desde ella.
     *   Si solo existe la cola regular con pacientes, se atiende desde ella.
     *   Si ambas colas están vacías, imprime un aviso y retorna {@code null}.
     *
     * @return {@link Paciente} atendido, o {@code null} si no hay pacientes en ninguna cola
     */
    public Paciente atenderPaciente() {
        Paciente pacienteAtendido = null;

        if (!colaPreferencial.esVacia() && !colaRegular.esVacia()) {
            if (contadorPreferenciales < 2) {
                pacienteAtendido = colaPreferencial.desencolar();
                contadorPreferenciales++;
            } else {
                pacienteAtendido = colaRegular.desencolar();
                contadorPreferenciales = 0;
            }
        } else if (!colaPreferencial.esVacia()) {
            pacienteAtendido = colaPreferencial.desencolar();
            contadorPreferenciales++;
        } else if (!colaRegular.esVacia()) {
            pacienteAtendido = colaRegular.desencolar();
            contadorPreferenciales = 0;
        } else {
            System.out.println("No hay pacientes pendientes por atender.");
            return null;
        }

        System.out.println("Ficha # " + pacienteAtendido.getFicha()
            + " con cédula " + pacienteAtendido.getCedula()
            + " pasar a consulta médica.");
        return pacienteAtendido;
    }
}
