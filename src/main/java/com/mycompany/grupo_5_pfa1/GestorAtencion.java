/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.grupo_5_pfa1;
import javax.swing.JOptionPane;

/**
 *
 * @author Grupo 5
 */

public class GestorAtencion { // Inicio de la clase GestorAtencion.
    private ColaPacientes colaPreferencial; // Guarda la cola de pacientes preferenciales.
    private ColaPacientes colaRegular; // Guarda la cola de pacientes regulares.
    private int contadorPreferenciales; // Cuenta cuántos pacientes preferenciales se atendieron de forma seguida.
    private int contadorFichaRegular; // Lleva el número consecutivo de fichas regulares asignadas.
    private int contadorFichaPreferencial; // Lleva el número consecutivo de fichas preferenciales asignadas.
    private int contadorFichaGlobal; // Lleva el número consecutivo global cuando se usa secuencia única.
    private boolean secuenciaUnica; // Indica si R y P comparten un único contador (true) o cuentan por separado (false).

    public GestorAtencion(ColaPacientes colaPreferencial, ColaPacientes colaRegular) { // Constructor con secuencia separada por defecto.
        this.colaPreferencial = colaPreferencial; // Asigna la cola preferencial recibida al atributo colaPreferencial.
        this.colaRegular = colaRegular; // Asigna la cola regular recibida al atributo colaRegular.
        this.contadorPreferenciales = 0; // Inicializa el contador de preferenciales en cero.
        this.contadorFichaRegular = 0; // Inicializa el contador de fichas regulares en cero.
        this.contadorFichaPreferencial = 0; // Inicializa el contador de fichas preferenciales en cero.
        this.contadorFichaGlobal = 0; // Inicializa el contador global en cero.
        this.secuenciaUnica = false; // Por defecto usa secuencia separada (R1,R2... / P1,P2...).
    }

    public GestorAtencion(ColaPacientes colaPreferencial, ColaPacientes colaRegular, boolean secuenciaUnica) { // Constructor que permite elegir tipo de secuencia.
        this(colaPreferencial, colaRegular); // Llama al constructor base.
        this.secuenciaUnica = secuenciaUnica; // Asigna el tipo de secuencia indicado.
    }

    /**
     * Muestra el submenú de tipo de paciente, solicita cédula y nombre,
     * genera la ficha consecutiva según la secuencia configurada e inserta
     * el paciente en la cola correcta.
     * @param JOptionPane JOptionPane activo para leer la entrada del usuario.
     */
    public void seleccionarFicha() { // Inicio del método interactivo seleccionarFicha con JOptionPane.
        String[] opciones = {"Paciente Regular", "Paciente Preferencial"}; // Opciones del diálogo.
        int eleccion; // Variable que almacenará la elección del usuario.
        do { // Repite hasta que el usuario seleccione una opción válida.
            eleccion = JOptionPane.showOptionDialog( // Muestra el diálogo de selección de tipo.
                null,
                "Seleccione el tipo de paciente:",
                "Seleccionar Ficha",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                opciones,
                opciones[0]
            );
            if (eleccion == JOptionPane.CLOSED_OPTION) { // Valida si el usuario cerró el diálogo sin seleccionar.
                JOptionPane.showMessageDialog(null, "Debe seleccionar un tipo de paciente.", "Advertencia", JOptionPane.WARNING_MESSAGE); // Muestra advertencia.
            }
        } while (eleccion == JOptionPane.CLOSED_OPTION); // Repite si no se seleccionó ninguna opción.

        char tipo = (eleccion == 0) ? 'R' : 'P'; // Asigna 'R' si eligió Regular, 'P' si eligió Preferencial.

        String cedula; // Variable que almacenará la cédula ingresada.
        do { // Repite hasta que la cédula sea válida.
            cedula = JOptionPane.showInputDialog(null, "Ingrese el número de cédula del paciente:", "Seleccionar Ficha", JOptionPane.PLAIN_MESSAGE); // Solicita la cédula.
            if (cedula == null || cedula.trim().isEmpty()) { // Valida si la cédula está vacía o se canceló.
                JOptionPane.showMessageDialog(null, "La cédula no puede estar vacía. Intente de nuevo.", "Advertencia", JOptionPane.WARNING_MESSAGE); // Muestra advertencia.
            }
        } while (cedula == null || cedula.trim().isEmpty()); // Repite si la cédula no es válida.

        String nombre; // Variable que almacenará el nombre ingresado.
        do { // Repite hasta que el nombre sea válido.
            nombre = JOptionPane.showInputDialog(null, "Ingrese el nombre completo del paciente:", "Seleccionar Ficha", JOptionPane.PLAIN_MESSAGE); // Solicita el nombre.
            if (nombre == null || nombre.trim().isEmpty()) { // Valida si el nombre está vacío o se canceló.
                JOptionPane.showMessageDialog(null, "El nombre no puede estar vacío. Intente de nuevo.", "Advertencia", JOptionPane.WARNING_MESSAGE); // Muestra advertencia.
            }
        } while (nombre == null || nombre.trim().isEmpty()); // Repite si el nombre no es válido.

        seleccionarFichaLogica(cedula.trim(), nombre.trim(), tipo); // Delega la lógica de generación e inserción.
    }

