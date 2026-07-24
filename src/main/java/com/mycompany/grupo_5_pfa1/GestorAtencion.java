package com.mycompany.grupo_5_pfa1;

import javax.swing.JOptionPane;

/**
 * Gestiona la asignación de fichas y la atención de pacientes en el hospital.
 *
 * Administra dos colas: preferencial y regular, aplicando la regla de
 * prioridad: por cada paciente regular atendido se atienden dos preferenciales.
 *
 * @author Grupo 5
 * @version 2.0
 */
public class GestorAtencion {

    /**
     * Cola de pacientes con prioridad preferencial.
     */
    private ColaPacientes colaPreferencial;

    /**
     * Cola de pacientes sin prioridad.
     */
    private ColaPacientes colaRegular;

    /**
     * Cantidad de pacientes preferenciales atendidos consecutivamente.
     */
    private int contadorPreferenciales;

    /**
     * Contador de fichas regulares.
     */
    private int contadorFichaRegular;

    /**
     * Contador de fichas preferenciales.
     */
    private int contadorFichaPreferencial;

    /**
     * Contador global de fichas.
     */
    private int contadorFichaGlobal;

    /**
     * Indica si se usa secuencia única o separada.
     */
    private boolean secuenciaUnica;

    /**
     * Lista doble circular que almacena el expediente único de pacientes.
     */
    private ListaExpedientes listaExpedientes;

    /**
     * Lista simple que almacena la bitácora de citas atendidas durante el día.
     */
    private ListaBitacora listaBitacora;

    /**
     * Gestor encargado de procesar la información del expediente del paciente.
     */
    private GestorExpedientes gestorExpedientes;

    /**
     * Constructor principal de GestorAtencion.
     *
     * @param colaPreferencial Cola de pacientes preferenciales.
     * @param colaRegular Cola de pacientes regulares.
     */
    public GestorAtencion(ColaPacientes colaPreferencial, ColaPacientes colaRegular) {

        this.colaPreferencial = colaPreferencial;
        this.colaRegular = colaRegular;
        this.contadorPreferenciales = 0;
        this.contadorFichaRegular = 0;
        this.contadorFichaPreferencial = 0;
        this.contadorFichaGlobal = 0;
        this.secuenciaUnica = false;

        this.listaExpedientes = new ListaExpedientes();
        this.listaBitacora = new ListaBitacora();
        this.gestorExpedientes = new GestorExpedientes();
    }

    /**
     * Constructor que permite seleccionar el modo de numeración.
     *
     * @param colaPreferencial Cola de pacientes preferenciales.
     * @param colaRegular Cola de pacientes regulares.
     * @param secuenciaUnica true si se utiliza secuencia única.
     */
    public GestorAtencion(ColaPacientes colaPreferencial,
            ColaPacientes colaRegular,
            boolean secuenciaUnica) {

        this(colaPreferencial, colaRegular);
        this.secuenciaUnica = secuenciaUnica;
    }

    /**
     * Permite seleccionar una ficha para paciente regular o preferencial.
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
                opciones[0]);

        if (eleccion == JOptionPane.CLOSED_OPTION) {
            return;
        }

        char tipo = (eleccion == 0) ? 'R' : 'P';

        String cedula = JOptionPane.showInputDialog(null,
                "Ingrese el número de cédula del paciente:",
                "Seleccionar Ficha",
                JOptionPane.PLAIN_MESSAGE);

        if (cedula == null || cedula.trim().isEmpty()) {

            JOptionPane.showMessageDialog(null,
                    "Cédula inválida. Operación cancelada.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        String nombre = JOptionPane.showInputDialog(null,
                "Ingrese el nombre completo del paciente:",
                "Seleccionar Ficha",
                JOptionPane.PLAIN_MESSAGE);

        if (nombre == null || nombre.trim().isEmpty()) {

            JOptionPane.showMessageDialog(null,
                    "Nombre inválido. Operación cancelada.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        seleccionarFichaLogica(cedula.trim(), nombre.trim(), tipo);
    }

    /**
     * Genera la ficha del paciente y lo inserta en la cola correspondiente.
     *
     * @param cedula Cédula del paciente.
     * @param nombre Nombre completo del paciente.
     * @param tipo Tipo de ficha: R para regular, P para preferencial.
     * @return Paciente creado.
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

            JOptionPane.showMessageDialog(null,
                    "Su número de ficha es la: " + ficha,
                    "Ficha Asignada",
                    JOptionPane.INFORMATION_MESSAGE);

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

            JOptionPane.showMessageDialog(null,
                    "Su número de ficha es la: " + ficha,
                    "Ficha Asignada",
                    JOptionPane.INFORMATION_MESSAGE);

            return nuevoPaciente;

        } else {

            JOptionPane.showMessageDialog(null,
                    "Tipo de ficha inválido.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);

            return null;
        }
    }

    /**
     * Atiende al siguiente paciente aplicando la regla de prioridad: dos
     * pacientes preferenciales por un paciente regular.
     *
     * @return Paciente atendido o null si no hay pacientes en cola.
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

            JOptionPane.showMessageDialog(null,
                    "No hay pacientes pendientes por atender.",
                    "Atender Paciente",
                    JOptionPane.INFORMATION_MESSAGE);

            return null;
        }

        JOptionPane.showMessageDialog(null,
                "Ficha # " + pacienteAtendido.getFicha()
                + " con cédula " + pacienteAtendido.getCedula()
                + "\npasar a consulta médica.",
                "Atender Paciente",
                JOptionPane.INFORMATION_MESSAGE);

        gestorExpedientes.procesarAtencion(pacienteAtendido,
                listaExpedientes,
                listaBitacora);

        return pacienteAtendido;
    }

    /**
     * Muestra la bitácora de citas atendidas durante la sesión actual, tanto en
     * consola como en una ventana emergente. En la ventana se distingue
     * visualmente cada registro según su tiempo de espera:
     *
     * Verde: de 1 a 30 segundos. Amarillo: más de 30 segundos y menos de 1
     * minuto. Rojo: más de 1 minuto.
     *
     * @author Camila Cabrera
     */
    public void consultarBitacoraDelDia() {

        System.out.println("\n--- Bitácora de Citas del Día ---");
        System.out.println(listaBitacora.mostrarBitacora());

        JOptionPane.showMessageDialog(
                null,
                listaBitacora.mostrarBitacoraConColor(),
                "Bitácora de Citas del Día",
                JOptionPane.INFORMATION_MESSAGE);
    }

    /**
     * Retorna la lista de expedientes del sistema.
     *
     * @return Lista doble circular de expedientes.
     */
    public ListaExpedientes getListaExpedientes() {
        return listaExpedientes;
    }

    /**
     * Retorna la lista de bitácora del día.
     *
     * @return Lista simple de bitácora.
     */
    public ListaBitacora getListaBitacora() {
        return listaBitacora;
    }
}