    /**
     * Genera la ficha, crea el paciente y lo inserta en la cola correspondiente.
     * Secuencia separada (defecto): R → R1, R2, R3... / P → P1, P2, P3...
     * Secuencia única:              compartida → R1, P2, R3, P4...
     * @param cedula Cédula del paciente.
     * @param nombre Nombre del paciente.
     * @param tipo   Tipo de ficha: 'R' para regular, 'P' para preferencial.
     * @return Paciente creado e insertado, o null si el tipo es inválido.
     */
    public Paciente seleccionarFichaLogica(String cedula, String nombre, char tipo) { // Inicio del método de lógica de seleccionarFicha.
        String ficha; // Variable que almacenará el código de ficha generado.
        Paciente nuevoPaciente; // Variable que almacenará el paciente creado.

        if (tipo == 'R' || tipo == 'r') { // Valida si el tipo ingresado es regular.
            if (secuenciaUnica) { // Valida si se usa secuencia única compartida.
                contadorFichaGlobal++; // Incrementa el contador global.
                ficha = "R" + contadorFichaGlobal; // Genera ficha con número global.
            } else { // Si usa secuencia separada.
                contadorFichaRegular++; // Incrementa el contador exclusivo de regulares.
                ficha = "R" + contadorFichaRegular; // Genera ficha con número de regulares.
            }
            nuevoPaciente = new Paciente(ficha, cedula, nombre, new java.util.Date()); // Crea el paciente con la ficha generada y timestamp actual.
            colaRegular.encolar(nuevoPaciente); // Inserta el paciente en la cola regular.
            JOptionPane.showMessageDialog(null, "Su número de ficha es la: " + ficha, "Ficha Asignada", JOptionPane.INFORMATION_MESSAGE); // Muestra la ficha asignada.
            return nuevoPaciente; // Retorna el paciente insertado.

        } else if (tipo == 'P' || tipo == 'p') { // Valida si el tipo ingresado es preferencial.
            if (secuenciaUnica) { // Valida si se usa secuencia única compartida.
                contadorFichaGlobal++; // Incrementa el contador global.
                ficha = "P" + contadorFichaGlobal; // Genera ficha con número global.
            } else { // Si usa secuencia separada.
                contadorFichaPreferencial++; // Incrementa el contador exclusivo de preferenciales.
                ficha = "P" + contadorFichaPreferencial; // Genera ficha con número de preferenciales.
            }
            nuevoPaciente = new Paciente(ficha, cedula, nombre, new java.util.Date()); // Crea el paciente con la ficha generada y timestamp actual.
            colaPreferencial.encolar(nuevoPaciente); // Inserta el paciente en la cola preferencial.
            JOptionPane.showMessageDialog(null, "Su número de ficha es la: " + ficha, "Ficha Asignada", JOptionPane.INFORMATION_MESSAGE); // Muestra la ficha asignada.
            return nuevoPaciente; // Retorna el paciente insertado.

        } else { // Si el tipo ingresado no es válido.
            System.out.println("Tipo de ficha inválido."); // Muestra mensaje de error.
            return null; // Retorna null porque no se pudo crear el paciente.
        }
    }

    public Paciente atenderPaciente() { // Método que atiende un paciente según la regla 2 preferenciales y 1 regular.
        Paciente pacienteAtendido = null; // Variable donde se guardará el paciente que será atendido.
        if (!colaPreferencial.esVacia() && !colaRegular.esVacia()) { // Valida si ambas colas tienen pacientes.
            if (contadorPreferenciales < 2) { // Valida si todavía no se han atendido 2 preferenciales seguidos.
                pacienteAtendido = colaPreferencial.desencolar(); // Saca el primer paciente de la cola preferencial.
                contadorPreferenciales++; // Aumenta el contador de pacientes preferenciales atendidos.
            } 
   
            else { // Si ya se atendieron 2 pacientes preferenciales seguidos.
                pacienteAtendido = colaRegular.desencolar(); // Saca el primer paciente de la cola regular.
                contadorPreferenciales = 0; // Reinicia el contador de preferenciales.
            } 
        } 
       
        else if (!colaPreferencial.esVacia()) { // Valida si solo hay pacientes preferenciales.
            pacienteAtendido = colaPreferencial.desencolar(); // Saca el primer paciente preferencial.
            contadorPreferenciales++; // Aumenta el contador de preferenciales.
        } 
        
        else if (!colaRegular.esVacia()) { // Valida si solo hay pacientes regulares.
            pacienteAtendido = colaRegular.desencolar(); // Saca el primer paciente regular.
            contadorPreferenciales = 0; // Reinicia el contador de preferenciales.
        } 
        
        else { // Si no hay pacientes en ninguna cola.
            System.out.println("No hay pacientes pendientes por atender."); // Muestra mensaje si ambas colas están vacías.
            return null; // Retorna null porque no hay paciente para atender.
        } 

        System.out.println("Ficha # " + pacienteAtendido.getFicha() + " con cédula " + pacienteAtendido.getCedula() + " pasar a consulta médica."); 
        return pacienteAtendido; // Retorna el paciente que fue atendido.
    } 

} 